package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.g;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import f4.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UploadFileWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3495a;

    /* renamed from: b, reason: collision with root package name */
    public final g f3496b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3495a = context;
        this.f3496b = new g(context, 20);
        Activity activity = c.f4875o;
        this.f3495a = f.e(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03ee  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.UploadFileWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
