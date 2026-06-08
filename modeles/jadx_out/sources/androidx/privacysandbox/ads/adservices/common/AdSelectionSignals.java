package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdSelectionSignals {
    private final String signals;

    public AdSelectionSignals(String str) {
        str.getClass();
        this.signals = str;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdSelectionSignals convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals fromString = android.adservices.common.AdSelectionSignals.fromString(this.signals);
        fromString.getClass();
        return fromString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSelectionSignals) {
            return l.a(this.signals, ((AdSelectionSignals) obj).signals);
        }
        return false;
    }

    public final String getSignals() {
        return this.signals;
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
