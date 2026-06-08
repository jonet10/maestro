package h0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.work.WorkRequest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5391a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f5392b = new LinkedBlockingQueue();

    public final IBinder a() {
        y.f("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f5391a) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot call get on this connection more than once");
            return null;
        }
        this.f5391a = true;
        IBinder iBinder = (IBinder) this.f5392b.poll(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f5392b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
