package j4;

import a2.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6568b;

    /* renamed from: l, reason: collision with root package name */
    public int f6569l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(t tVar, v6.c cVar) {
        super(cVar);
        this.f6568b = tVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6567a = obj;
        this.f6569l |= Integer.MIN_VALUE;
        return this.f6568b.b(null, this);
    }
}
