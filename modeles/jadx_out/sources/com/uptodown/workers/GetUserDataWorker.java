package com.uptodown.workers;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class GetUserDataWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserDataWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(t6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof o5.i
            if (r0 == 0) goto L13
            r0 = r6
            o5.i r0 = (o5.i) r0
            int r1 = r0.f8186l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8186l = r1
            goto L18
        L13:
            o5.i r0 = new o5.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8184a
            int r1 = r0.f8186l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            p6.a.e(r6)     // Catch: java.lang.Exception -> L26
            goto L53
        L26:
            r6 = move-exception
            goto L5b
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2e:
            p6.a.e(r6)
            android.content.Context r6 = r5.getApplicationContext()     // Catch: java.lang.Exception -> L26
            r6.getClass()     // Catch: java.lang.Exception -> L26
            r0.f8186l = r3     // Catch: java.lang.Exception -> L26
            v7.e r1 = o7.m0.f8288a     // Catch: java.lang.Exception -> L26
            v7.d r1 = v7.d.f10884a     // Catch: java.lang.Exception -> L26
            c4.sc r3 = new c4.sc     // Catch: java.lang.Exception -> L26
            r4 = 25
            r3.<init>(r6, r2, r2, r4)     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = o7.c0.C(r3, r1, r0)     // Catch: java.lang.Exception -> L26
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L4e
            goto L50
        L4e:
            p6.x r6 = p6.x.f8463a     // Catch: java.lang.Exception -> L26
        L50:
            if (r6 != r0) goto L53
            return r0
        L53:
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L26
            r6.getClass()     // Catch: java.lang.Exception -> L26
            return r6
        L5b:
            r6.printStackTrace()
            android.support.v4.media.g r0 = new android.support.v4.media.g
            android.content.Context r1 = r5.getApplicationContext()
            r2 = 20
            r0.<init>(r1, r2)
            java.lang.String r1 = "GetUserDataWorker"
            r0.F(r1, r6)
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.success()
            r6.getClass()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GetUserDataWorker.doWork(t6.c):java.lang.Object");
    }
}
