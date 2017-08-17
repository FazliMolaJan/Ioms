package vm;

import com.hy.ioms.view.IView;

/**
 * Created by wsw on 2017/6/20.
 */

public interface IBaseDataViewModel {
    /**
     * 加载更多数据
     */
    void loadMore();

    /**
     * 刷新数据
     */
    void refresh();
}
