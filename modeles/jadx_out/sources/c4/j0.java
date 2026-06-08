package c4;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.fragment.app.Fragment;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.WishlistActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1745a;

    /* renamed from: b, reason: collision with root package name */
    public int f1746b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1747l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1748m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1749n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(v8 v8Var, Context context, long j, int i, t6.c cVar) {
        super(2, cVar);
        this.f1745a = 5;
        this.f1748m = v8Var;
        this.f1749n = context;
        this.f1747l = j;
        this.f1746b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1745a) {
            case 0:
                return new j0((k0) this.f1748m, this.f1747l, (String) this.f1749n, cVar, 0);
            case 1:
                return new j0((PublicListActivity) this.f1748m, this.f1747l, (x4.j) this.f1749n, cVar, 1);
            case 2:
                return new j0((RecommendedActivity) this.f1748m, this.f1747l, (String) this.f1749n, cVar, 2);
            case 3:
                return new j0((RecommendedActivity) this.f1748m, this.f1747l, (x4.j) this.f1749n, cVar, 3);
            case 4:
                return new j0((v8) this.f1748m, (RepliesActivity) this.f1749n, this.f1747l, cVar);
            case 5:
                return new j0((v8) this.f1748m, (Context) this.f1749n, this.f1747l, this.f1746b, cVar);
            case 6:
                return new j0((WishlistActivity) this.f1748m, this.f1747l, (String) this.f1749n, cVar, 6);
            case 7:
                return new j0((WishlistActivity) this.f1748m, this.f1747l, (x4.j) this.f1749n, cVar, 7);
            case 8:
                return new j0((k0) this.f1748m, this.f1747l, (n5.d) this.f1749n, cVar, 8);
            case 9:
                return new j0((u4.z0) this.f1748m, this.f1747l, (String) this.f1749n, this.f1746b, cVar, 9);
            default:
                return new j0((u4.m1) this.f1748m, this.f1747l, (String) this.f1749n, this.f1746b, cVar, 10);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1745a) {
            case 0:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 1:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 2:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 3:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 4:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 5:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 6:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 7:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 8:
                return ((j0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 9:
                j0 j0Var = (j0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                j0Var.invokeSuspend(xVar);
                return xVar;
            default:
                j0 j0Var2 = (j0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                j0Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object a8;
        Object a10;
        Object a11;
        Object a12;
        Object C;
        JSONObject jSONObject;
        Object a13;
        Object a14;
        Object a15;
        int i = this.f1745a;
        long j = this.f1747l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar = p6.x.f8463a;
        Object obj2 = this.f1749n;
        Object obj3 = this.f1748m;
        switch (i) {
            case 0:
                k0 k0Var = (k0) obj3;
                int i6 = this.f1746b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(k0Var, j);
                    this.f1746b = 1;
                    a8 = s0Var.a(this);
                    if (a8 == aVar) {
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a8 = ((p6.k) obj).f8444a;
                }
                if (!(a8 instanceof p6.j)) {
                    x4.g gVar = (x4.g) a8;
                    if (!k0Var.isFinishing()) {
                        Intent intent = new Intent(k0Var, (Class<?>) AppDetailActivity.class);
                        intent.putExtra("appInfo", gVar);
                        float f = UptodownApp.I;
                        k0Var.startActivity(intent, b4.d.a(k0Var));
                    }
                }
                String str = (String) obj2;
                Throwable a16 = p6.k.a(a8);
                if (a16 != null) {
                    int i10 = s4.y0.f9323l;
                    if (d0.b.J(a16)) {
                        k0Var.J();
                    } else if (str == null || str.length() == 0) {
                        String string = k0Var.getString(2131951694);
                        string.getClass();
                        k0Var.A(string);
                    } else {
                        j5.c.e(k0Var, str, null);
                    }
                }
                break;
            case 1:
                PublicListActivity publicListActivity = (PublicListActivity) obj3;
                int i11 = this.f1746b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var2 = new e1.s0(publicListActivity, j);
                    this.f1746b = 1;
                    a10 = s0Var2.a(this);
                    if (a10 == aVar) {
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a10 = ((p6.k) obj).f8444a;
                }
                x4.j jVar = (x4.j) obj2;
                if (!(a10 instanceof p6.j)) {
                    x4.g gVar2 = (x4.g) a10;
                    if (!publicListActivity.isFinishing()) {
                        Intent intent2 = new Intent(publicListActivity, (Class<?>) AppDetailActivity.class);
                        intent2.putExtra("appInfo", gVar2);
                        intent2.putExtra("viewCategory", jVar);
                        float f10 = UptodownApp.I;
                        publicListActivity.startActivity(intent2, b4.d.a(publicListActivity));
                    }
                }
                Throwable a17 = p6.k.a(a10);
                if (a17 != null) {
                    int i12 = s4.y0.f9323l;
                    if (d0.b.J(a17)) {
                        publicListActivity.J();
                    } else {
                        String string2 = publicListActivity.getString(2131951694);
                        string2.getClass();
                        publicListActivity.A(string2);
                    }
                }
                break;
            case 2:
                RecommendedActivity recommendedActivity = (RecommendedActivity) obj3;
                int i13 = this.f1746b;
                if (i13 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var3 = new e1.s0(recommendedActivity, j);
                    this.f1746b = 1;
                    a11 = s0Var3.a(this);
                    if (a11 == aVar) {
                    }
                } else if (i13 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a11 = ((p6.k) obj).f8444a;
                }
                if (!(a11 instanceof p6.j)) {
                    x4.g gVar3 = (x4.g) a11;
                    if (!recommendedActivity.isFinishing()) {
                        Intent intent3 = new Intent(recommendedActivity, (Class<?>) AppDetailActivity.class);
                        intent3.putExtra("appInfo", gVar3);
                        ActivityResultLauncher activityResultLauncher = recommendedActivity.f3343f0;
                        float f11 = UptodownApp.I;
                        activityResultLauncher.launch(intent3, b4.d.b(recommendedActivity));
                    }
                }
                String str2 = (String) obj2;
                Throwable a18 = p6.k.a(a11);
                if (a18 != null) {
                    int i14 = s4.y0.f9323l;
                    if (d0.b.J(a18)) {
                        recommendedActivity.J();
                    } else if (str2 == null || str2.length() == 0) {
                        String message = a18.getMessage();
                        if (message != null && message.length() != 0) {
                            String message2 = a18.getMessage();
                            message2.getClass();
                            recommendedActivity.A(message2);
                        }
                    } else {
                        j5.c.e(recommendedActivity, str2, null);
                    }
                }
                break;
            case 3:
                RecommendedActivity recommendedActivity2 = (RecommendedActivity) obj3;
                int i15 = this.f1746b;
                if (i15 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var4 = new e1.s0(recommendedActivity2, j);
                    this.f1746b = 1;
                    a12 = s0Var4.a(this);
                    if (a12 == aVar) {
                    }
                } else if (i15 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a12 = ((p6.k) obj).f8444a;
                }
                x4.j jVar2 = (x4.j) obj2;
                if (!(a12 instanceof p6.j)) {
                    x4.g gVar4 = (x4.g) a12;
                    if (!recommendedActivity2.isFinishing()) {
                        Intent intent4 = new Intent(recommendedActivity2, (Class<?>) AppDetailActivity.class);
                        intent4.putExtra("appInfo", gVar4);
                        intent4.putExtra("viewCategory", jVar2);
                        ActivityResultLauncher activityResultLauncher2 = recommendedActivity2.f3343f0;
                        float f12 = UptodownApp.I;
                        activityResultLauncher2.launch(intent4, b4.d.b(recommendedActivity2));
                    }
                }
                Throwable a19 = p6.k.a(a12);
                if (a19 != null) {
                    int i16 = s4.y0.f9323l;
                    if (d0.b.J(a19)) {
                        recommendedActivity2.J();
                    } else {
                        String message3 = a19.getMessage();
                        if (message3 != null && message3.length() != 0) {
                            String message4 = a19.getMessage();
                            message4.getClass();
                            recommendedActivity2.N(message4);
                        }
                    }
                }
                break;
            case 4:
                v8 v8Var = (v8) obj3;
                int i17 = this.f1746b;
                if (i17 == 0) {
                    p6.a.e(obj);
                    v8Var.f2226s = false;
                    this.f1746b = 1;
                    v7.e eVar = o7.m0.f8288a;
                    C = o7.c0.C(new j0(v8Var, (RepliesActivity) obj2, this.f1747l, 0, (t6.c) null), v7.d.f10884a, this);
                    if (C == aVar) {
                    }
                } else if (i17 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    C = obj;
                }
                r7.o0 o0Var = v8Var.f2213a;
                j5.r rVar = new j5.r(new r8((ArrayList) C, false));
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            case 5:
                p6.a.e(obj);
                v8 v8Var2 = (v8) obj3;
                v8Var2.f2225r = true;
                r7.o0 o0Var2 = v8Var2.f2213a;
                o0Var2.getClass();
                o0Var2.g(null, j5.p.f6705a);
                ArrayList arrayList = new ArrayList();
                j5.v vVar = new j5.v((Context) obj2);
                int i18 = this.f1746b;
                HashMap hashMap = new HashMap();
                hashMap.put("page[limit]", String.valueOf(10));
                hashMap.put("page[offset]", String.valueOf(i18));
                x4.g2 k5 = vVar.k(k0.k.g(j, "https://www.uptodown.app:443/eapi/comments/", "/answers"), hashMap, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/comments/idReview/answers");
                if (k5.b() || (jSONObject = k5.f11206d) == null) {
                    v8Var2.f2226s = true;
                } else {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            int length = optJSONArray.length();
                            for (int i19 = 0; i19 < length; i19++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i19);
                                optJSONObject.getClass();
                                arrayList2.add(q1.a.g(optJSONObject));
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        arrayList.addAll(arrayList2);
                        if (optJSONArray.length() == 0) {
                            v8Var2.f2226s = true;
                        }
                    }
                }
                v8Var2.f2225r = false;
                break;
            case 6:
                WishlistActivity wishlistActivity = (WishlistActivity) obj3;
                int i20 = this.f1746b;
                if (i20 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var5 = new e1.s0(wishlistActivity, j);
                    this.f1746b = 1;
                    a13 = s0Var5.a(this);
                    if (a13 == aVar) {
                    }
                } else if (i20 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a13 = ((p6.k) obj).f8444a;
                }
                if (!(a13 instanceof p6.j)) {
                    x4.g gVar5 = (x4.g) a13;
                    if (!wishlistActivity.isFinishing()) {
                        Intent intent5 = new Intent(wishlistActivity, (Class<?>) AppDetailActivity.class);
                        intent5.putExtra("appInfo", gVar5);
                        ActivityResultLauncher activityResultLauncher3 = wishlistActivity.f3371e0;
                        float f13 = UptodownApp.I;
                        activityResultLauncher3.launch(intent5, b4.d.b(wishlistActivity));
                    }
                }
                String str3 = (String) obj2;
                Throwable a20 = p6.k.a(a13);
                if (a20 != null) {
                    int i21 = s4.y0.f9323l;
                    if (d0.b.J(a20)) {
                        wishlistActivity.J();
                    } else if (str3 == null || str3.length() == 0) {
                        String message5 = a20.getMessage();
                        if (message5 != null && message5.length() != 0) {
                            String message6 = a20.getMessage();
                            message6.getClass();
                            wishlistActivity.A(message6);
                        }
                    } else {
                        j5.c.e(wishlistActivity, str3, null);
                    }
                }
                break;
            case 7:
                WishlistActivity wishlistActivity2 = (WishlistActivity) obj3;
                int i22 = this.f1746b;
                if (i22 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var6 = new e1.s0(wishlistActivity2, j);
                    this.f1746b = 1;
                    a14 = s0Var6.a(this);
                    if (a14 == aVar) {
                    }
                } else if (i22 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a14 = ((p6.k) obj).f8444a;
                }
                x4.j jVar3 = (x4.j) obj2;
                if (!(a14 instanceof p6.j)) {
                    x4.g gVar6 = (x4.g) a14;
                    if (!wishlistActivity2.isFinishing()) {
                        Intent intent6 = new Intent(wishlistActivity2, (Class<?>) AppDetailActivity.class);
                        intent6.putExtra("appInfo", gVar6);
                        intent6.putExtra("viewCategory", jVar3);
                        ActivityResultLauncher activityResultLauncher4 = wishlistActivity2.f3371e0;
                        float f14 = UptodownApp.I;
                        activityResultLauncher4.launch(intent6, b4.d.b(wishlistActivity2));
                    }
                }
                Throwable a21 = p6.k.a(a14);
                if (a21 != null) {
                    int i23 = s4.y0.f9323l;
                    if (d0.b.J(a21)) {
                        wishlistActivity2.J();
                    } else {
                        String message7 = a21.getMessage();
                        if (message7 != null && message7.length() != 0) {
                            String message8 = a21.getMessage();
                            message8.getClass();
                            wishlistActivity2.N(message8);
                        }
                    }
                }
                break;
            case 8:
                k0 k0Var2 = (k0) obj3;
                int i24 = this.f1746b;
                if (i24 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var7 = new e1.s0(k0Var2, j);
                    this.f1746b = 1;
                    a15 = s0Var7.a(this);
                    if (a15 == aVar) {
                    }
                } else if (i24 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a15 = ((p6.k) obj).f8444a;
                }
                n5.d dVar = (n5.d) obj2;
                if (!(a15 instanceof p6.j)) {
                    x4.g gVar7 = (x4.g) a15;
                    gVar7.getClass();
                    dVar.f8069a = gVar7;
                    if (dVar.f8070b.getVisibility() == 0) {
                        dVar.d(k0Var2);
                        if (dVar.f8069a.B0 == 1) {
                            dVar.h(k0Var2);
                        } else {
                            n5.d.a(k0Var2, dVar);
                        }
                    }
                }
                break;
            case 9:
                p6.a.e(obj);
                Context requireContext = ((u4.z0) obj3).requireContext();
                requireContext.getClass();
                new j5.v(requireContext).C(this.f1747l, (String) obj2, "parentCategoryFeature", this.f1746b);
                break;
            default:
                p6.a.e(obj);
                Context requireContext2 = ((u4.m1) obj3).requireContext();
                requireContext2.getClass();
                new j5.v(requireContext2).C(this.f1747l, (String) obj2, "homeFeature", this.f1746b);
                break;
        }
        return xVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(k0 k0Var, long j, Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f1745a = i;
        this.f1748m = k0Var;
        this.f1747l = j;
        this.f1749n = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(Fragment fragment, long j, String str, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f1745a = i6;
        this.f1748m = fragment;
        this.f1747l = j;
        this.f1749n = str;
        this.f1746b = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(v8 v8Var, RepliesActivity repliesActivity, long j, t6.c cVar) {
        super(2, cVar);
        this.f1745a = 4;
        this.f1748m = v8Var;
        this.f1749n = repliesActivity;
        this.f1747l = j;
    }
}
