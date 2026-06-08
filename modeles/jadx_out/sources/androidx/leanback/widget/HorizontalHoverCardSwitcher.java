package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class HorizontalHoverCardSwitcher extends PresenterSwitcher {
    int mCardLeft;
    int mCardRight;
    private int[] mTmpOffsets = new int[2];
    private Rect mTmpRect = new Rect();

    @Override // androidx.leanback.widget.PresenterSwitcher
    public void insertView(View view) {
        getParentViewGroup().addView(view);
    }

    @Override // androidx.leanback.widget.PresenterSwitcher
    public void onViewSelected(View view) {
        int width = getParentViewGroup().getWidth() - getParentViewGroup().getPaddingRight();
        int paddingLeft = getParentViewGroup().getPaddingLeft();
        view.measure(0, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z9 = view.getLayoutDirection() == 1;
        if (!z9) {
            if (view.getMeasuredWidth() + this.mCardLeft > width) {
                marginLayoutParams.leftMargin = width - view.getMeasuredWidth();
                view.requestLayout();
            }
        }
        if (z9 && this.mCardLeft < paddingLeft) {
            marginLayoutParams.leftMargin = paddingLeft;
        } else if (z9) {
            marginLayoutParams.leftMargin = this.mCardRight - view.getMeasuredWidth();
        } else {
            marginLayoutParams.leftMargin = this.mCardLeft;
        }
        view.requestLayout();
    }

    public void select(HorizontalGridView horizontalGridView, View view, Object obj) {
        ViewGroup parentViewGroup = getParentViewGroup();
        horizontalGridView.getViewSelectedOffsets(view, this.mTmpOffsets);
        this.mTmpRect.set(0, 0, view.getWidth(), view.getHeight());
        parentViewGroup.offsetDescendantRectToMyCoords(view, this.mTmpRect);
        Rect rect = this.mTmpRect;
        int i = rect.left;
        int i6 = this.mTmpOffsets[0];
        this.mCardLeft = i - i6;
        this.mCardRight = rect.right - i6;
        select(obj);
    }
}
