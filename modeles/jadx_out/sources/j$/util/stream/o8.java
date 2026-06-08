package j$.util.stream;

import java.util.function.DoublePredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o8 extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6316b;

    public o8(e6 e6Var, m5 m5Var) {
        super(m5Var);
        this.f6316b = true;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j) {
        this.f6195a.c(-1L);
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        if (this.f6316b) {
            DoublePredicate doublePredicate = null;
            doublePredicate.test(d10);
            throw null;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final boolean e() {
        return !this.f6316b || this.f6195a.e();
    }
}
