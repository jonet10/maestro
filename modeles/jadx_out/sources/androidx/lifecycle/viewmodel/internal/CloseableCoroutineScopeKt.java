package androidx.lifecycle.viewmodel.internal;

import o7.a0;
import o7.c0;
import o7.m0;
import t6.h;
import t6.i;
import t7.n;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(a0 a0Var) {
        a0Var.getClass();
        return new CloseableCoroutineScope(a0Var);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        h hVar = i.f10314a;
        try {
            e eVar = m0.f8288a;
            hVar = n.f10348a.f8468l;
        } catch (IllegalStateException | p6.h unused) {
        }
        return new CloseableCoroutineScope(hVar.plus(c0.d()));
    }
}
