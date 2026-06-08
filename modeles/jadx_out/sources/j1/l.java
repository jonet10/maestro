package j1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements n, f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6550a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f6551b;

    /* renamed from: l, reason: collision with root package name */
    public final a f6552l;

    /* renamed from: m, reason: collision with root package name */
    public final p f6553m;

    public /* synthetic */ l(Executor executor, a aVar, p pVar, int i) {
        this.f6550a = i;
        this.f6551b = executor;
        this.f6552l = aVar;
        this.f6553m = pVar;
    }

    @Override // j1.n
    public final void a(p pVar) {
        switch (this.f6550a) {
            case 0:
                this.f6551b.execute(new m1.a(this, pVar, 22, false));
                break;
            default:
                this.f6551b.execute(new m1.a(this, pVar, 23, false));
                break;
        }
    }

    @Override // j1.f
    public void c(Object obj) {
        this.f6553m.k(obj);
    }

    @Override // j1.c
    public void f() {
        this.f6553m.n();
    }

    @Override // j1.e
    public void i(Exception exc) {
        this.f6553m.m(exc);
    }
}
