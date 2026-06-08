package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public f f9046a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9047b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f f9048l;

    /* renamed from: m, reason: collision with root package name */
    public int f9049m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(f fVar, t6.c cVar) {
        super(cVar);
        this.f9048l = fVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9047b = obj;
        this.f9049m |= Integer.MIN_VALUE;
        return this.f9048l.emit(null, this);
    }
}
