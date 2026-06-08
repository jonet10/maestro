package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class a4 implements r4, j5 {

    /* renamed from: a, reason: collision with root package name */
    public double f6132a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f6133b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f6134c;

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

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d10) {
        w3.d(this, d10);
    }

    public a4(double d10, DoubleBinaryOperator doubleBinaryOperator) {
        this.f6133b = d10;
        this.f6134c = doubleBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        accept(((a4) r4Var).f6132a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6132a = this.f6133b;
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        this.f6132a = this.f6134c.applyAsDouble(this.f6132a, d10);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Double.valueOf(this.f6132a);
    }
}
