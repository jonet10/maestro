package androidx.leanback.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.leanback.R;
import androidx.leanback.media.PlayerAdapter;
import com.google.gson.internal.a;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MediaPlayerAdapter extends PlayerAdapter {
    long mBufferedProgress;
    boolean mBufferingStart;
    Context mContext;
    boolean mHasDisplay;
    SurfaceHolderGlueHost mSurfaceHolderGlueHost;
    final MediaPlayer mPlayer = new MediaPlayer();
    final Runnable mRunnable = new Runnable() { // from class: androidx.leanback.media.MediaPlayerAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAdapter.this.getCallback().onCurrentPositionChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter.this.mHandler.postDelayed(this, r0.getProgressUpdatingInterval());
        }
    };
    final Handler mHandler = new Handler();
    boolean mInitialized = false;
    Uri mMediaSourceUri = null;
    MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.2
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mInitialized = true;
            mediaPlayerAdapter.notifyBufferingStartEnd();
            MediaPlayerAdapter mediaPlayerAdapter2 = MediaPlayerAdapter.this;
            if (mediaPlayerAdapter2.mSurfaceHolderGlueHost == null || mediaPlayerAdapter2.mHasDisplay) {
                mediaPlayerAdapter2.getCallback().onPreparedStateChanged(MediaPlayerAdapter.this);
            }
        }
    };
    final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.3
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.getCallback().onPlayStateChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter.this.getCallback().onPlayCompleted(MediaPlayerAdapter.this);
        }
    };
    final MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.4
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mBufferedProgress = (mediaPlayerAdapter.getDuration() * i) / 100;
            MediaPlayerAdapter.this.getCallback().onBufferedPositionChanged(MediaPlayerAdapter.this);
        }
    };
    final MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.5
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i6) {
            MediaPlayerAdapter.this.getCallback().onVideoSizeChanged(MediaPlayerAdapter.this, i, i6);
        }
    };
    final MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.6
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i6) {
            PlayerAdapter.Callback callback = MediaPlayerAdapter.this.getCallback();
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            callback.onError(mediaPlayerAdapter, i, mediaPlayerAdapter.mContext.getString(R.string.lb_media_player_error, Integer.valueOf(i), Integer.valueOf(i6)));
            return MediaPlayerAdapter.this.onError(i, i6);
        }
    };
    final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.7
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.onSeekComplete();
        }
    };
    final MediaPlayer.OnInfoListener mOnInfoListener = new MediaPlayer.OnInfoListener() { // from class: androidx.leanback.media.MediaPlayerAdapter.8
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i6) {
            boolean z9;
            if (i == 701) {
                MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
                mediaPlayerAdapter.mBufferingStart = true;
                mediaPlayerAdapter.notifyBufferingStartEnd();
            } else {
                if (i != 702) {
                    z9 = false;
                    return !z9 || MediaPlayerAdapter.this.onInfo(i, i6);
                }
                MediaPlayerAdapter mediaPlayerAdapter2 = MediaPlayerAdapter.this;
                mediaPlayerAdapter2.mBufferingStart = false;
                mediaPlayerAdapter2.notifyBufferingStartEnd();
            }
            z9 = true;
            if (z9) {
            }
        }
    };

    public MediaPlayerAdapter(Context context) {
        this.mContext = context;
    }

    private void prepareMediaForPlaying() {
        reset();
        try {
            Uri uri = this.mMediaSourceUri;
            if (uri != null) {
                this.mPlayer.setDataSource(this.mContext, uri);
                this.mPlayer.setAudioStreamType(3);
                this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
                this.mPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
                this.mPlayer.setOnErrorListener(this.mOnErrorListener);
                this.mPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                this.mPlayer.setOnCompletionListener(this.mOnCompletionListener);
                this.mPlayer.setOnInfoListener(this.mOnInfoListener);
                this.mPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
                notifyBufferingStartEnd();
                this.mPlayer.prepareAsync();
                getCallback().onPlayStateChanged(this);
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            a.k(e10);
        }
    }

    public void changeToUnitialized() {
        if (this.mInitialized) {
            this.mInitialized = false;
            notifyBufferingStartEnd();
            if (this.mHasDisplay) {
                getCallback().onPreparedStateChanged(this);
            }
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        return this.mBufferedProgress;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.mInitialized) {
            return this.mPlayer.getCurrentPosition();
        }
        return -1L;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.mInitialized) {
            return this.mPlayer.getDuration();
        }
        return -1L;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }

    public int getProgressUpdatingInterval() {
        return 16;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        return this.mInitialized && this.mPlayer.isPlaying();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPrepared() {
        if (this.mInitialized) {
            return this.mSurfaceHolderGlueHost == null || this.mHasDisplay;
        }
        return false;
    }

    public void notifyBufferingStartEnd() {
        getCallback().onBufferingStateChanged(this, this.mBufferingStart || !this.mInitialized);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            SurfaceHolderGlueHost surfaceHolderGlueHost = (SurfaceHolderGlueHost) playbackGlueHost;
            this.mSurfaceHolderGlueHost = surfaceHolderGlueHost;
            surfaceHolderGlueHost.setSurfaceHolderCallback(new VideoPlayerSurfaceHolderCallback());
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        SurfaceHolderGlueHost surfaceHolderGlueHost = this.mSurfaceHolderGlueHost;
        if (surfaceHolderGlueHost != null) {
            surfaceHolderGlueHost.setSurfaceHolderCallback(null);
            this.mSurfaceHolderGlueHost = null;
        }
        reset();
        release();
    }

    public boolean onError(int i, int i6) {
        return false;
    }

    public boolean onInfo(int i, int i6) {
        return false;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        if (isPlaying()) {
            this.mPlayer.pause();
            getCallback().onPlayStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        if (!this.mInitialized || this.mPlayer.isPlaying()) {
            return;
        }
        this.mPlayer.start();
        getCallback().onPlayStateChanged(this);
        getCallback().onCurrentPositionChanged(this);
    }

    public void release() {
        changeToUnitialized();
        this.mHasDisplay = false;
        this.mPlayer.release();
    }

    public void reset() {
        changeToUnitialized();
        this.mPlayer.reset();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j) {
        if (this.mInitialized) {
            this.mPlayer.seekTo((int) j);
        }
    }

    public boolean setDataSource(Uri uri) {
        Uri uri2 = this.mMediaSourceUri;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.mMediaSourceUri = uri;
        prepareMediaForPlaying();
        return true;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        boolean z9 = this.mHasDisplay;
        boolean z10 = surfaceHolder != null;
        this.mHasDisplay = z10;
        if (z9 == z10) {
            return;
        }
        this.mPlayer.setDisplay(surfaceHolder);
        boolean z11 = this.mHasDisplay;
        boolean z12 = this.mInitialized;
        if (z11) {
            if (z12) {
                getCallback().onPreparedStateChanged(this);
            }
        } else if (z12) {
            getCallback().onPreparedStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z9) {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (z9) {
            this.mHandler.postDelayed(this.mRunnable, getProgressUpdatingInterval());
        }
    }

    public void onSeekComplete() {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class VideoPlayerSurfaceHolderCallback implements SurfaceHolder.Callback {
        public VideoPlayerSurfaceHolderCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay(null);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i6, int i10) {
        }
    }
}
