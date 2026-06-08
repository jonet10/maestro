package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j4 extends s4 implements r4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f6238b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f6239c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f6240d;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f6352a = this.f6240d.apply(this.f6352a, ((j4) r4Var).f6352a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6352a = this.f6238b.get();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f6239c.accept(this.f6352a, obj);
    }

    public j4(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f6238b = supplier;
        this.f6239c = biConsumer;
        this.f6240d = binaryOperator;
    }
}
