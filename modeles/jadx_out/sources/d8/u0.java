package d8;

import com.google.android.gms.internal.measurement.z3;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 implements b8.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f3713a;

    /* renamed from: b, reason: collision with root package name */
    public final b8.d f3714b;

    public u0(String str, b8.d dVar) {
        dVar.getClass();
        this.f3713a = str;
        this.f3714b = dVar;
    }

    @Override // b8.e
    public final String a() {
        return this.f3713a;
    }

    @Override // b8.e
    public final boolean c() {
        return false;
    }

    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // b8.e
    public final int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f3713a.equals(u0Var.f3713a) && kotlin.jvm.internal.l.a(this.f3714b, u0Var.f3714b);
    }

    @Override // b8.e
    public final String f(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // b8.e
    public final List g(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // b8.e
    public final List getAnnotations() {
        return q6.t.f8724a;
    }

    @Override // b8.e
    public final z3 getKind() {
        return this.f3714b;
    }

    @Override // b8.e
    public final b8.e h(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final int hashCode() {
        return (this.f3714b.hashCode() * 31) + this.f3713a.hashCode();
    }

    @Override // b8.e
    public final boolean i(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // b8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return a4.x.m(new StringBuilder("PrimitiveDescriptor("), this.f3713a, ')');
    }
}
