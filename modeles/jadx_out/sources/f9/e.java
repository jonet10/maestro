package f9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5014a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f5015b;

    /* renamed from: l, reason: collision with root package name */
    public int f5016l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, v6.c cVar) {
        super(cVar);
        this.f5015b = hVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f5014a = obj;
        this.f5016l |= Integer.MIN_VALUE;
        return this.f5015b.b(0, null, null, this);
    }
}
