package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class l7 implements k5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6282a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntConsumer f6283b;

    public /* synthetic */ l7(IntConsumer intConsumer, int i) {
        this.f6282a = i;
        this.f6283b = intConsumer;
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
        switch (this.f6282a) {
            case 0:
                w3.c();
                throw null;
            default:
                w3.c();
                throw null;
        }
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        switch (this.f6282a) {
            case 0:
                this.f6283b.accept(i);
                break;
            default:
                ((r6) this.f6283b).accept(i);
                break;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        switch (this.f6282a) {
            case 0:
                w3.l();
                throw null;
            default:
                w3.l();
                throw null;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        switch (this.f6282a) {
            case 0:
                d((Integer) obj);
                break;
            default:
                d((Integer) obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f6282a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f6282a) {
        }
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j) {
        int i = this.f6282a;
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        switch (this.f6282a) {
            case 0:
                w3.g(this, num);
                break;
            default:
                w3.g(this, num);
                break;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f6282a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i = this.f6282a;
    }
}
