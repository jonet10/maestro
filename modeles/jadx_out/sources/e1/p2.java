package e1;

import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p2 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4190a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4191b;

    public p2() {
        this.f4190a = 1;
        a4.c0 c0Var = new a4.c0(Looper.getMainLooper(), 2, false);
        Looper.getMainLooper();
        this.f4191b = c0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4190a) {
            case 0:
                q1 q1Var = ((b3) this.f4191b).f3875a.f4265p;
                t1.m(q1Var);
                q1Var.p(runnable);
                break;
            case 1:
                ((a4.c0) this.f4191b).post(runnable);
                break;
            default:
                ((Executor) this.f4191b).execute(new q0.b(runnable, 1));
                break;
        }
    }

    public /* synthetic */ p2(Object obj, int i) {
        this.f4190a = i;
        this.f4191b = obj;
    }
}
