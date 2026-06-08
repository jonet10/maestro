package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateWriter;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import p6.i;
import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateEncoderKt {
    public static final Bundle encodeToSavedState(h hVar, Object obj, SavedStateConfiguration savedStateConfiguration) {
        hVar.getClass();
        obj.getClass();
        savedStateConfiguration.getClass();
        i[] iVarArr = new i[0];
        Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleOf);
        new SavedStateEncoder(bundleOf, savedStateConfiguration).encodeSerializableValue(hVar, obj);
        return bundleOf;
    }

    public static Bundle encodeToSavedState$default(Object obj, SavedStateConfiguration savedStateConfiguration, int i, Object obj2) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        obj.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> Bundle encodeToSavedStateNullable(h hVar, T t9, SavedStateConfiguration savedStateConfiguration) {
        hVar.getClass();
        savedStateConfiguration.getClass();
        i[] iVarArr = new i[0];
        Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleOf);
        new SavedStateEncoder(bundleOf, savedStateConfiguration).encodeSerializableValue(hVar, t9);
        return bundleOf;
    }

    public static Bundle encodeToSavedStateNullable$default(Object obj, SavedStateConfiguration savedStateConfiguration, int i, Object obj2) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static /* synthetic */ Bundle encodeToSavedStateNullable$default(h hVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i, Object obj2) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedStateNullable(hVar, obj, savedStateConfiguration);
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(h hVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i, Object obj2) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedState(hVar, obj, savedStateConfiguration);
    }

    public static final <T> Bundle encodeToSavedStateNullable(T t9, SavedStateConfiguration savedStateConfiguration) {
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final <T> Bundle encodeToSavedStateNullable(h hVar, T t9) {
        hVar.getClass();
        return encodeToSavedStateNullable$default(hVar, t9, null, 4, null);
    }

    public static final <T> Bundle encodeToSavedState(T t9, SavedStateConfiguration savedStateConfiguration) {
        t9.getClass();
        savedStateConfiguration.getClass();
        savedStateConfiguration.getSerializersModule();
        l.h();
        throw null;
    }

    public static final /* synthetic */ Bundle encodeToSavedState(h hVar, Object obj) {
        hVar.getClass();
        obj.getClass();
        return encodeToSavedState$default(hVar, obj, null, 4, null);
    }
}
