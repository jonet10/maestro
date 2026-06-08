package androidx.core.util;

import androidx.annotation.IntRange;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Pools {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Pool<T> {
        T acquire();

        boolean release(T t9);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i) {
            if (i > 0) {
                this.pool = new Object[i];
            } else {
                com.google.gson.internal.a.p("The max pool size must be > 0");
                throw null;
            }
        }

        private final boolean isInPool(T t9) {
            int i = this.poolSize;
            for (int i6 = 0; i6 < i; i6++) {
                if (this.pool[i6] == t9) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i = this.poolSize;
            if (i <= 0) {
                return null;
            }
            int i6 = i - 1;
            T t9 = (T) this.pool[i6];
            t9.getClass();
            this.pool[i6] = null;
            this.poolSize--;
            return t9;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t9) {
            t9.getClass();
            if (isInPool(t9)) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Already in the pool!");
                return false;
            }
            int i = this.poolSize;
            Object[] objArr = this.pool;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t9;
            this.poolSize = i + 1;
            return true;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        public SynchronizedPool(int i) {
            super(i);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t9;
            synchronized (this.lock) {
                t9 = (T) super.acquire();
            }
            return t9;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T t9) {
            boolean release;
            t9.getClass();
            synchronized (this.lock) {
                release = super.release(t9);
            }
            return release;
        }
    }

    private Pools() {
    }
}
