package androidx.lifecycle.serialization;

import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import d7.a;
import f7.b;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateHandleDelegateKt {
    public static final /* synthetic */ b saved(SavedStateHandle savedStateHandle, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateHandle.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateHandleDelegate(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }

    public static b saved$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> b savedNullable(SavedStateHandle savedStateHandle, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateHandle.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        return new SavedStateHandleDelegate(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }

    public static b savedNullable$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> b saved(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ b saved$default(SavedStateHandle savedStateHandle, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }

    public static final <T> b savedNullable(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateHandle.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ b savedNullable$default(SavedStateHandle savedStateHandle, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return savedNullable(savedStateHandle, bVar, str, savedStateConfiguration, aVar);
    }
}
