package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 extends i2 {

    /* renamed from: a, reason: collision with root package name */
    public final List f796a;

    public g1(List list) {
        this.f796a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        return this.f796a.equals(((g1) ((i2) obj)).f796a);
    }

    public final int hashCode() {
        return this.f796a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f796a + "}";
    }
}
