package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.x f9267a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9268b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b5.m f9269l;

    /* renamed from: m, reason: collision with root package name */
    public int f9270m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(b5.m mVar, v6.c cVar) {
        super(cVar);
        this.f9269l = mVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9268b = obj;
        this.f9270m |= Integer.MIN_VALUE;
        return this.f9269l.F(this);
    }
}
