package h9;

import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5483a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5484b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5485c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5486d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5487e;
    public final List f;

    public /* synthetic */ a(String str, String str2, String str3, String str4, List list, int i) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, "", (i & 32) != 0 ? new ArrayList() : list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.l.a(this.f5483a, aVar.f5483a) && kotlin.jvm.internal.l.a(this.f5484b, aVar.f5484b) && kotlin.jvm.internal.l.a(this.f5485c, aVar.f5485c) && kotlin.jvm.internal.l.a(this.f5486d, aVar.f5486d) && kotlin.jvm.internal.l.a(this.f5487e, aVar.f5487e) && kotlin.jvm.internal.l.a(this.f, aVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + i5.b(i5.b(i5.b(i5.b(this.f5483a.hashCode() * 31, this.f5484b), this.f5485c), this.f5486d), this.f5487e);
    }

    public final String toString() {
        return "AdvancedUILabels(initScreenSettingsButton=" + this.f5483a + ", initScreenRejectButton=" + this.f5484b + ", privacyBody=" + this.f5485c + ", privacyHeader=" + this.f5486d + ", secondScreenPrivacyBody=" + this.f5487e + ", customFooterLink=" + this.f + ')';
    }

    public a(String str, String str2, String str3, String str4, String str5, List list) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        list.getClass();
        this.f5483a = str;
        this.f5484b = str2;
        this.f5485c = str3;
        this.f5486d = str4;
        this.f5487e = str5;
        this.f = list;
    }
}
