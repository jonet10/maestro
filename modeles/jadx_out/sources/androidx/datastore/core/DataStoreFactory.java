package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import o7.a0;
import o7.c0;
import o7.m0;
import q6.t;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreFactory {
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, d7.a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2 = replaceFileCorruptionHandler;
        if ((i & 4) != 0) {
            list = t.f8724a;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            e eVar = m0.f8288a;
            a0Var = c0.b(d.f10884a.plus(c0.d()));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, a0Var, aVar);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, a0 a0Var) {
        storage.getClass();
        list.getClass();
        a0Var.getClass();
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, a.a.H(DataMigrationInitializer.Companion.getInitializer(list)), replaceFileCorruptionHandler, a0Var);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, d7.a aVar) {
        serializer.getClass();
        list.getClass();
        aVar.getClass();
        return create$default(this, serializer, replaceFileCorruptionHandler, list, null, aVar, 8, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, d7.a aVar) {
        serializer.getClass();
        aVar.getClass();
        return create$default(this, serializer, null, null, null, aVar, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        storage.getClass();
        return create$default(this, storage, null, null, null, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        storage.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, null, null, 12, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list) {
        storage.getClass();
        list.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, list, null, 8, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, a0 a0Var, d7.a aVar) {
        serializer.getClass();
        list.getClass();
        a0Var.getClass();
        aVar.getClass();
        return create(new FileStorage(serializer, null, aVar, 2, null), replaceFileCorruptionHandler, list, a0Var);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, d7.a aVar) {
        serializer.getClass();
        aVar.getClass();
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, aVar, 12, null);
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            list = t.f8724a;
        }
        if ((i & 8) != 0) {
            a0Var = c0.b(Actual_jvmKt.ioDispatcher().plus(c0.d()));
        }
        return dataStoreFactory.create(storage, replaceFileCorruptionHandler, list, a0Var);
    }
}
