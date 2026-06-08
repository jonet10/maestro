package androidx.savedstate;

import a4.x;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.g;
import p6.i;
import q6.l;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = new Companion(null);
    private final SavedStateRegistryOwner owner;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes;

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.getClass();
            this.classes = new LinkedHashSet();
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(String str) {
            str.getClass();
            this.classes.add(str);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            i[] iVarArr = new i[0];
            Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
            SavedStateWriter.m218putStringListimpl(SavedStateWriter.m183constructorimpl(bundleOf), Recreator.CLASSES_KEY, l.G0(this.classes));
            return bundleOf;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        savedStateRegistryOwner.getClass();
        this.owner = savedStateRegistryOwner;
    }

    private final void reflectiveNew(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            asSubclass.getClass();
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(null);
                    newInstance.getClass();
                    ((SavedStateRegistry.AutoRecreated) newInstance).onRecreated(this.owner);
                } catch (Exception e10) {
                    a.m(x.j("Failed to instantiate ", str), e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            a.m(androidx.lifecycle.l.w("Class ", str, " wasn't found"), e12);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        if (event != Lifecycle.Event.ON_CREATE) {
            o.j("Next event must be ON_CREATE");
            return;
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        Bundle consumeRestoredStateForKey = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (consumeRestoredStateForKey == null) {
            return;
        }
        List<String> m172getStringListOrNullimpl = SavedStateReader.m172getStringListOrNullimpl(SavedStateReader.m97constructorimpl(consumeRestoredStateForKey), CLASSES_KEY);
        if (m172getStringListOrNullimpl == null) {
            a.i("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        Iterator<String> it = m172getStringListOrNullimpl.iterator();
        while (it.hasNext()) {
            reflectiveNew(it.next());
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
