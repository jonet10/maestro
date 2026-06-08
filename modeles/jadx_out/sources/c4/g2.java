package c4;

import androidx.browser.trusted.sharing.ShareTarget;
import com.uptodown.activities.ListsActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1617a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f1618b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h2 f1619l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1620m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(ListsActivity listsActivity, h2 h2Var, ArrayList arrayList, t6.c cVar) {
        super(2, cVar);
        this.f1618b = listsActivity;
        this.f1619l = h2Var;
        this.f1620m = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1617a) {
            case 0:
                return new g2(this.f1618b, this.f1620m, this.f1619l, cVar);
            default:
                return new g2(this.f1618b, this.f1619l, this.f1620m, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1617a) {
            case 0:
                g2 g2Var = (g2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                g2Var.invokeSuspend(xVar);
                return xVar;
            default:
                g2 g2Var2 = (g2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                g2Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        switch (this.f1617a) {
            case 0:
                p6.a.e(obj);
                j5.v vVar = new j5.v(this.f1618b);
                x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/user/categories"), null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/user/categories");
                boolean b7 = k5.b();
                ArrayList arrayList = this.f1620m;
                if (!b7 && (jSONObject = k5.f11206d) != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        optJSONObject2.getClass();
                        x4.c1 c1Var = new x4.c1();
                        c1Var.f11078c = new ArrayList();
                        if (!optJSONObject2.isNull("categoryID")) {
                            c1Var.f11076a = optJSONObject2.optInt("categoryID");
                        }
                        if (!optJSONObject2.isNull("categoryName")) {
                            c1Var.f11077b = optJSONObject2.optString("categoryName");
                        }
                        if (!optJSONObject2.isNull("categoryIcons") && (optJSONArray2 = optJSONObject2.optJSONArray("categoryIcons")) != null) {
                            int length2 = optJSONArray2.length();
                            for (int i6 = 0; i6 < length2; i6++) {
                                c1Var.f11078c.add(optJSONArray2.optString(i6));
                            }
                        }
                        if (!optJSONObject2.isNull("categoryAppsCount")) {
                            c1Var.f11079d = optJSONObject2.optInt("categoryAppsCount");
                        }
                        arrayList.add(c1Var);
                    }
                }
                r7.o0 o0Var = this.f1619l.j;
                j5.r rVar = new j5.r(arrayList);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                p6.a.e(obj);
                j5.v vVar2 = new j5.v(this.f1618b);
                h2 h2Var = this.f1619l;
                int i10 = h2Var.f1669m;
                HashMap hashMap = new HashMap();
                hashMap.put("page[limit]", String.valueOf(i10));
                hashMap.putAll(j5.v.g());
                int i11 = 0;
                x4.g2 k10 = vVar2.k("https://www.uptodown.app:443".concat("/eapi/v2/pre-register-apps-by-user"), hashMap, ShareTarget.METHOD_GET, false);
                k10.f11206d = vVar2.i(k10, "/eapi/v2/pre-register-apps-by-user");
                boolean b10 = k10.b();
                ArrayList arrayList2 = this.f1620m;
                if (!b10 && (jSONObject2 = k10.f11206d) != null && (optJSONObject = jSONObject2.optJSONObject("data")) != null) {
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("apps");
                    if (optJSONArray3 != null) {
                        int length3 = optJSONArray3.length();
                        while (i11 < length3) {
                            JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i11);
                            optJSONObject3.getClass();
                            x4.x1 x1Var = new x4.x1();
                            if (!optJSONObject3.isNull("appID")) {
                                x1Var.f11448a = optJSONObject3.optLong("appID");
                            }
                            if (!optJSONObject3.isNull("name")) {
                                x1Var.f11449b = optJSONObject3.optString("name");
                            }
                            if (!optJSONObject3.isNull("iconURL")) {
                                x1Var.f11450c = optJSONObject3.optString("iconURL");
                            }
                            if (!optJSONObject3.isNull("authorName")) {
                                x1Var.f11451d = optJSONObject3.optString("authorName");
                            }
                            arrayList2.add(x1Var);
                            i11++;
                        }
                    }
                    i11 = optJSONObject.optInt("countApps");
                }
                r7.o0 o0Var2 = h2Var.g;
                j5.r rVar2 = new j5.r(new e2(arrayList2, i11));
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(ListsActivity listsActivity, ArrayList arrayList, h2 h2Var, t6.c cVar) {
        super(2, cVar);
        this.f1618b = listsActivity;
        this.f1620m = arrayList;
        this.f1619l = h2Var;
    }
}
