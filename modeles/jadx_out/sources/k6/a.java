package k6;

import a4.x;
import com.google.android.gms.internal.measurement.i5;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6976a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6977b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6978c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6979d;

    public a(String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.f6976a = str;
        this.f6977b = str2;
        this.f6978c = str3;
        this.f6979d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l.a(this.f6976a, aVar.f6976a) && l.a(this.f6977b, aVar.f6977b) && l.a(this.f6978c, aVar.f6978c) && l.a(this.f6979d, aVar.f6979d);
    }

    public final int hashCode() {
        return this.f6979d.hashCode() + i5.b(i5.b(this.f6976a.hashCode() * 31, this.f6977b), this.f6978c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Banner(title=");
        sb.append(this.f6976a);
        sb.append(", sectionTitle=");
        sb.append(this.f6977b);
        sb.append(", description=");
        sb.append(this.f6978c);
        sb.append(", confirm=");
        return x.m(sb, this.f6979d, ')');
    }

    public /* synthetic */ a(int i, String str, String str2) {
        this((i & 1) != 0 ? "" : str, "", (i & 4) != 0 ? "" : str2, "");
    }
}
