package vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hy.ioms.BR;

import javax.inject.Inject;

/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class EventViewModel extends BaseObservable {

    @Inject
    public EventViewModel() {
    }

    private android.view.View.OnClickListener onClick;

    public void setOnClick(android.view.View.OnClickListener onClick) {
        this.onClick = onClick;
        notifyPropertyChanged(BR.onClick);
    }

    @Bindable
    public android.view.View.OnClickListener getOnClick() {
        return this.onClick;
    }
}
