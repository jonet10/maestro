package c4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.uptodown.activities.MoreInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b4 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1413a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f1414b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f1415l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(MoreInfo moreInfo, kotlin.jvm.internal.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1415l = moreInfo;
        this.f1414b = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1413a) {
            case 0:
                return new b4(this.f1415l, this.f1414b, cVar);
            default:
                return new b4(this.f1414b, this.f1415l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1413a) {
            case 0:
                b4 b4Var = (b4) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                b4Var.invokeSuspend(xVar);
                return xVar;
            default:
                b4 b4Var2 = (b4) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                b4Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        int i;
        int i6 = this.f1413a;
        p6.x xVar = p6.x.f8463a;
        MoreInfo moreInfo = this.f1415l;
        kotlin.jvm.internal.v vVar = this.f1414b;
        switch (i6) {
            case 0:
                p6.a.e(obj);
                Context applicationContext = moreInfo.getApplicationContext();
                applicationContext.getClass();
                j5.v vVar2 = new j5.v(applicationContext);
                x4.g gVar = moreInfo.Q;
                gVar.getClass();
                x4.g2 k5 = vVar2.k(k0.k.g(gVar.f11158a, "https://www.uptodown.app:443/eapi/apps/", "/permissions"), null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar2.i(k5, "/eapi/apps/appId/permissions");
                if (!k5.b() && (jSONObject = k5.f11206d) != null) {
                    if (!jSONObject.isNull("success")) {
                        vVar.f7022a = jSONObject.optInt("success");
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (vVar.f7022a == 1 && optJSONObject != null) {
                        moreInfo.S = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray("permissions_concern");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i10 = 0; i10 < length; i10++) {
                                x4.v1 v1Var = new x4.v1();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                                optJSONObject2.getClass();
                                if (!optJSONObject2.isNull("permission")) {
                                    v1Var.f11421a = optJSONObject2.optString("permission");
                                }
                                if (!optJSONObject2.isNull("description")) {
                                    optJSONObject2.optString("description");
                                }
                                ArrayList arrayList = moreInfo.S;
                                arrayList.getClass();
                                arrayList.add(v1Var);
                            }
                        }
                        moreInfo.T = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("permissions");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i11 = 0; i11 < length2; i11++) {
                                x4.v1 v1Var2 = new x4.v1();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i11);
                                optJSONObject3.getClass();
                                if (!optJSONObject3.isNull("permission")) {
                                    v1Var2.f11421a = optJSONObject3.optString("permission");
                                }
                                if (!optJSONObject3.isNull("description")) {
                                    optJSONObject3.optString("description");
                                }
                                ArrayList arrayList2 = moreInfo.T;
                                arrayList2.getClass();
                                arrayList2.add(v1Var2);
                            }
                            break;
                        }
                    }
                }
                break;
            default:
                p6.a.e(obj);
                if (vVar.f7022a == 1) {
                    int i12 = MoreInfo.V;
                    moreInfo.B0().G.setVisibility(0);
                    ArrayList arrayList3 = moreInfo.S;
                    if (arrayList3 == null || arrayList3.isEmpty()) {
                        moreInfo.B0().G.setVisibility(8);
                        i = 0;
                    } else {
                        MoreInfo.A0(moreInfo, moreInfo.S, moreInfo.B0().f10189p);
                        ArrayList arrayList4 = moreInfo.S;
                        arrayList4.getClass();
                        i = arrayList4.size();
                    }
                    ArrayList arrayList5 = moreInfo.T;
                    if (arrayList5 != null && !arrayList5.isEmpty()) {
                        MoreInfo.A0(moreInfo, moreInfo.T, moreInfo.B0().f10193r);
                        ArrayList arrayList6 = moreInfo.T;
                        arrayList6.getClass();
                        i += arrayList6.size();
                    }
                    x4.g gVar2 = moreInfo.Q;
                    if (gVar2 != null && gVar2.H == 0) {
                        moreInfo.B0().f10198t0.setText(String.valueOf(i));
                    }
                } else {
                    int i13 = MoreInfo.V;
                    moreInfo.B0().G.setVisibility(8);
                }
                moreInfo.B0().f10197t.setVisibility(8);
                moreInfo.B0().M.setVisibility(0);
                break;
        }
        return xVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(kotlin.jvm.internal.v vVar, MoreInfo moreInfo, t6.c cVar) {
        super(2, cVar);
        this.f1414b = vVar;
        this.f1415l = moreInfo;
    }
}
