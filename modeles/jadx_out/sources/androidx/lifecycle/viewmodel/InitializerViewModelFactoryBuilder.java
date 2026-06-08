package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.CanonicalName_jvmKt;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import d7.l;
import j7.c;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ViewModelFactoryDsl
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InitializerViewModelFactoryBuilder {
    private final Map<c, ViewModelInitializer<?>> initializers = new LinkedHashMap();

    public final <T extends ViewModel> void addInitializer(c cVar, l lVar) {
        cVar.getClass();
        lVar.getClass();
        if (!this.initializers.containsKey(cVar)) {
            this.initializers.put(cVar, new ViewModelInitializer<>(cVar, lVar));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + CanonicalName_jvmKt.getCanonicalName(cVar) + '.').toString());
    }

    public final ViewModelProvider.Factory build() {
        return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel(this.initializers.values());
    }
}
