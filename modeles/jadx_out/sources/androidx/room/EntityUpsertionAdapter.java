package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        entityInsertionAdapter.getClass();
        entityDeletionOrUpdateAdapter.getClass();
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        }
        if (!m.q0(message, "unique", true) && !m.q0(message, "2067", false) && !m.q0(message, "1555", false)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(Iterable<? extends T> iterable) {
        iterable.getClass();
        for (T t9 : iterable) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t9);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t9);
            }
        }
    }

    public final long upsertAndReturnId(T t9) {
        try {
            return this.insertionAdapter.insertAndReturnId(t9);
        } catch (SQLiteConstraintException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(t9);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long j;
        collection.getClass();
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(next);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long j;
        collection.getClass();
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(next);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        collection.getClass();
        r6.c t9 = a.a.t();
        for (T t10 : collection) {
            try {
                t9.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t10)));
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
                t9.add(-1L);
            }
        }
        return a.a.m(t9);
    }

    public final void upsert(T[] tArr) {
        tArr.getClass();
        for (T t9 : tArr) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t9);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t9);
            }
        }
    }

    public final void upsert(T t9) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) t9);
        } catch (SQLiteConstraintException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(t9);
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long j;
        tArr.getClass();
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long j;
        tArr.getClass();
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        tArr.getClass();
        r6.c t9 = a.a.t();
        for (T t10 : tArr) {
            try {
                t9.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t10)));
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
                t9.add(-1L);
            }
        }
        return a.a.m(t9);
    }
}
