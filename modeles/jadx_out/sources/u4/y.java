package u4;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PublicProfileActivity;
import x4.k2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10660a;

    /* renamed from: b, reason: collision with root package name */
    public int f10661b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f0 f10662l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k2 f10663m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(f0 f0Var, k2 k2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10660a = i;
        this.f10662l = f0Var;
        this.f10663m = k2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10660a) {
            case 0:
                return new y(this.f10662l, this.f10663m, cVar, 0);
            default:
                return new y(this.f10662l, this.f10663m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10660a) {
            case 0:
                ((y) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            default:
                return ((y) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i = this.f10660a;
        k2 k2Var = this.f10663m;
        Object obj3 = u6.a.f10762a;
        f0 f0Var = this.f10662l;
        switch (i) {
            case 0:
                int i6 = this.f10661b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.o0 o0Var = f0Var.G().f10640x;
                c4.a0 a0Var = new c4.a0(3, f0Var, k2Var);
                this.f10661b = 1;
                o0Var.collect(a0Var, this);
                return obj3;
            default:
                int i10 = this.f10661b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    s4.x xVar = new s4.x(requireContext);
                    String str = k2Var.f11259b;
                    str.getClass();
                    this.f10661b = 1;
                    Object a8 = xVar.a(str, this);
                    obj2 = a8;
                    if (a8 == obj3) {
                        return obj3;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    obj2 = ((p6.k) obj).f8444a;
                }
                if (!(obj2 instanceof p6.j)) {
                    new android.support.v4.media.g(f0Var.requireContext(), 20).E(k0.k.e("source", "app_details"), "profile-open");
                    Intent intent = new Intent(f0Var.requireContext(), (Class<?>) PublicProfileActivity.class);
                    intent.putExtra("user", (w2) obj2);
                    float f = UptodownApp.I;
                    FragmentActivity requireActivity = f0Var.requireActivity();
                    requireActivity.getClass();
                    f0Var.startActivity(intent, b4.d.a(requireActivity));
                }
                if (p6.k.a(obj2) != null && f0Var.getActivity() != null) {
                    FragmentActivity activity = f0Var.getActivity();
                    activity.getClass();
                    String string = f0Var.getString(2131951998);
                    string.getClass();
                    ((c4.k0) activity).A(string);
                }
                return p6.x.f8463a;
        }
    }
}
