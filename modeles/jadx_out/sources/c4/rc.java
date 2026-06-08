package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class rc {

    /* renamed from: a, reason: collision with root package name */
    public final x4.z2 f2058a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2059b;

    public rc(x4.z2 z2Var, ArrayList arrayList) {
        this.f2058a = z2Var;
        this.f2059b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rc)) {
            return false;
        }
        rc rcVar = (rc) obj;
        return this.f2058a.equals(rcVar.f2058a) && this.f2059b.equals(rcVar.f2059b);
    }

    public final int hashCode() {
        return this.f2059b.hashCode() + (this.f2058a.hashCode() * 31);
    }

    public final String toString() {
        return "UserDevicesData(thisDevice=" + this.f2058a + ", userDevices=" + this.f2059b + ")";
    }
}
