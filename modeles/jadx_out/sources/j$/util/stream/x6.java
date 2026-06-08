package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class x6 implements Stream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ java.util.stream.Stream f6426a;

    public /* synthetic */ x6(java.util.stream.Stream stream) {
        this.f6426a = stream;
    }

    public static /* synthetic */ Stream g(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new x6(stream);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f6426a.allMatch(predicate);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f6426a.anyMatch(predicate);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream b(j$.util.q qVar) {
        return g(this.f6426a.flatMap(w3.O(qVar)));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f6426a.close();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object collect(Collector collector) {
        return this.f6426a.collect(collector == null ? null : collector instanceof i ? ((i) collector).f6219a : new j(collector));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f6426a.collect(supplier, biConsumer, biConsumer2);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ long count() {
        return this.f6426a.count();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return g(this.f6426a.distinct());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return g(this.f6426a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.f6426a;
        if (obj instanceof x6) {
            obj = ((x6) obj).f6426a;
        }
        return stream.equals(obj);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream filter(Predicate predicate) {
        return g(this.f6426a.filter(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 findAny() {
        return j$.util.c.i(this.f6426a.findAny());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 findFirst() {
        return j$.util.c.i(this.f6426a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f6426a.forEach(consumer);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f6426a.forEachOrdered(consumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6426a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f6426a.isParallel();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f6426a.iterator();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ n1 l(j$.util.q qVar) {
        return l1.g(this.f6426a.flatMapToLong(w3.O(qVar)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream limit(long j) {
        return g(this.f6426a.limit(j));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream map(Function function) {
        return g(this.f6426a.map(function));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ e0 mapToDouble(ToDoubleFunction toDoubleFunction) {
        return c0.g(this.f6426a.mapToDouble(toDoubleFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f6426a.mapToInt(toIntFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ n1 mapToLong(ToLongFunction toLongFunction) {
        return l1.g(this.f6426a.mapToLong(toLongFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 max(Comparator comparator) {
        return j$.util.c.i(this.f6426a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 min(Comparator comparator) {
        return j$.util.c.i(this.f6426a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f6426a.noneMatch(predicate);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return e.g(this.f6426a.onClose(runnable));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ e0 p(j$.util.q qVar) {
        return c0.g(this.f6426a.flatMapToDouble(w3.O(qVar)));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return e.g(this.f6426a.parallel());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream peek(Consumer consumer) {
        return g(this.f6426a.peek(consumer));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream r(j$.util.q qVar) {
        return IntStream.VivifiedWrapper.convert(this.f6426a.flatMapToInt(w3.O(qVar)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 reduce(BinaryOperator binaryOperator) {
        return j$.util.c.i(this.f6426a.reduce(binaryOperator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f6426a.reduce(obj, biFunction, binaryOperator);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f6426a.reduce(obj, binaryOperator);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return e.g(this.f6426a.sequential());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream skip(long j) {
        return g(this.f6426a.skip(j));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted() {
        return g(this.f6426a.sorted());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return g(this.f6426a.sorted(comparator));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f6426a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return g(this.f6426a.takeWhile(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray() {
        return this.f6426a.toArray();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f6426a.toArray(intFunction);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ List toList() {
        return this.f6426a.toList();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return e.g(this.f6426a.unordered());
    }
}
