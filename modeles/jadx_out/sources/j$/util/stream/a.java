package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final a f6125a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6126b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6127c;

    /* renamed from: d, reason: collision with root package name */
    public final a f6128d;

    /* renamed from: e, reason: collision with root package name */
    public int f6129e;
    public int f;
    public Spliterator g;
    public boolean h;
    public final boolean i;
    public Runnable j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6130k;

    public abstract h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction);

    public abstract boolean G(Spliterator spliterator, m5 m5Var);

    public abstract a7 H();

    public abstract z1 I(long j, IntFunction intFunction);

    public abstract boolean L();

    public abstract m5 M(int i, m5 m5Var);

    public abstract Spliterator P(a aVar, Supplier supplier, boolean z9);

    public a(Spliterator spliterator, int i, boolean z9) {
        this.f6126b = null;
        this.g = spliterator;
        this.f6125a = this;
        int i6 = z6.g & i;
        this.f6127c = i6;
        this.f = (~(i6 << 1)) & z6.f6443l;
        this.f6129e = 0;
        this.f6130k = z9;
    }

    public a(a aVar, int i) {
        if (aVar.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        aVar.h = true;
        aVar.f6128d = this;
        this.f6126b = aVar;
        this.f6127c = z6.h & i;
        this.f = z6.e(i, aVar.f);
        a aVar2 = aVar.f6125a;
        this.f6125a = aVar2;
        if (L()) {
            aVar2.i = true;
        }
        this.f6129e = aVar.f6129e + 1;
    }

    public final Object C(f8 f8Var) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (this.f6125a.f6130k) {
            return f8Var.b(this, N(f8Var.f()));
        }
        return f8Var.a(this, N(f8Var.f()));
    }

    public final h2 D(IntFunction intFunction) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (this.f6125a.f6130k && this.f6126b != null && L()) {
            this.f6129e = 0;
            a aVar = this.f6126b;
            return J(aVar, aVar.N(0), intFunction);
        }
        return B(N(0), true, intFunction);
    }

    public final Spliterator O() {
        a aVar = this.f6125a;
        if (this != aVar) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        Spliterator spliterator = aVar.g;
        if (spliterator != null) {
            aVar.g = null;
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    @Override // j$.util.stream.g
    public final g sequential() {
        this.f6125a.f6130k = false;
        return this;
    }

    @Override // j$.util.stream.g
    public final g parallel() {
        this.f6125a.f6130k = true;
        return this;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.h = true;
        this.g = null;
        a aVar = this.f6125a;
        Runnable runnable = aVar.j;
        if (runnable != null) {
            aVar.j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.g
    public final g onClose(Runnable runnable) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        Objects.requireNonNull(runnable);
        a aVar = this.f6125a;
        Runnable runnable2 = aVar.j;
        if (runnable2 != null) {
            runnable = new e8(runnable2, runnable);
        }
        aVar.j = runnable;
        return this;
    }

    @Override // j$.util.stream.g
    public Spliterator spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        a aVar = this.f6125a;
        if (this == aVar) {
            Spliterator spliterator = aVar.g;
            if (spliterator != null) {
                aVar.g = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        return P(this, new j$.util.q(2, this), aVar.f6130k);
    }

    public final h2 B(Spliterator spliterator, boolean z9, IntFunction intFunction) {
        if (this.f6125a.f6130k) {
            return E(this, spliterator, z9, intFunction);
        }
        z1 I = I(F(spliterator), intFunction);
        Q(spliterator, I);
        return I.build();
    }

    @Override // j$.util.stream.g
    public final boolean isParallel() {
        return this.f6125a.f6130k;
    }

    public final Spliterator N(int i) {
        int i6;
        int i10;
        a aVar = this.f6125a;
        Spliterator spliterator = aVar.g;
        if (spliterator != null) {
            aVar.g = null;
            if (aVar.f6130k && aVar.i) {
                a aVar2 = aVar.f6128d;
                int i11 = 1;
                while (aVar != this) {
                    int i12 = aVar2.f6127c;
                    if (aVar2.L()) {
                        if (z6.SHORT_CIRCUIT.j(i12)) {
                            i12 &= ~z6.f6452u;
                        }
                        spliterator = aVar2.K(aVar, spliterator);
                        if (spliterator.hasCharacteristics(64)) {
                            i6 = (~z6.f6451t) & i12;
                            i10 = z6.f6450s;
                        } else {
                            i6 = (~z6.f6450s) & i12;
                            i10 = z6.f6451t;
                        }
                        i12 = i6 | i10;
                        i11 = 0;
                    }
                    int i13 = i11 + 1;
                    aVar2.f6129e = i11;
                    aVar2.f = z6.e(i12, aVar.f);
                    a aVar3 = aVar2;
                    aVar2 = aVar2.f6128d;
                    aVar = aVar3;
                    i11 = i13;
                }
            }
            if (i != 0) {
                this.f = z6.e(i, this.f);
            }
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    public final long F(Spliterator spliterator) {
        if (z6.SIZED.j(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    public final m5 Q(Spliterator spliterator, m5 m5Var) {
        z(spliterator, R((m5) Objects.requireNonNull(m5Var)));
        return m5Var;
    }

    public final void z(Spliterator spliterator, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (!z6.SHORT_CIRCUIT.j(this.f)) {
            m5Var.c(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(m5Var);
            m5Var.end();
            return;
        }
        A(spliterator, m5Var);
    }

    public final boolean A(Spliterator spliterator, m5 m5Var) {
        a aVar = this;
        while (aVar.f6129e > 0) {
            aVar = aVar.f6126b;
        }
        m5Var.c(spliterator.getExactSizeIfKnown());
        boolean G = aVar.G(spliterator, m5Var);
        m5Var.end();
        return G;
    }

    public final m5 R(m5 m5Var) {
        Objects.requireNonNull(m5Var);
        for (a aVar = this; aVar.f6129e > 0; aVar = aVar.f6126b) {
            m5Var = aVar.M(aVar.f6126b.f, m5Var);
        }
        return m5Var;
    }

    public final Spliterator S(Spliterator spliterator) {
        return this.f6129e == 0 ? spliterator : P(this, new j$.util.q(3, spliterator), this.f6125a.f6130k);
    }

    public h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public Spliterator K(a aVar, Spliterator spliterator) {
        return J(aVar, spliterator, new j$.time.format.a(8)).spliterator();
    }
}
