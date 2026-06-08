package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private static final String BUG_LINK = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    public LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z9, boolean z10, String... strArr) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z9;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + roomSQLiteQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + roomSQLiteQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.paging.LimitOffsetDataSource.1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> set) {
                LimitOffsetDataSource.this.invalidate();
            }
        };
        if (z10) {
            registerObserverIfNecessary();
        }
    }

    private RoomSQLiteQuery getSQLiteQuery(int i, int i6) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, i6);
        acquire.bindLong(acquire.getArgCount(), i);
        return acquire;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    public List<T> convertRows(Cursor cursor) {
        return convertRows(new CursorSQLiteStatement(cursor));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams loadInitialParams, PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        RoomSQLiteQuery roomSQLiteQuery2;
        registerObserverIfNecessary();
        List<T> list = Collections.EMPTY_LIST;
        this.mDb.beginTransaction();
        Cursor cursor = null;
        try {
            int countItems = countItems();
            if (countItems != 0) {
                int computeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, countItems);
                roomSQLiteQuery = getSQLiteQuery(computeInitialLoadPosition, computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, countItems));
                try {
                    cursor = this.mDb.query(roomSQLiteQuery);
                    List<T> convertRows = convertRows(cursor);
                    this.mDb.setTransactionSuccessful();
                    roomSQLiteQuery2 = roomSQLiteQuery;
                    i = computeInitialLoadPosition;
                    list = convertRows;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.mDb.endTransaction();
                    if (roomSQLiteQuery != null) {
                        roomSQLiteQuery.release();
                    }
                    throw th;
                }
            } else {
                i = 0;
                roomSQLiteQuery2 = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            this.mDb.endTransaction();
            if (roomSQLiteQuery2 != null) {
                roomSQLiteQuery2.release();
            }
            loadInitialCallback.onResult(list, i, countItems);
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<T> loadRange(int i, int i6) {
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(i, i6);
        boolean z9 = this.mInTransaction;
        RoomDatabase roomDatabase = this.mDb;
        if (!z9) {
            Cursor query = roomDatabase.query(sQLiteQuery);
            try {
                return convertRows(query);
            } finally {
                query.close();
                sQLiteQuery.release();
            }
        }
        roomDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            cursor = this.mDb.query(sQLiteQuery);
            List<T> convertRows = convertRows(cursor);
            this.mDb.setTransactionSuccessful();
            return convertRows;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            this.mDb.endTransaction();
            sQLiteQuery.release();
        }
    }

    public List<T> convertRows(SQLiteStatement sQLiteStatement) {
        throw new UnsupportedOperationException("Unexpected call to a function with no implementation that Room is supposed to generate. Please file a bug at: https://issuetracker.google.com/issues/new?component=413107&template=1096568.");
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9, boolean z10, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z9, z10, strArr);
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z9, String... strArr) {
        this(roomDatabase, roomSQLiteQuery, z9, true, strArr);
    }

    public void loadRange(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z9, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z9, strArr);
    }
}
