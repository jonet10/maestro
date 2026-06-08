package androidx.datastore.core;

import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$coordinator$2 extends m implements d7.a {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$coordinator$2(DataStoreImpl<T> dataStoreImpl) {
        super(0);
        this.this$0 = dataStoreImpl;
    }

    @Override // d7.a
    public final InterProcessCoordinator invoke() {
        return this.this$0.getStorageConnection$datastore_core_release().getCoordinator();
    }
}
