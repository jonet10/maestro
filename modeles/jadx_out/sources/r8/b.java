package r8;

import w8.e0;
import w8.h;
import w8.i;
import w8.i0;
import w8.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f9086a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9087b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g f9088l;

    public b(g gVar) {
        this.f9088l = gVar;
        this.f9086a = new r(gVar.f9102d.a());
    }

    @Override // w8.e0
    public final i0 a() {
        return this.f9086a;
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f9087b) {
            return;
        }
        this.f9087b = true;
        this.f9088l.f9102d.m("0\r\n\r\n");
        r rVar = this.f9086a;
        i0 i0Var = rVar.f10988e;
        rVar.f10988e = i0.f10962d;
        i0Var.a();
        i0Var.b();
        this.f9088l.f9103e = 3;
    }

    @Override // w8.e0, java.io.Flushable
    public final synchronized void flush() {
        if (this.f9087b) {
            return;
        }
        this.f9088l.f9102d.flush();
    }

    @Override // w8.e0
    public final void l(h hVar, long j) {
        i iVar = this.f9088l.f9102d;
        if (this.f9087b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
        } else {
            if (j == 0) {
                return;
            }
            iVar.o(j);
            iVar.m("\r\n");
            iVar.l(hVar, j);
            iVar.m("\r\n");
        }
    }
}
