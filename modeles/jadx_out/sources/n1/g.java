package n1;

import a4.d0;
import java.util.concurrent.Executor;
import o7.c0;
import s1.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements s1.d {

    /* renamed from: b, reason: collision with root package name */
    public static final g f7913b = new g(0);

    /* renamed from: l, reason: collision with root package name */
    public static final g f7914l = new g(1);

    /* renamed from: m, reason: collision with root package name */
    public static final g f7915m = new g(2);

    /* renamed from: n, reason: collision with root package name */
    public static final g f7916n = new g(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7917a;

    public /* synthetic */ g(int i) {
        this.f7917a = i;
    }

    @Override // s1.d
    public final Object c(d0 d0Var) {
        switch (this.f7917a) {
            case 0:
                Object e10 = d0Var.e(new r(r1.a.class, Executor.class));
                e10.getClass();
                return c0.m((Executor) e10);
            case 1:
                Object e11 = d0Var.e(new r(r1.c.class, Executor.class));
                e11.getClass();
                return c0.m((Executor) e11);
            case 2:
                Object e12 = d0Var.e(new r(r1.b.class, Executor.class));
                e12.getClass();
                return c0.m((Executor) e12);
            default:
                Object e13 = d0Var.e(new r(r1.d.class, Executor.class));
                e13.getClass();
                return c0.m((Executor) e13);
        }
    }
}
