package e8;

import f8.b0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends x {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4778a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4779b;

    public n(String str, boolean z9) {
        str.getClass();
        this.f4778a = z9;
        this.f4779b = str.toString();
    }

    @Override // e8.x
    public final String c() {
        return this.f4779b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f4778a == nVar.f4778a && kotlin.jvm.internal.l.a(this.f4779b, nVar.f4779b);
    }

    public final int hashCode() {
        return this.f4779b.hashCode() + ((this.f4778a ? 1231 : 1237) * 31);
    }

    @Override // e8.x
    public final String toString() {
        boolean z9 = this.f4778a;
        String str = this.f4779b;
        if (!z9) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        b0.a(str, sb);
        return sb.toString();
    }
}
