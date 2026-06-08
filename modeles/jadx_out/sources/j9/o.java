package j9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public s f6787a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6788b;

    /* renamed from: l, reason: collision with root package name */
    public int f6789l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f6790m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ s f6791n;

    /* renamed from: o, reason: collision with root package name */
    public int f6792o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(s sVar, v6.c cVar) {
        super(cVar);
        this.f6791n = sVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6790m = obj;
        this.f6792o |= Integer.MIN_VALUE;
        return this.f6791n.a(0, this);
    }
}
