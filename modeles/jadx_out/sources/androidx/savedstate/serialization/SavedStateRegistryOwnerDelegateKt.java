package androidx.savedstate.serialization;

import androidx.savedstate.SavedStateRegistryOwner;
import d7.a;
import f7.b;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateRegistryOwnerDelegateKt {
    public static final /* synthetic */ b saved(SavedStateRegistryOwner savedStateRegistryOwner, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateRegistryOwner.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateRegistryOwnerDelegate(savedStateRegistryOwner.getSavedStateRegistry(), bVar, str, savedStateConfiguration, aVar);
    }

    public static b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> b savedNullable(SavedStateRegistryOwner savedStateRegistryOwner, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateRegistryOwner.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateRegistryOwnerDelegate(savedStateRegistryOwner.getSavedStateRegistry(), bVar, str, savedStateConfiguration, aVar);
    }

    public static b savedNullable$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateRegistryOwner, bVar, str, savedStateConfiguration, aVar);
    }

    public static /* synthetic */ b savedNullable$default(SavedStateRegistryOwner savedStateRegistryOwner, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return savedNullable(savedStateRegistryOwner, bVar, str, savedStateConfiguration, aVar);
    }

    public static final <T> b saved(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> b savedNullable(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateRegistryOwner.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }
}
