package c3;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements e3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1285a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f1286b;

    public /* synthetic */ m(f0.i iVar, int i) {
        this.f1285a = i;
        this.f1286b = iVar;
    }

    @Override // m6.a
    public final Object get() {
        switch (this.f1285a) {
            case 0:
                return new l((s2.b) this.f1286b.f4811b);
            default:
                return new f3.a((Context) this.f1286b.f4811b);
        }
    }
}
