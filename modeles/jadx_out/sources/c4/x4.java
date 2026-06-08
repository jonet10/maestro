package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x4 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2296a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2297b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2298c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2299d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f2300e;
    public final ArrayList f;

    public x4(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
        this.f2296a = arrayList;
        this.f2297b = arrayList2;
        this.f2298c = arrayList3;
        this.f2299d = arrayList4;
        this.f2300e = arrayList5;
        this.f = arrayList6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        return this.f2296a.equals(x4Var.f2296a) && this.f2297b.equals(x4Var.f2297b) && this.f2298c.equals(x4Var.f2298c) && this.f2299d.equals(x4Var.f2299d) && this.f2300e.equals(x4Var.f2300e) && this.f.equals(x4Var.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.f2300e.hashCode() + ((this.f2299d.hashCode() + ((this.f2298c.hashCode() + ((this.f2297b.hashCode() + (this.f2296a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MyAppsData(tmpAppUpdateData=" + this.f2296a + ", tmpUserApps=" + this.f2297b + ", tmpSystemApps=" + this.f2298c + ", tmpDisabledApps=" + this.f2299d + ", tmpSystemServices=" + this.f2300e + ", tmpPositiveApps=" + this.f + ")";
    }
}
