package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ViewModelProvider {
    public static final Companion Companion = new Companion(null);
    public static final CreationExtras.Key<String> VIEW_MODEL_KEY;
    private final ViewModelProviderImpl impl;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final Factory from(ViewModelInitializer<?>... viewModelInitializerArr) {
                viewModelInitializerArr.getClass();
                return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel((ViewModelInitializer<?>[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }

        <T extends ViewModel> T create(j7.c cVar, CreationExtras creationExtras);

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            viewModel.getClass();
        }
    }

    static {
        CreationExtras.Companion companion = CreationExtras.Companion;
        VIEW_MODEL_KEY = new CreationExtras.Key<String>() { // from class: androidx.lifecycle.ViewModelProvider$special$$inlined$Key$1
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r4) {
        /*
            r3 = this;
            r4.getClass()
            androidx.lifecycle.ViewModelStore r0 = r4.getViewModelStore()
            androidx.lifecycle.viewmodel.internal.ViewModelProviders r1 = androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE
            androidx.lifecycle.ViewModelProvider$Factory r2 = r1.getDefaultFactory$lifecycle_viewmodel(r4)
            androidx.lifecycle.viewmodel.CreationExtras r4 = r1.getDefaultCreationExtras$lifecycle_viewmodel(r4)
            r3.<init>(r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    public static final ViewModelProvider create(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        return Companion.create(viewModelStore, factory, creationExtras);
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        str.getClass();
        cls.getClass();
        return (T) this.impl.getViewModel$lifecycle_viewmodel(y.a(cls), str);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY;
        public static final Companion Companion = new Companion(null);
        private static AndroidViewModelFactory _instance;
        private final Application application;

        static {
            CreationExtras.Companion companion = CreationExtras.Companion;
            APPLICATION_KEY = new CreationExtras.Key<Application>() { // from class: androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$special$$inlined$Key$1
            };
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, 0);
            application.getClass();
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                T newInstance = cls.getConstructor(Application.class).newInstance(application);
                newInstance.getClass();
                return newInstance;
            } catch (IllegalAccessException e10) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e10);
                return null;
            } catch (InstantiationException e11) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e11);
                return null;
            } catch (NoSuchMethodException e12) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e12);
                return null;
            } catch (InvocationTargetException e13) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e13);
                return null;
            }
        }

        public static final AndroidViewModelFactory getInstance(Application application) {
            return Companion.getInstance(application);
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                application.getClass();
                if (AndroidViewModelFactory._instance == null) {
                    AndroidViewModelFactory._instance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory._instance;
                androidViewModelFactory.getClass();
                return androidViewModelFactory;
            }

            private Companion() {
            }
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        private AndroidViewModelFactory(Application application, int i) {
            this.application = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            cls.getClass();
            Application application = this.application;
            if (application != null) {
                return (T) create(cls, application);
            }
            a3.b.r("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            cls.getClass();
            creationExtras.getClass();
            if (this.application != null) {
                return (T) create(cls);
            }
            Application application = (Application) creationExtras.get(APPLICATION_KEY);
            if (application != null) {
                return (T) create(cls, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            com.google.gson.internal.a.p("CreationExtras must have an application by `APPLICATION_KEY`");
            return null;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = ViewModelProvider.VIEW_MODEL_KEY;
        private static NewInstanceFactory _instance;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(j7.c cVar, CreationExtras creationExtras) {
            cVar.getClass();
            creationExtras.getClass();
            return (T) create(d0.b.F(cVar), creationExtras);
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory._instance == null) {
                    NewInstanceFactory._instance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory._instance;
                newInstanceFactory.getClass();
                return newInstanceFactory;
            }

            private Companion() {
            }

            public static /* synthetic */ void getInstance$annotations() {
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            cls.getClass();
            creationExtras.getClass();
            return (T) create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            cls.getClass();
            return (T) JvmViewModelProviders.INSTANCE.createViewModel(cls);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras, int i, Object obj) {
            if ((i & 2) != 0) {
                factory = ViewModelProviders.INSTANCE.getDefaultFactory$lifecycle_viewmodel(viewModelStoreOwner);
            }
            if ((i & 4) != 0) {
                creationExtras = ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel(viewModelStoreOwner);
            }
            return companion.create(viewModelStoreOwner, factory, creationExtras);
        }

        public final ViewModelProvider create(ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras) {
            viewModelStoreOwner.getClass();
            factory.getClass();
            creationExtras.getClass();
            return new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), factory, creationExtras);
        }

        private Companion() {
        }

        public final ViewModelProvider create(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
            viewModelStore.getClass();
            factory.getClass();
            creationExtras.getClass();
            return new ViewModelProvider(viewModelStore, factory, creationExtras);
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion companion, ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i, Object obj) {
            if ((i & 2) != 0) {
                factory = DefaultViewModelProviderFactory.INSTANCE;
            }
            if ((i & 4) != 0) {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            return companion.create(viewModelStore, factory, creationExtras);
        }
    }

    public static final ViewModelProvider create(ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras) {
        return Companion.create(viewModelStoreOwner, factory, creationExtras);
    }

    @MainThread
    public final <T extends ViewModel> T get(j7.c cVar) {
        cVar.getClass();
        return (T) ViewModelProviderImpl.getViewModel$lifecycle_viewmodel$default(this.impl, cVar, null, 2, null);
    }

    @MainThread
    public final <T extends ViewModel> T get(String str, j7.c cVar) {
        str.getClass();
        cVar.getClass();
        return (T) this.impl.getViewModel$lifecycle_viewmodel(cVar, str);
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        cls.getClass();
        return (T) get(y.a(cls));
    }

    private ViewModelProvider(ViewModelProviderImpl viewModelProviderImpl) {
        this.impl = viewModelProviderImpl;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i, kotlin.jvm.internal.g gVar) {
        this(viewModelStore, factory, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        this(new ViewModelProviderImpl(viewModelStore, factory, creationExtras));
        viewModelStore.getClass();
        factory.getClass();
        creationExtras.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, null, 4, null);
        viewModelStore.getClass();
        factory.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory, ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel(viewModelStoreOwner));
        viewModelStoreOwner.getClass();
        factory.getClass();
    }
}
