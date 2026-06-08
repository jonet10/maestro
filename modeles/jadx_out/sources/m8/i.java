package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: n, reason: collision with root package name */
    public static final i f7734n;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7735a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7736b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7737c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7738d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7739e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7740k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7741l;

    /* renamed from: m, reason: collision with root package name */
    public String f7742m;

    static {
        h hVar = new h();
        hVar.f7733d = true;
        long j = Integer.MAX_VALUE;
        hVar.f7732c = j <= 2147483647L ? (int) j : Integer.MAX_VALUE;
        f7734n = new i(hVar);
    }

    public i(h hVar) {
        this.f7735a = hVar.f7730a;
        this.f7736b = hVar.f7731b;
        this.f7737c = -1;
        this.f7738d = -1;
        this.f7739e = false;
        this.f = false;
        this.g = false;
        this.h = hVar.f7732c;
        this.i = -1;
        this.j = hVar.f7733d;
        this.f7740k = false;
        this.f7741l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m8.i a(m8.s r23) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.i.a(m8.s):m8.i");
    }

    public final String toString() {
        String sb;
        String str = this.f7742m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f7735a) {
            sb2.append("no-cache, ");
        }
        if (this.f7736b) {
            sb2.append("no-store, ");
        }
        int i = this.f7737c;
        if (i != -1) {
            sb2.append("max-age=");
            sb2.append(i);
            sb2.append(", ");
        }
        int i6 = this.f7738d;
        if (i6 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i6);
            sb2.append(", ");
        }
        if (this.f7739e) {
            sb2.append("private, ");
        }
        if (this.f) {
            sb2.append("public, ");
        }
        if (this.g) {
            sb2.append("must-revalidate, ");
        }
        int i10 = this.h;
        if (i10 != -1) {
            sb2.append("max-stale=");
            sb2.append(i10);
            sb2.append(", ");
        }
        int i11 = this.i;
        if (i11 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i11);
            sb2.append(", ");
        }
        if (this.j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f7740k) {
            sb2.append("no-transform, ");
        }
        if (this.f7741l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            sb = "";
        } else {
            sb2.delete(sb2.length() - 2, sb2.length());
            sb = sb2.toString();
        }
        this.f7742m = sb;
        return sb;
    }

    public i(boolean z9, boolean z10, int i, int i6, boolean z11, boolean z12, boolean z13, int i10, int i11, boolean z14, boolean z15, boolean z16, String str) {
        this.f7735a = z9;
        this.f7736b = z10;
        this.f7737c = i;
        this.f7738d = i6;
        this.f7739e = z11;
        this.f = z12;
        this.g = z13;
        this.h = i10;
        this.i = i11;
        this.j = z14;
        this.f7740k = z15;
        this.f7741l = z16;
        this.f7742m = str;
    }
}
