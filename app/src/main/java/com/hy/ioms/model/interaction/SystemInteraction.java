package com.hy.ioms.model.interaction;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * 系统的交互
 * Created by wsw on 2017/8/10.
 */
@SuppressWarnings("unused")
public interface SystemInteraction {
    /**
     * 获取系统当前版本号
     */
    Single<Integer> getCurrentVersion();

    /**
     * 获取服务器最新版本号
     */
    Single<Integer> getLastVersion();

    /**
     * 获取当前服务器地址
     */
    Single<String> getCurrentServerAddress();

    /**
     * 设置服务器地址
     */
    Completable setServerAddress();


}
