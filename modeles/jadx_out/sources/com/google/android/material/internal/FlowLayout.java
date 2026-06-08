package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    private static int getMeasuredDimension(int i, int i6, int i10) {
        return i6 != Integer.MIN_VALUE ? i6 != 1073741824 ? i10 : i : Math.min(i10, i);
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalItemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        boolean z11 = true;
        this.rowCount = 1;
        boolean z12 = getLayoutDirection() == 1;
        int paddingRight = z12 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z12 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = 0;
        int i15 = paddingRight;
        int i16 = paddingTop;
        while (i14 < getChildCount()) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
                z10 = z11;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.getMarginStart();
                    i12 = marginLayoutParams.getMarginEnd();
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i15 + i13;
                int i17 = i10 - i;
                int i18 = i17 - paddingLeft;
                z10 = z11;
                if (!this.singleLine && measuredWidth > i18) {
                    measuredWidth = childAt.getMeasuredWidth() + paddingRight + i13;
                    i16 = paddingTop + this.lineSpacing;
                    this.rowCount++;
                    i15 = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                if (z12) {
                    childAt.layout(i17 - measuredWidth, i16, (i17 - i15) - i13, measuredHeight);
                } else {
                    childAt.layout(i15 + i13, i16, measuredWidth, measuredHeight);
                }
                i15 += childAt.getMeasuredWidth() + i13 + i12 + this.itemSpacing;
                paddingTop = measuredHeight;
            }
            i14++;
            z11 = z10;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int i10;
        int i11;
        int i12;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        int i13 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i13 - getPaddingRight();
        int i14 = paddingTop;
        int i15 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i6);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i10 = marginLayoutParams.leftMargin;
                    i11 = marginLayoutParams.rightMargin;
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int i17 = paddingLeft;
                if (childAt.getMeasuredWidth() + paddingLeft + i10 <= paddingRight || isSingleLine()) {
                    i12 = i17;
                } else {
                    i12 = getPaddingLeft();
                    i14 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i12 + i10;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (measuredWidth > i15) {
                    i15 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i10 + i11 + this.itemSpacing + i12;
                if (i16 == getChildCount() - 1) {
                    i15 += i11;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, getPaddingRight() + i15), getMeasuredDimension(size2, mode2, getPaddingBottom() + paddingTop));
    }

    public void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    public void setLineSpacing(int i) {
        this.lineSpacing = i;
    }

    public void setSingleLine(boolean z9) {
        this.singleLine = z9;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i6) {
        super(context, attributeSet, i, i6);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
