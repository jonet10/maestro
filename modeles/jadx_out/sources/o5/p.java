package o5;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.workers.UploadFileWorker;
import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p {
    public static void a(Context context, String str) {
        context.getClass();
        Object systemService = context.getSystemService("display");
        systemService.getClass();
        kotlin.jvm.internal.b d10 = a0.d(((DisplayManager) systemService).getDisplays());
        while (d10.hasNext()) {
            if (((Display) d10.next()).getState() != 1) {
                return;
            }
        }
        float f = UptodownApp.I;
        if (b4.d.p(context, "UploadFileWorker")) {
            return;
        }
        OneTimeWorkRequest.Builder builder = (OneTimeWorkRequest.Builder) androidx.lifecycle.l.t(UploadFileWorker.class, "UploadFileWorker");
        if (str != null) {
            builder.setInputData(new Data.Builder().putString("sha256", str).build());
        }
        WorkManager.Companion.getInstance(context).enqueue(builder.build());
    }
}
