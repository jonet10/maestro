package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p6.i;
import q6.t;
import q6.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MigrationUtil {
    public static final boolean contains(RoomDatabase.MigrationContainer migrationContainer, int i, int i6) {
        migrationContainer.getClass();
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (!migrations.containsKey(Integer.valueOf(i))) {
            return false;
        }
        Map<Integer, Migration> map = migrations.get(Integer.valueOf(i));
        if (map == null) {
            map = u.f8725a;
        }
        return map.containsKey(Integer.valueOf(i6));
    }

    public static final List<Migration> findMigrationPath(RoomDatabase.MigrationContainer migrationContainer, int i, int i6) {
        migrationContainer.getClass();
        if (i == i6) {
            return t.f8724a;
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), i6 > i, i, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z9, int i, int i6) {
        int i10;
        boolean z10;
        while (true) {
            if (z9) {
                if (i >= i6) {
                    return list;
                }
            } else if (i <= i6) {
                return list;
            }
            i sortedDescendingNodes$room_runtime_release = z9 ? migrationContainer.getSortedDescendingNodes$room_runtime_release(i) : migrationContainer.getSortedNodes$room_runtime_release(i);
            if (sortedDescendingNodes$room_runtime_release == null) {
                return null;
            }
            Map map = (Map) sortedDescendingNodes$room_runtime_release.f8441a;
            Iterator it = ((Iterable) sortedDescendingNodes$room_runtime_release.f8442b).iterator();
            while (it.hasNext()) {
                i10 = ((Number) it.next()).intValue();
                if (!z9) {
                    if (i6 <= i10 && i10 < i) {
                        Object obj = map.get(Integer.valueOf(i10));
                        obj.getClass();
                        list.add(obj);
                        z10 = true;
                        break;
                    }
                } else if (i + 1 <= i10 && i10 <= i6) {
                    Object obj2 = map.get(Integer.valueOf(i10));
                    obj2.getClass();
                    list.add(obj2);
                    z10 = true;
                    break;
                }
            }
            i10 = i;
            z10 = false;
            if (!z10) {
                return null;
            }
            i = i10;
        }
    }

    public static final boolean isMigrationRequired(DatabaseConfiguration databaseConfiguration, int i, int i6) {
        databaseConfiguration.getClass();
        if (i > i6 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime_release = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime_release();
        return databaseConfiguration.requireMigration && (migrationNotRequiredFrom$room_runtime_release == null || !migrationNotRequiredFrom$room_runtime_release.contains(Integer.valueOf(i)));
    }
}
