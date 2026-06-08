package o8;

import a2.t;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.l;
import com.google.android.gms.internal.measurement.i5;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import u8.h;
import w8.a0;
import w8.i0;
import w8.x;
import w8.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements Closeable, Flushable {
    public static final Pattern D = Pattern.compile("[a-z0-9_-]{1,120}");
    public final ThreadPoolExecutor B;

    /* renamed from: b, reason: collision with root package name */
    public final File f8356b;

    /* renamed from: l, reason: collision with root package name */
    public final File f8357l;

    /* renamed from: m, reason: collision with root package name */
    public final File f8358m;

    /* renamed from: n, reason: collision with root package name */
    public final File f8359n;

    /* renamed from: p, reason: collision with root package name */
    public final long f8361p;

    /* renamed from: s, reason: collision with root package name */
    public z f8364s;

    /* renamed from: u, reason: collision with root package name */
    public int f8366u;
    public boolean v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8367w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8368x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8369y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8370z;

    /* renamed from: r, reason: collision with root package name */
    public long f8363r = 0;

    /* renamed from: t, reason: collision with root package name */
    public final LinkedHashMap f8365t = new LinkedHashMap(0, 0.75f, true);
    public long A = 0;
    public final a4.f C = new a4.f(this, 22);

    /* renamed from: a, reason: collision with root package name */
    public final t8.a f8355a = t8.a.f10368a;

    /* renamed from: o, reason: collision with root package name */
    public final int f8360o = 201105;

    /* renamed from: q, reason: collision with root package name */
    public final int f8362q = 2;

    public f(File file, long j, ThreadPoolExecutor threadPoolExecutor) {
        this.f8356b = file;
        this.f8357l = new File(file, "journal");
        this.f8358m = new File(file, "journal.tmp");
        this.f8359n = new File(file, "journal.bkp");
        this.f8361p = j;
        this.B = threadPoolExecutor;
    }

    public static void z(String str) {
        if (D.matcher(str).matches()) {
            return;
        }
        com.google.gson.internal.a.p(l.w("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
    }

    public final synchronized void b() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void c(t tVar, boolean z9) {
        d dVar = (d) tVar.f53b;
        if (dVar.f != tVar) {
            throw new IllegalStateException();
        }
        if (z9 && !dVar.f8350e) {
            for (int i = 0; i < this.f8362q; i++) {
                if (!((boolean[]) tVar.f54c)[i]) {
                    tVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                t8.a aVar = this.f8355a;
                File file = dVar.f8349d[i];
                aVar.getClass();
                if (!file.exists()) {
                    tVar.a();
                    return;
                }
            }
        }
        for (int i6 = 0; i6 < this.f8362q; i6++) {
            File file2 = dVar.f8349d[i6];
            t8.a aVar2 = this.f8355a;
            if (z9) {
                aVar2.getClass();
                if (file2.exists()) {
                    File file3 = dVar.f8348c[i6];
                    this.f8355a.c(file2, file3);
                    long j = dVar.f8347b[i6];
                    this.f8355a.getClass();
                    long length = file3.length();
                    dVar.f8347b[i6] = length;
                    this.f8363r = (this.f8363r - j) + length;
                }
            } else {
                aVar2.a(file2);
            }
        }
        this.f8366u++;
        dVar.f = null;
        if (dVar.f8350e || z9) {
            dVar.f8350e = true;
            z zVar = this.f8364s;
            zVar.m("CLEAN");
            zVar.writeByte(32);
            this.f8364s.m(dVar.f8346a);
            z zVar2 = this.f8364s;
            for (long j6 : dVar.f8347b) {
                zVar2.writeByte(32);
                zVar2.c(j6);
            }
            this.f8364s.writeByte(10);
            if (z9) {
                long j10 = this.A;
                this.A = 1 + j10;
                dVar.g = j10;
            }
        } else {
            this.f8365t.remove(dVar.f8346a);
            z zVar3 = this.f8364s;
            zVar3.m("REMOVE");
            zVar3.writeByte(32);
            this.f8364s.m(dVar.f8346a);
            this.f8364s.writeByte(10);
        }
        this.f8364s.flush();
        if (this.f8363r > this.f8361p || h()) {
            this.B.execute(this.C);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f8367w && !this.f8368x) {
                for (d dVar : (d[]) this.f8365t.values().toArray(new d[this.f8365t.size()])) {
                    t tVar = dVar.f;
                    if (tVar != null) {
                        tVar.a();
                    }
                }
                y();
                this.f8364s.close();
                this.f8364s = null;
                this.f8368x = true;
                return;
            }
            this.f8368x = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized t d(long j, String str) {
        f();
        b();
        z(str);
        d dVar = (d) this.f8365t.get(str);
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar != null && dVar.f != null) {
            return null;
        }
        if (!this.f8369y && !this.f8370z) {
            z zVar = this.f8364s;
            zVar.m("DIRTY");
            zVar.writeByte(32);
            zVar.m(str);
            zVar.writeByte(10);
            this.f8364s.flush();
            if (this.v) {
                return null;
            }
            if (dVar == null) {
                dVar = new d(this, str);
                this.f8365t.put(str, dVar);
            }
            t tVar = new t(this, dVar);
            dVar.f = tVar;
            return tVar;
        }
        this.B.execute(this.C);
        return null;
    }

    public final synchronized e e(String str) {
        f();
        b();
        z(str);
        d dVar = (d) this.f8365t.get(str);
        if (dVar != null && dVar.f8350e) {
            e a8 = dVar.a();
            if (a8 == null) {
                return null;
            }
            this.f8366u++;
            z zVar = this.f8364s;
            zVar.m("READ");
            zVar.writeByte(32);
            zVar.m(str);
            zVar.writeByte(10);
            if (h()) {
                this.B.execute(this.C);
            }
            return a8;
        }
        return null;
    }

    public final synchronized void f() {
        try {
            if (this.f8367w) {
                return;
            }
            t8.a aVar = this.f8355a;
            File file = this.f8359n;
            aVar.getClass();
            if (file.exists()) {
                t8.a aVar2 = this.f8355a;
                File file2 = this.f8357l;
                aVar2.getClass();
                boolean exists = file2.exists();
                t8.a aVar3 = this.f8355a;
                File file3 = this.f8359n;
                if (exists) {
                    aVar3.a(file3);
                } else {
                    aVar3.c(file3, this.f8357l);
                }
            }
            t8.a aVar4 = this.f8355a;
            File file4 = this.f8357l;
            aVar4.getClass();
            if (file4.exists()) {
                try {
                    n();
                    j();
                    this.f8367w = true;
                    return;
                } catch (IOException e10) {
                    h.f10783a.k(5, "DiskLruCache " + this.f8356b + " is corrupt: " + e10.getMessage() + ", removing", e10);
                    try {
                        close();
                        this.f8355a.b(this.f8356b);
                        this.f8368x = false;
                    } catch (Throwable th) {
                        this.f8368x = false;
                        throw th;
                    }
                }
            }
            s();
            this.f8367w = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.f8367w) {
            b();
            y();
            this.f8364s.flush();
        }
    }

    public final boolean h() {
        int i = this.f8366u;
        return i >= 2000 && i >= this.f8365t.size();
    }

    public final z i() {
        w8.b bVar;
        File file = this.f8357l;
        this.f8355a.getClass();
        int i = 1;
        try {
            Logger logger = x.f11003a;
            file.getClass();
            bVar = new w8.b(i, new FileOutputStream(file, true), new i0());
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            Logger logger2 = x.f11003a;
            bVar = new w8.b(i, new FileOutputStream(file, true), new i0());
        }
        return new z(new c(this, bVar, 0));
    }

    public final synchronized boolean isClosed() {
        return this.f8368x;
    }

    public final void j() {
        File file = this.f8358m;
        t8.a aVar = this.f8355a;
        aVar.a(file);
        Iterator it = this.f8365t.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            t tVar = dVar.f;
            int i = this.f8362q;
            int i6 = 0;
            if (tVar == null) {
                while (i6 < i) {
                    this.f8363r += dVar.f8347b[i6];
                    i6++;
                }
            } else {
                dVar.f = null;
                while (i6 < i) {
                    aVar.a(dVar.f8348c[i6]);
                    aVar.a(dVar.f8349d[i6]);
                    i6++;
                }
                it.remove();
            }
        }
    }

    public final void n() {
        this.f8355a.getClass();
        a0 a0Var = new a0(i5.L(this.f8357l));
        try {
            String k5 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            String k10 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            String k11 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            String k12 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            String k13 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            if (!"libcore.io.DiskLruCache".equals(k5) || !"1".equals(k10) || !Integer.toString(this.f8360o).equals(k11) || !Integer.toString(this.f8362q).equals(k12) || !"".equals(k13)) {
                throw new IOException("unexpected journal header: [" + k5 + ", " + k10 + ", " + k12 + ", " + k13 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    r(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL));
                    i++;
                } catch (EOFException unused) {
                    this.f8366u = i - this.f8365t.size();
                    if (a0Var.b()) {
                        this.f8364s = i();
                    } else {
                        s();
                    }
                    n8.c.c(a0Var);
                    return;
                }
            }
        } catch (Throwable th) {
            n8.c.c(a0Var);
            throw th;
        }
    }

    public final void r(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            com.google.gson.internal.a.n("unexpected journal line: ".concat(str));
            return;
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.f8365t;
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        d dVar = (d) linkedHashMap.get(substring);
        if (dVar == null) {
            dVar = new d(this, substring);
            linkedHashMap.put(substring, dVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f = new t(this, dVar);
                return;
            } else {
                if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                }
                com.google.gson.internal.a.n("unexpected journal line: ".concat(str));
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        dVar.f8350e = true;
        dVar.f = null;
        if (split.length != dVar.h.f8362q) {
            androidx.core.content.pm.a.k(Arrays.toString(split), "unexpected journal line: ");
            return;
        }
        for (int i6 = 0; i6 < split.length; i6++) {
            try {
                dVar.f8347b[i6] = Long.parseLong(split[i6]);
            } catch (NumberFormatException unused) {
                androidx.core.content.pm.a.k(Arrays.toString(split), "unexpected journal line: ");
                return;
            }
        }
    }

    public final synchronized void s() {
        w8.b bVar;
        try {
            z zVar = this.f8364s;
            if (zVar != null) {
                zVar.close();
            }
            t8.a aVar = this.f8355a;
            File file = this.f8358m;
            aVar.getClass();
            int i = 1;
            try {
                Logger logger = x.f11003a;
                file.getClass();
                bVar = new w8.b(i, new FileOutputStream(file, false), new i0());
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                Logger logger2 = x.f11003a;
                bVar = new w8.b(i, new FileOutputStream(file, false), new i0());
            }
            z zVar2 = new z(bVar);
            try {
                zVar2.m("libcore.io.DiskLruCache");
                zVar2.writeByte(10);
                zVar2.m("1");
                zVar2.writeByte(10);
                zVar2.c(this.f8360o);
                zVar2.writeByte(10);
                zVar2.c(this.f8362q);
                zVar2.writeByte(10);
                zVar2.writeByte(10);
                for (d dVar : this.f8365t.values()) {
                    if (dVar.f != null) {
                        zVar2.m("DIRTY");
                        zVar2.writeByte(32);
                        zVar2.m(dVar.f8346a);
                        zVar2.writeByte(10);
                    } else {
                        zVar2.m("CLEAN");
                        zVar2.writeByte(32);
                        zVar2.m(dVar.f8346a);
                        for (long j : dVar.f8347b) {
                            zVar2.writeByte(32);
                            zVar2.c(j);
                        }
                        zVar2.writeByte(10);
                    }
                }
                zVar2.close();
                t8.a aVar2 = this.f8355a;
                File file2 = this.f8357l;
                aVar2.getClass();
                if (file2.exists()) {
                    this.f8355a.c(this.f8357l, this.f8359n);
                }
                this.f8355a.c(this.f8358m, this.f8357l);
                this.f8355a.a(this.f8359n);
                this.f8364s = i();
                this.v = false;
                this.f8370z = false;
            } catch (Throwable th) {
                zVar2.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void u(d dVar) {
        t tVar = dVar.f;
        String str = dVar.f8346a;
        if (tVar != null) {
            tVar.e();
        }
        for (int i = 0; i < this.f8362q; i++) {
            this.f8355a.a(dVar.f8348c[i]);
            long j = this.f8363r;
            long[] jArr = dVar.f8347b;
            this.f8363r = j - jArr[i];
            jArr[i] = 0;
        }
        this.f8366u++;
        z zVar = this.f8364s;
        zVar.m("REMOVE");
        zVar.writeByte(32);
        zVar.m(str);
        zVar.writeByte(10);
        this.f8365t.remove(str);
        if (h()) {
            this.B.execute(this.C);
        }
    }

    public final void y() {
        while (this.f8363r > this.f8361p) {
            u((d) this.f8365t.values().iterator().next());
        }
        this.f8369y = false;
    }
}
