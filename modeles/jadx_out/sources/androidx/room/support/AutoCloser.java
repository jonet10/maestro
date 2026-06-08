package androidx.room.support;

import androidx.annotation.GuardedBy;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.l;
import o7.a0;
import o7.c0;
import o7.e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AutoCloser {
    public static final String BUG_LINK = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    public static final Companion Companion = new Companion(null);
    private e1 autoCloseJob;
    private final long autoCloseTimeoutInMs;
    private a0 coroutineScope;

    @GuardedBy("lock")
    private SupportSQLiteDatabase delegateDatabase;
    private SupportSQLiteOpenHelper delegateOpenHelper;
    private AtomicLong lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private d7.a onAutoCloseCallback;
    private final AtomicInteger referenceCount;
    private final Watch watch;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Watch {
        long getMillis();
    }

    public AutoCloser(long j, TimeUnit timeUnit, Watch watch) {
        timeUnit.getClass();
        watch.getClass();
        this.watch = watch;
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j);
        this.referenceCount = new AtomicInteger(0);
        this.lastDecrementRefCountTimeStamp = new AtomicLong(watch.getMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoCloseDatabase() {
        synchronized (this.lock) {
            try {
                if (this.watch.getMillis() - this.lastDecrementRefCountTimeStamp.get() < this.autoCloseTimeoutInMs) {
                    return;
                }
                if (this.referenceCount.get() != 0) {
                    return;
                }
                d7.a aVar = this.onAutoCloseCallback;
                if (aVar == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                aVar.invoke();
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                e1 e1Var = this.autoCloseJob;
                if (e1Var != null) {
                    e1Var.c(null);
                }
                this.autoCloseJob = null;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Unbalanced reference count.");
            return;
        }
        this.lastDecrementRefCountTimeStamp.set(this.watch.getMillis());
        if (decrementAndGet == 0) {
            a0 a0Var = this.coroutineScope;
            if (a0Var != null) {
                this.autoCloseJob = c0.s(a0Var, null, null, new AutoCloser$decrementCountAndScheduleClose$2(this, null), 3);
            } else {
                l.i("coroutineScope");
                throw null;
            }
        }
    }

    public final <V> V executeRefCountingFunction(d7.l lVar) {
        lVar.getClass();
        try {
            return (V) lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final d7.a getAutoCloseCallbackForTest$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final int getRefCountForTest$room_runtime_release() {
        return this.referenceCount.get();
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        e1 e1Var = this.autoCloseJob;
        if (e1Var != null) {
            e1Var.c(null);
        }
        this.autoCloseJob = null;
        this.referenceCount.incrementAndGet();
        if (this.manuallyClosed) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Attempting to open already closed database.");
            return null;
        }
        synchronized (this.lock) {
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
            if (supportSQLiteOpenHelper == null) {
                l.i("delegateOpenHelper");
                throw null;
            }
            SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void initCoroutineScope(a0 a0Var) {
        a0Var.getClass();
        this.coroutineScope = a0Var;
    }

    public final void initOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        supportSQLiteOpenHelper.getClass();
        if (supportSQLiteOpenHelper instanceof AutoClosingRoomOpenHelper) {
            com.google.gson.internal.a.p("Failed requirement.");
        } else {
            this.delegateOpenHelper = supportSQLiteOpenHelper;
        }
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(d7.a aVar) {
        aVar.getClass();
        this.onAutoCloseCallback = aVar;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ AutoCloser(long j, TimeUnit timeUnit, Watch watch, int i, kotlin.jvm.internal.g gVar) {
        this(j, timeUnit, (i & 4) != 0 ? new a() : watch);
    }
}
