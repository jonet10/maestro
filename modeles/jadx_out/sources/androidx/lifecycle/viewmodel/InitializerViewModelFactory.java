package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.l;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import j7.c;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        viewModelInitializerArr.getClass();
        this.initializers = viewModelInitializerArr;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <VM extends ViewModel> VM create(Class<VM> cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        ViewModelProviders viewModelProviders = ViewModelProviders.INSTANCE;
        f a8 = y.a(cls);
        ViewModelInitializer<?>[] viewModelInitializerArr = this.initializers;
        return (VM) viewModelProviders.createViewModelFromInitializers$lifecycle_viewmodel(a8, creationExtras, (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        cls.getClass();
        return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return l.a(this, cVar, creationExtras);
    }
}
