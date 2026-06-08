package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationForAllTables;
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final h queryCoroutineContext;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SQLiteDriver sqliteDriver;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;
    private boolean useTempTrackingTable;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar) {
        context.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z9;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z10;
        this.allowDestructiveMigrationOnDowngrade = z11;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2;
        this.autoMigrationSpecs = list3;
        this.allowDestructiveMigrationForAllTables = z12;
        this.sqliteDriver = sQLiteDriver;
        this.queryCoroutineContext = hVar;
        this.multiInstanceInvalidation = intent != null;
        this.useTempTrackingTable = true;
    }

    public static /* synthetic */ DatabaseConfiguration copy$default(DatabaseConfiguration databaseConfiguration, Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List list2, List list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar, int i, Object obj) {
        h hVar2;
        SQLiteDriver sQLiteDriver2;
        if (obj != null) {
            a3.b.r("Super calls with default arguments not supported in this target, function: copy");
            return null;
        }
        Context context2 = (i & 1) != 0 ? databaseConfiguration.context : context;
        String str3 = (i & 2) != 0 ? databaseConfiguration.name : str;
        SupportSQLiteOpenHelper.Factory factory2 = (i & 4) != 0 ? databaseConfiguration.sqliteOpenHelperFactory : factory;
        RoomDatabase.MigrationContainer migrationContainer2 = (i & 8) != 0 ? databaseConfiguration.migrationContainer : migrationContainer;
        List list4 = (i & 16) != 0 ? databaseConfiguration.callbacks : list;
        boolean z13 = (i & 32) != 0 ? databaseConfiguration.allowMainThreadQueries : z9;
        RoomDatabase.JournalMode journalMode2 = (i & 64) != 0 ? databaseConfiguration.journalMode : journalMode;
        Executor executor3 = (i & 128) != 0 ? databaseConfiguration.queryExecutor : executor;
        Executor executor4 = (i & 256) != 0 ? databaseConfiguration.transactionExecutor : executor2;
        Intent intent2 = (i & 512) != 0 ? databaseConfiguration.multiInstanceInvalidationServiceIntent : intent;
        boolean z14 = (i & 1024) != 0 ? databaseConfiguration.requireMigration : z10;
        boolean z15 = (i & 2048) != 0 ? databaseConfiguration.allowDestructiveMigrationOnDowngrade : z11;
        Set set2 = (i & 4096) != 0 ? databaseConfiguration.migrationNotRequiredFrom : set;
        String str4 = (i & 8192) != 0 ? databaseConfiguration.copyFromAssetPath : str2;
        Context context3 = context2;
        File file2 = (i & 16384) != 0 ? databaseConfiguration.copyFromFile : file;
        Callable callable2 = (i & 32768) != 0 ? databaseConfiguration.copyFromInputStream : callable;
        RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2 = (i & 65536) != 0 ? databaseConfiguration.prepackagedDatabaseCallback : prepackagedDatabaseCallback;
        List list5 = (i & 131072) != 0 ? databaseConfiguration.typeConverters : list2;
        List list6 = (i & 262144) != 0 ? databaseConfiguration.autoMigrationSpecs : list3;
        boolean z16 = (i & 524288) != 0 ? databaseConfiguration.allowDestructiveMigrationForAllTables : z12;
        SQLiteDriver sQLiteDriver3 = (i & 1048576) != 0 ? databaseConfiguration.sqliteDriver : sQLiteDriver;
        if ((i & 2097152) != 0) {
            sQLiteDriver2 = sQLiteDriver3;
            hVar2 = databaseConfiguration.queryCoroutineContext;
        } else {
            hVar2 = hVar;
            sQLiteDriver2 = sQLiteDriver3;
        }
        return databaseConfiguration.copy(context3, str3, factory2, migrationContainer2, list4, z13, journalMode2, executor3, executor4, intent2, z14, z15, set2, str4, file2, callable2, prepackagedDatabaseCallback2, list5, list6, z16, sQLiteDriver2, hVar2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DatabaseConfiguration copy(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar) {
        context.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        return new DatabaseConfiguration(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, prepackagedDatabaseCallback, list2, list3, z12, sQLiteDriver, hVar);
    }

    public final Set<Integer> getMigrationNotRequiredFrom$room_runtime_release() {
        return this.migrationNotRequiredFrom;
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public boolean isMigrationRequired(int i, int i6) {
        return MigrationUtil.isMigrationRequired(this, i, i6);
    }

    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z9) {
        this.useTempTrackingTable = z9;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, boolean r32, java.util.Set<java.lang.Integer> r33) {
        /*
            r23 = this;
            r24.getClass()
            r26.getClass()
            r27.getClass()
            r30.getClass()
            r31.getClass()
            r21 = 0
            r22 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            q6.t r18 = q6.t.f8724a
            r20 = 0
            r9 = r31
            r19 = r18
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r11 = r32
            r13 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, boolean, java.util.Set):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            if (r35 == 0) goto L1f
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L1d:
            r12 = r0
            goto L23
        L1f:
            r3 = r26
            r0 = 0
            goto L1d
        L23:
            r23 = 0
            r24 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            q6.t r20 = q6.t.f8724a
            r22 = 0
            r21 = r20
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38, java.lang.String r39, java.io.File r40) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            if (r35 == 0) goto L1f
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L1d:
            r12 = r0
            goto L23
        L1f:
            r3 = r26
            r0 = 0
            goto L1d
        L23:
            r23 = 0
            r24 = 0
            r18 = 0
            r19 = 0
            q6.t r20 = q6.t.f8724a
            r22 = 0
            r21 = r20
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38, java.lang.String r39, java.io.File r40, java.util.concurrent.Callable<java.io.InputStream> r41) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            if (r35 == 0) goto L1f
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L1d:
            r12 = r0
            goto L23
        L1f:
            r3 = r26
            r0 = 0
            goto L1d
        L23:
            r23 = 0
            r24 = 0
            r19 = 0
            q6.t r20 = q6.t.f8724a
            r22 = 0
            r21 = r20
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38, java.lang.String r39, java.io.File r40, java.util.concurrent.Callable<java.io.InputStream> r41, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r42) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            if (r35 == 0) goto L1f
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L1d:
            r12 = r0
            goto L23
        L1f:
            r3 = r26
            r0 = 0
            goto L1d
        L23:
            r23 = 0
            r24 = 0
            q6.t r20 = q6.t.f8724a
            r22 = 0
            r21 = r20
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38, java.lang.String r39, java.io.File r40, java.util.concurrent.Callable<java.io.InputStream> r41, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r42, java.util.List<? extends java.lang.Object> r43) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            r43.getClass()
            if (r35 == 0) goto L22
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L20:
            r12 = r0
            goto L26
        L22:
            r3 = r26
            r0 = 0
            goto L20
        L26:
            r23 = 0
            r24 = 0
            q6.t r21 = q6.t.f8724a
            r22 = 0
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DatabaseConfiguration(android.content.Context r26, java.lang.String r27, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r28, androidx.room.RoomDatabase.MigrationContainer r29, java.util.List<? extends androidx.room.RoomDatabase.Callback> r30, boolean r31, androidx.room.RoomDatabase.JournalMode r32, java.util.concurrent.Executor r33, java.util.concurrent.Executor r34, boolean r35, boolean r36, boolean r37, java.util.Set<java.lang.Integer> r38, java.lang.String r39, java.io.File r40, java.util.concurrent.Callable<java.io.InputStream> r41, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r42, java.util.List<? extends java.lang.Object> r43, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r44) {
        /*
            r25 = this;
            r26.getClass()
            r28.getClass()
            r29.getClass()
            r32.getClass()
            r33.getClass()
            r34.getClass()
            r43.getClass()
            r44.getClass()
            if (r35 == 0) goto L25
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r1 = androidx.room.MultiInstanceInvalidationService.class
            r3 = r26
            r0.<init>(r3, r1)
        L23:
            r12 = r0
            goto L29
        L25:
            r3 = r26
            r0 = 0
            goto L23
        L29:
            r23 = 0
            r24 = 0
            r19 = 0
            r22 = 0
            r2 = r25
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r20 = r43
            r21 = r44
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        this(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, null, list2, list3, false, null, null);
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12) {
        this(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, null, list2, list3, z12, null, null);
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
    }
}
