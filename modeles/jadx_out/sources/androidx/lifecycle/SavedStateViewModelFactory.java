package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        savedStateRegistryOwner.getClass();
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        this.factory = application != null ? ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application) : new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        List list;
        Constructor findMatchingConstructor;
        List list2;
        cls.getClass();
        creationExtras.getClass();
        String str = (String) creationExtras.get(ViewModelProvider.VIEW_MODEL_KEY);
        if (str == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (creationExtras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null || creationExtras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) {
            if (this.lifecycle != null) {
                return (T) create(str, cls);
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        if (!isAssignableFrom || application == null) {
            list = SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE;
            findMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, list);
        } else {
            list2 = SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE;
            findMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, list2);
        }
        return findMatchingConstructor == null ? (T) this.factory.create(cls, creationExtras) : (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactory_androidKt.newInstance(cls, findMatchingConstructor, SavedStateHandleSupport.createSavedStateHandle(creationExtras)) : (T) SavedStateViewModelFactory_androidKt.newInstance(cls, findMatchingConstructor, application, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        viewModel.getClass();
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            savedStateRegistry.getClass();
            Lifecycle lifecycle = this.lifecycle;
            lifecycle.getClass();
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
        savedStateRegistryOwner.getClass();
    }

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(j7.c cVar, CreationExtras creationExtras) {
        cVar.getClass();
        creationExtras.getClass();
        return (T) create(d0.b.F(cVar), creationExtras);
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        List list;
        Constructor findMatchingConstructor;
        T t9;
        Application application;
        List list2;
        str.getClass();
        cls.getClass();
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.application == null) {
                list = SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE;
                findMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, list);
            } else {
                list2 = SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE;
                findMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, list2);
            }
            if (findMatchingConstructor == null) {
                return this.application != null ? (T) this.factory.create(cls) : (T) ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(cls);
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            savedStateRegistry.getClass();
            SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, str, this.defaultArgs);
            if (!isAssignableFrom || (application = this.application) == null) {
                t9 = (T) SavedStateViewModelFactory_androidKt.newInstance(cls, findMatchingConstructor, create.getHandle());
            } else {
                application.getClass();
                t9 = (T) SavedStateViewModelFactory_androidKt.newInstance(cls, findMatchingConstructor, application, create.getHandle());
            }
            t9.addCloseable(LegacySavedStateHandleController.TAG_SAVED_STATE_HANDLE_CONTROLLER, create);
            return t9;
        }
        a3.b.r("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        cls.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        com.google.gson.internal.a.p("Local and anonymous classes can not be ViewModels");
        return null;
    }
}
