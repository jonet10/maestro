package androidx.leanback.app;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.ViewHolderTask;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class RowsFragment extends BaseRowFragment implements BrowseFragment.MainFragmentRowsAdapterProvider, BrowseFragment.MainFragmentAdapterProvider {
    static final int ALIGN_TOP_NOT_SET = Integer.MIN_VALUE;
    static final boolean DEBUG = false;
    static final String TAG = "RowsFragment";
    ItemBridgeAdapter.AdapterListener mExternalAdapterListener;
    boolean mFreezeRows;
    private MainFragmentAdapter mMainFragmentAdapter;
    private MainFragmentRowsAdapter mMainFragmentRowsAdapter;
    BaseOnItemViewClickedListener mOnItemViewClickedListener;
    BaseOnItemViewSelectedListener mOnItemViewSelectedListener;
    private ArrayList<Presenter> mPresenterMapper;
    private RecyclerView.RecycledViewPool mRecycledViewPool;
    ItemBridgeAdapter.ViewHolder mSelectedViewHolder;
    private int mSubPosition;
    boolean mViewsCreated;
    boolean mExpand = true;
    private int mAlignedTop = Integer.MIN_VALUE;
    boolean mAfterEntranceTransition = true;
    private final ItemBridgeAdapter.AdapterListener mBridgeAdapterListener = new ItemBridgeAdapter.AdapterListener() { // from class: androidx.leanback.app.RowsFragment.1
        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onAddPresenter(Presenter presenter, int i) {
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAddPresenter(presenter, i);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            RowsFragment.setRowViewExpanded(viewHolder, RowsFragment.this.mExpand);
            RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
            RowPresenter.ViewHolder rowViewHolder = rowPresenter.getRowViewHolder(viewHolder.getViewHolder());
            rowPresenter.setEntranceTransitionState(rowViewHolder, RowsFragment.this.mAfterEntranceTransition);
            rowViewHolder.setOnItemViewSelectedListener(RowsFragment.this.mOnItemViewSelectedListener);
            rowViewHolder.setOnItemViewClickedListener(RowsFragment.this.mOnItemViewClickedListener);
            rowPresenter.freeze(rowViewHolder, RowsFragment.this.mFreezeRows);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAttachedToWindow(viewHolder);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onBind(viewHolder);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            VerticalGridView verticalGridView = RowsFragment.this.getVerticalGridView();
            if (verticalGridView != null) {
                verticalGridView.setClipChildren(false);
            }
            RowsFragment.this.setupSharedViewPool(viewHolder);
            RowsFragment.this.mViewsCreated = true;
            viewHolder.setExtraObject(new RowViewHolderExtra(viewHolder));
            RowsFragment.setRowViewSelected(viewHolder, false, true);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onCreate(viewHolder);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = RowsFragment.this.mSelectedViewHolder;
            if (viewHolder2 == viewHolder) {
                RowsFragment.setRowViewSelected(viewHolder2, false, true);
                RowsFragment.this.mSelectedViewHolder = null;
            }
            RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
            rowViewHolder.setOnItemViewSelectedListener(null);
            rowViewHolder.setOnItemViewClickedListener(null);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onDetachedFromWindow(viewHolder);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            RowsFragment.setRowViewSelected(viewHolder, false, true);
            ItemBridgeAdapter.AdapterListener adapterListener = RowsFragment.this.mExternalAdapterListener;
            if (adapterListener != null) {
                adapterListener.onUnbind(viewHolder);
            }
        }
    };

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class MainFragmentAdapter extends BrowseFragment.MainFragmentAdapter<RowsFragment> {
        public MainFragmentAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
            setScalingEnabled(true);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public boolean isScrolling() {
            return getFragment().isScrolling();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void onTransitionEnd() {
            getFragment().onTransitionEnd();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public boolean onTransitionPrepare() {
            return getFragment().onTransitionPrepare();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void onTransitionStart() {
            getFragment().onTransitionStart();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setAlignment(int i) {
            getFragment().setAlignment(i);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setEntranceTransitionState(boolean z9) {
            getFragment().setEntranceTransitionState(z9);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapter
        public void setExpand(boolean z9) {
            getFragment().setExpand(z9);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class RowViewHolderExtra implements TimeAnimator.TimeListener {
        static final Interpolator sSelectAnimatorInterpolator = new DecelerateInterpolator(2.0f);
        final RowPresenter mRowPresenter;
        final Presenter.ViewHolder mRowViewHolder;
        final TimeAnimator mSelectAnimator;
        final int mSelectAnimatorDurationInUse;
        final Interpolator mSelectAnimatorInterpolatorInUse;
        float mSelectLevelAnimDelta;
        float mSelectLevelAnimStart;

        public RowViewHolderExtra(ItemBridgeAdapter.ViewHolder viewHolder) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mSelectAnimator = timeAnimator;
            this.mRowPresenter = (RowPresenter) viewHolder.getPresenter();
            this.mRowViewHolder = viewHolder.getViewHolder();
            timeAnimator.setTimeListener(this);
            this.mSelectAnimatorDurationInUse = viewHolder.itemView.getResources().getInteger(R.integer.lb_browse_rows_anim_duration);
            this.mSelectAnimatorInterpolatorInUse = sSelectAnimatorInterpolator;
        }

        public void animateSelect(boolean z9, boolean z10) {
            this.mSelectAnimator.end();
            float f = z9 ? 1.0f : 0.0f;
            RowPresenter rowPresenter = this.mRowPresenter;
            if (z10) {
                rowPresenter.setSelectLevel(this.mRowViewHolder, f);
            } else if (rowPresenter.getSelectLevel(this.mRowViewHolder) != f) {
                float selectLevel = this.mRowPresenter.getSelectLevel(this.mRowViewHolder);
                this.mSelectLevelAnimStart = selectLevel;
                this.mSelectLevelAnimDelta = f - selectLevel;
                this.mSelectAnimator.start();
            }
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j6) {
            if (this.mSelectAnimator.isRunning()) {
                updateSelect(j, j6);
            }
        }

        public void updateSelect(long j, long j6) {
            float f;
            int i = this.mSelectAnimatorDurationInUse;
            if (j >= i) {
                this.mSelectAnimator.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            Interpolator interpolator = this.mSelectAnimatorInterpolatorInUse;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            this.mRowPresenter.setSelectLevel(this.mRowViewHolder, (f * this.mSelectLevelAnimDelta) + this.mSelectLevelAnimStart);
        }
    }

    private void freezeRows(boolean z9) {
        this.mFreezeRows = z9;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.freeze(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), z9);
            }
        }
    }

    public static void setRowViewExpanded(ItemBridgeAdapter.ViewHolder viewHolder, boolean z9) {
        ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), z9);
    }

    public static void setRowViewSelected(ItemBridgeAdapter.ViewHolder viewHolder, boolean z9, boolean z10) {
        ((RowViewHolderExtra) viewHolder.getExtraObject()).animateSelect(z9, z10);
        ((RowPresenter) viewHolder.getPresenter()).setRowViewSelected(viewHolder.getViewHolder(), z9);
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.container_list);
    }

    public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView == null) {
            return null;
        }
        return getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public int getLayoutResourceId() {
        return R.layout.lb_rows_fragment;
    }

    @Override // androidx.leanback.app.BrowseFragment.MainFragmentAdapterProvider
    public BrowseFragment.MainFragmentAdapter getMainFragmentAdapter() {
        if (this.mMainFragmentAdapter == null) {
            this.mMainFragmentAdapter = new MainFragmentAdapter(this);
        }
        return this.mMainFragmentAdapter;
    }

    @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapterProvider
    public BrowseFragment.MainFragmentRowsAdapter getMainFragmentRowsAdapter() {
        if (this.mMainFragmentRowsAdapter == null) {
            this.mMainFragmentRowsAdapter = new MainFragmentRowsAdapter(this);
        }
        return this.mMainFragmentRowsAdapter;
    }

    public BaseOnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public BaseOnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mOnItemViewSelectedListener;
    }

    public RowPresenter.ViewHolder getRowViewHolder(int i) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return null;
        }
        return getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(i));
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public /* bridge */ /* synthetic */ int getSelectedPosition() {
        return super.getSelectedPosition();
    }

    public boolean isScrolling() {
        return (getVerticalGridView() == null || getVerticalGridView().getScrollState() == 0) ? false : true;
    }

    @Override // androidx.leanback.app.BaseRowFragment, android.app.Fragment
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.leanback.app.BaseRowFragment, android.app.Fragment
    public void onDestroyView() {
        this.mViewsCreated = false;
        this.mSelectedViewHolder = null;
        this.mRecycledViewPool = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i6) {
        ItemBridgeAdapter.ViewHolder viewHolder2 = this.mSelectedViewHolder;
        if (viewHolder2 != viewHolder || this.mSubPosition != i6) {
            this.mSubPosition = i6;
            if (viewHolder2 != null) {
                setRowViewSelected(viewHolder2, false, false);
            }
            ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) viewHolder;
            this.mSelectedViewHolder = viewHolder3;
            if (viewHolder3 != null) {
                setRowViewSelected(viewHolder3, true, false);
            }
        }
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.getFragmentHost().showTitleView(i <= 0);
        }
    }

    @Override // androidx.leanback.app.BaseRowFragment, android.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public void onTransitionEnd() {
        super.onTransitionEnd();
        freezeRows(false);
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public boolean onTransitionPrepare() {
        boolean onTransitionPrepare = super.onTransitionPrepare();
        if (onTransitionPrepare) {
            freezeRows(true);
        }
        return onTransitionPrepare;
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public /* bridge */ /* synthetic */ void onTransitionStart() {
        super.onTransitionStart();
    }

    @Override // androidx.leanback.app.BaseRowFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getVerticalGridView().setItemAlignmentViewId(R.id.row_content);
        getVerticalGridView().setSaveChildrenPolicy(2);
        setAlignment(this.mAlignedTop);
        this.mRecycledViewPool = null;
        this.mPresenterMapper = null;
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.getFragmentHost().notifyViewCreated(this.mMainFragmentAdapter);
        }
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public void setAlignment(int i) {
        if (i == Integer.MIN_VALUE) {
            return;
        }
        this.mAlignedTop = i;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffsetWithPadding(true);
            verticalGridView.setWindowAlignmentOffset(this.mAlignedTop);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setWindowAlignment(0);
        }
    }

    public void setEntranceTransitionState(boolean z9) {
        this.mAfterEntranceTransition = z9;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
                rowPresenter.setEntranceTransitionState(rowPresenter.getRowViewHolder(viewHolder.getViewHolder()), this.mAfterEntranceTransition);
            }
        }
    }

    public void setExpand(boolean z9) {
        this.mExpand = z9;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                setRowViewExpanded((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i)), this.mExpand);
            }
        }
    }

    public void setExternalAdapterListener(ItemBridgeAdapter.AdapterListener adapterListener) {
        this.mExternalAdapterListener = adapterListener;
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.mOnItemViewClickedListener = baseOnItemViewClickedListener;
        if (this.mViewsCreated) {
            a.i("Item clicked listener must be set before views are created");
        }
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = baseOnItemViewSelectedListener;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            int childCount = verticalGridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                getRowViewHolder((ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i))).setOnItemViewSelectedListener(this.mOnItemViewSelectedListener);
            }
        }
    }

    public void setSelectedPosition(int i, boolean z9, final Presenter.ViewHolderTask viewHolderTask) {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return;
        }
        ViewHolderTask viewHolderTask2 = viewHolderTask != null ? new ViewHolderTask() { // from class: androidx.leanback.app.RowsFragment.2
            @Override // androidx.leanback.widget.ViewHolderTask
            public void run(final RecyclerView.ViewHolder viewHolder) {
                viewHolder.itemView.post(new Runnable() { // from class: androidx.leanback.app.RowsFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        viewHolderTask.run(RowsFragment.getRowViewHolder((ItemBridgeAdapter.ViewHolder) viewHolder));
                    }
                });
            }
        } : null;
        if (z9) {
            verticalGridView.setSelectedPositionSmooth(i, viewHolderTask2);
        } else {
            verticalGridView.setSelectedPosition(i, viewHolderTask2);
        }
    }

    public void setupSharedViewPool(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        if (rowViewHolder instanceof ListRowPresenter.ViewHolder) {
            ListRowPresenter.ViewHolder viewHolder2 = (ListRowPresenter.ViewHolder) rowViewHolder;
            HorizontalGridView gridView = viewHolder2.getGridView();
            RecyclerView.RecycledViewPool recycledViewPool = this.mRecycledViewPool;
            if (recycledViewPool == null) {
                this.mRecycledViewPool = gridView.getRecycledViewPool();
            } else {
                gridView.setRecycledViewPool(recycledViewPool);
            }
            ItemBridgeAdapter bridgeAdapter = viewHolder2.getBridgeAdapter();
            ArrayList<Presenter> arrayList = this.mPresenterMapper;
            if (arrayList == null) {
                this.mPresenterMapper = bridgeAdapter.getPresenterMapper();
            } else {
                bridgeAdapter.setPresenterMapper(arrayList);
            }
        }
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public void updateAdapter() {
        super.updateAdapter();
        this.mSelectedViewHolder = null;
        this.mViewsCreated = false;
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        if (bridgeAdapter != null) {
            bridgeAdapter.setAdapterListener(this.mBridgeAdapterListener);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Deprecated
    public static class MainFragmentRowsAdapter extends BrowseFragment.MainFragmentRowsAdapter<RowsFragment> {
        public MainFragmentRowsAdapter(RowsFragment rowsFragment) {
            super(rowsFragment);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return getFragment().findRowViewHolderByPosition(i);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public int getSelectedPosition() {
            return getFragment().getSelectedPosition();
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setAdapter(ObjectAdapter objectAdapter) {
            getFragment().setAdapter(objectAdapter);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
            getFragment().setOnItemViewClickedListener(onItemViewClickedListener);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
            getFragment().setOnItemViewSelectedListener(onItemViewSelectedListener);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z9, Presenter.ViewHolderTask viewHolderTask) {
            getFragment().setSelectedPosition(i, z9, viewHolderTask);
        }

        @Override // androidx.leanback.app.BrowseFragment.MainFragmentRowsAdapter
        public void setSelectedPosition(int i, boolean z9) {
            getFragment().setSelectedPosition(i, z9);
        }
    }

    public static RowPresenter.ViewHolder getRowViewHolder(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        return ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
    }

    @Deprecated
    public void enableRowScaling(boolean z9) {
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i, boolean z9) {
        super.setSelectedPosition(i, z9);
    }

    @Override // androidx.leanback.app.BaseRowFragment
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i) {
        super.setSelectedPosition(i);
    }
}
