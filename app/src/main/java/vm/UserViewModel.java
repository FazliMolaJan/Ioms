package vm;

import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.hy.ioms.BuildConfig;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import static com.hy.ioms.Config.SP_ACCOUNT;
import static com.hy.ioms.Config.SP_PASSWORD;

/**
 * Create By :wsw
 * 2016-08-30 10:12
 */

public class UserViewModel extends BaseObservable implements Serializable {

    private SharedPreferences sharedPreferences;

    @Inject
    public UserViewModel(@Named("normal") SharedPreferences normalSharedPreferences) {
        this.sharedPreferences = normalSharedPreferences;
    }

    public ObservableField<String> account = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    /**
     * 获取user
     */
    public void getUser() {
        if (BuildConfig.DEBUG) {
            account.set("admin");
            password.set("Hyweb4.0");
        } else {
            account.set(sharedPreferences.getString(SP_ACCOUNT, ""));
            password.set(sharedPreferences.getString(SP_PASSWORD, ""));
        }
    }

}
