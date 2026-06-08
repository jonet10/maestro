package j$.util.stream;

import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;
import j$.util.Spliterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class w3 implements f8 {

    /* renamed from: a, reason: collision with root package name */
    public static final z2 f6407a = new z2();

    /* renamed from: b, reason: collision with root package name */
    public static final x2 f6408b = new x2();

    /* renamed from: c, reason: collision with root package name */
    public static final y2 f6409c = new y2();

    /* renamed from: d, reason: collision with root package name */
    public static final w2 f6410d = new w2();

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6411e = new int[0];
    public static final long[] f = new long[0];
    public static final double[] g = new double[0];

    public abstract r4 Z();

    @Override // j$.util.stream.f8
    public /* synthetic */ int f() {
        return 0;
    }

    public static j$.util.q O(Function function) {
        j$.util.q qVar = new j$.util.q(6);
        qVar.f6104b = function;
        return qVar;
    }

    public static Set N(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof h) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    h hVar = (h) it.next();
                    hashSet.add(hVar == null ? null : hVar == h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar == h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                } catch (ClassCastException e10) {
                    j$.util.g.a(e10, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof Collector.Characteristics)) {
                j$.util.g.a(next.getClass(), "java.util.stream.Collector.Characteristics");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics = (Collector.Characteristics) it2.next();
                    hashSet.add(characteristics == null ? null : characteristics == Collector.Characteristics.CONCURRENT ? h.CONCURRENT : characteristics == Collector.Characteristics.UNORDERED ? h.UNORDERED : h.IDENTITY_FINISH);
                } catch (ClassCastException e11) {
                    j$.util.g.a(e11, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static long x(long j, long j6, long j10) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j6, j10));
        }
        return -1L;
    }

    public static long A(long j, long j6) {
        long j10 = j6 >= 0 ? j + j6 : Long.MAX_VALUE;
        return j10 >= 0 ? j10 : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static b5 a0(Spliterator spliterator, boolean z9) {
        Objects.requireNonNull(spliterator);
        return new b5(spliterator, z6.g(spliterator), z9);
    }

    public static Spliterator y(a7 a7Var, Spliterator spliterator, long j, long j6) {
        long A = A(j, j6);
        int i = v5.f6400a[a7Var.ordinal()];
        if (i == 1) {
            return new t7(spliterator, j, A);
        }
        if (i == 2) {
            return new q7((j$.util.y0) spliterator, j, A);
        }
        if (i == 3) {
            return new r7((j$.util.b1) spliterator, j, A);
        }
        if (i != 4) {
            throw new IllegalStateException("Unknown shape " + a7Var);
        }
        return new p7((j$.util.v0) spliterator, j, A);
    }

    public static j$.util.concurrent.t X(u1 u1Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.REFERENCE, u1Var, new j$.util.concurrent.t(5, u1Var, predicate));
    }

    public static a3 H(a7 a7Var) {
        int i = i2.f6222a[a7Var.ordinal()];
        if (i == 1) {
            return f6407a;
        }
        if (i == 2) {
            return f6408b;
        }
        if (i == 3) {
            return f6409c;
        }
        if (i == 4) {
            return f6410d;
        }
        throw new IllegalStateException("Unknown shape " + a7Var);
    }

    public static j$.util.concurrent.t T(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.INT_VALUE, u1Var, new o1(u1Var, 1));
    }

    public static o5 Y(e5 e5Var, long j, long j6) {
        if (j < 0) {
            j$.time.g.a(j);
            return null;
        }
        return new o5(e5Var, I(j6), j, j6);
    }

    public static h2 w(h2 h2Var, long j, long j6, IntFunction intFunction) {
        if (j == 0 && j6 == h2Var.count()) {
            return h2Var;
        }
        Spliterator spliterator = h2Var.spliterator();
        long j10 = j6 - j;
        z1 z9 = z(j10, intFunction);
        z9.c(j10);
        for (int i = 0; i < j && spliterator.tryAdvance(new d1(8)); i++) {
        }
        if (j6 == h2Var.count()) {
            spliterator.forEachRemaining(z9);
        } else {
            for (int i6 = 0; i6 < j10 && spliterator.tryAdvance(z9); i6++) {
            }
        }
        z9.end();
        return z9.build();
    }

    public static j2 F(a7 a7Var, h2 h2Var, h2 h2Var2) {
        int i = i2.f6222a[a7Var.ordinal()];
        if (i == 1) {
            return new s2(h2Var, h2Var2);
        }
        if (i == 2) {
            return new p2((d2) h2Var, (d2) h2Var2);
        }
        if (i == 3) {
            return new q2((f2) h2Var, (f2) h2Var2);
        }
        if (i != 4) {
            throw new IllegalStateException("Unknown shape " + a7Var);
        }
        return new o2((b2) h2Var, (b2) h2Var2);
    }

    public static j$.util.concurrent.t V(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.LONG_VALUE, u1Var, new o1(u1Var, 0));
    }

    public static void k() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static j$.util.concurrent.t R(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.DOUBLE_VALUE, u1Var, new o1(u1Var, 2));
    }

    public static void l() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static z1 z(long j, IntFunction intFunction) {
        if (j >= 0 && j < 2147483639) {
            return new b3(j, intFunction);
        }
        return new t3();
    }

    public static void c() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void g(k5 k5Var, Integer num) {
        if (h8.f6218a) {
            h8.a(k5Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        k5Var.accept(num.intValue());
    }

    public static void i(l5 l5Var, Long l10) {
        if (h8.f6218a) {
            h8.a(l5Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        l5Var.accept(l10.longValue());
    }

    public static x1 P(long j) {
        if (j < 0 || j >= 2147483639) {
            return new e3();
        }
        return new d3(j);
    }

    public static void d(j5 j5Var, Double d10) {
        if (h8.f6218a) {
            h8.a(j5Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        j5Var.accept(d10.doubleValue());
    }

    public static q5 U(b1 b1Var, long j, long j6) {
        if (j < 0) {
            j$.time.g.a(j);
            return null;
        }
        return new q5(b1Var, I(j6), j, j6);
    }

    public static y1 Q(long j) {
        if (j < 0 || j >= 2147483639) {
            return new n3();
        }
        return new m3(j);
    }

    public static Object[] m(g2 g2Var, IntFunction intFunction) {
        if (h8.f6218a) {
            h8.a(g2Var.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (g2Var.count() >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) g2Var.count());
        g2Var.k(objArr, 0);
        return objArr;
    }

    public static w1 G(long j) {
        if (j < 0 || j >= 2147483639) {
            return new v2();
        }
        return new u2(j);
    }

    public static h2 B(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        long F = aVar.F(spliterator);
        if (F < 0 || !spliterator.hasCharacteristics(16384)) {
            m0 m0Var = new m0();
            m0Var.f6286a = intFunction;
            h2 h2Var = (h2) new m2(aVar, spliterator, m0Var, new d1(16), 3).invoke();
            return z9 ? J(h2Var, intFunction) : h2Var;
        }
        if (F >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) F);
        new r3(spliterator, aVar, objArr).invoke();
        return new k2(objArr);
    }

    public static void r(d2 d2Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            d2Var.g((IntConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(d2Var.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.y0) d2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static s5 W(k1 k1Var, long j, long j6) {
        if (j < 0) {
            j$.time.g.a(j);
            return null;
        }
        return new s5(k1Var, I(j6), j, j6);
    }

    public static void o(d2 d2Var, Integer[] numArr, int i) {
        if (h8.f6218a) {
            h8.a(d2Var.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) d2Var.b();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            numArr[i + i6] = Integer.valueOf(iArr[i6]);
        }
    }

    public static d2 u(d2 d2Var, long j, long j6) {
        if (j == 0 && j6 == d2Var.count()) {
            return d2Var;
        }
        long j10 = j6 - j;
        j$.util.y0 y0Var = (j$.util.y0) d2Var.spliterator();
        x1 P = P(j10);
        P.c(j10);
        for (int i = 0; i < j && y0Var.tryAdvance((IntConsumer) new c2(0)); i++) {
        }
        if (j6 == d2Var.count()) {
            y0Var.forEachRemaining((IntConsumer) P);
        } else {
            for (int i6 = 0; i6 < j10 && y0Var.tryAdvance((IntConsumer) P); i6++) {
            }
        }
        P.end();
        return P.build();
    }

    public static d2 D(a aVar, Spliterator spliterator, boolean z9) {
        long F = aVar.F(spliterator);
        if (F < 0 || !spliterator.hasCharacteristics(16384)) {
            d2 d2Var = (d2) new m2(aVar, spliterator, new d1(12), new d1(13), 1).invoke();
            return z9 ? L(d2Var) : d2Var;
        }
        if (F >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) F];
        new p3(spliterator, aVar, iArr).invoke();
        return new c3(iArr);
    }

    public static f2 E(a aVar, Spliterator spliterator, boolean z9) {
        long F = aVar.F(spliterator);
        if (F < 0 || !spliterator.hasCharacteristics(16384)) {
            f2 f2Var = (f2) new m2(aVar, spliterator, new d1(14), new d1(15), 2).invoke();
            return z9 ? M(f2Var) : f2Var;
        }
        if (F >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) F];
        new q3(spliterator, aVar, jArr).invoke();
        return new l3(jArr);
    }

    public static void s(f2 f2Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            f2Var.g((LongConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(f2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.b1) f2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void p(f2 f2Var, Long[] lArr, int i) {
        if (h8.f6218a) {
            h8.a(f2Var.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) f2Var.b();
        for (int i6 = 0; i6 < jArr.length; i6++) {
            lArr[i + i6] = Long.valueOf(jArr[i6]);
        }
    }

    public static f2 v(f2 f2Var, long j, long j6) {
        if (j == 0 && j6 == f2Var.count()) {
            return f2Var;
        }
        long j10 = j6 - j;
        j$.util.b1 b1Var = (j$.util.b1) f2Var.spliterator();
        y1 Q = Q(j10);
        Q.c(j10);
        for (int i = 0; i < j && b1Var.tryAdvance((LongConsumer) new e2(0)); i++) {
        }
        if (j6 == f2Var.count()) {
            b1Var.forEachRemaining((LongConsumer) Q);
        } else {
            for (int i6 = 0; i6 < j10 && b1Var.tryAdvance((LongConsumer) Q); i6++) {
            }
        }
        Q.end();
        return Q.build();
    }

    public static b2 C(a aVar, Spliterator spliterator, boolean z9) {
        long F = aVar.F(spliterator);
        if (F < 0 || !spliterator.hasCharacteristics(16384)) {
            b2 b2Var = (b2) new m2(aVar, spliterator, new d1(10), new d1(11), 0).invoke();
            return z9 ? K(b2Var) : b2Var;
        }
        if (F >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) F];
        new o3(spliterator, aVar, dArr).invoke();
        return new t2(dArr);
    }

    public static u5 S(b0 b0Var, long j, long j6) {
        if (j < 0) {
            j$.time.g.a(j);
            return null;
        }
        return new u5(b0Var, I(j6), j, j6);
    }

    public static h2 J(h2 h2Var, IntFunction intFunction) {
        if (h2Var.o() <= 0) {
            return h2Var;
        }
        long count = h2Var.count();
        if (count >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) count);
        new v3(h2Var, objArr, 1).invoke();
        return new k2(objArr);
    }

    public static void q(b2 b2Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            b2Var.g((DoubleConsumer) consumer);
        } else {
            if (h8.f6218a) {
                h8.a(b2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.v0) b2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static d2 L(d2 d2Var) {
        if (d2Var.o() <= 0) {
            return d2Var;
        }
        long count = d2Var.count();
        if (count >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) count];
        new u3(d2Var, iArr, 0).invoke();
        return new c3(iArr);
    }

    public static void n(b2 b2Var, Double[] dArr, int i) {
        if (h8.f6218a) {
            h8.a(b2Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) b2Var.b();
        for (int i6 = 0; i6 < dArr2.length; i6++) {
            dArr[i + i6] = Double.valueOf(dArr2[i6]);
        }
    }

    public static b2 t(b2 b2Var, long j, long j6) {
        if (j == 0 && j6 == b2Var.count()) {
            return b2Var;
        }
        long j10 = j6 - j;
        j$.util.v0 v0Var = (j$.util.v0) b2Var.spliterator();
        w1 G = G(j10);
        G.c(j10);
        for (int i = 0; i < j && v0Var.tryAdvance((DoubleConsumer) new a2(0)); i++) {
        }
        if (j6 == b2Var.count()) {
            v0Var.forEachRemaining((DoubleConsumer) G);
        } else {
            for (int i6 = 0; i6 < j10 && v0Var.tryAdvance((DoubleConsumer) G); i6++) {
            }
        }
        G.end();
        return G.build();
    }

    public static f2 M(f2 f2Var) {
        if (f2Var.o() <= 0) {
            return f2Var;
        }
        long count = f2Var.count();
        if (count >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) count];
        new u3(f2Var, jArr, 0).invoke();
        return new l3(jArr);
    }

    public static int I(long j) {
        return (j != -1 ? z6.f6452u : 0) | z6.f6451t;
    }

    public static b2 K(b2 b2Var) {
        if (b2Var.o() <= 0) {
            return b2Var;
        }
        long count = b2Var.count();
        if (count >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) count];
        new u3(b2Var, dArr, 0).invoke();
        return new t2(dArr);
    }

    @Override // j$.util.stream.f8
    public Object a(a aVar, Spliterator spliterator) {
        r4 Z = Z();
        aVar.Q(spliterator, Z);
        return Z.get();
    }

    @Override // j$.util.stream.f8
    public Object b(a aVar, Spliterator spliterator) {
        return ((r4) new y4(this, aVar, spliterator).invoke()).get();
    }
}
