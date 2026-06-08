package r8;

import a4.x;
import w8.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends a {

    /* renamed from: n, reason: collision with root package name */
    public boolean f9098n;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9083b) {
            return;
        }
        if (!this.f9098n) {
            b(false, null);
        }
        this.f9083b = true;
    }

    @Override // r8.a, w8.g0
    public final long p(h hVar, long j) {
        if (j < 0) {
            com.google.gson.internal.a.p(x.h(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.f9083b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return 0L;
        }
        if (this.f9098n) {
            return -1L;
        }
        long p10 = super.p(hVar, j);
        if (p10 != -1) {
            return p10;
        }
        this.f9098n = true;
        b(true, null);
        return -1L;
    }
}
