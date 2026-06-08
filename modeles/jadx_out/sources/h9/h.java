package h9;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f5532a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5533b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5534c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5535d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f5536e;

    public h(String str, String str2, int i, String str3, ArrayList arrayList) {
        this.f5532a = str;
        this.f5533b = str2;
        this.f5534c = i;
        this.f5535d = str3;
        this.f5536e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f5532a.equals(hVar.f5532a) && this.f5533b.equals(hVar.f5533b) && this.f5534c == hVar.f5534c && this.f5535d.equals(hVar.f5535d) && this.f5536e.equals(hVar.f5536e);
    }

    public final int hashCode() {
        return this.f5536e.hashCode() + androidx.lifecycle.l.o((this.f5534c + androidx.lifecycle.l.o(this.f5532a.hashCode() * 31, 31, this.f5533b)) * 31, 31, this.f5535d);
    }

    public final String toString() {
        return "Disclosure(identifier=" + this.f5532a + ", type=" + this.f5533b + ", maxAgeSeconds=" + this.f5534c + ", domain=" + this.f5535d + ", purposes=" + this.f5536e + ')';
    }
}
