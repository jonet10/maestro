package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void forceUniformWidth(int i, int i6) {
        int i10;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        int i11 = 0;
        while (i11 < i) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i12 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    i10 = i6;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i10, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i12;
                    i11++;
                    i6 = i10;
                }
            }
            i10 = i6;
            i11++;
            i6 = i10;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i6, int i10, int i11) {
        view.layout(i, i6, i10 + i, i11 + i6);
    }

    private boolean tryOnMeasure(int i, int i6) {
        int i10;
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            paddingBottom += view.getMeasuredHeight();
            i10 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i10 = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            i11 = resolveMinimumHeight(view2);
            i12 = view2.getMeasuredHeight() - i11;
            paddingBottom += i11;
            i10 = View.combineMeasuredStates(i10, view2.getMeasuredState());
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            i13 = view3.getMeasuredHeight();
            paddingBottom += i13;
            i10 = View.combineMeasuredStates(i10, view3.getMeasuredState());
        } else {
            i13 = 0;
        }
        int i15 = size - paddingBottom;
        if (view2 != null) {
            int i16 = paddingBottom - i11;
            int min = Math.min(i15, i12);
            if (min > 0) {
                i15 -= min;
                i11 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY));
            paddingBottom = i16 + view2.getMeasuredHeight();
            i10 = View.combineMeasuredStates(i10, view2.getMeasuredState());
        }
        if (view3 != null && i15 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i13 + i15, mode));
            paddingBottom = (paddingBottom - i13) + view3.getMeasuredHeight();
            i10 = View.combineMeasuredStates(i10, view3.getMeasuredState());
        }
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                i17 = Math.max(i17, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i17, i, i10), View.resolveSizeAndState(paddingBottom, i6, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i6);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
            r10 = this;
            int r11 = r10.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r10.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r11
            int r0 = r10.getPaddingRight()
            int r14 = r14 - r0
            int r0 = r10.getMeasuredHeight()
            int r1 = r10.getChildCount()
            int r2 = r10.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L39
            r4 = 80
            if (r3 == r4) goto L30
            int r13 = r10.getPaddingTop()
            goto L43
        L30:
            int r3 = r10.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r3 - r0
            goto L43
        L39:
            int r3 = r10.getPaddingTop()
            int r15 = r15 - r13
            int r15 = r15 - r0
            int r15 = r15 / 2
            int r13 = r15 + r3
        L43:
            android.graphics.drawable.Drawable r15 = r10.getDividerDrawable()
            r0 = 0
            if (r15 != 0) goto L4c
            r15 = r0
            goto L50
        L4c:
            int r15 = r15.getIntrinsicHeight()
        L50:
            if (r0 >= r1) goto Lb1
            android.view.View r4 = r10.getChildAt(r0)
            if (r4 == 0) goto Lae
            int r3 = r4.getVisibility()
            r5 = 8
            if (r3 == r5) goto Lae
            int r7 = r4.getMeasuredWidth()
            int r8 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            r9 = r3
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            int r3 = r9.gravity
            if (r3 >= 0) goto L74
            r3 = r2
        L74:
            int r5 = r10.getLayoutDirection()
            int r3 = androidx.core.view.GravityCompat.getAbsoluteGravity(r3, r5)
            r3 = r3 & 7
            r5 = 1
            if (r3 == r5) goto L8f
            r5 = 5
            if (r3 == r5) goto L89
            int r3 = r9.leftMargin
            int r3 = r3 + r11
        L87:
            r5 = r3
            goto L9a
        L89:
            int r3 = r12 - r7
            int r5 = r9.rightMargin
        L8d:
            int r3 = r3 - r5
            goto L87
        L8f:
            int r3 = r14 - r7
            int r3 = r3 / 2
            int r3 = r3 + r11
            int r5 = r9.leftMargin
            int r3 = r3 + r5
            int r5 = r9.rightMargin
            goto L8d
        L9a:
            boolean r3 = r10.hasDividerBeforeChildAt(r0)
            if (r3 == 0) goto La1
            int r13 = r13 + r15
        La1:
            int r3 = r9.topMargin
            int r6 = r13 + r3
            r3 = r10
            r3.setChildFrame(r4, r5, r6, r7, r8)
            int r13 = r9.bottomMargin
            int r8 = r8 + r13
            int r8 = r8 + r6
            r13 = r8
        Lae:
            int r0 = r0 + 1
            goto L50
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i6) {
        if (tryOnMeasure(i, i6)) {
            return;
        }
        super.onMeasure(i, i6);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
