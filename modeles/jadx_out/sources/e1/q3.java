package e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import j$.util.Objects;
import java.lang.ref.SoftReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Parcelable f4215b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f4216l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f4217m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4218n;

    public q3(w3 w3Var, c5 c5Var, boolean z9, e eVar) {
        this.f4214a = 2;
        this.f4215b = c5Var;
        this.f4216l = z9;
        this.f4218n = eVar;
        Objects.requireNonNull(w3Var);
        this.f4217m = w3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        int i;
        switch (this.f4214a) {
            case 0:
                w3 w3Var = (w3) this.f4217m;
                i0 i0Var = w3Var.f4359m;
                if (i0Var == null) {
                    w0 w0Var = w3Var.f3875a.f4264o;
                    t1.m(w0Var);
                    w0Var.f4339o.b("Discarding data. Failed to set user property");
                    return;
                } else {
                    w3Var.y(i0Var, this.f4216l ? null : (x4) this.f4218n, (c5) this.f4215b);
                    w3Var.t();
                    return;
                }
            case 1:
                w3 w3Var2 = (w3) this.f4217m;
                i0 i0Var2 = w3Var2.f4359m;
                if (i0Var2 == null) {
                    w0 w0Var2 = w3Var2.f3875a.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.b("Discarding data. Failed to send event to service");
                    return;
                } else {
                    w3Var2.y(i0Var2, this.f4216l ? null : (u) this.f4218n, (c5) this.f4215b);
                    w3Var2.t();
                    return;
                }
            case 2:
                w3 w3Var3 = (w3) this.f4217m;
                i0 i0Var3 = w3Var3.f4359m;
                if (i0Var3 == null) {
                    w0 w0Var3 = w3Var3.f3875a.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4339o.b("Discarding data. Failed to send conditional user property to service");
                    return;
                } else {
                    w3Var3.y(i0Var3, this.f4216l ? null : (e) this.f4218n, (c5) this.f4215b);
                    w3Var3.t();
                    return;
                }
            default:
                Intent intent = (Intent) this.f4215b;
                Context context = (Context) this.f4218n;
                boolean z9 = this.f4216l;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f4217m;
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
                    Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent2 != null) {
                        i = FirebaseInstanceIdReceiver.a(intent2);
                    } else {
                        int i6 = 500;
                        if (intent.getExtras() != null) {
                            g0.a aVar = new g0.a(intent);
                            Executor executor2 = null;
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            synchronized (FirebaseInstanceIdReceiver.class) {
                                try {
                                    SoftReference softReference = FirebaseInstanceIdReceiver.f3082b;
                                    if (softReference != null) {
                                        executor2 = (Executor) softReference.get();
                                    }
                                    if (executor2 == null) {
                                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new q0.a("pscm-ack-executor"));
                                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                                        executor2 = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                        FirebaseInstanceIdReceiver.f3082b = new SoftReference(executor2);
                                    }
                                    executor = executor2;
                                } finally {
                                }
                            }
                            executor.execute(new x1(context, aVar, countDownLatch, 10, false));
                            try {
                                i6 = ((Integer) b2.t1.j(new y2.j(context).b(intent))).intValue();
                            } catch (InterruptedException | ExecutionException e10) {
                                Log.e("FirebaseMessaging", "Failed to send message to service.", e10);
                            }
                            try {
                                if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                                    Log.w("CloudMessagingReceiver", "Message ack timed out");
                                }
                            } catch (InterruptedException e11) {
                                Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e11.toString()));
                            }
                        }
                        i = i6;
                    }
                    if (z9 && pendingResult != null) {
                        pendingResult.setResultCode(i);
                    }
                    if (pendingResult != null) {
                        pendingResult.finish();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    throw th;
                }
        }
    }

    public /* synthetic */ q3(w3 w3Var, c5 c5Var, boolean z9, l0.a aVar, int i) {
        this.f4214a = i;
        this.f4215b = c5Var;
        this.f4216l = z9;
        this.f4218n = aVar;
        this.f4217m = w3Var;
    }

    public /* synthetic */ q3(FirebaseInstanceIdReceiver firebaseInstanceIdReceiver, Intent intent, Context context, boolean z9, BroadcastReceiver.PendingResult pendingResult) {
        this.f4214a = 3;
        this.f4215b = intent;
        this.f4218n = context;
        this.f4216l = z9;
        this.f4217m = pendingResult;
    }
}
