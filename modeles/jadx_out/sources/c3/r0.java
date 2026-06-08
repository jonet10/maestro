package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public s0 f1312a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1313b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ s0 f1314l;

    /* renamed from: m, reason: collision with root package name */
    public int f1315m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, v6.c cVar) {
        super(cVar);
        this.f1314l = s0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1313b = obj;
        this.f1315m |= Integer.MIN_VALUE;
        return s0.a(this.f1314l, this);
    }
}
