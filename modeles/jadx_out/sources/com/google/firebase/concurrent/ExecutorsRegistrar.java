package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.android.gms.internal.measurement.i5;
import com.google.firebase.components.ComponentRegistrar;
import j9.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import r1.b;
import r1.c;
import r1.d;
import s1.e;
import s1.m;
import s1.o;
import s1.r;
import t1.a;
import t1.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ThreadPoolCreation"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final m f3073a = new m(new e(2));

    /* renamed from: b, reason: collision with root package name */
    public static final m f3074b = new m(new e(3));

    /* renamed from: c, reason: collision with root package name */
    public static final m f3075c = new m(new e(4));

    /* renamed from: d, reason: collision with root package name */
    public static final m f3076d = new m(new e(5));

    public static f a() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        detectNetwork.detectResourceMismatches();
        if (Build.VERSION.SDK_INT >= 26) {
            detectNetwork.detectUnbufferedIo();
        }
        return new f(Executors.newFixedThreadPool(4, new a("Firebase Background", 10, detectNetwork.penaltyLog().build())), (ScheduledExecutorService) f3076d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        r rVar = new r(r1.a.class, ScheduledExecutorService.class);
        r[] rVarArr = {new r(r1.a.class, ExecutorService.class), new r(r1.a.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(rVar);
        for (r rVar2 : rVarArr) {
            i5.i(rVar2, "Null interface");
        }
        Collections.addAll(hashSet, rVarArr);
        s1.a aVar = new s1.a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new o(2), hashSet3);
        r rVar3 = new r(b.class, ScheduledExecutorService.class);
        r[] rVarArr2 = {new r(b.class, ExecutorService.class), new r(b.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(rVar3);
        for (r rVar4 : rVarArr2) {
            i5.i(rVar4, "Null interface");
        }
        Collections.addAll(hashSet4, rVarArr2);
        s1.a aVar2 = new s1.a(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new o(3), hashSet6);
        r rVar5 = new r(c.class, ScheduledExecutorService.class);
        r[] rVarArr3 = {new r(c.class, ExecutorService.class), new r(c.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(rVar5);
        for (r rVar6 : rVarArr3) {
            i5.i(rVar6, "Null interface");
        }
        Collections.addAll(hashSet7, rVarArr3);
        s1.a aVar3 = new s1.a(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new o(4), hashSet9);
        u b7 = s1.a.b(new r(d.class, Executor.class));
        b7.f = new o(5);
        return Arrays.asList(aVar, aVar2, aVar3, b7.d());
    }
}
