package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.support.QueryInterceptorOpenHelperFactory;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import d7.p;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import p6.i;
import p6.x;
import q6.n;
import q6.t;
import q6.u;
import q6.v;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class RoomDatabase {
    public static final Companion Companion = new Companion(null);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private RoomConnectionManager connectionManager;
    private a0 coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private h transactionContext;
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();
    private final Map<j7.c, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class JournalMode {
        private static final /* synthetic */ w6.a $ENTRIES;
        private static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode AUTOMATIC = new JournalMode("AUTOMATIC", 0);
        public static final JournalMode TRUNCATE = new JournalMode("TRUNCATE", 1);
        public static final JournalMode WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            JournalMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = t0.f.u($values);
        }

        private JournalMode(String str, int i) {
        }

        public static w6.a getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            context.getClass();
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface QueryCallback {
        void onQuery(String str, List<? extends Object> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x beginTransaction$lambda$8(RoomDatabase roomDatabase, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        roomDatabase.internalBeginTransaction();
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper createConnectionManager$lambda$1(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        databaseConfiguration.getClass();
        return roomDatabase.createOpenHelper(databaseConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x endTransaction$lambda$9(RoomDatabase roomDatabase, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        roomDatabase.internalEndTransaction();
        return x.f8463a;
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            getInvalidationTracker().syncBlocking$room_runtime_release();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        getInvalidationTracker().refreshVersionsAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosed() {
        a0 a0Var = this.coroutineScope;
        if (a0Var == null) {
            l.i("coroutineScope");
            throw null;
        }
        c0.h(a0Var);
        getInvalidationTracker().stop$room_runtime_release();
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            roomConnectionManager.close();
        } else {
            l.i("connectionManager");
            throw null;
        }
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj != null) {
            a3.b.r("Super calls with default arguments not supported in this target, function: query");
            return null;
        }
        if ((i & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
    }

    private final <T extends SupportSQLiteOpenHelper> T unwrapOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (supportSQLiteOpenHelper == null) {
            return null;
        }
        l.h();
        throw null;
    }

    public final void addTypeConverter$room_runtime_release(j7.c cVar, Object obj) {
        cVar.getClass();
        obj.getClass();
        this.typeConverters.put(cVar, obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime_release()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotSuspendingTransaction() {
        if (!inCompatibilityMode$room_runtime_release() || inTransaction() || this.suspendingTransactionId.get() == null) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new e(this, 2));
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        this.closeBarrier.close$room_runtime_release();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        str.getClass();
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> createAutoMigrations(Map<j7.c, ? extends AutoMigrationSpec> map) {
        map.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q6.a0.h0(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(d0.b.F((j7.c) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    public final RoomConnectionManager createConnectionManager$room_runtime_release(DatabaseConfiguration databaseConfiguration) {
        RoomOpenDelegate roomOpenDelegate;
        databaseConfiguration.getClass();
        try {
            RoomOpenDelegateMarker createOpenDelegate = createOpenDelegate();
            createOpenDelegate.getClass();
            roomOpenDelegate = (RoomOpenDelegate) createOpenDelegate;
        } catch (p6.h unused) {
            roomOpenDelegate = null;
        }
        return roomOpenDelegate == null ? new RoomConnectionManager(databaseConfiguration, new e(this, 1)) : new RoomConnectionManager(databaseConfiguration, roomOpenDelegate);
    }

    public abstract InvalidationTracker createInvalidationTracker();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RoomOpenDelegateMarker createOpenDelegate() {
        throw new p6.h(0);
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        databaseConfiguration.getClass();
        throw new p6.h(0);
    }

    public void endTransaction() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new e(this, 0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        map.getClass();
        return t.f8724a;
    }

    public final CloseBarrier getCloseBarrier$room_runtime_release() {
        return this.closeBarrier;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final a0 getCoroutineScope() {
        a0 a0Var = this.coroutineScope;
        if (a0Var != null) {
            return a0Var;
        }
        l.i("coroutineScope");
        throw null;
    }

    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        l.i("internalTracker");
        throw null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            l.i("connectionManager");
            throw null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = roomConnectionManager.getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            return supportOpenHelper$room_runtime_release;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final h getQueryContext() {
        a0 a0Var = this.coroutineScope;
        if (a0Var != null) {
            return a0Var.getCoroutineContext();
        }
        l.i("coroutineScope");
        throw null;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        l.i("internalQueryExecutor");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<j7.c> getRequiredAutoMigrationSpecClasses() {
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(n.i0(requiredAutoMigrationSpecs, 10));
        Iterator<T> it = requiredAutoMigrationSpecs.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            cls.getClass();
            arrayList.add(y.a(cls));
        }
        return q6.l.J0(arrayList);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return v.f8726a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<j7.c, List<j7.c>> getRequiredTypeConverterClasses() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> entrySet = getRequiredTypeConverters().entrySet();
        int h02 = q6.a0.h0(n.i0(entrySet, 10));
        if (h02 < 16) {
            h02 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h02);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            cls.getClass();
            kotlin.jvm.internal.f a8 = y.a(cls);
            List<Class> list2 = list;
            ArrayList arrayList = new ArrayList(n.i0(list2, 10));
            for (Class cls2 : list2) {
                cls2.getClass();
                arrayList.add(y.a(cls2));
            }
            linkedHashMap.put(a8, arrayList);
        }
        return linkedHashMap;
    }

    public final Map<j7.c, List<j7.c>> getRequiredTypeConverterClassesMap$room_runtime_release() {
        return getRequiredTypeConverterClasses();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return u.f8725a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public final h getTransactionContext$room_runtime_release() {
        h hVar = this.transactionContext;
        if (hVar != null) {
            return hVar;
        }
        l.i("transactionContext");
        throw null;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        l.i("internalTransactionExecutor");
        throw null;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        cls.getClass();
        return (T) this.typeConverters.get(y.a(cls));
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public final boolean inCompatibilityMode$room_runtime_release() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.getSupportOpenHelper$room_runtime_release() != null;
        }
        l.i("connectionManager");
        throw null;
    }

    public boolean inTransaction() {
        return isOpenInternal() && getOpenHelper().getWritableDatabase().inTransaction();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(androidx.room.DatabaseConfiguration r7) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.init(androidx.room.DatabaseConfiguration):void");
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        internalInitInvalidationTracker(new SupportSQLiteConnection(supportSQLiteDatabase));
    }

    public final boolean isMainThread$room_runtime_release() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.isSupportDatabaseOpen();
        }
        l.i("connectionManager");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isOpenInternal() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.isSupportDatabaseOpen();
        }
        l.i("connectionManager");
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void performClear(boolean z9, String... strArr) {
        strArr.getClass();
        assertNotMainThread();
        assertNotSuspendingTransaction();
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new RoomDatabase$performClear$1(this, z9, strArr, null));
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        supportSQLiteQuery.getClass();
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return cancellationSignal != null ? getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal) : getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        callable.getClass();
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z9) {
        this.useTempTrackingTable = z9;
    }

    public final <R> Object useConnection$room_runtime_release(boolean z9, p pVar, t6.c cVar) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager != null) {
            return roomConnectionManager.useConnection(z9, pVar, cVar);
        }
        l.i("connectionManager");
        throw null;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationForAllTables;
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private final List<AutoMigrationSpec> autoMigrationSpecs;
        private final List<Callback> callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SQLiteDriver driver;
        private final d7.a factory;
        private boolean inMemoryTrackingTableMode;
        private JournalMode journalMode;
        private final j7.c klass;
        private final MigrationContainer migrationContainer;
        private final Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private h queryCallbackCoroutineContext;
        private Executor queryCallbackExecutor;
        private h queryCoroutineContext;
        private Executor queryExecutor;
        private boolean requireMigration;
        private SupportSQLiteOpenHelper.Factory supportOpenHelperFactory;
        private Executor transactionExecutor;
        private final List<Object> typeConverters;

        public Builder(Context context, Class<T> cls, String str) {
            context.getClass();
            cls.getClass();
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = y.a(cls);
            this.context = context;
            this.name = str;
            this.factory = null;
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec autoMigrationSpec) {
            autoMigrationSpec.getClass();
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            callback.getClass();
            this.callbacks.add(callback);
            return this;
        }

        public Builder<T> addMigrations(Migration... migrationArr) {
            migrationArr.getClass();
            for (Migration migration : migrationArr) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object obj) {
            obj.getClass();
            this.typeConverters.add(obj);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            SupportSQLiteOpenHelper.Factory factory;
            SupportSQLiteOpenHelper.Factory factory2;
            T t9;
            h hVar;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            RoomDatabaseKt.validateMigrationsNotRequired(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            SQLiteDriver sQLiteDriver = this.driver;
            if (sQLiteDriver == null && this.supportOpenHelperFactory == null) {
                factory = new FrameworkSQLiteOpenHelperFactory();
            } else {
                SupportSQLiteOpenHelper.Factory factory3 = this.supportOpenHelperFactory;
                if (sQLiteDriver == null) {
                    factory = factory3;
                } else {
                    if (factory3 != null) {
                        com.google.gson.internal.a.p("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                        return null;
                    }
                    factory = null;
                }
            }
            boolean z9 = this.autoCloseTimeout > 0;
            boolean z10 = (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) ? false : true;
            boolean z11 = this.queryCallback != null;
            if (factory != null) {
                if (z9) {
                    if (this.name == null) {
                        com.google.gson.internal.a.p("Cannot create auto-closing database for an in-memory database.");
                        return null;
                    }
                    long j = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) {
                        com.google.gson.internal.a.p("Required value was null.");
                        return null;
                    }
                    factory = new AutoClosingRoomOpenHelperFactory(factory, new AutoCloser(j, timeUnit, null, 4, null));
                }
                if (z10) {
                    if (this.name == null) {
                        com.google.gson.internal.a.p("Cannot create from asset or file for an in-memory database.");
                        return null;
                    }
                    String str = this.copyFromAssetPath;
                    int i = str == null ? 0 : 1;
                    File file = this.copyFromFile;
                    int i6 = file == null ? 0 : 1;
                    Callable<InputStream> callable = this.copyFromInputStream;
                    if (i + i6 + (callable != null ? 1 : 0) != 1) {
                        com.google.gson.internal.a.p("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        return null;
                    }
                    factory = new PrePackagedCopyOpenHelperFactory(str, file, callable, factory);
                }
                if (z11) {
                    Executor executor2 = this.queryCallbackExecutor;
                    if (executor2 != null) {
                        hVar = c0.m(executor2);
                    } else {
                        hVar = this.queryCallbackCoroutineContext;
                        if (hVar == null) {
                            com.google.gson.internal.a.p("Required value was null.");
                            return null;
                        }
                    }
                    t7.c b7 = c0.b(hVar);
                    QueryCallback queryCallback = this.queryCallback;
                    if (queryCallback == null) {
                        com.google.gson.internal.a.p("Required value was null.");
                        return null;
                    }
                    factory = new QueryInterceptorOpenHelperFactory(factory, b7, queryCallback);
                }
                factory2 = factory;
            } else {
                factory2 = null;
            }
            if (factory2 == null) {
                if (z9) {
                    com.google.gson.internal.a.p("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                    return null;
                }
                if (z10) {
                    com.google.gson.internal.a.p("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                    return null;
                }
                if (z11) {
                    com.google.gson.internal.a.p("Query Callback is not supported when an SQLiteDriver is configured.");
                    return null;
                }
            }
            Context context = this.context;
            String str2 = this.name;
            MigrationContainer migrationContainer = this.migrationContainer;
            List<Callback> list = this.callbacks;
            boolean z12 = this.allowMainThreadQueries;
            JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context);
            Executor executor3 = this.queryExecutor;
            if (executor3 == null) {
                com.google.gson.internal.a.p("Required value was null.");
                return null;
            }
            Executor executor4 = this.transactionExecutor;
            if (executor4 == null) {
                com.google.gson.internal.a.p("Required value was null.");
                return null;
            }
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory2, migrationContainer, list, z12, resolve$room_runtime_release, executor3, executor4, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
            databaseConfiguration.setUseTempTrackingTable$room_runtime_release(this.inMemoryTrackingTableMode);
            d7.a aVar = this.factory;
            if (aVar == null || (t9 = (T) aVar.invoke()) == null) {
                t9 = (T) KClassUtil.findAndInstantiateDatabaseImpl$default(d0.b.F(this.klass), null, 2, null);
            }
            t9.init(databaseConfiguration);
            return t9;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String str, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            str.getClass();
            prepackagedDatabaseCallback.getClass();
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.copyFromAssetPath = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File file, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            file.getClass();
            prepackagedDatabaseCallback.getClass();
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            callable.getClass();
            prepackagedDatabaseCallback.getClass();
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.copyFromInputStream = callable;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            this.multiInstanceInvalidationIntent = this.name != null ? new Intent(this.context, (Class<?>) MultiInstanceInvalidationService.class) : null;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigration(boolean z9) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z9;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(boolean z9, int... iArr) {
            iArr.getClass();
            for (int i : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            this.allowDestructiveMigrationForAllTables = z9;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigrationOnDowngrade(boolean z9) {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z9;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
            this.supportOpenHelperFactory = factory;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j, TimeUnit timeUnit) {
            timeUnit.getClass();
            if (j < 0) {
                com.google.gson.internal.a.p("autoCloseTimeout must be >= 0");
                return null;
            }
            this.autoCloseTimeout = j;
            this.autoCloseTimeUnit = timeUnit;
            return this;
        }

        public final Builder<T> setDriver(SQLiteDriver sQLiteDriver) {
            sQLiteDriver.getClass();
            this.driver = sQLiteDriver;
            return this;
        }

        @ExperimentalRoomApi
        public final Builder<T> setInMemoryTrackingMode(boolean z9) {
            this.inMemoryTrackingTableMode = z9;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode) {
            journalMode.getClass();
            this.journalMode = journalMode;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent intent) {
            intent.getClass();
            if (this.name == null) {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback, Executor executor) {
            queryCallback.getClass();
            executor.getClass();
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = executor;
            this.queryCallbackCoroutineContext = null;
            return this;
        }

        public final Builder<T> setQueryCoroutineContext(h hVar) {
            hVar.getClass();
            if (this.queryExecutor != null || this.transactionExecutor != null) {
                com.google.gson.internal.a.p("This builder has already been configured with an Executor. A RoomDatabase canonly be configured with either an Executor or a CoroutineContext.");
                return null;
            }
            if (hVar.get(t6.d.f10313a) != null) {
                this.queryCoroutineContext = hVar;
                return this;
            }
            com.google.gson.internal.a.p("It is required that the coroutine context contain a dispatcher.");
            return null;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            executor.getClass();
            if (this.queryCoroutineContext == null) {
                this.queryExecutor = executor;
                return this;
            }
            com.google.gson.internal.a.p("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            return null;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            executor.getClass();
            if (this.queryCoroutineContext == null) {
                this.transactionExecutor = executor;
                return this;
            }
            com.google.gson.internal.a.p("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            return null;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> createFromAsset(String str) {
            str.getClass();
            this.copyFromAssetPath = str;
            return this;
        }

        public Builder<T> createFromFile(File file) {
            file.getClass();
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable) {
            callable.getClass();
            this.copyFromInputStream = callable;
            return this;
        }

        public final Builder<T> setQueryCallback(h hVar, QueryCallback queryCallback) {
            hVar.getClass();
            queryCallback.getClass();
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = null;
            this.queryCallbackCoroutineContext = hVar;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            iArr.getClass();
            for (int i : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            return this;
        }

        public Builder(j7.c cVar, String str, d7.a aVar, Context context) {
            cVar.getClass();
            context.getClass();
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = cVar;
            this.context = context;
            this.name = str;
            this.factory = aVar;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void internalInitInvalidationTracker(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        getInvalidationTracker().internalInit$room_runtime_release(sQLiteConnection);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> T getTypeConverter(j7.c cVar) {
        cVar.getClass();
        T t9 = (T) this.typeConverters.get(cVar);
        t9.getClass();
        return t9;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Callback {
        public void onCreate(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onCreate(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }

        public void onDestructiveMigration(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onDestructiveMigration(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }

        public void onOpen(SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onOpen(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }

        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }
    }

    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    public static /* synthetic */ void getMDatabase$annotations() {
    }

    public void runInTransaction(Runnable runnable) {
        runnable.getClass();
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void addMigration(Migration migration) {
            migration.getClass();
            int i = migration.startVersion;
            int i6 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer valueOf = Integer.valueOf(i);
            TreeMap<Integer, Migration> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap<Integer, Migration> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i6))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i6)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i6), migration);
        }

        public void addMigrations(List<? extends Migration> list) {
            list.getClass();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                addMigration((Migration) it.next());
            }
        }

        public final boolean contains(int i, int i6) {
            return MigrationUtil.contains(this, i, i6);
        }

        public List<Migration> findMigrationPath(int i, int i6) {
            return MigrationUtil.findMigrationPath(this, i, i6);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public final i getSortedDescendingNodes$room_runtime_release(int i) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return new i(treeMap, treeMap.descendingKeySet());
        }

        public final i getSortedNodes$room_runtime_release(int i) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return new i(treeMap, treeMap.keySet());
        }

        public void addMigrations(Migration... migrationArr) {
            migrationArr.getClass();
            for (Migration migration : migrationArr) {
                addMigration(migration);
            }
        }
    }

    public Cursor query(String str, Object[] objArr) {
        str.getClass();
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(str, objArr));
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        return query$default(this, supportSQLiteQuery, null, 2, null);
    }
}
