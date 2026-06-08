package r7;

import c4.dd;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public dd f9057a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9058b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f9059l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ dd f9060m;

    /* renamed from: n, reason: collision with root package name */
    public int f9061n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(dd ddVar, t6.c cVar) {
        super(cVar);
        this.f9060m = ddVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9059l = obj;
        this.f9061n |= Integer.MIN_VALUE;
        return this.f9060m.emit(null, this);
    }
}
