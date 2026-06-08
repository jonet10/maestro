package e1;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import com.uptodown.util.views.UsernameTextView;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4333a = 2;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4334b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4335l;

    public w(y yVar, long j) {
        this.f4334b = j;
        Objects.requireNonNull(yVar);
        this.f4335l = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4333a;
        long j = this.f4334b;
        Object obj = this.f4335l;
        switch (i) {
            case 0:
                ((y) obj).m(j);
                break;
            case 1:
                m3 m3Var = (m3) obj;
                y yVar = m3Var.f3875a.f4271w;
                t1.j(yVar);
                yVar.j(j);
                m3Var.f4122n = null;
                break;
            default:
                UsernameTextView usernameTextView = (UsernameTextView) obj;
                ValueAnimator valueAnimator = usernameTextView.f3453a;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(j);
                ofFloat.setRepeatCount(1);
                ofFloat.setRepeatMode(2);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.addUpdateListener(new com.google.android.material.motion.c(usernameTextView, 3));
                usernameTextView.f3453a = ofFloat;
                ofFloat.start();
                Handler animationHandler = usernameTextView.getAnimationHandler();
                if (animationHandler != null) {
                    animationHandler.postDelayed(this, usernameTextView.f3457n);
                    break;
                }
                break;
        }
    }

    public w(m3 m3Var, long j) {
        this.f4334b = j;
        Objects.requireNonNull(m3Var);
        this.f4335l = m3Var;
    }

    public w(UsernameTextView usernameTextView, long j) {
        this.f4335l = usernameTextView;
        this.f4334b = j;
    }
}
