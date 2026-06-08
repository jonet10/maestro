package androidx.datastore.core;

import r7.f0;
import r7.h;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SingleProcessCoordinator implements InterProcessCoordinator {
    private final String filePath;
    private final x7.a mutex;
    private final h updateNotifications;
    private final AtomicInt version;

    public SingleProcessCoordinator(String str) {
        str.getClass();
        this.filePath = str;
        this.mutex = x7.h.a();
        this.version = new AtomicInt(0);
        this.updateNotifications = new f0(new SingleProcessCoordinator$updateNotifications$1(null));
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public h getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(c cVar) {
        return new Integer(this.version.get());
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(c cVar) {
        return new Integer(this.version.incrementAndGet());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        if (r9.lock(null, r0) == r5) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object lock(d7.l r8, t6.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessCoordinator$lock$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator$lock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$lock$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L46
            if (r1 == r3) goto L38
            if (r1 != r2) goto L31
            java.lang.Object r8 = r0.L$0
            x7.a r8 = (x7.a) r8
            p6.a.e(r9)     // Catch: java.lang.Throwable -> L2f
            goto L68
        L2f:
            r9 = move-exception
            goto L70
        L31:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            r8 = 0
            return r8
        L38:
            java.lang.Object r8 = r0.L$1
            x7.a r8 = (x7.a) r8
            java.lang.Object r1 = r0.L$0
            d7.l r1 = (d7.l) r1
            p6.a.e(r9)
            r9 = r8
            r8 = r1
            goto L58
        L46:
            p6.a.e(r9)
            x7.a r9 = r7.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r1 = r9.lock(r4, r0)
            if (r1 != r5) goto L58
            goto L64
        L58:
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L6c
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L6c
            r0.label = r2     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6c
            if (r8 != r5) goto L65
        L64:
            return r5
        L65:
            r6 = r9
            r9 = r8
            r8 = r6
        L68:
            r8.unlock(r4)
            return r9
        L6c:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L70:
            r8.unlock(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.lock(d7.l, t6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object tryLock(d7.p r6, t6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.SingleProcessCoordinator$tryLock$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator$tryLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$tryLock$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            boolean r6 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            x7.a r0 = (x7.a) r0
            p6.a.e(r7)     // Catch: java.lang.Throwable -> L2c
            goto L54
        L2c:
            r7 = move-exception
            goto L5e
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L35:
            p6.a.e(r7)
            x7.a r7 = r5.mutex
            boolean r1 = r7.tryLock(r3)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L5a
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5a
            r0.Z$0 = r1     // Catch: java.lang.Throwable -> L5a
            r0.label = r2     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r6 = r6.invoke(r4, r0)     // Catch: java.lang.Throwable -> L5a
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L51
            return r0
        L51:
            r0 = r7
            r7 = r6
            r6 = r1
        L54:
            if (r6 == 0) goto L59
            r0.unlock(r3)
        L59:
            return r7
        L5a:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r1
        L5e:
            if (r6 == 0) goto L63
            r0.unlock(r3)
        L63:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.tryLock(d7.p, t6.c):java.lang.Object");
    }
}
