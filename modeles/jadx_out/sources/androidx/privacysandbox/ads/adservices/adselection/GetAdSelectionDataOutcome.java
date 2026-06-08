package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class GetAdSelectionDataOutcome {
    private final byte[] adSelectionData;
    private final long adSelectionId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public GetAdSelectionDataOutcome(android.adservices.adselection.GetAdSelectionDataOutcome getAdSelectionDataOutcome) {
        this(getAdSelectionDataOutcome.getAdSelectionId(), getAdSelectionDataOutcome.getAdSelectionData());
        getAdSelectionDataOutcome.getClass();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        return this.adSelectionId == getAdSelectionDataOutcome.adSelectionId && Arrays.equals(this.adSelectionData, getAdSelectionDataOutcome.adSelectionData);
    }

    public final byte[] getAdSelectionData() {
        return this.adSelectionData;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        byte[] bArr = this.adSelectionData;
        return i + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.adSelectionId + ", adSelectionData=" + this.adSelectionData;
    }

    public GetAdSelectionDataOutcome(long j, byte[] bArr) {
        this.adSelectionId = j;
        this.adSelectionData = bArr;
    }

    public /* synthetic */ GetAdSelectionDataOutcome(long j, byte[] bArr, int i, g gVar) {
        this(j, (i & 2) != 0 ? null : bArr);
    }

    public GetAdSelectionDataOutcome(long j) {
        this(j, null, 2, null);
    }
}
