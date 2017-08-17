package vm;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.utils.rx.RxJavaUtils;
import com.hy.ioms.view.IView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * ${description}
 * Created by wsw on 2017/8/12.
 */

public abstract class BasePageDataViewModel<T, S> extends BaseObservable implements IBaseDataViewModel {
    //当前状态
    public ObservableInt currentState = new ObservableInt(IView.IDLE);
    public ObservableBoolean dataLoading = new ObservableBoolean(false);
    public ObservableBoolean dataRefresh = new ObservableBoolean(false);
    public ObservableList<S> datas = new ObservableArrayList<>();
    public PagingParams pagingParams;

    /**
     * 加载分页数据
     *
     * @param pageSingle         分页数据的single
     * @param baseSingleObserver 对数据进行处理
     */
    public void loadPageData(Single<Page<T>> pageSingle, BaseSingleObserver<List<S>> baseSingleObserver) {
        pageSingle.doOnSubscribe(disposable -> doOnSubscribe())
                .doOnSuccess(page -> pagingParams.totalCount = page.getTotalNumber())
                .map(Page::getContent)
                .toObservable()
                .flatMap(Observable::fromIterable)
                .doOnNext(this::beforeTransformSingleData)
                .map(this::transform)
                .toList()
                .doAfterSuccess(ses -> doAfterSuccess())
                .doOnError(throwable -> {
                    currentState.set(IView.IDLE);
                    dataLoading.set(false);
                    dataRefresh.set(false);
                })
                .compose(RxJavaUtils.single_io_main())
                .subscribe(baseSingleObserver);
    }

    /**
     * 数据转换
     *
     * @param t 将数据从 t转换为 S
     * @return S
     */
    public abstract S transform(T t);

    /**
     * 在数据绑定时
     */
    private void doOnSubscribe() {
        switch (getCurrentState()) {
            case IView.REFRESHING:
                beforeRefresh();
                break;
            case IView.LOADING:
                beforeLoadMore();
                break;
            default:
                break;
        }
    }

    /**
     * 在获取数据成功后
     */
    private void doAfterSuccess() {
        switch (getCurrentState()) {
            case IView.REFRESHING:
                afterRefresh();
                break;
            case IView.LOADING:
                afterLoadMore();
                break;
            default:
                break;
        }
        currentState.set(IView.IDLE);
    }

    public void beforeLoadMore() {
        dataLoading.set(true);
    }

    public void beforeRefresh() {
        dataRefresh.set(true);
    }

    public void afterLoadMore() {
        pagingParams.currentPage += 1;
        pagingParams.queryPage += 1;
        dataLoading.set(false);
    }

    public void afterRefresh() {
        datas.clear();
        pagingParams.currentPage = Config.DEFAULT_PAGE;
        pagingParams.queryPage = Config.DEFAULT_QUERY_PAGE;
        dataRefresh.set(false);
    }

    public int getCurrentState() {
        return this.currentState.get();
    }

    /**
     * 获取到单个数据,对单个数据进行处理
     */
    public void beforeTransformSingleData(@NonNull T t) {
    }

    /**
     * 主要用於data binding中的數據綁定
     */
    public ObservableList getDatas() {
        return this.datas;
    }
}