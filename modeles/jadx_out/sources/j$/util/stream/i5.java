package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class i5 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public final m5 f6224a;

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

    public i5(m5 m5Var) {
        this.f6224a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // j$.util.stream.m5
    public void c(long j) {
        this.f6224a.c(j);
    }

    @Override // j$.util.stream.m5
    public void end() {
        this.f6224a.end();
    }

    @Override // j$.util.stream.m5
    public boolean e() {
        return this.f6224a.e();
    }
}
