package androidx.privacysandbox.ads.adservices.adid;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdId {
    private final String adId;
    private final boolean isLimitAdTrackingEnabled;

    public AdId(String str, boolean z9) {
        str.getClass();
        this.adId = str;
        this.isLimitAdTrackingEnabled = z9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdId)) {
            return false;
        }
        AdId adId = (AdId) obj;
        return l.a(this.adId, adId.adId) && this.isLimitAdTrackingEnabled == adId.isLimitAdTrackingEnabled;
    }

    public final String getAdId() {
        return this.adId;
    }

    public int hashCode() {
        return (this.adId.hashCode() * 31) + (this.isLimitAdTrackingEnabled ? 1231 : 1237);
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled;
    }

    public String toString() {
        return "AdId: adId=" + this.adId + ", isLimitAdTrackingEnabled=" + this.isLimitAdTrackingEnabled;
    }

    public /* synthetic */ AdId(String str, boolean z9, int i, g gVar) {
        this(str, (i & 2) != 0 ? false : z9);
    }
}
