package q6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f8727a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8728b;

    public w(int i, Object obj) {
        this.f8727a = i;
        this.f8728b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f8727a == wVar.f8727a && kotlin.jvm.internal.l.a(this.f8728b, wVar.f8728b);
    }

    public final int hashCode() {
        int i = this.f8727a * 31;
        Object obj = this.f8728b;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f8727a + ", value=" + this.f8728b + ')';
    }
}
