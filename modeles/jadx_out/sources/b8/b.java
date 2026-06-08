package b8;

import com.google.android.gms.internal.measurement.z3;
import java.util.List;
import kotlin.jvm.internal.l;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final f f1103a;

    /* renamed from: b, reason: collision with root package name */
    public final j7.c f1104b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1105c;

    public b(f fVar, j7.c cVar) {
        cVar.getClass();
        this.f1103a = fVar;
        this.f1104b = cVar;
        this.f1105c = fVar.f1112a + '<' + ((kotlin.jvm.internal.f) cVar).c() + '>';
    }

    @Override // b8.e
    public final String a() {
        return this.f1105c;
    }

    @Override // b8.e
    public final boolean c() {
        return false;
    }

    @Override // b8.e
    public final int d(String str) {
        str.getClass();
        return this.f1103a.d(str);
    }

    @Override // b8.e
    public final int e() {
        return this.f1103a.f1114c;
    }

    public final boolean equals(Object obj) {
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f1103a.equals(bVar.f1103a) && l.a(bVar.f1104b, this.f1104b);
    }

    @Override // b8.e
    public final String f(int i) {
        return this.f1103a.f1116e[i];
    }

    @Override // b8.e
    public final List g(int i) {
        return this.f1103a.g[i];
    }

    @Override // b8.e
    public final List getAnnotations() {
        return t.f8724a;
    }

    @Override // b8.e
    public final z3 getKind() {
        return this.f1103a.f1113b;
    }

    @Override // b8.e
    public final e h(int i) {
        return this.f1103a.f[i];
    }

    public final int hashCode() {
        return this.f1105c.hashCode() + (((kotlin.jvm.internal.f) this.f1104b).hashCode() * 31);
    }

    @Override // b8.e
    public final boolean i(int i) {
        return this.f1103a.h[i];
    }

    @Override // b8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f1104b + ", original: " + this.f1103a + ')';
    }
}
