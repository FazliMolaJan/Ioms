package com.hy.ioms.model.interactor;

import io.reactivex.Completable;

/**
 * 用户操作交互器
 * Created by wsw on 2017/8/9.
 */

public interface UserInteractor {
    Completable login(String account, String password);
}
