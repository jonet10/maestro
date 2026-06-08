package j$.util.stream;

import j$.util.Objects;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6403b;

    /* renamed from: c, reason: collision with root package name */
    public final j$.util.f0 f6404c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f6405d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, m5 m5Var) {
        super(m5Var);
        this.f6405d = xVar;
        m5 m5Var2 = this.f6195a;
        Objects.requireNonNull(m5Var2);
        this.f6404c = new j$.util.f0(m5Var2, 1);
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j) {
        this.f6195a.c(-1L);
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        e0 e0Var = (e0) ((j$.util.q) this.f6405d.f6420m).apply(d10);
        if (e0Var != null) {
            try {
                boolean z9 = this.f6403b;
                j$.util.f0 f0Var = this.f6404c;
                if (!z9) {
                    e0Var.sequential().forEach(f0Var);
                } else {
                    j$.util.v0 spliterator = e0Var.sequential().spliterator();
                    while (!this.f6195a.e() && spliterator.tryAdvance((DoubleConsumer) f0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    e0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (e0Var != null) {
            e0Var.close();
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final boolean e() {
        this.f6403b = true;
        return this.f6195a.e();
    }
}
