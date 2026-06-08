package b5;

import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final p2 f1011a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1012b;

    public d(p2 p2Var, boolean z9) {
        this.f1011a = p2Var;
        this.f1012b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.l.a(this.f1011a, dVar.f1011a) && this.f1012b == dVar.f1012b;
    }

    public final int hashCode() {
        p2 p2Var = this.f1011a;
        return ((p2Var == null ? 0 : p2Var.hashCode()) * 31) + (this.f1012b ? 1231 : 1237);
    }

    public final String toString() {
        return "TopResult(topByCategory=" + this.f1011a + ", success=" + this.f1012b + ")";
    }
}
