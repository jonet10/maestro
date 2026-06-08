package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1709a;

    public i1(ArrayList arrayList) {
        this.f1709a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f1709a.equals(((i1) obj).f1709a);
    }

    public final int hashCode() {
        return this.f1709a.hashCode();
    }

    public final String toString() {
        return "FreeUpSpaceData(tmpUserApps=" + this.f1709a + ")";
    }
}
