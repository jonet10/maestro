package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ActivityViewModelLazyKt {
    @MainThread
    public static final <VM extends ViewModel> p6.f viewModels(ComponentActivity componentActivity, d7.a aVar) {
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        l.h();
        throw null;
    }

    public static p6.f viewModels$default(ComponentActivity componentActivity, d7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        l.h();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> p6.f viewModels(ComponentActivity componentActivity, d7.a aVar, d7.a aVar2) {
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        l.h();
        throw null;
    }

    public static p6.f viewModels$default(ComponentActivity componentActivity, d7.a aVar, d7.a aVar2, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar2 = null;
        }
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        l.h();
        throw null;
    }
}
