package com.uptodown.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DeviceStatusWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3471a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceStatusWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3471a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d3 A[LOOP:1: B:55:0x01cd->B:57:0x01d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024b  */
    /* JADX WARN: Type inference failed for: r10v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DeviceStatusWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
