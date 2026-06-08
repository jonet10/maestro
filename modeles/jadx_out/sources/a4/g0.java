package a4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.PicassoProvider;
import j$.util.DesugarCollections;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 {
    public static final c0 j = new c0(Looper.getMainLooper(), 0, false);

    /* renamed from: k, reason: collision with root package name */
    public static volatile g0 f94k = null;

    /* renamed from: a, reason: collision with root package name */
    public final f0 f95a;

    /* renamed from: b, reason: collision with root package name */
    public final List f96b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f97c;

    /* renamed from: d, reason: collision with root package name */
    public final q f98d;

    /* renamed from: e, reason: collision with root package name */
    public final a3.d f99e;
    public final o0 f;
    public final WeakHashMap g;
    public final WeakHashMap h;
    public final ReferenceQueue i;

    public g0(Context context, q qVar, a3.d dVar, f0 f0Var, o0 o0Var) {
        this.f97c = context;
        this.f98d = qVar;
        this.f99e = dVar;
        this.f95a = f0Var;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new k(context, 1));
        arrayList.add(new j(context));
        int i = 0;
        arrayList.add(new y(context, i));
        arrayList.add(new k(context, i));
        arrayList.add(new c(context));
        arrayList.add(new y(context, 1));
        arrayList.add(new b0(qVar.f170c, o0Var));
        this.f96b = DesugarCollections.unmodifiableList(arrayList);
        this.f = o0Var;
        this.g = new WeakHashMap();
        this.h = new WeakHashMap();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.i = referenceQueue;
        new e0(referenceQueue, j).start();
    }

    public static g0 d() {
        if (f94k == null) {
            synchronized (g0.class) {
                try {
                    if (f94k == null) {
                        Context context = PicassoProvider.f3287a;
                        if (context == null) {
                            throw new IllegalStateException("context == null");
                        }
                        f94k = new d0(context).h();
                    }
                } finally {
                }
            }
        }
        return f94k;
    }

    public final void a(Object obj) {
        StringBuilder sb = t0.f177a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Method call should happen from the main thread.");
            return;
        }
        b bVar = (b) this.g.remove(obj);
        if (bVar != null) {
            bVar.a();
            n nVar = this.f98d.h;
            nVar.sendMessage(nVar.obtainMessage(2, bVar));
        }
        if (obj instanceof ImageView) {
            l lVar = (l) this.h.remove((ImageView) obj);
            if (lVar != null) {
                lVar.f133l = null;
                WeakReference weakReference = lVar.f132b;
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView == null) {
                    return;
                }
                weakReference.clear();
                imageView.removeOnAttachStateChangeListener(lVar);
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(lVar);
                }
            }
        }
    }

    public final void b(Bitmap bitmap, int i, b bVar, Exception exc) {
        if (bVar.g) {
            return;
        }
        if (!bVar.f) {
            this.g.remove(bVar.d());
        }
        if (bitmap == null) {
            bVar.c(exc);
        } else if (i != 0) {
            bVar.b(bitmap, i);
        } else {
            s1.o.j("LoadedFrom cannot be null.");
        }
    }

    public final void c(b bVar) {
        Object d10 = bVar.d();
        if (d10 != null) {
            WeakHashMap weakHashMap = this.g;
            if (weakHashMap.get(d10) != bVar) {
                a(d10);
                weakHashMap.put(d10, bVar);
            }
        }
        n nVar = this.f98d.h;
        nVar.sendMessage(nVar.obtainMessage(1, bVar));
    }

    public final l0 e(String str) {
        if (str == null) {
            return new l0(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return new l0(this, Uri.parse(str), 0);
        }
        com.google.gson.internal.a.p("Path must not be empty.");
        return null;
    }

    public final l0 f() {
        return new l0(this, null, 2131231479);
    }

    public final Bitmap g(String str) {
        v vVar = (v) ((u) this.f99e.f63b).get(str);
        Bitmap bitmap = vVar != null ? vVar.f180a : null;
        o0 o0Var = this.f;
        if (bitmap != null) {
            o0Var.f148b.sendEmptyMessage(0);
            return bitmap;
        }
        o0Var.f148b.sendEmptyMessage(1);
        return bitmap;
    }
}
