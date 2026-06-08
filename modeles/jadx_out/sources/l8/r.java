package l8;

import a4.x;
import java.util.ArrayList;
import java.util.RandomAccess;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7257a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7258b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7259c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7260d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7261e;
    public final Object f;
    public final String g;
    public final String h;
    public final String i;

    public r(boolean z9, String str, String str2, String str3, String str4, ArrayList arrayList, String str5, String str6, String str7, int i) {
        z9 = (i & 2) != 0 ? false : z9;
        str = (i & 4) != 0 ? "" : str;
        str2 = (i & 8) != 0 ? "" : str2;
        str3 = (i & 16) != 0 ? "" : str3;
        str4 = (i & 32) != 0 ? "" : str4;
        RandomAccess randomAccess = (i & 64) != 0 ? t.f8724a : arrayList;
        str5 = (i & 128) != 0 ? "" : str5;
        str6 = (i & 256) != 0 ? "" : str6;
        str7 = (i & 512) != 0 ? "" : str7;
        this.f7257a = z9;
        this.f7258b = str;
        this.f7259c = str2;
        this.f7260d = str3;
        this.f7261e = str4;
        this.f = randomAccess;
        this.g = str5;
        this.h = str6;
        this.i = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f7257a == rVar.f7257a && this.f7258b.equals(rVar.f7258b) && this.f7259c.equals(rVar.f7259c) && this.f7260d.equals(rVar.f7260d) && this.f7261e.equals(rVar.f7261e) && this.f.equals(rVar.f) && this.g.equals(rVar.g) && this.h.equals(rVar.h) && this.i.equals(rVar.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z9 = this.f7257a;
        ?? r02 = z9;
        if (z9) {
            r02 = 1;
        }
        return this.i.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o((this.f.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(r02 * 31, 31, this.f7258b), 31, this.f7259c), 31, this.f7260d), 31, this.f7261e)) * 31, 31, this.g), 31, this.h);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("USPPortalLabels(isGdprEnabledInUS=false, suppressCcpaLinks=");
        sb.append(this.f7257a);
        sb.append(", uspPrivacyPolicyLinkText=");
        sb.append(this.f7258b);
        sb.append(", uspDeleteDataLinkText=");
        sb.append(this.f7259c);
        sb.append(", uspAccessDataLinkText=");
        sb.append(this.f7260d);
        sb.append(", uspDnsTitle=");
        sb.append(this.f7261e);
        sb.append(", uspDnsText=");
        sb.append(this.f);
        sb.append(", uspDeleteDataLink=");
        sb.append(this.g);
        sb.append(", uspAccessDataLink=");
        sb.append(this.h);
        sb.append(", uspPrivacyPolicyLink=");
        return x.m(sb, this.i, ')');
    }
}
