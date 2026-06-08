package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w5 extends b {
    public final a j;

    /* renamed from: k, reason: collision with root package name */
    public final IntFunction f6412k;

    /* renamed from: l, reason: collision with root package name */
    public final long f6413l;

    /* renamed from: m, reason: collision with root package name */
    public final long f6414m;

    /* renamed from: n, reason: collision with root package name */
    public long f6415n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f6416o;

    @Override // j$.util.stream.b
    public final void f() {
        this.i = true;
        if (this.f6416o) {
            d(w3.H(this.j.H()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:
    
        if (r2 >= r0) goto L49;
     */
    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.w5.onCompletion(java.util.concurrent.CountedCompleter):void");
    }

    public w5(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction, long j, long j6) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.f6412k = intFunction;
        this.f6413l = j;
        this.f6414m = j6;
    }

    public w5(w5 w5Var, Spliterator spliterator) {
        super(w5Var, spliterator);
        this.j = w5Var.j;
        this.f6412k = w5Var.f6412k;
        this.f6413l = w5Var.f6413l;
        this.f6414m = w5Var.f6414m;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new w5(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return w3.H(this.j.H());
    }

    @Override // j$.util.stream.d
    public final Object a() {
        if (b()) {
            z6 z6Var = z6.SIZED;
            a aVar = this.j;
            int i = aVar.f6127c;
            int i6 = z6Var.f6457e;
            z1 I = this.j.I((i & i6) == i6 ? aVar.F(this.f6169b) : -1L, this.f6412k);
            m5 M = this.j.M(this.f6168a.f, I);
            a aVar2 = this.f6168a;
            aVar2.A(this.f6169b, aVar2.R(M));
            return I.build();
        }
        z1 I2 = this.j.I(-1L, this.f6412k);
        if (this.f6413l == 0) {
            m5 M2 = this.j.M(this.f6168a.f, I2);
            a aVar3 = this.f6168a;
            aVar3.A(this.f6169b, aVar3.R(M2));
        } else {
            this.f6168a.Q(this.f6169b, I2);
        }
        h2 build = I2.build();
        this.f6415n = build.count();
        this.f6416o = true;
        this.f6169b = null;
        return build;
    }

    public final long j(long j) {
        if (this.f6416o) {
            return this.f6415n;
        }
        w5 w5Var = (w5) this.f6171d;
        w5 w5Var2 = (w5) this.f6172e;
        if (w5Var == null || w5Var2 == null) {
            return this.f6415n;
        }
        long j6 = w5Var.j(j);
        return j6 >= j ? j6 : w5Var2.j(j) + j6;
    }
}
