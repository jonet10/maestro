package f0;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements LoaderManager.LoaderCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f4812a;

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader onCreateLoader(int i, Bundle bundle) {
        return new d(this.f4812a, i0.g.a());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        SignInHubActivity signInHubActivity = this.f4812a;
        signInHubActivity.setResult(signInHubActivity.f2463m, signInHubActivity.f2464n);
        signInHubActivity.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader loader) {
    }
}
