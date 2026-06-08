package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7762a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f7763b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f7764c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7765d;

    public n(o oVar) {
        this.f7762a = oVar.f7767a;
        this.f7763b = oVar.f7769c;
        this.f7764c = oVar.f7770d;
        this.f7765d = oVar.f7768b;
    }

    public final void a(String... strArr) {
        if (!this.f7762a) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.f7763b = (String[]) strArr.clone();
        } else {
            com.google.gson.internal.a.p("At least one cipher suite is required");
        }
    }

    public final void b(String... strArr) {
        if (!this.f7762a) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.f7764c = (String[]) strArr.clone();
        } else {
            com.google.gson.internal.a.p("At least one TLS version is required");
        }
    }

    public n(boolean z9) {
        this.f7762a = z9;
    }
}
