package h9;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f5589a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5590b;

    public o(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.f5589a = str;
        this.f5590b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.l.a(this.f5589a, oVar.f5589a) && kotlin.jvm.internal.l.a(this.f5590b, oVar.f5590b);
    }

    public final int hashCode() {
        return this.f5590b.hashCode() + (this.f5589a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnersDisclosureLabels(disclosureLabel=");
        sb.append(this.f5589a);
        sb.append(", backLabel=");
        return x.m(sb, this.f5590b, ')');
    }
}
