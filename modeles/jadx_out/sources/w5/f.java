package w5;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10930a;

    public f(ArrayList arrayList) {
        this.f10930a = arrayList;
    }

    public final boolean equals(Object obj) {
        Object obj2 = 2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        Object obj3 = Boolean.TRUE;
        return obj3.equals(obj3) && obj2.equals(obj2) && this.f10930a.equals(fVar.f10930a);
    }

    public final int hashCode() {
        Integer num = 2;
        return this.f10930a.hashCode() + ((num.hashCode() + (Boolean.TRUE.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "EncodingOptions(isForVendors=" + Boolean.TRUE + ", version=" + ((Object) 2) + ", segments=" + this.f10930a + ')';
    }
}
