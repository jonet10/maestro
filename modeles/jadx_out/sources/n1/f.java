package n1;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import e1.c0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k0.y;
import s1.m;
import t1.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f7906k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayMap f7907l = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f7908a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7909b;

    /* renamed from: c, reason: collision with root package name */
    public final h f7910c;

    /* renamed from: d, reason: collision with root package name */
    public final s1.f f7911d;
    public final m g;
    public final s2.b h;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f7912e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList j = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    public f(Context context, String str, h hVar) {
        ?? arrayList;
        int i = 0;
        this.f7908a = context;
        y.d(str);
        this.f7909b = str;
        this.f7910c = hVar;
        a aVar = FirebaseInitProvider.f3097a;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new s1.c((String) it.next(), i));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        j jVar = j.f9533a;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        int i6 = 1;
        arrayList3.add(new s1.c(new FirebaseCommonRegistrar(), i6));
        arrayList3.add(new s1.c(new ExecutorsRegistrar(), i6));
        arrayList4.add(s1.a.c(context, Context.class, new Class[0]));
        arrayList4.add(s1.a.c(this, f.class, new Class[0]));
        arrayList4.add(s1.a.c(hVar, h.class, new Class[0]));
        c0 c0Var = new c0(9);
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.f3098b.get()) {
            arrayList4.add(s1.a.c(aVar, a.class, new Class[0]));
        }
        s1.f fVar = new s1.f(arrayList3, arrayList4, c0Var);
        this.f7911d = fVar;
        Trace.endSection();
        this.g = new m(new b(i, this, context));
        this.h = fVar.c(q2.d.class);
        c cVar = new c(this);
        a();
        if (this.f7912e.get()) {
            j0.c.f6482n.f6483a.get();
        }
        this.i.add(cVar);
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f c() {
        f fVar;
        synchronized (f7906k) {
            try {
                fVar = (f) f7907l.get("[DEFAULT]");
                if (fVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + p0.c.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((q2.d) fVar.h.get()).c();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static f f(Context context) {
        synchronized (f7906k) {
            try {
                if (f7907l.containsKey("[DEFAULT]")) {
                    return c();
                }
                h a8 = h.a(context);
                if (a8 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return g(context, a8);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f g(Context context, h hVar) {
        f fVar;
        AtomicReference atomicReference = d.f7903a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = d.f7903a;
            if (atomicReference2.get() == null) {
                d dVar = new d();
                while (true) {
                    if (atomicReference2.compareAndSet(null, dVar)) {
                        j0.c.b(application);
                        j0.c.f6482n.a(dVar);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f7906k) {
            ArrayMap arrayMap = f7907l;
            y.i(!arrayMap.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            y.h(context, "Application context cannot be null.");
            fVar = new f(context, "[DEFAULT]", hVar);
            arrayMap.put("[DEFAULT]", fVar);
        }
        fVar.e();
        return fVar;
    }

    public final void a() {
        y.i(!this.f.get(), "FirebaseApp was deleted");
    }

    public final Object b(Class cls) {
        a();
        return this.f7911d.a(cls);
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f7909b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f7910c.f7919b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void e() {
        HashMap hashMap;
        if (!UserManagerCompat.isUserUnlocked(this.f7908a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f7909b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f7908a;
            AtomicReference atomicReference = e.f7904b;
            if (atomicReference.get() == null) {
                e eVar = new e(context);
                while (!atomicReference.compareAndSet(null, eVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f7909b);
        Log.i("FirebaseApp", sb2.toString());
        s1.f fVar = this.f7911d;
        a();
        boolean equals = "[DEFAULT]".equals(this.f7909b);
        AtomicReference atomicReference2 = fVar.f9127o;
        Boolean valueOf = Boolean.valueOf(equals);
        while (true) {
            if (atomicReference2.compareAndSet(null, valueOf)) {
                synchronized (fVar) {
                    hashMap = new HashMap(fVar.f9122a);
                }
                fVar.g(hashMap, equals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((q2.d) this.h.get()).c();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        fVar.a();
        return this.f7909b.equals(fVar.f7909b);
    }

    public final boolean h() {
        boolean z9;
        a();
        x2.a aVar = (x2.a) this.g.get();
        synchronized (aVar) {
            z9 = aVar.f11037a;
        }
        return z9;
    }

    public final int hashCode() {
        return this.f7909b.hashCode();
    }

    public final String toString() {
        android.support.v4.media.g gVar = new android.support.v4.media.g(this);
        gVar.p(this.f7909b, "name");
        gVar.p(this.f7910c, "options");
        return gVar.toString();
    }
}
