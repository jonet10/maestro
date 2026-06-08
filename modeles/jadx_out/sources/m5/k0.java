package m5;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7442a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f7443b;

    public /* synthetic */ k0(RecyclerView.ViewHolder viewHolder, int i) {
        this.f7442a = i;
        this.f7443b = viewHolder;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f7442a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7442a) {
            case 0:
                ((l0) this.f7443b).f7460p.setVisibility(8);
                break;
            default:
                p1 p1Var = (p1) this.f7443b;
                p1Var.f7509m.setVisibility(8);
                p1Var.B = o1.f7494a;
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i = this.f7442a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i = this.f7442a;
    }

    private final void a(Animator animator) {
    }

    private final void b(Animator animator) {
    }

    private final void c(Animator animator) {
    }

    private final void d(Animator animator) {
    }

    private final void e(Animator animator) {
    }

    private final void f(Animator animator) {
    }
}
