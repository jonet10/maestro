package androidx.leanback.app;

import android.view.SurfaceHolder;
import androidx.leanback.media.SurfaceHolderGlueHost;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class VideoSupportFragmentGlueHost extends PlaybackSupportFragmentGlueHost implements SurfaceHolderGlueHost {
    private final VideoSupportFragment mFragment;

    public VideoSupportFragmentGlueHost(VideoSupportFragment videoSupportFragment) {
        super(videoSupportFragment);
        this.mFragment = videoSupportFragment;
    }

    @Override // androidx.leanback.media.SurfaceHolderGlueHost
    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.mFragment.setSurfaceHolderCallback(callback);
    }
}
