package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkForegroundKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
    }

    public static final Object workForeground(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor, t6.c cVar) {
        boolean z9 = workSpec.expedited;
        x xVar = x.f8463a;
        if (z9 && Build.VERSION.SDK_INT < 31) {
            Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
            mainThreadExecutor.getClass();
            Object C = c0.C(new WorkForegroundKt$workForeground$2(listenableWorker, workSpec, foregroundUpdater, context, null), c0.m(mainThreadExecutor), cVar);
            if (C == u6.a.f10762a) {
                return C;
            }
        }
        return xVar;
    }
}
