package u4;

import android.content.Context;
import org.json.JSONObject;
import x4.g2;
import x4.k2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10607b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f10608l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f10609m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v0 f10610n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(Context context, String str, int i, long j, v0 v0Var, t6.c cVar) {
        super(2, cVar);
        this.f10606a = context;
        this.f10607b = str;
        this.f10608l = i;
        this.f10609m = j;
        this.f10610n = v0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new t0(this.f10606a, this.f10607b, this.f10608l, this.f10609m, this.f10610n, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        t0 t0Var = (t0) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        t0Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i;
        JSONObject jSONObject;
        p6.a.e(obj);
        Context context = this.f10606a;
        String str = this.f10607b;
        boolean z9 = false;
        if (q1.a.k(context, str)) {
            i = 0;
        } else {
            q1.a.o(context, str, String.valueOf(System.currentTimeMillis()));
            j5.v vVar = new j5.v(context);
            k2 k2Var = new k2();
            k2Var.f11263o = str;
            k2Var.f11264p = this.f10608l;
            g2 F = vVar.F(this.f10609m, k2Var);
            i = F.f11204b;
            if (!F.b() && (jSONObject = F.f11206d) != null && jSONObject.optInt("success") == 1) {
                z9 = true;
            }
        }
        r7.o0 o0Var = this.f10610n.f10636s;
        j5.r rVar = new j5.r(new l0(z9, i));
        o0Var.getClass();
        o0Var.g(null, rVar);
        return p6.x.f8463a;
    }
}
