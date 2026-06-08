package c4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u6 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v6 f2162a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2163b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f2164l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f2165m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f2166n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f2167o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u6(v6 v6Var, Context context, String str, String str2, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f2162a = v6Var;
        this.f2163b = context;
        this.f2164l = str;
        this.f2165m = str2;
        this.f2166n = xVar;
        this.f2167o = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new u6(this.f2162a, this.f2163b, this.f2164l, this.f2165m, this.f2166n, this.f2167o, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        u6 u6Var = (u6) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        u6Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        p6.a.e(obj);
        r7.o0 o0Var = this.f2162a.f2203a;
        o0Var.getClass();
        o0Var.g(null, j5.p.f6705a);
        j5.v vVar = new j5.v(this.f2163b);
        HashMap hashMap = new HashMap();
        hashMap.put("password1", this.f2164l);
        hashMap.put("password2", this.f2165m);
        x4.g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/user/set-new-password"), hashMap, ShareTarget.METHOD_POST, false);
        if (k5.b()) {
            k5.f11206d = vVar.j(k5, "/eapi/user/set-new-password");
        } else {
            k5.f11206d = vVar.i(k5, "/eapi/user/set-new-password");
        }
        boolean b7 = k5.b();
        kotlin.jvm.internal.v vVar2 = this.f2167o;
        kotlin.jvm.internal.x xVar = this.f2166n;
        if (!b7 && (jSONObject = k5.f11206d) != null) {
            xVar.f7024a = x4.g2.e(jSONObject);
            vVar2.f7022a = jSONObject.optInt("success");
        }
        j5.r rVar = new j5.r(new t6(vVar2.f7022a, (String) xVar.f7024a, k5.b()));
        o0Var.getClass();
        o0Var.g(null, rVar);
        return p6.x.f8463a;
    }
}
