package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class l1 implements n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongStream f6273a;

    public /* synthetic */ l1(LongStream longStream) {
        this.f6273a = longStream;
    }

    public static /* synthetic */ n1 g(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof m1 ? ((m1) longStream).f6287a : new l1(longStream);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 a() {
        return g(this.f6273a.takeWhile(null));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ e0 asDoubleStream() {
        return c0.g(this.f6273a.asDoubleStream());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.c0 average() {
        return j$.util.c.j(this.f6273a.average());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ Stream boxed() {
        return x6.g(this.f6273a.boxed());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 c() {
        return g(this.f6273a.filter(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f6273a.close();
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f6273a.collect(supplier, objLongConsumer, biConsumer);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ long count() {
        return this.f6273a.count();
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 d() {
        return g(this.f6273a.dropWhile(null));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 distinct() {
        return g(this.f6273a.distinct());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 e() {
        return g(this.f6273a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.f6273a;
        if (obj instanceof l1) {
            obj = ((l1) obj).f6273a;
        }
        return longStream.equals(obj);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.e0 findAny() {
        return j$.util.c.l(this.f6273a.findAny());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.e0 findFirst() {
        return j$.util.c.l(this.f6273a.findFirst());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f6273a.forEach(longConsumer);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f6273a.forEachOrdered(longConsumer);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ e0 h() {
        return c0.g(this.f6273a.mapToDouble(null));
    }

    public final /* synthetic */ int hashCode() {
        return this.f6273a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f6273a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
    @Override // j$.util.stream.n1, j$.util.stream.g
    public final /* synthetic */ j$.util.q0 iterator() {
        ?? it = this.f6273a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof j$.util.p0 ? ((j$.util.p0) it).f6102a : new j$.util.o0(it);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f6273a.iterator();
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ boolean j() {
        return this.f6273a.noneMatch(null);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 limit(long j) {
        return g(this.f6273a.limit(j));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return x6.g(this.f6273a.mapToObj(longFunction));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.e0 max() {
        return j$.util.c.l(this.f6273a.max());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.e0 min() {
        return j$.util.c.l(this.f6273a.min());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ boolean n() {
        return this.f6273a.anyMatch(null);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return e.g(this.f6273a.onClose(runnable));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return e.g(this.f6273a.parallel());
    }

    @Override // j$.util.stream.n1, j$.util.stream.g
    public final /* synthetic */ n1 parallel() {
        return g(this.f6273a.parallel());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 peek(LongConsumer longConsumer) {
        return g(this.f6273a.peek(longConsumer));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.f6273a.reduce(j, longBinaryOperator);
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ j$.util.e0 reduce(LongBinaryOperator longBinaryOperator) {
        return j$.util.c.l(this.f6273a.reduce(longBinaryOperator));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return e.g(this.f6273a.sequential());
    }

    @Override // j$.util.stream.n1, j$.util.stream.g
    public final /* synthetic */ n1 sequential() {
        return g(this.f6273a.sequential());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 skip(long j) {
        return g(this.f6273a.skip(j));
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ n1 sorted() {
        return g(this.f6273a.sorted());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f6273a.spliterator());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
    @Override // j$.util.stream.n1, j$.util.stream.g
    public final /* synthetic */ j$.util.b1 spliterator() {
        return j$.util.z0.a(this.f6273a.spliterator());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ long sum() {
        return this.f6273a.sum();
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ long[] toArray() {
        return this.f6273a.toArray();
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ boolean u() {
        return this.f6273a.allMatch(null);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return e.g(this.f6273a.unordered());
    }

    @Override // j$.util.stream.n1
    public final /* synthetic */ IntStream x() {
        return IntStream.VivifiedWrapper.convert(this.f6273a.mapToInt(null));
    }

    @Override // j$.util.stream.n1
    public final j$.util.a0 summaryStatistics() {
        this.f6273a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.n1
    public final n1 b(j$.util.q qVar) {
        LongStream longStream = this.f6273a;
        j$.util.q qVar2 = new j$.util.q(7);
        qVar2.f6104b = qVar;
        return g(longStream.flatMap(qVar2));
    }
}
