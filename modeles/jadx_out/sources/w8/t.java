package w8;

import java.util.zip.Inflater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f10994a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f10995b;

    /* renamed from: l, reason: collision with root package name */
    public int f10996l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10997m;

    public t(a0 a0Var, Inflater inflater) {
        this.f10994a = a0Var;
        this.f10995b = inflater;
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f10994a.f10933a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f10997m) {
            return;
        }
        this.f10995b.end();
        this.f10997m = true;
        this.f10994a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC] */
    @Override // w8.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p(w8.h r11, long r12) {
        /*
            r10 = this;
            r11.getClass()
        L3:
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto Lb3
            boolean r3 = r10.f10997m
            if (r3 != 0) goto Lab
            w8.a0 r3 = r10.f10994a
            java.util.zip.Inflater r4 = r10.f10995b
            if (r2 != 0) goto L15
        L13:
            r8 = r0
            goto L80
        L15:
            r2 = 1
            w8.b0 r2 = r11.u(r2)     // Catch: java.util.zip.DataFormatException -> L6e
            int r5 = r2.f10941c     // Catch: java.util.zip.DataFormatException -> L6e
            int r5 = 8192 - r5
            long r5 = (long) r5     // Catch: java.util.zip.DataFormatException -> L6e
            long r5 = java.lang.Math.min(r12, r5)     // Catch: java.util.zip.DataFormatException -> L6e
            int r5 = (int) r5     // Catch: java.util.zip.DataFormatException -> L6e
            boolean r6 = r4.needsInput()     // Catch: java.util.zip.DataFormatException -> L6e
            if (r6 != 0) goto L2b
            goto L45
        L2b:
            boolean r6 = r3.b()     // Catch: java.util.zip.DataFormatException -> L6e
            if (r6 == 0) goto L32
            goto L45
        L32:
            w8.h r6 = r3.f10934b     // Catch: java.util.zip.DataFormatException -> L6e
            w8.b0 r6 = r6.f10960a     // Catch: java.util.zip.DataFormatException -> L6e
            r6.getClass()     // Catch: java.util.zip.DataFormatException -> L6e
            int r7 = r6.f10941c     // Catch: java.util.zip.DataFormatException -> L6e
            int r8 = r6.f10940b     // Catch: java.util.zip.DataFormatException -> L6e
            int r7 = r7 - r8
            r10.f10996l = r7     // Catch: java.util.zip.DataFormatException -> L6e
            byte[] r6 = r6.f10939a     // Catch: java.util.zip.DataFormatException -> L6e
            r4.setInput(r6, r8, r7)     // Catch: java.util.zip.DataFormatException -> L6e
        L45:
            byte[] r6 = r2.f10939a     // Catch: java.util.zip.DataFormatException -> L6e
            int r7 = r2.f10941c     // Catch: java.util.zip.DataFormatException -> L6e
            int r5 = r4.inflate(r6, r7, r5)     // Catch: java.util.zip.DataFormatException -> L6e
            int r6 = r10.f10996l     // Catch: java.util.zip.DataFormatException -> L6e
            if (r6 != 0) goto L52
            goto L60
        L52:
            int r7 = r4.getRemaining()     // Catch: java.util.zip.DataFormatException -> L6e
            int r6 = r6 - r7
            int r7 = r10.f10996l     // Catch: java.util.zip.DataFormatException -> L6e
            int r7 = r7 - r6
            r10.f10996l = r7     // Catch: java.util.zip.DataFormatException -> L6e
            long r6 = (long) r6     // Catch: java.util.zip.DataFormatException -> L6e
            r3.skip(r6)     // Catch: java.util.zip.DataFormatException -> L6e
        L60:
            if (r5 <= 0) goto L70
            int r6 = r2.f10941c     // Catch: java.util.zip.DataFormatException -> L6e
            int r6 = r6 + r5
            r2.f10941c = r6     // Catch: java.util.zip.DataFormatException -> L6e
            long r6 = r11.f10961b     // Catch: java.util.zip.DataFormatException -> L6e
            long r8 = (long) r5     // Catch: java.util.zip.DataFormatException -> L6e
            long r6 = r6 + r8
            r11.f10961b = r6     // Catch: java.util.zip.DataFormatException -> L6e
            goto L80
        L6e:
            r11 = move-exception
            goto La5
        L70:
            int r5 = r2.f10940b     // Catch: java.util.zip.DataFormatException -> L6e
            int r6 = r2.f10941c     // Catch: java.util.zip.DataFormatException -> L6e
            if (r5 != r6) goto L13
            w8.b0 r5 = r2.a()     // Catch: java.util.zip.DataFormatException -> L6e
            r11.f10960a = r5     // Catch: java.util.zip.DataFormatException -> L6e
            w8.c0.a(r2)     // Catch: java.util.zip.DataFormatException -> L6e
            goto L13
        L80:
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 <= 0) goto L85
            return r8
        L85:
            boolean r0 = r4.finished()
            if (r0 != 0) goto La2
            boolean r0 = r4.needsDictionary()
            if (r0 == 0) goto L92
            goto La2
        L92:
            boolean r0 = r3.b()
            if (r0 != 0) goto L9a
            goto L3
        L9a:
            java.io.EOFException r11 = new java.io.EOFException
            java.lang.String r12 = "source exhausted prematurely"
            r11.<init>(r12)
            throw r11
        La2:
            r11 = -1
            return r11
        La5:
            java.io.IOException r12 = new java.io.IOException
            r12.<init>(r11)
            throw r12
        Lab:
            java.lang.String r11 = "closed"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
        Lb0:
            r11 = 0
            return r11
        Lb3:
            java.lang.String r11 = "byteCount < 0: "
            java.lang.String r11 = a4.x.h(r12, r11)
            s1.o.o(r11)
            goto Lb0
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.t.p(w8.h, long):long");
    }
}
