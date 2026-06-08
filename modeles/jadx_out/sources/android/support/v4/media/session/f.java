package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class f implements IBinder.DeathRecipient {
    final Object mCallbackObj = new l(new f0.i(this));
    e mHandler;
    a mIControllerCallback;

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        postToHandler(8, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a getIControllerCallback() {
        return this.mIControllerCallback;
    }

    public abstract void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

    public abstract void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat);

    public void postToHandler(int i, Object obj, Bundle bundle) {
        e eVar = this.mHandler;
        if (eVar != null) {
            Message obtainMessage = eVar.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void setHandler(Handler handler) {
        if (handler != null) {
            e eVar = new e(this, handler.getLooper());
            this.mHandler = eVar;
            eVar.f280a = true;
        } else {
            e eVar2 = this.mHandler;
            if (eVar2 != null) {
                eVar2.f280a = false;
                eVar2.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        }
    }

    public void onSessionDestroyed() {
    }

    public void onSessionReady() {
    }

    public void onAudioInfoChanged(j jVar) {
    }

    public void onCaptioningEnabledChanged(boolean z9) {
    }

    public void onExtrasChanged(Bundle bundle) {
    }

    public void onQueueChanged(List<MediaSessionCompat$QueueItem> list) {
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onShuffleModeChanged(int i) {
    }

    public void onSessionEvent(String str, Bundle bundle) {
    }
}
