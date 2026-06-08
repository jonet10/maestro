package p6;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8451a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8452b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f8453l;

    public n(Object obj, Object obj2, Object obj3) {
        this.f8451a = obj;
        this.f8452b = obj2;
        this.f8453l = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.l.a(this.f8451a, nVar.f8451a) && kotlin.jvm.internal.l.a(this.f8452b, nVar.f8452b) && kotlin.jvm.internal.l.a(this.f8453l, nVar.f8453l);
    }

    public final int hashCode() {
        Object obj = this.f8451a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f8452b;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f8453l;
        return hashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f8451a + ", " + this.f8452b + ", " + this.f8453l + ')';
    }
}
