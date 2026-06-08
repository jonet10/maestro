package h9;

import a4.x;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f5601a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5602b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5603c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5604d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5605e;
    public final String f;

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        this.f5601a = str;
        this.f5602b = str2;
        this.f5603c = str3;
        this.f5604d = str4;
        this.f5605e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.l.a(this.f5601a, sVar.f5601a) && kotlin.jvm.internal.l.a(this.f5602b, sVar.f5602b) && kotlin.jvm.internal.l.a(this.f5603c, sVar.f5603c) && kotlin.jvm.internal.l.a(this.f5604d, sVar.f5604d) && kotlin.jvm.internal.l.a(this.f5605e, sVar.f5605e) && kotlin.jvm.internal.l.a(this.f, sVar.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + i5.b(i5.b(i5.b(i5.b(this.f5601a.hashCode() * 31, this.f5602b), this.f5603c), this.f5604d), this.f5605e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StacksScreen(title=");
        sb.append(this.f5601a);
        sb.append(", legalDescriptionTextLabel=");
        sb.append(this.f5602b);
        sb.append(", agreeToAllButton=");
        sb.append(this.f5603c);
        sb.append(", searchBarHint=");
        sb.append(this.f5604d);
        sb.append(", closeLabel=");
        sb.append(this.f5605e);
        sb.append(", backLabel=");
        return x.m(sb, this.f, ')');
    }
}
