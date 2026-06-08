package androidx.datastore.core;

import com.google.android.material.card.MaterialCardViewHelper;
import d7.l;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {298, MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readDataAndUpdateCache$3 extends i implements l {
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$3(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(1, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // v6.a
    public final c create(c cVar) {
        return new DataStoreImpl$readDataAndUpdateCache$3(this.this$0, cVar);
    }

    @Override // d7.l
    public final Object invoke(c cVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$3) create(cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r5 != r3) goto L22;
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
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1b
            if (r0 != r1) goto L14
            java.lang.Object r0 = r4.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            p6.a.e(r5)
            goto L44
        L14:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L1b:
            p6.a.e(r5)     // Catch: java.lang.Throwable -> L1f
            goto L30
        L1f:
            r5 = move-exception
            r0 = r5
            goto L33
        L22:
            p6.a.e(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0     // Catch: java.lang.Throwable -> L1f
            r4.label = r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r5, r2, r4)     // Catch: java.lang.Throwable -> L1f
            if (r5 != r3) goto L30
            goto L43
        L30:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5     // Catch: java.lang.Throwable -> L1f
            goto L50
        L33:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r5)
            r4.L$0 = r0
            r4.label = r1
            java.lang.Object r5 = r5.getVersion(r4)
            if (r5 != r3) goto L44
        L43:
            return r3
        L44:
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r0, r5)
            r5 = r1
        L50:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            p6.i r1 = new p6.i
            r1.<init>(r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
