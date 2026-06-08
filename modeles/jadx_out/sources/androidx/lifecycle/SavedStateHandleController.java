package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver, AutoCloseable {
    private final SavedStateHandle handle;
    private boolean isAttached;
    private final String key;

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        str.getClass();
        savedStateHandle.getClass();
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void attachToLifecycle(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        savedStateRegistry.getClass();
        lifecycle.getClass();
        if (this.isAttached) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Already attached to lifecycleOwner");
            return;
        }
        this.isAttached = true;
        lifecycle.addObserver(this);
        savedStateRegistry.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
    }

    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }
}
