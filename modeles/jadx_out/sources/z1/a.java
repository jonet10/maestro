package z1;

import g5.f;
import g5.g;
import j1.i;
import j1.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.arch.core.executor.a f11902a = new androidx.arch.core.executor.a(2);

    public static p a(p pVar, p pVar2) {
        g gVar = new g(2);
        i iVar = new i((f) gVar.f5315b);
        androidx.transition.a aVar = new androidx.transition.a(iVar, new AtomicBoolean(false), gVar, 8);
        androidx.arch.core.executor.a aVar2 = f11902a;
        pVar.e(aVar2, aVar);
        pVar2.e(aVar2, aVar);
        return iVar.f6539a;
    }
}
