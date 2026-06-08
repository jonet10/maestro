package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import q7.s;
import r7.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class g implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f447a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f448b;

    public /* synthetic */ g(Object obj, int i) {
        this.f447a = i;
        this.f448b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f447a) {
            case 0:
                LifecycleKt$eventFlow$1.invokeSuspend$lambda$0((s) this.f448b, lifecycleOwner, event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((o0) this.f448b, lifecycleOwner, event);
                break;
        }
    }
}
