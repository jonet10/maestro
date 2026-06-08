package j0;

import a4.c0;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends i0.g {

    /* renamed from: b, reason: collision with root package name */
    public final i0.d f6519b;

    public o(i0.d dVar) {
        this.f6519b = dVar;
    }

    public final f0.g b(f0.g gVar) {
        boolean z9 = true;
        if (!gVar.i && !((Boolean) BasePendingResult.j.get()).booleanValue()) {
            z9 = false;
        }
        gVar.i = z9;
        i0.d dVar = this.f6519b;
        e eVar = dVar.j;
        eVar.getClass();
        s sVar = new s(new u(gVar), eVar.f6498r.get(), dVar);
        c0 c0Var = eVar.v;
        c0Var.sendMessage(c0Var.obtainMessage(4, sVar));
        return gVar;
    }
}
