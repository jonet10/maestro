package com.uptodown.workers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.g;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import java.util.ArrayList;
import java.util.Iterator;
import x4.p;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class GetUpdatesWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3482a;

    /* renamed from: b, reason: collision with root package name */
    public final g f3483b;

    /* renamed from: c, reason: collision with root package name */
    public int f3484c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3482a = context;
        this.f3483b = new g(context, 20);
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(com.uptodown.workers.GetUpdatesWorker r24, org.json.JSONObject r25) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GetUpdatesWorker.b(com.uptodown.workers.GetUpdatesWorker, org.json.JSONObject):void");
    }

    public final void c(q2 q2Var) {
        ArrayList arrayList = q2Var.f11353t;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = q2Var.f11353t;
        arrayList2.getClass();
        ArrayList c9 = p.c(this.f3482a, arrayList2);
        if (c9.isEmpty()) {
            return;
        }
        Iterator it = c9.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            Bundle bundle = new Bundle();
            bundle.putInt("update", 1);
            bundle.putString("feature", (String) next);
            this.f3483b.E(bundle, "required_features_not_supported");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if (r5 != 4) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList d(org.json.JSONArray r8, j5.g r9, boolean r10) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r8.length()
            r2 = 0
        La:
            if (r2 >= r1) goto L7b
            org.json.JSONObject r3 = r8.optJSONObject(r2)
            java.lang.String r4 = "packagename"
            boolean r5 = r3.isNull(r4)
            if (r5 != 0) goto L78
            java.lang.String r4 = r3.optString(r4)
            r4.getClass()
            x4.e r4 = r9.B(r4)
            if (r4 == 0) goto L78
            x4.q2 r3 = b2.t1.G(r4, r3)
            if (r3 == 0) goto L78
            r4 = 1
            if (r10 == 0) goto L30
            r3.f11349p = r4
        L30:
            java.lang.String r5 = r3.f11344b
            x4.q2 r6 = r9.Y(r5)
            if (r6 == 0) goto L48
            boolean r4 = r6.b(r3)
            if (r4 == 0) goto L75
            r9.s(r5)
            r9.e0(r3)
            r7.c(r3)
            goto L75
        L48:
            r9.e0(r3)
            r7.c(r3)
            android.content.Context r6 = r7.f3482a
            r6.getClass()
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Error -> L65 java.lang.Exception -> L67
            int r5 = r6.getApplicationEnabledSetting(r5)     // Catch: java.lang.Error -> L65 java.lang.Exception -> L67
            r6 = 2
            if (r5 == r6) goto L75
            r6 = 3
            if (r5 == r6) goto L75
            r6 = 4
            if (r5 != r6) goto L70
            goto L75
        L65:
            r5 = move-exception
            goto L69
        L67:
            r5 = move-exception
            goto L6d
        L69:
            r5.printStackTrace()
            goto L70
        L6d:
            r5.printStackTrace()
        L70:
            int r5 = r7.f3484c
            int r5 = r5 + r4
            r7.f3484c = r5
        L75:
            r0.add(r3)
        L78:
            int r2 = r2 + 1
            goto La
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GetUpdatesWorker.d(org.json.JSONArray, j5.g, boolean):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(t6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof o5.g
            if (r0 == 0) goto L13
            r0 = r5
            o5.g r0 = (o5.g) r0
            int r1 = r0.f8182l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8182l = r1
            goto L18
        L13:
            o5.g r0 = new o5.g
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8180a
            int r1 = r0.f8182l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r5)
            goto L43
        L26:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return r2
        L2c:
            p6.a.e(r5)
            v7.e r5 = o7.m0.f8288a
            v7.d r5 = v7.d.f10884a
            o5.h r1 = new o5.h
            r1.<init>(r4, r2)
            r0.f8182l = r3
            java.lang.Object r5 = o7.c0.C(r1, r5, r0)
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L43
            return r0
        L43:
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GetUpdatesWorker.doWork(t6.c):java.lang.Object");
    }
}
