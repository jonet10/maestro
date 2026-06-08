package y2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArrayMap;
import b2.t1;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11776a;

    /* renamed from: b, reason: collision with root package name */
    public final s4.s f11777b;

    /* renamed from: c, reason: collision with root package name */
    public final g4.v f11778c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f11779d;
    public final ScheduledThreadPoolExecutor f;
    public final v h;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f11780e = new ArrayMap();
    public boolean g = false;

    public x(FirebaseMessaging firebaseMessaging, s4.s sVar, v vVar, g4.v vVar2, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f11779d = firebaseMessaging;
        this.f11777b = sVar;
        this.h = vVar;
        this.f11778c = vVar2;
        this.f11776a = context;
        this.f = scheduledThreadPoolExecutor;
    }

    public static void a(j1.p pVar) {
        try {
            t1.k(pVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e10) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e10);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e11);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static boolean d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public final void b(String str) {
        String a8 = this.f11779d.a();
        g4.v vVar = this.f11778c;
        vVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        a(vVar.d(vVar.k(a8, "/topics/" + str, bundle)));
    }

    public final void c(String str) {
        String a8 = this.f11779d.a();
        g4.v vVar = this.f11778c;
        vVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        a(vVar.d(vVar.k(a8, "/topics/" + str, bundle)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(u uVar) {
        synchronized (this.f11780e) {
            try {
                String str = uVar.f11766c;
                if (this.f11780e.containsKey(str)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f11780e.get(str);
                    j1.i iVar = (j1.i) arrayDeque.poll();
                    if (iVar != null) {
                        iVar.a(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f11780e.remove(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void f(boolean z9) {
        this.g = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0089 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #1 {IOException -> 0x005d, blocks: (B:8:0x0028, B:13:0x0083, B:15:0x0089, B:19:0x0039, B:21:0x0041, B:23:0x004a, B:26:0x005f, B:28:0x0067, B:30:0x0070), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.x.g():boolean");
    }

    public final void h(long j) {
        this.f.schedule(new z(this, this.f11776a, this.f11777b, Math.min(Math.max(30L, 2 * j), 28800L)), j, TimeUnit.SECONDS);
        f(true);
    }
}
