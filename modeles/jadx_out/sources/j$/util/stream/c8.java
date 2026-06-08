package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class c8 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6166a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f6167b;

    public /* synthetic */ c8(Consumer consumer, int i) {
        this.f6166a = i;
        this.f6167b = consumer;
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
        switch (this.f6166a) {
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
        switch (this.f6166a) {
            case 0:
                w3.k();
                throw null;
            default:
                w3.k();
                throw null;
        }
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        switch (this.f6166a) {
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
    public final void n(Object obj) {
        switch (this.f6166a) {
            case 0:
                ((w6) this.f6167b).n(obj);
                break;
            default:
                this.f6167b.n(obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f6166a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j) {
        int i = this.f6166a;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        switch (this.f6166a) {
        }
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
        int i = this.f6166a;
    }
}
