package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o2 {

    /* renamed from: a, reason: collision with root package name */
    public long f11307a;

    /* renamed from: b, reason: collision with root package name */
    public int f11308b;

    /* renamed from: c, reason: collision with root package name */
    public int f11309c;

    /* renamed from: d, reason: collision with root package name */
    public String f11310d;

    /* renamed from: e, reason: collision with root package name */
    public String f11311e;
    public String f;
    public String g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.f11307a == o2Var.f11307a && this.f11308b == o2Var.f11308b && this.f11309c == o2Var.f11309c && kotlin.jvm.internal.l.a(this.f11310d, o2Var.f11310d) && kotlin.jvm.internal.l.a(this.f11311e, o2Var.f11311e) && kotlin.jvm.internal.l.a(this.f, o2Var.f) && kotlin.jvm.internal.l.a(this.g, o2Var.g);
    }

    public final int hashCode() {
        long j = this.f11307a;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.f11308b) * 31) + this.f11309c) * 31;
        String str = this.f11310d;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f11311e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        long j = this.f11307a;
        int i = this.f11308b;
        int i6 = this.f11309c;
        String str = this.f11310d;
        String str2 = this.f11311e;
        String str3 = this.f;
        String str4 = this.g;
        StringBuilder sb = new StringBuilder("FloatingCategoryTopExtraData(lastUpdate=");
        sb.append(j);
        sb.append(", totalApps=");
        sb.append(i);
        sb.append(", editorID=");
        sb.append(i6);
        sb.append(", editorName=");
        sb.append(str);
        a4.x.B(sb, ", editorAvatar=", str2, ", editorJobTitle=", str3);
        return a4.x.o(sb, ", url=", str4, ")");
    }
}
