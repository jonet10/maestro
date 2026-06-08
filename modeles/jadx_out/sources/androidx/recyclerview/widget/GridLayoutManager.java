package androidx.recyclerview.widget;

import a3.b;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "GridLayoutManager";
    private static final Set<Integer> sSupportedDirectionsForActionScrollInDirection = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    int[] mCachedBorders;
    int mColumnWithAccessibilityFocus;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    private int mPositionTargetedByScrollInDirection;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    int mRowWithAccessibilityFocus;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean isAccessibilityFocused(@NonNull View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i6) {
            return i % i6;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i6 = 0;
            while (i6 <= size) {
                int i10 = (i6 + size) >>> 1;
                if (sparseIntArray.keyAt(i10) < i) {
                    i6 = i10 + 1;
                } else {
                    size = i10 - 1;
                }
            }
            int i11 = i6 - 1;
            if (i11 < 0 || i11 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i11);
        }

        public int getCachedSpanGroupIndex(int i, int i6) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i6);
            }
            int i10 = this.mSpanGroupIndexCache.get(i, -1);
            if (i10 != -1) {
                return i10;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i6);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i, int i6) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i6);
            }
            int i10 = this.mSpanIndexCache.get(i, -1);
            if (i10 != -1) {
                return i10;
            }
            int spanIndex = getSpanIndex(i, i6);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i6) {
            int i10;
            int i11;
            int i12;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) == -1) {
                i10 = 0;
                i11 = 0;
                i12 = 0;
            } else {
                i11 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i12 = findFirstKeyLessThan + 1;
                i10 = getSpanSize(findFirstKeyLessThan) + getCachedSpanIndex(findFirstKeyLessThan, i6);
                if (i10 == i6) {
                    i11++;
                    i10 = 0;
                }
            }
            int spanSize = getSpanSize(i);
            while (i12 < i) {
                int spanSize2 = getSpanSize(i12);
                i10 += spanSize2;
                if (i10 == i6) {
                    i11++;
                    i10 = 0;
                } else if (i10 > i6) {
                    i11++;
                    i10 = spanSize2;
                }
                i12++;
            }
            return i10 + spanSize > i6 ? i11 + 1 : i11;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                goto L30
            L20:
                r2 = r1
                r4 = r2
            L22:
                if (r2 >= r6) goto L33
                int r3 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                if (r4 != r7) goto L2d
                r4 = r1
                goto L30
            L2d:
                if (r4 <= r7) goto L30
                r4 = r3
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r4
                if (r0 > r7) goto L37
                return r4
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z9) {
            if (!z9) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z9;
        }

        public void setSpanIndexCacheEnabled(boolean z9) {
            if (!z9) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z9;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i6) {
        super(context, attributeSet, i, i6);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i6).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, boolean z9) {
        int i6;
        int i10;
        int i11;
        int i12 = 0;
        if (z9) {
            i11 = 1;
            i10 = i;
            i6 = 0;
        } else {
            i6 = i - 1;
            i10 = -1;
            i11 = -1;
        }
        while (i6 != i10) {
            View view = this.mSet[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i12;
            i12 += spanSize;
            i6 += i11;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    public static int[] calculateItemBorders(int[] iArr, int i, int i6) {
        int i10;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i6) {
            iArr = new int[i + 1];
        }
        int i11 = 0;
        iArr[0] = 0;
        int i12 = i6 / i;
        int i13 = i6 % i;
        int i14 = 0;
        for (int i15 = 1; i15 <= i; i15++) {
            i11 += i13;
            if (i11 <= 0 || i - i11 >= i13) {
                i10 = i12;
            } else {
                i10 = i12 + 1;
                i11 -= i;
            }
            i14 += i10;
            iArr[i15] = i14;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int max = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (isSmoothScrollbarEnabled) {
                    return Math.round((max * (Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)));
                }
                return max;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((decoratedEnd / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z9 = i == 1;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z9) {
            while (spanIndex > 0) {
                int i6 = anchorInfo.mPosition;
                if (i6 <= 0) {
                    return;
                }
                int i10 = i6 - 1;
                anchorInfo.mPosition = i10;
                spanIndex = getSpanIndex(recycler, state, i10);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i11 = anchorInfo.mPosition;
        while (i11 < itemCount) {
            int i12 = i11 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i12);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i11 = i12;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i11;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    @Nullable
    private View findChildWithAccessibilityFocus() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Objects.requireNonNull(childAt);
            if (Api21Impl.isAccessibilityFocused(childAt)) {
                return getChildAt(i);
            }
        }
        return null;
    }

    private int findScrollTargetPositionAbove(int i, int i6, int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            int rowIndex = getRowIndex(i11);
            int columnIndex = getColumnIndex(i11);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex < i && getColumnIndices(i11).contains(Integer.valueOf(i6))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i11;
                }
            } else if (rowIndex < i && columnIndex == i6) {
                this.mRowWithAccessibilityFocus = ((Integer) Collections.max(getRowIndices(i11))).intValue();
                return i11;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionBelow(int i, int i6, int i10) {
        for (int i11 = i10 + 1; i11 < getItemCount(); i11++) {
            int rowIndex = getRowIndex(i11);
            int columnIndex = getColumnIndex(i11);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if (rowIndex > i && (columnIndex == i6 || getColumnIndices(i11).contains(Integer.valueOf(i6)))) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    return i11;
                }
            } else if (rowIndex > i && columnIndex == i6) {
                this.mRowWithAccessibilityFocus = getRowIndex(i11);
                return i11;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheLeft(int i, int i6, int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            int rowIndex = getRowIndex(i11);
            int columnIndex = getColumnIndex(i11);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i && columnIndex < i6) || rowIndex < i) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i11;
                }
            } else if (getRowIndices(i11).contains(Integer.valueOf(i)) && columnIndex < i6) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i11;
            }
        }
        return -1;
    }

    private int findScrollTargetPositionOnTheRight(int i, int i6, int i10) {
        for (int i11 = i10 + 1; i11 < getItemCount(); i11++) {
            int rowIndex = getRowIndex(i11);
            int columnIndex = getColumnIndex(i11);
            if (rowIndex < 0 || columnIndex < 0) {
                break;
            }
            if (this.mOrientation == 1) {
                if ((rowIndex == i && columnIndex > i6) || rowIndex > i) {
                    this.mRowWithAccessibilityFocus = rowIndex;
                    this.mColumnWithAccessibilityFocus = columnIndex;
                    return i11;
                }
            } else if (columnIndex > i6 && getRowIndices(i11).contains(Integer.valueOf(i))) {
                this.mColumnWithAccessibilityFocus = columnIndex;
                return i11;
            }
        }
        return -1;
    }

    private int getColumnIndex(int i) {
        int i6 = this.mOrientation;
        RecyclerView recyclerView = this.mRecyclerView;
        return i6 == 0 ? getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i) : getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i);
    }

    private Set<Integer> getColumnIndices(int i) {
        return getRowOrColumnIndices(getColumnIndex(i), i);
    }

    private int getRowIndex(int i) {
        int i6 = this.mOrientation;
        RecyclerView recyclerView = this.mRecyclerView;
        return i6 == 1 ? getSpanGroupIndex(recyclerView.mRecycler, recyclerView.mState, i) : getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i);
    }

    private Set<Integer> getRowIndices(int i) {
        return getRowOrColumnIndices(getRowIndex(i), i);
    }

    private Set<Integer> getRowOrColumnIndices(int i, int i6) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.mRecyclerView;
        int spanSize = getSpanSize(recyclerView.mRecycler, recyclerView.mState, i6);
        for (int i10 = i; i10 < i + spanSize; i10++) {
            hashSet.add(Integer.valueOf(i10));
        }
        return hashSet;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        l.z(i, "Cannot find span size for pre layout position. ", TAG);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i6 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i6 != -1) {
            return i6;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        l.z(i, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", TAG);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i6 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i6 != -1) {
            return i6;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        l.z(i, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", TAG);
        return 1;
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i));
    }

    private boolean hasAccessibilityFocusChanged(int i) {
        return (getRowIndices(i).contains(Integer.valueOf(this.mRowWithAccessibilityFocus)) && getColumnIndices(i).contains(Integer.valueOf(this.mColumnWithAccessibilityFocus))) ? false : true;
    }

    private void measureChild(View view, int i, boolean z9) {
        int i6;
        int i10;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i10 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i6 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i6 = childMeasureSpec;
            i10 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i10, i6, z9);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i6, boolean z9) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z9 ? shouldReMeasureChild(view, i, i6, layoutParams) : shouldMeasureChild(view, i, i6, layoutParams)) {
            view.measure(i, i6);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.mSpanCount;
        for (int i6 = 0; i6 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i6++) {
            int i10 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i10, Math.max(0, layoutState.mScrollingOffset));
            i -= this.mSpanSizeLookup.getSpanSize(i10);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(state) : super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(state) : super.computeVerticalScrollRange(state);
    }

    public int findPositionOfFirstItemOnARowBelowForHorizontalGrid(int i) {
        if (i < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap();
        for (int i6 = 0; i6 < getItemCount(); i6++) {
            for (Integer num : getRowIndices(i6)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                if (!treeMap.containsKey(num)) {
                    treeMap.put(num, Integer.valueOf(i6));
                }
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int intValue = num2.intValue();
            if (intValue > i) {
                int intValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.mRowWithAccessibilityFocus = intValue;
                this.mColumnWithAccessibilityFocus = 0;
                return intValue2;
            }
        }
        return -1;
    }

    public int findPositionOfLastItemOnARowAboveForHorizontalGrid(int i) {
        if (i < 0 || this.mOrientation == 1) {
            return -1;
        }
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        for (int i6 = 0; i6 < getItemCount(); i6++) {
            for (Integer num : getRowIndices(i6)) {
                if (num.intValue() < 0) {
                    return -1;
                }
                treeMap.put(num, Integer.valueOf(i6));
            }
        }
        for (Integer num2 : treeMap.keySet()) {
            int intValue = num2.intValue();
            if (intValue < i) {
                int intValue2 = ((Integer) treeMap.get(num2)).intValue();
                this.mRowWithAccessibilityFocus = intValue;
                this.mColumnWithAccessibilityFocus = getColumnIndex(intValue2);
                return intValue2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z9, boolean z10) {
        int i;
        int i6;
        int childCount = getChildCount();
        int i10 = 1;
        if (z10) {
            i6 = getChildCount() - 1;
            i = -1;
            i10 = -1;
        } else {
            i = childCount;
            i6 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i6 != i) {
            View childAt = getChildAt(i6);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i6 += i10;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i, int i6) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i6 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i10 = this.mSpanCount;
        return iArr2[i10 - i] - iArr2[(i10 - i) - i6];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        r20.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void layoutChunk(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, androidx.recyclerview.widget.LinearLayoutManager.LayoutState r19, androidx.recyclerview.widget.LinearLayoutManager.LayoutChunkResult r20) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, androidx.recyclerview.widget.LinearLayoutManager$LayoutState, androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f3, code lost:
    
        if (r13 == (r2 > r4)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        RecyclerView.Adapter adapter = this.mRecyclerView.mAdapter;
        if (adapter == null || adapter.getItemCount() <= 1) {
            return;
        }
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i6) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i6, int i10) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i6) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i6, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        View findViewByPosition;
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
        int i = this.mPositionTargetedByScrollInDirection;
        if (i == -1 || (findViewByPosition = findViewByPosition(i)) == null) {
            return;
        }
        findViewByPosition.sendAccessibilityEvent(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        this.mPositionTargetedByScrollInDirection = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        RecyclerView.ViewHolder childViewHolder;
        int findScrollTargetPositionOnTheLeft;
        if (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION.getId() || i == -1) {
            if (i != 16908343 || bundle == null) {
                return super.performAccessibilityAction(i, bundle);
            }
            int i6 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT, -1);
            int i10 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT, -1);
            if (i6 != -1 && i10 != -1) {
                int itemCount = this.mRecyclerView.mAdapter.getItemCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= itemCount) {
                        i11 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.mRecyclerView;
                    int spanIndex = getSpanIndex(recyclerView.mRecycler, recyclerView.mState, i11);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    int spanGroupIndex = getSpanGroupIndex(recyclerView2.mRecycler, recyclerView2.mState, i11);
                    if (this.mOrientation == 1) {
                        if (spanIndex == i10 && spanGroupIndex == i6) {
                            break;
                        }
                        i11++;
                    } else {
                        if (spanIndex == i6 && spanGroupIndex == i10) {
                            break;
                        }
                        i11++;
                    }
                }
                if (i11 > -1) {
                    scrollToPositionWithOffset(i11, 0);
                    return true;
                }
            }
            return false;
        }
        View findChildWithAccessibilityFocus = findChildWithAccessibilityFocus();
        if (findChildWithAccessibilityFocus == null || bundle == null) {
            return false;
        }
        int i12 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
        if (!sSupportedDirectionsForActionScrollInDirection.contains(Integer.valueOf(i12)) || (childViewHolder = this.mRecyclerView.getChildViewHolder(findChildWithAccessibilityFocus)) == null) {
            return false;
        }
        int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
        int rowIndex = getRowIndex(absoluteAdapterPosition);
        int columnIndex = getColumnIndex(absoluteAdapterPosition);
        if (rowIndex >= 0 && columnIndex >= 0) {
            if (hasAccessibilityFocusChanged(absoluteAdapterPosition)) {
                this.mRowWithAccessibilityFocus = rowIndex;
                this.mColumnWithAccessibilityFocus = columnIndex;
            }
            int i13 = this.mRowWithAccessibilityFocus;
            if (i13 == -1) {
                i13 = rowIndex;
            }
            int i14 = this.mColumnWithAccessibilityFocus;
            if (i14 != -1) {
                columnIndex = i14;
            }
            if (i12 == 17) {
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheLeft(i13, columnIndex, absoluteAdapterPosition);
            } else if (i12 == 33) {
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionAbove(i13, columnIndex, absoluteAdapterPosition);
            } else if (i12 == 66) {
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionOnTheRight(i13, columnIndex, absoluteAdapterPosition);
            } else {
                if (i12 != 130) {
                    return false;
                }
                findScrollTargetPositionOnTheLeft = findScrollTargetPositionBelow(i13, columnIndex, absoluteAdapterPosition);
            }
            if (findScrollTargetPositionOnTheLeft == -1 && this.mOrientation == 0) {
                if (i12 == 17) {
                    findScrollTargetPositionOnTheLeft = findPositionOfLastItemOnARowAboveForHorizontalGrid(rowIndex);
                } else if (i12 == 66) {
                    findScrollTargetPositionOnTheLeft = findPositionOfFirstItemOnARowBelowForHorizontalGrid(rowIndex);
                }
            }
            if (findScrollTargetPositionOnTheLeft != -1) {
                scrollToPosition(findScrollTargetPositionOnTheLeft);
                this.mPositionTargetedByScrollInDirection = findScrollTargetPositionOnTheLeft;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i6) {
        int chooseSize;
        int chooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i6);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i6, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i6, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i) {
        if (i == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i < 1) {
            a.p(l.u(i, "Span count should be at least 1. Provided "));
            return;
        }
        this.mSpanCount = i;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z9) {
        if (z9) {
            b.r("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.setStackFromEnd(false);
        }
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z9) {
        this.mUsingSpansToEstimateScrollBarDimensions = z9;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(int i, int i6) {
            super(i, i6);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i6, boolean z9) {
        super(context, i6, z9);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.mPositionTargetedByScrollInDirection = -1;
        this.mRowWithAccessibilityFocus = -1;
        this.mColumnWithAccessibilityFocus = -1;
        setSpanCount(i);
    }
}
