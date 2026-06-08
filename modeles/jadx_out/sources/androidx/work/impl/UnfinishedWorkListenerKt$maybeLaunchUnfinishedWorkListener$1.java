package androidx.work.impl;

import androidx.work.Logger;
import d7.r;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", l = {59}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 extends v6.i implements r {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    public UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(t6.c cVar) {
        super(4, cVar);
    }

    @Override // d7.r
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((r7.i) obj, (Throwable) obj2, ((Number) obj3).longValue(), (t6.c) obj4);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        long j;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            Throwable th = (Throwable) this.L$0;
            long j6 = this.J$0;
            Logger logger = Logger.get();
            str = UnfinishedWorkListenerKt.TAG;
            logger.error(str, "Cannot check for unfinished work", th);
            j = UnfinishedWorkListenerKt.MAX_DELAY_MS;
            long min = Math.min(j6 * 30000, j);
            this.label = 1;
            Object j10 = c0.j(min, this);
            u6.a aVar = u6.a.f10762a;
            if (j10 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return Boolean.TRUE;
    }

    public final Object invoke(r7.i iVar, Throwable th, long j, t6.c cVar) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(cVar);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.L$0 = th;
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.J$0 = j;
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.invokeSuspend(x.f8463a);
    }
}
