package s8;

import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends n8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9408b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f9409l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q f9410m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(q qVar, Object[] objArr, int i, long j) {
        super("OkHttp Window Update %s stream %d", objArr);
        this.f9410m = qVar;
        this.f9408b = i;
        this.f9409l = j;
    }

    @Override // n8.a
    public final void a() {
        q qVar = this.f9410m;
        try {
            qVar.A.r(this.f9408b, this.f9409l);
        } catch (IOException unused) {
            qVar.c();
        }
    }
}
