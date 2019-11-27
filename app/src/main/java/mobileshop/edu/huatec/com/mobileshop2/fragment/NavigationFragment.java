package mobileshop.edu.huatec.com.mobileshop2.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.common.BaseFragment;

public class NavigationFragment extends BaseFragment implements View.OnClickListener{

    private ImageButton mIbHome;
    private ImageButton mIbCategory;
    private ImageButton mIbCart;
    private ImageButton mIbPersonal;
    private HomeFragment homeFragment;
    private CategroyFragment categroyFragment;
    private CatFragment catFragment;
    private PersonalFragment personalFragment;

    public int getContentViewId(){
        return R.layout.fragment_navigation;
    }

    protected void initView(View view){
        super.initView(view);
        mIbHome = view.findViewById(R.id.ib_home);
        mIbCategory = view.findViewById(R.id.ib_category);
        mIbCart = view.findViewById(R.id.ib_cart);
        mIbPersonal = view.findViewById(R.id.ib_personal);
        //设置监听
        mIbHome.setOnClickListener(this);
        mIbCategory.setOnClickListener(this);
        mIbCart.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);

        select(mIbHome);
    }
    private void select(View v){
        mIbHome.setImageResource(R.drawable.tab_item_home_normal);
        mIbCategory.setImageResource(R.drawable.tab_item_category_normal);
        mIbCart.setImageResource(R.drawable.tab_item_cart_normal);
        mIbPersonal.setImageResource(R.drawable.tab_item_personal_normal);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if(categroyFragment!=null){
            fragmentTransaction.hide(categroyFragment);
        }
        if(catFragment!=null){
            fragmentTransaction.hide(catFragment);
        }
        if(personalFragment!=null){
            fragmentTransaction.hide(personalFragment);
        }
        switch (v.getId()){
            case R.id.ib_home:
                mIbHome.setImageResource(R.drawable.tab_item_home_focus);
                if (homeFragment == null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,homeFragment);
                }else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.ib_category:
                mIbCategory.setImageResource(R.drawable.tab_item_category_focus);
                if (categroyFragment==null){
                    categroyFragment=new CategroyFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,categroyFragment);
                }else {
                    fragmentTransaction.show(categroyFragment);
                }
                break;
            case R.id.ib_cart:
                mIbCart.setImageResource(R.drawable.tab_item_cart_focus);
                if (catFragment==null){
                    catFragment=new CatFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,catFragment);
                }else {
                    fragmentTransaction.show(catFragment);
                }
                break;
            case R.id.ib_personal:
                mIbPersonal.setImageResource(R.drawable.tab_item_personal_focus);
                if (personalFragment==null){
                    personalFragment=new PersonalFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,personalFragment);
                }else {
                    fragmentTransaction.show(personalFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
    public void onClick(View v){
        select(v);
    }
}
