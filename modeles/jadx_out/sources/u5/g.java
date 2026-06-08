package u5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f10716a;

    /* renamed from: b, reason: collision with root package name */
    public final i f10717b;

    public g(int i, i iVar) {
        iVar.getClass();
        this.f10716a = i;
        this.f10717b = iVar;
    }

    public final String a() {
        int i = this.f10716a;
        if (i <= 0) {
            throw new w5.e(kotlin.jvm.internal.l.g(": TCModelError, cannot hash invalid PurposeRestriction", "f.k"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        sb.append(this.f10717b.f10726a);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10716a == gVar.f10716a && this.f10717b == gVar.f10717b;
    }

    public final int hashCode() {
        return this.f10717b.hashCode() + (this.f10716a * 31);
    }

    public final String toString() {
        return "PurposeRestriction(purposeId=" + this.f10716a + ", restrictionType=" + this.f10717b + ')';
    }
}
