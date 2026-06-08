package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements p6.f {
    private VM cached;
    private final d7.a extrasProducer;
    private final d7.a factoryProducer;
    private final d7.a storeProducer;
    private final j7.c viewModelClass;

    public ViewModelLazy(j7.c cVar, d7.a aVar, d7.a aVar2, d7.a aVar3) {
        cVar.getClass();
        aVar.getClass();
        aVar2.getClass();
        aVar3.getClass();
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    @Override // p6.f
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) ViewModelProvider.Companion.create((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    @Override // p6.f
    public boolean isInitialized() {
        return this.cached != null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(j7.c cVar, d7.a aVar, d7.a aVar2) {
        this(cVar, aVar, aVar2, null, 8, null);
        cVar.getClass();
        aVar.getClass();
        aVar2.getClass();
    }

    public /* synthetic */ ViewModelLazy(j7.c cVar, d7.a aVar, d7.a aVar2, d7.a aVar3, int i, kotlin.jvm.internal.g gVar) {
        this(cVar, aVar, aVar2, (i & 8) != 0 ? new k(0) : aVar3);
    }
}
