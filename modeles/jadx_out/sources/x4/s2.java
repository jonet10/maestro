package x4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11389a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11390b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f11391l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f11392m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f11393n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s2(Context context, String str, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.v vVar2, t6.c cVar, int i) {
        super(2, cVar);
        this.f11389a = i;
        this.f11390b = context;
        this.f11391l = str;
        this.f11392m = vVar;
        this.f11393n = vVar2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f11389a) {
            case 0:
                return new s2(this.f11390b, this.f11391l, this.f11392m, this.f11393n, cVar, 0);
            default:
                return new s2(this.f11390b, this.f11391l, this.f11392m, this.f11393n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f11389a) {
            case 0:
                s2 s2Var = (s2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                s2Var.invokeSuspend(xVar);
                return xVar;
            default:
                s2 s2Var2 = (s2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                s2Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        switch (this.f11389a) {
            case 0:
                p6.a.e(obj);
                Context context = this.f11390b;
                j5.v vVar = new j5.v(context);
                String str = this.f11391l;
                str.getClass();
                g2 k5 = vVar.k("https://www.uptodown.app:443/eapi/user/follow/".concat(str), null, ShareTarget.METHOD_POST, false);
                k5.f11206d = vVar.i(k5, "/eapi/user/follow/followUserID");
                int i = k5.f11204b;
                kotlin.jvm.internal.v vVar2 = this.f11392m;
                vVar2.f7022a = i;
                if (!k5.b() && (jSONObject = k5.f11206d) != null && !jSONObject.isNull("success")) {
                    this.f11393n.f7022a = jSONObject.optInt("success");
                }
                if (vVar2.f7022a == 401) {
                    u2.b(context);
                }
                break;
            default:
                p6.a.e(obj);
                Context context2 = this.f11390b;
                j5.v vVar3 = new j5.v(context2);
                String str2 = this.f11391l;
                str2.getClass();
                g2 k10 = vVar3.k("https://www.uptodown.app:443/eapi/user/unfollow/".concat(str2), null, ShareTarget.METHOD_POST, false);
                k10.f11206d = vVar3.i(k10, "/eapi/user/unfollow/followUserID");
                int i6 = k10.f11204b;
                kotlin.jvm.internal.v vVar4 = this.f11392m;
                vVar4.f7022a = i6;
                if (!k10.b() && (jSONObject2 = k10.f11206d) != null && !jSONObject2.isNull("success")) {
                    this.f11393n.f7022a = jSONObject2.optInt("success");
                }
                if (vVar4.f7022a == 401) {
                    u2.b(context2);
                }
                break;
        }
        return p6.x.f8463a;
    }
}
