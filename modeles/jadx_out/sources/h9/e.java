package h9;

import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5506a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5507b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5508c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5509d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5510e;
    public final String f;
    public final List g;

    public /* synthetic */ e(String str, String str2, String str3, String str4, String str5, List list, int i) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, "", (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? new ArrayList() : list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.l.a(this.f5506a, eVar.f5506a) && kotlin.jvm.internal.l.a(this.f5507b, eVar.f5507b) && kotlin.jvm.internal.l.a(this.f5508c, eVar.f5508c) && kotlin.jvm.internal.l.a(this.f5509d, eVar.f5509d) && kotlin.jvm.internal.l.a(this.f5510e, eVar.f5510e) && kotlin.jvm.internal.l.a(this.f, eVar.f) && kotlin.jvm.internal.l.a(this.g, eVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + i5.b(i5.b(i5.b(i5.b(i5.b(this.f5506a.hashCode() * 31, this.f5507b), this.f5508c), this.f5509d), this.f5510e), this.f);
    }

    public final String toString() {
        return "ConsentOrPayUILabels(initScreenSettingsButton=" + this.f5506a + ", action1Label=" + this.f5507b + ", action2Label=" + this.f5508c + ", privacyBody=" + this.f5509d + ", secondScreenPrivacyBody=" + this.f5510e + ", privacyHeader=" + this.f + ", customFooterLink=" + this.g + ')';
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6, List list) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        list.getClass();
        this.f5506a = str;
        this.f5507b = str2;
        this.f5508c = str3;
        this.f5509d = str4;
        this.f5510e = str5;
        this.f = str6;
        this.g = list;
    }
}
