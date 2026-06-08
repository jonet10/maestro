package androidx.datastore.core;

import p6.x;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StorageConnectionKt {
    public static final <T> Object readData(StorageConnection<T> storageConnection, c cVar) {
        return storageConnection.readScope(new StorageConnectionKt$readData$2(null), cVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t9, c cVar) {
        Object writeScope = storageConnection.writeScope(new StorageConnectionKt$writeData$2(t9, null), cVar);
        return writeScope == u6.a.f10762a ? writeScope : x.f8463a;
    }
}
