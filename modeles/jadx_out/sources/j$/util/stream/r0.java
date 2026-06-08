package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class r0 implements f8, g8 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6337a;

    public /* synthetic */ void accept(double d10) {
        w3.c();
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        w3.k();
        throw null;
    }

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
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public r0(boolean z9) {
        this.f6337a = z9;
    }

    @Override // j$.util.stream.f8
    public final int f() {
        if (this.f6337a) {
            return 0;
        }
        return z6.f6449r;
    }

    public final void g(a aVar, Spliterator spliterator) {
        if (this.f6337a) {
            new s0(aVar, spliterator, this).invoke();
        } else {
            new t0(aVar, spliterator, aVar.R(this)).invoke();
        }
    }
}
