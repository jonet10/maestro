package c3;

import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 {
    public static final h0 Companion = new h0();

    /* renamed from: d, reason: collision with root package name */
    public static final z7.b[] f1267d = {null, null, new d8.e0(d8.b1.f3621a, z.f1354a)};

    /* renamed from: a, reason: collision with root package name */
    public final n0 f1268a;

    /* renamed from: b, reason: collision with root package name */
    public final g1 f1269b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f1270c;

    public /* synthetic */ i0(int i, n0 n0Var, g1 g1Var, Map map) {
        if (1 != (i & 1)) {
            d8.o0.e(g0.f1246a.getDescriptor(), i, 1);
            throw null;
        }
        this.f1268a = n0Var;
        if ((i & 2) == 0) {
            this.f1269b = null;
        } else {
            this.f1269b = g1Var;
        }
        if ((i & 4) == 0) {
            this.f1270c = null;
        } else {
            this.f1270c = map;
        }
    }

    public static i0 a(i0 i0Var, n0 n0Var, g1 g1Var, Map map, int i) {
        if ((i & 1) != 0) {
            n0Var = i0Var.f1268a;
        }
        if ((i & 2) != 0) {
            g1Var = i0Var.f1269b;
        }
        if ((i & 4) != 0) {
            map = i0Var.f1270c;
        }
        i0Var.getClass();
        n0Var.getClass();
        return new i0(n0Var, g1Var, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return kotlin.jvm.internal.l.a(this.f1268a, i0Var.f1268a) && kotlin.jvm.internal.l.a(this.f1269b, i0Var.f1269b) && kotlin.jvm.internal.l.a(this.f1270c, i0Var.f1270c);
    }

    public final int hashCode() {
        int hashCode = this.f1268a.hashCode() * 31;
        g1 g1Var = this.f1269b;
        int hashCode2 = (hashCode + (g1Var == null ? 0 : g1Var.hashCode())) * 31;
        Map map = this.f1270c;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "SessionData(sessionDetails=" + this.f1268a + ", backgroundTime=" + this.f1269b + ", processDataMap=" + this.f1270c + ')';
    }

    public i0(n0 n0Var, g1 g1Var, Map map) {
        n0Var.getClass();
        this.f1268a = n0Var;
        this.f1269b = g1Var;
        this.f1270c = map;
    }
}
