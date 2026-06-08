package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7010a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7011b = false;

    /* renamed from: l, reason: collision with root package name */
    public final int f7012l = 2;

    public a(Object obj) {
        this.f7010a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7011b == aVar.f7011b && this.f7012l == aVar.f7012l && l.a(this.f7010a, aVar.f7010a) && AtomicReference.class.equals(AtomicReference.class);
    }

    @Override // kotlin.jvm.internal.i
    public final int getArity() {
        return 2;
    }

    public final int hashCode() {
        return ((((((((((AtomicReference.class.hashCode() + ((this.f7010a != null ? r0.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + (this.f7011b ? 1231 : 1237)) * 31) + 2) * 31) + this.f7012l;
    }

    public final String toString() {
        y.f7025a.getClass();
        return z.a(this);
    }
}
