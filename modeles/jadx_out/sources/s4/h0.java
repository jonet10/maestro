package s4;

import androidx.browser.trusted.sharing.ShareTarget;
import e1.v4;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v4 f9211b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f9212l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(v4 v4Var, long j, t6.c cVar, int i) {
        super(2, cVar);
        this.f9210a = i;
        this.f9211b = v4Var;
        this.f9212l = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9210a) {
            case 0:
                return new h0(this.f9211b, this.f9212l, cVar, 0);
            default:
                return new h0(this.f9211b, this.f9212l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9210a) {
        }
        return ((h0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.j jVar;
        Object obj2;
        String str;
        p6.j jVar2;
        Object obj3;
        String str2;
        switch (this.f9210a) {
            case 0:
                p6.a.e(obj);
                j5.v vVar = new j5.v(this.f9211b.f4332b);
                String g = k0.k.g(this.f9212l, "/eapi/app/", "/recommended/add");
                g2 k5 = vVar.k("https://www.uptodown.app:443".concat(g), null, ShareTarget.METHOD_POST, false);
                k5.f11206d = vVar.i(k5, g);
                if (k5.b() || (str = k5.f11203a) == null || str.length() == 0) {
                    jVar = new p6.j(new Exception());
                } else {
                    String str3 = k5.f11203a;
                    str3.getClass();
                    if (new JSONObject(str3).optInt("success") == 1) {
                        obj2 = Boolean.TRUE;
                        return new p6.k(obj2);
                    }
                    jVar = new p6.j(new Exception());
                }
                obj2 = jVar;
                return new p6.k(obj2);
            default:
                p6.a.e(obj);
                j5.v vVar2 = new j5.v(this.f9211b.f4332b);
                String g3 = k0.k.g(this.f9212l, "/eapi/app/", "/recommended/delete");
                g2 k10 = vVar2.k("https://www.uptodown.app:443".concat(g3), null, ShareTarget.METHOD_POST, false);
                k10.f11206d = vVar2.i(k10, g3);
                if (k10.b() || (str2 = k10.f11203a) == null || str2.length() == 0) {
                    jVar2 = new p6.j(new Exception());
                } else {
                    String str4 = k10.f11203a;
                    str4.getClass();
                    if (new JSONObject(str4).optInt("success") == 1) {
                        obj3 = Boolean.TRUE;
                        return new p6.k(obj3);
                    }
                    jVar2 = new p6.j(new Exception());
                }
                obj3 = jVar2;
                return new p6.k(obj3);
        }
    }
}
