package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import j7.c;
import kotlin.jvm.internal.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelProviderImpl {
    private final CreationExtras defaultExtras;
    private final ViewModelProvider.Factory factory;
    private final SynchronizedObject lock;
    private final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore viewModelStore, ViewModelProvider.Factory factory, CreationExtras creationExtras) {
        viewModelStore.getClass();
        factory.getClass();
        creationExtras.getClass();
        this.store = viewModelStore;
        this.factory = factory;
        this.defaultExtras = creationExtras;
        this.lock = new SynchronizedObject();
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel$default(ViewModelProviderImpl viewModelProviderImpl, c cVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel(cVar);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel(cVar, str);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel(c cVar, String str) {
        T t9;
        cVar.getClass();
        str.getClass();
        synchronized (this.lock) {
            try {
                t9 = (T) this.store.get(str);
                if (((f) cVar).d(t9)) {
                    if (this.factory instanceof ViewModelProvider.OnRequeryFactory) {
                        ViewModelProvider.OnRequeryFactory onRequeryFactory = (ViewModelProvider.OnRequeryFactory) this.factory;
                        t9.getClass();
                        onRequeryFactory.onRequery(t9);
                    }
                    t9.getClass();
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultExtras);
                    mutableCreationExtras.set(ViewModelProvider.VIEW_MODEL_KEY, str);
                    t9 = (T) ViewModelProviderImpl_androidKt.createViewModel(this.factory, cVar, mutableCreationExtras);
                    this.store.put(str, t9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t9;
    }
}
