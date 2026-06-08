package androidx.datastore.core;

import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$readDataAndUpdateCache$4 extends i implements p {
    final /* synthetic */ int $cachedVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl<T> dataStoreImpl, int i, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
        this.$cachedVersion = i;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.this$0, this.$cachedVersion, cVar);
        dataStoreImpl$readDataAndUpdateCache$4.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    public final Object invoke(boolean z9, c cVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z9), cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        int i;
        State state;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12 = this.label;
        u6.a aVar = u6.a.f10762a;
        try {
        } catch (Throwable th2) {
            if (z12 != 0) {
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.Z$0 = z12;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != aVar) {
                    th = th2;
                    obj = version;
                    z11 = z12;
                }
            } else {
                th = th2;
                i = this.$cachedVersion;
                z10 = z12;
            }
        }
        if (z12 == 0) {
            p6.a.e(obj);
            boolean z13 = this.Z$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.Z$0 = z13;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(z13, this);
            z12 = z13;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (z12 != 1) {
                if (z12 != 2) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                boolean z14 = this.Z$0;
                th = (Throwable) this.L$0;
                p6.a.e(obj);
                z11 = z14;
                i = ((Number) obj).intValue();
                z10 = z11;
                state = new ReadException(th, i);
                z9 = z10;
                return new p6.i(state, Boolean.valueOf(z9));
            }
            boolean z15 = this.Z$0;
            p6.a.e(obj);
            z12 = z15;
        }
        state = (State) obj;
        z9 = z12;
        return new p6.i(state, Boolean.valueOf(z9));
    }

    @Override // d7.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (c) obj2);
    }
}
