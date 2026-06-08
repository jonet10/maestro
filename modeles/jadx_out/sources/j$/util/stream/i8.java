package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i8 extends c5 implements q8 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6230l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Predicate f6231m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i8(e5 e5Var, int i, Predicate predicate, int i6) {
        super(e5Var, i);
        this.f6230l = i6;
        this.f6231m = predicate;
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        switch (this.f6230l) {
            case 0:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(9)).spliterator() : new x8(aVar.S(spliterator), this.f6231m, 1);
            default:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(9)).spliterator() : new x8(aVar.S(spliterator), this.f6231m, 0);
        }
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f6230l) {
            case 0:
                return (h2) new t8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (h2) new s8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        switch (this.f6230l) {
            case 0:
                return new l(this, m5Var);
            default:
                return new j8(this, m5Var, false);
        }
    }

    @Override // j$.util.stream.q8
    public r8 g(z1 z1Var, boolean z9) {
        return new j8(this, z1Var, z9);
    }
}
