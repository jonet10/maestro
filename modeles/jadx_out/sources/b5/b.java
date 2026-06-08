package b5;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1007a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1008b;

    public b(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f1007a = arrayList;
        this.f1008b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f1007a, bVar.f1007a) && this.f1008b == bVar.f1008b;
    }

    public final int hashCode() {
        return (this.f1007a.hashCode() * 31) + (this.f1008b ? 1231 : 1237);
    }

    public final String toString() {
        return "ChildrenResult(categories=" + this.f1007a + ", success=" + this.f1008b + ")";
    }
}
