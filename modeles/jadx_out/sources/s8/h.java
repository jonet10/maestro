package s8;

import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends n8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9405b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9406l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q f9407m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(q qVar, Object[] objArr, int i, int i6) {
        super("OkHttp %s stream %d", objArr);
        this.f9407m = qVar;
        this.f9405b = i;
        this.f9406l = i6;
    }

    @Override // n8.a
    public final void a() {
        q qVar = this.f9407m;
        try {
            qVar.A.i(this.f9405b, this.f9406l);
        } catch (IOException unused) {
            qVar.c();
        }
    }
}
