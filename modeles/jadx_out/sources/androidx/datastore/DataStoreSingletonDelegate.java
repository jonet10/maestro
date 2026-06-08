package androidx.datastore;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import d7.l;
import f7.a;
import j7.k;
import java.util.List;
import o7.a0;
import w8.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreSingletonDelegate<T> implements a {

    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    private final String fileName;
    private final Object lock;
    private final l produceMigrations;
    private final a0 scope;
    private final OkioSerializer<T> serializer;

    public DataStoreSingletonDelegate(String str, OkioSerializer<T> okioSerializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, a0 a0Var) {
        str.getClass();
        okioSerializer.getClass();
        lVar.getClass();
        a0Var.getClass();
        this.fileName = str;
        this.serializer = okioSerializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = a0Var;
        this.lock = new Object();
    }

    @Override // f7.a
    public DataStore<T> getValue(Context context, k kVar) {
        DataStore<T> dataStore;
        context.getClass();
        kVar.getClass();
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
                    OkioStorage okioStorage = new OkioStorage(o.f10985a, this.serializer, null, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this), 4, null);
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    applicationContext.getClass();
                    this.INSTANCE = dataStoreFactory.create(okioStorage, replaceFileCorruptionHandler, (List) lVar.invoke(applicationContext), this.scope);
                }
                dataStore = this.INSTANCE;
                dataStore.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
