package androidx.room.coroutines;

import d7.p;
import o7.c0;
import t6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RunBlockingUninterruptible_androidKt {
    public static final <T> T runBlockingUninterruptible(p pVar) {
        pVar.getClass();
        Thread.interrupted();
        return (T) c0.w(i.f10314a, new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(pVar, null));
    }
}
