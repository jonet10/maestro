package c4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1621a;

    /* renamed from: b, reason: collision with root package name */
    public int f1622b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1623l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g3(MainActivity mainActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1621a = i;
        this.f1623l = mainActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1621a) {
            case 0:
                return new g3(this.f1623l, cVar, 0);
            case 1:
                return new g3(this.f1623l, cVar, 1);
            case 2:
                return new g3(this.f1623l, cVar, 2);
            case 3:
                return new g3(this.f1623l, cVar, 3);
            case 4:
                return new g3(this.f1623l, cVar, 4);
            case 5:
                return new g3(this.f1623l, cVar, 5);
            case 6:
                return new g3(this.f1623l, cVar, 6);
            default:
                return new g3(this.f1623l, cVar, 7);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1621a) {
        }
        return ((g3) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        File file;
        String str;
        File file2;
        long j;
        String str2;
        int i = this.f1621a;
        MainActivity mainActivity = this.f1623l;
        int i6 = 2;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar = p6.x.f8463a;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        switch (i) {
            case 0:
                int i10 = this.f1622b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                    MainActivity mainActivity2 = this.f1623l;
                    ArrayList E = a.a.E(mainActivity2);
                    int size = E.size();
                    t6.c cVar = null;
                    if (size != 0) {
                        if (size != 1) {
                            if (E.size() > 1) {
                                q6.q.j0(E, new g4.z(8));
                            }
                            file2 = (File) E.get(0);
                        } else {
                            file2 = (File) E.get(0);
                        }
                        file = file2;
                    } else {
                        file = null;
                    }
                    if (file != null) {
                        j5.g l10 = j5.g.D.l(mainActivity2);
                        l10.b();
                        ArrayList F = l10.F();
                        l10.c();
                        Iterator it = F.iterator();
                        it.getClass();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                x4.k kVar = (x4.k) next;
                                String str3 = kVar.f11247a;
                                if (str3 != null && str3.length() != 0 && l7.u.m0(kVar.f11247a, file.getAbsolutePath(), true) && (str = kVar.f11248b) != null && str.length() != 0) {
                                    String str4 = kVar.f11248b;
                                    str4.getClass();
                                    if (Long.parseLong(str4) == file.lastModified()) {
                                    }
                                }
                            } else {
                                String name = file.getName();
                                name.getClass();
                                xVar2.f7024a = a.a.C(name);
                            }
                        }
                    }
                    v7.e eVar = o7.m0.f8288a;
                    p7.c cVar2 = t7.n.f10348a;
                    b5.l lVar = new b5.l(xVar2, mainActivity2, file, cVar, 5);
                    this.f1622b = 1;
                    if (o7.c0.C(lVar, cVar2, this) == aVar) {
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 1:
                int i11 = this.f1622b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    MainActivity mainActivity3 = this.f1623l;
                    SharedPreferences sharedPreferences = mainActivity3.getSharedPreferences("SettingsPreferences", 0);
                    try {
                        j = sharedPreferences.getLong("getLastTimePendingDialogShown", 0L);
                    } catch (ClassCastException unused) {
                        try {
                            long j6 = sharedPreferences.getInt("getLastTimePendingDialogShown", -1);
                            SharedPreferences sharedPreferences2 = mainActivity3.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences2.getClass();
                            SharedPreferences.Editor edit = sharedPreferences2.edit();
                            edit.putLong("getLastTimePendingDialogShown", j6);
                            edit.apply();
                            j = j6;
                        } catch (ClassCastException unused2) {
                            j = 0;
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i12 = MainActivity.G0;
                    j5.g l11 = j5.g.D.l(mainActivity3);
                    l11.b();
                    ArrayList P = l11.P();
                    l11.c();
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = P.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        x4.r rVar = (x4.r) next2;
                        if (rVar.p() && rVar.f11356l == 0 && rVar.c()) {
                            arrayList.add(rVar);
                        }
                    }
                    if ((arrayList.isEmpty() ? j : 0L) + 86400000 < currentTimeMillis) {
                        ArrayList arrayList2 = new ArrayList();
                        if (com.google.android.gms.internal.measurement.z3.f2928c) {
                            arrayList2.addAll(b2.t1.z(mainActivity3));
                        }
                        if (!arrayList2.isEmpty() || !arrayList.isEmpty()) {
                            v7.e eVar2 = o7.m0.f8288a;
                            p7.c cVar3 = t7.n.f10348a;
                            b5.l lVar2 = new b5.l((k0) mainActivity3, arrayList2, (Object) arrayList, (t6.c) null, 6);
                            this.f1622b = 1;
                            if (o7.c0.C(lVar2, cVar3, this) == aVar) {
                            }
                        }
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 2:
                int i13 = this.f1622b;
                if (i13 == 0) {
                    p6.a.e(obj);
                    MainActivity mainActivity4 = this.f1623l;
                    j5.v vVar = new j5.v(mainActivity4);
                    t6.c cVar4 = null;
                    x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/deep-link-hash"), null, ShareTarget.METHOD_GET, false);
                    k5.f11206d = vVar.i(k5, "/eapi/deep-link-hash");
                    if (!k5.b() && (str2 = k5.f11203a) != null && str2.length() != 0) {
                        JSONObject jSONObject = k5.f11206d;
                        jSONObject.getClass();
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            long optLong = optJSONObject.optLong("appID");
                            long optLong2 = optJSONObject.optLong("deepLinkHashID");
                            if (optLong > 0 && optLong2 > 0) {
                                x4.k kVar2 = new x4.k();
                                UptodownApp.f3293g0 = kVar2;
                                kVar2.f11251e = optLong2;
                                int i14 = MainActivity.G0;
                                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(mainActivity4);
                                v7.e eVar3 = o7.m0.f8288a;
                                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new n3(mainActivity4, optLong, cVar4, 1), 2);
                            }
                        }
                    } else if (mainActivity4.l()) {
                        mainActivity4.T0();
                    } else {
                        v7.e eVar4 = o7.m0.f8288a;
                        p7.c cVar5 = t7.n.f10348a;
                        j3 j3Var = new j3(mainActivity4, cVar4, 4);
                        this.f1622b = 1;
                        if (o7.c0.C(j3Var, cVar5, this) == aVar) {
                        }
                    }
                } else if (i13 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 3:
                int i15 = this.f1622b;
                if (i15 == 0) {
                    p6.a.e(obj);
                    this.f1622b = 1;
                    int i16 = MainActivity.G0;
                    v7.e eVar5 = o7.m0.f8288a;
                    Object C = o7.c0.C(new j3(mainActivity, objArr == true ? 1 : 0, i6), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                    }
                } else if (i15 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 4:
                int i17 = this.f1622b;
                if (i17 == 0) {
                    p6.a.e(obj);
                    Context applicationContext = mainActivity.getApplicationContext();
                    applicationContext.getClass();
                    e1.v4 v4Var = new e1.v4(applicationContext, 2, false);
                    this.f1622b = 1;
                    v7.e eVar6 = o7.m0.f8288a;
                    Object C2 = o7.c0.C(new g(v4Var, objArr2 == true ? 1 : 0, 22), v7.d.f10884a, this);
                    if (C2 != aVar) {
                        C2 = xVar;
                    }
                    if (C2 == aVar) {
                    }
                } else if (i17 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 5:
                int i18 = this.f1622b;
                if (i18 == 0) {
                    p6.a.e(obj);
                    this.f1622b = 1;
                    int i19 = MainActivity.G0;
                    v7.e eVar7 = o7.m0.f8288a;
                    Object C3 = o7.c0.C(new j3(mainActivity, objArr3 == true ? 1 : 0, i6), v7.d.f10884a, this);
                    if (C3 != aVar) {
                        C3 = xVar;
                    }
                    if (C3 == aVar) {
                    }
                } else if (i18 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 6:
                int i20 = this.f1622b;
                if (i20 == 0) {
                    p6.a.e(obj);
                    MainActivity mainActivity5 = this.f1623l;
                    if (mainActivity5.getApplicationContext() != null) {
                        Context applicationContext2 = mainActivity5.getApplicationContext();
                        applicationContext2.getClass();
                        int size2 = b2.t1.z(applicationContext2).size();
                        Context applicationContext3 = mainActivity5.getApplicationContext();
                        applicationContext3.getClass();
                        j5.g l12 = j5.g.D.l(applicationContext3);
                        l12.b();
                        ArrayList P2 = l12.P();
                        l12.c();
                        Iterator it3 = P2.iterator();
                        it3.getClass();
                        int i21 = 0;
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            next3.getClass();
                            x4.r rVar2 = (x4.r) next3;
                            if (rVar2.p() && rVar2.f11356l == 0 && rVar2.c()) {
                                i21++;
                            }
                        }
                        kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                        xVar3.f7024a = ContextCompat.getDrawable(mainActivity5, 2131231490);
                        x4.w2 h = x4.u2.h(mainActivity5);
                        if (h != null) {
                            String str5 = h.f11433l;
                            String k10 = str5 != null ? a4.x.k(str5, UptodownApp.R, ":webp") : null;
                            if (k10 != null && k10.length() != 0) {
                                try {
                                    a4.l0 e10 = a4.g0.d().e(x4.u2.e(h.f11433l));
                                    float f = UptodownApp.I;
                                    e10.h(b4.d.x(mainActivity5));
                                    Bitmap c9 = e10.c();
                                    c9.getClass();
                                    Resources resources = mainActivity5.getResources();
                                    resources.getClass();
                                    xVar3.f7024a = new BitmapDrawable(resources, c9);
                                } catch (IOException unused3) {
                                }
                            }
                        }
                        v7.e eVar8 = o7.m0.f8288a;
                        p7.c cVar6 = t7.n.f10348a;
                        m mVar = new m(mainActivity5, xVar3, i21, size2, null, 1);
                        this.f1622b = 1;
                        if (o7.c0.C(mVar, cVar6, this) == aVar) {
                        }
                    }
                } else if (i20 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            default:
                int i22 = this.f1622b;
                if (i22 == 0) {
                    p6.a.e(obj);
                    this.f1622b = 1;
                    if (o7.c0.j(1000L, this) == aVar) {
                    }
                } else if (i22 == 1) {
                    p6.a.e(obj);
                } else if (i22 != 2) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    break;
                }
                this.f1622b = 2;
                int i23 = MainActivity.G0;
                v7.e eVar9 = o7.m0.f8288a;
                Object C4 = o7.c0.C(new g3(mainActivity, objArr4 == true ? 1 : 0, 6), v7.d.f10884a, this);
                if (C4 != aVar) {
                    C4 = xVar;
                }
                if (C4 == aVar) {
                }
                break;
        }
        return xVar;
    }
}
