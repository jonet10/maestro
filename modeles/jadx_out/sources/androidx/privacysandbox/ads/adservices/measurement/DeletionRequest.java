package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.DeletionRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import j$.time.Instant;
import j$.time.TimeConversions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(26)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DeletionRequest {
    public static final Companion Companion = new Companion(null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(26)
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris;
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris;
        private Instant start;

        public Builder(int i, int i6) {
            this.deletionMode = i;
            this.matchBehavior = i6;
            Instant instant = Instant.MIN;
            instant.getClass();
            this.start = instant;
            Instant instant2 = Instant.MAX;
            instant2.getClass();
            this.end = instant2;
            t tVar = t.f8724a;
            this.domainUris = tVar;
            this.originUris = tVar;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        public final Builder setDomainUris(List<? extends Uri> list) {
            list.getClass();
            this.domainUris = list;
            return this;
        }

        public final Builder setEnd(Instant instant) {
            instant.getClass();
            this.end = instant;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> list) {
            list.getClass();
            this.originUris = list;
            return this;
        }

        public final Builder setStart(Instant instant) {
            instant.getClass();
            this.start = instant;
            return this;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ DeletionRequest(int r8, int r9, j$.time.Instant r10, j$.time.Instant r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.g r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L9
            j$.time.Instant r10 = j$.time.Instant.MIN
            r10.getClass()
        L9:
            r3 = r10
            r10 = r14 & 8
            if (r10 == 0) goto L13
            j$.time.Instant r11 = j$.time.Instant.MAX
            r11.getClass()
        L13:
            r4 = r11
            r10 = r14 & 16
            q6.t r11 = q6.t.f8724a
            if (r10 == 0) goto L1c
            r5 = r11
            goto L1d
        L1c:
            r5 = r12
        L1d:
            r10 = r14 & 32
            if (r10 == 0) goto L26
            r6 = r11
        L22:
            r0 = r7
            r1 = r8
            r2 = r9
            goto L28
        L26:
            r6 = r13
            goto L22
        L28:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.DeletionRequest.<init>(int, int, j$.time.Instant, j$.time.Instant, java.util.List, java.util.List, int, kotlin.jvm.internal.g):void");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.DeletionRequest convertToAdServices$ads_adservices_release() {
        DeletionRequest.Builder start;
        DeletionRequest.Builder end;
        start = new DeletionRequest.Builder().setDeletionMode(this.deletionMode).setMatchBehavior(this.matchBehavior).setStart(TimeConversions.convert(this.start));
        end = start.setEnd(TimeConversions.convert(this.end));
        android.adservices.measurement.DeletionRequest build = end.setDomainUris(this.domainUris).setOriginUris(this.originUris).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        return this.deletionMode == deletionRequest.deletionMode && new HashSet(this.domainUris).equals(new HashSet(deletionRequest.domainUris)) && new HashSet(this.originUris).equals(new HashSet(deletionRequest.originUris)) && l.a(this.start, deletionRequest.start) && l.a(this.end, deletionRequest.end) && this.matchBehavior == deletionRequest.matchBehavior;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return ((this.end.hashCode() + ((this.start.hashCode() + ((this.originUris.hashCode() + ((this.domainUris.hashCode() + (this.deletionMode * 31)) * 31)) * 31)) * 31)) * 31) + this.matchBehavior;
    }

    public String toString() {
        return "DeletionRequest { DeletionMode=" + (this.deletionMode == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA") + ", MatchBehavior=" + (this.matchBehavior == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE") + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface DeletionMode {
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeletionRequest(int i, int i6, Instant instant, Instant instant2, List<? extends Uri> list, List<? extends Uri> list2) {
        instant.getClass();
        instant2.getClass();
        list.getClass();
        list2.getClass();
        this.deletionMode = i;
        this.matchBehavior = i6;
        this.start = instant;
        this.end = instant2;
        this.domainUris = list;
        this.originUris = list2;
    }
}
