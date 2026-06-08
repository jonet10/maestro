package androidx.work.impl.utils;

import android.content.Intent;
import android.net.Uri;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import b8.h;
import c4.k0;
import c4.mc;
import c4.nc;
import c4.w4;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserDeviceDetailsActivity;
import d7.l;
import e4.o0;
import e4.q0;
import e8.p;
import f8.m;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import l7.i;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import q6.u;
import t7.n;
import u4.f0;
import u4.m1;
import u4.w1;
import u4.z0;
import u4.z1;
import x4.g;
import x4.k;
import x4.z2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f635b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f636l;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f634a = i;
        this.f635b = obj;
        this.f636l = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d7.a
    public final Object invoke() {
        x forId$lambda$1;
        Object invoke;
        String[] names;
        int i = this.f634a;
        int i6 = 2;
        Object[] objArr = 0;
        x xVar = x.f8463a;
        Object obj = this.f636l;
        Object obj2 = this.f635b;
        switch (i) {
            case 0:
                forId$lambda$1 = CancelWorkRunnable.forId$lambda$1((WorkManagerImpl) obj2, (UUID) obj);
                return forId$lambda$1;
            case 1:
                invoke = ((l) obj2).invoke((WorkDatabase) obj);
                return invoke;
            case 2:
                ((k0) obj2).W((File) obj, null);
                return xVar;
            case 3:
                g gVar = (g) obj2;
                MainActivity mainActivity = (MainActivity) obj;
                int i10 = MainActivity.G0;
                if (gVar.k() && gVar.j()) {
                    float f = UptodownApp.I;
                    int E = b4.d.E(mainActivity, gVar);
                    k kVar = UptodownApp.f3293g0;
                    if (kVar != null) {
                        kVar.f11250d = E;
                    }
                    if (kVar != null) {
                        kVar.f11249c = gVar.F;
                    }
                } else {
                    String string = mainActivity.getString(2131951692);
                    string.getClass();
                    mainActivity.A(string);
                }
                mainActivity.x0(gVar);
                mainActivity.f3320s0 = -1L;
                return xVar;
            case 4:
                ((w4) obj2).M0((String) obj);
                return xVar;
            case 5:
                String str = (String) obj;
                int i11 = OldVersionsActivity.S;
                str.getClass();
                Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                intent.addFlags(268435456);
                ((OldVersionsActivity) obj2).startActivity(intent);
                return xVar;
            case 6:
                ArrayList arrayList = (ArrayList) obj2;
                Updates updates = (Updates) obj;
                int i12 = Updates.n0;
                x4.e eVar = arrayList.size() == 1 ? (x4.e) arrayList.get(0) : null;
                float f10 = UptodownApp.I;
                if (!b4.d.p(updates, "DownloadUpdatesWorker")) {
                    updates.M0(eVar != null ? eVar.f11123l : null);
                    updates.a1();
                } else if (eVar != null) {
                    w4.D0(eVar);
                }
                return xVar;
            case 7:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj2;
                z2 z2Var = (z2) obj;
                int i13 = UserDeviceDetailsActivity.T;
                nc z02 = userDeviceDetailsActivity.z0();
                long j = z2Var.f11481a;
                String str2 = z2Var.f11482b;
                z02.getClass();
                a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                v7.e eVar2 = m0.f8288a;
                c0.s(viewModelScope, v7.d.f10884a, null, new mc(userDeviceDetailsActivity, j, z02, str2, (t6.c) null), 2);
                return xVar;
            case 8:
                b8.e eVar3 = (b8.e) obj2;
                e8.b bVar = (e8.b) obj;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                bVar.f4761a.getClass();
                m.l(eVar3, bVar);
                int e10 = eVar3.e();
                for (int i14 = 0; i14 < e10; i14++) {
                    List g = eVar3.g(i14);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : g) {
                        if (obj3 instanceof p) {
                            arrayList2.add(obj3);
                        }
                    }
                    p pVar = (p) (arrayList2.size() == 1 ? arrayList2.get(0) : null);
                    if (pVar != null && (names = pVar.names()) != null) {
                        for (String str3 : names) {
                            String str4 = kotlin.jvm.internal.l.a(eVar3.getKind(), h.h) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str3)) {
                                throw new f8.l("The suggested name '" + str3 + "' for " + str4 + ' ' + eVar3.f(i14) + " is already one of the names for " + str4 + ' ' + eVar3.f(((Number) q6.a0.g0(linkedHashMap, str3)).intValue()) + " in " + eVar3);
                            }
                            linkedHashMap.put(str3, Integer.valueOf(i14));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? u.f8725a : linkedHashMap;
            case 9:
                String str5 = ((g) obj).f11167i0;
                str5.getClass();
                ((w4.g) obj2).p(str5);
                return xVar;
            case 10:
                String str6 = (String) obj;
                Matcher matcher = ((l7.k) obj2).f7176a.matcher(str6);
                matcher.getClass();
                if (matcher.find(0)) {
                    return new i(matcher, str6);
                }
                return null;
            case 11:
                ((ProgressBar) obj2).setVisibility(8);
                ((m5.f) obj).f7375a = false;
                return xVar;
            case 12:
                u4.d dVar = (u4.d) obj;
                String str7 = ((g) obj2).F;
                if (str7 != null) {
                    dVar.a(str7);
                }
                return xVar;
            case 13:
                f0 f0Var = (f0) obj;
                String str8 = ((g) obj2).F;
                if (str8 != null) {
                    f0Var.u0(str8);
                }
                return xVar;
            case 14:
                ((z0) obj2).m(((g) obj).F);
                return xVar;
            case 15:
                ((m1) obj2).d(((g) obj).F);
                return xVar;
            default:
                z1 z1Var = (z1) obj2;
                g gVar2 = (g) obj;
                gVar2.getClass();
                q0 q0Var = z1Var.f10685o;
                q0Var.getClass();
                ((o0) q0Var.f4666l.get(z1Var.c(gVar2.F))).f4648a = gVar2;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(z1Var);
                v7.e eVar4 = m0.f8288a;
                c0.s(lifecycleScope, n.f10348a, null, new w1(z1Var, gVar2, objArr == true ? 1 : 0, i6), 2);
                return xVar;
        }
    }
}
