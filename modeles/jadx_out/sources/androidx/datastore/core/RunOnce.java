package androidx.datastore.core;

import o7.c0;
import o7.q;
import o7.r;
import p6.x;
import t6.c;
import x7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class RunOnce {
    private final x7.a runMutex = h.a();
    private final q didRun = c0.a();

    public final Object awaitComplete(c cVar) {
        Object w2 = ((r) this.didRun).w(cVar);
        return w2 == u6.a.f10762a ? w2 : x.f8463a;
    }

    public abstract Object doRun(c cVar);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077 A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:13:0x0085, B:21:0x0069, B:25:0x0077), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [x7.a] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [x7.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runIfNeeded(t6.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            p6.x r4 = p6.x.f8463a
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L4a
            if (r1 == r3) goto L3e
            if (r1 != r2) goto L37
            java.lang.Object r1 = r0.L$1
            x7.a r1 = (x7.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            p6.a.e(r8)     // Catch: java.lang.Throwable -> L35
            goto L85
        L35:
            r8 = move-exception
            goto L90
        L37:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            r8 = 0
            return r8
        L3e:
            java.lang.Object r1 = r0.L$1
            x7.a r1 = (x7.a) r1
            java.lang.Object r3 = r0.L$0
            androidx.datastore.core.RunOnce r3 = (androidx.datastore.core.RunOnce) r3
            p6.a.e(r8)
            goto L69
        L4a:
            p6.a.e(r8)
            o7.q r8 = r7.didRun
            o7.m1 r8 = (o7.m1) r8
            boolean r8 = r8.O()
            if (r8 == 0) goto L58
            return r4
        L58:
            x7.a r8 = r7.runMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r1 = r8.lock(r5, r0)
            if (r1 != r6) goto L67
            goto L83
        L67:
            r3 = r7
            r1 = r8
        L69:
            o7.q r8 = r3.didRun     // Catch: java.lang.Throwable -> L35
            o7.m1 r8 = (o7.m1) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.O()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L77
            r1.unlock(r5)
            return r4
        L77:
            r0.L$0 = r3     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L35
            r0.label = r2     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r3.doRun(r0)     // Catch: java.lang.Throwable -> L35
            if (r8 != r6) goto L84
        L83:
            return r6
        L84:
            r0 = r3
        L85:
            o7.q r8 = r0.didRun     // Catch: java.lang.Throwable -> L35
            o7.r r8 = (o7.r) r8     // Catch: java.lang.Throwable -> L35
            r8.Q(r4)     // Catch: java.lang.Throwable -> L35
            r1.unlock(r5)
            return r4
        L90:
            r1.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(t6.c):java.lang.Object");
    }
}
