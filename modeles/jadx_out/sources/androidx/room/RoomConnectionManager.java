package androidx.room;

import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.coroutines.AndroidSQLiteDriverConnectionPool;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.driver.SupportSQLiteConnectionPool;
import androidx.room.driver.SupportSQLiteDriver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.AndroidSQLiteDriver;
import d7.l;
import d7.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p6.x;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomConnectionManager extends BaseRoomConnectionManager {
    private final List<RoomDatabase.Callback> callbacks;
    private final DatabaseConfiguration configuration;
    private final ConnectionPool connectionPool;
    private final RoomOpenDelegate openDelegate;
    private SupportSQLiteDatabase supportDatabase;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class NoOpOpenDelegate extends RoomOpenDelegate {
        public NoOpOpenDelegate() {
            super(-1, "", "");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void createAllTables(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void dropAllTables(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onCreate(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onOpen(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPostMigrate(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPreMigrate(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class SupportOpenHelperCallback extends SupportSQLiteOpenHelper.Callback {
        public SupportOpenHelperCallback(int i) {
            super(i);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
            RoomConnectionManager.this.onCreate(new SupportSQLiteConnection(supportSQLiteDatabase));
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i6) {
            supportSQLiteDatabase.getClass();
            onUpgrade(supportSQLiteDatabase, i, i6);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
            RoomConnectionManager.this.onOpen(new SupportSQLiteConnection(supportSQLiteDatabase));
            RoomConnectionManager.this.supportDatabase = supportSQLiteDatabase;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i6) {
            supportSQLiteDatabase.getClass();
            RoomConnectionManager.this.onMigrate(new SupportSQLiteConnection(supportSQLiteDatabase), i, i6);
        }
    }

    public RoomConnectionManager(DatabaseConfiguration databaseConfiguration, RoomOpenDelegate roomOpenDelegate) {
        ConnectionPool newSingleConnectionPool;
        databaseConfiguration.getClass();
        roomOpenDelegate.getClass();
        this.configuration = databaseConfiguration;
        this.openDelegate = roomOpenDelegate;
        List<RoomDatabase.Callback> list = databaseConfiguration.callbacks;
        this.callbacks = list == null ? t.f8724a : list;
        SQLiteDriver sQLiteDriver = databaseConfiguration.sqliteDriver;
        if (sQLiteDriver != null) {
            if (sQLiteDriver instanceof AndroidSQLiteDriver) {
                BaseRoomConnectionManager.DriverWrapper driverWrapper = new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver);
                String str = databaseConfiguration.name;
                newSingleConnectionPool = new AndroidSQLiteDriverConnectionPool(driverWrapper, str != null ? str : ":memory:");
            } else {
                newSingleConnectionPool = databaseConfiguration.name == null ? ConnectionPoolKt.newSingleConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), ":memory:") : ConnectionPoolKt.newConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), databaseConfiguration.name, getMaxNumberOfReaders(databaseConfiguration.journalMode), getMaxNumberOfWriters(databaseConfiguration.journalMode));
            }
            this.connectionPool = newSingleConnectionPool;
        } else {
            if (databaseConfiguration.sqliteOpenHelperFactory == null) {
                com.google.gson.internal.a.p("SQLiteManager was constructed with both null driver and open helper factory!");
                throw null;
            }
            this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver(databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.Companion.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new SupportOpenHelperCallback(roomOpenDelegate.getVersion())).build())));
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$1(RoomConnectionManager roomConnectionManager, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        roomConnectionManager.supportDatabase = supportSQLiteDatabase;
        return x.f8463a;
    }

    private final void init() {
        boolean z9 = getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            supportOpenHelper$room_runtime_release.setWriteAheadLoggingEnabled(z9);
        }
    }

    private final DatabaseConfiguration installOnOpenCallback(DatabaseConfiguration databaseConfiguration, final l lVar) {
        Collection collection = databaseConfiguration.callbacks;
        if (collection == null) {
            collection = t.f8724a;
        }
        Collection collection2 = collection;
        RoomDatabase.Callback callback = new RoomDatabase.Callback() { // from class: androidx.room.RoomConnectionManager$installOnOpenCallback$newCallbacks$1
            @Override // androidx.room.RoomDatabase.Callback
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.getClass();
                l.this.invoke(supportSQLiteDatabase);
            }
        };
        ArrayList arrayList = new ArrayList(collection2.size() + 1);
        arrayList.addAll(collection2);
        arrayList.add(callback);
        return DatabaseConfiguration.copy$default(databaseConfiguration, null, null, null, null, arrayList, false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    public final void close() {
        this.connectionPool.close();
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public List<RoomDatabase.Callback> getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public DatabaseConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public RoomOpenDelegate getOpenDelegate() {
        return this.openDelegate;
    }

    public final SupportSQLiteOpenHelper getSupportOpenHelper$room_runtime_release() {
        SupportSQLiteDriver supportDriver$room_runtime_release;
        ConnectionPool connectionPool = this.connectionPool;
        SupportSQLiteConnectionPool supportSQLiteConnectionPool = connectionPool instanceof SupportSQLiteConnectionPool ? (SupportSQLiteConnectionPool) connectionPool : null;
        if (supportSQLiteConnectionPool == null || (supportDriver$room_runtime_release = supportSQLiteConnectionPool.getSupportDriver$room_runtime_release()) == null) {
            return null;
        }
        return supportDriver$room_runtime_release.getOpenHelper();
    }

    public final boolean isSupportDatabaseOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.supportDatabase;
        if (supportSQLiteDatabase != null) {
            return supportSQLiteDatabase.isOpen();
        }
        return false;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public String resolveFileName$room_runtime_release(String str) {
        str.getClass();
        if (str.equals(":memory:")) {
            return str;
        }
        String absolutePath = getConfiguration().context.getDatabasePath(str).getAbsolutePath();
        absolutePath.getClass();
        return absolutePath;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    public <R> Object useConnection(boolean z9, p pVar, t6.c cVar) {
        return this.connectionPool.useConnection(z9, pVar, cVar);
    }

    public RoomConnectionManager(DatabaseConfiguration databaseConfiguration, l lVar) {
        databaseConfiguration.getClass();
        lVar.getClass();
        this.configuration = databaseConfiguration;
        this.openDelegate = new NoOpOpenDelegate();
        List<RoomDatabase.Callback> list = databaseConfiguration.callbacks;
        this.callbacks = list == null ? t.f8724a : list;
        this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver((SupportSQLiteOpenHelper) lVar.invoke(installOnOpenCallback(databaseConfiguration, new b(this, 2)))));
        init();
    }
}
