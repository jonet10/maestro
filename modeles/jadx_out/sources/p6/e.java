package p6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final e f8436b = new e();

    /* renamed from: a, reason: collision with root package name */
    public final int f8437a = 131594;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        eVar.getClass();
        return this.f8437a - eVar.f8437a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f8437a == eVar.f8437a;
    }

    public final int hashCode() {
        return this.f8437a;
    }

    public final String toString() {
        return "2.2.10";
    }
}
