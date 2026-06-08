package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class tb {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2137a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2138b;

    public tb(ArrayList arrayList, ArrayList arrayList2) {
        this.f2137a = arrayList;
        this.f2138b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tb)) {
            return false;
        }
        tb tbVar = (tb) obj;
        return this.f2137a.equals(tbVar.f2137a) && this.f2138b.equals(tbVar.f2138b);
    }

    public final int hashCode() {
        return this.f2138b.hashCode() + (this.f2137a.hashCode() * 31);
    }

    public final String toString() {
        return "AvatarsData(avatars=" + this.f2137a + ", turboAvatars=" + this.f2138b + ")";
    }
}
