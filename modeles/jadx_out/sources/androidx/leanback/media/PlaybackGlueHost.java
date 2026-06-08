package androidx.leanback.media;

import android.view.View;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Row;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class PlaybackGlueHost {
    PlaybackGlue mGlue;

    public final void attachToGlue(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mGlue;
        if (playbackGlue2 != null) {
            playbackGlue2.onDetachedFromHost();
        }
        this.mGlue = playbackGlue;
        if (playbackGlue != null) {
            playbackGlue.onAttachedToHost(this);
        }
    }

    public PlayerCallback getPlayerCallback() {
        return null;
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return false;
    }

    public boolean isControlsOverlayVisible() {
        return true;
    }

    public void setControlsOverlayAutoHideEnabled(boolean z9) {
        setFadingEnabled(z9);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class HostCallback {
        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public void onHostStart() {
        }

        public void onHostStop() {
        }
    }

    @Deprecated
    public void fadeOut() {
    }

    public void notifyPlaybackRowChanged() {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class PlayerCallback {
        public void onBufferingStateChanged(boolean z9) {
        }

        public void onError(int i, CharSequence charSequence) {
        }

        public void onVideoSizeChanged(int i, int i6) {
        }
    }

    public void hideControlsOverlay(boolean z9) {
    }

    @Deprecated
    public void setFadingEnabled(boolean z9) {
    }

    public void setHostCallback(HostCallback hostCallback) {
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
    }

    public void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
    }

    public void setPlaybackRow(Row row) {
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
    }

    public void showControlsOverlay(boolean z9) {
    }
}
