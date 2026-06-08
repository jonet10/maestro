package c4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1442a;

    /* renamed from: b, reason: collision with root package name */
    public int f1443b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1444l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1445m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, long j, t6.c cVar, int i) {
        super(2, cVar);
        this.f1442a = i;
        this.f1445m = obj;
        this.f1444l = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1442a) {
            case 0:
                return new c((AppDetailActivity) this.f1445m, this.f1444l, cVar, 0);
            case 1:
                return new c((FeedActivity) this.f1445m, this.f1444l, cVar, 1);
            default:
                return new c((u4.f1) this.f1445m, this.f1444l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1442a) {
        }
        return ((c) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String message;
        Object obj3;
        Object obj4;
        int i = this.f1442a;
        p6.x xVar = p6.x.f8463a;
        long j = this.f1444l;
        Object obj5 = u6.a.f10762a;
        Object obj6 = this.f1445m;
        switch (i) {
            case 0:
                AppDetailActivity appDetailActivity = (AppDetailActivity) obj6;
                int i6 = this.f1443b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    e1.s0 s0Var = new e1.s0(appDetailActivity, j);
                    this.f1443b = 1;
                    Object a8 = s0Var.a(this);
                    obj2 = a8;
                    if (a8 == obj5) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    obj2 = ((p6.k) obj).f8444a;
                }
                if (!(obj2 instanceof p6.j)) {
                    appDetailActivity.y0((x4.g) obj2);
                }
                Throwable a10 = p6.k.a(obj2);
                if (a10 != null && (message = a10.getMessage()) != null && message.length() != 0) {
                    String message2 = a10.getMessage();
                    message2.getClass();
                    appDetailActivity.A(message2);
                    break;
                }
                break;
            case 1:
                FeedActivity feedActivity = (FeedActivity) obj6;
                int i10 = this.f1443b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    s4.x xVar2 = new s4.x(feedActivity);
                    String valueOf = String.valueOf(j);
                    this.f1443b = 1;
                    Object a11 = xVar2.a(valueOf, this);
                    obj3 = a11;
                    if (a11 == obj5) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    obj3 = ((p6.k) obj).f8444a;
                }
                if (!(obj3 instanceof p6.j)) {
                    int i11 = FeedActivity.S;
                    feedActivity.y0().f9897b.setVisibility(8);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "feed");
                    new android.support.v4.media.g(feedActivity, 20).E(bundle, "profile-open");
                    Intent intent = new Intent(feedActivity, (Class<?>) PublicProfileActivity.class);
                    intent.putExtra("user", (x4.w2) obj3);
                    float f = UptodownApp.I;
                    feedActivity.startActivity(intent, b4.d.a(feedActivity));
                }
                if (p6.k.a(obj3) != null) {
                    int i12 = FeedActivity.S;
                    feedActivity.y0().f9897b.setVisibility(8);
                    break;
                }
                break;
            default:
                u4.f1 f1Var = (u4.f1) obj6;
                int i13 = this.f1443b;
                if (i13 == 0) {
                    p6.a.e(obj);
                    Context requireContext = f1Var.requireContext();
                    requireContext.getClass();
                    s4.x xVar3 = new s4.x(requireContext);
                    String valueOf2 = String.valueOf(j);
                    this.f1443b = 1;
                    Object a12 = xVar3.a(valueOf2, this);
                    obj4 = a12;
                    if (a12 == obj5) {
                        break;
                    }
                } else if (i13 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    obj4 = ((p6.k) obj).f8444a;
                }
                if (!(obj4 instanceof p6.j)) {
                    f1Var.a().f9931o.setVisibility(8);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("source", "feed");
                    new android.support.v4.media.g(f1Var.requireContext(), 20).E(bundle2, "profile-open");
                    Intent intent2 = new Intent(f1Var.requireContext(), (Class<?>) PublicProfileActivity.class);
                    intent2.putExtra("user", (x4.w2) obj4);
                    float f10 = UptodownApp.I;
                    FragmentActivity requireActivity = f1Var.requireActivity();
                    requireActivity.getClass();
                    f1Var.startActivity(intent2, b4.d.a(requireActivity));
                }
                if (p6.k.a(obj4) != null) {
                    f1Var.a().f9931o.setVisibility(8);
                    break;
                }
                break;
        }
        return xVar;
    }
}
