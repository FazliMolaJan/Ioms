package vm;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.hy.ioms.Config;
import com.hy.ioms.model.Page;
import com.hy.ioms.model.PagingParams;
import com.hy.ioms.utils.rx.BaseSingleObserver;
import com.hy.ioms.view.IView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * ${description}
 * Created by wsw on 2017/8/12.
 */

public abstract class BasePageDataViewModel<T, S> extends BaseObservable implements IBaseDataViewModel {

    public ObservableField<Integer> currentState = new ObservableField<>(IView.IDLE);
    public ObservableList<S> dataList = new ObservableArrayList<>();
    public PagingParams pagingParams;

    public void loadPageData(Single<Page<T>> pageSingle, BaseSingleObserver<List<S>> baseSingleObserver) {
        pageSingle
                .doOnSubscribe(disposable -> doOnSubscribe())
                .map(Page::getContent)
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(this::transform)
                .toList()
                .doAfterSuccess(ses -> doAfterSuccess())
                .subscribe(baseSingleObserver);
    }

    public abstract S transform(T t);

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
        if (pagingParams.queryPage != Config.DEFAULT_QUERY_PAGE) {//初始化不为第一页
            pagingParams.currentPage += 1;
        }
        pagingParams.queryPage += 1;
    }

    public void beforeRefresh() {
        pagingParams.init();
    }

    public void afterLoadMore() {

    }

    public void afterRefresh() {

    }

    public int getCurrentState() {
        return currentState.get();
    }
}