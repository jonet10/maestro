package c4;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f1359b;

    public /* synthetic */ a(AppDetailActivity appDetailActivity, int i) {
        this.f1358a = i;
        this.f1359b = appDetailActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        int i = this.f1358a;
        AppDetailActivity appDetailActivity = this.f1359b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i) {
            case 0:
                int i6 = AppDetailActivity.X;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(appDetailActivity);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, v7.d.f10884a, null, new b.s(appDetailActivity, (t6.c) null, 2), 2);
                break;
            case 1:
                int i10 = AppDetailActivity.X;
                if (activityResult.getResultCode() == -1) {
                    r7.o0 o0Var = appDetailActivity.P;
                    Intent data = activityResult.getData();
                    Boolean valueOf = Boolean.valueOf(data != null ? data.getBooleanExtra("wishlistChanged", false) : false);
                    o0Var.getClass();
                    o0Var.g(null, valueOf);
                    r7.o0 o0Var2 = appDetailActivity.Q;
                    Intent data2 = activityResult.getData();
                    Boolean valueOf2 = Boolean.valueOf(data2 != null ? data2.getBooleanExtra("recommendedAppsChanged", false) : false);
                    o0Var2.getClass();
                    o0Var2.g(null, valueOf2);
                    break;
                }
                break;
            default:
                int i11 = AppDetailActivity.X;
                if (activityResult.getResultCode() == -1) {
                    float f = UptodownApp.I;
                    b4.d.F(appDetailActivity);
                    break;
                }
                break;
        }
    }
}
