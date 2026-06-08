package g5;

import android.content.Context;
import androidx.leanback.widget.Presenter;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import e1.s0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f5365a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f5366b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5367l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f5368m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TvMyAppsFragment tvMyAppsFragment, long j, Presenter.ViewHolder viewHolder, t6.c cVar) {
        super(2, cVar);
        this.f5366b = tvMyAppsFragment;
        this.f5367l = j;
        this.f5368m = viewHolder;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new z(this.f5366b, this.f5367l, this.f5368m, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object a8;
        int i = this.f5365a;
        TvMyAppsFragment tvMyAppsFragment = this.f5366b;
        if (i == 0) {
            p6.a.e(obj);
            Context requireContext = tvMyAppsFragment.requireContext();
            requireContext.getClass();
            s0 s0Var = new s0(requireContext, this.f5367l);
            this.f5365a = 1;
            a8 = s0Var.a(this);
            u6.a aVar = u6.a.f10762a;
            if (a8 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
            a8 = ((p6.k) obj).f8444a;
        }
        if (!(a8 instanceof p6.j)) {
            x4.g gVar = (x4.g) a8;
            if (tvMyAppsFragment.getActivity() != null) {
                f5.a aVar2 = (f5.a) tvMyAppsFragment.getActivity();
                aVar2.getClass();
                aVar2.j(gVar, this.f5368m);
            }
        }
        return p6.x.f8463a;
    }
}
