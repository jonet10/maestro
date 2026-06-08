package l8;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7247a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7248b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7249c;

    public /* synthetic */ o() {
        this(new ArrayList(), new ArrayList(), new ArrayList());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.l.a(this.f7247a, oVar.f7247a) && kotlin.jvm.internal.l.a(this.f7248b, oVar.f7248b) && kotlin.jvm.internal.l.a(this.f7249c, oVar.f7249c);
    }

    public final int hashCode() {
        return this.f7249c.hashCode() + j8.e.a(this.f7247a.hashCode() * 31, this.f7248b);
    }

    public final String toString() {
        return "PremiumProperties(vendorBlacklist=" + this.f7247a + ", vendorWhitelist=" + this.f7248b + ", googleWhitelist=" + this.f7249c + ')';
    }

    public o(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f7247a = arrayList;
        this.f7248b = arrayList2;
        this.f7249c = arrayList3;
    }
}
