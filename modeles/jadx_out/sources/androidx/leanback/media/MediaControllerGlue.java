package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.f;
import android.support.v4.media.session.k;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class MediaControllerGlue extends PlaybackControlGlue {
    static final boolean DEBUG = false;
    static final String TAG = "MediaControllerGlue";
    private final f mCallback;
    k mMediaController;

    public MediaControllerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.mCallback = new f() { // from class: androidx.leanback.media.MediaControllerGlue.1
            @Override // android.support.v4.media.session.f
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                MediaControllerGlue.this.onMetadataChanged();
            }

            @Override // android.support.v4.media.session.f
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
                MediaControllerGlue.this.onStateChanged();
            }

            @Override // android.support.v4.media.session.f
            public void onSessionDestroyed() {
                MediaControllerGlue.this.mMediaController = null;
            }

            @Override // android.support.v4.media.session.f
            public void onSessionEvent(String str, Bundle bundle) {
            }
        };
    }

    public void detach() {
        this.mMediaController = null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentPosition() {
        return (int) this.mMediaController.b().f265b;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentSpeedId() {
        k kVar = null;
        int i = (int) kVar.b().f267m;
        int i6 = 0;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i > 0) {
            int[] fastForwardSpeeds = getFastForwardSpeeds();
            while (i6 < fastForwardSpeeds.length) {
                if (i == fastForwardSpeeds[i6]) {
                    return i6 + 10;
                }
                i6++;
            }
        } else {
            int[] rewindSpeeds = getRewindSpeeds();
            while (i6 < rewindSpeeds.length) {
                if ((-i) == rewindSpeeds[i6]) {
                    return (-10) - i6;
                }
                i6++;
            }
        }
        l.z(i, "Couldn't find index for speed ", TAG);
        return -1;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public Drawable getMediaArt() {
        throw null;
    }

    public final k getMediaController() {
        return this.mMediaController;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getMediaDuration() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaSubtitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaTitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public long getSupportedActions() {
        long j = this.mMediaController.b().f268n;
        long j6 = (512 & j) != 0 ? 64L : 0L;
        if ((j & 32) != 0) {
            j6 |= 256;
        }
        if ((j & 16) != 0) {
            j6 |= 16;
        }
        if ((64 & j) != 0) {
            j6 |= 128;
        }
        return (j & 8) != 0 ? j6 | 32 : j6;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean hasValidMedia() {
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean isMediaPlaying() {
        return this.mMediaController.b().f264a == 3;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void next() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void play(int i) {
        if (i == 1) {
            throw null;
        }
        if (i <= 0) {
            throw null;
        }
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void previous() {
        throw null;
    }

    public void attachToMediaController(k kVar) {
    }
}
