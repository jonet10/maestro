package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i) {
        Preconditions.checkArgumentNonnegative(i, "Margin must be non-negative");
        this.mMarginPx = i;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        a.i("Expected the page view to be managed by a ViewPager2 instance.");
        return null;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float f10 = this.mMarginPx * f;
        if (requireViewPager.getOrientation() != 0) {
            view.setTranslationY(f10);
            return;
        }
        if (requireViewPager.isRtl()) {
            f10 = -f10;
        }
        view.setTranslationX(f10);
    }
}
