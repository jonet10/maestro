package h9;

import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f5591a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5592b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5593c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5594d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5595e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final ArrayList j;

    public p(String str, ArrayList arrayList, String str2, String str3, String str4, int i) {
        str = (i & 4) != 0 ? "" : str;
        RandomAccess randomAccess = (i & 8) != 0 ? q6.t.f8724a : arrayList;
        str2 = (i & 32) != 0 ? "" : str2;
        str3 = (i & 64) != 0 ? "" : str3;
        str4 = (i & 128) != 0 ? "" : str4;
        ArrayList arrayList2 = new ArrayList();
        this.f5591a = "";
        this.f5592b = "";
        this.f5593c = str;
        this.f5594d = randomAccess;
        this.f5595e = "";
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = "";
        this.j = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.l.a(this.f5591a, pVar.f5591a) && kotlin.jvm.internal.l.a(this.f5592b, pVar.f5592b) && kotlin.jvm.internal.l.a(this.f5593c, pVar.f5593c) && kotlin.jvm.internal.l.a(this.f5594d, pVar.f5594d) && kotlin.jvm.internal.l.a(this.f5595e, pVar.f5595e) && kotlin.jvm.internal.l.a(this.f, pVar.f) && kotlin.jvm.internal.l.a(this.g, pVar.g) && kotlin.jvm.internal.l.a(this.h, pVar.h) && kotlin.jvm.internal.l.a(this.i, pVar.i) && kotlin.jvm.internal.l.a(this.j, pVar.j);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.List] */
    public final int hashCode() {
        return this.j.hashCode() + i5.b(i5.b(i5.b(i5.b(i5.b(j8.e.a(i5.b(i5.b(this.f5591a.hashCode() * 31, this.f5592b), this.f5593c), this.f5594d), this.f5595e), this.f), this.g), this.h), this.i);
    }

    public final String toString() {
        return "PremiumUiLabels(linksTitle=" + this.f5591a + ", nonIabVendorsLabel=" + this.f5592b + ", uspDnsTitle=" + this.f5593c + ", uspDnsText=" + this.f5594d + ", uspDoNotSellToggleText=" + this.f5595e + ", uspPrivacyPolicyLinkText=" + this.f + ", uspDeleteDataLinkText=" + this.g + ", uspAccessDataLinkText=" + this.h + ", uspAcceptButton=" + this.i + ", initScreenCustomLinks=" + this.j + ')';
    }
}
