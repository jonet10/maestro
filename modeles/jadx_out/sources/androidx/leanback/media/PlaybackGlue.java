package androidx.leanback.media;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.leanback.media.PlaybackGlueHost;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class PlaybackGlue {
    private final Context mContext;
    private PlaybackGlueHost mPlaybackGlueHost;
    ArrayList<PlayerCallback> mPlayerCallbacks;

    public PlaybackGlue(Context context) {
        this.mContext = context;
    }

    public void addPlayerCallback(PlayerCallback playerCallback) {
        if (this.mPlayerCallbacks == null) {
            this.mPlayerCallbacks = new ArrayList<>();
        }
        this.mPlayerCallbacks.add(playerCallback);
    }

    public Context getContext() {
        return this.mContext;
    }

    public PlaybackGlueHost getHost() {
        return this.mPlaybackGlueHost;
    }

    @SuppressLint({"NullableCollection"})
    public List<PlayerCallback> getPlayerCallbacks() {
        if (this.mPlayerCallbacks == null) {
            return null;
        }
        return new ArrayList(this.mPlayerCallbacks);
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isPrepared() {
        return true;
    }

    @CallSuper
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        this.mPlaybackGlueHost = playbackGlueHost;
        playbackGlueHost.setHostCallback(new PlaybackGlueHost.HostCallback() { // from class: androidx.leanback.media.PlaybackGlue.2
            @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
            public void onHostDestroy() {
                PlaybackGlue.this.setHost(null);
            }

            @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
            public void onHostPause() {
                PlaybackGlue.this.onHostPause();
            }

            @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
            public void onHostResume() {
                PlaybackGlue.this.onHostResume();
            }

            @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
            public void onHostStart() {
                PlaybackGlue.this.onHostStart();
            }

            @Override // androidx.leanback.media.PlaybackGlueHost.HostCallback
            public void onHostStop() {
                PlaybackGlue.this.onHostStop();
            }
        });
    }

    @CallSuper
    public void onDetachedFromHost() {
        PlaybackGlueHost playbackGlueHost = this.mPlaybackGlueHost;
        if (playbackGlueHost != null) {
            playbackGlueHost.setHostCallback(null);
            this.mPlaybackGlueHost = null;
        }
    }

    public void playWhenPrepared() {
        if (isPrepared()) {
            play();
        } else {
            addPlayerCallback(new PlayerCallback() { // from class: androidx.leanback.media.PlaybackGlue.1
                @Override // androidx.leanback.media.PlaybackGlue.PlayerCallback
                public void onPreparedStateChanged(PlaybackGlue playbackGlue) {
                    if (playbackGlue.isPrepared()) {
                        PlaybackGlue.this.removePlayerCallback(this);
                        PlaybackGlue.this.play();
                    }
                }
            });
        }
    }

    public void removePlayerCallback(PlayerCallback playerCallback) {
        ArrayList<PlayerCallback> arrayList = this.mPlayerCallbacks;
        if (arrayList != null) {
            arrayList.remove(playerCallback);
        }
    }

    public final void setHost(PlaybackGlueHost playbackGlueHost) {
        PlaybackGlueHost playbackGlueHost2 = this.mPlaybackGlueHost;
        if (playbackGlueHost2 == playbackGlueHost) {
            return;
        }
        if (playbackGlueHost2 != null) {
            playbackGlueHost2.attachToGlue(null);
        }
        this.mPlaybackGlueHost = playbackGlueHost;
        if (playbackGlueHost != null) {
            playbackGlueHost.attachToGlue(this);
        }
    }

    public void next() {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void onHostStart() {
    }

    public void onHostStop() {
    }

    public void pause() {
    }

    public void play() {
    }

    public void previous() {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class PlayerCallback {
        public void onPlayCompleted(PlaybackGlue playbackGlue) {
        }

        public void onPlayStateChanged(PlaybackGlue playbackGlue) {
        }

        public void onPreparedStateChanged(PlaybackGlue playbackGlue) {
        }
    }
}
