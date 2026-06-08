package androidx.datastore.core;

import d7.q;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StorageConnectionKt$readData$2 extends i implements q {
    private /* synthetic */ Object L$0;
    int label;

    public StorageConnectionKt$readData$2(c cVar) {
        super(3, cVar);
    }

    @Override // d7.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (c) obj3);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        ReadScope readScope = (ReadScope) this.L$0;
        this.label = 1;
        Object readData = readScope.readData(this);
        u6.a aVar = u6.a.f10762a;
        return readData == aVar ? aVar : readData;
    }

    public final Object invoke(ReadScope<T> readScope, boolean z9, c cVar) {
        StorageConnectionKt$readData$2 storageConnectionKt$readData$2 = new StorageConnectionKt$readData$2(cVar);
        storageConnectionKt$readData$2.L$0 = readScope;
        return storageConnectionKt$readData$2.invokeSuspend(x.f8463a);
    }
}
