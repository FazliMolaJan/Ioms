package com.hy.ioms;

import com.hy.ioms.model.dto.UserDTO;
import com.hy.ioms.model.net.IomsApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wsw on 2017/8/8.
 */
public class LoginTest {
    IomsApi iomsApi;

    @Before
    public void setUp() {
        iomsApi = MockRetrofit.getInstance();
    }

    @Test
    public void login() throws Exception {
        iomsApi.getAuthenticate()
                .andThen(iomsApi.login("admin", "admin", true))
                .andThen(iomsApi.getAccount())
                .subscribe(new Consumer<UserDTO>() {
                    @Override
                    public void accept(@NonNull UserDTO userDTO) throws Exception {
                        System.out.println(userDTO);
                    }
                })
        ;
    }
}
