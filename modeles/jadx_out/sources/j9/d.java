package j9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public f f6747a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6748b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f f6749l;

    /* renamed from: m, reason: collision with root package name */
    public int f6750m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, v6.c cVar) {
        super(cVar);
        this.f6749l = fVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6748b = obj;
        this.f6750m |= Integer.MIN_VALUE;
        return this.f6749l.d(this);
    }
}
