package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class t1 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6362a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6363b;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(int i) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(long j) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j) {
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public t1(u1 u1Var) {
        this.f6363b = !u1Var.f6379b;
    }

    @Override // j$.util.stream.m5
    public final boolean e() {
        return this.f6362a;
    }
}
