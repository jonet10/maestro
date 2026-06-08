package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h6 extends c5 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6215l;

    /* renamed from: m, reason: collision with root package name */
    public final Comparator f6216m;

    public h6(e5 e5Var) {
        super(e5Var, z6.f6448q | z6.f6446o);
        this.f6215l = true;
        this.f6216m = j$.util.f.INSTANCE;
    }

    public h6(e5 e5Var, Comparator comparator) {
        super(e5Var, z6.f6448q | z6.f6447p);
        this.f6215l = false;
        this.f6216m = (Comparator) Objects.requireNonNull(comparator);
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (z6.SORTED.j(i) && this.f6215l) {
            return m5Var;
        }
        boolean j = z6.SIZED.j(i);
        Comparator comparator = this.f6216m;
        if (j) {
            return new m6(m5Var, comparator);
        }
        return new i6(m5Var, comparator);
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (z6.SORTED.j(aVar.f) && this.f6215l) {
            return aVar.B(spliterator, false, intFunction);
        }
        Object[] m10 = aVar.B(spliterator, true, intFunction).m(intFunction);
        Arrays.sort(m10, this.f6216m);
        return new k2(m10);
    }
}
