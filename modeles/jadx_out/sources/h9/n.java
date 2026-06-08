package h9;

import a4.x;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f5584a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5585b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5586c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5587d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5588e;
    public final String f;
    public final String g;

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        this.f5584a = str;
        this.f5585b = str2;
        this.f5586c = str3;
        this.f5587d = str4;
        this.f5588e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.l.a(this.f5584a, nVar.f5584a) && kotlin.jvm.internal.l.a(this.f5585b, nVar.f5585b) && kotlin.jvm.internal.l.a(this.f5586c, nVar.f5586c) && kotlin.jvm.internal.l.a(this.f5587d, nVar.f5587d) && kotlin.jvm.internal.l.a(this.f5588e, nVar.f5588e) && kotlin.jvm.internal.l.a(this.f, nVar.f) && kotlin.jvm.internal.l.a(this.g, nVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + i5.b(i5.b(i5.b(i5.b(i5.b(this.f5584a.hashCode() * 31, this.f5585b), this.f5586c), this.f5587d), this.f5588e), this.f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnerScreen(title=");
        sb.append(this.f5584a);
        sb.append(", bodyText=");
        sb.append(this.f5585b);
        sb.append(", searchBarHint=");
        sb.append(this.f5586c);
        sb.append(", partnersLabel=");
        sb.append(this.f5587d);
        sb.append(", showAllVendorsMenu=");
        sb.append(this.f5588e);
        sb.append(", showIABVendorsMenu=");
        sb.append(this.f);
        sb.append(", backLabel=");
        return x.m(sb, this.g, ')');
    }
}
