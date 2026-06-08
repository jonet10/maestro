package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import q6.b0;
import r7.c0;
import r7.e0;
import r7.m0;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateHandle {
    public static final Companion Companion = new Companion(null);
    private SavedStateHandleImpl impl;
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    @VisibleForTesting
    public SavedStateHandle(Map<String, ? extends Object> map) {
        map.getClass();
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(map);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z9, T t9) {
        String createMutuallyExclusiveErrorMessage;
        SavingStateLiveData<?> savingStateLiveData;
        if (this.impl.getMutableFlows().containsKey(str)) {
            createMutuallyExclusiveErrorMessage = SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(str);
            o.o(createMutuallyExclusiveErrorMessage);
            return null;
        }
        Map<String, SavingStateLiveData<?>> map = this.liveDatas;
        SavingStateLiveData<?> savingStateLiveData2 = map.get(str);
        if (savingStateLiveData2 == null) {
            if (this.impl.getRegular().containsKey(str)) {
                savingStateLiveData = new SavingStateLiveData<>(this, str, this.impl.getRegular().get(str));
            } else if (z9) {
                this.impl.getRegular().put(str, t9);
                savingStateLiveData = new SavingStateLiveData<>(this, str, t9);
            } else {
                savingStateLiveData = new SavingStateLiveData<>(this, str);
            }
            savingStateLiveData2 = savingStateLiveData;
            map.put(str, savingStateLiveData2);
        }
        return savingStateLiveData2;
    }

    @MainThread
    public final void clearSavedStateProvider(String str) {
        str.getClass();
        this.impl.clearSavedStateProvider(str);
    }

    @MainThread
    public final boolean contains(String str) {
        str.getClass();
        return this.impl.contains(str);
    }

    @MainThread
    public final <T> T get(String str) {
        str.getClass();
        return (T) this.impl.get(str);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str) {
        str.getClass();
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, null);
        liveDataInternal.getClass();
        return liveDataInternal;
    }

    @MainThread
    public final <T> c0 getMutableStateFlow(String str, T t9) {
        String createMutuallyExclusiveErrorMessage;
        str.getClass();
        if (!this.liveDatas.containsKey(str)) {
            return this.impl.getMutableStateFlow(str, t9);
        }
        createMutuallyExclusiveErrorMessage = SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(str);
        o.o(createMutuallyExclusiveErrorMessage);
        return null;
    }

    @MainThread
    public final <T> m0 getStateFlow(String str, T t9) {
        str.getClass();
        boolean containsKey = this.impl.getMutableFlows().containsKey(str);
        SavedStateHandleImpl savedStateHandleImpl = this.impl;
        return containsKey ? new e0(savedStateHandleImpl.getMutableStateFlow(str, t9)) : savedStateHandleImpl.getStateFlow(str, t9);
    }

    @MainThread
    public final Set<String> keys() {
        return b0.Z(this.impl.keys(), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String str) {
        str.getClass();
        T t9 = (T) this.impl.remove(str);
        SavingStateLiveData<?> remove = this.liveDatas.remove(str);
        if (remove != null) {
            remove.detach();
        }
        return t9;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    @MainThread
    public final <T> void set(String str, T t9) {
        str.getClass();
        if (!Companion.validateValue(t9)) {
            t9.getClass();
            androidx.core.view.contentcapture.a.q(t9.getClass(), "Can't put value with type ", " into saved state");
            return;
        }
        SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
        SavingStateLiveData<?> savingStateLiveData2 = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
        if (savingStateLiveData2 != null) {
            savingStateLiveData2.setValue(t9);
        }
        this.impl.set(str, t9);
    }

    @MainThread
    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        str.getClass();
        savedStateProvider.getClass();
        this.impl.setSavedStateProvider(str, savedStateProvider);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new SavedStateHandle();
            }
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            classLoader.getClass();
            bundle.setClassLoader(classLoader);
            return new SavedStateHandle(SavedStateReader.m178toMapimpl(SavedStateReader.m97constructorimpl(bundle)));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object obj) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(obj);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t9) {
            super(t9);
            str.getClass();
            this.key = str;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t9) {
            SavedStateHandleImpl savedStateHandleImpl;
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null && (savedStateHandleImpl = savedStateHandle.impl) != null) {
                savedStateHandleImpl.set(this.key, t9);
            }
            super.setValue(t9);
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            str.getClass();
            this.key = str;
            this.handle = savedStateHandle;
        }
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str, T t9) {
        str.getClass();
        return getLiveDataInternal(str, true, t9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(null, 1, 0 == true ? 1 : 0);
    }
}
