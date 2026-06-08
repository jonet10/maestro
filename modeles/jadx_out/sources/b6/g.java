package b6;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.documentfile.provider.DocumentFile;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c4.bc;
import c4.ca;
import c4.g9;
import c4.h6;
import c4.t0;
import c4.v8;
import c4.w;
import c4.y7;
import c4.ya;
import c4.z6;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.ContactUsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import d7.p;
import g4.h0;
import j4.o;
import j5.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o7.a0;
import o7.b0;
import o7.c0;
import o7.f0;
import o7.m0;
import org.json.JSONObject;
import p6.x;
import q6.l;
import q7.r;
import r7.k0;
import s4.s;
import t7.n;
import u4.v0;
import x4.d2;
import x4.g2;
import x4.h2;
import x4.j;
import x4.k2;
import x4.m2;
import x4.p2;
import x4.x1;
import x4.y2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1087a;

    /* renamed from: b, reason: collision with root package name */
    public int f1088b;

    /* renamed from: l, reason: collision with root package name */
    public Object f1089l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1090m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1091n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, ca caVar, String str, int i, t6.c cVar) {
        super(2, cVar);
        this.f1087a = 11;
        this.f1089l = context;
        this.f1090m = caVar;
        this.f1091n = str;
        this.f1088b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(Object obj) {
        Application application = (Application) this.f1091n;
        l8.e eVar = (l8.e) this.f1090m;
        int i = this.f1088b;
        int i6 = 3;
        int i10 = 2;
        int i11 = 0;
        int i12 = 1;
        Typeface typeface = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        if (i == 0) {
            p6.a.e(obj);
            a0 a0Var = (a0) this.f1089l;
            o6.e.f8225b = new n9.a(eVar.f7187a == null ? null : new Float(r8.f7193c.intValue()));
            o6.e.f8226c = new n9.a(eVar.f7188b == null ? null : new Float(r8.f7193c.intValue()));
            o6.e.f8227d = new n9.a(eVar.f7189c == null ? null : new Float(r8.f7193c.intValue()));
            o6.e.f8228e = new n9.a(eVar.f7190d == null ? null : new Float(r8.f7193c.intValue()));
            f0[] f0VarArr = {c0.e(a0Var, new o6.b(application, eVar, objArr4 == true ? 1 : 0, i11)), c0.e(a0Var, new o6.b(application, eVar, objArr3 == true ? 1 : 0, i12)), c0.e(a0Var, new o6.b(application, eVar, objArr2 == true ? 1 : 0, i10)), c0.e(a0Var, new o6.b(application, eVar, objArr == true ? 1 : 0, i6))};
            this.f1088b = 1;
            obj = c0.f(f0VarArr, this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        List list = (List) obj;
        Typeface typeface2 = (Typeface) list.get(0);
        Typeface typeface3 = (Typeface) list.get(1);
        Typeface typeface4 = (Typeface) list.get(2);
        Typeface typeface5 = (Typeface) list.get(3);
        h9.c cVar = m9.c.f7859c;
        n9.a aVar2 = o6.e.f8225b;
        if (aVar2 != null) {
            if (typeface2 == null) {
                typeface2 = cVar == null ? null : cVar.f5493a;
            }
            aVar2.f8119a = typeface2;
        }
        n9.a aVar3 = o6.e.f8226c;
        if (aVar3 != null) {
            if (typeface3 == null) {
                typeface3 = cVar == null ? null : cVar.f5493a;
            }
            aVar3.f8119a = typeface3;
        }
        n9.a aVar4 = o6.e.f8227d;
        if (aVar4 != null) {
            if (typeface4 == null) {
                typeface4 = cVar == null ? null : cVar.f5494b;
            }
            aVar4.f8119a = typeface4;
        }
        n9.a aVar5 = o6.e.f8228e;
        if (aVar5 != null) {
            if (typeface5 != null) {
                typeface = typeface5;
            } else if (cVar != null) {
                typeface = cVar.f5494b;
            }
            aVar5.f8119a = typeface;
        }
        a.a.f("All fonts set: Title=" + o6.e.f8225b + ", Subtitle=" + o6.e.f8226c + ", Body=" + o6.e.f8227d + ", Button=" + o6.e.f8228e);
        return x.f8463a;
    }

    private final Object b(Object obj) {
        j5.g l10;
        JSONObject jSONObject;
        v vVar = (v) this.f1091n;
        s sVar = (s) this.f1090m;
        int i = this.f1088b;
        if (i == 0) {
            p6.a.e(obj);
            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
            xVar.f7024a = new ArrayList();
            l10 = j5.g.D.l(sVar.f9284a);
            l10.b();
            h2 X = l10.X("home_categories");
            if (X == null || !X.a()) {
                g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/home"), v.g(), ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, "/eapi/home");
                if (!k5.b() && (jSONObject = k5.f11206d) != null) {
                    xVar.f7024a = t0.f.x(jSONObject);
                    String str = k5.f11203a;
                    str.getClass();
                    long currentTimeMillis = System.currentTimeMillis();
                    l10.r("home_categories");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "home_categories");
                    contentValues.put("json", str);
                    contentValues.put("timestamp", String.valueOf(currentTimeMillis));
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.insert("responses", null, contentValues);
                }
            } else {
                xVar.f7024a = t0.f.x(new JSONObject((String) X.f11212b));
            }
            if (!((Collection) xVar.f7024a).isEmpty()) {
                p2 a8 = s.a(sVar, (j) l.q0((List) xVar.f7024a), vVar, l10);
                v7.e eVar = m0.f8288a;
                p7.c cVar = n.f10348a;
                w wVar = new w(sVar, a8, vVar, xVar, null, 11);
                this.f1089l = l10;
                this.f1088b = 1;
                Object C = c0.C(wVar, cVar, this);
                u6.a aVar = u6.a.f10762a;
                if (C == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            l10 = (j5.g) this.f1089l;
            p6.a.e(obj);
        }
        l10.c();
        return x.f8463a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [q7.i] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    private final Object c(Object obj) {
        ?? r42;
        int i = this.f1088b;
        x xVar = x.f8463a;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return xVar;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        a0 a0Var = (a0) this.f1089l;
        r7.i iVar = (r7.i) this.f1090m;
        r7.d dVar = (r7.d) this.f1091n;
        switch (dVar.f8966m) {
            case 2:
                t6.h hVar = dVar.f8963a;
                int i6 = dVar.f8964b;
                ya yaVar = new ya(dVar, null, 26);
                o7.a rVar = new r(c0.t(a0Var, hVar), i5.a(i6, q7.a.f8729a, 4));
                rVar.f0(b0.f8233a, rVar, yaVar);
                r42 = rVar;
                break;
            default:
                t6.h hVar2 = dVar.f8963a;
                int i10 = dVar.f8964b;
                if (i10 == -3) {
                    i10 = -2;
                }
                q7.a aVar = dVar.f8965l;
                ya yaVar2 = new ya(dVar, null, 26);
                o7.a rVar2 = new r(c0.t(a0Var, hVar2), i5.a(i10, aVar, 4));
                rVar2.f0(b0.f8235l, rVar2, yaVar2);
                r42 = rVar2;
                break;
        }
        this.f1088b = 1;
        Object i11 = k0.i(iVar, r42, true, this);
        u6.a aVar2 = u6.a.f10762a;
        if (i11 != aVar2) {
            i11 = xVar;
        }
        return i11 == aVar2 ? aVar2 : xVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1087a) {
            case 0:
                return new g((b) this.f1090m, (h) this.f1091n, cVar, 0);
            case 1:
                return new g(this.f1088b, (AppInstalledDetailsActivity) this.f1089l, (String) this.f1090m, (x4.r) this.f1091n, cVar);
            case 2:
                return new g((kotlin.jvm.internal.v) this.f1089l, (ContactUsActivity) this.f1090m, (kotlin.jvm.internal.x) this.f1091n, cVar, 2);
            case 3:
                return new g((ContactUsActivity) this.f1089l, (String) this.f1090m, (String) this.f1091n, cVar, 3);
            case 4:
                return new g((t0) this.f1089l, (Context) this.f1090m, (String) this.f1091n, cVar, 4);
            case 5:
                return new g((h6) this.f1090m, (OldVersionsActivity) this.f1091n, cVar, 5);
            case 6:
                return new g((Context) this.f1089l, (x1) this.f1090m, (z6) this.f1091n, cVar, 6);
            case 7:
                return new g((k2) this.f1089l, (Context) this.f1090m, (y7) this.f1091n, cVar, 7);
            case 8:
                return new g((d2) this.f1089l, (Context) this.f1090m, (v8) this.f1091n, cVar, 8);
            case 9:
                return new g((k2) this.f1089l, (Context) this.f1090m, (v8) this.f1091n, cVar, 9);
            case 10:
                return new g((k2) this.f1089l, (Context) this.f1090m, (g9) this.f1091n, cVar, 10);
            case 11:
                return new g((Context) this.f1089l, (ca) this.f1090m, (String) this.f1091n, this.f1088b, cVar);
            case 12:
                return new g((k2) this.f1089l, (Context) this.f1090m, (bc) this.f1091n, cVar, 12);
            case 13:
                return new g((UserDeviceDetailsActivity) this.f1090m, (y2) this.f1091n, cVar, 13);
            case 14:
                return new g((UsernameEditActivity) this.f1089l, (kotlin.jvm.internal.v) this.f1090m, (kotlin.jvm.internal.x) this.f1091n, cVar, 14);
            case 15:
                return new g((m2) this.f1089l, (PreferencesActivity) this.f1090m, (x4.p) this.f1091n, cVar, 15);
            case 16:
                return new g((String) this.f1089l, (String) this.f1090m, (String) this.f1091n, cVar, 16);
            case 17:
                return new g((File) this.f1089l, (o) this.f1090m, (DocumentFile) this.f1091n, cVar, 17);
            case 18:
                return new g((File) this.f1089l, (File) this.f1090m, (n4.h) this.f1091n, cVar, 18);
            case 19:
                return new g((String) this.f1089l, (Activity) this.f1090m, (h0) this.f1091n, cVar, 19);
            case 20:
                g gVar = new g((Application) this.f1091n, (l8.e) this.f1090m, cVar);
                gVar.f1089l = obj;
                return gVar;
            case 21:
                return new g((y2.s) this.f1090m, (v) this.f1091n, cVar, 21);
            case 22:
                return new g((s) this.f1090m, (v) this.f1091n, cVar, 22);
            case 23:
                g gVar2 = new g((r7.i) this.f1090m, (r7.d) this.f1091n, cVar, 23);
                gVar2.f1089l = obj;
                return gVar2;
            default:
                return new g((v0) this.f1089l, (k2) this.f1090m, (Context) this.f1091n, cVar, 24);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1087a) {
            case 1:
                g gVar = (g) create(a0Var, cVar);
                x xVar = x.f8463a;
                gVar.invokeSuspend(xVar);
                break;
            case 11:
                g gVar2 = (g) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                gVar2.invokeSuspend(xVar2);
                break;
            case 14:
                ((g) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                break;
        }
        return ((g) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0a14  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0239 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 3030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Application application, l8.e eVar, t6.c cVar) {
        super(2, cVar);
        this.f1087a = 20;
        this.f1090m = eVar;
        this.f1091n = application;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, AppInstalledDetailsActivity appInstalledDetailsActivity, String str, x4.r rVar, t6.c cVar) {
        super(2, cVar);
        this.f1087a = 1;
        this.f1088b = i;
        this.f1089l = appInstalledDetailsActivity;
        this.f1090m = str;
        this.f1091n = rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, Object obj2, Object obj3, t6.c cVar, int i) {
        super(2, cVar);
        this.f1087a = i;
        this.f1089l = obj;
        this.f1090m = obj2;
        this.f1091n = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f1087a = i;
        this.f1090m = obj;
        this.f1091n = obj2;
    }
}
