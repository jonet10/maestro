package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ControlBar extends LinearLayout {
    private int mChildMarginFromCenter;
    boolean mDefaultFocusToMiddle;
    int mLastFocusIndex;
    private OnChildFocusedListener mOnChildFocusedListener;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface OnChildFocusedListener {
        void onChildFocusedListener(View view, View view2);
    }

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastFocusIndex = -1;
        this.mDefaultFocusToMiddle = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i6) {
        if (i != 33 && i != 130) {
            super.addFocusables(arrayList, i, i6);
            return;
        }
        int i10 = this.mLastFocusIndex;
        if (i10 >= 0 && i10 < getChildCount()) {
            arrayList.add(getChildAt(this.mLastFocusIndex));
        } else if (getChildCount() > 0) {
            arrayList.add(getChildAt(getDefaultFocusIndex()));
        }
    }

    public int getDefaultFocusIndex() {
        if (this.mDefaultFocusToMiddle) {
            return getChildCount() / 2;
        }
        return 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        if (this.mChildMarginFromCenter <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < getChildCount() - 1) {
            View childAt = getChildAt(i10);
            i10++;
            View childAt2 = getChildAt(i10);
            int measuredWidth = this.mChildMarginFromCenter - ((childAt2.getMeasuredWidth() + childAt.getMeasuredWidth()) / 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            int marginStart = measuredWidth - layoutParams.getMarginStart();
            layoutParams.setMarginStart(measuredWidth);
            childAt2.setLayoutParams(layoutParams);
            i11 += marginStart;
        }
        setMeasuredDimension(getMeasuredWidth() + i11, getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (getChildCount() > 0) {
            int i6 = this.mLastFocusIndex;
            if (getChildAt((i6 < 0 || i6 >= getChildCount()) ? getDefaultFocusIndex() : this.mLastFocusIndex).requestFocus(i, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.mLastFocusIndex = indexOfChild(view);
        OnChildFocusedListener onChildFocusedListener = this.mOnChildFocusedListener;
        if (onChildFocusedListener != null) {
            onChildFocusedListener.onChildFocusedListener(view, view2);
        }
    }

    public void setChildMarginFromCenter(int i) {
        this.mChildMarginFromCenter = i;
    }

    public void setDefaultFocusToMiddle(boolean z9) {
        this.mDefaultFocusToMiddle = z9;
    }

    public void setOnChildFocusedListener(OnChildFocusedListener onChildFocusedListener) {
        this.mOnChildFocusedListener = onChildFocusedListener;
    }

    public ControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastFocusIndex = -1;
        this.mDefaultFocusToMiddle = true;
    }
}
