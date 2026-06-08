package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class b1 extends a implements IntStream {
    @Override // j$.util.stream.IntStream
    public final j$.util.d0 findAny() {
        return (j$.util.d0) C(h0.f6210d);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.d0 findFirst() {
        return (j$.util.d0) C(h0.f6209c);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream sorted() {
        return new f6(this, z6.f6448q | z6.f6446o, 0);
    }

    @Override // j$.util.stream.IntStream
    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        C(new o0(intConsumer, false));
    }

    @Override // j$.util.stream.IntStream
    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        C(new o0(intConsumer, true));
    }

    public static j$.util.y0 T(Spliterator spliterator) {
        if (spliterator instanceof j$.util.y0) {
            return (j$.util.y0) spliterator;
        }
        if (h8.f6218a) {
            h8.a(a.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // j$.util.stream.a
    public final a7 H() {
        return a7.INT_VALUE;
    }

    @Override // j$.util.stream.a
    public final h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        return w3.D(aVar, spliterator, z9);
    }

    @Override // j$.util.stream.a
    public final Spliterator P(a aVar, Supplier supplier, boolean z9) {
        return new m7(aVar, supplier, z9);
    }

    @Override // j$.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        IntConsumer j0Var;
        boolean e10;
        j$.util.y0 T = T(spliterator);
        if (m5Var instanceof IntConsumer) {
            j0Var = (IntConsumer) m5Var;
        } else {
            if (h8.f6218a) {
                h8.a(a.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            j0Var = new j$.util.j0(m5Var, 1);
        }
        do {
            e10 = m5Var.e();
            if (e10) {
                break;
            }
        } while (T.tryAdvance(j0Var));
        return e10;
    }

    @Override // j$.util.stream.a
    public final z1 I(long j, IntFunction intFunction) {
        return w3.P(j);
    }

    @Override // j$.util.stream.g
    public final j$.util.m0 iterator() {
        j$.util.y0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.h1(spliterator);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final j$.util.y0 spliterator() {
        return T(super.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final n1 asLongStream() {
        return new v(this, 0, 1);
    }

    @Override // j$.util.stream.IntStream
    public final e0 asDoubleStream() {
        return new t(this, 0, 3);
    }

    @Override // j$.util.stream.IntStream
    public final Stream boxed() {
        return new r(this, 0, new q(26), 1);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream e() {
        Objects.requireNonNull(null);
        return new u(this, z6.f6447p | z6.f6445n, 1);
    }

    @Override // j$.util.stream.IntStream
    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new r(this, z6.f6447p | z6.f6445n, intFunction, 1);
    }

    @Override // j$.util.stream.IntStream
    public final n1 i() {
        Objects.requireNonNull(null);
        return new v(this, z6.f6447p | z6.f6445n, 2);
    }

    @Override // j$.util.stream.IntStream
    public final e0 f() {
        Objects.requireNonNull(null);
        return new t(this, z6.f6447p | z6.f6445n, 4);
    }

    @Override // j$.util.stream.IntStream
    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) C(new m4(a7.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream o(m0 m0Var) {
        Objects.requireNonNull(m0Var);
        return new v0(this, z6.f6447p | z6.f6445n | z6.f6451t, m0Var, 1);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.d0 reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (j$.util.d0) C(new z3(a7.INT_VALUE, intBinaryOperator, 3));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream c() {
        Objects.requireNonNull(null);
        return new u(this, z6.f6451t, 3);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new v0(this, intConsumer);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j < 0) {
            j$.time.g.c(Long.toString(j));
            return null;
        }
        return w3.U(this, 0L, j);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : w3.U(this, j, -1L);
        }
        j$.time.g.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.IntStream
    public final IntStream a() {
        int i = z8.f6458a;
        Objects.requireNonNull(null);
        return new f6(this, z8.f6458a, 1);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream d() {
        int i = z8.f6458a;
        Objects.requireNonNull(null);
        return new f6(this, z8.f6459b, 2);
    }

    @Override // j$.util.stream.IntStream
    public final long count() {
        return ((Long) C(new d4(3))).longValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream distinct() {
        return ((e5) boxed()).distinct().mapToInt(new q(25));
    }

    @Override // j$.util.stream.IntStream
    public final int sum() {
        return reduce(0, new q(20));
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.d0 min() {
        return reduce(new q(17));
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.d0 max() {
        return reduce(new q(21));
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.c0 average() {
        long j = ((long[]) collect(new q(22), new q(23), new q(24)))[0];
        return j > 0 ? new j$.util.c0(r0[1] / j) : j$.util.c0.f5975c;
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.y summaryStatistics() {
        return (j$.util.y) collect(new j$.time.format.a(13), new q(18), new q(19));
    }

    @Override // j$.util.stream.IntStream
    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(pVar);
        return C(new b4(a7.INT_VALUE, pVar, objIntConsumer, supplier, 4));
    }

    @Override // j$.util.stream.IntStream
    public final boolean v() {
        return ((Boolean) C(w3.T(u1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean m() {
        return ((Boolean) C(w3.T(u1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean q() {
        return ((Boolean) C(w3.T(u1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) w3.L((d2) D(new q(16))).b();
    }
}
