package u4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10551a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10552b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f10553l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v0 f10554m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Context context, v0 v0Var, long j, t6.c cVar) {
        super(2, cVar);
        this.f10551a = 3;
        this.f10552b = context;
        this.f10554m = v0Var;
        this.f10553l = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10551a) {
            case 0:
                return new n0(this.f10554m, this.f10552b, this.f10553l, cVar);
            case 1:
                return new n0(1, this.f10553l, this.f10552b, cVar, this.f10554m);
            case 2:
                return new n0(2, this.f10553l, this.f10552b, cVar, this.f10554m);
            default:
                return new n0(this.f10552b, this.f10554m, this.f10553l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10551a) {
            case 0:
                n0 n0Var = (n0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                n0Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                n0 n0Var2 = (n0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                n0Var2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                n0 n0Var3 = (n0) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                n0Var3.invokeSuspend(xVar3);
                return xVar3;
            default:
                n0 n0Var4 = (n0) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                n0Var4.invokeSuspend(xVar4);
                return xVar4;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        JSONObject jSONObject3;
        switch (this.f10551a) {
            case 0:
                p6.a.e(obj);
                r7.o0 o0Var = this.f10554m.f10630m;
                o0Var.getClass();
                o0Var.g(null, j5.p.f6705a);
                Context context = this.f10552b;
                j5.v vVar = new j5.v(context);
                long j = this.f10553l;
                g2 b7 = vVar.b(j);
                if (!b7.b() && (jSONObject = b7.f11206d) != null && jSONObject.optInt("success") == 1) {
                    new android.support.v4.media.g(context, 20).E(k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed"), "preregister");
                    j5.g l10 = j5.g.D.l(context);
                    l10.b();
                    String[] strArr = {String.valueOf(j)};
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("preregistrations", "appId=?", strArr);
                    l10.c();
                    j5.r rVar = new j5.r(new j0(false));
                    o0Var.getClass();
                    o0Var.g(null, rVar);
                }
                break;
            case 1:
                p6.a.e(obj);
                j5.v vVar2 = new j5.v(this.f10552b);
                boolean z9 = false;
                g2 k5 = vVar2.k(k0.k.g(this.f10553l, "https://www.uptodown.app:443/eapi/app/", "/pre-registered"), j5.v.g(), ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar2.i(k5, "/eapi/app/appID/pre-registered");
                if (k5.b() || (jSONObject2 = k5.f11206d) == null || (optJSONObject = jSONObject2.optJSONObject("data")) == null) {
                    str = null;
                } else {
                    str = !optJSONObject.isNull("message") ? optJSONObject.optString("message") : null;
                    if (!optJSONObject.isNull("preRegistered") && optJSONObject.optInt("preRegistered") != 0) {
                        z9 = true;
                    }
                }
                r7.o0 o0Var2 = this.f10554m.f10632o;
                j5.r rVar2 = new j5.r(new k0(str, z9));
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
            case 2:
                ArrayList w2 = a4.x.w(obj);
                j5.v vVar3 = new j5.v(this.f10552b);
                g2 k10 = vVar3.k(k0.k.g(this.f10553l, "https://www.uptodown.app:443/eapi/v2/apps/", "/promoted"), j5.v.g(), ShareTarget.METHOD_GET, false);
                k10.f11206d = vVar3.i(k10, "/eapi/v2/apps/appID/promoted");
                if (!k10.b() && (jSONObject3 = k10.f11206d) != null) {
                    JSONArray optJSONArray = jSONObject3.optJSONArray("data");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            x4.g gVar = new x4.g();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            optJSONObject2.getClass();
                            gVar.a(null, optJSONObject2);
                            w2.add(gVar);
                        }
                    }
                    if (!w2.isEmpty()) {
                        r7.o0 o0Var3 = this.f10554m.f10627e;
                        o0Var3.getClass();
                        o0Var3.g(null, w2);
                    }
                }
                break;
            default:
                p6.a.e(obj);
                j5.v vVar4 = new j5.v(this.f10552b);
                Object value = this.f10554m.C.getValue();
                long j6 = this.f10553l;
                if (value != null) {
                    g2 k11 = vVar4.k(k0.k.g(j6, "https://www.uptodown.com:443/dwn/", "/native-external-update/increase"), null, ShareTarget.METHOD_POST, false);
                    k11.f11206d = vVar4.i(k11, "/dwn/appID/native-external-update/increase");
                } else {
                    g2 k12 = vVar4.k(k0.k.g(j6, "https://www.uptodown.com:443/dwn/", "/native-external/increase"), null, ShareTarget.METHOD_POST, false);
                    k12.f11206d = vVar4.i(k12, "/dwn/appID/native-external/increase");
                }
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(int i, long j, Context context, t6.c cVar, v0 v0Var) {
        super(2, cVar);
        this.f10551a = i;
        this.f10552b = context;
        this.f10553l = j;
        this.f10554m = v0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(v0 v0Var, Context context, long j, t6.c cVar) {
        super(2, cVar);
        this.f10551a = 0;
        this.f10554m = v0Var;
        this.f10552b = context;
        this.f10553l = j;
    }
}
