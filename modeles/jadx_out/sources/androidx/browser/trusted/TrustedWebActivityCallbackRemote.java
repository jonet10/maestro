package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TrustedWebActivityCallbackRemote {
    private final android.support.customtabs.trusted.c mCallbackBinder;

    private TrustedWebActivityCallbackRemote(@NonNull android.support.customtabs.trusted.c cVar) {
        this.mCallbackBinder = cVar;
    }

    @Nullable
    public static TrustedWebActivityCallbackRemote fromBinder(@Nullable IBinder iBinder) {
        android.support.customtabs.trusted.c asInterface = iBinder == null ? null : android.support.customtabs.trusted.b.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(asInterface);
    }

    public void runExtraCallback(@NonNull String str, @NonNull Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}
