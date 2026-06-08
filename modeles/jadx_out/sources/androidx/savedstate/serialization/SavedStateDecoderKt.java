package androidx.savedstate.serialization;

import android.os.Bundle;
import kotlin.jvm.internal.l;
import z7.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateDecoderKt {
    public static final /* synthetic */ Object decodeFromSavedState(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        aVar.getClass();
        bundle.getClass();
        savedStateConfiguration.getClass();
        return new SavedStateDecoder(bundle, savedStateConfiguration).decodeSerializableValue(aVar);
    }

    public static Object decodeFromSavedState$default(Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> T decodeFromSavedStateNullable(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        aVar.getClass();
        bundle.getClass();
        savedStateConfiguration.getClass();
        return (T) new SavedStateDecoder(bundle, savedStateConfiguration).decodeSerializableValue(aVar);
    }

    public static Object decodeFromSavedStateNullable$default(Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> T decodeFromSavedState(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> T decodeFromSavedStateNullable(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ Object decodeFromSavedState$default(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedState(aVar, bundle, savedStateConfiguration);
    }

    public static /* synthetic */ Object decodeFromSavedStateNullable$default(a aVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedStateNullable(aVar, bundle, savedStateConfiguration);
    }

    public static final /* synthetic */ Object decodeFromSavedState(a aVar, Bundle bundle) {
        aVar.getClass();
        bundle.getClass();
        return decodeFromSavedState$default(aVar, bundle, null, 4, null);
    }

    public static final <T> T decodeFromSavedStateNullable(a aVar, Bundle bundle) {
        aVar.getClass();
        bundle.getClass();
        return (T) decodeFromSavedStateNullable$default(aVar, bundle, null, 4, null);
    }
}
