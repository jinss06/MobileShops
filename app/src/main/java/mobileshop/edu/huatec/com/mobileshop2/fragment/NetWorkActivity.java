package mobileshop.edu.huatec.com.mobileshop2.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import mobileshop.edu.huatec.com.mobileshop2.R;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetWorkActivity extends AppCompatActivity implements View.OnClickListener {
    Handler handler = new Handler();
    private TextView tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_network);

        tv_result = (TextView)findViewById(R.id.tv_result);
        findViewById(R.id.bt_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_request:
                httpRequest("444","444");
                break;
        }
    }

    private void httpRequest(final String username,final String password){
        new Thread(){
            @Override
            public void run(){
                super.run();
                OkHttpClient client = new OkHttpClient();
                FormBody body = new FormBody.Builder()
                        .add("input",username)
                        .add("password",password)
                        .build();
                Request request = new Request.Builder()
                        .url("http://10.216.49.81:8080/MobileShop/member/login2")
                        .post(body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    Gson gson = new Gson();
                    final MemberResult memberResult = gson.fromJson(result,MemberResult.class);
                    handler.post(new Runnable(){
                        @Override
                        public void run(){
                            if(memberResult !=null &&memberResult.data!=null){
                                tv_result.setText(
                                        String.format("用户名：%s\n邮箱：%s"
                                        ,memberResult.data.uname
                                        ,memberResult.data.email));
                            }
                        }
                    });
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
