package a4;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f168a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f169b;

    /* renamed from: c, reason: collision with root package name */
    public final f0.i f170c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f171d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f172e;
    public final WeakHashMap f;
    public final LinkedHashSet g;
    public final n h;
    public final Handler i;
    public final a3.d j;

    /* renamed from: k, reason: collision with root package name */
    public final o0 f173k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f174l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f175m;

    public q(Context context, j0 j0Var, Handler handler, f0.i iVar, a3.d dVar, o0 o0Var) {
        o oVar = new o("Picasso-Dispatcher", 10);
        oVar.start();
        Looper looper = oVar.getLooper();
        StringBuilder sb = t0.f177a;
        int i = 0;
        c0 c0Var = new c0(looper, 1, false);
        c0Var.sendMessageDelayed(c0Var.obtainMessage(), 1000L);
        this.f168a = context;
        this.f169b = j0Var;
        this.f171d = new LinkedHashMap();
        this.f172e = new WeakHashMap();
        this.f = new WeakHashMap();
        this.g = new LinkedHashSet();
        this.h = new n(oVar.getLooper(), this, i);
        this.f170c = iVar;
        this.i = handler;
        this.j = dVar;
        this.f173k = o0Var;
        this.f174l = new ArrayList(4);
        try {
            Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (NullPointerException | SecurityException unused) {
        }
        this.f175m = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        p pVar = new p(this, i);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        q qVar = (q) pVar.f158b;
        if (qVar.f175m) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        qVar.f168a.registerReceiver(pVar, intentFilter);
    }

    public final void a(h hVar) {
        Future future = hVar.v;
        if (future == null || !future.isCancelled()) {
            Bitmap bitmap = hVar.f111u;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f174l.add(hVar);
            n nVar = this.h;
            if (nVar.hasMessages(7)) {
                return;
            }
            nVar.sendEmptyMessageDelayed(7, 200L);
        }
    }

    public final void b(h hVar) {
        n nVar = this.h;
        nVar.sendMessage(nVar.obtainMessage(4, hVar));
    }

    public final void c(h hVar, boolean z9) {
        hVar.f101b.getClass();
        this.f171d.remove(hVar.f105o);
        a(hVar);
    }

    public final void d(b bVar, boolean z9) {
        b bVar2 = bVar.f72e;
        String str = bVar.f71d;
        if (this.g.contains(bVar2)) {
            this.f.put(bVar.d(), bVar);
            return;
        }
        LinkedHashMap linkedHashMap = this.f171d;
        h hVar = (h) linkedHashMap.get(str);
        if (hVar != null) {
            hVar.f101b.getClass();
            if (hVar.f109s == null) {
                hVar.f109s = bVar;
                return;
            }
            if (hVar.f110t == null) {
                hVar.f110t = new ArrayList(3);
            }
            hVar.f110t.add(bVar);
            int i = bVar.f69b.h;
            if (c.j.c(i) > c.j.c(hVar.A)) {
                hVar.A = i;
                return;
            }
            return;
        }
        ExecutorService executorService = this.f169b;
        boolean isShutdown = executorService.isShutdown();
        g0 g0Var = bVar.f68a;
        if (isShutdown) {
            return;
        }
        h e10 = h.e(g0Var, this, this.j, this.f173k, bVar);
        e10.v = executorService.submit(e10);
        linkedHashMap.put(str, e10);
        if (z9) {
            this.f172e.remove(bVar.d());
        }
    }
}
