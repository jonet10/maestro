package u4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.g2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10525a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10526b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m1 f10527l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(ArrayList arrayList, m1 m1Var, t6.c cVar) {
        super(2, cVar);
        this.f10526b = arrayList;
        this.f10527l = m1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10525a) {
            case 0:
                return new l1(this.f10527l, this.f10526b, cVar);
            default:
                return new l1(this.f10526b, this.f10527l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10525a) {
            case 0:
                l1 l1Var = (l1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                l1Var.invokeSuspend(xVar);
                return xVar;
            default:
                l1 l1Var2 = (l1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                l1Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        switch (this.f10525a) {
            case 0:
                p6.a.e(obj);
                m1 m1Var = this.f10527l;
                Context requireContext = m1Var.requireContext();
                requireContext.getClass();
                j5.v vVar = new j5.v(requireContext);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = m1Var.f10542o;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.j jVar = ((p2) next).f11329a;
                        if (jVar.f11227m) {
                            arrayList.add(new Integer(jVar.f11224a));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    m1Var.f10546s = false;
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("page[limit]", String.valueOf(20));
                    hashMap.put("page[offset]", String.valueOf(0));
                    hashMap.put("categoryIDs", arrayList.toString());
                    hashMap.putAll(j5.v.g());
                    g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/floating-category/additional/apps"), hashMap, ShareTarget.METHOD_POST, false);
                    k5.f11206d = vVar.i(k5, "/eapi/floating-category/additional/apps");
                    if (k5.b() || (jSONObject = k5.f11206d) == null) {
                        m1Var.f10546s = false;
                    } else {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("floatingCategory");
                                if (optJSONObject2 != null) {
                                    x4.j jVar2 = new x4.j(0, (String) null, 7);
                                    jVar2.b(optJSONObject2);
                                    ArrayList arrayList3 = new ArrayList();
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("apps");
                                    if (optJSONArray2 != null) {
                                        int length2 = optJSONArray2.length();
                                        for (int i6 = 0; i6 < length2; i6++) {
                                            x4.g gVar = new x4.g();
                                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                                            optJSONObject3.getClass();
                                            gVar.a(null, optJSONObject3);
                                            arrayList3.add(gVar);
                                        }
                                    }
                                    p2 p2Var = new p2(jVar2, arrayList3, 4);
                                    p2Var.f11331c = 5;
                                    ArrayList arrayList4 = m1Var.f10542o;
                                    if (arrayList4 != null) {
                                        arrayList4.add(p2Var);
                                    }
                                    this.f10526b.add(p2Var);
                                }
                            }
                        }
                    }
                }
                m1Var.f10545r = false;
                break;
            default:
                p6.a.e(obj);
                ArrayList arrayList5 = this.f10526b;
                int size = arrayList5.size();
                m1 m1Var2 = this.f10527l;
                if (size < 4) {
                    m1Var2.f10546s = false;
                }
                Iterator it2 = arrayList5.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    p2 p2Var2 = (p2) next2;
                    e4.h hVar = m1Var2.f10538b;
                    if (hVar != null) {
                        hVar.b(p2Var2);
                    }
                }
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(m1 m1Var, ArrayList arrayList, t6.c cVar) {
        super(2, cVar);
        this.f10527l = m1Var;
        this.f10526b = arrayList;
    }
}
