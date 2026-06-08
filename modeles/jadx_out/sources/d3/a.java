package d3;

import kotlin.jvm.internal.l;
import x7.g;
import y1.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final g f3540a;

    /* renamed from: b, reason: collision with root package name */
    public i f3541b = null;

    public a(g gVar) {
        this.f3540a = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3540a.equals(aVar.f3540a) && l.a(this.f3541b, aVar.f3541b);
    }

    public final int hashCode() {
        int hashCode = this.f3540a.hashCode() * 31;
        i iVar = this.f3541b;
        return hashCode + (iVar == null ? 0 : iVar.hashCode());
    }

    public final String toString() {
        return "Dependency(mutex=" + this.f3540a + ", subscriber=" + this.f3541b + ')';
    }
}
