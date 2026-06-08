package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(31)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class NetworkRequest31 {
    public static final NetworkRequest31 INSTANCE = new NetworkRequest31();

    private NetworkRequest31() {
    }

    public final int[] capabilities(NetworkRequest networkRequest) {
        networkRequest.getClass();
        int[] capabilities = networkRequest.getCapabilities();
        capabilities.getClass();
        return capabilities;
    }

    public final int[] transportTypes(NetworkRequest networkRequest) {
        networkRequest.getClass();
        int[] transportTypes = networkRequest.getTransportTypes();
        transportTypes.getClass();
        return transportTypes;
    }
}
