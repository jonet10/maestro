package d8;

import com.google.android.gms.internal.measurement.z3;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w0 implements b8.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final b8.e f3719a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3720b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f3721c;

    public w0(b8.e eVar) {
        eVar.getClass();
        this.f3719a = eVar;
        this.f3720b = eVar.a() + '?';
        this.f3721c = o0.b(eVar);
    }

    @Override // b8.e
    public final String a() {
        return this.f3720b;
    }

    @Override // d8.k
    public final Set b() {
        return this.f3721c;
    }

    @Override // b8.e
    public final boolean c() {
        return true;
    }

    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        return this.f3719a.d(str);
    }

    @Override // b8.e
    public final int e() {
        return this.f3719a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w0) {
            return kotlin.jvm.internal.l.a(this.f3719a, ((w0) obj).f3719a);
        }
        return false;
    }

    @Override // b8.e
    public final String f(int i) {
        return this.f3719a.f(i);
    }

    @Override // b8.e
    public final List g(int i) {
        return this.f3719a.g(i);
    }

    @Override // b8.e
    public final List getAnnotations() {
        return this.f3719a.getAnnotations();
    }

    @Override // b8.e
    public final z3 getKind() {
        return this.f3719a.getKind();
    }

    @Override // b8.e
    public final b8.e h(int i) {
        return this.f3719a.h(i);
    }

    public final int hashCode() {
        return this.f3719a.hashCode() * 31;
    }

    @Override // b8.e
    public final boolean i(int i) {
        return this.f3719a.i(i);
    }

    @Override // b8.e
    public final boolean isInline() {
        return this.f3719a.isInline();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3719a);
        sb.append('?');
        return sb.toString();
    }
}
