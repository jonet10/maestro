package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g6 {

    /* renamed from: a, reason: collision with root package name */
    public final x4.e f1628a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.g f1629b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1630c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1631d;

    public g6(x4.e eVar, x4.g gVar, ArrayList arrayList, boolean z9) {
        this.f1628a = eVar;
        this.f1629b = gVar;
        this.f1630c = arrayList;
        this.f1631d = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g6)) {
            return false;
        }
        g6 g6Var = (g6) obj;
        return kotlin.jvm.internal.l.a(this.f1628a, g6Var.f1628a) && this.f1629b.equals(g6Var.f1629b) && kotlin.jvm.internal.l.a(this.f1630c, g6Var.f1630c) && this.f1631d == g6Var.f1631d;
    }

    public final int hashCode() {
        x4.e eVar = this.f1628a;
        int hashCode = (this.f1629b.hashCode() + ((eVar == null ? 0 : eVar.hashCode()) * 31)) * 31;
        ArrayList arrayList = this.f1630c;
        return ((hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31) + (this.f1631d ? 1231 : 1237);
    }

    public final String toString() {
        return "OldVersionsData(app=" + this.f1628a + ", appInfo=" + this.f1629b + ", oldVersions=" + this.f1630c + ", isOldVersionsAvailable=" + this.f1631d + ")";
    }
}
