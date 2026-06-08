package e1;

import java.lang.Thread;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f4155a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q1 f4156b;

    public n1(q1 q1Var, String str) {
        this.f4156b = q1Var;
        this.f4155a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        w0 w0Var = this.f4156b.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4339o.c(th, this.f4155a);
    }
}
