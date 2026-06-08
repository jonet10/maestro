package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1545a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1546b;

    public e2(ArrayList arrayList, int i) {
        this.f1545a = arrayList;
        this.f1546b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e2)) {
            return false;
        }
        e2 e2Var = (e2) obj;
        return this.f1545a.equals(e2Var.f1545a) && this.f1546b == e2Var.f1546b;
    }

    public final int hashCode() {
        return (this.f1545a.hashCode() * 31) + this.f1546b;
    }

    public final String toString() {
        return "UserPreregisterListData(list=" + this.f1545a + ", appsCount=" + this.f1546b + ")";
    }
}
