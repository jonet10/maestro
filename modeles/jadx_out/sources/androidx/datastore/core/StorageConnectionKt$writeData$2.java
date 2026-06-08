package androidx.datastore.core;

import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", l = {77}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StorageConnectionKt$writeData$2 extends i implements p {
    final /* synthetic */ T $value;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageConnectionKt$writeData$2(T t9, c cVar) {
        super(2, cVar);
        this.$value = t9;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        StorageConnectionKt$writeData$2 storageConnectionKt$writeData$2 = new StorageConnectionKt$writeData$2(this.$value, cVar);
        storageConnectionKt$writeData$2.L$0 = obj;
        return storageConnectionKt$writeData$2;
    }

    @Override // d7.p
    public final Object invoke(WriteScope<T> writeScope, c cVar) {
        return ((StorageConnectionKt$writeData$2) create(writeScope, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            WriteScope writeScope = (WriteScope) this.L$0;
            T t9 = this.$value;
            this.label = 1;
            Object writeData = writeScope.writeData(t9, this);
            u6.a aVar = u6.a.f10762a;
            if (writeData == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
