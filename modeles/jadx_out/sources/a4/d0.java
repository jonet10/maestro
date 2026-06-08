package a4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c3.h1;
import com.uptodown.core.activities.InstallerActivity;
import j$.util.DesugarCollections;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 implements e3.b, s1.b, ViewBinding, t.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f80a;

    /* renamed from: b, reason: collision with root package name */
    public Object f81b;

    /* renamed from: l, reason: collision with root package name */
    public Object f82l;

    /* renamed from: m, reason: collision with root package name */
    public Object f83m;

    /* renamed from: n, reason: collision with root package name */
    public Object f84n;

    /* renamed from: o, reason: collision with root package name */
    public Object f85o;

    public d0(s1.a aVar, s1.b bVar) {
        this.f80a = 6;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<s1.i> set = aVar.f9115c;
        Set set2 = aVar.g;
        for (s1.i iVar : set) {
            int i = iVar.f9136c;
            int i6 = iVar.f9135b;
            boolean z9 = i == 0;
            s1.r rVar = iVar.f9134a;
            if (z9) {
                if (i6 == 2) {
                    hashSet4.add(rVar);
                } else {
                    hashSet.add(rVar);
                }
            } else if (i == 2) {
                hashSet3.add(rVar);
            } else if (i6 == 2) {
                hashSet5.add(rVar);
            } else {
                hashSet2.add(rVar);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(s1.r.a(p2.b.class));
        }
        this.f81b = DesugarCollections.unmodifiableSet(hashSet);
        this.f82l = DesugarCollections.unmodifiableSet(hashSet2);
        this.f83m = DesugarCollections.unmodifiableSet(hashSet3);
        this.f84n = DesugarCollections.unmodifiableSet(hashSet4);
        DesugarCollections.unmodifiableSet(hashSet5);
        this.f85o = bVar;
    }

    public static d0 g(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = 2131363378;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, 2131363378);
        if (switchCompat != null) {
            i = 2131364176;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364176);
            if (textView != null) {
                i = 2131364177;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364177);
                if (textView2 != null) {
                    return new d0(relativeLayout, relativeLayout, switchCompat, textView, textView2, 10);
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static d0 i(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        d0 d0Var = new d0(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (((ArrayDeque) d0Var.f84n)) {
            try {
                ((ArrayDeque) d0Var.f84n).clear();
                String string = ((SharedPreferences) d0Var.f81b).getString((String) d0Var.f82l, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) d0Var.f83m)) {
                    String[] split = string.split((String) d0Var.f83m, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) d0Var.f84n).add(str);
                        }
                    }
                    return d0Var;
                }
                return d0Var;
            } finally {
            }
        }
    }

    public static d0 k(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558508, (ViewGroup) null, false);
        int i = 2131362003;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(inflate, 2131362003);
        if (checkBox != null) {
            i = 2131363688;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363688);
            if (textView != null) {
                i = 2131364010;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364010);
                if (textView2 != null) {
                    i = 2131364110;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                    if (textView3 != null) {
                        return new d0((LinearLayout) inflate, checkBox, textView, textView2, textView3, 7);
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public static boolean l(l4.n nVar, int i) {
        int i6;
        return i == -1 || (i6 = nVar.f) == -1 || i6 == i;
    }

    @Override // s1.b
    public Object a(Class cls) {
        if (!((Set) this.f81b).contains(s1.r.a(cls))) {
            s1.o.l(cls, "Attempting to request an undeclared dependency ", ".");
            return null;
        }
        Object a8 = ((s1.b) this.f85o).a(cls);
        if (!cls.equals(p2.b.class)) {
            return a8;
        }
        return new s1.s();
    }

    @Override // s1.b
    public s2.b b(s1.r rVar) {
        if (((Set) this.f82l).contains(rVar)) {
            return ((s1.b) this.f85o).b(rVar);
        }
        s1.o.l(rVar, "Attempting to request an undeclared dependency Provider<", ">.");
        return null;
    }

    @Override // s1.b
    public s2.b c(Class cls) {
        return b(s1.r.a(cls));
    }

    @Override // s1.b
    public Set d(s1.r rVar) {
        if (((Set) this.f84n).contains(rVar)) {
            return ((s1.b) this.f85o).d(rVar);
        }
        s1.o.l(rVar, "Attempting to request an undeclared dependency Set<", ">.");
        return null;
    }

    @Override // s1.b
    public Object e(s1.r rVar) {
        if (((Set) this.f81b).contains(rVar)) {
            return ((s1.b) this.f85o).e(rVar);
        }
        s1.o.l(rVar, "Attempting to request an undeclared dependency ", ".");
        return null;
    }

    @Override // s1.b
    public s1.p f(s1.r rVar) {
        if (((Set) this.f83m).contains(rVar)) {
            return ((s1.b) this.f85o).f(rVar);
        }
        s1.o.l(rVar, "Attempting to request an undeclared dependency Deferred<", ">.");
        return null;
    }

    @Override // m6.a
    public Object get() {
        switch (this.f80a) {
            case 1:
                return new c3.s0((n1.f) ((f0.i) this.f81b).f4811b, (t2.d) ((m6.a) this.f82l).get(), (f3.j) ((m6.a) this.f83m).get(), (c3.l) ((e3.c) this.f84n).get(), (t6.h) ((m6.a) this.f85o).get());
            case 2:
            default:
                return new w.a((Executor) ((m6.a) this.f81b).get(), (s.d) ((m6.a) this.f82l).get(), (t4.n0) ((t4.n0) this.f83m).get(), (y.d) ((m6.a) this.f84n).get(), (z.c) ((m6.a) this.f85o).get());
            case 3:
                return new f3.c((h1) ((m6.a) this.f81b).get(), (t2.d) ((m6.a) this.f82l).get(), (c3.b) ((m6.a) this.f83m).get(), (f3.d) ((m6.a) this.f84n).get(), (f3.n) ((e3.c) this.f85o).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f80a) {
        }
        return (RelativeLayout) this.f81b;
    }

    public g0 h() {
        long j;
        Context context = (Context) this.f81b;
        if (((f0.i) this.f82l) == null) {
            StringBuilder sb = t0.f177a;
            File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
            } catch (IllegalArgumentException unused) {
                j = 5242880;
            }
            long max = Math.max(Math.min(j, 52428800L), 5242880L);
            m8.w wVar = new m8.w();
            wVar.i = new m8.g(file, max);
            this.f82l = new f0.i(new m8.x(wVar), 1);
        }
        if (((a3.d) this.f84n) == null) {
            this.f84n = new a3.d(context);
        }
        if (((j0) this.f83m) == null) {
            this.f83m = new j0(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new s0());
        }
        if (((f0) this.f85o) == null) {
            this.f85o = f0.f91a;
        }
        o0 o0Var = new o0((a3.d) this.f84n);
        return new g0(context, new q(context, (j0) this.f83m, g0.j, (f0.i) this.f82l, (a3.d) this.f84n, o0Var), (a3.d) this.f84n, (f0) this.f85o, o0Var);
    }

    public s1.p j(Class cls) {
        return f(s1.r.a(cls));
    }

    public String m() {
        String str;
        synchronized (((ArrayDeque) this.f84n)) {
            str = (String) ((ArrayDeque) this.f84n).peek();
        }
        return str;
    }

    public boolean n(Object obj) {
        boolean remove;
        synchronized (((ArrayDeque) this.f84n)) {
            remove = ((ArrayDeque) this.f84n).remove(obj);
            if (remove) {
                ((ScheduledThreadPoolExecutor) this.f85o).execute(new a2.s(this, 18));
            }
        }
        return remove;
    }

    public void o(o.a aVar, o.g gVar) {
        r.r rVar = (r.r) this.f85o;
        r.j jVar = (r.j) this.f81b;
        String str = (String) this.f82l;
        o.e eVar = (o.e) this.f84n;
        if (eVar == null) {
            com.google.gson.internal.a.i("Null transformer");
            return;
        }
        o.c cVar = (o.c) this.f83m;
        w.a aVar2 = rVar.f8851c;
        r.j a8 = jVar.a(aVar.f8122b);
        r.h hVar = new r.h();
        hVar.f8823r = new HashMap();
        hVar.f8821p = Long.valueOf(rVar.f8849a.f());
        hVar.f8822q = Long.valueOf(rVar.f8850b.f());
        hVar.f8816b = str;
        hVar.f8820o = new r.m(cVar, (byte[]) eVar.apply(aVar.f8121a));
        hVar.f8818m = null;
        o.b bVar = aVar.f8123c;
        if (bVar != null) {
            hVar.f8819n = bVar.f8124a;
        }
        aVar2.f10906b.execute(new a2.r(aVar2, a8, gVar, hVar.b(), 3));
    }

    public Set p(Class cls) {
        return d(s1.r.a(cls));
    }

    public d0(InstallerActivity installerActivity) {
        this.f80a = 4;
        this.f82l = new ArrayList();
        this.f83m = new ArrayList();
        this.f84n = new ArrayList();
        this.f85o = new ArrayList();
    }

    public d0(e2.d dVar) {
        this.f80a = 2;
        this.f81b = (d6.f) dVar.f4466b;
        this.f82l = (e1.c0) dVar.f4468m;
        this.f83m = (q2.e) dVar.f4469n;
        this.f84n = (e1.c0) dVar.f4470o;
        this.f85o = (a3.d) dVar.f4472q;
    }

    public /* synthetic */ d0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.f80a = i;
        this.f81b = obj;
        this.f82l = obj2;
        this.f83m = obj3;
        this.f84n = obj4;
        this.f85o = obj5;
    }

    public d0(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f80a = 13;
        this.f84n = new ArrayDeque();
        this.f81b = sharedPreferences;
        this.f82l = "topic_operation_queue";
        this.f83m = ",";
        this.f85o = scheduledThreadPoolExecutor;
    }

    public d0(Context context) {
        this.f80a = 0;
        if (context != null) {
            this.f81b = context.getApplicationContext();
        } else {
            com.google.gson.internal.a.p("Context must not be null.");
            throw null;
        }
    }
}
