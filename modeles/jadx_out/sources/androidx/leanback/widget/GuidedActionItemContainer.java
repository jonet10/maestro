package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {
    private boolean mFocusOutAllowed;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFocusOutAllowed = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        if (this.mFocusOutAllowed || !Util.isDescendant(this, view)) {
            return super.focusSearch(view, i);
        }
        View focusSearch = super.focusSearch(view, i);
        if (Util.isDescendant(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }

    public void setFocusOutAllowed(boolean z9) {
        this.mFocusOutAllowed = z9;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidedActionItemContainer(Context context) {
        this(context, null);
    }
}
