package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t1 extends t7.r {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8313n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t1(t6.h hVar, t6.c cVar, int i) {
        super(cVar, hVar);
        this.f8313n = i;
    }

    @Override // o7.m1
    public final boolean B(Throwable th) {
        switch (this.f8313n) {
            case 0:
                return false;
            default:
                return x(th);
        }
    }
}
