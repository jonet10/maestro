package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class f5 implements j5 {

    /* renamed from: a, reason: collision with root package name */
    public final m5 f6195a;

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
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d10) {
        w3.d(this, d10);
    }

    public f5(m5 m5Var) {
        this.f6195a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // j$.util.stream.m5
    public void c(long j) {
        this.f6195a.c(j);
    }

    @Override // j$.util.stream.m5
    public void end() {
        this.f6195a.end();
    }

    @Override // j$.util.stream.m5
    public boolean e() {
        return this.f6195a.e();
    }
}
