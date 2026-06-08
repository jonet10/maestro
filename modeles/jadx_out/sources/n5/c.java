package n5;

import android.view.View;
import android.view.animation.Animation;
import u4.f0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8068b;

    public /* synthetic */ c(Object obj, int i) {
        this.f8067a = i;
        this.f8068b = obj;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f8067a) {
            case 0:
                View view = ((d) this.f8068b).f8072d;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("vBackground");
                    throw null;
                }
            default:
                f0 f0Var = (f0) this.f8068b;
                t4.b bVar = f0Var.f10473b;
                bVar.getClass();
                bVar.f9616o.removeAllViews();
                f0Var.G().U.set(false);
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f8067a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f8067a;
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
