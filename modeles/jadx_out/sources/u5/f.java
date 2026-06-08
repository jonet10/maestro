package u5;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Long f10714a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f10715b;

    public /* synthetic */ f() {
        this(null, new LinkedHashMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.l.a(this.f10714a, fVar.f10714a) && kotlin.jvm.internal.l.a(this.f10715b, fVar.f10715b);
    }

    public final int hashCode() {
        Long l10 = this.f10714a;
        return this.f10715b.hashCode() + ((l10 == null ? 0 : l10.hashCode()) * 31);
    }

    public final String toString() {
        return "IabApprovedCmpList(lastUpdated=" + this.f10714a + ", cmpInfoMap=" + this.f10715b + ')';
    }

    public f(Long l10, LinkedHashMap linkedHashMap) {
        this.f10714a = l10;
        this.f10715b = linkedHashMap;
    }
}
