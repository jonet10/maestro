package v7;

import a4.x;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends h {

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f10891l;

    public i(Runnable runnable, long j, boolean z9) {
        super(j, z9);
        this.f10891l = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10891l.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f10891l;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(c0.o(runnable));
        sb.append(", ");
        sb.append(this.f10889a);
        sb.append(", ");
        return x.m(sb, this.f10890b ? "Blocking" : "Non-blocking", ']');
    }
}
