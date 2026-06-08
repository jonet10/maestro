package c4;

import androidx.viewpager2.widget.ViewPager2;
import com.uptodown.activities.Gallery;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gallery f2037a;

    public r1(Gallery gallery) {
        this.f2037a = gallery;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int i) {
        super.onPageSelected(i);
        int i6 = Gallery.R;
        this.f2037a.z0(i);
    }
}
