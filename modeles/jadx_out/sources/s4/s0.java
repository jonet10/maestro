package s4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9289a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9290b;

    public s0(ArrayList arrayList, int i) {
        this.f9289a = arrayList;
        this.f9290b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f9289a.equals(s0Var.f9289a) && this.f9290b == s0Var.f9290b;
    }

    public final int hashCode() {
        return (this.f9289a.hashCode() * 31) + this.f9290b;
    }

    public final String toString() {
        return "WishlistData(wishlist=" + this.f9289a + ", countApps=" + this.f9290b + ")";
    }
}
