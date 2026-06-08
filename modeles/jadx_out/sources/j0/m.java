package j0;

import a4.c0;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import c4.f5;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements i0.e, i0.f {
    public final i0.b j;

    /* renamed from: k, reason: collision with root package name */
    public final a f6507k;

    /* renamed from: l, reason: collision with root package name */
    public final android.support.v4.media.g f6508l;

    /* renamed from: o, reason: collision with root package name */
    public final int f6511o;

    /* renamed from: p, reason: collision with root package name */
    public final t f6512p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6513q;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ e f6516t;
    public final LinkedList i = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f6509m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    public final HashMap f6510n = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f6514r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public h0.b f6515s = null;

    /* JADX WARN: Multi-variable type inference failed */
    public m(e eVar, i0.d dVar) {
        this.f6516t = eVar;
        Looper looper = eVar.v.getLooper();
        b5.m a8 = dVar.a();
        g4.v vVar = new g4.v((String) a8.f1062l, (ArraySet) a8.f1061b, (String) a8.f1063m);
        d0.b bVar = (d0.b) dVar.f5616c.f247b;
        y.g(bVar);
        i0.b r9 = bVar.r(dVar.f5614a, looper, vVar, dVar.f5617d, this, this);
        String str = dVar.f5615b;
        if (str != null && (r9 instanceof k0.e)) {
            ((k0.e) r9).B = str;
        }
        if (str != null && (r9 instanceof h)) {
            androidx.lifecycle.l.C(r9);
            throw null;
        }
        this.j = r9;
        this.f6507k = dVar.f5618e;
        this.f6508l = new android.support.v4.media.g(18);
        this.f6511o = dVar.g;
        if (!r9.l()) {
            this.f6512p = null;
            return;
        }
        Context context = eVar.f6494n;
        c0 c0Var = eVar.v;
        b5.m a10 = dVar.a();
        this.f6512p = new t(context, c0Var, new g4.v((String) a10.f1062l, (ArraySet) a10.f1061b, (String) a10.f1063m));
    }

    @Override // i0.f
    public final void a(h0.b bVar) {
        o(bVar, null);
    }

    public final void b(h0.b bVar) {
        HashSet hashSet = this.f6509m;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() != null) {
            com.google.gson.internal.a.o();
        } else {
            if (y.j(bVar, h0.b.f5393o)) {
                this.j.e();
            }
            throw null;
        }
    }

    @Override // i0.e
    public final void c(int i) {
        Looper myLooper = Looper.myLooper();
        c0 c0Var = this.f6516t.v;
        if (myLooper == c0Var.getLooper()) {
            i(i);
        } else {
            c0Var.post(new f5(this, i, 3));
        }
    }

    @Override // i0.e
    public final void d() {
        Looper myLooper = Looper.myLooper();
        c0 c0Var = this.f6516t.v;
        if (myLooper == c0Var.getLooper()) {
            h();
        } else {
            c0Var.post(new a4.f(this, 15));
        }
    }

    public final void e(Status status) {
        y.c(this.f6516t.v);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z9) {
        y.c(this.f6516t.v);
        if ((status == null) == (exc == null)) {
            com.google.gson.internal.a.p("Status XOR exception should be null");
            return;
        }
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            x xVar = (x) it.next();
            if (!z9 || xVar.f6538a == 2) {
                if (status != null) {
                    xVar.a(status);
                } else {
                    xVar.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.i;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            x xVar = (x) arrayList.get(i);
            if (!this.j.g()) {
                return;
            }
            if (k(xVar)) {
                linkedList.remove(xVar);
            }
        }
    }

    public final void h() {
        e eVar = this.f6516t;
        y.c(eVar.v);
        this.f6515s = null;
        b(h0.b.f5393o);
        c0 c0Var = eVar.v;
        if (this.f6513q) {
            a aVar = this.f6507k;
            c0Var.removeMessages(11, aVar);
            c0Var.removeMessages(9, aVar);
            this.f6513q = false;
        }
        Iterator it = this.f6510n.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.o();
        } else {
            g();
            j();
        }
    }

    public final void i(int i) {
        e eVar = this.f6516t;
        c0 c0Var = eVar.v;
        y.c(eVar.v);
        this.f6515s = null;
        this.f6513q = true;
        String k5 = this.j.k();
        android.support.v4.media.g gVar = this.f6508l;
        gVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (k5 != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(k5);
        }
        gVar.I(true, new Status(20, sb.toString(), null, null));
        a aVar = this.f6507k;
        c0Var.sendMessageDelayed(Message.obtain(c0Var, 9, aVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        c0Var.sendMessageDelayed(Message.obtain(c0Var, 11, aVar), 120000L);
        ((SparseIntArray) eVar.f6496p.f247b).clear();
        Iterator it = this.f6510n.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.o();
        }
    }

    public final void j() {
        e eVar = this.f6516t;
        c0 c0Var = eVar.v;
        a aVar = this.f6507k;
        c0Var.removeMessages(12, aVar);
        c0Var.sendMessageDelayed(c0Var.obtainMessage(12, aVar), eVar.f6490a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(x xVar) {
        h0.d dVar;
        if (!(xVar instanceof q)) {
            android.support.v4.media.g gVar = this.f6508l;
            i0.b bVar = this.j;
            xVar.d(gVar, bVar.l());
            try {
                xVar.c(this);
                return true;
            } catch (DeadObjectException unused) {
                c(1);
                bVar.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        q qVar = (q) xVar;
        h0.d[] g = qVar.g(this);
        if (g != null && g.length != 0) {
            h0.d[] j = this.j.j();
            if (j == null) {
                j = new h0.d[0];
            }
            ArrayMap arrayMap = new ArrayMap(j.length);
            for (h0.d dVar2 : j) {
                arrayMap.put(dVar2.f5402a, Long.valueOf(dVar2.c()));
            }
            int length = g.length;
            for (int i = 0; i < length; i++) {
                dVar = g[i];
                Long l10 = (Long) arrayMap.get(dVar.f5402a);
                if (l10 == null || l10.longValue() < dVar.c()) {
                    break;
                }
            }
        }
        dVar = null;
        if (dVar == null) {
            android.support.v4.media.g gVar2 = this.f6508l;
            i0.b bVar2 = this.j;
            xVar.d(gVar2, bVar2.l());
            try {
                xVar.c(this);
                return true;
            } catch (DeadObjectException unused2) {
                c(1);
                bVar2.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.j.getClass().getName() + " could not execute call because it requires feature (" + dVar.f5402a + ", " + dVar.c() + ").");
        if (!this.f6516t.f6502w || !qVar.f(this)) {
            qVar.b(new i0.j(dVar));
            return true;
        }
        n nVar = new n(this.f6507k, dVar);
        int indexOf = this.f6514r.indexOf(nVar);
        ArrayList arrayList = this.f6514r;
        if (indexOf >= 0) {
            n nVar2 = (n) arrayList.get(indexOf);
            this.f6516t.v.removeMessages(15, nVar2);
            c0 c0Var = this.f6516t.v;
            c0Var.sendMessageDelayed(Message.obtain(c0Var, 15, nVar2), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            return false;
        }
        arrayList.add(nVar);
        c0 c0Var2 = this.f6516t.v;
        c0Var2.sendMessageDelayed(Message.obtain(c0Var2, 15, nVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        c0 c0Var3 = this.f6516t.v;
        c0Var3.sendMessageDelayed(Message.obtain(c0Var3, 16, nVar), 120000L);
        h0.b bVar3 = new h0.b(null, null, 2);
        if (!l(bVar3)) {
            this.f6516t.a(bVar3, this.f6511o);
        }
        return false;
    }

    public final boolean l(h0.b bVar) {
        synchronized (e.f6489z) {
        }
        return false;
    }

    public final void m() {
        e eVar = this.f6516t;
        y.c(eVar.v);
        i0.b bVar = this.j;
        if (bVar.g() || bVar.d()) {
            return;
        }
        try {
            android.support.v4.media.g gVar = eVar.f6496p;
            Context context = eVar.f6494n;
            SparseIntArray sparseIntArray = (SparseIntArray) gVar.f247b;
            y.g(context);
            int i = bVar.i();
            int i6 = ((SparseIntArray) gVar.f247b).get(i, -1);
            if (i6 == -1) {
                i6 = 0;
                int i10 = 0;
                while (true) {
                    if (i10 >= sparseIntArray.size()) {
                        i6 = -1;
                        break;
                    }
                    int keyAt = sparseIntArray.keyAt(i10);
                    if (keyAt > i && sparseIntArray.get(keyAt) == 0) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i6 == -1) {
                    i6 = ((h0.e) gVar.f248l).b(context, i);
                }
                sparseIntArray.put(i, i6);
            }
            if (i6 != 0) {
                h0.b bVar2 = new h0.b(null, null, i6);
                Log.w("GoogleApiManager", "The service for " + bVar.getClass().getName() + " is not available: " + bVar2.toString());
                o(bVar2, null);
                return;
            }
            g8.g gVar2 = new g8.g();
            gVar2.f5386o = eVar;
            gVar2.f5384m = null;
            gVar2.f5385n = null;
            gVar2.f5381a = false;
            gVar2.f5382b = bVar;
            gVar2.f5383l = this.f6507k;
            if (bVar.l()) {
                t tVar = this.f6512p;
                y.g(tVar);
                Handler handler = tVar.f6527k;
                g4.v vVar = tVar.f6530n;
                h1.a aVar = tVar.f6531o;
                if (aVar != null) {
                    aVar.o();
                }
                vVar.f5280p = Integer.valueOf(System.identityHashCode(tVar));
                tVar.f6531o = (h1.a) tVar.f6528l.r(tVar.j, handler.getLooper(), vVar, (g1.a) vVar.f5279o, tVar, tVar);
                tVar.f6532p = gVar2;
                Set set = tVar.f6529m;
                if (set == null || set.isEmpty()) {
                    handler.post(new a4.f(tVar, 17));
                } else {
                    h1.a aVar2 = tVar.f6531o;
                    aVar2.getClass();
                    aVar2.c(new k0.l((k0.e) aVar2));
                }
            }
            try {
                bVar.c(gVar2);
            } catch (SecurityException e10) {
                o(new h0.b(null, null, 10), e10);
            }
        } catch (IllegalStateException e11) {
            o(new h0.b(null, null, 10), e11);
        }
    }

    public final void n(x xVar) {
        y.c(this.f6516t.v);
        boolean g = this.j.g();
        LinkedList linkedList = this.i;
        if (g) {
            if (k(xVar)) {
                j();
                return;
            } else {
                linkedList.add(xVar);
                return;
            }
        }
        linkedList.add(xVar);
        h0.b bVar = this.f6515s;
        if (bVar == null || bVar.f5395b == 0 || bVar.f5396l == null) {
            m();
        } else {
            o(bVar, null);
        }
    }

    public final void o(h0.b bVar, RuntimeException runtimeException) {
        h1.a aVar;
        y.c(this.f6516t.v);
        t tVar = this.f6512p;
        if (tVar != null && (aVar = tVar.f6531o) != null) {
            aVar.o();
        }
        y.c(this.f6516t.v);
        this.f6515s = null;
        ((SparseIntArray) this.f6516t.f6496p.f247b).clear();
        b(bVar);
        if ((this.j instanceof m0.c) && bVar.f5395b != 24) {
            e eVar = this.f6516t;
            eVar.f6491b = true;
            c0 c0Var = eVar.v;
            c0Var.sendMessageDelayed(c0Var.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (bVar.f5395b == 4) {
            e(e.f6488y);
            return;
        }
        if (this.i.isEmpty()) {
            this.f6515s = bVar;
            return;
        }
        e eVar2 = this.f6516t;
        if (runtimeException != null) {
            y.c(eVar2.v);
            f(null, runtimeException, false);
            return;
        }
        boolean z9 = eVar2.f6502w;
        a aVar2 = this.f6507k;
        if (!z9) {
            e(e.b(aVar2, bVar));
            return;
        }
        f(e.b(aVar2, bVar), null, true);
        if (this.i.isEmpty() || l(bVar) || this.f6516t.a(bVar, this.f6511o)) {
            return;
        }
        if (bVar.f5395b == 18) {
            this.f6513q = true;
        }
        if (!this.f6513q) {
            e(e.b(this.f6507k, bVar));
            return;
        }
        e eVar3 = this.f6516t;
        a aVar3 = this.f6507k;
        c0 c0Var2 = eVar3.v;
        c0Var2.sendMessageDelayed(Message.obtain(c0Var2, 9, aVar3), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    public final void p(h0.b bVar) {
        y.c(this.f6516t.v);
        i0.b bVar2 = this.j;
        bVar2.b("onSignInFailed for " + bVar2.getClass().getName() + " with " + String.valueOf(bVar));
        o(bVar, null);
    }

    public final void q() {
        y.c(this.f6516t.v);
        Status status = e.f6487x;
        e(status);
        this.f6508l.I(false, status);
        for (g gVar : (g[]) this.f6510n.keySet().toArray(new g[0])) {
            n(new w(new j1.i()));
        }
        b(new h0.b(null, null, 4));
        i0.b bVar = this.j;
        if (bVar.g()) {
            bVar.f(new g5.f(this, 2));
        }
    }
}
