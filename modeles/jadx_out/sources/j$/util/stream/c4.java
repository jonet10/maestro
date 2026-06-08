package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class c4 implements r4, j5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6161a;

    /* renamed from: b, reason: collision with root package name */
    public double f6162b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f6163c;

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

    public c4(DoubleBinaryOperator doubleBinaryOperator) {
        this.f6163c = doubleBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        c4 c4Var = (c4) r4Var;
        if (c4Var.f6161a) {
            return;
        }
        accept(c4Var.f6162b);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6161a = true;
        this.f6162b = 0.0d;
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        if (this.f6161a) {
            this.f6161a = false;
            this.f6162b = d10;
        } else {
            this.f6162b = this.f6163c.applyAsDouble(this.f6162b, d10);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f6161a ? j$.util.c0.f5975c : new j$.util.c0(this.f6162b);
    }
}
