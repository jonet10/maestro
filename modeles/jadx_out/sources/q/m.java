package q;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class m extends w {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8605a;

    public m(ArrayList arrayList) {
        this.f8605a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        return this.f8605a.equals(((m) ((w) obj)).f8605a);
    }

    public final int hashCode() {
        return this.f8605a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f8605a + "}";
    }
}
