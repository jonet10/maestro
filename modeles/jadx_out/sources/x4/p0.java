package x4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends u0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11328a;

    public p0(ArrayList arrayList) {
        this.f11328a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p0) && kotlin.jvm.internal.l.a(this.f11328a, ((p0) obj).f11328a);
    }

    public final int hashCode() {
        ArrayList arrayList = this.f11328a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        return "NoWifi(apps=" + this.f11328a + ")";
    }
}
