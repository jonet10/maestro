package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class c0 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleStream f6155a;

    public /* synthetic */ c0(DoubleStream doubleStream) {
        this.f6155a = doubleStream;
    }

    public static /* synthetic */ e0 g(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof d0 ? ((d0) doubleStream).f6173a : new c0(doubleStream);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 a() {
        return g(this.f6155a.takeWhile(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 average() {
        return j$.util.c.j(this.f6155a.average());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Stream boxed() {
        return x6.g(this.f6155a.boxed());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 c() {
        return g(this.f6155a.filter(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f6155a.close();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f6155a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ long count() {
        return this.f6155a.count();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 d() {
        return g(this.f6155a.dropWhile(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 distinct() {
        return g(this.f6155a.distinct());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 e() {
        return g(this.f6155a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f6155a;
        if (obj instanceof c0) {
            obj = ((c0) obj).f6155a;
        }
        return doubleStream.equals(obj);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 findAny() {
        return j$.util.c.j(this.f6155a.findAny());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 findFirst() {
        return j$.util.c.j(this.f6155a.findFirst());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f6155a.forEach(doubleConsumer);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f6155a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6155a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f6155a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ j$.util.i0 iterator() {
        ?? it = this.f6155a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof j$.util.h0 ? ((j$.util.h0) it).f6066a : new j$.util.g0(it);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f6155a.iterator();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean k() {
        return this.f6155a.anyMatch(null);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 limit(long j) {
        return g(this.f6155a.limit(j));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return x6.g(this.f6155a.mapToObj(doubleFunction));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 max() {
        return j$.util.c.j(this.f6155a.max());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 min() {
        return j$.util.c.j(this.f6155a.min());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return e.g(this.f6155a.onClose(runnable));
    }

    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ e0 parallel() {
        return g(this.f6155a.parallel());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return e.g(this.f6155a.parallel());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 peek(DoubleConsumer doubleConsumer) {
        return g(this.f6155a.peek(doubleConsumer));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double reduce(double d10, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f6155a.reduce(d10, doubleBinaryOperator);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return j$.util.c.j(this.f6155a.reduce(doubleBinaryOperator));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean s() {
        return this.f6155a.allMatch(null);
    }

    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ e0 sequential() {
        return g(this.f6155a.sequential());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return e.g(this.f6155a.sequential());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 skip(long j) {
        return g(this.f6155a.skip(j));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 sorted() {
        return g(this.f6155a.sorted());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f6155a.spliterator());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ j$.util.v0 spliterator() {
        return j$.util.t0.a(this.f6155a.spliterator());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double sum() {
        return this.f6155a.sum();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ n1 t() {
        return l1.g(this.f6155a.mapToLong(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double[] toArray() {
        return this.f6155a.toArray();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return e.g(this.f6155a.unordered());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ IntStream w() {
        return IntStream.VivifiedWrapper.convert(this.f6155a.mapToInt(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean y() {
        return this.f6155a.noneMatch(null);
    }

    @Override // j$.util.stream.e0
    public final j$.util.x summaryStatistics() {
        this.f6155a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.e0
    public final e0 b(j$.util.q qVar) {
        DoubleStream doubleStream = this.f6155a;
        j$.util.q qVar2 = new j$.util.q(5);
        qVar2.f6104b = qVar;
        return g(doubleStream.flatMap(qVar2));
    }
}
