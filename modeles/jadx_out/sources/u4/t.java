package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10603a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10604b;

    /* renamed from: l, reason: collision with root package name */
    public int f10605l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(f0 f0Var, v6.c cVar) {
        super(cVar);
        this.f10604b = f0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f10603a = obj;
        this.f10605l |= Integer.MIN_VALUE;
        return f0.a(this.f10604b, this);
    }
}
