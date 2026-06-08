package a5;

import r7.d0;
import r7.e0;
import r7.j0;
import r7.k0;
import r7.o0;
import x4.f0;
import x4.g0;
import x4.h0;
import x4.i0;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f193a;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f194b;

    /* renamed from: c, reason: collision with root package name */
    public static final j0 f195c;

    /* renamed from: d, reason: collision with root package name */
    public static final d0 f196d;

    static {
        o0 b7 = k0.b(g0.f11198a);
        f193a = b7;
        f194b = new e0(b7);
        j0 a8 = k0.a(0, 1);
        f195c = a8;
        f196d = new d0(a8);
    }

    public static void a() {
        o0 o0Var = f193a;
        if ((o0Var.getValue() instanceof x4.e0) || (o0Var.getValue() instanceof h0)) {
            i(g0.f11198a);
        }
    }

    public static r b() {
        i0 i0Var = (i0) f193a.getValue();
        if (i0Var instanceof f0) {
            return ((f0) i0Var).f11150a;
        }
        if (i0Var instanceof h0) {
            return ((h0) i0Var).f11209a;
        }
        return null;
    }

    public static boolean c(long j) {
        o0 o0Var = f193a;
        if (!(o0Var.getValue() instanceof f0)) {
            return false;
        }
        Object value = o0Var.getValue();
        value.getClass();
        return ((f0) value).f11150a.f11361q == j;
    }

    public static boolean d() {
        return f193a.getValue() instanceof h0;
    }

    public static boolean e(long j) {
        o0 o0Var = f193a;
        if (!(o0Var.getValue() instanceof h0)) {
            return false;
        }
        Object value = o0Var.getValue();
        value.getClass();
        return ((h0) value).f11209a.f11361q == j;
    }

    public static void f() {
        i(x4.e0.f11137a);
    }

    public static void g() {
        i0 i0Var = (i0) f193a.getValue();
        if (i0Var instanceof f0) {
            i(new h0(((f0) i0Var).f11150a));
        }
    }

    public static void h() {
        i0 i0Var = (i0) f193a.getValue();
        if (i0Var instanceof h0) {
            i(new f0(((h0) i0Var).f11209a));
        }
    }

    public static void i(i0 i0Var) {
        o0 o0Var = f193a;
        o0Var.getClass();
        o0Var.g(null, i0Var);
    }
}
