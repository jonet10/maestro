package c4;

import android.content.Context;
import android.content.Intent;
import androidx.browser.trusted.sharing.ShareTarget;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.VirusTotalReport;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2293a;

    /* renamed from: b, reason: collision with root package name */
    public int f2294b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f2295l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x3(MoreInfo moreInfo, t6.c cVar, int i) {
        super(2, cVar);
        this.f2293a = i;
        this.f2295l = moreInfo;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2293a) {
            case 0:
                return new x3(this.f2295l, cVar, 0);
            case 1:
                return new x3(this.f2295l, cVar, 1);
            case 2:
                return new x3(this.f2295l, cVar, 2);
            case 3:
                return new x3(this.f2295l, cVar, 3);
            default:
                return new x3(this.f2295l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2293a) {
        }
        return ((x3) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Object obj2;
        int i = this.f2293a;
        int i6 = 0;
        Object obj3 = p6.x.f8463a;
        Object obj4 = u6.a.f10762a;
        MoreInfo moreInfo = this.f2295l;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i10 = this.f2294b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        p6.a.e(obj);
                        return obj3;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                Context applicationContext = moreInfo.getApplicationContext();
                applicationContext.getClass();
                j5.v vVar = new j5.v(applicationContext);
                x4.g gVar = moreInfo.Q;
                gVar.getClass();
                x4.g2 k5 = vVar.k(k0.k.g(gVar.f11158a, "https://www.uptodown.app:443/eapi/v2/app/", "/abis"), null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/v2/app/appId/abis");
                if (k5.b() || (jSONObject = k5.f11206d) == null) {
                    return obj3;
                }
                if (jSONObject.optInt("success") == 1 && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                    moreInfo.R = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i11 = 0; i11 < length; i11++) {
                        ArrayList arrayList = moreInfo.R;
                        arrayList.getClass();
                        arrayList.add(optJSONArray.get(i11).toString());
                    }
                }
                v7.e eVar = o7.m0.f8288a;
                p7.c cVar2 = t7.n.f10348a;
                w3 w3Var = new w3(moreInfo, null, 0);
                this.f2294b = 1;
                return o7.c0.C(w3Var, cVar2, this) == obj4 ? obj4 : obj3;
            case 1:
                int i12 = this.f2294b;
                if (i12 == 0) {
                    p6.a.e(obj);
                    this.f2294b = 1;
                    return MoreInfo.z0(moreInfo, this) == obj4 ? obj4 : obj3;
                }
                if (i12 == 1) {
                    p6.a.e(obj);
                    return obj3;
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                int i13 = this.f2294b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        p6.a.e(obj);
                        return obj3;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                this.f2294b = 1;
                int i14 = MoreInfo.V;
                v7.e eVar2 = o7.m0.f8288a;
                Object C = o7.c0.C(new x3(moreInfo, cVar, i6), v7.d.f10884a, this);
                if (C != obj4) {
                    C = obj3;
                }
                return C == obj4 ? obj4 : obj3;
            case 3:
                int i15 = this.f2294b;
                if (i15 == 0) {
                    p6.a.e(obj);
                    this.f2294b = 1;
                    return MoreInfo.y0(moreInfo, this) == obj4 ? obj4 : obj3;
                }
                if (i15 == 1) {
                    p6.a.e(obj);
                    return obj3;
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i16 = this.f2294b;
                if (i16 == 0) {
                    p6.a.e(obj);
                    x4.g gVar2 = moreInfo.Q;
                    gVar2.getClass();
                    String valueOf = String.valueOf(gVar2.J);
                    x4.g gVar3 = moreInfo.Q;
                    gVar3.getClass();
                    b5.m mVar = new b5.m(moreInfo, valueOf, gVar3.P, 22);
                    this.f2294b = 1;
                    Object D = mVar.D(this);
                    obj2 = D;
                    if (D == obj4) {
                        return obj4;
                    }
                } else {
                    if (i16 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    obj2 = ((p6.k) obj).f8444a;
                }
                if (!(obj2 instanceof p6.j)) {
                    Intent intent = new Intent(moreInfo, (Class<?>) VirusTotalReport.class);
                    intent.putExtra("appInfo", moreInfo.Q);
                    intent.putExtra("appReportVT", (x4.f2) obj2);
                    float f = UptodownApp.I;
                    moreInfo.startActivity(intent, b4.d.a(moreInfo));
                }
                if (p6.k.a(obj2) == null) {
                    return obj3;
                }
                Intent intent2 = new Intent(moreInfo, (Class<?>) VirusTotalReport.class);
                intent2.putExtra("appInfo", moreInfo.Q);
                intent2.putExtra("isVirusTotalReportAvaialable", false);
                float f10 = UptodownApp.I;
                moreInfo.startActivity(intent2, b4.d.a(moreInfo));
                return obj3;
        }
    }
}
