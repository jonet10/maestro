package c4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class mc extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1878a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f1879b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1880l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewModel f1881m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f1882n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc(Context context, long j, nc ncVar, String str, t6.c cVar) {
        super(2, cVar);
        this.f1879b = context;
        this.f1880l = j;
        this.f1881m = ncVar;
        this.f1882n = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1878a) {
            case 0:
                return new mc(this.f1879b, this.f1880l, this.f1882n, (nc) this.f1881m, cVar);
            case 1:
                return new mc(this.f1879b, this.f1880l, (nc) this.f1881m, this.f1882n, cVar);
            default:
                return new mc(this.f1879b, this.f1882n, this.f1880l, (v8) this.f1881m, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1878a) {
            case 0:
                mc mcVar = (mc) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                mcVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                mc mcVar2 = (mc) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                mcVar2.invokeSuspend(xVar2);
                return xVar2;
            default:
                mc mcVar3 = (mc) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                mcVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        JSONObject jSONObject;
        int i = this.f1878a;
        p6.x xVar = p6.x.f8463a;
        ViewModel viewModel = this.f1881m;
        long j = this.f1880l;
        Context context = this.f1879b;
        int i6 = 0;
        switch (i) {
            case 0:
                r7.o0 o0Var = ((nc) viewModel).f1922d;
                p6.a.e(obj);
                j5.v vVar = new j5.v(context);
                String valueOf = String.valueOf(j);
                valueOf.getClass();
                HashMap hashMap = new HashMap();
                String str2 = this.f1882n;
                hashMap.put("name", str2);
                x4.g2 k5 = vVar.k(androidx.lifecycle.l.w("https://www.uptodown.app:443/eapi/user-data/device/", valueOf, "/update-name"), hashMap, ShareTarget.METHOD_POST, false);
                JSONObject i10 = vVar.i(k5, "/eapi/user-data/device/deviceID/update-name");
                k5.f11206d = i10;
                if (i10 != null) {
                    int optInt = i10.optInt("success");
                    if (!k5.b()) {
                        String string = context.getString(2131951924);
                        string.getClass();
                        j5.r rVar = new j5.r(new kc(this.f1880l, string, str2, optInt));
                        o0Var.getClass();
                        o0Var.g(null, rVar);
                        break;
                    } else {
                        j5.r rVar2 = new j5.r(new kc(this.f1880l, x4.g2.e(i10), str2, optInt));
                        o0Var.getClass();
                        o0Var.g(null, rVar2);
                        break;
                    }
                }
                break;
            case 1:
                r7.o0 o0Var2 = ((nc) viewModel).f;
                p6.a.e(obj);
                j5.v vVar2 = new j5.v(context);
                String valueOf2 = String.valueOf(j);
                valueOf2.getClass();
                x4.g2 k10 = vVar2.k("https://www.uptodown.app:443/eapi/user-data/device/" + valueOf2 + "/unlink", null, ShareTarget.METHOD_POST, false);
                JSONObject i11 = vVar2.i(k10, "/eapi/user-data/device/deviceID/unlink");
                k10.f11206d = i11;
                if (i11 != null) {
                    int optInt2 = i11.optInt("success");
                    boolean b7 = k10.b();
                    String str3 = this.f1882n;
                    if (!b7) {
                        String string2 = context.getString(2131952702);
                        string2.getClass();
                        j5.r rVar3 = new j5.r(new lc(optInt2, string2, str3));
                        o0Var2.getClass();
                        o0Var2.g(null, rVar3);
                        break;
                    } else {
                        j5.r rVar4 = new j5.r(new lc(optInt2, x4.g2.e(i11), str3));
                        o0Var2.getClass();
                        o0Var2.g(null, rVar4);
                        break;
                    }
                }
                break;
            default:
                p6.a.e(obj);
                String valueOf3 = String.valueOf(System.currentTimeMillis());
                String str4 = this.f1882n;
                if (context != null) {
                    if (str4.length() != 0) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                        sharedPreferences.getClass();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("last_review_text", str4);
                        edit.apply();
                    }
                    if (valueOf3 != null && valueOf3.length() != 0) {
                        SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
                        sharedPreferences2.getClass();
                        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                        edit2.putString("last_review_timestamp", valueOf3);
                        edit2.apply();
                    }
                }
                j5.v vVar3 = new j5.v(context);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("text", str4);
                try {
                    PackageManager packageManager = context.getPackageManager();
                    packageManager.getClass();
                    String packageName = context.getPackageName();
                    packageName.getClass();
                    str = " " + n4.i.e(packageManager, packageName, 0).versionName;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    str = "";
                }
                hashMap2.put("uagent", "uptodownandroid".concat(str));
                x4.g2 k11 = vVar3.k(a4.x.l(new StringBuilder("https://www.uptodown.app:443/eapi/comments/"), j, "/answers"), hashMap2, ShareTarget.METHOD_POST, false);
                k11.f11206d = vVar3.i(k11, "/eapi/comments/idReply/answers/post");
                String e11 = (k11.b() || (jSONObject = k11.f11206d) == null || (i6 = jSONObject.optInt("success")) != 0) ? null : x4.g2.e(jSONObject);
                int i12 = i6;
                r7.o0 o0Var3 = ((v8) viewModel).g;
                j5.r rVar5 = new j5.r(new s8(i12, k11.f11204b, this.f1880l, str4, e11));
                o0Var3.getClass();
                o0Var3.g(null, rVar5);
                break;
        }
        return xVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc(Context context, long j, String str, nc ncVar, t6.c cVar) {
        super(2, cVar);
        this.f1879b = context;
        this.f1880l = j;
        this.f1882n = str;
        this.f1881m = ncVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc(Context context, String str, long j, v8 v8Var, t6.c cVar) {
        super(2, cVar);
        this.f1879b = context;
        this.f1882n = str;
        this.f1880l = j;
        this.f1881m = v8Var;
    }
}
