package e1;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public String f4141l;

    /* renamed from: m, reason: collision with root package name */
    public String f4142m;

    /* renamed from: n, reason: collision with root package name */
    public int f4143n;

    /* renamed from: o, reason: collision with root package name */
    public String f4144o;

    /* renamed from: p, reason: collision with root package name */
    public String f4145p;

    /* renamed from: q, reason: collision with root package name */
    public long f4146q;

    /* renamed from: r, reason: collision with root package name */
    public final long f4147r;

    /* renamed from: s, reason: collision with root package name */
    public final long f4148s;

    /* renamed from: t, reason: collision with root package name */
    public List f4149t;

    /* renamed from: u, reason: collision with root package name */
    public String f4150u;
    public int v;

    /* renamed from: w, reason: collision with root package name */
    public String f4151w;

    /* renamed from: x, reason: collision with root package name */
    public String f4152x;

    /* renamed from: y, reason: collision with root package name */
    public long f4153y;

    /* renamed from: z, reason: collision with root package name */
    public String f4154z;

    public n0(t1 t1Var, long j, long j6) {
        super(t1Var);
        this.f4153y = 0L;
        this.f4154z = null;
        this.f4147r = j;
        this.f4148s = j6;
    }

    @Override // e1.h0
    public final boolean j() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0103  */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.c5 k(java.lang.String r45) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.n0.k(java.lang.String):e1.c5");
    }

    public final void l() {
        String format;
        g();
        t1 t1Var = this.f3875a;
        g1 g1Var = t1Var.f4263n;
        w0 w0Var = t1Var.f4264o;
        t1.k(g1Var);
        if (g1Var.n().i(i2.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            a5 a5Var = t1Var.f4267r;
            t1.k(a5Var);
            a5Var.e0().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            t1.m(w0Var);
            w0Var.v.b("Analytics Storage consent is not granted");
            format = null;
        }
        t1.m(w0Var);
        w0Var.v.b("Resetting session stitching token to ".concat(format == null ? "null" : "not null"));
        this.f4152x = format;
        t1Var.f4269t.getClass();
        this.f4153y = System.currentTimeMillis();
    }

    public final String m() {
        h();
        k0.y.g(this.f4141l);
        return this.f4141l;
    }

    public final String n() {
        g();
        h();
        k0.y.g(this.f4151w);
        return this.f4151w;
    }
}
