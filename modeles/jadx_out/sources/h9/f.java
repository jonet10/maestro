package h9;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5511a;

    public f() {
        this.f5511a = new ArrayList();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && kotlin.jvm.internal.l.a(this.f5511a, ((f) obj).f5511a);
    }

    public final int hashCode() {
        return this.f5511a.hashCode();
    }

    public final String toString() {
        return "CookieDisclosure(disclosures=" + this.f5511a + ')';
    }

    public f(ArrayList arrayList) {
        this.f5511a = arrayList;
    }
}
