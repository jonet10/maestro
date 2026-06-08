package androidx.lifecycle.serialization;

import a4.x;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.internal.CanonicalName_jvmKt;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import d7.a;
import f7.b;
import j7.k;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class SavedStateHandleDelegate<T> implements b, SavedStateRegistry.SavedStateProvider {
    private Object cachedValue;
    private final SavedStateConfiguration configuration;
    private final a init;
    private final String key;
    private final SavedStateHandle savedStateHandle;
    private final z7.b serializer;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class UNINITIALIZED {
        public static final UNINITIALIZED INSTANCE = new UNINITIALIZED();

        private UNINITIALIZED() {
        }
    }

    public SavedStateHandleDelegate(SavedStateHandle savedStateHandle, z7.b bVar, String str, SavedStateConfiguration savedStateConfiguration, a aVar) {
        savedStateHandle.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        this.savedStateHandle = savedStateHandle;
        this.serializer = bVar;
        this.key = str;
        this.configuration = savedStateConfiguration;
        this.init = aVar;
        this.cachedValue = UNINITIALIZED.INSTANCE;
    }

    private final String getQualifiedKey(Object obj, k kVar) {
        String str;
        String str2 = this.key;
        if (str2 != null) {
            return str2;
        }
        if (obj != null) {
            str = CanonicalName_jvmKt.getCanonicalName(y.a(obj.getClass())) + '.';
        } else {
            str = "";
        }
        StringBuilder t9 = x.t(str);
        t9.append(kVar.getName());
        return t9.toString();
    }

    private final T loadInitialValue(String str) {
        Bundle bundle = (Bundle) this.savedStateHandle.get(str);
        if (bundle == null) {
            return (T) this.init.invoke();
        }
        z7.b bVar = this.serializer;
        bVar.getClass();
        return (T) SavedStateDecoderKt.decodeFromSavedStateNullable(bVar, bundle, this.configuration);
    }

    @Override // f7.a
    public T getValue(Object obj, k kVar) {
        kVar.getClass();
        if (l.a(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            String qualifiedKey = getQualifiedKey(obj, kVar);
            this.savedStateHandle.setSavedStateProvider(qualifiedKey, this);
            this.cachedValue = loadInitialValue(qualifiedKey);
        }
        return (T) this.cachedValue;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        if (!l.a(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            return SavedStateEncoderKt.encodeToSavedStateNullable(this.serializer, this.cachedValue, this.configuration);
        }
        i[] iVarArr = new i[0];
        Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleOf);
        return bundleOf;
    }

    public void setValue(Object obj, k kVar, T t9) {
        kVar.getClass();
        if (l.a(this.cachedValue, UNINITIALIZED.INSTANCE)) {
            this.savedStateHandle.setSavedStateProvider(getQualifiedKey(obj, kVar), this);
        }
        this.cachedValue = t9;
    }
}
