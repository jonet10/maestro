package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;

    @NonNull
    ResolvableFuture<Integer> mResultFuture;

    @Nullable
    @VisibleForTesting
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService = null;
    private boolean mHasBoundService = false;

    public UnusedAppRestrictionsBackportServiceConnection(@NonNull Context context) {
        this.mContext = context;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z9, boolean z10) throws RemoteException {
                if (!z9) {
                    UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.set(0);
                    Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
                    return;
                }
                UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = UnusedAppRestrictionsBackportServiceConnection.this;
                if (z10) {
                    unusedAppRestrictionsBackportServiceConnection.mResultFuture.set(3);
                } else {
                    unusedAppRestrictionsBackportServiceConnection.mResultFuture.set(2);
                }
            }
        };
    }

    public void connectAndFetchResult(@NonNull ResolvableFuture<Integer> resolvableFuture) {
        if (this.mHasBoundService) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
            return;
        }
        this.mHasBoundService = true;
        this.mResultFuture = resolvableFuture;
        this.mContext.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager())), this, 1);
    }

    public void disconnectFromService() {
        if (!this.mHasBoundService) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("bindService must be called before unbind");
        } else {
            this.mHasBoundService = false;
            this.mContext.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.mUnusedAppRestrictionsService = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(getBackportCallback());
        } catch (RemoteException unused) {
            this.mResultFuture.set(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mUnusedAppRestrictionsService = null;
    }
}
