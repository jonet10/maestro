package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class GuidanceStylingRelativeLayout extends RelativeLayout {
    private float mTitleKeylinePercent;

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleKeylinePercent = getKeyLinePercent(context);
    }

    public static float getKeyLinePercent(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(androidx.leanback.R.styleable.LeanbackGuidedStepTheme);
        float f = obtainStyledAttributes.getFloat(androidx.leanback.R.styleable.LeanbackGuidedStepTheme_guidedStepKeyline, 40.0f);
        obtainStyledAttributes.recycle();
        return f;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        View findViewById = getRootView().findViewById(androidx.leanback.R.id.guidance_title);
        View findViewById2 = getRootView().findViewById(androidx.leanback.R.id.guidance_breadcrumb);
        View findViewById3 = getRootView().findViewById(androidx.leanback.R.id.guidance_description);
        ImageView imageView = (ImageView) getRootView().findViewById(androidx.leanback.R.id.guidance_icon);
        int measuredHeight = (int) ((getMeasuredHeight() * this.mTitleKeylinePercent) / 100.0f);
        if (findViewById != null && findViewById.getParent() == this) {
            int baseline = (((measuredHeight - findViewById.getBaseline()) - findViewById2.getMeasuredHeight()) - findViewById.getPaddingTop()) - findViewById2.getTop();
            if (findViewById2.getParent() == this) {
                findViewById2.offsetTopAndBottom(baseline);
            }
            findViewById.offsetTopAndBottom(baseline);
            if (findViewById3 != null && findViewById3.getParent() == this) {
                findViewById3.offsetTopAndBottom(baseline);
            }
        }
        if (imageView == null || imageView.getParent() != this || imageView.getDrawable() == null) {
            return;
        }
        imageView.offsetTopAndBottom(measuredHeight - (imageView.getMeasuredHeight() / 2));
    }

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidanceStylingRelativeLayout(Context context) {
        this(context, null);
    }
}
