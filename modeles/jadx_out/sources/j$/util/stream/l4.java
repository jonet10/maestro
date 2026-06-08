package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l4 implements r4, k5 {

    /* renamed from: a, reason: collision with root package name */
    public int f6277a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6278b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f6279c;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        w3.c();
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
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public l4(int i, IntBinaryOperator intBinaryOperator) {
        this.f6278b = i;
        this.f6279c = intBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        accept(((l4) r4Var).f6277a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6277a = this.f6278b;
    }

    @Override // j$.util.stream.m5
    public final void accept(int i) {
        this.f6277a = this.f6279c.applyAsInt(this.f6277a, i);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f6277a);
    }
}
