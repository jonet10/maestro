package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.customaudience.a;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class GetTopicsRequest {
    private final String adsSdkName;
    private final boolean shouldRecordObservation;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        private String adsSdkName = "";
        private boolean shouldRecordObservation = true;

        public final GetTopicsRequest build() {
            return new GetTopicsRequest(this.adsSdkName, this.shouldRecordObservation);
        }

        public final Builder setAdsSdkName(String str) {
            str.getClass();
            if (str.length() > 0) {
                this.adsSdkName = str;
                return this;
            }
            a.i("adsSdkName must be set");
            return null;
        }

        public final Builder setShouldRecordObservation(boolean z9) {
            this.shouldRecordObservation = z9;
            return this;
        }
    }

    public /* synthetic */ GetTopicsRequest(String str, boolean z9, int i, g gVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        return l.a(this.adsSdkName, getTopicsRequest.adsSdkName) && this.shouldRecordObservation == getTopicsRequest.shouldRecordObservation;
    }

    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public int hashCode() {
        return (this.adsSdkName.hashCode() * 31) + (this.shouldRecordObservation ? 1231 : 1237);
    }

    public final boolean shouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public GetTopicsRequest(String str, boolean z9) {
        str.getClass();
        this.adsSdkName = str;
        this.shouldRecordObservation = z9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetTopicsRequest() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }
}
