package b2;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final q f906a = new q();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f907b = l2.c.a("pc");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f908c = l2.c.a("symbol");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f909d = l2.c.a("file");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f910e = l2.c.a(TypedValues.CycleType.S_WAVE_OFFSET);
    public static final l2.c f = l2.c.a("importance");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        l2.e eVar = (l2.e) obj2;
        x0 x0Var = (x0) ((z1) obj);
        eVar.f(f907b, x0Var.f971a);
        eVar.a(f908c, x0Var.f972b);
        eVar.a(f909d, x0Var.f973c);
        eVar.f(f910e, x0Var.f974d);
        eVar.e(f, x0Var.f975e);
    }
}
