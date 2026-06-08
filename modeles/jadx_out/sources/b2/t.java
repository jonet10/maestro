package b2;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final t f935a = new t();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f936b = l2.c.a("timestamp");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f937c = l2.c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f938d = l2.c.a("app");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f939e = l2.c.a("device");
    public static final l2.c f = l2.c.a("log");
    public static final l2.c g = l2.c.a("rollouts");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        l2.e eVar = (l2.e) obj2;
        p0 p0Var = (p0) ((j2) obj);
        eVar.f(f936b, p0Var.f901a);
        eVar.a(f937c, p0Var.f902b);
        eVar.a(f938d, p0Var.f903c);
        eVar.a(f939e, p0Var.f904d);
        eVar.a(f, p0Var.f905e);
        eVar.a(g, p0Var.f);
    }
}
