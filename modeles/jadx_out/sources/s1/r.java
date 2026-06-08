package s1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f9150a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f9151b;

    public r(Class cls, Class cls2) {
        this.f9150a = cls;
        this.f9151b = cls2;
    }

    public static r a(Class cls) {
        return new r(q.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f9151b.equals(rVar.f9151b)) {
            return this.f9150a.equals(rVar.f9150a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9150a.hashCode() + (this.f9151b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f9151b;
        Class cls2 = this.f9150a;
        if (cls2 == q.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
