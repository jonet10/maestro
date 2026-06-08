package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class Grid {
    static final int START_DEFAULT = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected CircularIntArray[] mTmpItemPositionsInRows;
    Object[] mTmpItem = new Object[1];
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mStartIndex = -1;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Location {
        int mRow;

        public Location(int i) {
            this.mRow = i;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Provider {
        void addItem(Object obj, int i, int i6, int i10, int i11);

        int createItem(int i, boolean z9, Object[] objArr, boolean z10);

        int getCount();

        int getEdge(int i);

        int getMinIndex();

        int getSize(int i);

        void removeItem(int i);
    }

    public static Grid createGrid(int i) {
        if (i == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i);
        return staggeredGridDefault;
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        return appendVisibleItems(this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public final void appendVisibleItems(int i) {
        appendVisibleItems(i, false);
    }

    public abstract boolean appendVisibleItems(int i, boolean z9);

    public final boolean checkAppendOverLimit(int i) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        return this.mReversedFlow ? findRowMin(true, null) <= i + this.mSpacing : findRowMax(false, null) >= i - this.mSpacing;
    }

    public final boolean checkPrependOverLimit(int i) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        return this.mReversedFlow ? findRowMax(false, null) >= i - this.mSpacing : findRowMin(true, null) <= i + this.mSpacing;
    }

    public abstract void debugPrint(PrintWriter printWriter);

    public void fillDisappearingItems(int[] iArr, int i, SparseIntArray sparseIntArray) {
        int lastVisibleIndex = getLastVisibleIndex();
        int binarySearch = lastVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i, lastVisibleIndex) : 0;
        if (binarySearch < 0) {
            boolean z9 = this.mReversedFlow;
            Provider provider = this.mProvider;
            int edge = z9 ? (provider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing : provider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            for (int i6 = (-binarySearch) - 1; i6 < i; i6++) {
                int i10 = iArr[i6];
                int i11 = sparseIntArray.get(i10);
                int i12 = i11 < 0 ? 0 : i11;
                int createItem = this.mProvider.createItem(i10, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i10, createItem, i12, edge);
                boolean z10 = this.mReversedFlow;
                int i13 = this.mSpacing;
                edge = z10 ? (edge - createItem) - i13 : edge + createItem + i13;
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        int binarySearch2 = firstVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i, firstVisibleIndex) : 0;
        if (binarySearch2 < 0) {
            int i14 = (-binarySearch2) - 2;
            boolean z11 = this.mReversedFlow;
            Provider provider2 = this.mProvider;
            int edge2 = z11 ? provider2.getEdge(firstVisibleIndex) : provider2.getEdge(firstVisibleIndex);
            while (i14 >= 0) {
                int i15 = iArr[i14];
                int i16 = sparseIntArray.get(i15);
                int i17 = i16 < 0 ? 0 : i16;
                int createItem2 = this.mProvider.createItem(i15, false, this.mTmpItem, true);
                boolean z12 = this.mReversedFlow;
                int i18 = this.mSpacing;
                int i19 = z12 ? edge2 + i18 + createItem2 : (edge2 - i18) - createItem2;
                this.mProvider.addItem(this.mTmpItem[0], i15, createItem2, i17, i19);
                i14--;
                edge2 = i19;
            }
        }
    }

    public abstract int findRowMax(boolean z9, int i, int[] iArr);

    public final int findRowMax(boolean z9, int[] iArr) {
        return findRowMax(z9, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    public abstract int findRowMin(boolean z9, int i, int[] iArr);

    public final int findRowMin(boolean z9, int[] iArr) {
        return findRowMin(z9, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract CircularIntArray[] getItemPositionsInRows(int i, int i6);

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public abstract Location getLocation(int i);

    public int getNumRows() {
        return this.mNumRows;
    }

    public final int getRowIndex(int i) {
        Location location = getLocation(i);
        if (location == null) {
            return -1;
        }
        return location.mRow;
    }

    public void invalidateItemsAfter(int i) {
        int i6;
        if (i >= 0 && (i6 = this.mLastVisibleIndex) >= 0) {
            if (i6 >= i) {
                this.mLastVisibleIndex = i - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public final boolean prependOneColumnVisibleItems() {
        return prependVisibleItems(this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public final void prependVisibleItems(int i) {
        prependVisibleItems(i, false);
    }

    public abstract boolean prependVisibleItems(int i, boolean z9);

    public void removeInvisibleItemsAtEnd(int i, int i6) {
        while (true) {
            int i10 = this.mLastVisibleIndex;
            if (i10 < this.mFirstVisibleIndex || i10 <= i) {
                break;
            }
            boolean z9 = this.mReversedFlow;
            Provider provider = this.mProvider;
            if (!z9) {
                if (provider.getEdge(i10) < i6) {
                    break;
                }
                this.mProvider.removeItem(this.mLastVisibleIndex);
                this.mLastVisibleIndex--;
            } else {
                if (provider.getEdge(i10) > i6) {
                    break;
                }
                this.mProvider.removeItem(this.mLastVisibleIndex);
                this.mLastVisibleIndex--;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i, int i6) {
        while (true) {
            int i10 = this.mLastVisibleIndex;
            int i11 = this.mFirstVisibleIndex;
            if (i10 < i11 || i11 >= i) {
                break;
            }
            int size = this.mProvider.getSize(i11);
            boolean z9 = this.mReversedFlow;
            Provider provider = this.mProvider;
            if (!z9) {
                if (provider.getEdge(this.mFirstVisibleIndex) + size > i6) {
                    break;
                }
                this.mProvider.removeItem(this.mFirstVisibleIndex);
                this.mFirstVisibleIndex++;
            } else {
                if (provider.getEdge(this.mFirstVisibleIndex) - size < i6) {
                    break;
                }
                this.mProvider.removeItem(this.mFirstVisibleIndex);
                this.mFirstVisibleIndex++;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    public void setNumRows(int i) {
        if (i <= 0) {
            o.n();
            return;
        }
        if (this.mNumRows == i) {
            return;
        }
        this.mNumRows = i;
        this.mTmpItemPositionsInRows = new CircularIntArray[i];
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            this.mTmpItemPositionsInRows[i6] = new CircularIntArray();
        }
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public final void setReversedFlow(boolean z9) {
        this.mReversedFlow = z9;
    }

    public final void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setStart(int i) {
        this.mStartIndex = i;
    }

    public void collectAdjacentPrefetchPositions(int i, int i6, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }
}
