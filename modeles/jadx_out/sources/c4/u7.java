package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u7 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2168a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2169b;

    public u7(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.getClass();
        arrayList2.getClass();
        this.f2168a = arrayList;
        this.f2169b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u7)) {
            return false;
        }
        u7 u7Var = (u7) obj;
        return kotlin.jvm.internal.l.a(this.f2168a, u7Var.f2168a) && kotlin.jvm.internal.l.a(this.f2169b, u7Var.f2169b);
    }

    public final int hashCode() {
        return this.f2169b.hashCode() + (this.f2168a.hashCode() * 31);
    }

    public final String toString() {
        return "PublicProfileData(recommendedApps=" + this.f2168a + ", userReviews=" + this.f2169b + ")";
    }
}
