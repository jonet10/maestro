package o8;

import a2.t;
import java.io.IOException;
import w8.h;
import w8.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends p {

    /* renamed from: b, reason: collision with root package name */
    public boolean f8343b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8344l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8345m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, w8.b bVar, int i) {
        super(bVar);
        this.f8344l = i;
        this.f8345m = obj;
    }

    public final void b() {
        switch (this.f8344l) {
            case 0:
                ((f) this.f8345m).v = true;
                return;
            default:
                synchronized (((f) ((t) this.f8345m).f55d)) {
                    ((t) this.f8345m).e();
                }
                return;
        }
    }

    @Override // w8.p, w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f8343b) {
            return;
        }
        try {
            super.close();
        } catch (IOException unused) {
            this.f8343b = true;
            b();
        }
    }

    @Override // w8.p, w8.e0, java.io.Flushable
    public final void flush() {
        if (this.f8343b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException unused) {
            this.f8343b = true;
            b();
        }
    }

    @Override // w8.p, w8.e0
    public final void l(h hVar, long j) {
        if (this.f8343b) {
            hVar.skip(j);
            return;
        }
        try {
            this.f10986a.l(hVar, j);
        } catch (IOException unused) {
            this.f8343b = true;
            b();
        }
    }
}
