package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(28)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkRequest28 {
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    public static final NetworkRequest createNetworkRequest(int[] iArr, int[] iArr2) {
        int[] iArr3;
        iArr.getClass();
        iArr2.getClass();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : iArr) {
            try {
                builder.addCapability(i);
            } catch (IllegalArgumentException e10) {
                Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring adding capability '" + i + '\'', e10);
            }
        }
        iArr3 = NetworkRequestCompatKt.defaultCapabilities;
        for (int i6 : iArr3) {
            if (!j.T(iArr, i6)) {
                try {
                    builder.removeCapability(i6);
                } catch (IllegalArgumentException e11) {
                    Logger.get().warning(NetworkRequestCompat.Companion.getTAG(), "Ignoring removing default capability '" + i6 + '\'', e11);
                }
            }
        }
        for (int i10 : iArr2) {
            builder.addTransportType(i10);
        }
        NetworkRequest build = builder.build();
        build.getClass();
        return build;
    }

    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(int[] iArr, int[] iArr2) {
        iArr.getClass();
        iArr2.getClass();
        return new NetworkRequestCompat(createNetworkRequest(iArr, iArr2));
    }

    public final boolean hasCapability$work_runtime_release(NetworkRequest networkRequest, int i) {
        networkRequest.getClass();
        return networkRequest.hasCapability(i);
    }

    public final boolean hasTransport$work_runtime_release(NetworkRequest networkRequest, int i) {
        networkRequest.getClass();
        return networkRequest.hasTransport(i);
    }
}
