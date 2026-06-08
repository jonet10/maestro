package s1;

import a4.x;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final r f9134a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9135b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9136c;

    public i(r rVar, int i, int i6) {
        i5.i(rVar, "Null dependency anInterface.");
        this.f9134a = rVar;
        this.f9135b = i;
        this.f9136c = i6;
    }

    public static i a(Class cls) {
        return new i(1, 0, cls);
    }

    public static i b(r rVar) {
        return new i(rVar, 1, 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f9134a.equals(iVar.f9134a) && this.f9135b == iVar.f9135b && this.f9136c == iVar.f9136c;
    }

    public final int hashCode() {
        return ((((this.f9134a.hashCode() ^ 1000003) * 1000003) ^ this.f9135b) * 1000003) ^ this.f9136c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f9134a);
        sb.append(", type=");
        int i = this.f9135b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i6 = this.f9136c;
        if (i6 == 0) {
            str = "direct";
        } else if (i6 == 1) {
            str = "provider";
        } else {
            if (i6 != 2) {
                o.j(androidx.lifecycle.l.u(i6, "Unsupported injection: "));
                return null;
            }
            str = "deferred";
        }
        return x.n(sb, str, "}");
    }

    public i(int i, int i6, Class cls) {
        this(r.a(cls), i, i6);
    }
}
