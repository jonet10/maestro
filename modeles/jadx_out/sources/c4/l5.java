package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l5 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1824a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1825b;

    public l5(ArrayList arrayList, ArrayList arrayList2) {
        arrayList2.getClass();
        this.f1824a = arrayList;
        this.f1825b = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l5)) {
            return false;
        }
        l5 l5Var = (l5) obj;
        return this.f1824a.equals(l5Var.f1824a) && kotlin.jvm.internal.l.a(this.f1825b, l5Var.f1825b);
    }

    public final int hashCode() {
        return this.f1825b.hashCode() + (this.f1824a.hashCode() * 31);
    }

    public final String toString() {
        return "MyDownloadsData(downloads=" + this.f1824a + ", downloadsQueue=" + this.f1825b + ")";
    }
}
