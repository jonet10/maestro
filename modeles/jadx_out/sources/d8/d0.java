package d8;

import com.google.android.gms.internal.measurement.z3;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 implements b8.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f3629a;

    /* renamed from: b, reason: collision with root package name */
    public final b8.e f3630b;

    /* renamed from: c, reason: collision with root package name */
    public final b8.e f3631c;

    public d0(String str, b8.e eVar, b8.e eVar2) {
        this.f3629a = str;
        this.f3630b = eVar;
        this.f3631c = eVar2;
    }

    @Override // b8.e
    public final String a() {
        return this.f3629a;
    }

    @Override // b8.e
    public final boolean c() {
        return false;
    }

    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        Integer h02 = l7.t.h0(str);
        if (h02 != null) {
            return h02.intValue();
        }
        com.google.gson.internal.a.p(str.concat(" is not a valid map index"));
        return 0;
    }

    @Override // b8.e
    public final int e() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f3629a.equals(d0Var.f3629a) && this.f3630b.equals(d0Var.f3630b) && this.f3631c.equals(d0Var.f3631c);
    }

    @Override // b8.e
    public final String f(int i) {
        return String.valueOf(i);
    }

    @Override // b8.e
    public final List g(int i) {
        if (i >= 0) {
            return q6.t.f8724a;
        }
        s1.o.o(a4.x.n(a4.x.p(i, "Illegal index ", ", "), this.f3629a, " expects only non-negative indices"));
        return null;
    }

    @Override // b8.e
    public final List getAnnotations() {
        return q6.t.f8724a;
    }

    @Override // b8.e
    public final z3 getKind() {
        return b8.i.j;
    }

    @Override // b8.e
    public final b8.e h(int i) {
        if (i < 0) {
            s1.o.o(a4.x.n(a4.x.p(i, "Illegal index ", ", "), this.f3629a, " expects only non-negative indices"));
            return null;
        }
        int i6 = i % 2;
        if (i6 == 0) {
            return this.f3630b;
        }
        if (i6 == 1) {
            return this.f3631c;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Unreached");
        return null;
    }

    public final int hashCode() {
        return this.f3631c.hashCode() + ((this.f3630b.hashCode() + (this.f3629a.hashCode() * 31)) * 31);
    }

    @Override // b8.e
    public final boolean i(int i) {
        if (i >= 0) {
            return false;
        }
        s1.o.o(a4.x.n(a4.x.p(i, "Illegal index ", ", "), this.f3629a, " expects only non-negative indices"));
        return false;
    }

    @Override // b8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return this.f3629a + '(' + this.f3630b + ", " + this.f3631c + ')';
    }
}
