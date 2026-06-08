package androidx.activity;

import kotlin.jvm.internal.k;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends k implements d7.a {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m4invoke() {
        ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }

    @Override // d7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m4invoke();
        return x.f8463a;
    }
}
