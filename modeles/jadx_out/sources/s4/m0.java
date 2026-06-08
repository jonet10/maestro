package s4;

import androidx.browser.trusted.sharing.ShareTarget;
import e1.v4;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9242a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v4 f9243b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(v4 v4Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f9242a = i;
        this.f9243b = v4Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9242a) {
            case 0:
                return new m0(this.f9243b, cVar, 0);
            default:
                return new m0(this.f9243b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9242a) {
        }
        return ((m0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        switch (this.f9242a) {
            case 0:
                p6.a.e(obj);
                j5.v vVar = new j5.v(this.f9243b.f4332b);
                g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/my-recommended-list/private"), null, ShareTarget.METHOD_POST, false);
                k5.f11206d = vVar.i(k5, "/eapi/my-recommended-list/private");
                return new p6.k((k5.b() || (str = k5.f11203a) == null || str.length() == 0) ? Boolean.TRUE : Boolean.FALSE);
            default:
                p6.a.e(obj);
                j5.v vVar2 = new j5.v(this.f9243b.f4332b);
                g2 k10 = vVar2.k("https://www.uptodown.app:443".concat("/eapi/my-recommended-list/public"), null, ShareTarget.METHOD_POST, false);
                k10.f11206d = vVar2.i(k10, "/eapi/my-recommended-list/public");
                return new p6.k((k10.b() || (str2 = k10.f11203a) == null || str2.length() == 0) ? Boolean.FALSE : Boolean.TRUE);
        }
    }
}
