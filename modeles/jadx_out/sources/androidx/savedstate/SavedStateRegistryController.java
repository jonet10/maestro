package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.jvm.internal.g;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateRegistryController {
    public static final Companion Companion = new Companion(null);
    private final SavedStateRegistryImpl impl;
    private final SavedStateRegistry savedStateRegistry;

    private SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
        this.savedStateRegistry = new SavedStateRegistry(savedStateRegistryImpl);
    }

    public static final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return Companion.create(savedStateRegistryOwner);
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        this.impl.performAttach();
    }

    @MainThread
    public final void performRestore(Bundle bundle) {
        this.impl.performRestore$savedstate(bundle);
    }

    @MainThread
    public final void performSave(Bundle bundle) {
        bundle.getClass();
        this.impl.performSave$savedstate(bundle);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x create$lambda$0(SavedStateRegistryOwner savedStateRegistryOwner) {
            savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(savedStateRegistryOwner));
            return x.f8463a;
        }

        public final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
            savedStateRegistryOwner.getClass();
            return new SavedStateRegistryController(new SavedStateRegistryImpl(savedStateRegistryOwner, new androidx.room.g(savedStateRegistryOwner, 2)), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl, g gVar) {
        this(savedStateRegistryImpl);
    }
}
