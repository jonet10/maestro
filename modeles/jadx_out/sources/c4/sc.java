package c4;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.widget.EditText;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.documentfile.provider.DocumentFile;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class sc extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2096a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2097b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2098l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc(d4.l lVar, Context context, t6.c cVar) {
        super(2, cVar);
        this.f2096a = 3;
        this.f2098l = lVar;
        this.f2097b = context;
    }

    private final Object a(Object obj) {
        FileOutputStream fileOutputStream = (FileOutputStream) this.f2098l;
        FileInputStream fileInputStream = (FileInputStream) this.f2097b;
        p6.a.e(obj);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            }
            fileInputStream.close();
            try {
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
            return p6.x.f8463a;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Exception unused3) {
            }
            try {
                fileOutputStream.close();
                throw th;
            } catch (Exception unused4) {
                throw th;
            }
        }
    }

    private final Object b(Object obj) {
        File file = (File) this.f2098l;
        m8.q qVar = (m8.q) this.f2097b;
        p6.x xVar = p6.x.f8463a;
        p6.a.e(obj);
        try {
            boolean z9 = false;
            try {
                SharedPreferences sharedPreferences = ((Activity) qVar.f7780b).getSharedPreferences("CoreSettings", 0);
                if (sharedPreferences.contains("system_app")) {
                    z9 = sharedPreferences.getBoolean("system_app", false);
                }
            } catch (Exception unused) {
            }
            if (z9) {
                m8.q.a(qVar, file);
            } else {
                g4.h0 h0Var = (g4.h0) qVar.f7781l;
                if (h0Var == null) {
                    return null;
                }
                file.getPath();
                h0Var.f5190a.M("error: not system permissions");
            }
            return xVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return xVar;
        }
    }

    private final Object c(Object obj) {
        p6.a.e(obj);
        g4.u uVar = (g4.u) this.f2097b;
        String name = ((DocumentFile) this.f2098l).getName();
        name.getClass();
        uVar.a(name);
        return p6.x.f8463a;
    }

    private final Object d(Object obj) {
        String str;
        JSONObject optJSONObject;
        p6.a.e(obj);
        Context context = (Context) this.f2097b;
        x4.w2 h = x4.u2.h(context);
        if (h != null && x4.u2.g(context)) {
            j5.v vVar = new j5.v(context);
            HashMap hashMap = new HashMap();
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                hashMap.put("deviceIdentifier", string);
            }
            x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/user/getUpdatedData"), hashMap, ShareTarget.METHOD_GET, false);
            if (!k5.b() && (str = k5.f11203a) != null && str.length() != 0) {
                String str2 = k5.f11203a;
                str2.getClass();
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt("success") == 1 && !jSONObject.isNull("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    h.b(context, optJSONObject);
                    h.e(context);
                    w4.p pVar = (w4.p) this.f2098l;
                    if (pVar != null) {
                        pVar.l();
                    }
                }
            }
            if (k5.f11204b == 401) {
                x4.u2.b(context);
            }
        }
        return p6.x.f8463a;
    }

    private final Object e(Object obj) {
        p6.a.e(obj);
        u4.y0 y0Var = (u4.y0) ((y2.s) this.f2097b).f11756l;
        ArrayList arrayList = (ArrayList) ((kotlin.jvm.internal.x) this.f2098l).f7024a;
        y0Var.getClass();
        arrayList.getClass();
        y0Var.f10664a.f10672m = arrayList;
        return p6.x.f8463a;
    }

    private final Object f(Object obj) {
        long j;
        JSONObject jSONObject;
        boolean z9;
        String str;
        x4.e eVar;
        x4.e eVar2;
        String str2;
        kotlin.jvm.internal.v vVar = (kotlin.jvm.internal.v) this.f2098l;
        p6.a.e(obj);
        s4.g gVar = (s4.g) this.f2097b;
        ArrayList arrayList = gVar.f9201a;
        Context context = gVar.f9202b;
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        try {
            j = sharedPreferences.getLong("getLastTimeGetTrackedAppsInfoCalled", 0L);
        } catch (ClassCastException unused) {
            try {
                j = sharedPreferences.getInt("getLastTimeGetTrackedAppsInfoCalled", -1);
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences2.getClass();
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                edit.putLong("getLastTimeGetTrackedAppsInfoCalled", j);
                edit.apply();
            } catch (ClassCastException unused2) {
                j = 0;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        boolean z10 = true;
        if (currentTimeMillis > 86400000) {
            vVar.f7022a++;
        }
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            if (((x4.e) next).H == 0) {
                vVar.f7022a++;
            }
        }
        if (vVar.f7022a > 0) {
            j5.v vVar2 = new j5.v(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            context.getClass();
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences3.getClass();
            SharedPreferences.Editor edit2 = sharedPreferences3.edit();
            edit2.putLong("getLastTimeGetTrackedAppsInfoCalled", currentTimeMillis2);
            edit2.apply();
            x4.e eVar3 = null;
            x4.g2 k5 = vVar2.k(a4.x.j("https://t.uptodown.app:443/eapi/androidtracker/device-apps-installed/", Settings.Secure.getString(context.getContentResolver(), "android_id")), null, ShareTarget.METHOD_GET, false);
            k5.f11206d = vVar2.i(k5, "/eapi/androidtracker/device-apps-installed");
            if (!k5.b() && (jSONObject = k5.f11206d) != null && !jSONObject.isNull("success")) {
                String str3 = "data";
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                    j5.g l10 = j5.g.D.l(context);
                    l10.b();
                    int length = optJSONArray.length();
                    int i = 0;
                    while (i < length) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (!optJSONObject.isNull("packageName")) {
                            String optString = optJSONObject.optString("packageName");
                            Iterator it2 = arrayList.iterator();
                            it2.getClass();
                            while (true) {
                                if (!it2.hasNext()) {
                                    eVar2 = eVar3;
                                    break;
                                }
                                Object next2 = it2.next();
                                next2.getClass();
                                eVar2 = (x4.e) next2;
                                if (l7.u.m0(optString, eVar2.f11123l, z10)) {
                                    break;
                                }
                            }
                            if (eVar2 != null) {
                                long optLong = !optJSONObject.isNull("appID") ? optJSONObject.optLong("appID") : 0L;
                                int optInt = !optJSONObject.isNull("hasOldVersions") ? optJSONObject.optInt("hasOldVersions") : 0;
                                String str4 = str3;
                                if (eVar2.H == 0 || eVar2.F != optLong || eVar2.G != optInt) {
                                    optString.getClass();
                                    l10.u0(optString, optInt, optLong);
                                }
                                arrayList.remove(eVar2);
                                String str5 = eVar2.f11123l;
                                str5.getClass();
                                x4.q2 Y = l10.Y(str5);
                                if (Y != null) {
                                    x4.g2 o10 = vVar2.o(optLong);
                                    if (!o10.b() && (str2 = o10.f11203a) != null && str2.length() != 0) {
                                        String str6 = o10.f11203a;
                                        str6.getClass();
                                        JSONObject jSONObject2 = new JSONObject(str6);
                                        str = str4;
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject(str);
                                        z9 = true;
                                        if (jSONObject2.optInt("success") != 1 || optJSONObject2 == null) {
                                            eVar = null;
                                        } else {
                                            x4.g gVar2 = new x4.g();
                                            eVar = null;
                                            gVar2.a(null, optJSONObject2);
                                            String str7 = gVar2.f11161c0;
                                            if (str7 != null && gVar2.F != null) {
                                                Y.f11350q = str7;
                                                l10.p0(Y);
                                            }
                                        }
                                        i++;
                                        str3 = str;
                                        eVar3 = eVar;
                                        z10 = z9;
                                    }
                                }
                                str = str4;
                                eVar = null;
                                z9 = true;
                                i++;
                                str3 = str;
                                eVar3 = eVar;
                                z10 = z9;
                            }
                        }
                        z9 = z10;
                        str = str3;
                        eVar = eVar3;
                        i++;
                        str3 = str;
                        eVar3 = eVar;
                        z10 = z9;
                    }
                    Iterator it3 = arrayList.iterator();
                    it3.getClass();
                    while (it3.hasNext()) {
                        Object next3 = it3.next();
                        next3.getClass();
                        x4.e eVar4 = (x4.e) next3;
                        String str8 = eVar4.f11123l;
                        if (str8 != null && eVar4.H == 0) {
                            l10.u0(str8, 0, eVar4.F);
                        }
                    }
                    l10.c();
                }
            }
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object h(Object obj) {
        p6.j jVar;
        JSONObject jSONObject;
        p6.a.e(obj);
        AtomicBoolean atomicBoolean = s4.x.f9315b;
        if (atomicBoolean.compareAndSet(false, true)) {
            x4.w2 w2Var = new x4.w2();
            j5.v vVar = new j5.v(((s4.x) this.f2097b).f9316a);
            String str = (String) this.f2098l;
            str.getClass();
            x4.g2 k5 = vVar.k("https://www.uptodown.app:443/eapi/profile/" + str + "/data", null, ShareTarget.METHOD_GET, false);
            k5.f11206d = vVar.i(k5, "/eapi/profile/userID/data");
            if (k5.b() || (jSONObject = k5.f11206d) == null) {
                atomicBoolean.set(false);
                jVar = new p6.j(new Exception());
            } else if (jSONObject.isNull("data")) {
                atomicBoolean.set(false);
                jVar = new p6.j(new Exception());
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                jSONObject2.getClass();
                w2Var.c(jSONObject2);
                atomicBoolean.set(false);
                jVar = w2Var;
            }
        } else {
            atomicBoolean.set(false);
            jVar = new p6.j(new Exception());
        }
        return new p6.k(jVar);
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2096a) {
            case 0:
                return new sc((Context) this.f2097b, (tc) this.f2098l, cVar, 0);
            case 1:
                return new sc((Context) this.f2097b, (zc) this.f2098l, cVar, 1);
            case 2:
                return new sc((WishlistActivity) this.f2097b, (String) this.f2098l, cVar, 2);
            case 3:
                return new sc((d4.l) this.f2098l, (Context) this.f2097b, cVar);
            case 4:
                return new sc((TvAppDetailActivity) this.f2097b, (String) this.f2098l, cVar, 4);
            case 5:
                sc scVar = new sc((f5.a) this.f2098l, cVar, 5);
                scVar.f2097b = obj;
                return scVar;
            case 6:
                return new sc((g4.h) this.f2097b, (String) this.f2098l, cVar, 6);
            case 7:
                return new sc((FileExplorerActivity) this.f2097b, (String) this.f2098l, cVar, 7);
            case 8:
                return new sc((FileExplorerActivity) this.f2097b, (kotlin.jvm.internal.v) this.f2098l, cVar, 8);
            case 9:
                return new sc((FileExplorerActivity) this.f2097b, (EditText) this.f2098l, cVar, 9);
            case 10:
                return new sc((InstallerActivity) this.f2097b, (kotlin.jvm.internal.v) this.f2098l, cVar, 10);
            case 11:
                return new sc((TvAppDetailFragment) this.f2097b, (kotlin.jvm.internal.x) this.f2098l, cVar, 11);
            case 12:
                return new sc((TvAppsListFragment) this.f2097b, (kotlin.jvm.internal.x) this.f2098l, cVar, 12);
            case 13:
                return new sc((TvMyAppsFragment) this.f2097b, (kotlin.jvm.internal.x) this.f2098l, cVar, 13);
            case 14:
                return new sc((TvMyDownloadsFragment) this.f2097b, (ArrayList) this.f2098l, cVar, 14);
            case 15:
                return new sc((TvSearchFragment) this.f2097b, (x4.g) this.f2098l, cVar, 15);
            case 16:
                return new sc((g5.n0) this.f2097b, (kotlin.jvm.internal.x) this.f2098l, cVar, 16);
            case 17:
                sc scVar2 = new sc((d7.l) this.f2098l, cVar, 17);
                scVar2.f2097b = obj;
                return scVar2;
            case 18:
                return new sc((a2.t) this.f2097b, (ArrayList) this.f2098l, cVar, 18);
            case 19:
                return new sc((a2.t) this.f2097b, (String) this.f2098l, cVar, 19);
            case 20:
                return new sc((FileInputStream) this.f2097b, (FileOutputStream) this.f2098l, cVar, 20);
            case 21:
                return new sc((g4.h0) this.f2097b, (String) this.f2098l, cVar, 21);
            case 22:
                return new sc((m8.q) this.f2097b, (File) this.f2098l, cVar, 22);
            case 23:
                return new sc((g4.u) this.f2097b, (File) this.f2098l, cVar, 23);
            case 24:
                return new sc((g4.u) this.f2097b, (DocumentFile) this.f2098l, cVar, 24);
            case 25:
                return new sc((Context) this.f2097b, (w4.p) this.f2098l, cVar, 25);
            case 26:
                return new sc((y2.s) this.f2097b, (kotlin.jvm.internal.x) this.f2098l, cVar, 26);
            case 27:
                return new sc((s4.g) this.f2097b, (kotlin.jvm.internal.v) this.f2098l, cVar, 27);
            case 28:
                return new sc((s4.x) this.f2097b, (String) this.f2098l, cVar, 28);
            default:
                return new sc((r.k) this.f2097b, (x4.x1) this.f2098l, cVar, 29);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2096a) {
            case 0:
                sc scVar = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar = p6.x.f8463a;
                scVar.invokeSuspend(xVar);
                break;
            case 1:
                sc scVar2 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar2 = p6.x.f8463a;
                scVar2.invokeSuspend(xVar2);
                break;
            case 2:
                sc scVar3 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar3 = p6.x.f8463a;
                scVar3.invokeSuspend(xVar3);
                break;
            case 3:
                sc scVar4 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar4 = p6.x.f8463a;
                scVar4.invokeSuspend(xVar4);
                break;
            case 4:
                sc scVar5 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar5 = p6.x.f8463a;
                scVar5.invokeSuspend(xVar5);
                break;
            case 5:
                sc scVar6 = (sc) create((x4.d0) obj, (t6.c) obj2);
                p6.x xVar6 = p6.x.f8463a;
                scVar6.invokeSuspend(xVar6);
                break;
            case 6:
                sc scVar7 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar7 = p6.x.f8463a;
                scVar7.invokeSuspend(xVar7);
                break;
            case 7:
                sc scVar8 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar8 = p6.x.f8463a;
                scVar8.invokeSuspend(xVar8);
                break;
            case 8:
                sc scVar9 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar9 = p6.x.f8463a;
                scVar9.invokeSuspend(xVar9);
                break;
            case 9:
                sc scVar10 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar10 = p6.x.f8463a;
                scVar10.invokeSuspend(xVar10);
                break;
            case 10:
                sc scVar11 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar11 = p6.x.f8463a;
                scVar11.invokeSuspend(xVar11);
                break;
            case 11:
                sc scVar12 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar12 = p6.x.f8463a;
                scVar12.invokeSuspend(xVar12);
                break;
            case 12:
                sc scVar13 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar13 = p6.x.f8463a;
                scVar13.invokeSuspend(xVar13);
                break;
            case 13:
                sc scVar14 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar14 = p6.x.f8463a;
                scVar14.invokeSuspend(xVar14);
                break;
            case 14:
                sc scVar15 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar15 = p6.x.f8463a;
                scVar15.invokeSuspend(xVar15);
                break;
            case 15:
                sc scVar16 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar16 = p6.x.f8463a;
                scVar16.invokeSuspend(xVar16);
                break;
            case 16:
                sc scVar17 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar17 = p6.x.f8463a;
                scVar17.invokeSuspend(xVar17);
                break;
            case 17:
                sc scVar18 = (sc) create((MutablePreferences) obj, (t6.c) obj2);
                p6.x xVar18 = p6.x.f8463a;
                scVar18.invokeSuspend(xVar18);
                break;
            case 18:
                sc scVar19 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar19 = p6.x.f8463a;
                scVar19.invokeSuspend(xVar19);
                break;
            case 19:
                sc scVar20 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar20 = p6.x.f8463a;
                scVar20.invokeSuspend(xVar20);
                break;
            case 20:
                sc scVar21 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar21 = p6.x.f8463a;
                scVar21.invokeSuspend(xVar21);
                break;
            case 23:
                sc scVar22 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar22 = p6.x.f8463a;
                scVar22.invokeSuspend(xVar22);
                break;
            case 24:
                sc scVar23 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar23 = p6.x.f8463a;
                scVar23.invokeSuspend(xVar23);
                break;
            case 25:
                sc scVar24 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar24 = p6.x.f8463a;
                scVar24.invokeSuspend(xVar24);
                break;
            case 26:
                sc scVar25 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar25 = p6.x.f8463a;
                scVar25.invokeSuspend(xVar25);
                break;
            case 27:
                sc scVar26 = (sc) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar26 = p6.x.f8463a;
                scVar26.invokeSuspend(xVar26);
                break;
        }
        return ((sc) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:325:0x07cf  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x08d2 A[LOOP:8: B:350:0x08d0->B:351:0x08d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0911 A[LOOP:10: B:364:0x090f->B:365:0x0911, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0950 A[LOOP:12: B:378:0x094e->B:379:0x0950, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x096f  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x098f A[LOOP:14: B:392:0x098d->B:393:0x098f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x09c4  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x09fd  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0a36  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x09c8  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x087b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v71 */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            Method dump skipped, instructions count: 3154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.sc.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sc(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f2096a = i;
        this.f2097b = obj;
        this.f2098l = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sc(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f2096a = i;
        this.f2098l = obj;
    }
}
