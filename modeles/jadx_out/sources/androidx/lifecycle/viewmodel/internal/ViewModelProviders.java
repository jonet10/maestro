package androidx.lifecycle.viewmodel.internal;

import androidx.core.content.pm.a;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import d7.l;
import j7.c;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelProviders {
    public static final ViewModelProviders INSTANCE = new ViewModelProviders();
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    private ViewModelProviders() {
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel(Collection<? extends ViewModelInitializer<?>> collection) {
        collection.getClass();
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) collection.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }

    public final <VM extends ViewModel> VM createViewModelFromInitializers$lifecycle_viewmodel(c cVar, CreationExtras creationExtras, ViewModelInitializer<?>... viewModelInitializerArr) {
        VM vm;
        ViewModelInitializer<?> viewModelInitializer;
        l initializer$lifecycle_viewmodel;
        cVar.getClass();
        creationExtras.getClass();
        viewModelInitializerArr.getClass();
        int length = viewModelInitializerArr.length;
        int i = 0;
        while (true) {
            vm = null;
            if (i >= length) {
                viewModelInitializer = null;
                break;
            }
            viewModelInitializer = viewModelInitializerArr[i];
            if (kotlin.jvm.internal.l.a(viewModelInitializer.getClazz$lifecycle_viewmodel(), cVar)) {
                break;
            }
            i++;
        }
        if (viewModelInitializer != null && (initializer$lifecycle_viewmodel = viewModelInitializer.getInitializer$lifecycle_viewmodel()) != null) {
            vm = (VM) initializer$lifecycle_viewmodel.invoke(creationExtras);
        }
        if (vm != null) {
            return vm;
        }
        a.i(CanonicalName_jvmKt.getCanonicalName(cVar), "No initializer set for given class ");
        return null;
    }

    public final CreationExtras getDefaultCreationExtras$lifecycle_viewmodel(ViewModelStoreOwner viewModelStoreOwner) {
        viewModelStoreOwner.getClass();
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
    }

    public final ViewModelProvider.Factory getDefaultFactory$lifecycle_viewmodel(ViewModelStoreOwner viewModelStoreOwner) {
        viewModelStoreOwner.getClass();
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : DefaultViewModelProviderFactory.INSTANCE;
    }

    public final <T extends ViewModel> String getDefaultKey$lifecycle_viewmodel(c cVar) {
        cVar.getClass();
        String canonicalName = CanonicalName_jvmKt.getCanonicalName(cVar);
        if (canonicalName != null) {
            return "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
        }
        com.google.gson.internal.a.p("Local and anonymous classes can not be ViewModels");
        return null;
    }

    public final <VM extends ViewModel> VM unsupportedCreateViewModel$lifecycle_viewmodel() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel(ViewModelInitializer<?>... viewModelInitializerArr) {
        viewModelInitializerArr.getClass();
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
