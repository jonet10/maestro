package androidx.datastore.core;

import d7.p;
import o7.a0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {134, 135}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$incrementCollector$2$1 extends i implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((DataStoreImpl$incrementCollector$2$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        if (r5.collect(r0, r4) == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r5.awaitComplete(r4) == r3) goto L15;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.label
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            p6.a.e(r5)
            goto L4b
        L10:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L17:
            p6.a.e(r5)
            goto L2d
        L1b:
            p6.a.e(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreImpl$InitDataStore r5 = androidx.datastore.core.DataStoreImpl.access$getReadAndInit$p(r5)
            r4.label = r2
            java.lang.Object r5 = r5.awaitComplete(r4)
            if (r5 != r3) goto L2d
            goto L4a
        L2d:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r5)
            r7.h r5 = r5.getUpdateNotifications()
            r7.h r5 = r7.k0.g(r5)
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1
            androidx.datastore.core.DataStoreImpl<T> r2 = r4.this$0
            r0.<init>()
            r4.label = r1
            java.lang.Object r5 = r5.collect(r0, r4)
            if (r5 != r3) goto L4b
        L4a:
            return r3
        L4b:
            p6.x r5 = p6.x.f8463a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
