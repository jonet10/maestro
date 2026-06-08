package g5;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import c4.sc;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5324a;

    /* renamed from: b, reason: collision with root package name */
    public int f5325b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f5326l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(TvAppsListFragment tvAppsListFragment, t6.c cVar, int i) {
        super(2, cVar);
        this.f5324a = i;
        this.f5326l = tvAppsListFragment;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5324a) {
            case 0:
                return new j(this.f5326l, cVar, 0);
            default:
                return new j(this.f5326l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5324a) {
        }
        return ((j) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        g2 g2Var;
        JSONObject jSONObject;
        Resources resources;
        int i = this.f5324a;
        int i6 = 0;
        TvAppsListFragment tvAppsListFragment = this.f5326l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar = p6.x.f8463a;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i10 = this.f5325b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                    tvAppsListFragment.f3430m = true;
                    FragmentActivity requireActivity = tvAppsListFragment.requireActivity();
                    requireActivity.getClass();
                    j5.v vVar = new j5.v(requireActivity);
                    x4.j jVar = tvAppsListFragment.f3428b;
                    if (jVar != null) {
                        int i11 = jVar.f11224a;
                        if (i11 == -2) {
                            g2Var = vVar.m(75, tvAppsListFragment.f3429l);
                        } else if (i11 != -1) {
                            jVar.getClass();
                            boolean z9 = jVar.f11227m;
                            x4.j jVar2 = tvAppsListFragment.f3428b;
                            if (z9) {
                                jVar2.getClass();
                                g2Var = vVar.u(jVar2.f11224a, 75, tvAppsListFragment.f3429l);
                            } else {
                                jVar2.getClass();
                                g2Var = vVar.t(jVar2.f11224a, 75, tvAppsListFragment.f3429l);
                            }
                        } else {
                            g2Var = vVar.s(75, tvAppsListFragment.f3429l);
                        }
                    } else {
                        g2Var = null;
                    }
                    if (g2Var != null && !g2Var.b() && (jSONObject = g2Var.f11206d) != null) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                            xVar2.f7024a = new ArrayList();
                            Context context = tvAppsListFragment.getContext();
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
                                tvAppsListFragment.f3429l++;
                                i6++;
                            }
                        }
                    }
                    v7.e eVar = o7.m0.f8288a;
                    p7.c cVar2 = t7.n.f10348a;
                    sc scVar = new sc(tvAppsListFragment, xVar2, cVar, 12);
                    this.f5325b = 1;
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
                int i12 = this.f5325b;
                if (i12 == 0) {
                    p6.a.e(obj);
                    this.f5325b = 1;
                    v7.e eVar2 = o7.m0.f8288a;
                    Object C = o7.c0.C(new j(tvAppsListFragment, cVar, i6), v7.d.f10884a, this);
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
