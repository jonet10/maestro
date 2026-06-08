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
public final class DependencyDao_Impl implements DependencyDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Dependency> __insertAdapterOfDependency;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfDependency = new EntityInsertAdapter<Dependency>() { // from class: androidx.work.impl.model.DependencyDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, Dependency dependency) {
                sQLiteStatement.getClass();
                dependency.getClass();
                sQLiteStatement.mo92bindText(1, dependency.getWorkSpecId());
                sQLiteStatement.mo92bindText(2, dependency.getPrerequisiteId());
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getDependentWorkIds$lambda$3(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final List getPrerequisites$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
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
    public static final boolean hasCompletedAllPrerequisites$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            boolean z9 = false;
            if (prepare.step()) {
                z9 = ((int) prepare.getLong(0)) != 0;
            }
            return z9;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasDependents$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.mo92bindText(1, str2);
            boolean z9 = false;
            if (prepare.step()) {
                z9 = ((int) prepare.getLong(0)) != 0;
            }
            return z9;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x insertDependency$lambda$0(DependencyDao_Impl dependencyDao_Impl, Dependency dependency, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        dependencyDao_Impl.__insertAdapterOfDependency.insert(sQLiteConnection, (SQLiteConnection) dependency);
        return x.f8463a;
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getDependentWorkIds(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 1));
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getPrerequisites(String str) {
        str.getClass();
        return (List) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 4));
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(String str) {
        str.getClass();
        return ((Boolean) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 3))).booleanValue();
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(String str) {
        str.getClass();
        return ((Boolean) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 2))).booleanValue();
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void insertDependency(Dependency dependency) {
        dependency.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a(0, this, dependency));
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
