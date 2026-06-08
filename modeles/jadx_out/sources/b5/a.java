package b5;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1005a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1006b;

    public a(ArrayList arrayList, int i) {
        this.f1005a = arrayList;
        this.f1006b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1005a.equals(aVar.f1005a) && this.f1006b == aVar.f1006b;
    }

    public final int hashCode() {
        return (this.f1005a.hashCode() * 31) + this.f1006b;
    }

    public final String toString() {
        return "ChildTopsResult(tops=" + this.f1005a + ", errors=" + this.f1006b + ")";
    }
}
