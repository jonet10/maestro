package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f2570a = Executors.defaultThreadFactory();

    public f1(k1 k1Var) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f2570a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
