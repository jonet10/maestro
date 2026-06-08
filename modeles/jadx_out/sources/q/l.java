package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class l extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f8598a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8599b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8600c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8601d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8602e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8603k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8604l;

    public l(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f8598a = num;
        this.f8599b = str;
        this.f8600c = str2;
        this.f8601d = str3;
        this.f8602e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.f8603k = str10;
        this.f8604l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f8598a.equals(((l) aVar).f8598a)) {
            return false;
        }
        if (!this.f8599b.equals(((l) aVar).f8599b)) {
            return false;
        }
        if (!this.f8600c.equals(((l) aVar).f8600c)) {
            return false;
        }
        if (!this.f8601d.equals(((l) aVar).f8601d)) {
            return false;
        }
        if (!this.f8602e.equals(((l) aVar).f8602e)) {
            return false;
        }
        if (!this.f.equals(((l) aVar).f)) {
            return false;
        }
        if (!this.g.equals(((l) aVar).g)) {
            return false;
        }
        if (!this.h.equals(((l) aVar).h)) {
            return false;
        }
        if (!this.i.equals(((l) aVar).i)) {
            return false;
        }
        if (!this.j.equals(((l) aVar).j)) {
            return false;
        }
        if (this.f8603k.equals(((l) aVar).f8603k)) {
            return this.f8604l.equals(((l) aVar).f8604l);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((this.f8598a.hashCode() ^ 1000003) * 1000003) ^ this.f8599b.hashCode()) * 1000003) ^ this.f8600c.hashCode()) * 1000003) ^ this.f8601d.hashCode()) * 1000003) ^ this.f8602e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.f8603k.hashCode()) * 1000003) ^ this.f8604l.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f8598a);
        sb.append(", model=");
        sb.append(this.f8599b);
        sb.append(", hardware=");
        sb.append(this.f8600c);
        sb.append(", device=");
        sb.append(this.f8601d);
        sb.append(", product=");
        sb.append(this.f8602e);
        sb.append(", osBuild=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(this.g);
        sb.append(", fingerprint=");
        sb.append(this.h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.j);
        sb.append(", mccMnc=");
        sb.append(this.f8603k);
        sb.append(", applicationBuild=");
        return a4.x.n(sb, this.f8604l, "}");
    }
}
