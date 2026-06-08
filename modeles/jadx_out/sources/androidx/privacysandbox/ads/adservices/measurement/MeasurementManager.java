package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.jvm.internal.g;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class MeasurementManager {
    public static final Companion Companion = new Companion(null);
    public static final int MEASUREMENT_API_STATE_DISABLED = 0;
    public static final int MEASUREMENT_API_STATE_ENABLED = 1;

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final MeasurementManager obtain(Context context) {
        return Companion.obtain(context);
    }

    public abstract Object deleteRegistrations(DeletionRequest deletionRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object getMeasurementApiStatus(c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerSource(Uri uri, InputEvent inputEvent, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract Object registerSource(SourceRegistrationRequest sourceRegistrationRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerTrigger(Uri uri, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, c cVar);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final MeasurementManager obtain(Context context) {
            context.getClass();
            StringBuilder sb = new StringBuilder("AdServicesInfo.version=");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            sb.append(adServicesInfo.adServicesVersion());
            Log.d("MeasurementManager", sb.toString());
            if (adServicesInfo.adServicesVersion() >= 5) {
                return new MeasurementManagerApi33Ext5Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (MeasurementManager) BackCompatManager.INSTANCE.getManager(context, "MeasurementManager", new MeasurementManager$Companion$obtain$1(context));
            }
            return null;
        }

        private Companion() {
        }
    }
}
