package androidx.room;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObservedTableStates {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ObserveOp {
        private static final /* synthetic */ w6.a $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        static {
            ObserveOp[] $values = $values();
            $VALUES = $values;
            $ENTRIES = t0.f.u($values);
        }

        private ObserveOp(String str, int i) {
        }

        public static w6.a getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }
    }

    public ObservedTableStates(int i) {
        this.tableObserversCount = new long[i];
        this.tableObservedState = new boolean[i];
    }

    public final void forceNeedSync$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final ObserveOp[] getTablesToSync$room_runtime_release() {
        ObserveOp observeOp;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.needsSync) {
                reentrantLock.unlock();
                return null;
            }
            this.needsSync = false;
            int length = this.tableObserversCount.length;
            ObserveOp[] observeOpArr = new ObserveOp[length];
            int i = 0;
            boolean z9 = false;
            while (i < length) {
                boolean z10 = true;
                boolean z11 = this.tableObserversCount[i] > 0;
                boolean[] zArr = this.tableObservedState;
                if (z11 != zArr[i]) {
                    zArr[i] = z11;
                    observeOp = z11 ? ObserveOp.ADD : ObserveOp.REMOVE;
                } else {
                    z10 = z9;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr[i] = observeOp;
                i++;
                z9 = z10;
            }
            ObserveOp[] observeOpArr2 = z9 ? observeOpArr : null;
            reentrantLock.unlock();
            return observeOpArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean onObserverAdded$room_runtime_release(int[] iArr) {
        iArr.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z9 = false;
            for (int i : iArr) {
                long[] jArr = this.tableObserversCount;
                long j = jArr[i];
                jArr[i] = 1 + j;
                if (j == 0) {
                    z9 = true;
                    this.needsSync = true;
                }
            }
            return z9;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] iArr) {
        iArr.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z9 = false;
            for (int i : iArr) {
                long[] jArr = this.tableObserversCount;
                long j = jArr[i];
                jArr[i] = j - 1;
                if (j == 1) {
                    z9 = true;
                    this.needsSync = true;
                }
            }
            return z9;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void resetTriggerState$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean[] zArr = this.tableObservedState;
            int length = zArr.length;
            zArr.getClass();
            Arrays.fill(zArr, 0, length, false);
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
