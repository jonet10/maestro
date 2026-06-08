package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import p6.x;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"WrongConstant"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;
    public static final Companion Companion = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i6 = i + 1;
        this.bindingTypes = new int[i6];
        this.longBindings = new long[i6];
        this.doubleBindings = new double[i6];
        this.stringBindings = new String[i6];
        this.blobBindings = new byte[i6][];
    }

    public static final RoomSQLiteQuery acquire(String str, int i) {
        return Companion.acquire(str, i);
    }

    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        roomSQLiteQuery.bindTo(sQLiteStatement);
        return x.f8463a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        bArr.getClass();
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d10) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        str.getClass();
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    public final void bindText(int i, String str) {
        str.getClass();
        bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        supportSQLiteProgram.getClass();
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i6 = this.bindingTypes[i];
            if (i6 == 1) {
                supportSQLiteProgram.bindNull(i);
            } else if (i6 == 2) {
                supportSQLiteProgram.bindLong(i, this.longBindings[i]);
            } else if (i6 == 3) {
                supportSQLiteProgram.bindDouble(i, this.doubleBindings[i]);
            } else if (i6 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    com.google.gson.internal.a.p("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindString(i, str);
            } else if (i6 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    com.google.gson.internal.a.p("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        int[] iArr = this.bindingTypes;
        Arrays.fill(iArr, 0, iArr.length, 1);
        j.e0(null, r0, 0, this.stringBindings.length);
        j.e0(null, r0, 0, this.blobBindings.length);
        this.query = null;
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        roomSQLiteQuery.getClass();
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Required value was null.");
        return null;
    }

    public final void init(String str, int i) {
        str.getClass();
        this.query = str;
        this.argCount = i;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
        }
    }

    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getSql(), new b(this, 4));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final RoomSQLiteQuery acquire(String str, int i) {
            str.getClass();
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, null);
                    roomSQLiteQuery.init(str, i);
                    return roomSQLiteQuery;
                }
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.init(str, i);
                return value;
            }
        }

        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            supportSQLiteQuery.getClass();
            final RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i, byte[] bArr) {
                    bArr.getClass();
                    RoomSQLiteQuery.this.bindBlob(i, bArr);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i, double d10) {
                    RoomSQLiteQuery.this.bindDouble(i, d10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i, long j) {
                    RoomSQLiteQuery.this.bindLong(i, j);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i) {
                    RoomSQLiteQuery.this.bindNull(i);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i, String str) {
                    str.getClass();
                    RoomSQLiteQuery.this.bindString(i, str);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    RoomSQLiteQuery.this.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    RoomSQLiteQuery.this.close();
                }
            });
            return acquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            it.getClass();
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i;
            }
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public /* synthetic */ RoomSQLiteQuery(int i, kotlin.jvm.internal.g gVar) {
        this(i);
    }

    public final void bindTo(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i6 = this.bindingTypes[i];
            if (i6 == 1) {
                sQLiteStatement.mo91bindNull(i);
            } else if (i6 == 2) {
                sQLiteStatement.mo90bindLong(i, this.longBindings[i]);
            } else if (i6 == 3) {
                sQLiteStatement.mo89bindDouble(i, this.doubleBindings[i]);
            } else if (i6 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    com.google.gson.internal.a.p("Required value was null.");
                    return;
                }
                sQLiteStatement.mo92bindText(i, str);
            } else if (i6 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    com.google.gson.internal.a.p("Required value was null.");
                    return;
                }
                sQLiteStatement.mo88bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            } else {
                i++;
            }
        }
    }
}
