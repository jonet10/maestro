package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.utils.ProcessUtils;
import o7.a0;
import r7.k0;
import r7.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UnfinishedWorkListenerKt {
    private static final int DELAY_MS = 30000;
    private static final long MAX_DELAY_MS;
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("UnfinishedWorkListener");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
        MAX_DELAY_MS = 3600000L;
    }

    public static final void maybeLaunchUnfinishedWorkListener(a0 a0Var, Context context, Configuration configuration, WorkDatabase workDatabase) {
        a0Var.getClass();
        context.getClass();
        configuration.getClass();
        workDatabase.getClass();
        if (ProcessUtils.isDefaultProcess(context, configuration)) {
            k0.n(new o(k0.h(k0.g(new o(workDatabase.workSpecDao().hasUnfinishedWorkFlow(), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(null), 2))), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(context, null)), a0Var);
        }
    }
}
