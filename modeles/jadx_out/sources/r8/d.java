package r8;

import java.net.ProtocolException;
import w8.e0;
import w8.h;
import w8.i0;
import w8.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f9093a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9094b;

    /* renamed from: l, reason: collision with root package name */
    public long f9095l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g f9096m;

    public d(g gVar, long j) {
        this.f9096m = gVar;
        this.f9093a = new r(gVar.f9102d.a());
        this.f9095l = j;
    }

    @Override // w8.e0
    public final i0 a() {
        return this.f9093a;
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9094b) {
            return;
        }
        this.f9094b = true;
        if (this.f9095l > 0) {
            throw new ProtocolException("unexpected end of stream");
        }
        r rVar = this.f9093a;
        i0 i0Var = rVar.f10988e;
        rVar.f10988e = i0.f10962d;
        i0Var.a();
        i0Var.b();
        this.f9096m.f9103e = 3;
    }

    @Override // w8.e0, java.io.Flushable
    public final void flush() {
        if (this.f9094b) {
            return;
        }
        this.f9096m.f9102d.flush();
    }

    @Override // w8.e0
    public final void l(h hVar, long j) {
        if (this.f9094b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return;
        }
        long j6 = hVar.f10961b;
        byte[] bArr = n8.c.f8114a;
        if (j < 0 || 0 > j6 || j6 < j) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (j <= this.f9095l) {
            this.f9096m.f9102d.l(hVar, j);
            this.f9095l -= j;
            return;
        }
        throw new ProtocolException("expected " + this.f9095l + " bytes but received " + j);
    }
}
