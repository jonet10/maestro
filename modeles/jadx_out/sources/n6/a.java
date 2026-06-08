package n6;

import a4.x;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8105a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8106b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8107c;

    public a(int i, String str, String str2) {
        str = (i & 1) != 0 ? "" : str;
        str2 = (i & 2) != 0 ? "" : str2;
        this.f8105a = str;
        this.f8106b = str2;
        this.f8107c = "";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8105a.equals(aVar.f8105a) && this.f8106b.equals(aVar.f8106b) && this.f8107c.equals(aVar.f8107c);
    }

    public final int hashCode() {
        return this.f8107c.hashCode() + l.o(this.f8105a.hashCode() * 31, 31, this.f8106b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeoIP(country=");
        sb.append(this.f8105a);
        sb.append(", region=");
        sb.append(this.f8106b);
        sb.append(", city=");
        return x.m(sb, this.f8107c, ')');
    }
}
