package androidx.leanback.widget;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import java.io.PrintWriter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class StaggeredGrid extends Grid {
    protected Object mPendingItem;
    protected int mPendingItemSize;
    protected CircularArray<Location> mLocations = new CircularArray<>(64);
    protected int mFirstIndex = -1;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Location extends Grid.Location {
        int mOffset;
        int mSize;

        public Location(int i, int i6, int i10) {
            super(i);
            this.mOffset = i6;
            this.mSize = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0039 -> B:10:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int calculateOffsetAfterLastItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.getLastIndex()
        L4:
            int r1 = r2.mFirstIndex
            if (r0 < r1) goto L14
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mRow
            if (r1 != r3) goto L11
            goto L18
        L11:
            int r0 = r0 + (-1)
            goto L4
        L14:
            int r0 = r2.getLastIndex()
        L18:
            boolean r3 = r2.isReversedFlow()
            if (r3 == 0) goto L28
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r3 = -r3
            int r1 = r2.mSpacing
            goto L3f
        L28:
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r1 = r2.mSpacing
            int r3 = r3 + r1
        L31:
            int r0 = r0 + 1
            int r1 = r2.getLastIndex()
            if (r0 > r1) goto L41
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mOffset
        L3f:
            int r3 = r3 - r1
            goto L31
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGrid.calculateOffsetAfterLastItem(int):int");
    }

    public final boolean appendVisbleItemsWithCache(int i, boolean z9) {
        int i6;
        int i10;
        int i11;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int count = this.mProvider.getCount();
        int i12 = this.mLastVisibleIndex;
        if (i12 >= 0) {
            i6 = i12 + 1;
            i10 = this.mProvider.getEdge(i12);
        } else {
            int i13 = this.mStartIndex;
            i6 = i13 != -1 ? i13 : 0;
            if (i6 > getLastIndex() + 1 || i6 < getFirstIndex()) {
                this.mLocations.clear();
                return false;
            }
            if (i6 > getLastIndex()) {
                return false;
            }
            i10 = Integer.MAX_VALUE;
        }
        int lastIndex = getLastIndex();
        int i14 = i6;
        while (i14 < count && i14 <= lastIndex) {
            Location location = getLocation(i14);
            if (i10 != Integer.MAX_VALUE) {
                i10 += location.mOffset;
            }
            int i15 = i10;
            int i16 = location.mRow;
            int createItem = this.mProvider.createItem(i14, true, this.mTmpItem, false);
            if (createItem != location.mSize) {
                location.mSize = createItem;
                this.mLocations.removeFromEnd(lastIndex - i14);
                i11 = i14;
            } else {
                i11 = lastIndex;
            }
            this.mLastVisibleIndex = i14;
            if (this.mFirstVisibleIndex < 0) {
                this.mFirstVisibleIndex = i14;
            }
            this.mProvider.addItem(this.mTmpItem[0], i14, createItem, i16, i15);
            if (!z9 && checkAppendOverLimit(i)) {
                return true;
            }
            int edge = i15 == Integer.MAX_VALUE ? this.mProvider.getEdge(i14) : i15;
            if (i16 == this.mNumRows - 1 && z9) {
                return true;
            }
            i14++;
            lastIndex = i11;
            i10 = edge;
        }
        return false;
    }

    public final int appendVisibleItemToRow(int i, int i6, int i10) {
        int i11 = this.mLastVisibleIndex;
        if (i11 >= 0 && (i11 != getLastIndex() || this.mLastVisibleIndex != i - 1)) {
            throw new IllegalStateException();
        }
        int i12 = this.mLastVisibleIndex;
        Location location = new Location(i6, i12 < 0 ? (this.mLocations.size() <= 0 || i != getLastIndex() + 1) ? 0 : calculateOffsetAfterLastItem(i6) : i10 - this.mProvider.getEdge(i12), 0);
        this.mLocations.addLast(location);
        Object obj = this.mPendingItem;
        if (obj != null) {
            location.mSize = this.mPendingItemSize;
            this.mPendingItem = null;
        } else {
            location.mSize = this.mProvider.createItem(i, true, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        if (this.mLocations.size() == 1) {
            this.mLastVisibleIndex = i;
            this.mFirstVisibleIndex = i;
            this.mFirstIndex = i;
        } else {
            int i13 = this.mLastVisibleIndex;
            if (i13 < 0) {
                this.mLastVisibleIndex = i;
                this.mFirstVisibleIndex = i;
            } else {
                this.mLastVisibleIndex = i13 + 1;
            }
        }
        this.mProvider.addItem(obj2, i, location.mSize, i6, i10);
        return location.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean appendVisibleItems(int i, boolean z9) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkAppendOverLimit(i)) {
            return false;
        }
        try {
            if (!appendVisbleItemsWithCache(i, z9)) {
                return appendVisibleItemsWithoutCache(i, z9);
            }
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return true;
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    public abstract boolean appendVisibleItemsWithoutCache(int i, boolean z9);

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        int size = this.mLocations.size();
        for (int i = 0; i < size; i++) {
            printWriter.print("<" + (this.mFirstIndex + i) + "," + this.mLocations.get(i).mRow + ">");
            printWriter.print(" ");
            printWriter.println();
        }
    }

    public final int getFirstIndex() {
        return this.mFirstIndex;
    }

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i, int i6) {
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            this.mTmpItemPositionsInRows[i10].clear();
        }
        if (i >= 0) {
            while (i <= i6) {
                CircularIntArray circularIntArray = this.mTmpItemPositionsInRows[getLocation(i).mRow];
                if (circularIntArray.size() <= 0 || circularIntArray.getLast() != i - 1) {
                    circularIntArray.addLast(i);
                    circularIntArray.addLast(i);
                } else {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i);
                }
                i++;
            }
        }
        return this.mTmpItemPositionsInRows;
    }

    public final int getLastIndex() {
        return (this.mLocations.size() + this.mFirstIndex) - 1;
    }

    @Override // androidx.leanback.widget.Grid
    public final Location getLocation(int i) {
        int i6 = i - this.mFirstIndex;
        if (i6 < 0 || i6 >= this.mLocations.size()) {
            return null;
        }
        return this.mLocations.get(i6);
    }

    public final int getSize() {
        return this.mLocations.size();
    }

    @Override // androidx.leanback.widget.Grid
    public void invalidateItemsAfter(int i) {
        super.invalidateItemsAfter(i);
        this.mLocations.removeFromEnd((getLastIndex() - i) + 1);
        if (this.mLocations.size() == 0) {
            this.mFirstIndex = -1;
        }
    }

    public final boolean prependVisbleItemsWithCache(int i, boolean z9) {
        int i6;
        int i10;
        int i11;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int i12 = this.mFirstVisibleIndex;
        if (i12 >= 0) {
            i10 = this.mProvider.getEdge(i12);
            i11 = getLocation(this.mFirstVisibleIndex).mOffset;
            i6 = this.mFirstVisibleIndex - 1;
        } else {
            int i13 = this.mStartIndex;
            i6 = i13 != -1 ? i13 : 0;
            if (i6 > getLastIndex() || i6 < getFirstIndex() - 1) {
                this.mLocations.clear();
                return false;
            }
            if (i6 < getFirstIndex()) {
                return false;
            }
            i10 = Integer.MAX_VALUE;
            i11 = 0;
        }
        int max = Math.max(this.mProvider.getMinIndex(), this.mFirstIndex);
        for (int i14 = i6; i14 >= max; i14--) {
            Location location = getLocation(i14);
            int i15 = location.mRow;
            int createItem = this.mProvider.createItem(i14, false, this.mTmpItem, false);
            if (createItem != location.mSize) {
                this.mLocations.removeFromStart((i14 + 1) - this.mFirstIndex);
                this.mFirstIndex = this.mFirstVisibleIndex;
                this.mPendingItem = this.mTmpItem[0];
                this.mPendingItemSize = createItem;
                return false;
            }
            this.mFirstVisibleIndex = i14;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i14;
            }
            this.mProvider.addItem(this.mTmpItem[0], i14, createItem, i15, i10 - i11);
            if (!z9 && checkPrependOverLimit(i)) {
                return true;
            }
            i10 = this.mProvider.getEdge(i14);
            i11 = location.mOffset;
            if (i15 == 0 && z9) {
                return true;
            }
        }
        return false;
    }

    public final int prependVisibleItemToRow(int i, int i6, int i10) {
        int i11 = this.mFirstVisibleIndex;
        if (i11 >= 0 && (i11 != getFirstIndex() || this.mFirstVisibleIndex != i + 1)) {
            throw new IllegalStateException();
        }
        int i12 = this.mFirstIndex;
        Location location = i12 >= 0 ? getLocation(i12) : null;
        int edge = this.mProvider.getEdge(this.mFirstIndex);
        Location location2 = new Location(i6, 0, 0);
        this.mLocations.addFirst(location2);
        Object obj = this.mPendingItem;
        if (obj != null) {
            location2.mSize = this.mPendingItemSize;
            this.mPendingItem = null;
        } else {
            location2.mSize = this.mProvider.createItem(i, false, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        this.mFirstVisibleIndex = i;
        this.mFirstIndex = i;
        if (this.mLastVisibleIndex < 0) {
            this.mLastVisibleIndex = i;
        }
        boolean z9 = this.mReversedFlow;
        int i13 = location2.mSize;
        int i14 = !z9 ? i10 - i13 : i10 + i13;
        if (location != null) {
            location.mOffset = edge - i14;
        }
        this.mProvider.addItem(obj2, i, location2.mSize, i6, i14);
        return location2.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    public final boolean prependVisibleItems(int i, boolean z9) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z9 && checkPrependOverLimit(i)) {
            return false;
        }
        try {
            if (!prependVisbleItemsWithCache(i, z9)) {
                return prependVisibleItemsWithoutCache(i, z9);
            }
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return true;
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    public abstract boolean prependVisibleItemsWithoutCache(int i, boolean z9);
}
