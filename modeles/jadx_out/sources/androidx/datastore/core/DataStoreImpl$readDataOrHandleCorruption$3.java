package androidx.datastore.core;

import d7.l;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$3 extends i implements l {
    final /* synthetic */ x $newData;
    final /* synthetic */ v $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$3(x xVar, DataStoreImpl<T> dataStoreImpl, v vVar, c cVar) {
        super(1, cVar);
        this.$newData = xVar;
        this.this$0 = dataStoreImpl;
        this.$version = vVar;
    }

    @Override // v6.a
    public final c create(c cVar) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, cVar);
    }

    @Override // d7.l
    public final Object invoke(c cVar) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        if (r6 != r4) goto L28;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.label
            r1 = 3
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r0 == 0) goto L2e
            if (r0 == r3) goto L26
            if (r0 == r2) goto L1e
            if (r0 != r1) goto L17
            java.lang.Object r0 = r5.L$0
            kotlin.jvm.internal.v r0 = (kotlin.jvm.internal.v) r0
            p6.a.e(r6)
            goto L71
        L17:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L1e:
            java.lang.Object r0 = r5.L$0
            kotlin.jvm.internal.v r0 = (kotlin.jvm.internal.v) r0
            p6.a.e(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5e
            goto L55
        L26:
            java.lang.Object r0 = r5.L$0
            kotlin.jvm.internal.x r0 = (kotlin.jvm.internal.x) r0
            p6.a.e(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5e
            goto L40
        L2e:
            p6.a.e(r6)
            kotlin.jvm.internal.x r0 = r5.$newData     // Catch: androidx.datastore.core.CorruptionException -> L5e
            androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L5e
            r5.L$0 = r0     // Catch: androidx.datastore.core.CorruptionException -> L5e
            r5.label = r3     // Catch: androidx.datastore.core.CorruptionException -> L5e
            java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r6, r5)     // Catch: androidx.datastore.core.CorruptionException -> L5e
            if (r6 != r4) goto L40
            goto L70
        L40:
            r0.f7024a = r6     // Catch: androidx.datastore.core.CorruptionException -> L5e
            kotlin.jvm.internal.v r0 = r5.$version     // Catch: androidx.datastore.core.CorruptionException -> L5e
            androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0     // Catch: androidx.datastore.core.CorruptionException -> L5e
            androidx.datastore.core.InterProcessCoordinator r6 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r6)     // Catch: androidx.datastore.core.CorruptionException -> L5e
            r5.L$0 = r0     // Catch: androidx.datastore.core.CorruptionException -> L5e
            r5.label = r2     // Catch: androidx.datastore.core.CorruptionException -> L5e
            java.lang.Object r6 = r6.getVersion(r5)     // Catch: androidx.datastore.core.CorruptionException -> L5e
            if (r6 != r4) goto L55
            goto L70
        L55:
            java.lang.Number r6 = (java.lang.Number) r6     // Catch: androidx.datastore.core.CorruptionException -> L5e
            int r6 = r6.intValue()     // Catch: androidx.datastore.core.CorruptionException -> L5e
            r0.f7022a = r6     // Catch: androidx.datastore.core.CorruptionException -> L5e
            goto L79
        L5e:
            kotlin.jvm.internal.v r0 = r5.$version
            androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0
            kotlin.jvm.internal.x r2 = r5.$newData
            java.lang.Object r2 = r2.f7024a
            r5.L$0 = r0
            r5.label = r1
            java.lang.Object r6 = r6.writeData$datastore_core_release(r2, r3, r5)
            if (r6 != r4) goto L71
        L70:
            return r4
        L71:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r0.f7022a = r6
        L79:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
