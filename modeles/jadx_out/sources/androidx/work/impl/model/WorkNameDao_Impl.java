package androidx.work.impl.model;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import p6.x;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkNameDao_Impl implements WorkNameDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkName> __insertAdapterOfWorkName;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfWorkName = new EntityInsertAdapter<WorkName>() { // from class: androidx.work.impl.model.WorkNameDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, WorkName workName) {
                sQLiteStatement.getClass();
                workName.getClass();
                sQLiteStatement.mo92bindText(1, workName.getName());
                sQLiteStatement.mo92bindText(2, workName.getWorkSpecId());
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getNamesForWorkSpecId$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
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
    public static final List getWorkSpecIdsWithName$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
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
    public static final x insert$lambda$0(WorkNameDao_Impl workNameDao_Impl, WorkName workName, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        workNameDao_Impl.__insertAdapterOfWorkName.insert(sQLiteConnection, (SQLiteConnection) workName);
        return x.f8463a;
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public List<String> getNamesForWorkSpecId(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 9));
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public List<String> getWorkSpecIdsWithName(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 8));
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public void insert(WorkName workName) {
        workName.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a(3, this, workName));
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
