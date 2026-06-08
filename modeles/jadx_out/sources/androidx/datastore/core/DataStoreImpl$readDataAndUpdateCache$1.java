package androidx.datastore.core;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {287, 296, 304}, m = "readDataAndUpdateCache")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readDataAndUpdateCache$1 extends c {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$1(DataStoreImpl<T> dataStoreImpl, t6.c cVar) {
        super(cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object readDataAndUpdateCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readDataAndUpdateCache = this.this$0.readDataAndUpdateCache(false, this);
        return readDataAndUpdateCache;
    }
}
