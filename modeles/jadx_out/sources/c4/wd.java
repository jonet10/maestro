package c4;

import android.view.KeyEvent;
import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.activities.YouTubeActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class wd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2281a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f2282b;

    public /* synthetic */ wd(KeyEvent.Callback callback, int i) {
        this.f2281a = i;
        this.f2282b = callback;
    }

    public final void a(View view, w6 w6Var) {
        int i = this.f2281a;
        int i6 = 0;
        KeyEvent.Callback callback = this.f2282b;
        switch (i) {
            case 0:
                YouTubeActivity youTubeActivity = (YouTubeActivity) callback;
                int i10 = YouTubeActivity.Q;
                youTubeActivity.y0().f9895l.setVisibility(8);
                youTubeActivity.y0().f9894b.setVisibility(0);
                youTubeActivity.y0().f9894b.addView(view);
                break;
            default:
                ArrayList arrayList = ((YouTubePlayerView) callback).f3284a;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    while (i6 < size) {
                        Object obj = arrayList.get(i6);
                        i6++;
                        ((wd) obj).a(view, w6Var);
                    }
                    break;
                } else {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("To enter fullscreen you need to first register a FullscreenListener.");
                    break;
                }
        }
    }

    public final void b() {
        int i = this.f2281a;
        int i6 = 0;
        KeyEvent.Callback callback = this.f2282b;
        switch (i) {
            case 0:
                YouTubeActivity youTubeActivity = (YouTubeActivity) callback;
                int i10 = YouTubeActivity.Q;
                youTubeActivity.y0().f9895l.setVisibility(0);
                youTubeActivity.y0().f9894b.setVisibility(8);
                youTubeActivity.y0().f9894b.removeAllViews();
                break;
            default:
                ArrayList arrayList = ((YouTubePlayerView) callback).f3284a;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    while (i6 < size) {
                        Object obj = arrayList.get(i6);
                        i6++;
                        ((wd) obj).b();
                    }
                    break;
                } else {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("To enter fullscreen you need to first register a FullscreenListener.");
                    break;
                }
        }
    }
}
