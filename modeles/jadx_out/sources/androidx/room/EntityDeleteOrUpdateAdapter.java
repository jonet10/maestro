package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class EntityDeleteOrUpdateAdapter<T> {
    public abstract void bind(SQLiteStatement sQLiteStatement, T t9);

    public abstract String createQuery();

    public final int handle(SQLiteConnection sQLiteConnection, T t9) {
        sQLiteConnection.getClass();
        if (t9 == null) {
            return 0;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(prepare, t9);
            prepare.step();
            t0.f.g(prepare, null);
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
        }
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        int i = 0;
        if (tArr == null) {
            return 0;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        int i6 = 0;
        while (i6 < tArr.length) {
            try {
                int i10 = i6 + 1;
                try {
                    T t9 = tArr[i6];
                    if (t9 != null) {
                        bind(prepare, t9);
                        prepare.step();
                        prepare.reset();
                        i += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                    }
                    i6 = i10;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new NoSuchElementException(e10.getMessage());
                }
            } finally {
            }
        }
        t0.f.g(prepare, null);
        return i;
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        sQLiteConnection.getClass();
        int i = 0;
        if (iterable == null) {
            return 0;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t9 : iterable) {
                if (t9 != null) {
                    bind(prepare, t9);
                    prepare.step();
                    prepare.reset();
                    i += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                }
            }
            t0.f.g(prepare, null);
            return i;
        } finally {
        }
    }
}
