package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.e;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ConnectionHolder implements ServiceConnection {
    private static final int STATE_AWAITING_CONNECTION = 0;
    private static final int STATE_CANCELLED = 3;
    private static final int STATE_CONNECTED = 1;
    private static final int STATE_DISCONNECTED = 2;

    @Nullable
    private Exception mCancellationException;

    @NonNull
    private final Runnable mCloseRunnable;

    @NonNull
    private List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> mCompleters;

    @Nullable
    private TrustedWebActivityServiceConnection mService;
    private int mState;

    @NonNull
    private final WrapperFactory mWrapperFactory;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class WrapperFactory {
        @NonNull
        public TrustedWebActivityServiceConnection create(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(e.asInterface(iBinder), componentName);
        }
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable, @NonNull WrapperFactory wrapperFactory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = runnable;
        this.mWrapperFactory = wrapperFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getServiceWrapper$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        int i = this.mState;
        if (i == 0) {
            this.mCompleters.add(completer);
        } else {
            if (i != 1) {
                if (i == 2) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Service has been disconnected.");
                    return null;
                }
                if (i == 3) {
                    throw this.mCancellationException;
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Connection state is invalid");
                return null;
            }
            TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = this.mService;
            if (trustedWebActivityServiceConnection == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("ConnectionHolder state is incorrect.");
                return null;
            }
            completer.set(trustedWebActivityServiceConnection);
        }
        return "ConnectionHolder, state = " + this.mState;
    }

    @MainThread
    public void cancel(@NonNull Exception exc) {
        Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = this.mCompleters.iterator();
        while (it.hasNext()) {
            it.next().setException(exc);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exc;
    }

    @NonNull
    @MainThread
    public m1.b getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.browser.trusted.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                Object lambda$getServiceWrapper$0;
                lambda$getServiceWrapper$0 = ConnectionHolder.this.lambda$getServiceWrapper$0(completer);
                return lambda$getServiceWrapper$0;
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.create(componentName, iBinder);
        Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = this.mCompleters.iterator();
        while (it.hasNext()) {
            it.next().set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable) {
        this(runnable, new WrapperFactory());
    }
}
