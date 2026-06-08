package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import j$.time.Duration;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(26)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(Duration duration) {
        duration.getClass();
        return duration.toMillis();
    }
}
