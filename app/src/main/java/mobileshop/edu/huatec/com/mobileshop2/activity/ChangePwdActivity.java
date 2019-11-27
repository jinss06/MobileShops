package mobileshop.edu.huatec.com.mobileshop2.activity;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;

public class ChangePwdActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId(){return R.layout.activity_change_pwd;}

    @Override
    protected void initView(){
        super.initView();
        tvTitle.setText("修改密码");
    }
    @OnClick(R.id.iv_back)
    void close(){finish();}
}
