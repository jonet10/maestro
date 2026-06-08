package androidx.datastore.core;

import d7.l;
import kotlin.jvm.internal.m;
import p6.f;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$writeActor$1 extends m implements l {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeActor$1(DataStoreImpl<T> dataStoreImpl) {
        super(1);
        this.this$0 = dataStoreImpl;
    }

    public final void invoke(Throwable th) {
        f fVar;
        if (th != null) {
            ((DataStoreImpl) this.this$0).inMemoryCache.tryUpdate(new Final(th));
        }
        fVar = ((DataStoreImpl) this.this$0).storageConnectionDelegate;
        if (fVar.isInitialized()) {
            this.this$0.getStorageConnection$datastore_core_release().close();
        }
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f8463a;
    }
}
