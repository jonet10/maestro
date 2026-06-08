package androidx.constraintlayout.core;

import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Pool<T> {
        T acquire();

        boolean release(T t9);

        void releaseAll(T[] tArr, int i);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i > 0) {
                this.mPool = new Object[i];
            } else {
                a.p("The max pool size must be > 0");
                throw null;
            }
        }

        private boolean isInPool(T t9) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == t9) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i <= 0) {
                return null;
            }
            int i6 = i - 1;
            Object[] objArr = this.mPool;
            T t9 = (T) objArr[i6];
            objArr[i6] = null;
            this.mPoolSize = i - 1;
            return t9;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t9) {
            int i = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t9;
            this.mPoolSize = i + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i6 = 0; i6 < i; i6++) {
                T t9 = tArr[i6];
                int i10 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i10 < objArr.length) {
                    objArr[i10] = t9;
                    this.mPoolSize = i10 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
