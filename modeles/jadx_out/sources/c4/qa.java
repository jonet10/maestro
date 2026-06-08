package c4;

import android.view.animation.Animation;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class qa implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2023a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f2024b;

    public /* synthetic */ qa(Updates updates, int i) {
        this.f2023a = i;
        this.f2024b = updates;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f2023a) {
            case 0:
                break;
            default:
                int i = Updates.n0;
                Updates updates = this.f2024b;
                updates.T0().f10251p.setPadding(0, 0, 0, (int) updates.getResources().getDimension(2131165272));
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f2023a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f2023a) {
            case 0:
                int i = Updates.n0;
                this.f2024b.T0().f10251p.setPadding(0, 0, 0, 0);
                break;
        }
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
