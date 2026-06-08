package r8;

import java.io.IOException;
import w8.g0;
import w8.h;
import w8.i0;
import w8.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f9082a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9083b;

    /* renamed from: l, reason: collision with root package name */
    public long f9084l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g f9085m;

    public a(g gVar) {
        this.f9085m = gVar;
        this.f9082a = new r(gVar.f9101c.a());
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f9082a;
    }

    public final void b(boolean z9, IOException iOException) {
        g gVar = this.f9085m;
        int i = gVar.f9103e;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            com.google.gson.internal.a.f(gVar.f9103e, "state: ");
            return;
        }
        r rVar = this.f9082a;
        i0 i0Var = rVar.f10988e;
        rVar.f10988e = i0.f10962d;
        i0Var.a();
        i0Var.b();
        gVar.f9103e = 6;
        p8.e eVar = gVar.f9100b;
        if (eVar != null) {
            eVar.h(!z9, gVar, iOException);
        }
    }

    @Override // w8.g0
    public long p(h hVar, long j) {
        try {
            long p10 = this.f9085m.f9101c.p(hVar, j);
            if (p10 <= 0) {
                return p10;
            }
            this.f9084l += p10;
            return p10;
        } catch (IOException e10) {
            b(false, e10);
            throw e10;
        }
    }
}
