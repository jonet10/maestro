package u6;

import d7.p;
import kotlin.jvm.internal.a0;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f10767a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f10768b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t6.c f10769l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(t6.c cVar, h hVar, p pVar, t6.c cVar2) {
        super(cVar, hVar);
        this.f10768b = pVar;
        this.f10769l = cVar2;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f10767a;
        if (i != 0) {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("This coroutine had already completed");
                return null;
            }
            this.f10767a = 2;
            p6.a.e(obj);
            return obj;
        }
        this.f10767a = 1;
        p6.a.e(obj);
        p pVar = this.f10768b;
        pVar.getClass();
        a0.b(2, pVar);
        return pVar.invoke(this.f10769l, this);
    }
}
