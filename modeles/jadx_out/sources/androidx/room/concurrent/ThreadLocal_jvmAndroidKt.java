package androidx.room.concurrent;

import t6.f;
import t7.v;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ThreadLocal_jvmAndroidKt {
    public static final <T> f asContextElement(ThreadLocal<T> threadLocal, T t9) {
        threadLocal.getClass();
        return new v(threadLocal, t9);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static /* synthetic */ void ThreadLocal$annotations() {
    }
}
