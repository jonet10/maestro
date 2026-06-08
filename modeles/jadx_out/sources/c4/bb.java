package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class bb extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.u f1429a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1430b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ eb f1431l;

    /* renamed from: m, reason: collision with root package name */
    public int f1432m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(eb ebVar, v6.c cVar) {
        super(cVar);
        this.f1431l = ebVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1430b = obj;
        this.f1432m |= Integer.MIN_VALUE;
        return eb.a(this.f1431l, null, null, false, this);
    }
}
