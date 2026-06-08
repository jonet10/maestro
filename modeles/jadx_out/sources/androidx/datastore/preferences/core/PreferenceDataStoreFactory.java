package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import d7.a;
import java.util.List;
import o7.a0;
import o7.c0;
import o7.m0;
import q6.t;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            list = t.f8724a;
        }
        if ((i & 8) != 0) {
            a0Var = c0.b(Actual_jvmAndroidKt.ioDispatcher().plus(c0.d()));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, a0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 2) != 0) {
            list = t.f8724a;
        }
        if ((i & 4) != 0) {
            a0Var = c0.b(Actual_jvmAndroidKt.ioDispatcher().plus(c0.d()));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, a0Var, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a0 a0Var, a aVar) {
        list.getClass();
        a0Var.getClass();
        aVar.getClass();
        return new PreferenceDataStore(create(new FileStorage(PreferencesFileSerializer.INSTANCE, null, new PreferenceDataStoreFactory$create$delegate$1(aVar), 2, null), replaceFileCorruptionHandler, list, a0Var));
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a0 a0Var, a aVar) {
        list.getClass();
        a0Var.getClass();
        aVar.getClass();
        return create(replaceFileCorruptionHandler, list, a0Var, new PreferenceDataStoreFactory$createWithPath$1(aVar));
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        list.getClass();
        aVar.getClass();
        return createWithPath$default(this, replaceFileCorruptionHandler, list, null, aVar, 4, null);
    }

    public final DataStore<Preferences> createWithPath(a aVar) {
        aVar.getClass();
        return createWithPath$default(this, null, null, null, aVar, 7, null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        aVar.getClass();
        return createWithPath$default(this, replaceFileCorruptionHandler, null, null, aVar, 6, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        storage.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (a0) null, 12, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list) {
        storage.getClass();
        list.getClass();
        return create$default(this, storage, replaceFileCorruptionHandler, list, (a0) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 2) != 0) {
            list = t.f8724a;
        }
        if ((i & 4) != 0) {
            e eVar = m0.f8288a;
            a0Var = c0.b(d.f10884a.plus(c0.d()));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, a0Var, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        aVar.getClass();
        return create$default(this, replaceFileCorruptionHandler, (List) null, (a0) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        list.getClass();
        aVar.getClass();
        return create$default(this, replaceFileCorruptionHandler, list, (a0) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> create(a aVar) {
        aVar.getClass();
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (a0) null, aVar, 7, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        storage.getClass();
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (a0) null, 14, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a0 a0Var) {
        storage.getClass();
        list.getClass();
        a0Var.getClass();
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, list, a0Var));
    }
}
