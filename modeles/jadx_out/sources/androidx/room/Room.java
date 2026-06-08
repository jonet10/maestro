package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.jvm.internal.l;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Room {
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> cls, String str) {
        context.getClass();
        cls.getClass();
        if (str == null || m.z0(str)) {
            com.google.gson.internal.a.p("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            return null;
        }
        if (!l.a(str, ":memory:")) {
            return new RoomDatabase.Builder<>(context, cls, str);
        }
        com.google.gson.internal.a.p("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return null;
    }

    public static RoomDatabase.Builder databaseBuilder$default(Room room, Context context, String str, d7.a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            l.h();
            throw null;
        }
        context.getClass();
        str.getClass();
        aVar.getClass();
        if (m.z0(str)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        if (str.equals(":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
        }
        l.h();
        throw null;
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        context.getClass();
        cls.getClass();
        return new RoomDatabase.Builder<>(context, cls, null);
    }

    public static RoomDatabase.Builder inMemoryDatabaseBuilder$default(Room room, Context context, d7.a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            l.h();
            throw null;
        }
        context.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, d7.a aVar) {
        context.getClass();
        aVar.getClass();
        l.h();
        throw null;
    }

    public final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, String str, d7.a aVar) {
        context.getClass();
        str.getClass();
        aVar.getClass();
        if (!m.z0(str)) {
            if (str.equals(":memory:")) {
                throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
            }
            l.h();
            throw null;
        }
        throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().");
    }
}
