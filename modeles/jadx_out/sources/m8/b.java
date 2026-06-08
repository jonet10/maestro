package m8;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f7678a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final b f7679b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final b f7680c = new b();

    /* renamed from: d, reason: collision with root package name */
    public static final b f7681d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static b f7682e;

    public static Socket a(m mVar, a aVar, p8.e eVar) {
        Iterator it = mVar.f7760d.iterator();
        while (it.hasNext()) {
            p8.a aVar2 = (p8.a) it.next();
            if (aVar2.g(aVar, null) && aVar2.h != null && aVar2 != eVar.a()) {
                if (eVar.f8492l != null || eVar.i.f8476n.size() != 1) {
                    throw new IllegalStateException();
                }
                Reference reference = (Reference) eVar.i.f8476n.get(0);
                Socket b7 = eVar.b(true, false, false);
                eVar.i = aVar2;
                aVar2.f8476n.add(reference);
                return b7;
            }
        }
        return null;
    }

    public static void b(m mVar, a aVar, p8.e eVar, f0 f0Var) {
        Iterator it = mVar.f7760d.iterator();
        while (it.hasNext()) {
            p8.a aVar2 = (p8.a) it.next();
            if (aVar2.g(aVar, f0Var)) {
                if (eVar.i != null) {
                    throw new IllegalStateException();
                }
                eVar.i = aVar2;
                eVar.j = true;
                aVar2.f8476n.add(new p8.d(eVar, eVar.f));
                return;
            }
        }
    }
}
