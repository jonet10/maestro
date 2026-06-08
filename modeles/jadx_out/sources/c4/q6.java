package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q6 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c3.y0 f2016b;

    /* renamed from: l, reason: collision with root package name */
    public int f2017l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(c3.y0 y0Var, t6.c cVar) {
        super(cVar);
        this.f2016b = y0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f2015a = obj;
        this.f2017l |= Integer.MIN_VALUE;
        return this.f2016b.a(null, this);
    }
}
