package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.jvm.internal.g;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class AdSelectionManager {
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    public static final AdSelectionManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract Object getAdSelectionData(GetAdSelectionDataRequest getAdSelectionDataRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract Object persistAdSelectionResult(PersistAdSelectionResultRequest persistAdSelectionResultRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract Object reportEvent(ReportEventRequest reportEventRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object reportImpression(ReportImpressionRequest reportImpressionRequest, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract Object selectAds(AdSelectionConfig adSelectionConfig, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract Object selectAds(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, c cVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract Object updateAdCounterHistogram(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, c cVar);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final AdSelectionManager obtain(Context context) {
            context.getClass();
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            if (adServicesInfo.adServicesVersion() >= 4) {
                return new AdSelectionManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (AdSelectionManager) BackCompatManager.INSTANCE.getManager(context, "AdSelectionManager", new AdSelectionManager$Companion$obtain$1(context));
            }
            return null;
        }

        private Companion() {
        }
    }
}
