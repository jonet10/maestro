package j$.util.stream;

import java.util.function.LongPredicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m8 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6291b;

    public m8(g6 g6Var, m5 m5Var) {
        super(m5Var);
        this.f6291b = true;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j) {
        this.f6214a.c(-1L);
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        if (this.f6291b) {
            LongPredicate longPredicate = null;
            longPredicate.test(j);
            throw null;
        }
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final boolean e() {
        return !this.f6291b || this.f6214a.e();
    }
}
