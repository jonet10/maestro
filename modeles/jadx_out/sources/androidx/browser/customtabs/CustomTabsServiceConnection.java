package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.e;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {

    @Nullable
    private Context mApplicationContext;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext != null) {
            onCustomTabsServiceConnected(componentName, new CustomTabsClient(e.asInterface(iBinder), componentName, this.mApplicationContext) { // from class: androidx.browser.customtabs.CustomTabsServiceConnection.1
            });
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
