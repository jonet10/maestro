package e2;

import a2.e;
import a2.f;
import a2.p;
import a2.q;
import a2.t;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.datastore.core.DataStore;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import b2.a0;
import b2.b0;
import b2.c1;
import b2.c2;
import b2.d1;
import b2.f0;
import b2.f1;
import b2.g1;
import b2.j2;
import b2.o0;
import b2.p0;
import b2.q0;
import b2.r0;
import b2.t1;
import b2.u0;
import b2.v0;
import b2.z0;
import c3.d0;
import c3.h1;
import c3.s0;
import c3.t0;
import e1.x1;
import f3.j;
import j$.util.DesugarCollections;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import k0.k;
import s1.o;
import t4.n0;
import t6.h;
import y1.g;
import y1.i;
import y1.r;
import y1.w;
import y1.x;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements e3.b, ViewBinding, t.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4465a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4466b;

    /* renamed from: l, reason: collision with root package name */
    public Object f4467l;

    /* renamed from: m, reason: collision with root package name */
    public Object f4468m;

    /* renamed from: n, reason: collision with root package name */
    public Object f4469n;

    /* renamed from: o, reason: collision with root package name */
    public Object f4470o;

    /* renamed from: p, reason: collision with root package name */
    public Object f4471p;

    /* renamed from: q, reason: collision with root package name */
    public Object f4472q;

    public d(Context context) {
        String str;
        this.f4465a = 0;
        String str2 = ((z0) v1.d.f10792a.b(context)).f988a;
        this.f4466b = str2;
        File filesDir = context.getFilesDir();
        this.f4467l = filesDir;
        if (str2.isEmpty()) {
            str = ".com.google.firebase.crashlytics.files.v1";
        } else {
            StringBuilder sb = new StringBuilder(".crashlytics.v3");
            sb.append(File.separator);
            sb.append(str2.length() > 40 ? g.h(str2) : str2.replaceAll("[^a-zA-Z0-9.]", "_"));
            str = sb.toString();
        }
        File file = new File(filesDir, str);
        l(file);
        this.f4468m = file;
        File file2 = new File(file, "open-sessions");
        l(file2);
        this.f4469n = file2;
        File file3 = new File(file, "reports");
        l(file3);
        this.f4470o = file3;
        File file4 = new File(file, "priority-reports");
        l(file4);
        this.f4471p = file4;
        File file5 = new File(file, "native-reports");
        l(file5);
        this.f4472q = file5;
    }

    public static p0 a(p0 p0Var, f fVar, d dVar, Map map) {
        Map unmodifiableMap;
        o0 a8 = p0Var.a();
        String c9 = ((a2.d) fVar.f19b).c();
        if (c9 != null) {
            a8.f896e = new c1(c9);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        boolean isEmpty = map.isEmpty();
        t tVar = (t) dVar.f4469n;
        if (isEmpty) {
            unmodifiableMap = ((e) ((AtomicMarkableReference) tVar.f53b).getReference()).a();
        } else {
            HashMap hashMap = new HashMap(((e) ((AtomicMarkableReference) tVar.f53b).getReference()).a());
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String b7 = e.b(1024, (String) entry.getKey());
                if (hashMap.size() < 64 || hashMap.containsKey(b7)) {
                    hashMap.put(b7, e.b(1024, (String) entry.getValue()));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " keys when adding event specific keys. Maximum allowable: 1024", null);
            }
            unmodifiableMap = DesugarCollections.unmodifiableMap(hashMap);
        }
        List i6 = i(unmodifiableMap);
        List i10 = i(((e) ((AtomicMarkableReference) ((t) dVar.f4470o).f53b).getReference()).a());
        if (!i6.isEmpty() || !i10.isEmpty()) {
            q0 q0Var = (q0) p0Var.f903c;
            a8.f894c = new q0(q0Var.f911a, i6, i10, q0Var.f914d, q0Var.f915e, q0Var.f, q0Var.g);
        }
        return a8.a();
    }

    public static j2 b(p0 p0Var, d dVar) {
        List a8 = ((q) dVar.f4471p).a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < a8.size(); i++) {
            p pVar = (p) a8.get(i);
            pVar.getClass();
            d1 d1Var = new d1();
            a2.b bVar = (a2.b) pVar;
            String str = bVar.f10e;
            if (str == null) {
                com.google.gson.internal.a.i("Null variantId");
                return null;
            }
            String str2 = bVar.f7b;
            if (str2 == null) {
                com.google.gson.internal.a.i("Null rolloutId");
                return null;
            }
            d1Var.f767a = new f1(str2, str);
            String str3 = bVar.f8c;
            if (str3 == null) {
                com.google.gson.internal.a.i("Null parameterKey");
                return null;
            }
            d1Var.f768b = str3;
            d1Var.f769c = bVar.f9d;
            d1Var.f770d = bVar.f;
            d1Var.f771e = (byte) (d1Var.f771e | 1);
            arrayList.add(d1Var.a());
        }
        if (arrayList.isEmpty()) {
            return p0Var;
        }
        o0 a10 = p0Var.a();
        a10.f = new g1(arrayList);
        return a10.a();
    }

    public static d c(View view) {
        int i = 2131362399;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, 2131362399);
        if (imageView != null) {
            i = 2131362469;
            if (((ImageView) ViewBindings.findChildViewById(view, 2131362469)) != null) {
                i = 2131362621;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, 2131362621);
                if (linearLayout != null) {
                    i = 2131362796;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, 2131362796);
                    if (progressBar != null) {
                        i = 2131363116;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, 2131363116);
                        if (relativeLayout != null) {
                            i = 2131363633;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131363633);
                            if (textView != null) {
                                i = 2131363968;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131363968);
                                if (textView2 != null) {
                                    return new d((LinearLayout) view, imageView, linearLayout, progressBar, relativeLayout, textView, textView2, 8);
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static d d(View view) {
        int i = 2131362435;
        if (((ImageView) ViewBindings.findChildViewById(view, 2131362435)) != null) {
            i = 2131363234;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, 2131363234);
            if (relativeLayout != null) {
                i = 2131363272;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, 2131363272);
                if (relativeLayout2 != null) {
                    i = 2131363341;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, 2131363341);
                    if (recyclerView != null) {
                        i = 2131363862;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131363862);
                        if (textView != null) {
                            i = 2131364087;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364087);
                            if (textView2 != null) {
                                i = 2131364409;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, 2131364409);
                                if (textView3 != null) {
                                    return new d((LinearLayout) view, relativeLayout, relativeLayout2, recyclerView, textView, textView2, textView3, 10);
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static String f(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return byteArrayOutputStream2;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static d g(Context context, x xVar, d dVar, y1.a aVar, f fVar, d dVar2, android.support.v4.media.g gVar, g2.e eVar, m8.q qVar, i iVar, z1.e eVar2) {
        r rVar = new r(context, xVar, aVar, gVar, eVar);
        b bVar = new b(dVar, eVar, iVar);
        c2.c cVar = f2.a.f4817b;
        r.r.b(context);
        return new d(rVar, bVar, new f2.a(new f2.c(r.r.a().c(new p.a(f2.a.f4818c, f2.a.f4819d)).a("FIREBASE_CRASHLYTICS_REPORT", new o.c("json"), f2.a.f4820e), eVar.b(), qVar)), fVar, dVar2, xVar, eVar2, 12);
    }

    public static List i(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                com.google.gson.internal.a.i("Null key");
                return null;
            }
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                com.google.gson.internal.a.i("Null value");
                return null;
            }
            arrayList.add(new f0(str, str2));
        }
        Collections.sort(arrayList, new androidx.constraintlayout.core.utils.a(13));
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public static d j(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558515, (ViewGroup) null, false);
        int i = 2131362004;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(inflate, 2131362004);
        if (checkBox != null) {
            i = 2131363694;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363694);
            if (textView != null) {
                i = 2131363788;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363788);
                if (textView2 != null) {
                    i = 2131364113;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364113);
                    if (textView3 != null) {
                        i = 2131364272;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364272);
                        if (textView4 != null) {
                            i = 2131364385;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364385);
                            if (textView5 != null) {
                                return new d((RelativeLayout) inflate, checkBox, textView, textView2, textView3, textView4, textView5, 6);
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public static synchronized void l(File file) {
        synchronized (d.class) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        return;
                    }
                    String str = "Unexpected non-directory file: " + file + "; deleting file and creating new directory.";
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", str, null);
                    }
                    file.delete();
                }
                if (!file.mkdirs()) {
                    Log.e("FirebaseCrashlytics", "Could not create Crashlytics-specific directory: " + file, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean m(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                m(file2);
            }
        }
        return file.delete();
    }

    public static List n(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public void e(String str) {
        File file = new File((File) this.f4467l, str);
        if (file.exists() && m(file)) {
            String str2 = "Deleted previous Crashlytics file system: " + file.getPath();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str2, null);
            }
        }
    }

    @Override // m6.a
    public Object get() {
        switch (this.f4465a) {
            case 2:
                return new c3.d1((j) ((m6.a) this.f4466b).get(), (t0) ((m6.a) this.f4467l).get(), (s0) ((m6.a) this.f4468m).get(), (h1) ((m6.a) this.f4469n).get(), (DataStore) ((m6.a) this.f4470o).get(), (d0) ((e3.c) this.f4471p).get(), (h) ((m6.a) this.f4472q).get());
            default:
                return new x.g((Context) ((m6.a) this.f4466b).get(), (s.d) ((m6.a) this.f4467l).get(), (y.d) ((m6.a) this.f4468m).get(), (n0) ((n0) this.f4469n).get(), (Executor) ((m6.a) this.f4470o).get(), (z.c) ((m6.a) this.f4471p).get(), new q2.e(2), new q2.e(1), (y.c) ((m6.a) this.f4472q).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f4465a) {
            case 6:
                return (RelativeLayout) this.f4466b;
            case 7:
                return (LinearLayout) this.f4466b;
            case 8:
                return (LinearLayout) this.f4466b;
            case 9:
                return (RelativeLayout) this.f4466b;
            default:
                return (LinearLayout) this.f4466b;
        }
    }

    public File h(String str, String str2) {
        File file = new File((File) this.f4469n, str);
        file.mkdirs();
        return new File(file, str2);
    }

    public void k(Throwable th, Thread thread, String str, final a2.c cVar, boolean z9) {
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it;
        byte b7;
        final boolean equals = str.equals("crash");
        r rVar = (r) this.f4466b;
        long j = cVar.f12b;
        Context context = rVar.f11669a;
        int i = context.getResources().getConfiguration().orientation;
        android.support.v4.media.g gVar = rVar.f11672d;
        Stack stack = new Stack();
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            stack.push(th2);
        }
        s sVar = null;
        while (!stack.isEmpty()) {
            Throwable th3 = (Throwable) stack.pop();
            sVar = new s(th3.getLocalizedMessage(), th3.getClass().getName(), gVar.d(th3.getStackTrace()), sVar, 6);
        }
        s sVar2 = sVar;
        o0 o0Var = new o0();
        o0Var.f893b = str;
        o0Var.f892a = j;
        o0Var.g = (byte) (o0Var.g | 1);
        c2 b10 = v1.d.f10792a.b(context);
        int i6 = ((z0) b10).f990c;
        Boolean valueOf = i6 > 0 ? Boolean.valueOf(i6 != 100) : null;
        ArrayList a8 = v1.d.a(context);
        byte b11 = (byte) 1;
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) sVar2.f11757m;
        String name = thread.getName();
        if (name == null) {
            com.google.gson.internal.a.i("Null name");
            return;
        }
        byte b12 = (byte) 1;
        List d10 = r.d(stackTraceElementArr, 4);
        if (d10 == null) {
            com.google.gson.internal.a.i("Null frames");
            return;
        }
        if (b12 != 1) {
            StringBuilder sb = new StringBuilder();
            if (b12 == 0) {
                sb.append(" importance");
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb));
            return;
        }
        arrayList.add(new v0(name, 4, d10));
        if (z9) {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = Thread.getAllStackTraces().entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Thread, StackTraceElement[]> next = it2.next();
                Thread key = next.getKey();
                if (key.equals(thread)) {
                    it = it2;
                    b7 = b12;
                } else {
                    StackTraceElement[] d11 = gVar.d(next.getValue());
                    String name2 = key.getName();
                    if (name2 == null) {
                        com.google.gson.internal.a.i("Null name");
                        return;
                    }
                    it = it2;
                    List d12 = r.d(d11, 0);
                    if (d12 == null) {
                        com.google.gson.internal.a.i("Null frames");
                        return;
                    }
                    if (b12 != 1) {
                        byte b13 = b12;
                        StringBuilder sb2 = new StringBuilder();
                        if (b13 == 0) {
                            sb2.append(" importance");
                        }
                        androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb2));
                        return;
                    }
                    b7 = b12;
                    arrayList.add(new v0(name2, 0, d12));
                }
                it2 = it;
                b12 = b7;
            }
        }
        List unmodifiableList = DesugarCollections.unmodifiableList(arrayList);
        b2.t0 c9 = r.c(sVar2, 0);
        u0 e10 = r.e();
        List a10 = rVar.a();
        if (a10 == null) {
            com.google.gson.internal.a.i("Null binaries");
            return;
        }
        r0 r0Var = new r0(unmodifiableList, c9, null, e10, a10);
        if (b11 != 1) {
            StringBuilder sb3 = new StringBuilder();
            if (b11 == 0) {
                sb3.append(" uiOrientation");
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb3));
            return;
        }
        o0Var.f894c = new q0(r0Var, null, null, valueOf, b10, a8, i);
        o0Var.f895d = rVar.b(i);
        p0 a11 = o0Var.a();
        Map map = cVar.f13c;
        f fVar = (f) this.f4469n;
        d dVar = (d) this.f4470o;
        final j2 b14 = b(a(a11, fVar, dVar, map), dVar);
        if (z9) {
            ((b) this.f4467l).d(b14, cVar.f11a, equals);
        } else {
            ((z1.e) this.f4472q).f11909b.a(new Runnable() { // from class: y1.y
                @Override // java.lang.Runnable
                public final void run() {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "disk worker: log non-fatal event to persistence", null);
                    }
                    ((e2.b) e2.d.this.f4467l).d(b14, cVar.f11a, equals);
                }
            });
        }
    }

    public j1.p o(String str, Executor executor) {
        j1.i iVar;
        ArrayList b7 = ((b) this.f4467l).b();
        ArrayList arrayList = new ArrayList();
        int size = b7.size();
        int i = 0;
        while (i < size) {
            int i6 = i + 1;
            File file = (File) b7.get(i);
            try {
                c2.c cVar = b.g;
                String e10 = b.e(file);
                cVar.getClass();
                arrayList.add(new y1.b(c2.c.i(e10), file.getName(), file));
            } catch (IOException e11) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e11);
                file.delete();
            }
            i = i6;
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            y1.b bVar = (y1.b) obj;
            if (str == null || str.equals(bVar.f11605b)) {
                f2.a aVar = (f2.a) this.f4468m;
                b0 b0Var = bVar.f11604a;
                if (b0Var.f == null || b0Var.g == null) {
                    w b10 = ((x) this.f4471p).b(true);
                    b0 b0Var2 = bVar.f11604a;
                    String str2 = b10.f11687a;
                    a0 a8 = b0Var2.a();
                    a8.f719e = str2;
                    b0 a10 = a8.a();
                    String str3 = b10.f11688b;
                    a0 a11 = a10.a();
                    a11.f = str3;
                    bVar = new y1.b(a11.a(), bVar.f11605b, bVar.f11606c);
                }
                boolean z9 = str != null;
                f2.c cVar2 = aVar.f4821a;
                synchronized (cVar2.f) {
                    try {
                        iVar = new j1.i();
                        if (z9) {
                            ((AtomicInteger) cVar2.i.f7780b).getAndIncrement();
                            if (cVar2.f.size() < cVar2.f4830e) {
                                v1.c cVar3 = v1.c.f10791a;
                                cVar3.b("Enqueueing report: " + bVar.f11605b);
                                cVar3.b("Queue size: " + cVar2.f.size());
                                cVar2.g.execute(new x1(cVar2, bVar, iVar, 9));
                                cVar3.b("Closing task for report: " + bVar.f11605b);
                                iVar.c(bVar);
                            } else {
                                cVar2.a();
                                String str4 = "Dropping report due to queue being full: " + bVar.f11605b;
                                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", str4, null);
                                }
                                ((AtomicInteger) cVar2.i.f7781l).getAndIncrement();
                                iVar.c(bVar);
                            }
                        } else {
                            cVar2.b(bVar, iVar);
                        }
                    } finally {
                    }
                }
                arrayList2.add(iVar.f6539a.d(executor, new o(this, 24)));
            }
        }
        return t1.Q(arrayList2);
    }

    public void p() {
        Thread thread = (Thread) this.f4471p;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new m4.c(this, 0));
            this.f4471p = thread2;
            thread2.start();
        }
    }

    public d(int i) {
        this.f4465a = i;
        switch (i) {
            case 4:
                this.f4466b = new AtomicBoolean();
                this.f4467l = null;
                this.f4468m = new HashMap(16, 1.0f);
                this.f4469n = new HashMap(16, 1.0f);
                this.f4470o = new HashMap(16, 1.0f);
                this.f4471p = new HashMap(16, 1.0f);
                this.f4472q = null;
                break;
        }
    }

    public d(Context context, b4.g gVar, m4.b bVar) {
        this.f4465a = 5;
        context.getClass();
        gVar.getClass();
        this.f4466b = context;
        this.f4467l = gVar;
        this.f4468m = bVar;
        Thread thread = new Thread(new m4.c(this, 2));
        this.f4470o = thread;
        thread.start();
    }

    public d(LinearLayout linearLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3) {
        this.f4465a = 7;
        this.f4466b = linearLayout;
        this.f4467l = editText;
        this.f4468m = imageView2;
        this.f4469n = imageView3;
        this.f4470o = imageView4;
        this.f4471p = imageView5;
        this.f4472q = imageView6;
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i) {
        this.f4465a = i;
        this.f4466b = obj;
        this.f4467l = obj2;
        this.f4468m = obj3;
        this.f4469n = obj4;
        this.f4470o = obj5;
        this.f4471p = obj6;
        this.f4472q = obj7;
    }

    public d(String str, d dVar, z1.e eVar) {
        this.f4465a = 1;
        this.f4469n = new t(this, false);
        this.f4470o = new t(this, true);
        this.f4471p = new q();
        this.f4472q = new AtomicMarkableReference(null, false);
        this.f4466b = str;
        this.f4467l = new a2.h(dVar);
        this.f4468m = eVar;
    }
}
