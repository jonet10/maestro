package s7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9351a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f9352b;

    /* renamed from: l, reason: collision with root package name */
    public int f9353l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, t6.c cVar) {
        super(cVar);
        this.f9352b = fVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9351a = obj;
        this.f9353l |= Integer.MIN_VALUE;
        return this.f9352b.emit(null, this);
    }
}
