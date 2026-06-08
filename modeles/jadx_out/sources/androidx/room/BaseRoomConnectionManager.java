package androidx.room;

import a4.x;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import d7.p;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.l;
import l7.u;
import p6.i;
import p6.j;
import p6.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    public static final Companion Companion = new Companion(null);
    private boolean isConfigured;
    private boolean isInitializing;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver sQLiteDriver) {
            sQLiteDriver.getClass();
            this.this$0 = baseRoomConnectionManager;
            this.actual = sQLiteDriver;
        }

        private final SQLiteConnection openLocked(final String str) {
            return (SQLiteConnection) new ExclusiveLock(str, (this.this$0.isConfigured || this.this$0.isInitializing || l.a(str, ":memory:")) ? false : true).withLock(new c(this.this$0, this, str, 0), new d7.l() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // d7.l
                public final Void invoke(Throwable th) {
                    th.getClass();
                    throw new IllegalStateException(x.n(new StringBuilder("Unable to open database '"), str, "'. Was a proper path / name used in Room's database builder?"), th);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (baseRoomConnectionManager.isInitializing) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
                return null;
            }
            SQLiteConnection open = driverWrapper.actual.open(str);
            if (baseRoomConnectionManager.isConfigured) {
                baseRoomConnectionManager.configurationConnection(open);
                return open;
            }
            try {
                baseRoomConnectionManager.isInitializing = true;
                baseRoomConnectionManager.configureDatabase(open);
                return open;
            } finally {
                baseRoomConnectionManager.isInitializing = false;
            }
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection open(String str) {
            str.getClass();
            return openLocked(this.this$0.resolveFileName$room_runtime_release(str));
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkIdentity(SQLiteConnection sQLiteConnection) {
        Object jVar;
        RoomOpenDelegate.ValidationResult onValidateSchema;
        if (hasRoomMasterTable(sQLiteConnection)) {
            SQLiteStatement prepare = sQLiteConnection.prepare(RoomMasterTable.READ_QUERY);
            try {
                String text = prepare.step() ? prepare.getText(0) : null;
                t0.f.g(prepare, null);
                if (l.a(getOpenDelegate().getIdentityHash(), text) || l.a(getOpenDelegate().getLegacyIdentityHash(), text)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + text).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    t0.f.g(prepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        } catch (Throwable th3) {
            jVar = new j(th3);
        }
        if (!onValidateSchema.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
        }
        getOpenDelegate().onPostMigrate(sQLiteConnection);
        updateIdentity(sQLiteConnection);
        jVar = p6.x.f8463a;
        if (!(jVar instanceof j)) {
            SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
        }
        Throwable a8 = k.a(jVar);
        if (a8 == null) {
            return;
        }
        SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
        throw a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection sQLiteConnection) {
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
    }

    private final void configureBusyTimeout(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA busy_timeout");
        try {
            prepare.step();
            long j = prepare.getLong(0);
            t0.f.g(prepare, null);
            if (j < 3000) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t0.f.g(prepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection sQLiteConnection) {
        Object jVar;
        configureJournalMode(sQLiteConnection);
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA user_version");
        try {
            prepare.step();
            int i = (int) prepare.getLong(0);
            t0.f.g(prepare, null);
            if (i != getOpenDelegate().getVersion()) {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        onCreate(sQLiteConnection);
                    } else {
                        onMigrate(sQLiteConnection, i, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(sQLiteConnection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    jVar = p6.x.f8463a;
                } catch (Throwable th) {
                    jVar = new j(th);
                }
                if (!(jVar instanceof j)) {
                    SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                }
                Throwable a8 = k.a(jVar);
                if (a8 != null) {
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw a8;
                }
            }
            onOpen(sQLiteConnection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
    }

    private final void dropAllTables(SQLiteConnection sQLiteConnection) {
        if (!getConfiguration().allowDestructiveMigrationForAllTables) {
            getOpenDelegate().dropAllTables(sQLiteConnection);
            return;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            r6.c t9 = a.a.t();
            while (prepare.step()) {
                String text = prepare.getText(0);
                if (!u.p0(text, "sqlite_", false) && !text.equals("android_metadata")) {
                    t9.add(new i(text, Boolean.valueOf(l.a(prepare.getText(1), "view"))));
                }
            }
            r6.c m10 = a.a.m(t9);
            t0.f.g(prepare, null);
            ListIterator listIterator = m10.listIterator(0);
            while (true) {
                r6.a aVar = (r6.a) listIterator;
                if (!aVar.hasNext()) {
                    return;
                }
                i iVar = (i) aVar.next();
                String str = (String) iVar.f8441a;
                if (((Boolean) iVar.f8442b).booleanValue()) {
                    SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS " + str);
                } else {
                    SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS " + str);
                }
            }
        } finally {
        }
    }

    private final boolean hasEmptySchema(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z9 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) == 0) {
                    z9 = true;
                }
            }
            t0.f.g(prepare, null);
            return z9;
        } finally {
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z9 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) != 0) {
                    z9 = true;
                }
            }
            t0.f.g(prepare, null);
            return z9;
        } finally {
        }
    }

    private final void invokeCreateCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(sQLiteConnection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(sQLiteConnection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(sQLiteConnection);
        }
    }

    private final void updateIdentity(SQLiteConnection sQLiteConnection) {
        createMasterTableIfNotExists(sQLiteConnection);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    public abstract List<RoomDatabase.Callback> getCallbacks();

    public abstract DatabaseConfiguration getConfiguration();

    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1 || i == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    public abstract RoomOpenDelegate getOpenDelegate();

    public final void onCreate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        boolean hasEmptySchema = hasEmptySchema(sQLiteConnection);
        getOpenDelegate().createAllTables(sQLiteConnection);
        if (!hasEmptySchema) {
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(sQLiteConnection);
        getOpenDelegate().onCreate(sQLiteConnection);
        invokeCreateCallback(sQLiteConnection);
    }

    public final void onMigrate(SQLiteConnection sQLiteConnection, int i, int i6) {
        sQLiteConnection.getClass();
        List<Migration> findMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, i, i6);
        if (findMigrationPath == null) {
            if (!MigrationUtil.isMigrationRequired(getConfiguration(), i, i6)) {
                dropAllTables(sQLiteConnection);
                invokeDestructiveMigrationCallback(sQLiteConnection);
                getOpenDelegate().createAllTables(sQLiteConnection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i + " to " + i6 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        getOpenDelegate().onPreMigrate(sQLiteConnection);
        Iterator<T> it = findMigrationPath.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).migrate(sQLiteConnection);
        }
        RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        if (onValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(sQLiteConnection);
            updateIdentity(sQLiteConnection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg).toString());
        }
    }

    public final void onOpen(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        checkIdentity(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
        invokeOpenCallback(sQLiteConnection);
        this.isConfigured = true;
    }

    public String resolveFileName$room_runtime_release(String str) {
        str.getClass();
        return str;
    }

    public abstract <R> Object useConnection(boolean z9, p pVar, t6.c cVar);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
