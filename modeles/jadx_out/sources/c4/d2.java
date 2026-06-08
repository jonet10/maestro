package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1503a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1504b;

    public d2(ArrayList arrayList, int i) {
        this.f1503a = arrayList;
        this.f1504b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f1503a.equals(d2Var.f1503a) && this.f1504b == d2Var.f1504b;
    }

    public final int hashCode() {
        return (this.f1503a.hashCode() * 31) + this.f1504b;
    }

    public final String toString() {
        return "UserListData(list=" + this.f1503a + ", appsCount=" + this.f1504b + ")";
    }
}
