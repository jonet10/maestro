package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import f4.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class GenerateQueueWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3478a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3479b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3480c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3481d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateQueueWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3478a = context;
        this.f3479b = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        this.f3480c = workerParameters.getInputData().getBoolean("downloadUptodown", false);
        this.f3481d = workerParameters.getInputData().getString("packagename");
        Activity activity = c.f4875o;
        this.f3478a = f.e(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ee, code lost:
    
        if (r0 == null) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f6, code lost:
    
        if (r0.F.isEmpty() != false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f8, code lost:
    
        r0 = r0.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fa, code lost:
    
        if (r0 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0100, code lost:
    
        if (r0.isEmpty() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0103, code lost:
    
        r10 = r0.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        if (r9 >= r10) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0109, code lost:
    
        r11 = r0.get(r9);
        r9 = r9 + 1;
        r11 = (x4.j0) r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0113, code lost:
    
        if (r11.f11241r < r13) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0121, code lost:
    
        if (java.lang.System.currentTimeMillis() <= r11.f11242s) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0123, code lost:
    
        r13 = 4;
     */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GenerateQueueWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
