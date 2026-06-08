package o8;

import java.io.Closeable;
import w8.g0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final String f8351a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8352b;

    /* renamed from: l, reason: collision with root package name */
    public final g0[] f8353l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f f8354m;

    public e(f fVar, String str, long j, g0[] g0VarArr) {
        this.f8354m = fVar;
        this.f8351a = str;
        this.f8352b = j;
        this.f8353l = g0VarArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (g0 g0Var : this.f8353l) {
            n8.c.c(g0Var);
        }
    }
}
