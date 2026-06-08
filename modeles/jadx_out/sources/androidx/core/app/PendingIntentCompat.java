package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.PendingIntentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PendingIntentCompat {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i, intent, onFinished, handler, str, bundle);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i6) {
            return PendingIntent.getForegroundService(context, i, intent, i6);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        public GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
            boolean z9 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z9 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i = i;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    if (!z9) {
                        throw th;
                    }
                    Thread.currentThread().interrupt();
                    throw th;
                }
            }
            if (z9) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i, str, bundle);
                this.mCallback = null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.c
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
                    PendingIntentCompat.GatedCallback.this.onSendFinished(pendingIntent, intent, i, str, bundle);
                }
            };
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z9, int i) {
        int i6;
        if (!z9) {
            i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i6 = 33554432;
        }
        return i6 | i;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i6, @Nullable Bundle bundle, boolean z9) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z9, i6), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i6, boolean z9) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z9, i6));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i, @NonNull Intent intent, int i6, boolean z9) {
        return PendingIntent.getBroadcast(context, i, intent, addMutabilityFlags(z9, i6));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i, @NonNull Intent intent, int i6, boolean z9) {
        return Api26Impl.getForegroundService(context, i, intent, addMutabilityFlags(z9, i6));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i, @NonNull Intent intent, int i6, boolean z9) {
        return PendingIntent.getService(context, i, intent, addMutabilityFlags(z9, i6));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i6, boolean z9) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z9, i6));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i6, @Nullable Bundle bundle, boolean z9) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z9, i6), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i, intent, onFinished, handler, null, null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
        } finally {
        }
    }
}
