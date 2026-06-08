package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.RegisterSourceOptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SourceRegistrationRequest {
    private final InputEvent inputEvent;
    private final List<Uri> registrationUris;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        private InputEvent inputEvent;
        private final List<Uri> registrationUris;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(List<? extends Uri> list) {
            list.getClass();
            this.registrationUris = list;
        }

        public final SourceRegistrationRequest build() {
            return new SourceRegistrationRequest(this.registrationUris, this.inputEvent);
        }

        public final Builder setInputEvent(InputEvent inputEvent) {
            inputEvent.getClass();
            this.inputEvent = inputEvent;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SourceRegistrationRequest(List<? extends Uri> list, InputEvent inputEvent) {
        list.getClass();
        this.registrationUris = list;
        this.inputEvent = inputEvent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        return l.a(this.registrationUris, sourceRegistrationRequest.registrationUris) && l.a(this.inputEvent, sourceRegistrationRequest.inputEvent);
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final List<Uri> getRegistrationUris() {
        return this.registrationUris;
    }

    public int hashCode() {
        int hashCode = this.registrationUris.hashCode();
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent == null) {
            return hashCode;
        }
        return inputEvent.hashCode() + (hashCode * 31);
    }

    public String toString() {
        return androidx.lifecycle.l.w("AppSourcesRegistrationRequest { ", "RegistrationUris=[" + this.registrationUris + "], InputEvent=" + this.inputEvent, " }");
    }

    public /* synthetic */ SourceRegistrationRequest(List list, InputEvent inputEvent, int i, g gVar) {
        this(list, (i & 2) != 0 ? null : inputEvent);
    }
}
