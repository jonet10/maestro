package s7;

import f8.w;
import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final t6.c[] f9348a = new t6.c[0];

    /* renamed from: b, reason: collision with root package name */
    public static final w f9349b = new w("NULL");

    /* renamed from: c, reason: collision with root package name */
    public static final w f9350c = new w("UNINITIALIZED");

    public static /* synthetic */ r7.h a(i iVar, t6.h hVar, int i, q7.a aVar, int i6) {
        if ((i6 & 1) != 0) {
            hVar = t6.i.f10314a;
        }
        if ((i6 & 2) != 0) {
            i = -3;
        }
        if ((i6 & 4) != 0) {
            aVar = q7.a.f8729a;
        }
        return iVar.a(hVar, i, aVar);
    }

    public static final Object b(t6.h hVar, Object obj, Object obj2, d7.p pVar, t6.c cVar) {
        Object invoke;
        Object l10 = t7.a.l(hVar, obj2);
        try {
            p pVar2 = new p(cVar, hVar);
            if (androidx.lifecycle.l.D(pVar)) {
                a0.b(2, pVar);
                invoke = pVar.invoke(obj, pVar2);
            } else {
                invoke = d0.b.Q(pVar, obj, pVar2);
            }
            t7.a.g(hVar, l10);
            if (invoke == u6.a.f10762a) {
                cVar.getClass();
            }
            return invoke;
        } catch (Throwable th) {
            t7.a.g(hVar, l10);
            throw th;
        }
    }
}
