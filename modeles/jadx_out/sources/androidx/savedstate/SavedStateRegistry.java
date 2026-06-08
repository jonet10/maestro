package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.savedstate.Recreator;
import androidx.savedstate.internal.SavedStateRegistryImpl;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateRegistry {
    private final SavedStateRegistryImpl impl;
    private Recreator.SavedStateProvider recreatorProvider;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl savedStateRegistryImpl) {
        savedStateRegistryImpl.getClass();
        this.impl = savedStateRegistryImpl;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        str.getClass();
        return this.impl.consumeRestoredStateForKey(str);
    }

    public final SavedStateProvider getSavedStateProvider(String str) {
        str.getClass();
        return this.impl.getSavedStateProvider(str);
    }

    @MainThread
    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        str.getClass();
        savedStateProvider.getClass();
        this.impl.registerSavedStateProvider(str, savedStateProvider);
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        cls.getClass();
        if (!this.impl.isAllowingSavingState$savedstate()) {
            a.i("Can not perform this action after onSaveInstanceState");
            return;
        }
        Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.recreatorProvider = savedStateProvider;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
            if (savedStateProvider2 != null) {
                savedStateProvider2.add(cls.getName());
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        str.getClass();
        this.impl.unregisterSavedStateProvider(str);
    }
}
