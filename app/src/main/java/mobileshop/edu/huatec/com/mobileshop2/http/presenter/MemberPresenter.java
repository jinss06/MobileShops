package mobileshop.edu.huatec.com.mobileshop2.http.presenter;

import mobileshop.edu.huatec.com.mobileshop2.http.HttpMethods;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.MemberEntity;
import rx.Observable;
import rx.Subscriber;


public class MemberPresenter extends HttpMethods {
    //用户注册
    public static void register(Subscriber<MemberEntity> subscriber, String username, String emial, String password){
        Observable observable = memberService.register(username,password,emial)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    //用户登陆
    public static void login(Subscriber<MemberEntity> subscriber,String username,String password){
        Observable observable = memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    //修改密码
    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable = memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable,subscriber);
    }
}
