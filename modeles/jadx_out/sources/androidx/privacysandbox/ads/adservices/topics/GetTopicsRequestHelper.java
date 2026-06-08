package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class GetTopicsRequestHelper {
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        android.adservices.topics.GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(getTopicsRequest.getAdsSdkName()).setShouldRecordObservation(getTopicsRequest.shouldRecordObservation()).build();
        build.getClass();
        return build;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        android.adservices.topics.GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(getTopicsRequest.getAdsSdkName()).build();
        build.getClass();
        return build;
    }
}
