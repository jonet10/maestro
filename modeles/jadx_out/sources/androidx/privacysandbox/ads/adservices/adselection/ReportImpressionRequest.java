package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ReportImpressionRequest {
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    public ReportImpressionRequest(long j, AdSelectionConfig adSelectionConfig) {
        adSelectionConfig.getClass();
        this.adSelectionId = j;
        this.adSelectionConfig = adSelectionConfig;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportImpressionRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) ? Ext10Impl.Companion.convertReportImpressionRequest(this) : Ext4Impl.Companion.convertReportImpressionRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        return this.adSelectionId == reportImpressionRequest.adSelectionId && l.a(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig);
    }

    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.adSelectionConfig.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        private Ext10Impl() {
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                reportImpressionRequest.getClass();
                if (l.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    b.b();
                    return a.a(reportImpressionRequest.getAdSelectionId());
                }
                b.b();
                return b.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext4Impl {
        public static final Companion Companion = new Companion(null);

        private Ext4Impl() {
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                reportImpressionRequest.getClass();
                if (l.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    a3.b.r("adSelectionConfig is mandatory forAPI versions lower than ext 10");
                    return null;
                }
                b.b();
                return b.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
            }

            private Companion() {
            }
        }
    }

    @ExperimentalFeatures.Ext8OptIn
    public ReportImpressionRequest(long j) {
        this(j, AdSelectionConfig.Companion.getEMPTY());
    }
}
