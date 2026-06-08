package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.system.Settings;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ListRowPresenter extends RowPresenter {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_RECYCLED_POOL_SIZE = 24;
    private static final String TAG = "ListRowPresenter";
    private static int sExpandedRowNoHovercardBottomPadding;
    private static int sExpandedSelectedRowTopPadding;
    private static int sSelectedRowTopPadding;
    private int mBrowseRowsFadingEdgeLength;
    private int mExpandedRowHeight;
    private int mFocusZoomFactor;
    private PresenterSelector mHoverCardPresenterSelector;
    private boolean mKeepChildForeground;
    private int mNumRows;
    private HashMap<Presenter, Integer> mRecycledPoolSize;
    private boolean mRoundedCornersEnabled;
    private int mRowHeight;
    private boolean mShadowEnabled;
    ShadowOverlayHelper mShadowOverlayHelper;
    private ItemBridgeAdapter.Wrapper mShadowOverlayWrapper;
    private boolean mUseFocusDimmer;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class ListRowPresenterItemBridgeAdapter extends ItemBridgeAdapter {
        ViewHolder mRowViewHolder;

        public ListRowPresenterItemBridgeAdapter(ViewHolder viewHolder) {
            this.mRowViewHolder = viewHolder;
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAddPresenter(Presenter presenter, int i) {
            this.mRowViewHolder.getGridView().getRecycledViewPool().setMaxRecycledViews(i, ListRowPresenter.this.getRecycledPoolSize(presenter));
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            ListRowPresenter.this.applySelectLevelToChild(this.mRowViewHolder, viewHolder.itemView);
            this.mRowViewHolder.syncActivatedStatus(viewHolder.itemView);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.widget.ListRowPresenter.ListRowPresenterItemBridgeAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.mGridView.getChildViewHolder(viewHolder.itemView);
                        if (ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                            BaseOnItemViewClickedListener onItemViewClickedListener = ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.getOnItemViewClickedListener();
                            Presenter.ViewHolder viewHolder3 = viewHolder.mHolder;
                            Object obj = viewHolder2.mItem;
                            ViewHolder viewHolder4 = ListRowPresenterItemBridgeAdapter.this.mRowViewHolder;
                            onItemViewClickedListener.onItemClicked(viewHolder3, obj, viewHolder4, (ListRow) viewHolder4.mRow);
                        }
                    }
                });
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                TransitionHelper.setTransitionGroup((ViewGroup) view, true);
            }
            ShadowOverlayHelper shadowOverlayHelper = ListRowPresenter.this.mShadowOverlayHelper;
            if (shadowOverlayHelper != null) {
                shadowOverlayHelper.onViewCreated(viewHolder.itemView);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(null);
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SelectItemViewHolderTask extends Presenter.ViewHolderTask {
        private int mItemPosition;
        Presenter.ViewHolderTask mItemTask;
        private boolean mSmoothScroll = true;

        public SelectItemViewHolderTask(int i) {
            setItemPosition(i);
        }

        public int getItemPosition() {
            return this.mItemPosition;
        }

        public Presenter.ViewHolderTask getItemTask() {
            return this.mItemTask;
        }

        public boolean isSmoothScroll() {
            return this.mSmoothScroll;
        }

        @Override // androidx.leanback.widget.Presenter.ViewHolderTask
        public void run(Presenter.ViewHolder viewHolder) {
            if (viewHolder instanceof ViewHolder) {
                HorizontalGridView gridView = ((ViewHolder) viewHolder).getGridView();
                ViewHolderTask viewHolderTask = this.mItemTask != null ? new ViewHolderTask() { // from class: androidx.leanback.widget.ListRowPresenter.SelectItemViewHolderTask.1
                    final Presenter.ViewHolderTask itemTask;

                    {
                        this.itemTask = SelectItemViewHolderTask.this.mItemTask;
                    }

                    @Override // androidx.leanback.widget.ViewHolderTask
                    public void run(RecyclerView.ViewHolder viewHolder2) {
                        this.itemTask.run(((ItemBridgeAdapter.ViewHolder) viewHolder2).getViewHolder());
                    }
                } : null;
                boolean isSmoothScroll = isSmoothScroll();
                int i = this.mItemPosition;
                if (isSmoothScroll) {
                    gridView.setSelectedPositionSmooth(i, viewHolderTask);
                } else {
                    gridView.setSelectedPosition(i, viewHolderTask);
                }
            }
        }

        public void setItemPosition(int i) {
            this.mItemPosition = i;
        }

        public void setItemTask(Presenter.ViewHolderTask viewHolderTask) {
            this.mItemTask = viewHolderTask;
        }

        public void setSmoothScroll(boolean z9) {
            this.mSmoothScroll = z9;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ViewHolder extends RowPresenter.ViewHolder {
        final HorizontalGridView mGridView;
        final HorizontalHoverCardSwitcher mHoverCardViewSwitcher;
        ItemBridgeAdapter mItemBridgeAdapter;
        final ListRowPresenter mListRowPresenter;
        final int mPaddingBottom;
        final int mPaddingLeft;
        final int mPaddingRight;
        final int mPaddingTop;

        public ViewHolder(View view, HorizontalGridView horizontalGridView, ListRowPresenter listRowPresenter) {
            super(view);
            this.mHoverCardViewSwitcher = new HorizontalHoverCardSwitcher();
            this.mGridView = horizontalGridView;
            this.mListRowPresenter = listRowPresenter;
            this.mPaddingTop = horizontalGridView.getPaddingTop();
            this.mPaddingBottom = horizontalGridView.getPaddingBottom();
            this.mPaddingLeft = horizontalGridView.getPaddingLeft();
            this.mPaddingRight = horizontalGridView.getPaddingRight();
        }

        public final ItemBridgeAdapter getBridgeAdapter() {
            return this.mItemBridgeAdapter;
        }

        public final HorizontalGridView getGridView() {
            return this.mGridView;
        }

        public Presenter.ViewHolder getItemViewHolder(int i) {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.mGridView.findViewHolderForAdapterPosition(i);
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getViewHolder();
        }

        public final ListRowPresenter getListRowPresenter() {
            return this.mListRowPresenter;
        }

        @Override // androidx.leanback.widget.RowPresenter.ViewHolder
        public Object getSelectedItem() {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.mGridView.findViewHolderForAdapterPosition(getSelectedPosition());
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getItem();
        }

        @Override // androidx.leanback.widget.RowPresenter.ViewHolder
        public Presenter.ViewHolder getSelectedItemViewHolder() {
            return getItemViewHolder(getSelectedPosition());
        }

        public int getSelectedPosition() {
            return this.mGridView.getSelectedPosition();
        }
    }

    public ListRowPresenter(int i, boolean z9) {
        this.mNumRows = 1;
        this.mShadowEnabled = true;
        this.mBrowseRowsFadingEdgeLength = -1;
        this.mRoundedCornersEnabled = true;
        this.mKeepChildForeground = true;
        this.mRecycledPoolSize = new HashMap<>();
        if (!FocusHighlightHelper.isValidZoomIndex(i)) {
            com.google.gson.internal.a.p("Unhandled zoom factor");
            throw null;
        }
        this.mFocusZoomFactor = i;
        this.mUseFocusDimmer = z9;
    }

    private int getSpaceUnderBaseline(ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder headerViewHolder = viewHolder.getHeaderViewHolder();
        if (headerViewHolder != null) {
            return getHeaderPresenter() != null ? getHeaderPresenter().getSpaceUnderBaseline(headerViewHolder) : headerViewHolder.view.getPaddingBottom();
        }
        return 0;
    }

    private static void initStatics(Context context) {
        if (sSelectedRowTopPadding == 0) {
            sSelectedRowTopPadding = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_selected_row_top_padding);
            sExpandedSelectedRowTopPadding = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_expanded_selected_row_top_padding);
            sExpandedRowNoHovercardBottomPadding = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_expanded_row_no_hovercard_bottom_padding);
        }
    }

    private void setVerticalPadding(ViewHolder viewHolder) {
        int i;
        int i6;
        if (viewHolder.isExpanded()) {
            i = (viewHolder.isSelected() ? sExpandedSelectedRowTopPadding : viewHolder.mPaddingTop) - getSpaceUnderBaseline(viewHolder);
            i6 = this.mHoverCardPresenterSelector == null ? sExpandedRowNoHovercardBottomPadding : viewHolder.mPaddingBottom;
        } else {
            boolean isSelected = viewHolder.isSelected();
            int i10 = viewHolder.mPaddingBottom;
            if (isSelected) {
                i6 = sSelectedRowTopPadding;
                i = i6 - i10;
            } else {
                i = 0;
                i6 = i10;
            }
        }
        viewHolder.getGridView().setPadding(viewHolder.mPaddingLeft, i, viewHolder.mPaddingRight, i6);
    }

    private void setupFadingEffect(ListRowView listRowView) {
        HorizontalGridView gridView = listRowView.getGridView();
        if (this.mBrowseRowsFadingEdgeLength < 0) {
            TypedArray obtainStyledAttributes = gridView.getContext().obtainStyledAttributes(androidx.leanback.R.styleable.LeanbackTheme);
            this.mBrowseRowsFadingEdgeLength = (int) obtainStyledAttributes.getDimension(androidx.leanback.R.styleable.LeanbackTheme_browseRowsFadingEdgeLength, 0.0f);
            obtainStyledAttributes.recycle();
        }
        gridView.setFadingLeftEdgeLength(this.mBrowseRowsFadingEdgeLength);
    }

    private void updateFooterViewSwitcher(ViewHolder viewHolder) {
        if (!viewHolder.mExpanded || !viewHolder.mSelected) {
            if (this.mHoverCardPresenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.unselect();
            }
        } else {
            PresenterSelector presenterSelector = this.mHoverCardPresenterSelector;
            if (presenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.init((ViewGroup) viewHolder.view, presenterSelector);
            }
            HorizontalGridView horizontalGridView = viewHolder.mGridView;
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            selectChildView(viewHolder, viewHolder2 == null ? null : viewHolder2.itemView, false);
        }
    }

    public void applySelectLevelToChild(ViewHolder viewHolder, View view) {
        ShadowOverlayHelper shadowOverlayHelper = this.mShadowOverlayHelper;
        if (shadowOverlayHelper == null || !shadowOverlayHelper.needsOverlay()) {
            return;
        }
        this.mShadowOverlayHelper.setOverlayColor(view, viewHolder.mColorDimmer.getPaint().getColor());
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.mRoundedCornersEnabled;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        initStatics(viewGroup.getContext());
        ListRowView listRowView = new ListRowView(viewGroup.getContext());
        setupFadingEffect(listRowView);
        if (this.mRowHeight != 0) {
            listRowView.getGridView().setRowHeight(this.mRowHeight);
        }
        return new ViewHolder(listRowView, listRowView.getGridView(), this);
    }

    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void dispatchItemSelectedListener(RowPresenter.ViewHolder viewHolder, boolean z9) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        HorizontalGridView horizontalGridView = viewHolder2.mGridView;
        ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
        if (viewHolder3 == null) {
            super.dispatchItemSelectedListener(viewHolder, z9);
        } else {
            if (!z9 || viewHolder.getOnItemViewSelectedListener() == null) {
                return;
            }
            viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder3.getViewHolder(), viewHolder3.mItem, viewHolder2, viewHolder2.getRow());
        }
    }

    public final void enableChildRoundedCorners(boolean z9) {
        this.mRoundedCornersEnabled = z9;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void freeze(RowPresenter.ViewHolder viewHolder, boolean z9) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mGridView.setScrollEnabled(!z9);
        viewHolder2.mGridView.setAnimateChildLayout(!z9);
    }

    public int getExpandedRowHeight() {
        int i = this.mExpandedRowHeight;
        return i != 0 ? i : this.mRowHeight;
    }

    public final int getFocusZoomFactor() {
        return this.mFocusZoomFactor;
    }

    public final PresenterSelector getHoverCardPresenterSelector() {
        return this.mHoverCardPresenterSelector;
    }

    public int getRecycledPoolSize(Presenter presenter) {
        if (this.mRecycledPoolSize.containsKey(presenter)) {
            return this.mRecycledPoolSize.get(presenter).intValue();
        }
        return 24;
    }

    public int getRowHeight() {
        return this.mRowHeight;
    }

    public final boolean getShadowEnabled() {
        return this.mShadowEnabled;
    }

    @Deprecated
    public final int getZoomFactor() {
        return this.mFocusZoomFactor;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void initializeRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        super.initializeRowViewHolder(viewHolder);
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Context context = viewHolder.view.getContext();
        if (this.mShadowOverlayHelper == null) {
            ShadowOverlayHelper build = new ShadowOverlayHelper.Builder().needsOverlay(needsDefaultListSelectEffect()).needsShadow(needsDefaultShadow()).needsRoundedCorner(isUsingOutlineClipping(context) && areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.mKeepChildForeground).options(createShadowOverlayOptions()).build(context);
            this.mShadowOverlayHelper = build;
            if (build.needsWrapper()) {
                this.mShadowOverlayWrapper = new ItemBridgeAdapterShadowOverlayWrapper(this.mShadowOverlayHelper);
            }
        }
        ListRowPresenterItemBridgeAdapter listRowPresenterItemBridgeAdapter = new ListRowPresenterItemBridgeAdapter(viewHolder2);
        viewHolder2.mItemBridgeAdapter = listRowPresenterItemBridgeAdapter;
        listRowPresenterItemBridgeAdapter.setWrapper(this.mShadowOverlayWrapper);
        this.mShadowOverlayHelper.prepareParentForShadow(viewHolder2.mGridView);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder2.mItemBridgeAdapter, this.mFocusZoomFactor, this.mUseFocusDimmer);
        viewHolder2.mGridView.setFocusDrawingOrderEnabled(this.mShadowOverlayHelper.getShadowType() != 3);
        viewHolder2.mGridView.setOnChildSelectedListener(new OnChildSelectedListener() { // from class: androidx.leanback.widget.ListRowPresenter.1
            @Override // androidx.leanback.widget.OnChildSelectedListener
            public void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
                ListRowPresenter.this.selectChildView(viewHolder2, view, true);
            }
        });
        viewHolder2.mGridView.setOnUnhandledKeyListener(new BaseGridView.OnUnhandledKeyListener() { // from class: androidx.leanback.widget.ListRowPresenter.2
            @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                return viewHolder2.getOnKeyListener() != null && viewHolder2.getOnKeyListener().onKey(viewHolder2.view, keyEvent.getKeyCode(), keyEvent);
            }
        });
        viewHolder2.mGridView.setNumRows(this.mNumRows);
    }

    public final boolean isFocusDimmerUsed() {
        return this.mUseFocusDimmer;
    }

    public final boolean isKeepChildForeground() {
        return this.mKeepChildForeground;
    }

    public boolean isUsingDefaultListSelectEffect() {
        return true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingOutlineClipping(Context context) {
        return !Settings.getInstance(context).isOutlineClippingDisabled();
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    public final boolean needsDefaultListSelectEffect() {
        return isUsingDefaultListSelectEffect() && getSelectEffectEnabled();
    }

    public final boolean needsDefaultShadow() {
        return isUsingDefaultShadow() && getShadowEnabled();
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ListRow listRow = (ListRow) obj;
        viewHolder2.mItemBridgeAdapter.setAdapter(listRow.getAdapter());
        viewHolder2.mGridView.setAdapter(viewHolder2.mItemBridgeAdapter);
        viewHolder2.mGridView.setContentDescription(listRow.getContentDescription());
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewExpanded(RowPresenter.ViewHolder viewHolder, boolean z9) {
        super.onRowViewExpanded(viewHolder, z9);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (getRowHeight() != getExpandedRowHeight()) {
            viewHolder2.getGridView().setRowHeight(z9 ? getExpandedRowHeight() : getRowHeight());
        }
        setVerticalPadding(viewHolder2);
        updateFooterViewSwitcher(viewHolder2);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z9) {
        super.onRowViewSelected(viewHolder, z9);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        setVerticalPadding(viewHolder2);
        updateFooterViewSwitcher(viewHolder2);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int childCount = viewHolder2.mGridView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            applySelectLevelToChild(viewHolder2, viewHolder2.mGridView.getChildAt(i));
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mGridView.setAdapter(null);
        viewHolder2.mItemBridgeAdapter.clear();
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void selectChildView(ViewHolder viewHolder, View view, boolean z9) {
        if (view == null) {
            if (this.mHoverCardPresenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.unselect();
            }
            if (!z9 || viewHolder.getOnItemViewSelectedListener() == null) {
                return;
            }
            viewHolder.getOnItemViewSelectedListener().onItemSelected(null, null, viewHolder, viewHolder.mRow);
            return;
        }
        if (viewHolder.mSelected) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder.mGridView.getChildViewHolder(view);
            if (this.mHoverCardPresenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.select(viewHolder.mGridView, view, viewHolder2.mItem);
            }
            if (!z9 || viewHolder.getOnItemViewSelectedListener() == null) {
                return;
            }
            viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder2.mHolder, viewHolder2.mItem, viewHolder, viewHolder.mRow);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void setEntranceTransitionState(RowPresenter.ViewHolder viewHolder, boolean z9) {
        super.setEntranceTransitionState(viewHolder, z9);
        ((ViewHolder) viewHolder).mGridView.setChildrenVisibility(z9 ? 0 : 4);
    }

    public void setExpandedRowHeight(int i) {
        this.mExpandedRowHeight = i;
    }

    public final void setHoverCardPresenterSelector(PresenterSelector presenterSelector) {
        this.mHoverCardPresenterSelector = presenterSelector;
    }

    public final void setKeepChildForeground(boolean z9) {
        this.mKeepChildForeground = z9;
    }

    public void setNumRows(int i) {
        this.mNumRows = i;
    }

    public void setRecycledPoolSize(Presenter presenter, int i) {
        this.mRecycledPoolSize.put(presenter, Integer.valueOf(i));
    }

    public void setRowHeight(int i) {
        this.mRowHeight = i;
    }

    public final void setShadowEnabled(boolean z9) {
        this.mShadowEnabled = z9;
    }

    public ListRowPresenter(int i) {
        this(i, false);
    }

    public ListRowPresenter() {
        this(2);
    }
}
