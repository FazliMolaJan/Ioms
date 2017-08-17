package com.hy.ioms.model.repository;

import com.hy.ioms.model.dto.UserDTO;
import com.hy.ioms.model.net.IomsApi;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * 用户数据仓库
 * Created by wsw on 2017/8/9.
 */

public class UserRepository {

    private IomsApi iomsApi;

    @Inject
    public UserRepository(IomsApi iomsApi) {
        this.iomsApi = iomsApi;
    }

    /**
     * 登陆
     *
     * @param account  账号
     * @param password 密码
     * @return 是否成功
     */
    public Completable login(String account, String password) {
        return iomsApi.getAuthenticate()
                .andThen(iomsApi.login(account, password, true));
    }

    /**
     * 获取账户信息
     *
     * @return @{@link UserDTO}
     */
    public Single<UserDTO> getAccount() {
        return iomsApi.getAccount();
    }

}
