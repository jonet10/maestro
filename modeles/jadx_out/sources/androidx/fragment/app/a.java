package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f420b;

    public /* synthetic */ a(Object obj, int i) {
        this.f419a = i;
        this.f420b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle lambda$init$0;
        Bundle lambda$attachController$4;
        Bundle savedStateProvider$lambda$0;
        switch (this.f419a) {
            case 0:
                lambda$init$0 = ((FragmentActivity) this.f420b).lambda$init$0();
                return lambda$init$0;
            case 1:
                lambda$attachController$4 = ((FragmentManager) this.f420b).lambda$attachController$4();
                return lambda$attachController$4;
            default:
                savedStateProvider$lambda$0 = SavedStateHandleImpl.savedStateProvider$lambda$0((SavedStateHandleImpl) this.f420b);
                return savedStateProvider$lambda$0;
        }
    }
}
