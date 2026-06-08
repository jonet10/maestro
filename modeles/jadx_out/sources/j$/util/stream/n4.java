package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class n4 implements r4, k5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6293a;

    /* renamed from: b, reason: collision with root package name */
    public int f6294b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f6295c;

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

    public n4(IntBinaryOperator intBinaryOperator) {
        this.f6295c = intBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        n4 n4Var = (n4) r4Var;
        if (n4Var.f6293a) {
            return;
        }
        accept(n4Var.f6294b);
    }

    @Override // j$.util.stream.m5
    public final void c(long j) {
        this.f6293a = true;
        this.f6294b = 0;
    }

    @Override // j$.util.stream.m5
    public final void accept(int i) {
        if (this.f6293a) {
            this.f6293a = false;
            this.f6294b = i;
        } else {
            this.f6294b = this.f6295c.applyAsInt(this.f6294b, i);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f6293a ? j$.util.d0.f6032c : new j$.util.d0(this.f6294b);
    }
}
