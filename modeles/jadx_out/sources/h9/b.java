package h9;

import a4.x;
import com.google.android.gms.internal.measurement.i5;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5488a;

    /* renamed from: b, reason: collision with root package name */
    public final List f5489b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5490c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5491d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5492e;
    public final String f;

    public b(String str, String str2, String str3, String str4, String str5, List list) {
        str.getClass();
        list.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        this.f5488a = str;
        this.f5489b = list;
        this.f5490c = str2;
        this.f5491d = str3;
        this.f5492e = str4;
        this.f = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f5488a, bVar.f5488a) && kotlin.jvm.internal.l.a(this.f5489b, bVar.f5489b) && kotlin.jvm.internal.l.a(this.f5490c, bVar.f5490c) && kotlin.jvm.internal.l.a(this.f5491d, bVar.f5491d) && kotlin.jvm.internal.l.a(this.f5492e, bVar.f5492e) && kotlin.jvm.internal.l.a(this.f, bVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + i5.b(i5.b(i5.b(j8.e.a(this.f5488a.hashCode() * 31, this.f5489b), this.f5490c), this.f5491d), this.f5492e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CCPAScreen(title=");
        sb.append(this.f5488a);
        sb.append(", body=");
        sb.append(this.f5489b);
        sb.append(", deleteDataLinkText=");
        sb.append(this.f5490c);
        sb.append(", accessDataLinkText=");
        sb.append(this.f5491d);
        sb.append(", privacyPolicyLinkText=");
        sb.append(this.f5492e);
        sb.append(", backLabel=");
        return x.m(sb, this.f, ')');
    }
}
