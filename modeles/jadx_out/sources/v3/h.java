package v3;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final z3.f f10844a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f10845b = new Handler(Looper.getMainLooper());

    public h(z3.f fVar) {
        this.f10844a = fVar;
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.f10845b.post(new g(this, 4));
    }

    @JavascriptInterface
    public final void sendError(String str) {
        c cVar;
        str.getClass();
        if (str.equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_2D)) {
            cVar = c.f10826b;
        } else if (str.equalsIgnoreCase("5")) {
            cVar = c.f10827l;
        } else if (str.equalsIgnoreCase("100")) {
            cVar = c.f10828m;
        } else {
            cVar = (str.equalsIgnoreCase("101") || str.equalsIgnoreCase("150")) ? c.f10829n : str.equalsIgnoreCase("153") ? c.f10830o : c.f10825a;
        }
        this.f10845b.post(new androidx.browser.trusted.c(26, this, cVar));
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String str) {
        str.getClass();
        this.f10845b.post(new g(this, str.equalsIgnoreCase("small") ? a.f10807b : str.equalsIgnoreCase("medium") ? a.f10808l : str.equalsIgnoreCase("large") ? a.f10809m : str.equalsIgnoreCase("hd720") ? a.f10810n : str.equalsIgnoreCase("hd1080") ? a.f10811o : str.equalsIgnoreCase("highres") ? a.f10812p : str.equalsIgnoreCase("default") ? a.f10813q : a.f10806a, 1));
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String str) {
        str.getClass();
        this.f10845b.post(new g(this, str.equalsIgnoreCase("0.25") ? b.f10816b : str.equalsIgnoreCase("0.5") ? b.f10817l : str.equalsIgnoreCase("0.75") ? b.f10818m : str.equalsIgnoreCase("1") ? b.f10819n : str.equalsIgnoreCase("1.25") ? b.f10820o : str.equalsIgnoreCase("1.5") ? b.f10821p : str.equalsIgnoreCase("1.75") ? b.f10822q : str.equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_2D) ? b.f10823r : b.f10815a, 3));
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.f10845b.post(new g(this, 5));
    }

    @JavascriptInterface
    public final void sendStateChange(String str) {
        str.getClass();
        this.f10845b.post(new androidx.browser.trusted.c(27, this, str.equalsIgnoreCase("UNSTARTED") ? d.f10833b : str.equalsIgnoreCase("ENDED") ? d.f10834l : str.equalsIgnoreCase("PLAYING") ? d.f10835m : str.equalsIgnoreCase("PAUSED") ? d.f10836n : str.equalsIgnoreCase("BUFFERING") ? d.f10837o : str.equalsIgnoreCase("CUED") ? d.f10838p : d.f10832a));
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String str) {
        str.getClass();
        try {
            final float parseFloat = Float.parseFloat(str);
            this.f10845b.post(new Runnable() { // from class: v3.f
                @Override // java.lang.Runnable
                public final void run() {
                    z3.f fVar = h.this.f10844a;
                    Iterator<T> it = fVar.getListeners().iterator();
                    while (it.hasNext()) {
                        ((w3.a) it.next()).a(fVar.getInstance(), parseFloat);
                    }
                }
            });
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String str) {
        str.getClass();
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.f10845b.post(new g(this, Float.parseFloat(str), 2));
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(String str) {
        str.getClass();
        return this.f10845b.post(new androidx.browser.trusted.c(25, this, str));
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String str) {
        str.getClass();
        try {
            this.f10845b.post(new g(this, Float.parseFloat(str), 6));
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.f10845b.post(new g(this, 0));
    }
}
