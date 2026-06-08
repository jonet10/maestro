package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import f4.c;
import o5.l;
import o7.c0;
import o7.m0;
import t0.f;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PreRegisterWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3487a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreRegisterWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3487a = context;
        Activity activity = c.f4875o;
        this.f3487a = f.e(context);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success();
        success.getClass();
        try {
            e eVar = m0.f8288a;
            c0.s(c0.b(d.f10884a), null, null, new l(this, null), 3);
            return success;
        } catch (Exception e10) {
            e10.printStackTrace();
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            failure.getClass();
            return failure;
        }
    }
}
