package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class PresenterSwitcher {
    private Presenter mCurrentPresenter;
    private Presenter.ViewHolder mCurrentViewHolder;
    private ViewGroup mParent;
    private PresenterSelector mPresenterSelector;

    private void showView(boolean z9) {
        Presenter.ViewHolder viewHolder = this.mCurrentViewHolder;
        if (viewHolder != null) {
            showView(viewHolder.view, z9);
        }
    }

    private void switchView(Object obj) {
        Presenter presenter = this.mPresenterSelector.getPresenter(obj);
        Presenter presenter2 = this.mCurrentPresenter;
        if (presenter != presenter2) {
            showView(false);
            clear();
            this.mCurrentPresenter = presenter;
            if (presenter == null) {
                return;
            }
            Presenter.ViewHolder onCreateViewHolder = presenter.onCreateViewHolder(this.mParent);
            this.mCurrentViewHolder = onCreateViewHolder;
            insertView(onCreateViewHolder.view);
        } else if (presenter2 == null) {
            return;
        } else {
            presenter2.onUnbindViewHolder(this.mCurrentViewHolder);
        }
        this.mCurrentPresenter.onBindViewHolder(this.mCurrentViewHolder, obj);
        onViewSelected(this.mCurrentViewHolder.view);
    }

    public void clear() {
        Presenter presenter = this.mCurrentPresenter;
        if (presenter != null) {
            presenter.onUnbindViewHolder(this.mCurrentViewHolder);
            this.mParent.removeView(this.mCurrentViewHolder.view);
            this.mCurrentViewHolder = null;
            this.mCurrentPresenter = null;
        }
    }

    public final ViewGroup getParentViewGroup() {
        return this.mParent;
    }

    public void init(ViewGroup viewGroup, PresenterSelector presenterSelector) {
        clear();
        this.mParent = viewGroup;
        this.mPresenterSelector = presenterSelector;
    }

    public abstract void insertView(View view);

    public void select(Object obj) {
        switchView(obj);
        showView(true);
    }

    public void unselect() {
        showView(false);
    }

    public void showView(View view, boolean z9) {
        view.setVisibility(z9 ? 0 : 8);
    }

    public void onViewSelected(View view) {
    }
}
