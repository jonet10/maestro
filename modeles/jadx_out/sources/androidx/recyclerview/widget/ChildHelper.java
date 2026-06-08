package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    private View mViewInRemoveView;
    private int mRemoveStatus = 0;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i) {
            if (i < 64) {
                this.mData &= ~(1 << i);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i - 64);
            }
        }

        public int countOnesBefore(int i) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                long j = this.mData;
                return i >= 64 ? Long.bitCount(j) : Long.bitCount(((1 << i) - 1) & j);
            }
            if (i < 64) {
                return Long.bitCount(this.mData & ((1 << i) - 1));
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(i - 64);
        }

        public boolean get(int i) {
            if (i < 64) {
                return (this.mData & (1 << i)) != 0;
            }
            ensureNext();
            return this.mNext.get(i - 64);
        }

        public void insert(int i, boolean z9) {
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z9);
                return;
            }
            long j = this.mData;
            boolean z10 = (LAST_BIT & j) != 0;
            long j6 = (1 << i) - 1;
            this.mData = ((j & (~j6)) << 1) | (j & j6);
            if (z9) {
                set(i);
            } else {
                clear(i);
            }
            if (z10 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z10);
            }
        }

        public boolean remove(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            long j6 = this.mData;
            boolean z9 = (j6 & j) != 0;
            long j10 = j6 & (~j);
            this.mData = j10;
            long j11 = j - 1;
            this.mData = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z9;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i) {
            if (i < 64) {
                this.mData |= 1 << i;
            } else {
                ensureNext();
                this.mNext.set(i - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i6 = i;
        while (i6 < childCount) {
            int countOnesBefore = i - (i6 - this.mBucket.countOnesBefore(i6));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i6)) {
                    i6++;
                }
                return i6;
            }
            i6 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, int i, boolean z9) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z9);
        if (z9) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z9) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z9);
        if (z9) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i) {
        int size = this.mHiddenViews.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.mHiddenViews.get(i6);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i) {
        return this.mCallback.getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i) {
        return this.mCallback.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            a.h(view, "view is not a child, cannot hide ");
        } else {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        }
    }

    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int size = this.mHiddenViews.size();
        while (true) {
            size--;
            Callback callback = this.mCallback;
            if (size < 0) {
                callback.removeAllViews();
                return;
            } else {
                callback.onLeftHiddenState(this.mHiddenViews.get(size));
                this.mHiddenViews.remove(size);
            }
        }
    }

    public void removeView(View view) {
        int i = this.mRemoveStatus;
        if (i == 1) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i == 2) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            this.mRemoveStatus = 1;
            this.mViewInRemoveView = view;
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild < 0) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                return;
            }
            if (this.mBucket.remove(indexOfChild)) {
                unhideViewInternal(view);
            }
            this.mCallback.removeViewAt(indexOfChild);
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        } catch (Throwable th) {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
            throw th;
        }
    }

    public void removeViewAt(int i) {
        int i6 = this.mRemoveStatus;
        if (i6 == 1) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i6 == 2) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            int offset = getOffset(i);
            View childAt = this.mCallback.getChildAt(offset);
            if (childAt == null) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                return;
            }
            this.mRemoveStatus = 1;
            this.mViewInRemoveView = childAt;
            if (this.mBucket.remove(offset)) {
                unhideViewInternal(childAt);
            }
            this.mCallback.removeViewAt(offset);
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        } catch (Throwable th) {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
            throw th;
        }
    }

    public boolean removeViewIfHidden(View view) {
        int i = this.mRemoveStatus;
        if (i == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeViewIfHidden within removeView(At) for a different view");
            return false;
        }
        if (i == 2) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call removeViewIfHidden within removeViewIfHidden");
            return false;
        }
        try {
            this.mRemoveStatus = 2;
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild == -1) {
                unhideViewInternal(view);
                return true;
            }
            if (!this.mBucket.get(indexOfChild)) {
                return false;
            }
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        } finally {
            this.mRemoveStatus = 0;
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            a.h(view, "view is not a child, cannot hide ");
        } else if (!this.mBucket.get(indexOfChild)) {
            androidx.privacysandbox.ads.adservices.customaudience.a.h(view, "trying to unhide a view that was not hidden");
        } else {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        }
    }

    public void addView(View view, boolean z9) {
        addView(view, -1, z9);
    }
}
