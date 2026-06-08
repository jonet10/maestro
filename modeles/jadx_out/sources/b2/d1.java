package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public f1 f767a;

    /* renamed from: b, reason: collision with root package name */
    public String f768b;

    /* renamed from: c, reason: collision with root package name */
    public String f769c;

    /* renamed from: d, reason: collision with root package name */
    public long f770d;

    /* renamed from: e, reason: collision with root package name */
    public byte f771e;

    public final e1 a() {
        f1 f1Var;
        String str;
        String str2;
        if (this.f771e == 1 && (f1Var = this.f767a) != null && (str = this.f768b) != null && (str2 = this.f769c) != null) {
            return new e1(f1Var, str, str2, this.f770d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f767a == null) {
            sb.append(" rolloutVariant");
        }
        if (this.f768b == null) {
            sb.append(" parameterKey");
        }
        if (this.f769c == null) {
            sb.append(" parameterValue");
        }
        if ((1 & this.f771e) == 0) {
            sb.append(" templateVersion");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
