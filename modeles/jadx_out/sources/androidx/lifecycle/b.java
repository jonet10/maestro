package androidx.lifecycle;

import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f438a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f439b;

    public /* synthetic */ b(Object obj, int i) {
        this.f438a = i;
        this.f439b = obj;
    }

    @Override // d7.a
    public final Object invoke() {
        x _init_$lambda$0;
        SavedStateHandlesVM savedStateHandlesVM;
        switch (this.f438a) {
            case 0:
                _init_$lambda$0 = CoroutineLiveData._init_$lambda$0((CoroutineLiveData) this.f439b);
                return _init_$lambda$0;
            default:
                savedStateHandlesVM = SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) this.f439b);
                return savedStateHandlesVM;
        }
    }
}
