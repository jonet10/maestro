package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e6 extends z implements q8 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6183l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e6(a aVar, int i, int i6) {
        super(aVar, i);
        this.f6183l = i6;
    }

    @Override // j$.util.stream.a
    public Spliterator K(a aVar, Spliterator spliterator) {
        switch (this.f6183l) {
            case 1:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(27)).spliterator() : new u8((j$.util.v0) aVar.S(spliterator), 1);
            case 2:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(28)).spliterator() : new u8((j$.util.v0) aVar.S(spliterator), 0);
            default:
                return super.K(aVar, spliterator);
        }
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f6183l) {
            case 0:
                if (z6.SORTED.j(aVar.f)) {
                    return aVar.B(spliterator, false, intFunction);
                }
                double[] dArr = (double[]) ((b2) aVar.B(spliterator, true, intFunction)).b();
                Arrays.sort(dArr);
                return new t2(dArr);
            case 1:
                return (h2) new t8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (h2) new s8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        switch (this.f6183l) {
            case 0:
                Objects.requireNonNull(m5Var);
                if (z6.SORTED.j(i)) {
                    return m5Var;
                }
                return z6.SIZED.j(i) ? new j6(m5Var) : new b6(m5Var);
            case 1:
                return new o8(this, m5Var);
            default:
                return new p8(this, m5Var, false);
        }
    }

    @Override // j$.util.stream.q8
    public r8 g(z1 z1Var, boolean z9) {
        return new p8(this, z1Var, z9);
    }
}
