package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import kotlin.jvm.internal.l;
import p6.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    public static final <VM extends ViewModel> f activityViewModels(Fragment fragment, d7.a aVar) {
        fragment.getClass();
        l.h();
        throw null;
    }

    public static f activityViewModels$default(Fragment fragment, d7.a aVar, int i, Object obj) {
        fragment.getClass();
        l.h();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> f createViewModelLazy(Fragment fragment, j7.c cVar, d7.a aVar, d7.a aVar2) {
        fragment.getClass();
        cVar.getClass();
        aVar.getClass();
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(cVar, aVar, aVar2);
    }

    public static /* synthetic */ f createViewModelLazy$default(Fragment fragment, j7.c cVar, d7.a aVar, d7.a aVar2, int i, Object obj) {
        if ((i & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, cVar, aVar, aVar2);
    }

    @MainThread
    public static final <VM extends ViewModel> f viewModels(Fragment fragment, d7.a aVar, d7.a aVar2) {
        fragment.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    public static f viewModels$default(Fragment fragment, d7.a aVar, d7.a aVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        fragment.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }
}
