package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.time.Instant;
import j$.time.TimeConversions;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FetchAndJoinCustomAudienceRequest {
    private final Instant activationTime;
    private final Instant expirationTime;
    private final Uri fetchUri;
    private final String name;
    private final AdSelectionSignals userBiddingSignals;

    public /* synthetic */ FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, int i, g gVar) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : instant, (i & 8) != 0 ? null : instant2, (i & 16) != 0 ? null : adSelectionSignals);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        FetchAndJoinCustomAudienceRequest.Builder activationTime;
        FetchAndJoinCustomAudienceRequest.Builder expirationTime;
        activationTime = new FetchAndJoinCustomAudienceRequest.Builder(this.fetchUri).setName(this.name).setActivationTime(TimeConversions.convert(this.activationTime));
        expirationTime = activationTime.setExpirationTime(TimeConversions.convert(this.expirationTime));
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest build = expirationTime.setUserBiddingSignals(adSelectionSignals != null ? adSelectionSignals.convertToAdServices$ads_adservices_release() : null).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        return l.a(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) && l.a(this.name, fetchAndJoinCustomAudienceRequest.name) && l.a(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) && l.a(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) && l.a(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals);
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    public final String getName() {
        return this.name;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int hashCode = this.fetchUri.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.activationTime;
        int hashCode3 = (hashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.expirationTime;
        int hashCode4 = (hashCode3 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        return hashCode4 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0);
    }

    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str) {
        this(uri, str, null, null, null, 28, null);
        uri.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant) {
        this(uri, str, instant, null, null, 24, null);
        uri.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2) {
        this(uri, str, instant, instant2, null, 16, null);
        uri.getClass();
    }

    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals) {
        uri.getClass();
        this.fetchUri = uri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri) {
        this(uri, null, null, null, null, 30, null);
        uri.getClass();
    }
}
