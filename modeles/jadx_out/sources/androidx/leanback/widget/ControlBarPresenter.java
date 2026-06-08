package androidx.leanback.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ControlBar;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ControlBarPresenter extends Presenter {
    static final int MAX_CONTROLS = 7;
    private static int sChildMarginDefault;
    private static int sControlIconWidth;
    boolean mDefaultFocusToMiddle = true;
    private int mLayoutResourceId;
    OnControlClickedListener mOnControlClickedListener;
    OnControlSelectedListener mOnControlSelectedListener;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class BoundData {
        ObjectAdapter adapter;
        Presenter presenter;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface OnControlClickedListener {
        void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface OnControlSelectedListener {
        void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    public ControlBarPresenter(int i) {
        this.mLayoutResourceId = i;
    }

    public int getChildMarginDefault(Context context) {
        if (sChildMarginDefault == 0) {
            sChildMarginDefault = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_default);
        }
        return sChildMarginDefault;
    }

    public int getControlIconWidth(Context context) {
        if (sControlIconWidth == 0) {
            sControlIconWidth = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_control_icon_width);
        }
        return sControlIconWidth;
    }

    public int getLayoutResourceId() {
        return this.mLayoutResourceId;
    }

    public OnControlSelectedListener getOnItemControlListener() {
        return this.mOnControlSelectedListener;
    }

    public OnControlClickedListener getOnItemViewClickedListener() {
        return this.mOnControlClickedListener;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BoundData boundData = (BoundData) obj;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        ObjectAdapter objectAdapter2 = boundData.adapter;
        if (objectAdapter != objectAdapter2) {
            viewHolder2.mAdapter = objectAdapter2;
            if (objectAdapter2 != null) {
                objectAdapter2.registerObserver(viewHolder2.mDataObserver);
            }
        }
        Presenter presenter = boundData.presenter;
        viewHolder2.mPresenter = presenter;
        viewHolder2.mData = boundData;
        viewHolder2.showControls(presenter);
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(viewHolder2.mDataObserver);
            viewHolder2.mAdapter = null;
        }
        viewHolder2.mData = null;
    }

    public void setBackgroundColor(ViewHolder viewHolder, int i) {
        viewHolder.mControlsContainer.setBackgroundColor(i);
    }

    public void setDefaultFocusToMiddle(boolean z9) {
        this.mDefaultFocusToMiddle = z9;
    }

    public void setOnControlClickedListener(OnControlClickedListener onControlClickedListener) {
        this.mOnControlClickedListener = onControlClickedListener;
    }

    public void setOnControlSelectedListener(OnControlSelectedListener onControlSelectedListener) {
        this.mOnControlSelectedListener = onControlSelectedListener;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class ViewHolder extends Presenter.ViewHolder {
        ObjectAdapter mAdapter;
        ControlBar mControlBar;
        View mControlsContainer;
        BoundData mData;
        ObjectAdapter.DataObserver mDataObserver;
        Presenter mPresenter;
        SparseArray<Presenter.ViewHolder> mViewHolders;

        public ViewHolder(View view) {
            super(view);
            this.mViewHolders = new SparseArray<>();
            this.mControlsContainer = view.findViewById(androidx.leanback.R.id.controls_container);
            ControlBar controlBar = (ControlBar) view.findViewById(androidx.leanback.R.id.control_bar);
            this.mControlBar = controlBar;
            if (controlBar == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Couldn't find control_bar");
                throw null;
            }
            controlBar.setDefaultFocusToMiddle(ControlBarPresenter.this.mDefaultFocusToMiddle);
            this.mControlBar.setOnChildFocusedListener(new ControlBar.OnChildFocusedListener() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.1
                @Override // androidx.leanback.widget.ControlBar.OnChildFocusedListener
                public void onChildFocusedListener(View view2, View view3) {
                    if (ControlBarPresenter.this.mOnControlSelectedListener == null) {
                        return;
                    }
                    for (int i = 0; i < ViewHolder.this.mViewHolders.size(); i++) {
                        if (ViewHolder.this.mViewHolders.get(i).view == view2) {
                            ViewHolder viewHolder = ViewHolder.this;
                            ControlBarPresenter.this.mOnControlSelectedListener.onControlSelected(viewHolder.mViewHolders.get(i), ViewHolder.this.getDisplayedAdapter().get(i), ViewHolder.this.mData);
                            return;
                        }
                    }
                }
            });
            this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.2
                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onChanged() {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                        ViewHolder viewHolder2 = ViewHolder.this;
                        viewHolder2.showControls(viewHolder2.mPresenter);
                    }
                }

                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onItemRangeChanged(int i, int i6) {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                        for (int i10 = 0; i10 < i6; i10++) {
                            ViewHolder viewHolder2 = ViewHolder.this;
                            viewHolder2.bindControlToAction(i + i10, viewHolder2.mPresenter);
                        }
                    }
                }
            };
        }

        private void bindControlToAction(final int i, ObjectAdapter objectAdapter, Presenter presenter) {
            final Presenter.ViewHolder viewHolder = this.mViewHolders.get(i);
            Object obj = objectAdapter.get(i);
            if (viewHolder == null) {
                viewHolder = presenter.onCreateViewHolder(this.mControlBar);
                this.mViewHolders.put(i, viewHolder);
                presenter.setOnClickListener(viewHolder, new View.OnClickListener() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Object obj2 = ViewHolder.this.getDisplayedAdapter().get(i);
                        ViewHolder viewHolder2 = ViewHolder.this;
                        OnControlClickedListener onControlClickedListener = ControlBarPresenter.this.mOnControlClickedListener;
                        if (onControlClickedListener != null) {
                            onControlClickedListener.onControlClicked(viewHolder, obj2, viewHolder2.mData);
                        }
                    }
                });
            }
            if (viewHolder.view.getParent() == null) {
                this.mControlBar.addView(viewHolder.view);
            }
            presenter.onBindViewHolder(viewHolder, obj);
        }

        public int getChildMarginFromCenter(Context context, int i) {
            return ControlBarPresenter.this.getChildMarginDefault(context) + ControlBarPresenter.this.getControlIconWidth(context);
        }

        public ObjectAdapter getDisplayedAdapter() {
            return this.mAdapter;
        }

        public void showControls(Presenter presenter) {
            ObjectAdapter displayedAdapter = getDisplayedAdapter();
            int size = displayedAdapter == null ? 0 : displayedAdapter.size();
            View focusedChild = this.mControlBar.getFocusedChild();
            if (focusedChild != null && size > 0 && this.mControlBar.indexOfChild(focusedChild) >= size) {
                this.mControlBar.getChildAt(displayedAdapter.size() - 1).requestFocus();
            }
            for (int childCount = this.mControlBar.getChildCount() - 1; childCount >= size; childCount--) {
                this.mControlBar.removeViewAt(childCount);
            }
            for (int i = 0; i < size && i < 7; i++) {
                bindControlToAction(i, displayedAdapter, presenter);
            }
            ControlBar controlBar = this.mControlBar;
            controlBar.setChildMarginFromCenter(getChildMarginFromCenter(controlBar.getContext(), size));
        }

        public void bindControlToAction(int i, Presenter presenter) {
            bindControlToAction(i, getDisplayedAdapter(), presenter);
        }
    }
}
