package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AdTechIdentifier {
    private final String identifier;

    public AdTechIdentifier(String str) {
        str.getClass();
        this.identifier = str;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier fromString = android.adservices.common.AdTechIdentifier.fromString(this.identifier);
        fromString.getClass();
        return fromString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTechIdentifier) {
            return l.a(this.identifier, ((AdTechIdentifier) obj).identifier);
        }
        return false;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return String.valueOf(this.identifier);
    }
}
