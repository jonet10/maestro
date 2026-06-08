package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.Arrays;
import java.util.Map;
import p6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final p6.f viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        savedStateRegistry.getClass();
        viewModelStoreOwner.getClass();
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new m(new b(viewModelStoreOwner, 1));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        str.getClass();
        performRestore();
        Bundle bundle = this.restoredState;
        if (bundle == null || !SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(bundle), str)) {
            return null;
        }
        Bundle m159getSavedStateOrNullimpl = SavedStateReader.m159getSavedStateOrNullimpl(SavedStateReader.m97constructorimpl(bundle), str);
        if (m159getSavedStateOrNullimpl == null) {
            p6.i[] iVarArr = new p6.i[0];
            m159getSavedStateOrNullimpl = BundleKt.bundleOf((p6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
            SavedStateWriter.m183constructorimpl(m159getSavedStateOrNullimpl);
        }
        SavedStateWriter.m219removeimpl(SavedStateWriter.m183constructorimpl(bundle), str);
        if (SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return m159getSavedStateOrNullimpl;
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle consumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey(SavedStateHandleSupport.SAVED_STATE_KEY);
        p6.i[] iVarArr = new p6.i[0];
        Bundle bundleOf = BundleKt.bundleOf((p6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        Bundle m183constructorimpl = SavedStateWriter.m183constructorimpl(bundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m187putAllimpl(m183constructorimpl, bundle);
        }
        if (consumeRestoredStateForKey != null) {
            SavedStateWriter.m187putAllimpl(m183constructorimpl, consumeRestoredStateForKey);
        }
        this.restoredState = bundleOf;
        this.restored = true;
        getViewModel();
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle bundleOf = BundleKt.bundleOf((p6.i[]) Arrays.copyOf(new p6.i[0], 0));
        Bundle m183constructorimpl = SavedStateWriter.m183constructorimpl(bundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m187putAllimpl(m183constructorimpl, bundle);
        }
        for (Map.Entry<String, SavedStateHandle> entry : getViewModel().getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle saveState = entry.getValue().savedStateProvider().saveState();
            if (!SavedStateReader.m175isEmptyimpl(SavedStateReader.m97constructorimpl(saveState))) {
                SavedStateWriter.m210putSavedStateimpl(m183constructorimpl, key, saveState);
            }
        }
        this.restored = false;
        return bundleOf;
    }
}
