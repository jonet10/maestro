package androidx.privacysandbox.ads.adservices.signals;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext12OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UpdateSignalsRequest {
    private final Uri updateUri;

    public UpdateSignalsRequest(Uri uri) {
        uri.getClass();
        this.updateUri = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateSignalsRequest) {
            return l.a(this.updateUri, ((UpdateSignalsRequest) obj).updateUri);
        }
        return false;
    }

    public final Uri getUpdateUri() {
        return this.updateUri;
    }

    public int hashCode() {
        return this.updateUri.hashCode();
    }

    public String toString() {
        return "UpdateSignalsRequest: updateUri=" + this.updateUri;
    }
}
