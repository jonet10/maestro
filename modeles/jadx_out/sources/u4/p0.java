package u4;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.d3;
import x4.g2;
import x4.l2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j5.v f10568b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f10569l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v0 f10570m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(j5.v vVar, long j, v0 v0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10567a = i;
        this.f10568b = vVar;
        this.f10569l = j;
        this.f10570m = v0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10567a) {
            case 0:
                return new p0(this.f10568b, this.f10569l, this.f10570m, cVar, 0);
            default:
                return new p0(this.f10568b, this.f10569l, this.f10570m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10567a) {
            case 0:
                p0 p0Var = (p0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                p0Var.invokeSuspend(xVar);
                return xVar;
            default:
                p0 p0Var2 = (p0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                p0Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        JSONObject jSONObject;
        JSONArray optJSONArray;
        String str;
        JSONArray optJSONArray2;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        JSONArray optJSONArray3;
        switch (this.f10567a) {
            case 0:
                ArrayList w2 = a4.x.w(obj);
                String h = a4.x.h(this.f10569l, "https://www.uptodown.app:443/eapi/floating-categories/app/");
                j5.v vVar = this.f10568b;
                g2 k5 = vVar.k(h, null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/floating-categories/app");
                if (!k5.b() && (jSONObject = k5.f11206d) != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                    if (optJSONArray.length() <= 2) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            p2 p2Var = new p2(null, null, 7);
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("data");
                            if (optJSONObject3 != null) {
                                x4.j jVar = new x4.j(0, (String) null, 7);
                                jVar.b(optJSONObject3);
                                jVar.f11227m = true;
                                p2Var.f11329a = jVar;
                            }
                            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("apps");
                            if (optJSONArray4 != null) {
                                int length2 = optJSONArray4.length();
                                for (int i6 = 0; i6 < length2; i6++) {
                                    x4.g gVar = new x4.g();
                                    JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i6);
                                    optJSONObject4.getClass();
                                    gVar.a(null, optJSONObject4);
                                    p2Var.f11330b.add(gVar);
                                }
                            }
                            w2.add(p2Var);
                        }
                    } else {
                        int length3 = optJSONArray.length();
                        for (int i10 = 0; i10 < length3; i10++) {
                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i10);
                            x4.j jVar2 = new x4.j(0, (String) null, 7);
                            jVar2.f11227m = true;
                            optJSONObject5.getClass();
                            jVar2.b(optJSONObject5);
                            w2.add(jVar2);
                        }
                    }
                }
                if (!w2.isEmpty()) {
                    Object q02 = q6.l.q0(w2);
                    if (q02 instanceof x4.j) {
                        arrayList = w2;
                        w2 = null;
                    } else if (q02 instanceof p2) {
                        arrayList = null;
                    } else {
                        w2 = null;
                        arrayList = null;
                    }
                    r7.o0 o0Var = this.f10570m.i;
                    j5.r rVar = new j5.r(new h0(w2, arrayList));
                    o0Var.getClass();
                    o0Var.g(null, rVar);
                }
                break;
            default:
                ArrayList w9 = a4.x.w(obj);
                j5.v vVar2 = this.f10568b;
                long j = this.f10569l;
                g2 A = vVar2.A(j);
                if (!A.b() && (jSONObject2 = A.f11206d) != null && jSONObject2.optInt("success") == 1 && (optJSONObject = jSONObject2.optJSONObject("data")) != null && (optJSONArray3 = optJSONObject.optJSONArray("videos")) != null) {
                    int length4 = optJSONArray3.length();
                    for (int i11 = 0; i11 < length4; i11++) {
                        JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i11);
                        optJSONObject6.getClass();
                        d3 d3Var = new d3();
                        if (!optJSONObject6.isNull("youtubeID")) {
                            d3Var.f11119a = optJSONObject6.optString("youtubeID");
                        }
                        if (!optJSONObject6.isNull("image")) {
                            d3Var.f11120b = optJSONObject6.optString("image");
                        }
                        w9.add(d3Var);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                g2 r9 = vVar2.r(j);
                if (!r9.b() && (str = r9.f11203a) != null && str.length() != 0) {
                    String str2 = r9.f11203a;
                    str2.getClass();
                    JSONObject jSONObject3 = new JSONObject(str2);
                    if (jSONObject3.optInt("success") == 1 && (optJSONArray2 = jSONObject3.optJSONArray("data")) != null) {
                        int length5 = optJSONArray2.length();
                        for (int i12 = 0; i12 < length5; i12++) {
                            JSONObject optJSONObject7 = optJSONArray2.optJSONObject(i12);
                            optJSONObject7.getClass();
                            l2 l2Var = new l2();
                            if (!optJSONObject7.isNull("screenshotURL")) {
                                l2Var.f11277a = optJSONObject7.optString("screenshotURL");
                            }
                            if (!optJSONObject7.isNull("isVertical")) {
                                l2Var.f11280m = optJSONObject7.optInt("isVertical");
                            }
                            if (!optJSONObject7.isNull("featured")) {
                                l2Var.f11279l = optJSONObject7.optInt("featured");
                            }
                            if (l2Var.f11279l == 0) {
                                arrayList2.add(l2Var);
                            }
                            q6.q.j0(arrayList2, new c4.k1(new c4.j1(18), 11));
                        }
                    }
                }
                r7.o0 o0Var2 = this.f10570m.g;
                j5.r rVar2 = new j5.r(new g0(arrayList2, w9));
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
