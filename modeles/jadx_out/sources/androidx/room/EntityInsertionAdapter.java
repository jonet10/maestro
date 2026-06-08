package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import q6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        roomDatabase.getClass();
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t9);

    public final void insert(Iterable<? extends T> iterable) {
        iterable.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t9) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t9);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            for (T t9 : collection) {
                int i6 = i + 1;
                if (i < 0) {
                    m.h0();
                    throw null;
                }
                bind(acquire, t9);
                jArr[i] = acquire.executeInsert();
                i = i6;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            int i = 0;
            int i6 = 0;
            while (i < length) {
                int i10 = i6 + 1;
                try {
                    bind(acquire, tArr[i6]);
                    lArr[i] = Long.valueOf(acquire.executeInsert());
                    i++;
                    i6 = i10;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new NoSuchElementException(e10.getMessage());
                }
            }
            release(acquire);
            return lArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            r6.c t9 = a.a.t();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                t9.add(Long.valueOf(acquire.executeInsert()));
            }
            r6.c m10 = a.a.m(t9);
            release(acquire);
            return m10;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t9 : tArr) {
                bind(acquire, t9);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(T t9) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t9);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            r6.c t9 = a.a.t();
            for (T t10 : tArr) {
                bind(acquire, t10);
                t9.add(Long.valueOf(acquire.executeInsert()));
            }
            r6.c m10 = a.a.m(t9);
            release(acquire);
            return m10;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i = 0;
            int i6 = 0;
            while (i < length) {
                int i10 = i6 + 1;
                bind(acquire, tArr[i]);
                jArr[i6] = acquire.executeInsert();
                i++;
                i6 = i10;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }
}
