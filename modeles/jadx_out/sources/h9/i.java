package h9;

import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f5537a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5538b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5539c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5540d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5541e;
    public final String f;
    public final String g;
    public final String h;
    public final e i;
    public final a j;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, e eVar, a aVar) {
        str.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str8.getClass();
        this.f5537a = str;
        this.f5538b = str2;
        this.f5539c = str3;
        this.f5540d = str4;
        this.f5541e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = eVar;
        this.j = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.l.a(this.f5537a, iVar.f5537a) && this.f5538b.equals(iVar.f5538b) && kotlin.jvm.internal.l.a(this.f5539c, iVar.f5539c) && kotlin.jvm.internal.l.a(this.f5540d, iVar.f5540d) && kotlin.jvm.internal.l.a(this.f5541e, iVar.f5541e) && kotlin.jvm.internal.l.a(this.f, iVar.f) && this.g.equals(iVar.g) && kotlin.jvm.internal.l.a(this.h, iVar.h) && this.i.equals(iVar.i) && this.j.equals(iVar.j);
    }

    public final int hashCode() {
        return this.j.hashCode() + ((this.i.hashCode() + i5.b(androidx.lifecycle.l.o(i5.b(i5.b(i5.b(i5.b(androidx.lifecycle.l.o(this.f5537a.hashCode() * 31, 31, this.f5538b), this.f5539c), this.f5540d), this.f5541e), this.f), 31, this.g), this.h)) * 31);
    }

    public final String toString() {
        return "InitScreen(title=" + this.f5537a + ", body=" + this.f5538b + ", settings=" + this.f5539c + ", accept=" + this.f5540d + ", reject=" + this.f5541e + ", consentLink=" + this.f + ", privacyPolicyLink=" + this.g + ", privacyPolicyLinkText=" + this.h + ", consentOrPayUILabels=" + this.i + ", advancedUILabels=" + this.j + ')';
    }
}
