package l8;

import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f7194a;

    /* renamed from: b, reason: collision with root package name */
    public final GBCConsentValue f7195b;

    public g(int i, GBCConsentValue gBCConsentValue) {
        gBCConsentValue.getClass();
        this.f7194a = i;
        this.f7195b = gBCConsentValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7194a == gVar.f7194a && this.f7195b == gVar.f7195b;
    }

    public final int hashCode() {
        return this.f7195b.hashCode() + (this.f7194a * 31);
    }

    public final String toString() {
        return "GBCApplicablePurpose(id=" + this.f7194a + ", defaultValue=" + this.f7195b + ')';
    }
}
