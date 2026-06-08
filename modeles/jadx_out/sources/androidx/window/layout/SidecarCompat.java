package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        @GuardedBy("mLock")
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            extensionCallbackInterface.getClass();
            this.callbackInterface = extensionCallbackInterface;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            activity.getClass();
            windowLayoutInfo.getClass();
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (windowLayoutInfo.equals(this.activityWindowLayoutInfo.get(activity))) {
                    return;
                }
                this.activityWindowLayoutInfo.put(activity, windowLayoutInfo);
                reentrantLock.unlock();
                this.callbackInterface.onWindowLayoutChanged(activity, windowLayoutInfo);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;

        @GuardedBy("lock")
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;

        @GuardedBy("mLock")
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
            sidecarAdapter.getClass();
            sidecarCallback.getClass();
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = sidecarCallback;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            sidecarDeviceState.getClass();
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, sidecarDeviceState)) {
                    return;
                }
                this.lastDeviceState = sidecarDeviceState;
                this.callbackInterface.onDeviceStateChanged(sidecarDeviceState);
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            iBinder.getClass();
            sidecarWindowLayoutInfo.getClass();
            synchronized (this.lock) {
                if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                this.callbackInterface.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            sidecarCompat.getClass();
            activity.getClass();
            this.sidecarCompat = sidecarCompat;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getClass();
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity == null || activityWindowToken$window_release == null) {
                return;
            }
            this.sidecarCompat.register(activityWindowToken$window_release, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.getClass();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            sidecarCompat.getClass();
            this.this$0 = sidecarCompat;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface sidecar;
            sidecarDeviceState.getClass();
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            iBinder.getClass();
            sidecarWindowLayoutInfo.getClass();
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(iBinder);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = sidecarAdapter.translate(sidecarWindowLayoutInfo, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
            if (extensionCallbackInterface == null) {
                return;
            }
            extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
        }
    }

    @VisibleForTesting
    public SidecarCompat(@VisibleForTesting SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        sidecarAdapter.getClass();
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(final Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                    configuration.getClass();
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.extensionCallback;
                    if (extensionCallbackInterface == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    extensionCallbackInterface.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.componentCallbackMap.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @VisibleForTesting
    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        activity.getClass();
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(t.f8724a);
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.translate(windowLayoutInfo, deviceState);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        activity.getClass();
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        SidecarInterface sidecarInterface;
        activity.getClass();
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
        }
        unregisterComponentCallback(activity);
        boolean z9 = this.windowListenerRegisteredContexts.size() == 1;
        this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
        if (!z9 || (sidecarInterface = this.sidecar) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void register(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        iBinder.getClass();
        activity.getClass();
        this.windowListenerRegisteredContexts.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        extensionCallbackInterface.getClass();
        this.extensionCallback = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0189, TRY_LEAVE, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0159 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a5 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0165 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0080 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0171 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0059 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017d A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0020 A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0101, B:49:0x0104, B:51:0x012f, B:53:0x0139, B:54:0x0140, B:55:0x0141, B:56:0x0148, B:58:0x00b8, B:60:0x00df, B:62:0x0149, B:63:0x0150, B:64:0x0151, B:65:0x0158, B:66:0x0159, B:67:0x0164, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0165, B:74:0x0170, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0171, B:81:0x017c, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017d, B:90:0x0188, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #1 }] */
    @Override // androidx.window.layout.ExtensionInterfaceCompat
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface getSidecarCompat$window_release(Context context) {
            context.getClass();
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.Companion.parse(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SidecarCompat(Context context) {
        this(Companion.getSidecarCompat$window_release(context), new SidecarAdapter(null, 1, 0 == true ? 1 : 0));
        context.getClass();
    }
}
