package androidx.room;

import d7.l;
import d7.p;
import java.util.Set;
import r7.h;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomDatabaseKt {
    public static final h invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z9) {
        return RoomDatabaseKt__RoomDatabase_androidKt.invalidationTrackerFlow(roomDatabase, strArr, z9);
    }

    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, p pVar, t6.c cVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useReaderConnection(roomDatabase, pVar, cVar);
    }

    public static final <R> Object useWriterConnection(RoomDatabase roomDatabase, p pVar, t6.c cVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(roomDatabase, pVar, cVar);
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(roomDatabase, databaseConfiguration);
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        RoomDatabaseKt__RoomDatabaseKt.validateMigrationsNotRequired(set, set2);
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(roomDatabase, databaseConfiguration);
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, l lVar, t6.c cVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransaction(roomDatabase, lVar, cVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, l lVar, t6.c cVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransactionContext(roomDatabase, lVar, cVar);
    }
}
