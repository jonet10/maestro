package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PersistAdSelectionResultRequest {
    private final long adSelectionId;
    private final byte[] adSelectionResult;
    private final AdTechIdentifier seller;

    public /* synthetic */ PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr, int i, g gVar) {
        this(j, (i & 2) != 0 ? null : adTechIdentifier, (i & 4) != 0 ? null : bArr);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        PersistAdSelectionResultRequest.Builder adSelectionId = new PersistAdSelectionResultRequest.Builder().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier = this.seller;
        android.adservices.adselection.PersistAdSelectionResultRequest build = adSelectionId.setSeller(adTechIdentifier != null ? adTechIdentifier.convertToAdServices$ads_adservices_release() : null).setAdSelectionResult(this.adSelectionResult).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        return this.adSelectionId == persistAdSelectionResultRequest.adSelectionId && l.a(this.seller, persistAdSelectionResultRequest.seller) && Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        AdTechIdentifier adTechIdentifier = this.seller;
        int hashCode = (i + (adTechIdentifier != null ? adTechIdentifier.hashCode() : 0)) * 31;
        byte[] bArr = this.adSelectionResult;
        return hashCode + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    public PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier) {
        this(j, adTechIdentifier, null, 4, null);
    }

    public PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr) {
        this.adSelectionId = j;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    public PersistAdSelectionResultRequest(long j) {
        this(j, null, null, 6, null);
    }
}
