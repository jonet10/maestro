package androidx.datastore.core;

import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", l = {370, 371}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$2 extends i implements p {
    final /* synthetic */ int $preLockVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$2(DataStoreImpl<T> dataStoreImpl, int i, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
        this.$preLockVersion = i;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(this.this$0, this.$preLockVersion, cVar);
        dataStoreImpl$readDataOrHandleCorruption$2.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataOrHandleCorruption$2;
    }

    public final Object invoke(boolean z9, c cVar) {
        return ((DataStoreImpl$readDataOrHandleCorruption$2) create(Boolean.valueOf(z9), cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:
    
        if (r6 == r3) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.label
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L1f
            if (r0 == r2) goto L19
            if (r0 != r1) goto L12
            java.lang.Object r0 = r5.L$0
            p6.a.e(r6)
            goto L47
        L12:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L19:
            boolean r0 = r5.Z$0
            p6.a.e(r6)
            goto L31
        L1f:
            p6.a.e(r6)
            boolean r0 = r5.Z$0
            androidx.datastore.core.DataStoreImpl<T> r6 = r5.this$0
            r5.Z$0 = r0
            r5.label = r2
            java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r6, r5)
            if (r6 != r3) goto L31
            goto L43
        L31:
            if (r0 == 0) goto L4e
            androidx.datastore.core.DataStoreImpl<T> r0 = r5.this$0
            androidx.datastore.core.InterProcessCoordinator r0 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r0)
            r5.L$0 = r6
            r5.label = r1
            java.lang.Object r0 = r0.getVersion(r5)
            if (r0 != r3) goto L44
        L43:
            return r3
        L44:
            r4 = r0
            r0 = r6
            r6 = r4
        L47:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            goto L53
        L4e:
            int r0 = r5.$preLockVersion
            r4 = r0
            r0 = r6
            r6 = r4
        L53:
            androidx.datastore.core.Data r1 = new androidx.datastore.core.Data
            if (r0 == 0) goto L5c
            int r2 = r0.hashCode()
            goto L5d
        L5c:
            r2 = 0
        L5d:
            r1.<init>(r0, r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // d7.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (c) obj2);
    }
}
