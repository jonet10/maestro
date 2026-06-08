package j$.util.stream;

import j$.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class z4 extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6437b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6438c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6439d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f6440e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(v0 v0Var, m5 m5Var) {
        super(m5Var);
        this.f6440e = v0Var;
        m5 m5Var2 = this.f6224a;
        Objects.requireNonNull(m5Var2);
        this.f6439d = new j$.util.j0(m5Var2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(x xVar, m5 m5Var) {
        super(m5Var);
        this.f6440e = xVar;
        m5 m5Var2 = this.f6224a;
        Objects.requireNonNull(m5Var2);
        this.f6439d = new j$.util.f0(m5Var2, 1);
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j) {
        switch (this.f6437b) {
            case 0:
                this.f6224a.c(-1L);
                break;
            case 1:
                this.f6224a.c(-1L);
                break;
            default:
                this.f6224a.c(-1L);
                break;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        switch (this.f6437b) {
            case 0:
                j$.util.n0 n0Var = (j$.util.n0) this.f6439d;
                n1 n1Var = (n1) ((j$.util.q) ((g1) this.f6440e).f6201m).apply((j$.util.q) obj);
                if (n1Var != null) {
                    try {
                        if (!this.f6438c) {
                            n1Var.sequential().forEach(n0Var);
                        } else {
                            j$.util.b1 spliterator = n1Var.sequential().spliterator();
                            while (!this.f6224a.e() && spliterator.tryAdvance((LongConsumer) n0Var)) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            n1Var.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (n1Var != null) {
                    n1Var.close();
                    return;
                }
                return;
            case 1:
                j$.util.j0 j0Var = (j$.util.j0) this.f6439d;
                IntStream intStream = (IntStream) ((j$.util.q) ((v0) this.f6440e).f6395m).apply((j$.util.q) obj);
                if (intStream != null) {
                    try {
                        if (!this.f6438c) {
                            intStream.sequential().forEach(j0Var);
                        } else {
                            j$.util.y0 spliterator2 = intStream.sequential().spliterator();
                            while (!this.f6224a.e() && spliterator2.tryAdvance((IntConsumer) j0Var)) {
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            intStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                j$.util.f0 f0Var = (j$.util.f0) this.f6439d;
                e0 e0Var = (e0) ((j$.util.q) ((x) this.f6440e).f6420m).apply((j$.util.q) obj);
                if (e0Var != null) {
                    try {
                        if (!this.f6438c) {
                            e0Var.sequential().forEach(f0Var);
                        } else {
                            j$.util.v0 spliterator3 = e0Var.sequential().spliterator();
                            while (!this.f6224a.e() && spliterator3.tryAdvance((DoubleConsumer) f0Var)) {
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            e0Var.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (e0Var != null) {
                    e0Var.close();
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final boolean e() {
        switch (this.f6437b) {
            case 0:
                this.f6438c = true;
                break;
            case 1:
                this.f6438c = true;
                break;
            default:
                this.f6438c = true;
                break;
        }
        return this.f6224a.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(g1 g1Var, m5 m5Var) {
        super(m5Var);
        this.f6440e = g1Var;
        m5 m5Var2 = this.f6224a;
        Objects.requireNonNull(m5Var2);
        this.f6439d = new j$.util.n0(m5Var2, 1);
    }
}
