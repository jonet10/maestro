package j$.util.stream;

import java.util.function.IntPredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k8 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6268b;

    public k8(f6 f6Var, m5 m5Var) {
        super(m5Var);
        this.f6268b = true;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j) {
        this.f6205a.c(-1L);
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        if (this.f6268b) {
            IntPredicate intPredicate = null;
            intPredicate.test(i);
            throw null;
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        return !this.f6268b || this.f6205a.e();
    }
}
