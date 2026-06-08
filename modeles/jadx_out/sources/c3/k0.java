package c3;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 implements e3.b, t.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1281a;

    /* renamed from: b, reason: collision with root package name */
    public final m6.a f1282b;

    public /* synthetic */ k0(m6.a aVar, int i) {
        this.f1281a = i;
        this.f1282b = aVar;
    }

    @Override // m6.a
    public final Object get() {
        switch (this.f1281a) {
            case 0:
                return new j0((t0) this.f1282b.get());
            default:
                return new y.j((Context) this.f1282b.get(), Integer.valueOf(y.j.f11594m).intValue(), "com.google.android.datatransport.events");
        }
    }
}
