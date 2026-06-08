package a4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements Runnable {
    public static final Object B = new Object();
    public static final d C = new d(0);
    public static final AtomicInteger D = new AtomicInteger();
    public static final e E = new e();
    public int A;

    /* renamed from: a, reason: collision with root package name */
    public final int f100a = D.incrementAndGet();

    /* renamed from: b, reason: collision with root package name */
    public final g0 f101b;

    /* renamed from: l, reason: collision with root package name */
    public final q f102l;

    /* renamed from: m, reason: collision with root package name */
    public final a3.d f103m;

    /* renamed from: n, reason: collision with root package name */
    public final o0 f104n;

    /* renamed from: o, reason: collision with root package name */
    public final String f105o;

    /* renamed from: p, reason: collision with root package name */
    public final k0 f106p;

    /* renamed from: q, reason: collision with root package name */
    public int f107q;

    /* renamed from: r, reason: collision with root package name */
    public final n0 f108r;

    /* renamed from: s, reason: collision with root package name */
    public b f109s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f110t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f111u;
    public Future v;

    /* renamed from: w, reason: collision with root package name */
    public int f112w;

    /* renamed from: x, reason: collision with root package name */
    public Exception f113x;

    /* renamed from: y, reason: collision with root package name */
    public int f114y;

    /* renamed from: z, reason: collision with root package name */
    public int f115z;

    public h(g0 g0Var, q qVar, a3.d dVar, o0 o0Var, b bVar, n0 n0Var) {
        this.f101b = g0Var;
        this.f102l = qVar;
        this.f103m = dVar;
        this.f104n = o0Var;
        this.f109s = bVar;
        this.f105o = bVar.f71d;
        k0 k0Var = bVar.f69b;
        this.f106p = k0Var;
        this.A = k0Var.h;
        this.f107q = 0;
        this.f108r = n0Var;
        this.f115z = n0Var.d();
    }

    public static Bitmap a(List list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            q0 q0Var = (q0) list.get(i);
            try {
                Bitmap a8 = q0Var.a(bitmap);
                if (a8 == null) {
                    StringBuilder t9 = x.t("Transformation ");
                    t9.append(q0Var.b());
                    t9.append(" returned null after ");
                    t9.append(i);
                    t9.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        t9.append(((q0) it.next()).b());
                        t9.append('\n');
                    }
                    g0.j.post(new f(t9, 0));
                    return null;
                }
                if (a8 == bitmap && bitmap.isRecycled()) {
                    g0.j.post(new g(q0Var, 0));
                    return null;
                }
                if (a8 != bitmap && !bitmap.isRecycled()) {
                    g0.j.post(new g(q0Var, 1));
                    return null;
                }
                i++;
                bitmap = a8;
            } catch (RuntimeException e10) {
                g0.j.post(new m1.a(1, q0Var, e10));
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap c(w8.g0 g0Var, k0 k0Var) {
        g0Var.getClass();
        w8.a0 a0Var = new w8.a0(g0Var);
        boolean z9 = a0Var.d(0L, t0.f178b) && a0Var.d(8L, t0.f179c);
        k0Var.getClass();
        int i = k0Var.f130e;
        int i6 = k0Var.f129d;
        BitmapFactory.Options c9 = n0.c(k0Var);
        boolean z10 = c9 != null && c9.inJustDecodeBounds;
        if (z9) {
            w8.h hVar = a0Var.f10934b;
            hVar.z(g0Var);
            byte[] i10 = hVar.i(hVar.f10961b);
            if (z10) {
                BitmapFactory.decodeByteArray(i10, 0, i10.length, c9);
                n0.a(i6, i, c9.outWidth, c9.outHeight, c9, k0Var);
            }
            return BitmapFactory.decodeByteArray(i10, 0, i10.length, c9);
        }
        w8.f fVar = new w8.f(a0Var, 1);
        if (z10) {
            w wVar = new w(fVar);
            wVar.f187o = false;
            long j = wVar.f183b + 1024;
            if (wVar.f185m < j) {
                wVar.c(j);
            }
            long j6 = wVar.f183b;
            BitmapFactory.decodeStream(wVar, null, c9);
            n0.a(i6, i, c9.outWidth, c9.outHeight, c9, k0Var);
            wVar.b(j6);
            wVar.f187o = true;
            fVar = wVar;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(fVar, null, c9);
        if (decodeStream != null) {
            return decodeStream;
        }
        com.google.gson.internal.a.n("Failed to decode stream.");
        return null;
    }

    public static h e(g0 g0Var, q qVar, a3.d dVar, o0 o0Var, b bVar) {
        k0 k0Var = bVar.f69b;
        List list = g0Var.f96b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            n0 n0Var = (n0) list.get(i);
            if (n0Var.b(k0Var)) {
                return new h(g0Var, qVar, dVar, o0Var, bVar, n0Var);
            }
        }
        return new h(g0Var, qVar, dVar, o0Var, bVar, E);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap g(a4.k0 r17, android.graphics.Bitmap r18, int r19) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.h.g(a4.k0, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void h(k0 k0Var) {
        Uri uri = (Uri) k0Var.f127b;
        String valueOf = uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(k0Var.f128c);
        StringBuilder sb = (StringBuilder) C.get();
        sb.ensureCapacity(valueOf.length() + 8);
        sb.replace(8, sb.length(), valueOf);
        Thread.currentThread().setName(sb.toString());
    }

    public final boolean b() {
        ArrayList arrayList;
        Future future;
        return this.f109s == null && ((arrayList = this.f110t) == null || arrayList.isEmpty()) && (future = this.v) != null && future.cancel(false);
    }

    public final void d(b bVar) {
        boolean remove;
        if (this.f109s == bVar) {
            this.f109s = null;
            remove = true;
        } else {
            ArrayList arrayList = this.f110t;
            remove = arrayList != null ? arrayList.remove(bVar) : false;
        }
        if (remove && bVar.f69b.h == this.A) {
            ArrayList arrayList2 = this.f110t;
            boolean z9 = (arrayList2 == null || arrayList2.isEmpty()) ? false : true;
            b bVar2 = this.f109s;
            if (bVar2 != null || z9) {
                r1 = bVar2 != null ? bVar2.f69b.h : 1;
                if (z9) {
                    int size = this.f110t.size();
                    for (int i = 0; i < size; i++) {
                        int i6 = ((b) this.f110t.get(i)).f69b.h;
                        if (c.j.c(i6) > c.j.c(r1)) {
                            r1 = i6;
                        }
                    }
                }
            }
            this.A = r1;
        }
        this.f101b.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b6 A[Catch: all -> 0x009b, TryCatch #3 {all -> 0x009b, blocks: (B:43:0x008e, B:45:0x0096, B:48:0x00aa, B:52:0x00b6, B:53:0x00bf, B:62:0x009d), top: B:42:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap f() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.h.f():android.graphics.Bitmap");
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.f102l;
        try {
            try {
                try {
                    h(this.f106p);
                    this.f101b.getClass();
                    Bitmap f = f();
                    this.f111u = f;
                    if (f == null) {
                        n nVar = qVar.h;
                        nVar.sendMessage(nVar.obtainMessage(6, this));
                    } else {
                        qVar.b(this);
                    }
                } catch (a0 e10) {
                    this.f113x = e10;
                    n nVar2 = qVar.h;
                    nVar2.sendMessage(nVar2.obtainMessage(6, this));
                } catch (Exception e11) {
                    this.f113x = e11;
                    n nVar3 = qVar.h;
                    nVar3.sendMessage(nVar3.obtainMessage(6, this));
                }
            } catch (IOException e12) {
                this.f113x = e12;
                n nVar4 = qVar.h;
                nVar4.sendMessageDelayed(nVar4.obtainMessage(5, this), 500L);
            } catch (OutOfMemoryError e13) {
                StringWriter stringWriter = new StringWriter();
                this.f104n.a().a(new PrintWriter(stringWriter));
                this.f113x = new RuntimeException(stringWriter.toString(), e13);
                n nVar5 = qVar.h;
                nVar5.sendMessage(nVar5.obtainMessage(6, this));
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }
}
