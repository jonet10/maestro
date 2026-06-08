package a5;

import r7.d0;
import r7.e0;
import r7.j0;
import r7.k0;
import r7.o0;
import x4.a1;
import x4.r;
import x4.v0;
import x4.w0;
import x4.x0;
import x4.y0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f197a;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f198b;

    /* renamed from: c, reason: collision with root package name */
    public static final j0 f199c;

    /* renamed from: d, reason: collision with root package name */
    public static final d0 f200d;

    static {
        o0 b7 = k0.b(x0.f11447a);
        f197a = b7;
        f198b = new e0(b7);
        j0 a8 = k0.a(0, 1);
        f199c = a8;
        f200d = new d0(a8);
    }

    public static r a() {
        a1 a1Var = (a1) f197a.getValue();
        if (a1Var instanceof w0) {
            return ((w0) a1Var).f11427a;
        }
        if (a1Var instanceof y0) {
            return ((y0) a1Var).f11466a;
        }
        return null;
    }

    public static boolean b(long j) {
        o0 o0Var = f197a;
        if (!(o0Var.getValue() instanceof w0)) {
            return false;
        }
        Object value = o0Var.getValue();
        value.getClass();
        r rVar = ((w0) value).f11427a;
        return rVar != null && rVar.f11361q == j;
    }

    public static boolean c(long j) {
        o0 o0Var = f197a;
        if (!(o0Var.getValue() instanceof y0)) {
            return false;
        }
        Object value = o0Var.getValue();
        value.getClass();
        r rVar = ((y0) value).f11466a;
        return rVar != null && rVar.f11361q == j;
    }

    public static void d() {
        g(v0.f11420a);
    }

    public static void e() {
        a1 a1Var = (a1) f197a.getValue();
        if (a1Var instanceof w0) {
            g(new y0(((w0) a1Var).f11427a));
        }
    }

    public static void f() {
        a1 a1Var = (a1) f197a.getValue();
        if (a1Var instanceof y0) {
            g(new w0(((y0) a1Var).f11466a));
        }
    }

    public static void g(a1 a1Var) {
        o0 o0Var = f197a;
        o0Var.getClass();
        o0Var.g(null, a1Var);
    }
}
