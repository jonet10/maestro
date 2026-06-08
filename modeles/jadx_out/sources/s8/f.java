package s8;

import java.io.IOException;
import w8.g0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends w8.q {

    /* renamed from: b, reason: collision with root package name */
    public boolean f9397b;

    /* renamed from: l, reason: collision with root package name */
    public long f9398l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g f9399m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, g0 g0Var) {
        super(g0Var);
        this.f9399m = gVar;
        this.f9397b = false;
        this.f9398l = 0L;
    }

    @Override // w8.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        if (this.f9397b) {
            return;
        }
        this.f9397b = true;
        g gVar = this.f9399m;
        gVar.f9402b.h(false, gVar, null);
    }

    @Override // w8.q, w8.g0
    public final long p(w8.h hVar, long j) {
        try {
            long p10 = this.f10987a.p(hVar, j);
            if (p10 <= 0) {
                return p10;
            }
            this.f9398l += p10;
            return p10;
        } catch (IOException e10) {
            if (!this.f9397b) {
                this.f9397b = true;
                g gVar = this.f9399m;
                gVar.f9402b.h(false, gVar, e10);
            }
            throw e10;
        }
    }
}
