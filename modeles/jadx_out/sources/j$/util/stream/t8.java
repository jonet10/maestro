package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class t8 extends b {
    public final a j;

    /* renamed from: k, reason: collision with root package name */
    public final IntFunction f6369k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6370l;

    /* renamed from: m, reason: collision with root package name */
    public long f6371m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6372n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f6373o;

    @Override // j$.util.stream.b
    public final void f() {
        this.i = true;
        if (this.f6370l && this.f6373o) {
            d(w3.H(this.j.H()));
        }
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        Object F;
        d dVar = this.f6171d;
        if (dVar != null) {
            this.f6372n = ((t8) dVar).f6372n | ((t8) this.f6172e).f6372n;
            if (this.f6370l && this.i) {
                this.f6371m = 0L;
                F = w3.H(this.j.H());
            } else {
                if (this.f6370l) {
                    t8 t8Var = (t8) this.f6171d;
                    if (t8Var.f6372n) {
                        this.f6371m = t8Var.f6371m;
                        F = (h2) t8Var.i();
                    }
                }
                t8 t8Var2 = (t8) this.f6171d;
                long j = t8Var2.f6371m;
                t8 t8Var3 = (t8) this.f6172e;
                this.f6371m = j + t8Var3.f6371m;
                if (t8Var2.f6371m == 0) {
                    F = (h2) t8Var3.i();
                } else if (t8Var3.f6371m == 0) {
                    F = (h2) t8Var2.i();
                } else {
                    F = w3.F(this.j.H(), (h2) ((t8) this.f6171d).i(), (h2) ((t8) this.f6172e).i());
                }
            }
            d(F);
        }
        this.f6373o = true;
        super.onCompletion(countedCompleter);
    }

    public t8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.f6369k = intFunction;
        this.f6370l = z6.ORDERED.j(aVar2.f);
    }

    public t8(t8 t8Var, Spliterator spliterator) {
        super(t8Var, spliterator);
        this.j = t8Var.j;
        this.f6369k = t8Var.f6369k;
        this.f6370l = t8Var.f6370l;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new t8(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return w3.H(this.j.H());
    }

    @Override // j$.util.stream.d
    public final Object a() {
        z1 I = this.f6168a.I(-1L, this.f6369k);
        m5 M = this.j.M(this.f6168a.f, I);
        a aVar = this.f6168a;
        boolean A = aVar.A(this.f6169b, aVar.R(M));
        this.f6372n = A;
        if (A) {
            g();
        }
        h2 build = I.build();
        this.f6371m = build.count();
        return build;
    }
}
