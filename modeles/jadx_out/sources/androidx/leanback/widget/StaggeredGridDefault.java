package androidx.leanback.widget;

import androidx.leanback.widget.Grid;
import androidx.leanback.widget.StaggeredGrid;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class StaggeredGridDefault extends StaggeredGrid {
    private int findRowEdgeLimitSearchIndex(boolean z9) {
        boolean z10 = false;
        if (z9) {
            for (int i = this.mLastVisibleIndex; i >= this.mFirstVisibleIndex; i--) {
                int i6 = getLocation(i).mRow;
                if (i6 == 0) {
                    z10 = true;
                } else if (z10 && i6 == this.mNumRows - 1) {
                    return i;
                }
            }
            return -1;
        }
        for (int i10 = this.mFirstVisibleIndex; i10 <= this.mLastVisibleIndex; i10++) {
            int i11 = getLocation(i10).mRow;
            if (i11 == this.mNumRows - 1) {
                z10 = true;
            } else if (z10 && i11 == 0) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c3, code lost:
    
        if (r10 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c5, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c6, code lost:
    
        r9 = r9 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00e3, code lost:
    
        if (r10 != false) goto L67;
     */
    @Override // androidx.leanback.widget.StaggeredGrid
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean appendVisibleItemsWithoutCache(int r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.appendVisibleItemsWithoutCache(int, boolean):boolean");
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMax(boolean z9, int i, int[] iArr) {
        int i6;
        int edge = this.mProvider.getEdge(i);
        StaggeredGrid.Location location = getLocation(i);
        int i10 = location.mRow;
        if (this.mReversedFlow) {
            i6 = i10;
            int i11 = i6;
            int i12 = 1;
            int i13 = edge;
            for (int i14 = i + 1; i12 < this.mNumRows && i14 <= this.mLastVisibleIndex; i14++) {
                StaggeredGrid.Location location2 = getLocation(i14);
                i13 += location2.mOffset;
                int i15 = location2.mRow;
                if (i15 != i11) {
                    i12++;
                    if (!z9 ? i13 >= edge : i13 <= edge) {
                        i11 = i15;
                    } else {
                        edge = i13;
                        i = i14;
                        i6 = i15;
                        i11 = i6;
                    }
                }
            }
        } else {
            int i16 = 1;
            int i17 = i10;
            StaggeredGrid.Location location3 = location;
            int i18 = edge;
            edge = this.mProvider.getSize(i) + edge;
            i6 = i17;
            for (int i19 = i - 1; i16 < this.mNumRows && i19 >= this.mFirstVisibleIndex; i19--) {
                i18 -= location3.mOffset;
                location3 = getLocation(i19);
                int i20 = location3.mRow;
                if (i20 != i17) {
                    i16++;
                    int size = this.mProvider.getSize(i19) + i18;
                    if (!z9 ? size >= edge : size <= edge) {
                        i17 = i20;
                    } else {
                        edge = size;
                        i = i19;
                        i6 = i20;
                        i17 = i6;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i;
        }
        return edge;
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMin(boolean z9, int i, int[] iArr) {
        int i6;
        int edge = this.mProvider.getEdge(i);
        StaggeredGrid.Location location = getLocation(i);
        int i10 = location.mRow;
        if (this.mReversedFlow) {
            int i11 = 1;
            i6 = edge - this.mProvider.getSize(i);
            int i12 = i10;
            for (int i13 = i - 1; i11 < this.mNumRows && i13 >= this.mFirstVisibleIndex; i13--) {
                edge -= location.mOffset;
                location = getLocation(i13);
                int i14 = location.mRow;
                if (i14 != i12) {
                    i11++;
                    int size = edge - this.mProvider.getSize(i13);
                    if (!z9 ? size >= i6 : size <= i6) {
                        i12 = i14;
                    } else {
                        i6 = size;
                        i = i13;
                        i10 = i14;
                        i12 = i10;
                    }
                }
            }
        } else {
            int i15 = i10;
            int i16 = i15;
            int i17 = 1;
            int i18 = edge;
            for (int i19 = i + 1; i17 < this.mNumRows && i19 <= this.mLastVisibleIndex; i19++) {
                StaggeredGrid.Location location2 = getLocation(i19);
                i18 += location2.mOffset;
                int i20 = location2.mRow;
                if (i20 != i16) {
                    i17++;
                    if (!z9 ? i18 >= edge : i18 <= edge) {
                        i16 = i20;
                    } else {
                        edge = i18;
                        i = i19;
                        i15 = i20;
                        i16 = i15;
                    }
                }
            }
            i6 = edge;
            i10 = i15;
        }
        if (iArr != null) {
            iArr[0] = i10;
            iArr[1] = i;
        }
        return i6;
    }

    public int getRowMax(int i) {
        int i6;
        StaggeredGrid.Location location;
        int i10 = this.mFirstVisibleIndex;
        if (i10 < 0) {
            return Integer.MIN_VALUE;
        }
        boolean z9 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        if (z9) {
            int edge = provider.getEdge(i10);
            if (getLocation(this.mFirstVisibleIndex).mRow == i) {
                return edge;
            }
            int i11 = this.mFirstVisibleIndex;
            do {
                i11++;
                if (i11 <= getLastIndex()) {
                    location = getLocation(i11);
                    edge += location.mOffset;
                }
            } while (location.mRow != i);
            return edge;
        }
        int edge2 = provider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i) {
            i6 = location2.mSize;
        } else {
            int i12 = this.mLastVisibleIndex;
            do {
                i12--;
                if (i12 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i12);
                }
            } while (location2.mRow != i);
            i6 = location2.mSize;
        }
        return edge2 + i6;
        return Integer.MIN_VALUE;
    }

    public int getRowMin(int i) {
        StaggeredGrid.Location location;
        int i6;
        int i10 = this.mFirstVisibleIndex;
        if (i10 < 0) {
            return Integer.MAX_VALUE;
        }
        boolean z9 = this.mReversedFlow;
        Grid.Provider provider = this.mProvider;
        if (!z9) {
            int edge = provider.getEdge(i10);
            if (getLocation(this.mFirstVisibleIndex).mRow == i) {
                return edge;
            }
            int i11 = this.mFirstVisibleIndex;
            do {
                i11++;
                if (i11 <= getLastIndex()) {
                    location = getLocation(i11);
                    edge += location.mOffset;
                }
            } while (location.mRow != i);
            return edge;
        }
        int edge2 = provider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i) {
            i6 = location2.mSize;
        } else {
            int i12 = this.mLastVisibleIndex;
            do {
                i12--;
                if (i12 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i12);
                }
            } while (location2.mRow != i);
            i6 = location2.mSize;
        }
        return edge2 - i6;
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
    
        if (r9 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
    
        r8 = r8 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0125, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00e0, code lost:
    
        if (r9 != false) goto L66;
     */
    @Override // androidx.leanback.widget.StaggeredGrid
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean prependVisibleItemsWithoutCache(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.prependVisibleItemsWithoutCache(int, boolean):boolean");
    }
}
