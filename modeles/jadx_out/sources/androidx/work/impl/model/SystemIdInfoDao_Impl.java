package androidx.work.impl.model;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import p6.x;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SystemIdInfo> __insertAdapterOfSystemIdInfo;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfSystemIdInfo = new EntityInsertAdapter<SystemIdInfo>() { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, SystemIdInfo systemIdInfo) {
                sQLiteStatement.getClass();
                systemIdInfo.getClass();
                sQLiteStatement.mo92bindText(1, systemIdInfo.workSpecId);
                sQLiteStatement.mo90bindLong(2, systemIdInfo.getGeneration());
                sQLiteStatement.mo90bindLong(3, systemIdInfo.systemId);
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SystemIdInfo getSystemIdInfo$lambda$1(String str, String str2, int i, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            prepare.mo90bindLong(2, i);
            return prepare.step() ? new SystemIdInfo(prepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "work_spec_id")), (int) prepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "generation")), (int) prepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "system_id"))) : null;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkSpecIds$lambda$2(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(prepare.getText(0));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x insertSystemIdInfo$lambda$0(SystemIdInfoDao_Impl systemIdInfoDao_Impl, SystemIdInfo systemIdInfo, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        systemIdInfoDao_Impl.__insertAdapterOfSystemIdInfo.insert(sQLiteConnection, (SQLiteConnection) systemIdInfo);
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x removeSystemIdInfo$lambda$3(String str, String str2, int i, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            prepare.mo90bindLong(2, i);
            prepare.step();
            prepare.close();
            return x.f8463a;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x removeSystemIdInfo$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String str, int i) {
        str.getClass();
        return (SystemIdInfo) DBUtil.performBlocking(this.__db, true, false, new d(str, i, 1));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> getWorkSpecIds() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.f(7));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        systemIdInfo.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a(2, this, systemIdInfo));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String str, int i) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new d(str, i, 0));
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void removeSystemIdInfo(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        removeSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 7));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final SystemIdInfo getSystemIdInfo(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        return getSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }
}
