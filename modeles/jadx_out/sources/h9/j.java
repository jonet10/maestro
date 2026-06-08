package h9;

import a4.x;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f5542a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5543b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5544c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5545d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5546e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    /* renamed from: k, reason: collision with root package name */
    public final String f5547k;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str11.getClass();
        this.f5542a = str;
        this.f5543b = str2;
        this.f5544c = str3;
        this.f5545d = str4;
        this.f5546e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.f5547k = str11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.l.a(this.f5542a, jVar.f5542a) && kotlin.jvm.internal.l.a(this.f5543b, jVar.f5543b) && kotlin.jvm.internal.l.a(this.f5544c, jVar.f5544c) && kotlin.jvm.internal.l.a(this.f5545d, jVar.f5545d) && kotlin.jvm.internal.l.a(this.f5546e, jVar.f5546e) && kotlin.jvm.internal.l.a(this.f, jVar.f) && kotlin.jvm.internal.l.a(this.g, jVar.g) && kotlin.jvm.internal.l.a(this.h, jVar.h) && kotlin.jvm.internal.l.a(this.i, jVar.i) && kotlin.jvm.internal.l.a(this.j, jVar.j) && kotlin.jvm.internal.l.a(this.f5547k, jVar.f5547k);
    }

    public final int hashCode() {
        return this.f5547k.hashCode() + i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(this.f5542a.hashCode() * 31, this.f5543b), this.f5544c), this.f5545d), this.f5546e), this.f), this.g), this.h), this.i), this.j);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LegInterestScreen(title=");
        sb.append(this.f5542a);
        sb.append(", body=");
        sb.append(this.f5543b);
        sb.append(", objected=");
        sb.append(this.f5544c);
        sb.append(", accept=");
        sb.append(this.f5545d);
        sb.append(", objectAllButton=");
        sb.append(this.f5546e);
        sb.append(", searchBarHint=");
        sb.append(this.f);
        sb.append(", purposesLabel=");
        sb.append(this.g);
        sb.append(", partnersLabel=");
        sb.append(this.h);
        sb.append(", showAllVendorsMenu=");
        sb.append(this.i);
        sb.append(", showIABVendorsMenu=");
        sb.append(this.j);
        sb.append(", backLabel=");
        return x.m(sb, this.f5547k, ')');
    }
}
