package q7;

import androidx.leanback.media.MediaPlayerGlue;
import f8.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final m f8753a = new m(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f8754b = t7.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* renamed from: c, reason: collision with root package name */
    public static final int f8755c = t7.a.j(MediaPlayerGlue.FAST_FORWARD_REWIND_STEP, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* renamed from: d, reason: collision with root package name */
    public static final w f8756d = new w("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final w f8757e = new w("SHOULD_BUFFER");
    public static final w f = new w("S_RESUMING_BY_RCV");
    public static final w g = new w("RESUMING_BY_EB");
    public static final w h = new w("POISONED");
    public static final w i = new w("DONE_RCV");
    public static final w j = new w("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final w f8758k = new w("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final w f8759l = new w("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final w f8760m = new w("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final w f8761n = new w("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final w f8762o = new w("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final w f8763p = new w("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final w f8764q = new w("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final w f8765r = new w("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final w f8766s = new w("NO_CLOSE_CAUSE");

    public static final boolean a(o7.j jVar, Object obj, d7.q qVar) {
        w i6 = jVar.i(obj, qVar);
        if (i6 == null) {
            return false;
        }
        jVar.q(i6);
        return true;
    }
}
