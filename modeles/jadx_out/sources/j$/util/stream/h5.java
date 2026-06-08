package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class h5 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public final m5 f6214a;

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
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    public h5(m5 m5Var) {
        this.f6214a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // j$.util.stream.m5
    public void c(long j) {
        this.f6214a.c(j);
    }

    @Override // j$.util.stream.m5
    public void end() {
        this.f6214a.end();
    }

    @Override // j$.util.stream.m5
    public boolean e() {
        return this.f6214a.e();
    }
}
