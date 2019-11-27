package mobileshop.edu.huatec.com.mobileshop2.activity;

import android.text.TextUtils;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop2.http.ProgressDialogSubscriber;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.MemberEntity;
import mobileshop.edu.huatec.com.mobileshop2.http.presenter.MemberPresenter;
import mobileshop.edu.huatec.com.mobileshop2.utils.SystemCofig;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_uaername)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etpwd;    //密码输入框
    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }

    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etpwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)){
            toastShort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemCofig.setLogin(true);
                toastShort("登录成功");

                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);

                setResult(RESULT_OK);
                finish();
            }
        },userName,pwd);

    }


}

