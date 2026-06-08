package androidx.datastore.core;

import d7.l;
import d7.p;
import p6.x;
import t6.c;
import t6.h;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {330, 331, 337}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$transformAndWrite$2 extends i implements l {
    final /* synthetic */ h $callerContext;
    final /* synthetic */ p $transform;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2(DataStoreImpl<T> dataStoreImpl, h hVar, p pVar, c cVar) {
        super(1, cVar);
        this.this$0 = dataStoreImpl;
        this.$callerContext = hVar;
        this.$transform = pVar;
    }

    @Override // v6.a
    public final c create(c cVar) {
        return new DataStoreImpl$transformAndWrite$2(this.this$0, this.$callerContext, this.$transform, cVar);
    }

    @Override // d7.l
    public final Object invoke(c cVar) {
        return ((DataStoreImpl$transformAndWrite$2) create(cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if (r9 == r4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r9 == r4) goto L23;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.label
            r1 = 3
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r0 == 0) goto L28
            if (r0 == r3) goto L24
            if (r0 == r2) goto L1c
            if (r0 != r1) goto L15
            java.lang.Object r0 = r8.L$0
            p6.a.e(r9)
            return r0
        L15:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            r9 = 0
            return r9
        L1c:
            java.lang.Object r0 = r8.L$0
            androidx.datastore.core.Data r0 = (androidx.datastore.core.Data) r0
            p6.a.e(r9)
            goto L4e
        L24:
            p6.a.e(r9)
            goto L36
        L28:
            p6.a.e(r9)
            androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
            r8.label = r3
            java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r9, r3, r8)
            if (r9 != r4) goto L36
            goto L67
        L36:
            r0 = r9
            androidx.datastore.core.Data r0 = (androidx.datastore.core.Data) r0
            t6.h r9 = r8.$callerContext
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            d7.p r6 = r8.$transform
            r7 = 0
            r5.<init>(r6, r0, r7)
            r8.L$0 = r0
            r8.label = r2
            java.lang.Object r9 = o7.c0.C(r5, r9, r8)
            if (r9 != r4) goto L4e
            goto L67
        L4e:
            r0.checkHashCode()
            java.lang.Object r0 = r0.getValue()
            boolean r0 = kotlin.jvm.internal.l.a(r0, r9)
            if (r0 != 0) goto L68
            androidx.datastore.core.DataStoreImpl<T> r0 = r8.this$0
            r8.L$0 = r9
            r8.label = r1
            java.lang.Object r0 = r0.writeData$datastore_core_release(r9, r3, r8)
            if (r0 != r4) goto L68
        L67:
            return r4
        L68:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
