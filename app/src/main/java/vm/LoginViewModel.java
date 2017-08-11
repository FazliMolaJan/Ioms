package vm;

import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

import com.hy.ioms.model.interaction.UserInteraction;
import com.hy.ioms.view.IView;

import javax.inject.Named;

/**
 * 登陆 ViewModel
 * Created by wsw on 2017/6/12.
 */
public class LoginViewModel extends BaseObservable {

    private UserInteraction userInteraction;
    private SharedPreferences sharedPreferences;
    private IView view;

    public ObservableBoolean isLogin = new ObservableBoolean(false);

    public LoginViewModel(UserInteraction userInteraction,
                          SharedPreferences sharedPreferences, IView view) {
        this.userInteraction = userInteraction;
        this.sharedPreferences = sharedPreferences;
        this.view = view;
    }

    /**
     * 登陆
     *
     * @param userViewModel 用户 ViewModel
     */
    // TODO: 2017/6/13 这里登陆可以先尝试登陆,发现过期再调用getAuthenticate,等有空了再来修改
    public void login(UserViewModel userViewModel) {
        isLogin.set(true);
        sharedPreferences.edit().clear().apply(); //主要是为了清除sharedPreferences中的csrfToken和cookie
//        monitorApi.getAuthenticate()//获取验证
//                .doOnError(throwable -> Timber.e(throwable, "getAuthenticate: "))
//                .andThen(monitorApi.login(userViewModel.account.get()
//                        , userViewModel.password.get(), LOGIN_REMEMBER_DEFAULT))//登陆
//                .andThen(monitorApi.getAccount())//获取当前账号信息
//                .doOnSuccess(userDTO -> {
//                    //保存用户输入的账号信息
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString(SP_ACCOUNT, userViewModel.account.get());
//                    editor.putString(SP_PASSWORD, userViewModel.password.get());
//                    editor.apply();
//                })
//                .compose(RxJavaUtils.single_io_main())//切换线程
//                //与当前activity的生命周期绑定
//                .compose(view.bindLifecycle())
//                .doFinally(() -> isLogin.set(false))
//                .subscribe(new BaseSingleObserver<UserDTO>(view.getContext()) {
//                    @Override
//                    public void onSuccess(UserDTO userDTO) {
//                        //成功后跳转到DeviceListActivity
////                        DeviceListActivity.gotoActivity(view.getContext());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(view.getContext(), "登陆失败", Toast.LENGTH_SHORT).show();
//                    }
//                });

    }
}
