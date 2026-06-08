package c4;

import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class t5 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2118a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2119b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2120l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2121m;

    public /* synthetic */ t5(int i, Object obj, int i6, Object obj2) {
        this.f2118a = i6;
        this.f2120l = obj;
        this.f2121m = obj2;
        this.f2119b = i;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f2118a;
        p6.x xVar = p6.x.f8463a;
        Object obj = this.f2121m;
        Object obj2 = this.f2120l;
        switch (i) {
            case 0:
                File file = (File) obj2;
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj;
                int i6 = NotificationsRegistryActivity.T;
                if (file.delete()) {
                    String string = notificationsRegistryActivity.getString(2131952610, file.getName());
                    string.getClass();
                    notificationsRegistryActivity.A(string);
                    o7.c0.s(LifecycleOwnerKt.getLifecycleScope(notificationsRegistryActivity), v7.d.f10884a, null, new b.e(notificationsRegistryActivity, this.f2119b, null, 1), 2);
                    break;
                }
                break;
            case 1:
                RecommendedActivity recommendedActivity = (RecommendedActivity) obj2;
                x4.a3 a3Var = (x4.a3) obj;
                int i10 = RecommendedActivity.f3338g0;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    o7.c0.s(LifecycleOwnerKt.getLifecycleScope(recommendedActivity), null, null, new m(recommendedActivity, a3Var, this.f2119b, null, 3), 3);
                    break;
                }
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) obj2;
                x4.a3 a3Var2 = (x4.a3) obj;
                int i11 = WishlistActivity.f3367g0;
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    o7.c0.s(LifecycleOwnerKt.getLifecycleScope(wishlistActivity), null, null, new m(wishlistActivity, a3Var2, this.f2119b, null, 5), 3);
                    break;
                }
                break;
        }
        return xVar;
    }
}
