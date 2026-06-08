package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 {
    public static final a0 Companion = new a0();

    /* renamed from: a, reason: collision with root package name */
    public final int f1195a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1196b;

    public /* synthetic */ b0(int i, int i6, String str) {
        if (3 != (i & 3)) {
            d8.o0.e(z.f1354a.getDescriptor(), i, 3);
            throw null;
        }
        this.f1195a = i6;
        this.f1196b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f1195a == b0Var.f1195a && kotlin.jvm.internal.l.a(this.f1196b, b0Var.f1196b);
    }

    public final int hashCode() {
        return this.f1196b.hashCode() + (this.f1195a * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProcessData(pid=");
        sb.append(this.f1195a);
        sb.append(", uuid=");
        return a4.x.m(sb, this.f1196b, ')');
    }

    public b0(int i, String str) {
        str.getClass();
        this.f1195a = i;
        this.f1196b = str;
    }
}
