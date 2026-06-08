package com.uptodown.workers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import e1.c0;
import f4.c;
import j5.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import l7.u;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class SearchApksWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3488a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchApksWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3488a = context;
        Activity activity = c.f4875o;
        this.f3488a = f.e(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.io.File r20, int r21) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.SearchApksWorker.d(java.io.File, int):boolean");
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        boolean z9;
        Context context = this.f3488a;
        ListenableWorker.Result success = ListenableWorker.Result.success();
        success.getClass();
        try {
            ArrayList t9 = c0.t(context);
            g l10 = g.D.l(context);
            l10.b();
            ArrayList S = l10.S();
            Iterator it = t9.iterator();
            it.getClass();
            int i = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                Iterator it2 = S.iterator();
                int i6 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i6 = -1;
                        z9 = false;
                        break;
                    }
                    int i10 = i6 + 1;
                    if (u.m0(file.getAbsolutePath(), (String) it2.next(), false)) {
                        z9 = true;
                        break;
                    }
                    i6 = i10;
                }
                if (z9) {
                    S.remove(i6);
                } else if (i < 10 && d(file, i)) {
                    String absolutePath = file.getAbsolutePath();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("path", absolutePath);
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.insert("installable_files", null, contentValues);
                    i++;
                }
            }
            Iterator it3 = S.iterator();
            it3.getClass();
            while (it3.hasNext()) {
                Object next2 = it3.next();
                next2.getClass();
                SQLiteDatabase sQLiteDatabase2 = l10.f6673a;
                sQLiteDatabase2.getClass();
                sQLiteDatabase2.delete("installable_files", "path=?", new String[]{(String) next2});
            }
            l10.c();
            return success;
        } catch (Exception e10) {
            e10.printStackTrace();
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            failure.getClass();
            return failure;
        }
    }
}
