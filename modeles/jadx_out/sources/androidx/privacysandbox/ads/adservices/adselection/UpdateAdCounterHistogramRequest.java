package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext8OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UpdateAdCounterHistogramRequest {
    private final int adEventType;
    private final long adSelectionId;
    private final AdTechIdentifier callerAdTech;

    public UpdateAdCounterHistogramRequest(long j, int i, AdTechIdentifier adTechIdentifier) {
        adTechIdentifier.getClass();
        this.adSelectionId = j;
        this.adEventType = i;
        this.callerAdTech = adTechIdentifier;
        if (i == 0) {
            com.google.gson.internal.a.p("Win event types cannot be manually updated.");
            throw null;
        }
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        com.google.gson.internal.a.p("Ad event type must be one of AD_EVENT_TYPE_IMPRESSION, AD_EVENT_TYPE_VIEW, or AD_EVENT_TYPE_CLICK");
        throw null;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.UpdateAdCounterHistogramRequest convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.UpdateAdCounterHistogramRequest build = new UpdateAdCounterHistogramRequest.Builder(this.adSelectionId, this.adEventType, this.callerAdTech.convertToAdServices$ads_adservices_release()).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) obj;
        return this.adSelectionId == updateAdCounterHistogramRequest.adSelectionId && this.adEventType == updateAdCounterHistogramRequest.adEventType && l.a(this.callerAdTech, updateAdCounterHistogramRequest.callerAdTech);
    }

    public final int getAdEventType() {
        return this.adEventType;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final AdTechIdentifier getCallerAdTech() {
        return this.callerAdTech;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.callerAdTech.hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + this.adEventType) * 31);
    }

    public String toString() {
        int i = this.adEventType;
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.adSelectionId + ", adEventType=" + (i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Invalid ad event type" : "AD_EVENT_TYPE_CLICK" : "AD_EVENT_TYPE_VIEW" : "AD_EVENT_TYPE_IMPRESSION" : "AD_EVENT_TYPE_WIN") + ", callerAdTech=" + this.callerAdTech;
    }
}
