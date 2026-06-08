package j0;

import a4.c0;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArraySet;
import androidx.core.app.PendingIntentCompat;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k0.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Handler.Callback {
    public static e A;

    /* renamed from: x, reason: collision with root package name */
    public static final Status f6487x = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: y, reason: collision with root package name */
    public static final Status f6488y = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: z, reason: collision with root package name */
    public static final Object f6489z = new Object();

    /* renamed from: a, reason: collision with root package name */
    public long f6490a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6491b;

    /* renamed from: l, reason: collision with root package name */
    public k0.n f6492l;

    /* renamed from: m, reason: collision with root package name */
    public m0.b f6493m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f6494n;

    /* renamed from: o, reason: collision with root package name */
    public final h0.e f6495o;

    /* renamed from: p, reason: collision with root package name */
    public final android.support.v4.media.g f6496p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f6497q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f6498r;

    /* renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f6499s;

    /* renamed from: t, reason: collision with root package name */
    public final ArraySet f6500t;

    /* renamed from: u, reason: collision with root package name */
    public final ArraySet f6501u;
    public final c0 v;

    /* renamed from: w, reason: collision with root package name */
    public volatile boolean f6502w;

    public e(Context context, Looper looper) {
        h0.e eVar = h0.e.f5407d;
        this.f6490a = WorkRequest.MIN_BACKOFF_MILLIS;
        this.f6491b = false;
        this.f6497q = new AtomicInteger(1);
        this.f6498r = new AtomicInteger(0);
        this.f6499s = new ConcurrentHashMap(5, 0.75f, 1);
        this.f6500t = new ArraySet();
        this.f6501u = new ArraySet();
        this.f6502w = true;
        this.f6494n = context;
        c0 c0Var = new c0(looper, this, 4);
        Looper.getMainLooper();
        this.v = c0Var;
        this.f6495o = eVar;
        this.f6496p = new android.support.v4.media.g(25);
        PackageManager packageManager = context.getPackageManager();
        if (p0.b.f == null) {
            p0.b.f = Boolean.valueOf(p0.b.a() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (p0.b.f.booleanValue()) {
            this.f6502w = false;
        }
        c0Var.sendMessage(c0Var.obtainMessage(6));
    }

    public static Status b(a aVar, h0.b bVar) {
        return new Status(17, "API: " + ((String) aVar.f6479b.f248l) + " is not available on this device. Connection failed with: " + String.valueOf(bVar), bVar.f5396l, bVar);
    }

    public static e d(Context context) {
        e eVar;
        synchronized (f6489z) {
            try {
                if (A == null) {
                    Looper looper = k0.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = h0.e.f5406c;
                    A = new e(applicationContext, looper);
                }
                eVar = A;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final boolean a(h0.b bVar, int i) {
        h0.e eVar = this.f6495o;
        eVar.getClass();
        Context context = this.f6494n;
        if (!r0.a.a(context)) {
            int i6 = bVar.f5395b;
            PendingIntent pendingIntent = bVar.f5396l;
            if (!((i6 == 0 || pendingIntent == null) ? false : true)) {
                pendingIntent = null;
                Intent a8 = eVar.a(context, i6, null);
                if (a8 != null) {
                    pendingIntent = PendingIntentCompat.getActivity(context, 0, a8, 134217728, false);
                }
            }
            if (pendingIntent != null) {
                int i10 = GoogleApiActivity.f2465b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                eVar.f(context, i6, PendingIntent.getActivity(context, 0, intent, x0.d.f11036a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final m c(i0.d dVar) {
        a aVar = dVar.f5618e;
        ConcurrentHashMap concurrentHashMap = this.f6499s;
        m mVar = (m) concurrentHashMap.get(aVar);
        if (mVar == null) {
            mVar = new m(this, dVar);
            concurrentHashMap.put(aVar, mVar);
        }
        if (mVar.j.l()) {
            this.f6501u.add(aVar);
        }
        mVar.m();
        return mVar;
    }

    public final void e(h0.b bVar, int i) {
        if (a(bVar, i)) {
            return;
        }
        c0 c0Var = this.v;
        c0Var.sendMessage(c0Var.obtainMessage(5, i, 0, bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0306  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.e.handleMessage(android.os.Message):boolean");
    }
}
