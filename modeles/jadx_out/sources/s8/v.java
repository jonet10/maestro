package s8;

import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends w8.d {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f9464m;

    public v(w wVar) {
        this.f9464m = wVar;
    }

    @Override // w8.d
    public final void j() {
        w wVar = this.f9464m;
        if (wVar.d(6)) {
            wVar.f9468d.j(wVar.f9467c, 6);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
