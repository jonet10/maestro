package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger.get().debug(TAG, "Requesting diagnostics");
        try {
            WorkManager.getInstance(context).enqueue(OneTimeWorkRequest.from((Class<? extends ListenableWorker>) DiagnosticsWorker.class));
        } catch (IllegalStateException e10) {
            Logger.get().error(TAG, "WorkManager is not initialized", e10);
        }
    }
}
