package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class n7 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6304a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LongConsumer f6305b;

    public /* synthetic */ n7(LongConsumer longConsumer, int i) {
        this.f6304a = i;
        this.f6305b = longConsumer;
    }

    private final /* synthetic */ void a(long j) {
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d10) {
        switch (this.f6304a) {
            case 0:
                w3.c();
                throw null;
            default:
                w3.c();
                throw null;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        switch (this.f6304a) {
            case 0:
                w3.k();
                throw null;
            default:
                w3.k();
                throw null;
        }
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        switch (this.f6304a) {
            case 0:
                this.f6305b.accept(j);
                break;
            default:
                ((t6) this.f6305b).accept(j);
                break;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        switch (this.f6304a) {
            case 0:
                l((Long) obj);
                break;
            default:
                l((Long) obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f6304a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f6304a) {
        }
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j) {
        int i = this.f6304a;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f6304a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i = this.f6304a;
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        switch (this.f6304a) {
            case 0:
                w3.i(this, l10);
                break;
            default:
                w3.i(this, l10);
                break;
        }
    }
}
