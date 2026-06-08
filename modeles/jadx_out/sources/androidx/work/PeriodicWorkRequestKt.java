package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import j$.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PeriodicWorkRequestKt {
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j6, TimeUnit timeUnit2) {
        timeUnit.getClass();
        timeUnit2.getClass();
        l.h();
        throw null;
    }

    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        l.h();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        duration.getClass();
        l.h();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        duration.getClass();
        duration2.getClass();
        l.h();
        throw null;
    }
}
