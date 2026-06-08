package androidx.core.provider;

import android.app.Notification;
import android.app.job.JobInfo;
import android.net.Uri;
import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ Notification.DecoratedMediaCustomViewStyle a() {
        return new Notification.DecoratedMediaCustomViewStyle();
    }

    public static /* synthetic */ JobInfo.TriggerContentUri b(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d(ExecutorService executorService) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z9 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z9) {
                        executorService.shutdownNow();
                        z9 = true;
                    }
                }
            }
            if (z9) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
