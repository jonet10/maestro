package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceRegistrationRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WebSourceRegistrationRequest {
    private final Uri appDestination;
    private final InputEvent inputEvent;
    private final Uri topOriginUri;
    private final Uri verifiedDestination;
    private final Uri webDestination;
    private final List<WebSourceParams> webSourceParams;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        private Uri appDestination;
        private InputEvent inputEvent;
        private final Uri topOriginUri;
        private Uri verifiedDestination;
        private Uri webDestination;
        private final List<WebSourceParams> webSourceParams;

        public Builder(List<WebSourceParams> list, Uri uri) {
            list.getClass();
            uri.getClass();
            this.webSourceParams = list;
            this.topOriginUri = uri;
        }

        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.webSourceParams, this.topOriginUri, this.inputEvent, this.appDestination, this.webDestination, this.verifiedDestination);
        }

        public final Builder setAppDestination(Uri uri) {
            this.appDestination = uri;
            return this;
        }

        public final Builder setInputEvent(InputEvent inputEvent) {
            inputEvent.getClass();
            this.inputEvent = inputEvent;
            return this;
        }

        public final Builder setVerifiedDestination(Uri uri) {
            this.verifiedDestination = uri;
            return this;
        }

        public final Builder setWebDestination(Uri uri) {
            this.webDestination = uri;
            return this;
        }
    }

    public /* synthetic */ WebSourceRegistrationRequest(List list, Uri uri, InputEvent inputEvent, Uri uri2, Uri uri3, Uri uri4, int i, g gVar) {
        this(list, uri, (i & 4) != 0 ? null : inputEvent, (i & 8) != 0 ? null : uri2, (i & 16) != 0 ? null : uri3, (i & 32) != 0 ? null : uri4);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.WebSourceRegistrationRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.WebSourceRegistrationRequest build = new WebSourceRegistrationRequest.Builder(WebSourceParams.Companion.convertWebSourceParams$ads_adservices_release(this.webSourceParams), this.topOriginUri).setWebDestination(this.webDestination).setAppDestination(this.appDestination).setInputEvent(this.inputEvent).setVerifiedDestination(this.verifiedDestination).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        return l.a(this.webSourceParams, webSourceRegistrationRequest.webSourceParams) && l.a(this.webDestination, webSourceRegistrationRequest.webDestination) && l.a(this.appDestination, webSourceRegistrationRequest.appDestination) && l.a(this.topOriginUri, webSourceRegistrationRequest.topOriginUri) && l.a(this.inputEvent, webSourceRegistrationRequest.inputEvent) && l.a(this.verifiedDestination, webSourceRegistrationRequest.verifiedDestination);
    }

    public final Uri getAppDestination() {
        return this.appDestination;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    public final Uri getWebDestination() {
        return this.webDestination;
    }

    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public int hashCode() {
        int hashCode = this.topOriginUri.hashCode() + (this.webSourceParams.hashCode() * 31);
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            hashCode = (hashCode * 31) + inputEvent.hashCode();
        }
        Uri uri = this.appDestination;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.webDestination;
        if (uri2 != null) {
            hashCode = (hashCode * 31) + uri2.hashCode();
        }
        int hashCode2 = this.topOriginUri.hashCode() + (hashCode * 31);
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            hashCode2 = (hashCode2 * 31) + inputEvent2.hashCode();
        }
        Uri uri3 = this.verifiedDestination;
        if (uri3 == null) {
            return hashCode2;
        }
        return uri3.hashCode() + (hashCode2 * 31);
    }

    public String toString() {
        return androidx.lifecycle.l.w("WebSourceRegistrationRequest { ", "WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination, " }");
    }

    public WebSourceRegistrationRequest(List<WebSourceParams> list, Uri uri, InputEvent inputEvent, Uri uri2, Uri uri3, Uri uri4) {
        list.getClass();
        uri.getClass();
        this.webSourceParams = list;
        this.topOriginUri = uri;
        this.inputEvent = inputEvent;
        this.appDestination = uri2;
        this.webDestination = uri3;
        this.verifiedDestination = uri4;
    }
}
