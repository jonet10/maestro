package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import o7.c0;
import o7.e1;
import o7.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkConstraintsTrackerKt {
    private static final long DefaultNetworkRequestTimeoutMs = 1000;
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
    }

    @RequiresApi(28)
    public static final NetworkRequestConstraintController NetworkRequestConstraintController(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("connectivity");
        systemService.getClass();
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0L, 2, null);
    }

    public static final e1 listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, w wVar, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        workConstraintsTracker.getClass();
        workSpec.getClass();
        wVar.getClass();
        onConstraintsStateChangedListener.getClass();
        return c0.s(c0.b(wVar), null, null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, null), 3);
    }
}
