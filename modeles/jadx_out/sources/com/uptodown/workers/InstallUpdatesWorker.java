package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import f4.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class InstallUpdatesWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3485a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3485a = context;
        Activity activity = c.f4875o;
        this.f3485a = f.e(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() {
        /*
            Method dump skipped, instructions count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.InstallUpdatesWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
