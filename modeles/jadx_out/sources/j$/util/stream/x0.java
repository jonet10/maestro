package j$.util.stream;

import j$.util.Objects;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x0 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6421b;

    /* renamed from: c, reason: collision with root package name */
    public final j$.util.j0 f6422c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v0 f6423d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(v0 v0Var, m5 m5Var) {
        super(m5Var);
        this.f6423d = v0Var;
        m5 m5Var2 = this.f6205a;
        Objects.requireNonNull(m5Var2);
        this.f6422c = new j$.util.j0(m5Var2, 1);
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j) {
        this.f6205a.c(-1L);
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        IntStream intStream = (IntStream) ((m0) this.f6423d.f6395m).apply(i);
        if (intStream != null) {
            try {
                boolean z9 = this.f6421b;
                j$.util.j0 j0Var = this.f6422c;
                if (!z9) {
                    intStream.sequential().forEach(j0Var);
                } else {
                    j$.util.y0 spliterator = intStream.sequential().spliterator();
                    while (!this.f6205a.e() && spliterator.tryAdvance((IntConsumer) j0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        this.f6421b = true;
        return this.f6205a.e();
    }
}
