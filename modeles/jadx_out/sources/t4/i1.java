package t4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9893a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f9894b;

    /* renamed from: l, reason: collision with root package name */
    public final YouTubePlayerView f9895l;

    public i1(RelativeLayout relativeLayout, FrameLayout frameLayout, YouTubePlayerView youTubePlayerView) {
        this.f9893a = relativeLayout;
        this.f9894b = frameLayout;
        this.f9895l = youTubePlayerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9893a;
    }
}
