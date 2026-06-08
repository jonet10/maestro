package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkRequest30 {
    public static final NetworkRequest30 INSTANCE = new NetworkRequest30();

    private NetworkRequest30() {
    }

    public final NetworkSpecifier getNetworkSpecifier(NetworkRequest networkRequest) {
        networkRequest.getClass();
        return networkRequest.getNetworkSpecifier();
    }
}
