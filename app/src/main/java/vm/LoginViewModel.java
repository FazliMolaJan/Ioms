package vm;

import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.util.Log;
import android.widget.Toast;

import com.hy.ioms.model.interaction.UserInteraction;
import com.hy.ioms.utils.rx.BaseCompletableObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;
import com.hy.ioms.view.main.MainActivity;

import io.reactivex.annotations.NonNull;

import static com.hy.ioms.Config.SP_ACCOUNT;
import static com.hy.ioms.Config.SP_PASSWORD;

/**
 * 登陆 ViewModel
 * Created by wsw on 2017/6/12.
 */
public class LoginViewModel extends BaseObservable {

    private UserInteraction userInteraction;
    private SharedPreferences netSharedPreferences;
    private SharedPreferences normalSharedPreferences;
    private IView view;

    public ObservableBoolean isLogin = new ObservableBoolean(false);

    public LoginViewModel(UserInteraction userInteraction, SharedPreferences netSharedPreferences,
                          SharedPreferences normalSharedPreferences, IView view) {
        this.userInteraction = userInteraction;
        this.netSharedPreferences = netSharedPreferences;
        this.normalSharedPreferences = normalSharedPreferences;
        this.view = view;
    }

    /**
     * 登陆
     *
     * @param userViewModel 用户 ViewModel
     */
    // TODO: 2017/6/13 这里登陆可以先尝试登陆,发现过期再调用getAuthenticate,等有空了再来修改
    public void login(UserViewModel userViewModel) {
        Log.d("tag","測試debug信息");
        isLogin.set(true);
        netSharedPreferences.edit().clear().apply(); //主要是为了清除sharedPreferences中的csrfToken和cookie

        userInteraction.login(userViewModel.account.get(), userViewModel.password.get())
                .compose(RxJavaUtils.completable_io_main())//切换线程
                .compose(view.bindLifecycle())
                .doFinally(() -> isLogin.set(false))
                .subscribe(new BaseCompletableObserver(view.getContext()) {
                    @Override
                    public void onComplete() {
                        SharedPreferences.Editor editor = normalSharedPreferences.edit();
                        editor.putString(SP_ACCOUNT, userViewModel.account.get());
                        editor.putString(SP_PASSWORD, userViewModel.password.get());
                        editor.apply();
                        MainActivity.gotoActivity(view.getContext());
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Toast.makeText(view.getContext(), "登录失败,请检查", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
