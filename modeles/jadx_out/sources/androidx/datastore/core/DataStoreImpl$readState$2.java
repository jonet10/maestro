package androidx.datastore.core;

import d7.p;
import o7.a0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", l = {218, 226}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readState$2 extends i implements p {
    final /* synthetic */ boolean $requireLock;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readState$2(DataStoreImpl<T> dataStoreImpl, boolean z9, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
        this.$requireLock = z9;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new DataStoreImpl$readState$2(this.this$0, this.$requireLock, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((DataStoreImpl$readState$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r5 == r3) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r5 == r3) goto L22;
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
            if (r0 == 0) goto L1d
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            p6.a.e(r5)
            goto L4f
        L10:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L17:
            p6.a.e(r5)     // Catch: java.lang.Throwable -> L1b
            goto L42
        L1b:
            r5 = move-exception
            goto L52
        L1d:
            p6.a.e(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
            androidx.datastore.core.State r5 = r5.getCurrentState()
            boolean r5 = r5 instanceof androidx.datastore.core.Final
            androidx.datastore.core.DataStoreImpl<T> r0 = r4.this$0
            if (r5 == 0) goto L39
            androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r0)
            androidx.datastore.core.State r5 = r5.getCurrentState()
            return r5
        L39:
            r4.label = r2     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readAndInitOrPropagateAndThrowFailure(r0, r4)     // Catch: java.lang.Throwable -> L1b
            if (r5 != r3) goto L42
            goto L4e
        L42:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            boolean r0 = r4.$requireLock
            r4.label = r1
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataAndUpdateCache(r5, r0, r4)
            if (r5 != r3) goto L4f
        L4e:
            return r3
        L4f:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            return r5
        L52:
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r1 = -1
            r0.<init>(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
