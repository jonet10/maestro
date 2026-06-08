package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        roomDatabase.getClass();
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t9);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T t9) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t9);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        iterable.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                i += acquire.executeUpdateDelete();
            }
            return i;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement acquire = acquire();
        try {
            int i = 0;
            for (T t9 : tArr) {
                bind(acquire, t9);
                i += acquire.executeUpdateDelete();
            }
            return i;
        } finally {
            release(acquire);
        }
    }
}
