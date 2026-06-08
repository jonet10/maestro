package androidx.datastore.preferences;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import d7.l;
import f7.a;
import j7.k;
import java.util.List;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements a {

    @GuardedBy("lock")
    private volatile DataStore<Preferences> INSTANCE;
    private final ReplaceFileCorruptionHandler<Preferences> corruptionHandler;
    private final Object lock;
    private final String name;
    private final l produceMigrations;
    private final a0 scope;

    public PreferenceDataStoreSingletonDelegate(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, a0 a0Var) {
        str.getClass();
        lVar.getClass();
        a0Var.getClass();
        this.name = str;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = a0Var;
        this.lock = new Object();
    }

    @Override // f7.a
    public DataStore<Preferences> getValue(Context context, k kVar) {
        DataStore<Preferences> dataStore;
        context.getClass();
        kVar.getClass();
        DataStore<Preferences> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.INSTANCE;
                    ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    applicationContext.getClass();
                    this.INSTANCE = preferenceDataStoreFactory.create(replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) lVar.invoke(applicationContext), this.scope, new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
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
