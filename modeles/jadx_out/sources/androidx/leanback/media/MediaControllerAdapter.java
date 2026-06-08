package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.f;
import android.support.v4.media.session.k;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MediaControllerAdapter extends PlayerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaControllerAdapter";
    private k mController;
    Handler mHandler = new Handler();
    private final Runnable mPositionUpdaterRunnable = new Runnable() { // from class: androidx.leanback.media.MediaControllerAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            MediaControllerAdapter.this.mHandler.postDelayed(this, r0.getUpdatePeriod());
        }
    };
    boolean mIsBuffering = false;
    f mMediaControllerCallback = new f() { // from class: androidx.leanback.media.MediaControllerAdapter.2
        @Override // android.support.v4.media.session.f
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerAdapter.this.getCallback().onMetadataChanged(MediaControllerAdapter.this);
        }

        @Override // android.support.v4.media.session.f
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
            if (mediaControllerAdapter.mIsBuffering && playbackStateCompat.f264a != 6) {
                mediaControllerAdapter.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, false);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.mIsBuffering = false;
            }
            int i = playbackStateCompat.f264a;
            int i6 = playbackStateCompat.f269o;
            CharSequence charSequence = playbackStateCompat.f270p;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                MediaControllerAdapter.this.getCallback().onPlayCompleted(MediaControllerAdapter.this);
                return;
            }
            if (i == 2) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i == 3) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i == 6) {
                MediaControllerAdapter mediaControllerAdapter2 = MediaControllerAdapter.this;
                mediaControllerAdapter2.mIsBuffering = true;
                mediaControllerAdapter2.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, true);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i == 7) {
                MediaControllerAdapter mediaControllerAdapter3 = MediaControllerAdapter.this;
                if (charSequence == null) {
                    mediaControllerAdapter3.getCallback().onError(MediaControllerAdapter.this, i6, "");
                    return;
                } else {
                    mediaControllerAdapter3.getCallback().onError(MediaControllerAdapter.this, i6, charSequence.toString());
                    return;
                }
            }
            if (i == 4) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            } else if (i == 5) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            }
        }
    };

    public MediaControllerAdapter(k kVar) {
        a.i("Object of MediaControllerCompat is null");
        throw null;
    }

    private int mapRepeatActionToRepeatMode(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 2 ? -1 : 1;
        }
        return 2;
    }

    private int mapShuffleActionToShuffleMode(int i) {
        if (i != 0) {
            return i != 1 ? -1 : 1;
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void fastForward() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        if (this.mController.b() == null) {
            return 0L;
        }
        return this.mController.b().f266l;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.mController.b() == null) {
            return 0L;
        }
        return this.mController.b().f265b;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        throw null;
    }

    public Drawable getMediaArt(Context context) {
        throw null;
    }

    public k getMediaController() {
        return this.mController;
    }

    public CharSequence getMediaSubtitle() {
        throw null;
    }

    public CharSequence getMediaTitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getSupportedActions() {
        if (this.mController.b() == null) {
            return 0L;
        }
        long j = this.mController.b().f268n;
        long j6 = (j & 512) != 0 ? 64L : 0L;
        if ((j & 32) != 0) {
            j6 |= 256;
        }
        if ((j & 16) != 0) {
            j6 |= 16;
        }
        if ((64 & j) != 0) {
            j6 |= 128;
        }
        if ((8 & j) != 0) {
            j6 |= 32;
        }
        if ((262144 & j) != 0) {
            j6 |= 512;
        }
        return (j & 2097152) != 0 ? 1024 | j6 : j6;
    }

    public int getUpdatePeriod() {
        return 16;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        if (this.mController.b() == null) {
            return false;
        }
        return this.mController.b().f264a == 3 || this.mController.b().f264a == 4 || this.mController.b().f264a == 5;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void next() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        this.mController.c(this.mMediaControllerCallback);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void previous() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void rewind() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j) {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z9) {
        this.mHandler.removeCallbacks(this.mPositionUpdaterRunnable);
        if (z9) {
            this.mHandler.postDelayed(this.mPositionUpdaterRunnable, getUpdatePeriod());
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setRepeatAction(int i) {
        mapRepeatActionToRepeatMode(i);
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setShuffleAction(int i) {
        mapShuffleActionToShuffleMode(i);
        throw null;
    }
}
