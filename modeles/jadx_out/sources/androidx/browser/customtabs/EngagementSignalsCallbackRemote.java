package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.h;
import android.support.customtabs.i;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class EngagementSignalsCallbackRemote implements EngagementSignalsCallback {
    private static final String TAG = "EngagementSigsCallbkRmt";
    private final i mCallbackBinder;

    private EngagementSignalsCallbackRemote(@NonNull i iVar) {
        this.mCallbackBinder = iVar;
    }

    @NonNull
    public static EngagementSignalsCallbackRemote fromBinder(@NonNull IBinder iBinder) {
        return new EngagementSignalsCallbackRemote(h.asInterface(iBinder));
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onGreatestScrollPercentageIncreased(i, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void onSessionEnded(boolean z9, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onSessionEnded(z9, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void onVerticalScrollEvent(boolean z9, @NonNull Bundle bundle) {
        try {
            this.mCallbackBinder.onVerticalScrollEvent(z9, bundle);
        } catch (RemoteException unused) {
            Log.e(TAG, "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
