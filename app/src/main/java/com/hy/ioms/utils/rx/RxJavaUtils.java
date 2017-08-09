package com.hy.ioms.utils.rx;


import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * rxJava 工具类
 * Created by Administrator on 2017/3/1.
 */

public class RxJavaUtils {
    /**
     * rxJava线程切换 observable newThread -> main
     */
    public static <T> ObservableTransformer<T, T> observable_new_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * rxJava线程切换 observable io -> main
     */
    public static <T> ObservableTransformer<T, T> observable_io_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * rxJava线程切换 flowable io -> main
     */
    public static <T> FlowableTransformer<T, T> flowable_io_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * rxJava线程切换 flowable newThread -> main
     */
    public static <T> FlowableTransformer<T, T> flowable_new_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * rxJava线程切换 single io -> main
     */
    public static <T> SingleTransformer<T, T> single_io_main() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> SingleTransformer<Response<T>, T> sTransformer() {
        return responseObservable -> responseObservable.map(tResponse -> {
            if (!tResponse.isSuccessful()) throw new RuntimeException("" + tResponse.code());
            return tResponse.body();
        }).onErrorResumeNext(new HttpResponseFunc<>());
    }

    /**
     * 错误的Http统一处理
     */
    private static class HttpResponseFunc<T> implements Function<Throwable, Single<T>> {
        @Override
        public Single<T> apply(Throwable throwable) throws Exception {
            //ExceptionEngine为处理异常的驱动器
            return Single.error(new Throwable(throwable));
        }
    }

    /**
     * 获取到图片totalCount
     */
    public static <T> FlowableTransformer<Response<List<T>>, T> single_page(PagingParams pagingParams) {
        return (Flowable<Response<List<T>>> upstream) -> upstream.doOnNext(listResponse -> {
            String totalCount = listResponse.headers().get("X-Total-Count");
            pagingParams.totalCount = Integer.parseInt(totalCount);
        }).flatMap((Response<List<T>> listResponse) -> Flowable.fromIterable(listResponse.body()));
    }

    /**
     * 对page对象进行处理
     */
    public static <T> SingleTransformer<Page<Mapper<T>>, Page<T>> single_page_transform() {
        Page<T> page = new Page<>();
        return upstream -> upstream.doAfterSuccess(page::synchronize)
                .map(Page::getContent)
                .map(mappers -> {
                    List<T> list = new ArrayList<>();
                    for (Mapper<T> mapper : mappers) {
                        list.add(mapper.transform());
                    }
                    return list;
                })
                .map((Function<List<T>, Page<T>>) list -> {
                    page.setContent(list);
                    return page;
                });
    }
}
