package mobileshop.edu.huatec.com.mobileshop2.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop2.fragment.NavigationFragment;


public class MainActivity extends BaseActivity {
    public int getContentViewId(){
        return R.layout.activity_main;
    }
    protected void initView(){
        super.initView();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }

}
