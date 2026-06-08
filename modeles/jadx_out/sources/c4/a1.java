package c4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1363a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f1364b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f1365l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f1366m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(b1 b1Var, Context context, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f1363a = i;
        this.f1364b = b1Var;
        this.f1365l = context;
        this.f1366m = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1363a) {
            case 0:
                return new a1(this.f1364b, this.f1365l, this.f1366m, cVar, 0);
            default:
                return new a1(this.f1364b, this.f1365l, this.f1366m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1363a) {
            case 0:
                a1 a1Var = (a1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                a1Var.invokeSuspend(xVar);
                return xVar;
            default:
                a1 a1Var2 = (a1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                a1Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        switch (this.f1363a) {
            case 0:
                p6.a.e(obj);
                b1 b1Var = this.f1364b;
                b1Var.h = true;
                ArrayList arrayList = new ArrayList();
                j5.v vVar = new j5.v(this.f1365l);
                int i = b1Var.f;
                String str = this.f1366m;
                str.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("page[limit]", String.valueOf(40));
                hashMap.put("page[offset]", String.valueOf(i));
                x4.g2 k5 = vVar.k(androidx.lifecycle.l.w("https://www.uptodown.app:443/eapi/user/", str, "/followers"), hashMap, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/user/userID/followers");
                if (k5.b() || (jSONObject = k5.f11206d) == null) {
                    b1Var.g = false;
                } else {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null) {
                        arrayList.addAll(x4.u2.f(optJSONArray));
                        b1Var.f = arrayList.size() + b1Var.f;
                    }
                }
                r7.o0 o0Var = b1Var.f1405a;
                j5.r rVar = new j5.r(arrayList);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                p6.a.e(obj);
                b1 b1Var2 = this.f1364b;
                b1Var2.h = true;
                ArrayList arrayList2 = new ArrayList();
                j5.v vVar2 = new j5.v(this.f1365l);
                int i6 = b1Var2.f;
                String str2 = this.f1366m;
                str2.getClass();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("page[limit]", String.valueOf(40));
                hashMap2.put("page[offset]", String.valueOf(i6));
                x4.g2 k10 = vVar2.k(androidx.lifecycle.l.w("https://www.uptodown.app:443/eapi/user/", str2, "/followings"), hashMap2, ShareTarget.METHOD_GET, false);
                k10.f11206d = vVar2.i(k10, "/eapi/user/userID/followings");
                if (k10.b() || (jSONObject2 = k10.f11206d) == null) {
                    b1Var2.g = false;
                } else {
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("data");
                    if (optJSONArray2 != null) {
                        arrayList2.addAll(x4.u2.f(optJSONArray2));
                        b1Var2.f = arrayList2.size() + b1Var2.f;
                    }
                }
                r7.o0 o0Var2 = b1Var2.f1405a;
                j5.r rVar2 = new j5.r(arrayList2);
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
