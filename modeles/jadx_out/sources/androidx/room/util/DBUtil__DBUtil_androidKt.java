package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.TransactionElement;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.internal.measurement.z3;
import d7.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import o7.c0;
import t6.c;
import t6.e;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class DBUtil__DBUtil_androidKt {
    private static final <R> Object compatCoroutineExecute$DBUtil__DBUtil_androidKt(RoomDatabase roomDatabase, boolean z9, l lVar, c cVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release() && roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
            return lVar.invoke(cVar);
        }
        return c0.C(new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(lVar, null), (h) DBUtil.getCoroutineContext(roomDatabase, z9, cVar), cVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        DBUtil.dropFtsSyncTriggers(new SupportSQLiteConnection(supportSQLiteDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        supportSQLiteDatabase.getClass();
        str.getClass();
        DBUtil.foreignKeyCheck(new SupportSQLiteConnection(supportSQLiteDatabase), str);
    }

    public static final Object getCoroutineContext(RoomDatabase roomDatabase, boolean z9, c cVar) {
        e transactionDispatcher$room_runtime_release;
        h plus;
        if (!roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return roomDatabase.getCoroutineScope().getCoroutineContext();
        }
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
        return (transactionElement == null || (transactionDispatcher$room_runtime_release = transactionElement.getTransactionDispatcher$room_runtime_release()) == null || (plus = roomDatabase.getQueryContext().plus(transactionDispatcher$room_runtime_release)) == null) ? z9 ? roomDatabase.getTransactionContext$room_runtime_release() : roomDatabase.getQueryContext() : plus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> R performBlocking(RoomDatabase roomDatabase, boolean z9, boolean z10, l lVar) {
        roomDatabase.getClass();
        lVar.getClass();
        roomDatabase.assertNotMainThread();
        roomDatabase.assertNotSuspendingTransaction();
        return (R) RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new DBUtil__DBUtil_androidKt$performBlocking$1(roomDatabase, z9, z10, lVar, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> Object performInTransactionSuspending(RoomDatabase roomDatabase, l lVar, c cVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return RoomDatabaseKt.withTransactionContext(roomDatabase, new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(roomDatabase, lVar, null), cVar);
        }
        return c0.C(new DBUtil__DBUtil_androidKt$performInTransactionSuspending$3(roomDatabase, lVar, null), roomDatabase.getCoroutineScope().getCoroutineContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object performSuspending(androidx.room.RoomDatabase r15, boolean r16, boolean r17, d7.l r18, t6.c r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.result
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r7 = 1
            u6.a r8 = u6.a.f10762a
            if (r1 == 0) goto L50
            if (r1 == r7) goto L4c
            if (r1 == r3) goto L38
            if (r1 != r2) goto L31
            p6.a.e(r0)
            return r0
        L31:
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r15)
            r15 = 0
            return r15
        L38:
            boolean r15 = r6.Z$1
            boolean r1 = r6.Z$0
            java.lang.Object r3 = r6.L$1
            d7.l r3 = (d7.l) r3
            java.lang.Object r4 = r6.L$0
            androidx.room.RoomDatabase r4 = (androidx.room.RoomDatabase) r4
            p6.a.e(r0)
            r13 = r15
            r14 = r3
            r11 = r4
        L4a:
            r12 = r1
            goto L9a
        L4c:
            p6.a.e(r0)
            return r0
        L50:
            p6.a.e(r0)
            boolean r0 = r15.inCompatibilityMode$room_runtime_release()
            if (r0 == 0) goto L7e
            boolean r0 = r15.isOpenInternal()
            if (r0 == 0) goto L7e
            boolean r0 = r15.inTransaction()
            if (r0 == 0) goto L7e
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r15
            r2 = r16
            r1 = r17
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r2
            r2 = r0
            r6.label = r7
            java.lang.Object r15 = r15.useConnection$room_runtime_release(r1, r2, r6)
            if (r15 != r8) goto L7d
            goto Laf
        L7d:
            return r15
        L7e:
            r1 = r16
            r4 = r17
            r6.L$0 = r15
            r5 = r18
            r6.L$1 = r5
            r6.Z$0 = r1
            r6.Z$1 = r4
            r6.label = r3
            java.lang.Object r3 = androidx.room.util.DBUtil.getCoroutineContext(r15, r4, r6)
            if (r3 != r8) goto L95
            goto Laf
        L95:
            r11 = r15
            r0 = r3
            r13 = r4
            r14 = r5
            goto L4a
        L9a:
            t6.h r0 = (t6.h) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r9 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r10 = 0
            r9.<init>(r10, r11, r12, r13, r14)
            r15 = 0
            r6.L$0 = r15
            r6.L$1 = r15
            r6.label = r2
            java.lang.Object r15 = o7.c0.C(r9, r0, r6)
            if (r15 != r8) goto Lb0
        Laf:
            return r8
        Lb0:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.performSuspending(androidx.room.RoomDatabase, boolean, boolean, d7.l, t6.c):java.lang.Object");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9, CancellationSignal cancellationSignal) {
        roomDatabase.getClass();
        supportSQLiteQuery.getClass();
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z9 || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(query) : query;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int readVersion(File file) throws IOException {
        file.getClass();
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i = allocate.getInt();
            z3.k(channel, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                z3.k(channel, th);
                throw th2;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteConnection toSQLiteConnection(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        return new SupportSQLiteConnection(supportSQLiteDatabase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9) {
        roomDatabase.getClass();
        supportSQLiteQuery.getClass();
        return DBUtil.query(roomDatabase, supportSQLiteQuery, z9, null);
    }
}
