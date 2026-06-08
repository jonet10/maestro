package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.GridLayoutManager;
import androidx.leanback.widget.ItemAlignmentFacet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ItemAlignmentFacetHelper {
    private static final Rect sRect = new Rect();

    private ItemAlignmentFacetHelper() {
    }

    public static int getAlignmentPosition(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i) {
        View view2;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int i6 = itemAlignmentDef.mViewId;
        if (i6 == 0 || (view2 = view.findViewById(i6)) == null) {
            view2 = view;
        }
        int i10 = itemAlignmentDef.mOffset;
        if (i != 0) {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f = itemAlignmentDef.mOffsetPercent;
                if (f == 0.0f) {
                    i10 += view2.getPaddingTop();
                } else if (f == 100.0f) {
                    i10 -= view2.getPaddingBottom();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                i10 += (int) (((view2 == view ? layoutParams.getOpticalHeight(view2) : view2.getHeight()) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view != view2) {
                Rect rect = sRect;
                rect.top = i10;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                i10 = rect.top - layoutParams.getOpticalTopInset();
            }
            return itemAlignmentDef.isAlignedToTextViewBaseLine() ? view2.getBaseline() + i10 : i10;
        }
        if (view.getLayoutDirection() != 1) {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f10 = itemAlignmentDef.mOffsetPercent;
                if (f10 == 0.0f) {
                    i10 += view2.getPaddingLeft();
                } else if (f10 == 100.0f) {
                    i10 -= view2.getPaddingRight();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                i10 += (int) (((view2 == view ? layoutParams.getOpticalWidth(view2) : view2.getWidth()) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == view2) {
                return i10;
            }
            Rect rect2 = sRect;
            rect2.left = i10;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect2);
            return rect2.left - layoutParams.getOpticalLeftInset();
        }
        int opticalWidth = (view2 == view ? layoutParams.getOpticalWidth(view2) : view2.getWidth()) - i10;
        if (itemAlignmentDef.mOffsetWithPadding) {
            float f11 = itemAlignmentDef.mOffsetPercent;
            if (f11 == 0.0f) {
                opticalWidth -= view2.getPaddingRight();
            } else if (f11 == 100.0f) {
                opticalWidth += view2.getPaddingLeft();
            }
        }
        if (itemAlignmentDef.mOffsetPercent != -1.0f) {
            opticalWidth -= (int) (((view2 == view ? layoutParams.getOpticalWidth(view2) : view2.getWidth()) * itemAlignmentDef.mOffsetPercent) / 100.0f);
        }
        if (view == view2) {
            return opticalWidth;
        }
        Rect rect3 = sRect;
        rect3.right = opticalWidth;
        ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect3);
        return rect3.right + layoutParams.getOpticalRightInset();
    }
}
