package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1388a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1389b;

    public aa(ArrayList arrayList, boolean z9) {
        this.f1388a = arrayList;
        this.f1389b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        return this.f1388a.equals(aaVar.f1388a) && this.f1389b == aaVar.f1389b;
    }

    public final int hashCode() {
        return (this.f1388a.hashCode() * 31) + (this.f1389b ? 1231 : 1237);
    }

    public final String toString() {
        return "SearchCategoriesData(searchResults=" + this.f1388a + ", firstRequest=" + this.f1389b + ")";
    }
}
