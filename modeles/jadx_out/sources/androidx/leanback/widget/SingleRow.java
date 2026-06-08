package androidx.leanback.widget;

import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class SingleRow extends Grid {
    private final Grid.Location mTmpLocation = new Grid.Location(0);

    public SingleRow() {
        setNumRows(1);
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean appendVisibleItems(int i, boolean z9) {
        int i6;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkAppendOverLimit(i)) {
            return false;
        }
        int startIndexForAppend = getStartIndexForAppend();
        boolean z10 = false;
        while (startIndexForAppend < this.mProvider.getCount()) {
            int createItem = this.mProvider.createItem(startIndexForAppend, true, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                i6 = this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.mFirstVisibleIndex = startIndexForAppend;
                this.mLastVisibleIndex = startIndexForAppend;
            } else {
                boolean z11 = this.mReversedFlow;
                Grid.Provider provider = this.mProvider;
                if (z11) {
                    int i10 = startIndexForAppend - 1;
                    i6 = (provider.getEdge(i10) - this.mProvider.getSize(i10)) - this.mSpacing;
                } else {
                    int i11 = startIndexForAppend - 1;
                    i6 = provider.getEdge(i11) + this.mProvider.getSize(i11) + this.mSpacing;
                }
                this.mLastVisibleIndex = startIndexForAppend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForAppend, createItem, 0, i6);
            if (z9 || checkAppendOverLimit(i)) {
                return true;
            }
            startIndexForAppend++;
            z10 = true;
        }
        return z10;
    }

    @Override // androidx.leanback.widget.Grid
    public void collectAdjacentPrefetchPositions(int i, int i6, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int startIndexForPrepend;
        int i10;
        if (!this.mReversedFlow ? i6 < 0 : i6 > 0) {
            if (getLastVisibleIndex() == this.mProvider.getCount() - 1) {
                return;
            }
            startIndexForPrepend = getStartIndexForAppend();
            int size = this.mProvider.getSize(this.mLastVisibleIndex) + this.mSpacing;
            int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
            if (this.mReversedFlow) {
                size = -size;
            }
            i10 = size + edge;
        } else {
            if (getFirstVisibleIndex() == 0) {
                return;
            }
            startIndexForPrepend = getStartIndexForPrepend();
            int edge2 = this.mProvider.getEdge(this.mFirstVisibleIndex);
            boolean z9 = this.mReversedFlow;
            int i11 = this.mSpacing;
            if (!z9) {
                i11 = -i11;
            }
            i10 = edge2 + i11;
        }
        layoutPrefetchRegistry.addPosition(startIndexForPrepend, Math.abs(i10 - i));
    }

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        printWriter.print("SingleRow<");
        printWriter.print(this.mFirstVisibleIndex);
        printWriter.print(",");
        printWriter.print(this.mLastVisibleIndex);
        printWriter.print(">");
        printWriter.println();
    }

    @Override // androidx.leanback.widget.Grid
    public final int findRowMax(boolean z9, int i, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i;
        }
        boolean z10 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        return z10 ? provider.getEdge(i) : provider.getEdge(i) + this.mProvider.getSize(i);
    }

    @Override // androidx.leanback.widget.Grid
    public final int findRowMin(boolean z9, int i, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i;
        }
        boolean z10 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        return z10 ? provider.getEdge(i) - this.mProvider.getSize(i) : provider.getEdge(i);
    }

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i, int i6) {
        this.mTmpItemPositionsInRows[0].clear();
        this.mTmpItemPositionsInRows[0].addLast(i);
        this.mTmpItemPositionsInRows[0].addLast(i6);
        return this.mTmpItemPositionsInRows;
    }

    @Override // androidx.leanback.widget.Grid
    public final Grid.Location getLocation(int i) {
        return this.mTmpLocation;
    }

    public int getStartIndexForAppend() {
        int i = this.mLastVisibleIndex;
        if (i >= 0) {
            return i + 1;
        }
        int i6 = this.mStartIndex;
        if (i6 != -1) {
            return Math.min(i6, this.mProvider.getCount() - 1);
        }
        return 0;
    }

    public int getStartIndexForPrepend() {
        int i = this.mFirstVisibleIndex;
        if (i >= 0) {
            return i - 1;
        }
        int i6 = this.mStartIndex;
        Grid.Provider provider = this.mProvider;
        return i6 != -1 ? Math.min(i6, provider.getCount() - 1) : provider.getCount() - 1;
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean prependVisibleItems(int i, boolean z9) {
        int i6;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkPrependOverLimit(i)) {
            return false;
        }
        int minIndex = this.mProvider.getMinIndex();
        boolean z10 = false;
        for (int startIndexForPrepend = getStartIndexForPrepend(); startIndexForPrepend >= minIndex; startIndexForPrepend--) {
            int createItem = this.mProvider.createItem(startIndexForPrepend, false, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                i6 = this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.mFirstVisibleIndex = startIndexForPrepend;
                this.mLastVisibleIndex = startIndexForPrepend;
            } else {
                boolean z11 = this.mReversedFlow;
                Grid.Provider provider = this.mProvider;
                i6 = z11 ? provider.getEdge(startIndexForPrepend + 1) + this.mSpacing + createItem : (provider.getEdge(startIndexForPrepend + 1) - this.mSpacing) - createItem;
                this.mFirstVisibleIndex = startIndexForPrepend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForPrepend, createItem, 0, i6);
            z10 = true;
            if (z9 || checkPrependOverLimit(i)) {
                break;
            }
        }
        return z10;
    }
}
