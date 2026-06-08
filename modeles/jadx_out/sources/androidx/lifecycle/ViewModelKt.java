package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelKt {
    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();

    public static final a0 getViewModelScope(ViewModel viewModel) {
        CloseableCoroutineScope closeableCoroutineScope;
        viewModel.getClass();
        synchronized (VIEW_MODEL_SCOPE_LOCK) {
            closeableCoroutineScope = (CloseableCoroutineScope) viewModel.getCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY);
            if (closeableCoroutineScope == null) {
                closeableCoroutineScope = CloseableCoroutineScopeKt.createViewModelScope();
                viewModel.addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, closeableCoroutineScope);
            }
        }
        return closeableCoroutineScope;
    }
}
