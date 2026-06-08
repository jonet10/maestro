package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class k1 extends a implements n1 {
    @Override // j$.util.stream.n1
    public final j$.util.e0 findAny() {
        return (j$.util.e0) C(i0.f6221d);
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 findFirst() {
        return (j$.util.e0) C(i0.f6220c);
    }

    @Override // j$.util.stream.n1
    public final n1 sorted() {
        return new g6(this, z6.f6448q | z6.f6446o, 0);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new p0(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new p0(longConsumer, true));
    }

    public static j$.util.b1 T(Spliterator spliterator) {
        if (spliterator instanceof j$.util.b1) {
            return (j$.util.b1) spliterator;
        }
        if (h8.f6218a) {
            h8.a(a.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // j$.util.stream.a
    public final a7 H() {
        return a7.LONG_VALUE;
    }

    @Override // j$.util.stream.a
    public final h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        return w3.E(aVar, spliterator, z9);
    }

    @Override // j$.util.stream.a
    public final Spliterator P(a aVar, Supplier supplier, boolean z9) {
        return new o7(aVar, supplier, z9);
    }

    @Override // j$.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        LongConsumer n0Var;
        boolean e10;
        j$.util.b1 T = T(spliterator);
        if (m5Var instanceof LongConsumer) {
            n0Var = (LongConsumer) m5Var;
        } else {
            if (h8.f6218a) {
                h8.a(a.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            n0Var = new j$.util.n0(m5Var, 1);
        }
        do {
            e10 = m5Var.e();
            if (e10) {
                break;
            }
        } while (T.tryAdvance(n0Var));
        return e10;
    }

    @Override // j$.util.stream.a
    public final z1 I(long j, IntFunction intFunction) {
        return w3.Q(j);
    }

    @Override // j$.util.stream.g
    public final j$.util.q0 iterator() {
        j$.util.b1 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.i1(spliterator);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final j$.util.b1 spliterator() {
        return T(super.spliterator());
    }

    @Override // j$.util.stream.n1
    public final e0 asDoubleStream() {
        return new t(this, z6.f6445n, 5);
    }

    @Override // j$.util.stream.n1
    public final Stream boxed() {
        return new r(this, 0, new d1(0), 2);
    }

    @Override // j$.util.stream.n1
    public final n1 e() {
        Objects.requireNonNull(null);
        return new v(this, z6.f6447p | z6.f6445n, 3);
    }

    @Override // j$.util.stream.n1
    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new r(this, z6.f6447p | z6.f6445n, longFunction, 2);
    }

    @Override // j$.util.stream.n1
    public final IntStream x() {
        Objects.requireNonNull(null);
        return new u(this, z6.f6447p | z6.f6445n, 4);
    }

    @Override // j$.util.stream.n1
    public final e0 h() {
        Objects.requireNonNull(null);
        return new t(this, z6.f6447p | z6.f6445n, 6);
    }

    @Override // j$.util.stream.n1
    public final n1 b(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new g1(this, z6.f6447p | z6.f6445n | z6.f6451t, qVar, 0);
    }

    @Override // j$.util.stream.n1
    public final n1 c() {
        Objects.requireNonNull(null);
        return new v(this, z6.f6451t, 5);
    }

    @Override // j$.util.stream.n1
    public final n1 peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new g1(this, longConsumer);
    }

    @Override // j$.util.stream.n1
    public final n1 limit(long j) {
        if (j < 0) {
            j$.time.g.c(Long.toString(j));
            return null;
        }
        return w3.W(this, 0L, j);
    }

    @Override // j$.util.stream.n1
    public final n1 skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : w3.W(this, j, -1L);
        }
        j$.time.g.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.n1
    public final n1 a() {
        int i = z8.f6458a;
        Objects.requireNonNull(null);
        return new g6(this, z8.f6458a, 1);
    }

    @Override // j$.util.stream.n1
    public final n1 d() {
        int i = z8.f6458a;
        Objects.requireNonNull(null);
        return new g6(this, z8.f6459b, 2);
    }

    @Override // j$.util.stream.n1
    public final n1 distinct() {
        return ((e5) boxed()).distinct().mapToLong(new d1(7));
    }

    @Override // j$.util.stream.n1
    public final long sum() {
        return reduce(0L, new d1(5));
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 min() {
        return reduce(new d1(6));
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 max() {
        return reduce(new d1(4));
    }

    @Override // j$.util.stream.n1
    public final j$.util.c0 average() {
        long j = ((long[]) collect(new d1(1), new d1(2), new d1(3)))[0];
        return j > 0 ? new j$.util.c0(r0[1] / j) : j$.util.c0.f5975c;
    }

    @Override // j$.util.stream.n1
    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) C(new x3(a7.LONG_VALUE, longBinaryOperator, j))).longValue();
    }

    @Override // j$.util.stream.n1
    public final j$.util.a0 summaryStatistics() {
        return (j$.util.a0) collect(new j$.time.format.a(14), new q(27), new q(28));
    }

    @Override // j$.util.stream.n1
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return C(new b4(a7.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    @Override // j$.util.stream.n1
    public final boolean n() {
        return ((Boolean) C(w3.V(u1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (j$.util.e0) C(new z3(a7.LONG_VALUE, longBinaryOperator, 0));
    }

    @Override // j$.util.stream.n1
    public final boolean u() {
        return ((Boolean) C(w3.V(u1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final boolean j() {
        return ((Boolean) C(w3.V(u1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final long[] toArray() {
        return (long[]) w3.M((f2) D(new q(29))).b();
    }

    @Override // j$.util.stream.n1
    public final long count() {
        return ((Long) C(new d4(0))).longValue();
    }
}
