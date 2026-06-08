package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdSelectionOutcome {
    public static final Companion Companion = new Companion(null);
    public static final AdSelectionOutcome NO_OUTCOME;
    private final long adSelectionId;
    private final Uri renderUri;

    static {
        Uri uri = Uri.EMPTY;
        uri.getClass();
        NO_OUTCOME = new AdSelectionOutcome(0L, uri);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RequiresExtension.Container({@androidx.annotation.RequiresExtension(extension = 1000000, version = 4), @androidx.annotation.RequiresExtension(extension = 31, version = 9)})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AdSelectionOutcome(android.adservices.adselection.AdSelectionOutcome r3) {
        /*
            r2 = this;
            r3.getClass()
            long r0 = r3.getAdSelectionId()
            android.net.Uri r3 = r3.getRenderUri()
            r3.getClass()
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome.<init>(android.adservices.adselection.AdSelectionOutcome):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        return this.adSelectionId == adSelectionOutcome.adSelectionId && l.a(this.renderUri, adSelectionOutcome.renderUri);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    @ExperimentalFeatures.Ext10OptIn
    public final boolean hasOutcome() {
        return !equals(NO_OUTCOME);
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.renderUri.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @ExperimentalFeatures.Ext10OptIn
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        @ExperimentalFeatures.Ext10OptIn
        public static /* synthetic */ void getNO_OUTCOME$annotations() {
        }
    }

    public AdSelectionOutcome(long j, Uri uri) {
        uri.getClass();
        this.adSelectionId = j;
        this.renderUri = uri;
    }
}
