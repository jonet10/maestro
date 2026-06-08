package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p4 implements r4, l5 {

    /* renamed from: a, reason: collision with root package name */
    public long f6322a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6323b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f6324c;

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

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    public p4(long j, LongBinaryOperator longBinaryOperator) {
        this.f6323b = j;
        this.f6324c = longBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        accept(((p4) r4Var).f6322a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6322a = this.f6323b;
    }

    @Override // j$.util.stream.m5
    public final void accept(long j) {
        this.f6322a = this.f6324c.applyAsLong(this.f6322a, j);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f6322a);
    }
}
