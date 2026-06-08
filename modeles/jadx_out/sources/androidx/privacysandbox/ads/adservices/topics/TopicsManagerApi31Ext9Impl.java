package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresExtension(extension = 31, version = 9)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TopicsManagerApi31Ext9Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TopicsManagerApi31Ext9Impl(android.content.Context r1) {
        /*
            r0 = this;
            r1.getClass()
            android.adservices.topics.TopicsManager r1 = android.adservices.topics.TopicsManager.get(r1)
            r1.getClass()
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerApi31Ext9Impl.<init>(android.content.Context):void");
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithRecordObservation$ads_adservices_release(getTopicsRequest);
    }
}
