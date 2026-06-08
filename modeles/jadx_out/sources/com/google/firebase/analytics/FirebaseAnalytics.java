package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.work.WorkRequest;
import b2.t1;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.y0;
import e1.c3;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.y;
import n1.f;
import o1.a;
import t2.c;
import t2.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f3071b;

    /* renamed from: a, reason: collision with root package name */
    public final k1 f3072a;

    public FirebaseAnalytics(k1 k1Var) {
        y.g(k1Var);
        this.f3072a = k1Var;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f3071b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f3071b == null) {
                        f3071b = new FirebaseAnalytics(k1.c(context, null));
                    }
                } finally {
                }
            }
        }
        return f3071b;
    }

    @Nullable
    @Keep
    public static c3 getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        k1 c9 = k1.c(context, bundle);
        if (c9 == null) {
            return null;
        }
        return new a(c9);
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = c.f9541m;
            return (String) t1.k(((c) f.c().b(d.class)).d(), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @MainThread
    @Deprecated
    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        w0 c9 = w0.c(activity);
        k1 k1Var = this.f3072a;
        k1Var.getClass();
        k1Var.a(new y0(k1Var, c9, str, str2));
    }
}
