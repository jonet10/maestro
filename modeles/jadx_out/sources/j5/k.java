package j5;

import c4.k0;
import com.uptodown.UptodownApp;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f6696a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4.g f6697b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f6698l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w4.g f6699m;

    public /* synthetic */ k(boolean z9, x4.g gVar, k0 k0Var, w4.g gVar2) {
        this.f6696a = z9;
        this.f6697b = gVar;
        this.f6698l = k0Var;
        this.f6699m = gVar2;
    }

    @Override // d7.a
    public final Object invoke() {
        x4.r rVar;
        if (this.f6696a) {
            float f = UptodownApp.I;
            rVar = b4.d.D(this.f6697b, this.f6698l);
        } else {
            rVar = null;
        }
        this.f6699m.u(rVar);
        return x.f8463a;
    }
}
