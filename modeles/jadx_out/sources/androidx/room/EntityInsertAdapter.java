package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import q6.l;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class EntityInsertAdapter<T> {
    public abstract void bind(SQLiteStatement sQLiteStatement, T t9);

    public abstract String createQuery();

    public final void insert(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        int i = 0;
        while (i < tArr.length) {
            try {
                int i6 = i + 1;
                try {
                    T t9 = tArr[i];
                    if (t9 != null) {
                        bind(prepare, t9);
                        prepare.step();
                        prepare.reset();
                    }
                    i = i6;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new NoSuchElementException(e10.getMessage());
                }
            } finally {
            }
        }
        t0.f.g(prepare, null);
    }

    public final long insertAndReturnId(SQLiteConnection sQLiteConnection, T t9) {
        sQLiteConnection.getClass();
        if (t9 == null) {
            return -1L;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(prepare, t9);
            prepare.step();
            t0.f.g(prepare, null);
            return SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                Object p02 = l.p0(collection, i);
                if (p02 != null) {
                    bind(prepare, p02);
                    prepare.step();
                    prepare.reset();
                    j = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j = -1;
                }
                jArr[i] = j;
            }
            t0.f.g(prepare, null);
            return jArr;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                Object p02 = l.p0(collection, i);
                if (p02 != null) {
                    bind(prepare, p02);
                    prepare.step();
                    prepare.reset();
                    j = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j = -1;
                }
                lArr[i] = Long.valueOf(j);
            }
            t0.f.g(prepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        sQLiteConnection.getClass();
        if (collection == null) {
            return t.f8724a;
        }
        r6.c t9 = a.a.t();
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t10 : collection) {
                if (t10 != null) {
                    bind(prepare, t10);
                    prepare.step();
                    prepare.reset();
                    t9.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    t9.add(-1L);
                }
            }
            t0.f.g(prepare, null);
            return a.a.m(t9);
        } finally {
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, T t9) {
        sQLiteConnection.getClass();
        if (t9 == null) {
            return;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(prepare, t9);
            prepare.step();
            t0.f.g(prepare, null);
        } finally {
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        sQLiteConnection.getClass();
        if (iterable == null) {
            return;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t9 : iterable) {
                if (t9 != null) {
                    bind(prepare, t9);
                    prepare.step();
                    prepare.reset();
                }
            }
            t0.f.g(prepare, null);
        } finally {
        }
    }

    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                T t9 = tArr[i];
                if (t9 != null) {
                    bind(prepare, t9);
                    prepare.step();
                    prepare.reset();
                    j = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j = -1;
                }
                jArr[i] = j;
            }
            t0.f.g(prepare, null);
            return jArr;
        } finally {
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i = 0; i < length; i++) {
                T t9 = tArr[i];
                if (t9 != null) {
                    bind(prepare, t9);
                    prepare.step();
                    prepare.reset();
                    j = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j = -1;
                }
                lArr[i] = Long.valueOf(j);
            }
            t0.f.g(prepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return t.f8724a;
        }
        r6.c t9 = a.a.t();
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t10 : tArr) {
                if (t10 != null) {
                    bind(prepare, t10);
                    prepare.step();
                    prepare.reset();
                    t9.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    t9.add(-1L);
                }
            }
            t0.f.g(prepare, null);
            return a.a.m(t9);
        } finally {
        }
    }
}
