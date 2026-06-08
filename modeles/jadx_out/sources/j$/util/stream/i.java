package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class i implements Collector {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ java.util.stream.Collector f6219a;

    public /* synthetic */ i(java.util.stream.Collector collector) {
        this.f6219a = collector;
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ BiConsumer accumulator() {
        return this.f6219a.accumulator();
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Set characteristics() {
        return w3.N(this.f6219a.characteristics());
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ BinaryOperator combiner() {
        return this.f6219a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Collector collector = this.f6219a;
        if (obj instanceof i) {
            obj = ((i) obj).f6219a;
        }
        return collector.equals(obj);
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Function finisher() {
        return this.f6219a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f6219a.hashCode();
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Supplier supplier() {
        return this.f6219a.supplier();
    }
}
