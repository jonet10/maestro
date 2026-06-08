package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresExtension(extension = 1000000, version = 5)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TopicsManagerApi33Ext5Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TopicsManagerApi33Ext5Impl(android.content.Context r2) {
        /*
            r1 = this;
            r2.getClass()
            java.lang.Class r0 = androidx.privacysandbox.ads.adservices.customaudience.a.q()
            java.lang.Object r2 = r2.getSystemService(r0)
            r2.getClass()
            android.adservices.topics.TopicsManager r2 = androidx.privacysandbox.ads.adservices.customaudience.a.f(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerApi33Ext5Impl.<init>(android.content.Context):void");
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithRecordObservation$ads_adservices_release(getTopicsRequest);
    }
}
