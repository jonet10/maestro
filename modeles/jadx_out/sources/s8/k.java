package s8;

import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends n8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9414b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w8.h f9415l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f9416m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ q f9417n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(q qVar, Object[] objArr, int i, w8.h hVar, int i6, boolean z9) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.f9417n = qVar;
        this.f9414b = i;
        this.f9415l = hVar;
        this.f9416m = i6;
    }

    @Override // n8.a
    public final void a() {
        try {
            z zVar = this.f9417n.f9436s;
            w8.h hVar = this.f9415l;
            int i = this.f9416m;
            zVar.getClass();
            hVar.skip(i);
            this.f9417n.A.i(this.f9414b, 6);
            synchronized (this.f9417n) {
                this.f9417n.C.remove(Integer.valueOf(this.f9414b));
            }
        } catch (IOException unused) {
        }
    }
}
