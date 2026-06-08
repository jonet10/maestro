package c4;

import androidx.browser.trusted.sharing.ShareTarget;
import com.uptodown.activities.UserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class yc extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2367a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f2368b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ zc f2369l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yc(UserActivity userActivity, zc zcVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f2367a = i;
        this.f2368b = userActivity;
        this.f2369l = zcVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2367a) {
            case 0:
                return new yc(this.f2368b, this.f2369l, cVar, 0);
            default:
                return new yc(this.f2368b, this.f2369l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2367a) {
            case 0:
                yc ycVar = (yc) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                ycVar.invokeSuspend(xVar);
                return xVar;
            default:
                yc ycVar2 = (yc) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                ycVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        switch (this.f2367a) {
            case 0:
                p6.a.e(obj);
                UserActivity userActivity = this.f2368b;
                int size = b2.t1.z(userActivity).size();
                j5.g l10 = j5.g.D.l(userActivity);
                l10.b();
                ArrayList P = l10.P();
                l10.c();
                Iterator it = P.iterator();
                it.getClass();
                int i = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    x4.r rVar = (x4.r) next;
                    if (rVar.p() && rVar.f11356l == 0 && rVar.c()) {
                        i++;
                    }
                }
                r7.o0 o0Var = this.f2369l.f2408a;
                j5.r rVar2 = new j5.r(new wc(i, size));
                o0Var.getClass();
                o0Var.g(null, rVar2);
                break;
            default:
                p6.a.e(obj);
                j5.v vVar = new j5.v(this.f2368b);
                x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/promo-assign/provider/1"), null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/promo-assign/provider/1");
                if (!k5.b() && (jSONObject = k5.f11206d) != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && !optJSONObject.isNull("url")) {
                    String optString = optJSONObject.optString("url");
                    r7.o0 o0Var2 = this.f2369l.f2412e;
                    j5.r rVar3 = new j5.r(optString);
                    o0Var2.getClass();
                    o0Var2.g(null, rVar3);
                }
                break;
        }
        return p6.x.f8463a;
    }
}
