package g5;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import c4.sc;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5330a;

    /* renamed from: b, reason: collision with root package name */
    public int f5331b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ n0 f5332l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l0(n0 n0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f5330a = i;
        this.f5332l = n0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5330a) {
            case 0:
                return new l0(this.f5332l, cVar, 0);
            default:
                return new l0(this.f5332l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5330a) {
        }
        return ((l0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        g2 g2Var;
        JSONObject jSONObject;
        Resources resources;
        int i = this.f5330a;
        int i6 = 0;
        n0 n0Var = this.f5332l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar = p6.x.f8463a;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i10 = this.f5331b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                    n0Var.f5342m = true;
                    FragmentActivity requireActivity = n0Var.requireActivity();
                    requireActivity.getClass();
                    j5.v vVar = new j5.v(requireActivity);
                    x4.j jVar = n0Var.f5340b;
                    if (jVar != null) {
                        int i11 = jVar.f11224a;
                        if (i11 == -2) {
                            g2Var = vVar.m(75, n0Var.f5341l);
                        } else if (i11 != -1) {
                            jVar.getClass();
                            boolean z9 = jVar.f11227m;
                            x4.j jVar2 = n0Var.f5340b;
                            if (z9) {
                                jVar2.getClass();
                                g2Var = vVar.u(jVar2.f11224a, 75, n0Var.f5341l);
                            } else {
                                jVar2.getClass();
                                g2Var = vVar.t(jVar2.f11224a, 75, n0Var.f5341l);
                            }
                        } else {
                            g2Var = vVar.s(75, n0Var.f5341l);
                        }
                    } else {
                        g2Var = null;
                    }
                    if (g2Var != null && !g2Var.b() && (jSONObject = g2Var.f11206d) != null) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                            xVar2.f7024a = new ArrayList();
                            Context context = n0Var.getContext();
                            Integer num = (context == null || (resources = context.getResources()) == null) ? null : new Integer(resources.getDimensionPixelSize(2131166557));
                            int length = optJSONArray.length();
                            while (i6 < length) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                optJSONObject.getClass();
                                x4.g gVar = new x4.g();
                                gVar.a(null, optJSONObject);
                                ((ArrayList) xVar2.f7024a).add(gVar);
                                if (num != null) {
                                    a4.g0.d().e(gVar.g(num.intValue())).b(null);
                                }
                                n0Var.f5341l++;
                                i6++;
                            }
                        }
                    }
                    v7.e eVar = o7.m0.f8288a;
                    p7.c cVar2 = t7.n.f10348a;
                    sc scVar = new sc(n0Var, xVar2, cVar, 16);
                    this.f5331b = 1;
                    if (o7.c0.C(scVar, cVar2, this) == aVar) {
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            default:
                int i12 = this.f5331b;
                if (i12 == 0) {
                    p6.a.e(obj);
                    this.f5331b = 1;
                    v7.e eVar2 = o7.m0.f8288a;
                    Object C = o7.c0.C(new l0(n0Var, cVar, i6), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                    }
                } else if (i12 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
        }
        return xVar;
    }
}
