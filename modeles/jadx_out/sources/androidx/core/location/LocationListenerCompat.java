package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i);

    @Override // android.location.LocationListener
    void onLocationChanged(@NonNull List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@NonNull String str, int i, @Nullable Bundle bundle);
}
