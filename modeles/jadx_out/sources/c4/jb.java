package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class jb extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public j5.r f1769a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1770b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kb f1771l;

    /* renamed from: m, reason: collision with root package name */
    public int f1772m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(kb kbVar, t6.c cVar) {
        super(cVar);
        this.f1771l = kbVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1770b = obj;
        this.f1772m |= Integer.MIN_VALUE;
        return this.f1771l.a(null, this);
    }
}
