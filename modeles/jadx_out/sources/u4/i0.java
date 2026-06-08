package u4;

import java.util.ArrayList;
import x4.k2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10504a;

    /* renamed from: b, reason: collision with root package name */
    public final k2 f10505b;

    public i0(ArrayList arrayList, k2 k2Var) {
        this.f10504a = arrayList;
        this.f10505b = k2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f10504a.equals(i0Var.f10504a) && kotlin.jvm.internal.l.a(this.f10505b, i0Var.f10505b);
    }

    public final int hashCode() {
        int hashCode = this.f10504a.hashCode() * 31;
        k2 k2Var = this.f10505b;
        return hashCode + (k2Var == null ? 0 : k2Var.hashCode());
    }

    public final String toString() {
        return "AppReviewsData(appReviews=" + this.f10504a + ", appMyReview=" + this.f10505b + ")";
    }
}
