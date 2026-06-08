package com.inmobi.cmp.core.model.gbc;

import androidx.annotation.Keep;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class GoogleBasicConsents {
    private final GBCConsentValue adPersonalization;
    private final GBCConsentValue adStorage;
    private final GBCConsentValue adUserData;
    private final GBCConsentValue analyticsStorage;

    public GoogleBasicConsents(GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4) {
        gBCConsentValue.getClass();
        gBCConsentValue2.getClass();
        gBCConsentValue3.getClass();
        gBCConsentValue4.getClass();
        this.adStorage = gBCConsentValue;
        this.adUserData = gBCConsentValue2;
        this.adPersonalization = gBCConsentValue3;
        this.analyticsStorage = gBCConsentValue4;
    }

    public static /* synthetic */ GoogleBasicConsents copy$default(GoogleBasicConsents googleBasicConsents, GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4, int i, Object obj) {
        if ((i & 1) != 0) {
            gBCConsentValue = googleBasicConsents.adStorage;
        }
        if ((i & 2) != 0) {
            gBCConsentValue2 = googleBasicConsents.adUserData;
        }
        if ((i & 4) != 0) {
            gBCConsentValue3 = googleBasicConsents.adPersonalization;
        }
        if ((i & 8) != 0) {
            gBCConsentValue4 = googleBasicConsents.analyticsStorage;
        }
        return googleBasicConsents.copy(gBCConsentValue, gBCConsentValue2, gBCConsentValue3, gBCConsentValue4);
    }

    public final GBCConsentValue component1() {
        return this.adStorage;
    }

    public final GBCConsentValue component2() {
        return this.adUserData;
    }

    public final GBCConsentValue component3() {
        return this.adPersonalization;
    }

    public final GBCConsentValue component4() {
        return this.analyticsStorage;
    }

    public final GoogleBasicConsents copy(GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4) {
        gBCConsentValue.getClass();
        gBCConsentValue2.getClass();
        gBCConsentValue3.getClass();
        gBCConsentValue4.getClass();
        return new GoogleBasicConsents(gBCConsentValue, gBCConsentValue2, gBCConsentValue3, gBCConsentValue4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleBasicConsents)) {
            return false;
        }
        GoogleBasicConsents googleBasicConsents = (GoogleBasicConsents) obj;
        return this.adStorage == googleBasicConsents.adStorage && this.adUserData == googleBasicConsents.adUserData && this.adPersonalization == googleBasicConsents.adPersonalization && this.analyticsStorage == googleBasicConsents.analyticsStorage;
    }

    public final GBCConsentValue getAdPersonalization() {
        return this.adPersonalization;
    }

    public final GBCConsentValue getAdStorage() {
        return this.adStorage;
    }

    public final GBCConsentValue getAdUserData() {
        return this.adUserData;
    }

    public final GBCConsentValue getAnalyticsStorage() {
        return this.analyticsStorage;
    }

    public int hashCode() {
        return this.analyticsStorage.hashCode() + ((this.adPersonalization.hashCode() + ((this.adUserData.hashCode() + (this.adStorage.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "GoogleBasicConsents(adStorage=" + this.adStorage + ", adUserData=" + this.adUserData + ", adPersonalization=" + this.adPersonalization + ", analyticsStorage=" + this.analyticsStorage + ')';
    }
}
