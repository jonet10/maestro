package b6;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.browser.trusted.sharing.ShareTarget;
import c4.ac;
import c4.bc;
import c4.d9;
import c4.g9;
import c4.k0;
import c4.n6;
import c4.s5;
import c4.t0;
import c4.w4;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import d7.p;
import e4.e1;
import j5.r;
import j5.s;
import j5.v;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.l;
import o7.a0;
import org.json.JSONArray;
import org.json.JSONObject;
import p6.x;
import r7.o0;
import x4.a3;
import x4.g2;
import x4.k;
import x4.q2;
import x4.w2;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1064a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1065b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1066l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f1064a = i;
        this.f1065b = obj;
        this.f1066l = obj2;
    }

    private final Object a(Object obj) {
        Object obj2;
        String str = (String) this.f1066l;
        p6.a.e(obj);
        PublicListActivity publicListActivity = (PublicListActivity) this.f1065b;
        e1 e1Var = publicListActivity.f3336c0;
        if (e1Var == null || e1Var.f4519a.isEmpty() || str == null || str.length() == 0) {
            e1 e1Var2 = publicListActivity.f3336c0;
            if (e1Var2 != null) {
                e1Var2.notifyDataSetChanged();
            }
        } else {
            e1 e1Var3 = publicListActivity.f3336c0;
            e1Var3.getClass();
            ArrayList arrayList = e1Var3.f4519a;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    obj2 = null;
                    break;
                }
                obj2 = arrayList.get(i);
                i++;
                if (l.a(((a3) obj2).f11049d, str)) {
                    break;
                }
            }
            e1 e1Var4 = publicListActivity.f3336c0;
            e1Var4.getClass();
            int u02 = q6.l.u0(e1Var4.f4519a, (a3) obj2);
            e1 e1Var5 = publicListActivity.f3336c0;
            if (u02 > -1) {
                e1Var5.getClass();
                e1Var5.notifyItemChanged(u02);
            } else if (e1Var5 != null) {
                e1Var5.notifyDataSetChanged();
            }
        }
        return x.f8463a;
    }

    private final Object b(Object obj) {
        Object obj2;
        String str = (String) this.f1066l;
        p6.a.e(obj);
        RecommendedActivity recommendedActivity = (RecommendedActivity) this.f1065b;
        e1 e1Var = recommendedActivity.f3340c0;
        if (e1Var == null || e1Var.f4519a.isEmpty() || str == null || str.length() == 0) {
            e1 e1Var2 = recommendedActivity.f3340c0;
            if (e1Var2 != null) {
                e1Var2.notifyDataSetChanged();
            }
        } else {
            e1 e1Var3 = recommendedActivity.f3340c0;
            e1Var3.getClass();
            ArrayList arrayList = e1Var3.f4519a;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    obj2 = null;
                    break;
                }
                obj2 = arrayList.get(i);
                i++;
                if (l.a(((a3) obj2).f11049d, str)) {
                    break;
                }
            }
            e1 e1Var4 = recommendedActivity.f3340c0;
            e1Var4.getClass();
            int u02 = q6.l.u0(e1Var4.f4519a, (a3) obj2);
            e1 e1Var5 = recommendedActivity.f3340c0;
            if (u02 > -1) {
                e1Var5.getClass();
                e1Var5.notifyItemChanged(u02);
            } else if (e1Var5 != null) {
                e1Var5.notifyDataSetChanged();
            }
        }
        return x.f8463a;
    }

    private final Object c(Object obj) {
        JSONObject jSONObject;
        p6.a.e(obj);
        g9 g9Var = (g9) this.f1065b;
        o0 o0Var = g9Var.f1635a;
        o0Var.getClass();
        o0Var.g(null, j5.p.f6705a);
        ArrayList arrayList = new ArrayList();
        v vVar = new v((ReviewsActivity) this.f1066l);
        Object value = g9Var.i.getValue();
        value.getClass();
        long j = ((x4.g) value).f11158a;
        int i = g9Var.f1644o;
        String str = (String) g9Var.f1640k.getValue();
        str.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(20));
        hashMap.put("page[offset]", String.valueOf(i));
        hashMap.put("order", str);
        g2 k5 = vVar.k(a4.x.l(new StringBuilder("https://www.uptodown.app:443/eapi/apps/"), j, "/comments"), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = vVar.i(k5, "/eapi/apps/appId/comments");
        if (k5.b() || (jSONObject = k5.f11206d) == null) {
            g9Var.f1642m = false;
        } else {
            int optInt = jSONObject.optInt("success");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optInt == 1 && optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                    jSONObject2.getClass();
                    arrayList.add(q1.a.h(jSONObject2));
                }
            }
        }
        r rVar = new r(new d9(arrayList));
        o0Var.getClass();
        o0Var.g(null, rVar);
        g9Var.f1644o = arrayList.size() + g9Var.f1644o;
        return x.f8463a;
    }

    private final Object d(Object obj) {
        p6.a.e(obj);
        ArrayList arrayList = (ArrayList) this.f1065b;
        ArrayList arrayList2 = (ArrayList) this.f1066l;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList2.get(i);
            i++;
            x4.e eVar = (x4.e) obj2;
            String str = eVar.f11123l;
            if (str != null && eVar.v == 0) {
                int size2 = arrayList.size();
                int i6 = 0;
                while (true) {
                    if (i6 < size2) {
                        Object obj3 = arrayList.get(i6);
                        i6++;
                        q2 q2Var = (q2) obj3;
                        if (str.equalsIgnoreCase(q2Var.f11344b)) {
                            arrayList3.add(q2Var);
                            break;
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(!arrayList3.isEmpty());
    }

    private final Object e(Object obj) {
        JSONObject jSONObject;
        p6.a.e(obj);
        bc bcVar = (bc) this.f1065b;
        bcVar.h = true;
        ArrayList arrayList = new ArrayList();
        v vVar = new v((Context) this.f1066l);
        o0 o0Var = bcVar.f1437e;
        String str = ((w2) o0Var.getValue()).f11431a;
        str.getClass();
        g2 y9 = vVar.y(20, bcVar.i, str);
        if (!y9.b() && (jSONObject = y9.f11206d) != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("user");
                if (optJSONObject2 != null) {
                    ((w2) o0Var.getValue()).c(optJSONObject2);
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("comments");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    o0 o0Var2 = bcVar.f;
                    Boolean bool = Boolean.TRUE;
                    o0Var2.getClass();
                    o0Var2.g(null, bool);
                } else {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        jSONObject2.getClass();
                        arrayList.add(q1.a.r(jSONObject2));
                    }
                }
            }
        } else if (y9.f11204b == 404) {
            bcVar.g = false;
        }
        bcVar.i = arrayList.size() + bcVar.i;
        o0 o0Var3 = bcVar.f1433a;
        r rVar = new r(new ac((w2) o0Var.getValue(), arrayList, bcVar.g));
        o0Var3.getClass();
        o0Var3.g(null, rVar);
        bcVar.h = false;
        return x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1064a) {
            case 0:
                return new a((Bitmap) this.f1065b, (f) this.f1066l, cVar, 0);
            case 1:
                return new a((AppDetailActivity) this.f1065b, (String) this.f1066l, cVar, 1);
            case 2:
                return new a((AppFilesActivity) this.f1065b, (ArrayList) this.f1066l, cVar, 2);
            case 3:
                return new a((Throwable) this.f1065b, (AppInstalledDetailsActivity) this.f1066l, cVar, 3);
            case 4:
                return new a((k0) this.f1065b, (x4.r) this.f1066l, cVar, 4);
            case 5:
                return new a((t0) this.f1065b, (Context) this.f1066l, cVar, 5);
            case 6:
                return new a((FreeUpSpaceActivity) this.f1065b, (s) this.f1066l, cVar, 6);
            case 7:
                return new a((MainActivity) this.f1065b, (s4.c) this.f1066l, cVar, 7);
            case 8:
                return new a((MainActivity) this.f1065b, (x4.g) this.f1066l, cVar, 8);
            case 9:
                return new a((k) this.f1065b, (MainActivity) this.f1066l, cVar, 9);
            case 10:
                return new a((MainActivity) this.f1065b, (ArrayList) this.f1066l, cVar, 10);
            case 11:
                return new a((MainActivity) this.f1065b, (String) this.f1066l, cVar, 11);
            case 12:
                return new a((MyApps) this.f1065b, (s) this.f1066l, cVar, 12);
            case 13:
                return new a((MyApps) this.f1065b, (ArrayList) this.f1066l, cVar, 13);
            case 14:
                return new a((w4) this.f1065b, (d7.a) this.f1066l, cVar, 14);
            case 15:
                return new a((x4.r) this.f1065b, (Context) this.f1066l, cVar, 15);
            case 16:
                return new a((s5) this.f1065b, (MyStatsActivity) this.f1066l, cVar, 16);
            case 17:
                return new a((OldVersionsActivity) this.f1065b, (String) this.f1066l, cVar, 17);
            case 18:
                return new a((x4.r) this.f1065b, (OrganizationActivity) this.f1066l, cVar, 18);
            case 19:
                return new a((n6) this.f1065b, (OrganizationActivity) this.f1066l, cVar, 19);
            case 20:
                return new a((n6) this.f1065b, (Context) this.f1066l, cVar, 20);
            case 21:
                return new a((PreregistrationActivity) this.f1065b, (x1) this.f1066l, cVar, 21);
            case 22:
                return new a((Context) this.f1065b, (ArrayList) this.f1066l, cVar, 22);
            case 23:
                return new a((PublicListActivity) this.f1065b, (String) this.f1066l, cVar, 23);
            case 24:
                return new a((RecommendedActivity) this.f1065b, (String) this.f1066l, cVar, 24);
            case 25:
                return new a((g9) this.f1065b, (ReviewsActivity) this.f1066l, cVar, 25);
            case 26:
                return new a((ArrayList) this.f1065b, (ArrayList) this.f1066l, cVar, 26);
            case 27:
                return new a((bc) this.f1065b, (Context) this.f1066l, cVar, 27);
            case 28:
                return new a((UserDeviceDetailsActivity) this.f1065b, (x4.g) this.f1066l, cVar, 28);
            default:
                return new a((Throwable) this.f1065b, (UserDeviceDetailsActivity) this.f1066l, cVar, 29);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1064a) {
            case 0:
                a aVar = new a((Bitmap) this.f1065b, (f) this.f1066l, cVar, 0);
                x xVar = x.f8463a;
                aVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                a aVar2 = (a) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                aVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                a aVar3 = (a) create(a0Var, cVar);
                x xVar3 = x.f8463a;
                aVar3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                a aVar4 = (a) create(a0Var, cVar);
                x xVar4 = x.f8463a;
                aVar4.invokeSuspend(xVar4);
                return xVar4;
            case 4:
                a aVar5 = (a) create(a0Var, cVar);
                x xVar5 = x.f8463a;
                aVar5.invokeSuspend(xVar5);
                return xVar5;
            case 5:
                a aVar6 = (a) create(a0Var, cVar);
                x xVar6 = x.f8463a;
                aVar6.invokeSuspend(xVar6);
                return xVar6;
            case 6:
                a aVar7 = (a) create(a0Var, cVar);
                x xVar7 = x.f8463a;
                aVar7.invokeSuspend(xVar7);
                return xVar7;
            case 7:
                a aVar8 = (a) create(a0Var, cVar);
                x xVar8 = x.f8463a;
                aVar8.invokeSuspend(xVar8);
                return xVar8;
            case 8:
                a aVar9 = (a) create(a0Var, cVar);
                x xVar9 = x.f8463a;
                aVar9.invokeSuspend(xVar9);
                return xVar9;
            case 9:
                a aVar10 = (a) create(a0Var, cVar);
                x xVar10 = x.f8463a;
                aVar10.invokeSuspend(xVar10);
                return xVar10;
            case 10:
                a aVar11 = (a) create(a0Var, cVar);
                x xVar11 = x.f8463a;
                aVar11.invokeSuspend(xVar11);
                return xVar11;
            case 11:
                a aVar12 = (a) create(a0Var, cVar);
                x xVar12 = x.f8463a;
                aVar12.invokeSuspend(xVar12);
                return xVar12;
            case 12:
                a aVar13 = (a) create(a0Var, cVar);
                x xVar13 = x.f8463a;
                aVar13.invokeSuspend(xVar13);
                return xVar13;
            case 13:
                a aVar14 = (a) create(a0Var, cVar);
                x xVar14 = x.f8463a;
                aVar14.invokeSuspend(xVar14);
                return xVar14;
            case 14:
                a aVar15 = (a) create(a0Var, cVar);
                x xVar15 = x.f8463a;
                aVar15.invokeSuspend(xVar15);
                return xVar15;
            case 15:
                return ((a) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 16:
                a aVar16 = (a) create(a0Var, cVar);
                x xVar16 = x.f8463a;
                aVar16.invokeSuspend(xVar16);
                return xVar16;
            case 17:
                a aVar17 = (a) create(a0Var, cVar);
                x xVar17 = x.f8463a;
                aVar17.invokeSuspend(xVar17);
                return xVar17;
            case 18:
                a aVar18 = (a) create(a0Var, cVar);
                x xVar18 = x.f8463a;
                aVar18.invokeSuspend(xVar18);
                return xVar18;
            case 19:
                a aVar19 = (a) create(a0Var, cVar);
                x xVar19 = x.f8463a;
                aVar19.invokeSuspend(xVar19);
                return xVar19;
            case 20:
                a aVar20 = (a) create(a0Var, cVar);
                x xVar20 = x.f8463a;
                aVar20.invokeSuspend(xVar20);
                return xVar20;
            case 21:
                a aVar21 = (a) create(a0Var, cVar);
                x xVar21 = x.f8463a;
                aVar21.invokeSuspend(xVar21);
                return xVar21;
            case 22:
                a aVar22 = (a) create(a0Var, cVar);
                x xVar22 = x.f8463a;
                aVar22.invokeSuspend(xVar22);
                return xVar22;
            case 23:
                a aVar23 = (a) create(a0Var, cVar);
                x xVar23 = x.f8463a;
                aVar23.invokeSuspend(xVar23);
                return xVar23;
            case 24:
                a aVar24 = (a) create(a0Var, cVar);
                x xVar24 = x.f8463a;
                aVar24.invokeSuspend(xVar24);
                return xVar24;
            case 25:
                a aVar25 = (a) create(a0Var, cVar);
                x xVar25 = x.f8463a;
                aVar25.invokeSuspend(xVar25);
                return xVar25;
            case 26:
                return ((a) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 27:
                a aVar26 = (a) create(a0Var, cVar);
                x xVar26 = x.f8463a;
                aVar26.invokeSuspend(xVar26);
                return xVar26;
            case 28:
                a aVar27 = (a) create(a0Var, cVar);
                x xVar27 = x.f8463a;
                aVar27.invokeSuspend(xVar27);
                return xVar27;
            default:
                a aVar28 = (a) create(a0Var, cVar);
                x xVar28 = x.f8463a;
                aVar28.invokeSuspend(xVar28);
                return xVar28;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x04c4, code lost:
    
        if (l7.u.m0(((x4.e) r0).f11123l, r2, true) == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04fc, code lost:
    
        r13.z0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x04fa, code lost:
    
        if (l7.u.m0(((x4.g) r0).F, r2, true) != false) goto L201;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 3062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
