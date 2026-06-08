package z3;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import c4.w6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11939a;

    public e(f fVar) {
        this.f11939a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        createBitmap.getClass();
        return createBitmap;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        super.onHideCustomView();
        this.f11939a.f11940a.b();
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        view.getClass();
        customViewCallback.getClass();
        super.onShowCustomView(view, customViewCallback);
        this.f11939a.f11940a.a(view, new w6(customViewCallback, 29));
    }
}
