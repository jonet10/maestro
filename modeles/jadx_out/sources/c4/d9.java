package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d9 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1518a;

    public d9(ArrayList arrayList) {
        this.f1518a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d9) && this.f1518a.equals(((d9) obj).f1518a);
    }

    public final int hashCode() {
        return this.f1518a.hashCode();
    }

    public final String toString() {
        return "ReviewsData(reviews=" + this.f1518a + ")";
    }
}
