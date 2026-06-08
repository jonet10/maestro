package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f281b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Looper looper) {
        super(looper);
        this.f281b = fVar;
        this.f280a = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f280a) {
            int i = message.what;
            f fVar = this.f281b;
            switch (i) {
                case 1:
                    Bundle data = message.getData();
                    m.a(data);
                    fVar.onSessionEvent((String) message.obj, data);
                    break;
                case 2:
                    fVar.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                    break;
                case 3:
                    fVar.onMetadataChanged((MediaMetadataCompat) message.obj);
                    break;
                case 4:
                    fVar.onAudioInfoChanged((j) message.obj);
                    break;
                case 5:
                    fVar.onQueueChanged((List) message.obj);
                    break;
                case 6:
                    fVar.onQueueTitleChanged((CharSequence) message.obj);
                    break;
                case 7:
                    Bundle bundle = (Bundle) message.obj;
                    m.a(bundle);
                    fVar.onExtrasChanged(bundle);
                    break;
                case 8:
                    fVar.onSessionDestroyed();
                    break;
                case 9:
                    fVar.onRepeatModeChanged(((Integer) message.obj).intValue());
                    break;
                case 11:
                    fVar.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                    break;
                case 12:
                    fVar.onShuffleModeChanged(((Integer) message.obj).intValue());
                    break;
                case 13:
                    fVar.onSessionReady();
                    break;
            }
        }
    }
}
