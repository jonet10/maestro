package c4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class cb extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1479a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1480b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1481l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1482m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1483n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cb(boolean z9, Object obj, Object obj2, Object obj3, t6.c cVar, int i) {
        super(2, cVar);
        this.f1479a = i;
        this.f1480b = z9;
        this.f1481l = obj;
        this.f1482m = obj2;
        this.f1483n = obj3;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1479a) {
            case 0:
                return new cb(this.f1480b, (ArrayList) this.f1481l, (Context) this.f1482m, (kotlin.jvm.internal.u) this.f1483n, cVar, 0);
            default:
                return new cb(this.f1480b, (x4.g) this.f1481l, (j5.v) this.f1482m, (u4.v0) this.f1483n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1479a) {
            case 0:
                cb cbVar = (cb) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                cbVar.invokeSuspend(xVar);
                return xVar;
            default:
                cb cbVar2 = (cb) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                cbVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        switch (this.f1479a) {
            case 0:
                p6.a.e(obj);
                if (this.f1480b) {
                    Iterator it = ((ArrayList) this.f1481l).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.r a8 = ((x4.q2) next).a((Context) this.f1482m);
                        if (a8 == null || !a8.c()) {
                            ((kotlin.jvm.internal.u) this.f1483n).f7021a = false;
                        }
                    }
                }
                break;
            default:
                u4.v0 v0Var = (u4.v0) this.f1483n;
                j5.v vVar = (j5.v) this.f1482m;
                x4.g gVar = (x4.g) this.f1481l;
                p6.a.e(obj);
                int i = 0;
                if (this.f1480b) {
                    x4.c cVar = new x4.c();
                    cVar.f11074d = gVar;
                    x4.g2 k5 = vVar.k(k0.k.g(gVar.f11158a, "https://www.uptodown.app:443/eapi/app/", "/alternatives"), j5.v.g(), ShareTarget.METHOD_GET, false);
                    k5.f11206d = vVar.i(k5, "/eapi/app/appID/alternatives");
                    if (!k5.b() && (jSONObject2 = k5.f11206d) != null && jSONObject2.optInt("success") == 1 && (optJSONObject = jSONObject2.optJSONObject("data")) != null) {
                        if (!optJSONObject.isNull("title")) {
                            cVar.f11071a = optJSONObject.optString("title");
                        }
                        if (!optJSONObject.isNull("description")) {
                            cVar.f11072b = optJSONObject.optString("description");
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("apps");
                        if (optJSONArray != null) {
                            ArrayList arrayList = new ArrayList();
                            int length = optJSONArray.length();
                            while (i < length) {
                                x4.g gVar2 = new x4.g();
                                JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                                jSONObject3.getClass();
                                gVar2.a(null, jSONObject3);
                                arrayList.add(gVar2);
                                i++;
                            }
                            cVar.f11073c = arrayList;
                        }
                        ArrayList arrayList2 = cVar.f11073c;
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            r7.o0 o0Var = v0Var.f10625c;
                            o0Var.getClass();
                            o0Var.g(null, cVar);
                        }
                    }
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    long j = gVar.f11158a;
                    HashMap hashMap = new HashMap();
                    hashMap.put("page[limit]", String.valueOf(20));
                    hashMap.put("page[offset]", String.valueOf(0));
                    hashMap.putAll(j5.v.g());
                    x4.g2 k10 = vVar.k(k0.k.g(j, "https://www.uptodown.app:443/eapi/", "/similar"), hashMap, ShareTarget.METHOD_GET, false);
                    k10.f11206d = vVar.i(k10, "/eapi/appID/similar");
                    if (!k10.b() && (jSONObject = k10.f11206d) != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("data");
                        if (jSONObject.optInt("success", 0) == 1 && optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            while (i < length2) {
                                x4.g gVar3 = new x4.g();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                optJSONObject2.getClass();
                                gVar3.a(null, optJSONObject2);
                                arrayList3.add(gVar3);
                                i++;
                            }
                            if (!arrayList3.isEmpty()) {
                                r7.o0 o0Var2 = v0Var.f10623a;
                                o0Var2.getClass();
                                o0Var2.g(null, arrayList3);
                            }
                        }
                    }
                }
                break;
        }
        return p6.x.f8463a;
    }
}
