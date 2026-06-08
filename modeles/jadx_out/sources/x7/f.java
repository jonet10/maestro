package x7;

import d7.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f extends kotlin.jvm.internal.k implements q {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11526a = new f(3, g.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        g gVar = (g) obj;
        gVar.getClass();
        if (!kotlin.jvm.internal.l.a(obj3, h.f11529b)) {
            return gVar;
        }
        com.google.gson.internal.a.m(obj2, "This mutex is already locked by the specified owner: ");
        return null;
    }
}
