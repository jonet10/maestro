package s4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9167a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b5.m f9168b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f9169l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(b5.m mVar, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f9167a = i;
        this.f9168b = mVar;
        this.f9169l = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9167a) {
            case 0:
                return new a0(this.f9168b, this.f9169l, cVar, 0);
            default:
                return new a0(this.f9168b, this.f9169l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9167a) {
        }
        return ((a0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.j jVar;
        Object obj2;
        JSONObject jSONObject;
        p6.j jVar2;
        Object obj3;
        JSONObject jSONObject2;
        switch (this.f9167a) {
            case 0:
                p6.a.e(obj);
                b5.m mVar = this.f9168b;
                j5.v vVar = new j5.v((Context) mVar.f1061b);
                String str = this.f9169l;
                str.getClass();
                g2 k5 = vVar.k("https://www.uptodown.app:443/eapi/v2/virus-total/" + str + "/report", null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/v2/virus-total/fileId/report");
                if (!k5.b() && (jSONObject = k5.f11206d) != null) {
                    obj2 = b5.m.v(mVar, jSONObject);
                    if (obj2 == null) {
                        jVar = new p6.j(new Exception());
                    }
                    return new p6.k(obj2);
                }
                jVar = new p6.j(new Exception());
                obj2 = jVar;
                return new p6.k(obj2);
            default:
                p6.a.e(obj);
                b5.m mVar2 = this.f9168b;
                j5.v vVar2 = new j5.v((Context) mVar2.f1061b);
                String str2 = this.f9169l;
                str2.getClass();
                g2 k10 = vVar2.k("https://www.uptodown.app:443/eapi/v2/virus-total-by-sha256/" + str2 + "/report", null, ShareTarget.METHOD_GET, false);
                k10.f11206d = vVar2.i(k10, "/eapi/v2/virus-total-by-sha256/sha256/report");
                if (!k10.b() && (jSONObject2 = k10.f11206d) != null) {
                    obj3 = b5.m.v(mVar2, jSONObject2);
                    if (obj3 == null) {
                        jVar2 = new p6.j(new Exception());
                    }
                    return new p6.k(obj3);
                }
                jVar2 = new p6.j(new Exception());
                obj3 = jVar2;
                return new p6.k(obj3);
        }
    }
}
