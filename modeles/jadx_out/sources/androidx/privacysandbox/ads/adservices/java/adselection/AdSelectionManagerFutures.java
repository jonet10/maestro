package androidx.privacysandbox.ads.adservices.java.adselection;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import kotlin.jvm.internal.g;
import m1.b;
import o7.c0;
import o7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class AdSelectionManagerFutures {
    public static final Companion Companion = new Companion(null);

    public static final AdSelectionManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract b reportEventAsync(ReportEventRequest reportEventRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b reportImpressionAsync(ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b selectAdsAsync(AdSelectionConfig adSelectionConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract b updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AdSelectionManagerFutures from(Context context) {
            context.getClass();
            AdSelectionManager obtain = AdSelectionManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        private final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest) {
            getAdSelectionDataRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            persistAdSelectionResultRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b reportEventAsync(ReportEventRequest reportEventRequest) {
            reportEventRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b reportImpressionAsync(ReportImpressionRequest reportImpressionRequest) {
            reportImpressionRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b selectAdsAsync(AdSelectionConfig adSelectionConfig) {
            adSelectionConfig.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            updateAdCounterHistogramRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            adSelectionFromOutcomesConfig.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(c0.e(c0.b(m0.f8288a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, null)), null, 1, null);
        }
    }
}
