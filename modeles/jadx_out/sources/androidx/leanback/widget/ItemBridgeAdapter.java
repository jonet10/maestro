package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ItemBridgeAdapter extends RecyclerView.Adapter implements FacetProviderAdapter {
    static final boolean DEBUG = false;
    static final String TAG = "ItemBridgeAdapter";
    private ObjectAdapter mAdapter;
    private AdapterListener mAdapterListener;
    private ObjectAdapter.DataObserver mDataObserver;
    FocusHighlightHandler mFocusHighlight;
    private PresenterSelector mPresenterSelector;
    private ArrayList<Presenter> mPresenters;
    Wrapper mWrapper;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ChainingFocusChangeListener implements View.OnFocusChangeListener {
        final View.OnFocusChangeListener mChainedListener;
        FocusHighlightHandler mFocusHighlight;
        boolean mHasWrapper;

        public ChainingFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener, boolean z9, FocusHighlightHandler focusHighlightHandler) {
            this.mChainedListener = onFocusChangeListener;
            this.mHasWrapper = z9;
            this.mFocusHighlight = focusHighlightHandler;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z9) {
            if (this.mHasWrapper) {
                view = (View) view.getParent();
            }
            this.mFocusHighlight.onItemFocused(view, z9);
            View.OnFocusChangeListener onFocusChangeListener = this.mChainedListener;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z9);
            }
        }

        public void update(boolean z9, FocusHighlightHandler focusHighlightHandler) {
            this.mHasWrapper = z9;
            this.mFocusHighlight = focusHighlightHandler;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ViewHolder extends RecyclerView.ViewHolder implements FacetProvider {
        Object mExtraObject;
        final Presenter.ViewHolder mHolder;
        Object mItem;
        final Presenter mPresenter;

        public ViewHolder(Presenter presenter, View view, Presenter.ViewHolder viewHolder) {
            super(view);
            this.mPresenter = presenter;
            this.mHolder = viewHolder;
        }

        public final Object getExtraObject() {
            return this.mExtraObject;
        }

        @Override // androidx.leanback.widget.FacetProvider
        public Object getFacet(Class<?> cls) {
            return this.mHolder.getFacet(cls);
        }

        public final Object getItem() {
            return this.mItem;
        }

        public final Presenter getPresenter() {
            return this.mPresenter;
        }

        public final Presenter.ViewHolder getViewHolder() {
            return this.mHolder;
        }

        public void setExtraObject(Object obj) {
            this.mExtraObject = obj;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Wrapper {
        public abstract View createWrapper(View view);

        public abstract void wrap(View view, View view2);
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter, PresenterSelector presenterSelector) {
        this.mPresenters = new ArrayList<>();
        this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ItemBridgeAdapter.1
            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onChanged() {
                ItemBridgeAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemMoved(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemMoved(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeInserted(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeInserted(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeRemoved(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeRemoved(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i, int i6, Object obj) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i, i6, obj);
            }
        };
        setAdapter(objectAdapter);
        this.mPresenterSelector = presenterSelector;
    }

    public void clear() {
        setAdapter(null);
    }

    @Override // androidx.leanback.widget.FacetProviderAdapter
    public FacetProvider getFacetProvider(int i) {
        return this.mPresenters.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null) {
            return objectAdapter.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.mAdapter.getId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        PresenterSelector presenterSelector = this.mPresenterSelector;
        if (presenterSelector == null) {
            presenterSelector = this.mAdapter.getPresenterSelector();
        }
        Presenter presenter = presenterSelector.getPresenter(this.mAdapter.get(i));
        int indexOf = this.mPresenters.indexOf(presenter);
        if (indexOf < 0) {
            this.mPresenters.add(presenter);
            indexOf = this.mPresenters.indexOf(presenter);
            onAddPresenter(presenter, indexOf);
            AdapterListener adapterListener = this.mAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAddPresenter(presenter, indexOf);
            }
        }
        return indexOf;
    }

    public ArrayList<Presenter> getPresenterMapper() {
        return this.mPresenters;
    }

    public Wrapper getWrapper() {
        return this.mWrapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.mAdapter.get(i);
        viewHolder2.mItem = obj;
        viewHolder2.mPresenter.onBindViewHolder(viewHolder2.mHolder, obj);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Presenter.ViewHolder onCreateViewHolder;
        View view;
        Presenter presenter = this.mPresenters.get(i);
        Wrapper wrapper = this.mWrapper;
        if (wrapper != null) {
            view = wrapper.createWrapper(viewGroup);
            onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            this.mWrapper.wrap(view, onCreateViewHolder.view);
        } else {
            onCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            view = onCreateViewHolder.view;
        }
        ViewHolder viewHolder = new ViewHolder(presenter, view, onCreateViewHolder);
        onCreate(viewHolder);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onCreate(viewHolder);
        }
        View view2 = viewHolder.mHolder.view;
        View.OnFocusChangeListener onFocusChangeListener = view2.getOnFocusChangeListener();
        FocusHighlightHandler focusHighlightHandler = this.mFocusHighlight;
        if (focusHighlightHandler == null) {
            if (onFocusChangeListener instanceof ChainingFocusChangeListener) {
                view2.setOnFocusChangeListener(((ChainingFocusChangeListener) onFocusChangeListener).mChainedListener);
            }
            return viewHolder;
        }
        boolean z9 = onFocusChangeListener instanceof ChainingFocusChangeListener;
        Wrapper wrapper2 = this.mWrapper;
        if (z9) {
            ((ChainingFocusChangeListener) onFocusChangeListener).update(wrapper2 != null, focusHighlightHandler);
        } else {
            view2.setOnFocusChangeListener(new ChainingFocusChangeListener(onFocusChangeListener, wrapper2 != null, focusHighlightHandler));
        }
        this.mFocusHighlight.onInitializeView(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onAttachedToWindow(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onAttachedToWindow(viewHolder2);
        }
        viewHolder2.mPresenter.onViewAttachedToWindow(viewHolder2.mHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mPresenter.onViewDetachedFromWindow(viewHolder2.mHolder);
        onDetachedFromWindow(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onDetachedFromWindow(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mPresenter.onUnbindViewHolder(viewHolder2.mHolder);
        onUnbind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onUnbind(viewHolder2);
        }
        viewHolder2.mItem = null;
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        ObjectAdapter objectAdapter2 = this.mAdapter;
        if (objectAdapter == objectAdapter2) {
            return;
        }
        if (objectAdapter2 != null) {
            objectAdapter2.unregisterObserver(this.mDataObserver);
        }
        this.mAdapter = objectAdapter;
        if (objectAdapter == null) {
            notifyDataSetChanged();
            return;
        }
        objectAdapter.registerObserver(this.mDataObserver);
        if (hasStableIds() != this.mAdapter.hasStableIds()) {
            setHasStableIds(this.mAdapter.hasStableIds());
        }
        notifyDataSetChanged();
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.mAdapterListener = adapterListener;
    }

    public void setFocusHighlight(FocusHighlightHandler focusHighlightHandler) {
        this.mFocusHighlight = focusHighlightHandler;
    }

    public void setPresenter(PresenterSelector presenterSelector) {
        this.mPresenterSelector = presenterSelector;
        notifyDataSetChanged();
    }

    public void setPresenterMapper(ArrayList<Presenter> arrayList) {
        this.mPresenters = arrayList;
    }

    public void setWrapper(Wrapper wrapper) {
        this.mWrapper = wrapper;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class AdapterListener {
        public void onBind(ViewHolder viewHolder, List list) {
            onBind(viewHolder);
        }

        public void onBind(ViewHolder viewHolder) {
        }

        public void onAttachedToWindow(ViewHolder viewHolder) {
        }

        public void onCreate(ViewHolder viewHolder) {
        }

        public void onDetachedFromWindow(ViewHolder viewHolder) {
        }

        public void onUnbind(ViewHolder viewHolder) {
        }

        public void onAddPresenter(Presenter presenter, int i) {
        }
    }

    public void onAttachedToWindow(ViewHolder viewHolder) {
    }

    public void onBind(ViewHolder viewHolder) {
    }

    public void onCreate(ViewHolder viewHolder) {
    }

    public void onDetachedFromWindow(ViewHolder viewHolder) {
    }

    public void onUnbind(ViewHolder viewHolder) {
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter) {
        this(objectAdapter, null);
    }

    public ItemBridgeAdapter() {
        this.mPresenters = new ArrayList<>();
        this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ItemBridgeAdapter.1
            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onChanged() {
                ItemBridgeAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemMoved(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemMoved(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeInserted(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeInserted(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeRemoved(int i, int i6) {
                ItemBridgeAdapter.this.notifyItemRangeRemoved(i, i6);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i, int i6, Object obj) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i, i6, obj);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.mAdapter.get(i);
        viewHolder2.mItem = obj;
        viewHolder2.mPresenter.onBindViewHolder(viewHolder2.mHolder, obj, list);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2, list);
        }
    }

    public void onAddPresenter(Presenter presenter, int i) {
    }
}
