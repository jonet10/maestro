package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9291a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m8.q f9292b;

    /* renamed from: l, reason: collision with root package name */
    public int f9293l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(m8.q qVar, v6.c cVar) {
        super(cVar);
        this.f9292b = qVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9291a = obj;
        this.f9293l |= Integer.MIN_VALUE;
        Object k5 = this.f9292b.k(0, this);
        return k5 == u6.a.f10762a ? k5 : new p6.k(k5);
    }
}
