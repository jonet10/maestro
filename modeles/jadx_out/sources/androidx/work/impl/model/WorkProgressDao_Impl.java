package androidx.work.impl.model;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data;
import java.util.List;
import p6.x;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkProgress> __insertAdapterOfWorkProgress;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfWorkProgress = new EntityInsertAdapter<WorkProgress>() { // from class: androidx.work.impl.model.WorkProgressDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, WorkProgress workProgress) {
                sQLiteStatement.getClass();
                workProgress.getClass();
                sQLiteStatement.mo92bindText(1, workProgress.getWorkSpecId());
                sQLiteStatement.mo88bindBlob(2, Data.Companion.toByteArrayInternalV1(workProgress.getProgress()));
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x delete$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            prepare.step();
            prepare.close();
            return x.f8463a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x deleteAll$lambda$3(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return x.f8463a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data getProgressForWorkSpecId$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            Data data = null;
            if (prepare.step()) {
                byte[] blob = prepare.isNull(0) ? null : prepare.getBlob(0);
                if (blob != null) {
                    data = Data.Companion.fromByteArray(blob);
                }
            }
            return data;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x insert$lambda$0(WorkProgressDao_Impl workProgressDao_Impl, WorkProgress workProgress, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        workProgressDao_Impl.__insertAdapterOfWorkProgress.insert(sQLiteConnection, (SQLiteConnection) workProgress);
        return x.f8463a;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void delete(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 11));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.f(8));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public Data getProgressForWorkSpecId(String str) {
        str.getClass();
        return (Data) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 10));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void insert(WorkProgress workProgress) {
        workProgress.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a(4, this, workProgress));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<j7.c> getRequiredConverters() {
            return t.f8724a;
        }

        private Companion() {
        }
    }
}
