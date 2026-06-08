package a4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 {
    public static final AtomicInteger f = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    public final g0 f134a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f135b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136c;

    /* renamed from: d, reason: collision with root package name */
    public int f137d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f138e;

    public l0(g0 g0Var, Uri uri, int i) {
        this.f134a = g0Var;
        k0 k0Var = new k0();
        k0Var.f127b = uri;
        k0Var.f128c = i;
        this.f135b = k0Var;
    }

    public final k0 a(long j) {
        f.getAndIncrement();
        k0 k0Var = this.f135b;
        boolean z9 = k0Var.f;
        if (z9 && k0Var.f129d == 0 && k0Var.f130e == 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Center crop requires calling resize with positive width and height.");
            return null;
        }
        if (k0Var.h == 0) {
            k0Var.h = 2;
        }
        k0 k0Var2 = new k0((Uri) k0Var.f127b, k0Var.f128c, (ArrayList) k0Var.i, k0Var.f129d, k0Var.f130e, z9, k0Var.g, k0Var.h);
        this.f134a.f95a.getClass();
        return k0Var2;
    }

    public final void b(i iVar) {
        long nanoTime = System.nanoTime();
        if (this.f136c) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Fit cannot be used with fetch.");
            return;
        }
        k0 k0Var = this.f135b;
        if (((Uri) k0Var.f127b) == null && k0Var.f128c == 0) {
            return;
        }
        int i = k0Var.h;
        if (i == 0) {
            if (i != 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Priority already set.");
                return;
            }
            k0Var.h = 1;
        }
        k0 a8 = a(nanoTime);
        String a10 = t0.a(a8, new StringBuilder());
        g0 g0Var = this.f134a;
        if (g0Var.g(a10) != null) {
            if (iVar != null) {
                iVar.onSuccess();
            }
        } else {
            r rVar = new r(g0Var, a8, a10, iVar);
            n nVar = g0Var.f98d.h;
            nVar.sendMessage(nVar.obtainMessage(1, rVar));
        }
    }

    public final Bitmap c() {
        long nanoTime = System.nanoTime();
        StringBuilder sb = t0.f177a;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Method call should not happen from the main thread.");
            return null;
        }
        if (this.f136c) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Fit cannot be used with get.");
            return null;
        }
        k0 k0Var = this.f135b;
        Object obj = null;
        if (((Uri) k0Var.f127b) == null && k0Var.f128c == 0) {
            return null;
        }
        k0 a8 = a(nanoTime);
        g0 g0Var = this.f134a;
        return h.e(g0Var, g0Var.f98d, g0Var.f99e, g0Var.f, new s(g0Var, obj, a8, t0.a(a8, new StringBuilder()), 0)).f();
    }

    public final Drawable d() {
        int i = this.f137d;
        return i != 0 ? this.f134a.f97c.getDrawable(i) : this.f138e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(ImageView imageView, i iVar) {
        long nanoTime = System.nanoTime();
        StringBuilder sb = t0.f177a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Method call should happen from the main thread.");
            return;
        }
        if (imageView == null) {
            com.google.gson.internal.a.p("Target must not be null.");
            return;
        }
        k0 k0Var = this.f135b;
        Uri uri = (Uri) k0Var.f127b;
        g0 g0Var = this.f134a;
        if (uri == null && k0Var.f128c == 0) {
            g0Var.a(imageView);
            h0.a(imageView, d());
            return;
        }
        if (this.f136c) {
            if (k0Var.f129d != 0 || k0Var.f130e != 0) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Fit cannot be used with resize.");
                return;
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                h0.a(imageView, d());
                l lVar = new l(this, imageView, iVar);
                WeakHashMap weakHashMap = g0Var.h;
                if (weakHashMap.containsKey(imageView)) {
                    g0Var.a(imageView);
                }
                weakHashMap.put(imageView, lVar);
                return;
            }
            k0Var.e(width, height);
        }
        k0 a8 = a(nanoTime);
        StringBuilder sb2 = t0.f177a;
        String a10 = t0.a(a8, sb2);
        sb2.setLength(0);
        Bitmap g = g0Var.g(a10);
        if (g == null) {
            h0.a(imageView, d());
            t tVar = new t(g0Var, imageView, a8, a10);
            tVar.h = iVar;
            g0Var.c(tVar);
            return;
        }
        g0Var.a(imageView);
        Context context = g0Var.f97c;
        int i = h0.f116e;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new h0(context, g, drawable, 1));
        if (iVar != null) {
            iVar.onSuccess();
        }
    }

    public final void f(int i) {
        if (i == 0) {
            com.google.gson.internal.a.p("Placeholder image resource invalid.");
        } else if (this.f138e == null) {
            this.f137d = i;
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Placeholder image already set.");
        }
    }

    public final void g(Drawable drawable) {
        if (this.f137d == 0) {
            this.f138e = drawable;
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Placeholder image already set.");
        }
    }

    public final void h(q0 q0Var) {
        q0Var.b();
        k0 k0Var = this.f135b;
        if (((ArrayList) k0Var.i) == null) {
            k0Var.i = new ArrayList(2);
        }
        ((ArrayList) k0Var.i).add(q0Var);
    }
}
