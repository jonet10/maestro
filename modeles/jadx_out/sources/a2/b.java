package a2;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends p {

    /* renamed from: b, reason: collision with root package name */
    public final String f7b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10e;
    public final long f;

    public b(long j, String str, String str2, String str3, String str4) {
        if (str == null) {
            com.google.gson.internal.a.i("Null rolloutId");
            throw null;
        }
        this.f7b = str;
        if (str2 == null) {
            com.google.gson.internal.a.i("Null parameterKey");
            throw null;
        }
        this.f8c = str2;
        this.f9d = str3;
        if (str4 == null) {
            com.google.gson.internal.a.i("Null variantId");
            throw null;
        }
        this.f10e = str4;
        this.f = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        b bVar = (b) ((p) obj);
        return this.f7b.equals(bVar.f7b) && this.f8c.equals(bVar.f8c) && this.f9d.equals(bVar.f9d) && this.f10e.equals(bVar.f10e) && this.f == bVar.f;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f7b.hashCode() ^ 1000003) * 1000003) ^ this.f8c.hashCode()) * 1000003) ^ this.f9d.hashCode()) * 1000003) ^ this.f10e.hashCode()) * 1000003;
        long j = this.f;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutId=");
        sb.append(this.f7b);
        sb.append(", parameterKey=");
        sb.append(this.f8c);
        sb.append(", parameterValue=");
        sb.append(this.f9d);
        sb.append(", variantId=");
        sb.append(this.f10e);
        sb.append(", templateVersion=");
        return x.l(sb, this.f, "}");
    }
}
