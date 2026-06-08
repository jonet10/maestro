package f8;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends c8.a {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f4953a;

    /* renamed from: b, reason: collision with root package name */
    public final g8.f f4954b;

    public g(a0 a0Var, e8.b bVar) {
        bVar.getClass();
        this.f4953a = a0Var;
        this.f4954b = bVar.f4762b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[Catch: IllegalArgumentException -> 0x0030, TryCatch #0 {IllegalArgumentException -> 0x0030, blocks: (B:3:0x0007, B:5:0x0010, B:8:0x001f, B:10:0x0029, B:13:0x002c, B:14:0x002f), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: IllegalArgumentException -> 0x0030, TryCatch #0 {IllegalArgumentException -> 0x0030, blocks: (B:3:0x0007, B:5:0x0010, B:8:0x001f, B:10:0x0029, B:13:0x002c, B:14:0x002f), top: B:2:0x0007 }] */
    @Override // c8.a, c8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte decodeByte() {
        /*
            r6 = this;
            f8.a0 r0 = r6.f4953a
            java.lang.String r1 = r0.n()
            r2 = 0
            r1.getClass()     // Catch: java.lang.IllegalArgumentException -> L30
            p6.q r3 = b2.t1.O(r1)     // Catch: java.lang.IllegalArgumentException -> L30
            if (r3 == 0) goto L26
            int r3 = r3.f8456a     // Catch: java.lang.IllegalArgumentException -> L30
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 ^ r3
            r5 = -2147483393(0xffffffff800000ff, float:-3.57E-43)
            int r4 = java.lang.Integer.compare(r4, r5)     // Catch: java.lang.IllegalArgumentException -> L30
            if (r4 <= 0) goto L1f
            goto L26
        L1f:
            byte r3 = (byte) r3     // Catch: java.lang.IllegalArgumentException -> L30
            p6.o r4 = new p6.o     // Catch: java.lang.IllegalArgumentException -> L30
            r4.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L30
            goto L27
        L26:
            r4 = r2
        L27:
            if (r4 == 0) goto L2c
            byte r0 = r4.f8454a     // Catch: java.lang.IllegalArgumentException -> L30
            return r0
        L2c:
            l7.t.g0(r1)     // Catch: java.lang.IllegalArgumentException -> L30
            throw r2     // Catch: java.lang.IllegalArgumentException -> L30
        L30:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to parse type 'UByte' for input '"
            r3.<init>(r4)
            r3.append(r1)
            r1 = 39
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            r4 = 6
            f8.a0.p(r0, r1, r3, r2, r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.g.decodeByte():byte");
    }

    @Override // c8.c
    public final int decodeElementIndex(b8.e eVar) {
        eVar.getClass();
        throw new IllegalStateException("unsupported");
    }

    @Override // c8.a, c8.e
    public final int decodeInt() {
        a0 a0Var = this.f4953a;
        String n10 = a0Var.n();
        try {
            n10.getClass();
            p6.q O = t1.O(n10);
            if (O != null) {
                return O.f8456a;
            }
            l7.t.g0(n10);
            throw null;
        } catch (IllegalArgumentException unused) {
            a0.p(a0Var, "Failed to parse type 'UInt' for input '" + n10 + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // c8.a, c8.e
    public final long decodeLong() {
        a0 a0Var = this.f4953a;
        String n10 = a0Var.n();
        try {
            n10.getClass();
            p6.s P = t1.P(n10);
            if (P != null) {
                return P.f8458a;
            }
            l7.t.g0(n10);
            throw null;
        } catch (IllegalArgumentException unused) {
            a0.p(a0Var, "Failed to parse type 'ULong' for input '" + n10 + '\'', 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[Catch: IllegalArgumentException -> 0x0030, TryCatch #0 {IllegalArgumentException -> 0x0030, blocks: (B:3:0x0007, B:5:0x0010, B:8:0x001f, B:10:0x0029, B:13:0x002c, B:14:0x002f), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[Catch: IllegalArgumentException -> 0x0030, TryCatch #0 {IllegalArgumentException -> 0x0030, blocks: (B:3:0x0007, B:5:0x0010, B:8:0x001f, B:10:0x0029, B:13:0x002c, B:14:0x002f), top: B:2:0x0007 }] */
    @Override // c8.a, c8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final short decodeShort() {
        /*
            r6 = this;
            f8.a0 r0 = r6.f4953a
            java.lang.String r1 = r0.n()
            r2 = 0
            r1.getClass()     // Catch: java.lang.IllegalArgumentException -> L30
            p6.q r3 = b2.t1.O(r1)     // Catch: java.lang.IllegalArgumentException -> L30
            if (r3 == 0) goto L26
            int r3 = r3.f8456a     // Catch: java.lang.IllegalArgumentException -> L30
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 ^ r3
            r5 = -2147418113(0xffffffff8000ffff, float:-9.1834E-41)
            int r4 = java.lang.Integer.compare(r4, r5)     // Catch: java.lang.IllegalArgumentException -> L30
            if (r4 <= 0) goto L1f
            goto L26
        L1f:
            short r3 = (short) r3     // Catch: java.lang.IllegalArgumentException -> L30
            p6.v r4 = new p6.v     // Catch: java.lang.IllegalArgumentException -> L30
            r4.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L30
            goto L27
        L26:
            r4 = r2
        L27:
            if (r4 == 0) goto L2c
            short r0 = r4.f8461a     // Catch: java.lang.IllegalArgumentException -> L30
            return r0
        L2c:
            l7.t.g0(r1)     // Catch: java.lang.IllegalArgumentException -> L30
            throw r2     // Catch: java.lang.IllegalArgumentException -> L30
        L30:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to parse type 'UShort' for input '"
            r3.<init>(r4)
            r3.append(r1)
            r1 = 39
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            r4 = 6
            f8.a0.p(r0, r1, r3, r2, r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.g.decodeShort():short");
    }

    @Override // c8.c
    public final g8.f getSerializersModule() {
        return this.f4954b;
    }
}
