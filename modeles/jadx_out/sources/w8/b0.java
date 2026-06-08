package w8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f10939a;

    /* renamed from: b, reason: collision with root package name */
    public int f10940b;

    /* renamed from: c, reason: collision with root package name */
    public int f10941c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10942d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10943e;
    public b0 f;
    public b0 g;

    public b0(byte[] bArr, int i, int i6, boolean z9) {
        bArr.getClass();
        this.f10939a = bArr;
        this.f10940b = i;
        this.f10941c = i6;
        this.f10942d = z9;
        this.f10943e = false;
    }

    public final b0 a() {
        b0 b0Var = this.f;
        if (b0Var == this) {
            b0Var = null;
        }
        b0 b0Var2 = this.g;
        b0Var2.getClass();
        b0Var2.f = this.f;
        b0 b0Var3 = this.f;
        b0Var3.getClass();
        b0Var3.g = this.g;
        this.f = null;
        this.g = null;
        return b0Var;
    }

    public final void b(b0 b0Var) {
        b0Var.getClass();
        b0Var.g = this;
        b0Var.f = this.f;
        b0 b0Var2 = this.f;
        b0Var2.getClass();
        b0Var2.g = b0Var;
        this.f = b0Var;
    }

    public final b0 c() {
        this.f10942d = true;
        return new b0(this.f10939a, this.f10940b, this.f10941c, true);
    }

    public final void d(b0 b0Var, int i) {
        b0Var.getClass();
        byte[] bArr = b0Var.f10939a;
        if (!b0Var.f10943e) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("only owner can write");
            return;
        }
        int i6 = b0Var.f10941c;
        int i10 = i6 + i;
        if (i10 > 8192) {
            if (b0Var.f10942d) {
                s1.o.n();
                return;
            }
            int i11 = b0Var.f10940b;
            if (i10 - i11 > 8192) {
                s1.o.n();
                return;
            } else {
                q6.j.Y(bArr, 0, bArr, i11, i6);
                b0Var.f10941c -= b0Var.f10940b;
                b0Var.f10940b = 0;
            }
        }
        int i12 = b0Var.f10941c;
        int i13 = this.f10940b;
        q6.j.Y(this.f10939a, i12, bArr, i13, i13 + i);
        b0Var.f10941c += i;
        this.f10940b += i;
    }

    public b0() {
        this.f10939a = new byte[8192];
        this.f10943e = true;
        this.f10942d = false;
    }
}
