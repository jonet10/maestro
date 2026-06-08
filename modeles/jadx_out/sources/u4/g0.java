package u4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10494a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10495b;

    public g0(ArrayList arrayList, ArrayList arrayList2) {
        this.f10494a = arrayList;
        this.f10495b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f10494a.equals(g0Var.f10494a) && this.f10495b.equals(g0Var.f10495b);
    }

    public final int hashCode() {
        return this.f10495b.hashCode() + (this.f10494a.hashCode() * 31);
    }

    public final String toString() {
        return "AppMediaData(appScreenshot=" + this.f10494a + ", appVideos=" + this.f10495b + ")";
    }
}
