package j9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public f f6739a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6740b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f f6741l;

    /* renamed from: m, reason: collision with root package name */
    public int f6742m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, v6.c cVar) {
        super(cVar);
        this.f6741l = fVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6740b = obj;
        this.f6742m |= Integer.MIN_VALUE;
        return this.f6741l.a(this);
    }
}
