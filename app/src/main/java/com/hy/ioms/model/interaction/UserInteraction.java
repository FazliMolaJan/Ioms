package com.hy.ioms.model.interaction;

import io.reactivex.Completable;

/**
 * 用户操作交互器
 * Created by wsw on 2017/8/9.
 */

public interface UserInteraction {
    Completable login(String account, String password);
}
