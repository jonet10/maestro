package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o4 extends s4 implements r4, k5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f6311b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f6312c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f6313d;

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

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f6352a = this.f6313d.apply(this.f6352a, ((o4) r4Var).f6352a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6352a = this.f6311b.get();
    }

    @Override // j$.util.stream.m5
    public final void accept(int i) {
        this.f6312c.accept(this.f6352a, i);
    }

    public o4(Supplier supplier, ObjIntConsumer objIntConsumer, p pVar) {
        this.f6311b = supplier;
        this.f6312c = objIntConsumer;
        this.f6313d = pVar;
    }
}
