package r8;

import java.io.IOException;
import m8.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends a {

    /* renamed from: n, reason: collision with root package name */
    public final u f9089n;

    /* renamed from: o, reason: collision with root package name */
    public long f9090o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9091p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ g f9092q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, u uVar) {
        super(gVar);
        this.f9092q = gVar;
        this.f9090o = -1L;
        this.f9091p = true;
        this.f9089n = uVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z9;
        if (this.f9083b) {
            return;
        }
        if (this.f9091p) {
            try {
                z9 = n8.c.p(this, 100);
            } catch (IOException unused) {
                z9 = false;
            }
            if (!z9) {
                b(false, null);
            }
        }
        this.f9083b = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        if (r16.f9091p == false) goto L34;
     */
    @Override // r8.a, w8.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p(w8.h r17, long r18) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.c.p(w8.h, long):long");
    }
}
