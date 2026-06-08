package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z9 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2402a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2403b;

    public z9(ArrayList arrayList, boolean z9) {
        this.f2402a = arrayList;
        this.f2403b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z9)) {
            return false;
        }
        z9 z9Var = (z9) obj;
        return this.f2402a.equals(z9Var.f2402a) && this.f2403b == z9Var.f2403b;
    }

    public final int hashCode() {
        return (this.f2402a.hashCode() * 31) + (this.f2403b ? 1231 : 1237);
    }

    public final String toString() {
        return "SearchAppsData(searchResults=" + this.f2402a + ", firstRequest=" + this.f2403b + ")";
    }
}
