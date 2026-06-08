package j9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public x f6823a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6824b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x f6825l;

    /* renamed from: m, reason: collision with root package name */
    public int f6826m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, v6.c cVar) {
        super(cVar);
        this.f6825l = xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6824b = obj;
        this.f6826m |= Integer.MIN_VALUE;
        return this.f6825l.b(this);
    }
}
