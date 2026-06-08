package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11422a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11423b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11424c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11425d;

    public v2(String str, int i, int i6, int i10) {
        str.getClass();
        this.f11422a = str;
        this.f11423b = i;
        this.f11424c = i6;
        this.f11425d = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return kotlin.jvm.internal.l.a(this.f11422a, v2Var.f11422a) && this.f11423b == v2Var.f11423b && this.f11424c == v2Var.f11424c && this.f11425d == v2Var.f11425d;
    }

    public final int hashCode() {
        return (((((this.f11422a.hashCode() * 31) + this.f11423b) * 31) + this.f11424c) * 31) + this.f11425d;
    }

    public final String toString() {
        return "FollowUserData(userID=" + this.f11422a + ", success=" + this.f11423b + ", statusCode=" + this.f11424c + ", following=" + this.f11425d + ")";
    }
}
