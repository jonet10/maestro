package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k implements Collector {

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f6249a;

    /* renamed from: b, reason: collision with root package name */
    public final BiConsumer f6250b;

    /* renamed from: c, reason: collision with root package name */
    public final BinaryOperator f6251c;

    /* renamed from: d, reason: collision with root package name */
    public final Function f6252d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f6253e;

    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.f6249a = supplier;
        this.f6250b = biConsumer;
        this.f6251c = binaryOperator;
        this.f6252d = function;
        this.f6253e = set;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new j$.time.format.a(16), set);
        Set set2 = Collectors.f6120a;
    }

    @Override // j$.util.stream.Collector
    public final BiConsumer accumulator() {
        return this.f6250b;
    }

    @Override // j$.util.stream.Collector
    public final Supplier supplier() {
        return this.f6249a;
    }

    @Override // j$.util.stream.Collector
    public final BinaryOperator combiner() {
        return this.f6251c;
    }

    @Override // j$.util.stream.Collector
    public final Function finisher() {
        return this.f6252d;
    }

    @Override // j$.util.stream.Collector
    public final Set characteristics() {
        return this.f6253e;
    }
}
