package s8;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements Closeable {

    /* renamed from: n, reason: collision with root package name */
    public static final Logger f9449n = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final w8.j f9450a;

    /* renamed from: b, reason: collision with root package name */
    public final r f9451b;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9452l;

    /* renamed from: m, reason: collision with root package name */
    public final c f9453m;

    public s(w8.a0 a0Var, boolean z9) {
        this.f9450a = a0Var;
        this.f9452l = z9;
        r rVar = new r(a0Var);
        this.f9451b = rVar;
        this.f9453m = new c(rVar);
    }

    public static int b(int i, byte b7, short s6) {
        if ((b7 & 8) != 0) {
            i--;
        }
        if (s6 <= i) {
            return (short) (i - s6);
        }
        e.c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s6), Integer.valueOf(i));
        throw null;
    }

    public static int j(w8.j jVar) {
        return (jVar.readByte() & 255) | ((jVar.readByte() & 255) << 16) | ((jVar.readByte() & 255) << 8);
    }

    public final boolean c(boolean z9, o oVar) {
        int i;
        try {
            this.f9450a.t(9L);
            int j = j(this.f9450a);
            if (j < 0 || j > 16384) {
                e.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(j));
                throw null;
            }
            byte readByte = (byte) (this.f9450a.readByte() & 255);
            if (z9 && readByte != 4) {
                e.c("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f9450a.readByte() & 255);
            int readInt = this.f9450a.readInt();
            int i6 = Integer.MAX_VALUE & readInt;
            Logger logger = f9449n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, i6, j, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    e(oVar, j, readByte2, i6);
                    return true;
                case 1:
                    i(oVar, j, readByte2, i6);
                    return true;
                case 2:
                    if (j != 5) {
                        e.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(j));
                        throw null;
                    }
                    if (i6 == 0) {
                        e.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    w8.j jVar = this.f9450a;
                    jVar.readInt();
                    jVar.readByte();
                    return true;
                case 3:
                    if (j != 4) {
                        e.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(j));
                        throw null;
                    }
                    if (i6 == 0) {
                        e.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int readInt2 = this.f9450a.readInt();
                    int[] e10 = c.j.e(11);
                    int length = e10.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            i = e10[i10];
                            if (k0.k.c(i) != readInt2) {
                                i10++;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        e.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
                        throw null;
                    }
                    q qVar = (q) oVar.f9424l;
                    if (i6 != 0 && (readInt & 1) == 0) {
                        qVar.f9435r.execute(new j(qVar, new Object[]{qVar.f9430m, Integer.valueOf(i6)}, i6, i));
                        return true;
                    }
                    w f = qVar.f(i6);
                    if (f != null) {
                        f.j(i);
                    }
                    return true;
                case 4:
                    s(oVar, j, readByte2, i6);
                    return true;
                case 5:
                    r(oVar, j, readByte2, i6);
                    return true;
                case 6:
                    n(oVar, j, readByte2, i6);
                    return true;
                case 7:
                    f(oVar, j, i6);
                    return true;
                case 8:
                    if (j != 4) {
                        e.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(j));
                        throw null;
                    }
                    long readInt3 = this.f9450a.readInt() & 2147483647L;
                    if (readInt3 == 0) {
                        e.c("windowSizeIncrement was 0", Long.valueOf(readInt3));
                        throw null;
                    }
                    q qVar2 = (q) oVar.f9424l;
                    if (i6 == 0) {
                        synchronized (qVar2) {
                            q qVar3 = (q) oVar.f9424l;
                            qVar3.v += readInt3;
                            qVar3.notifyAll();
                        }
                        return true;
                    }
                    w d10 = qVar2.d(i6);
                    if (d10 != null) {
                        synchronized (d10) {
                            d10.f9466b += readInt3;
                            if (readInt3 > 0) {
                                d10.notifyAll();
                            }
                        }
                        return true;
                    }
                    return true;
                default:
                    this.f9450a.skip(j);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9450a.close();
    }

    public final void d(o oVar) {
        if (this.f9452l) {
            if (c(true, oVar)) {
                return;
            }
            e.c("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        w8.k kVar = e.f9393a;
        w8.k g = this.f9450a.g(kVar.f10971a.length);
        Level level = Level.FINE;
        Logger logger = f9449n;
        if (logger.isLoggable(level)) {
            String g3 = g.g();
            byte[] bArr = n8.c.f8114a;
            Locale locale = Locale.US;
            logger.fine("<< CONNECTION " + g3);
        }
        if (kVar.equals(g)) {
            return;
        }
        e.c("Expected a connection header but was %s", g.t());
        throw null;
    }

    public final void e(o oVar, int i, byte b7, int i6) {
        boolean z9;
        boolean z10;
        if (i6 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z11 = (b7 & 1) != 0;
        if ((b7 & 32) != 0) {
            e.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short readByte = (b7 & 8) != 0 ? (short) (this.f9450a.readByte() & 255) : (short) 0;
        int b10 = b(i, b7, readByte);
        w8.j jVar = this.f9450a;
        q qVar = (q) oVar.f9424l;
        if (i6 != 0 && (i6 & 1) == 0) {
            w8.h hVar = new w8.h();
            long j = b10;
            jVar.t(j);
            jVar.p(hVar, j);
            if (hVar.f10961b != j) {
                throw new IOException(hVar.f10961b + " != " + b10);
            }
            qVar.f9435r.execute(new k(qVar, new Object[]{qVar.f9430m, Integer.valueOf(i6)}, i6, hVar, b10, z11));
        } else {
            w d10 = qVar.d(i6);
            if (d10 == null) {
                ((q) oVar.f9424l).j(i6, 2);
                jVar.skip(b10);
            } else {
                u uVar = d10.g;
                long j6 = b10;
                while (true) {
                    if (j6 <= 0) {
                        uVar.getClass();
                        break;
                    }
                    synchronized (uVar.f9463o) {
                        z9 = uVar.f9462n;
                        z10 = uVar.f9459b.f10961b + j6 > uVar.f9460l;
                    }
                    if (z10) {
                        jVar.skip(j6);
                        w wVar = uVar.f9463o;
                        if (wVar.d(4)) {
                            wVar.f9468d.j(wVar.f9467c, 4);
                        }
                    } else {
                        if (z9) {
                            jVar.skip(j6);
                            break;
                        }
                        long p10 = jVar.p(uVar.f9458a, j6);
                        if (p10 == -1) {
                            s1.o.d();
                            return;
                        }
                        j6 -= p10;
                        synchronized (uVar.f9463o) {
                            try {
                                w8.h hVar2 = uVar.f9459b;
                                boolean z12 = hVar2.f10961b == 0;
                                hVar2.z(uVar.f9458a);
                                if (z12) {
                                    uVar.f9463o.notifyAll();
                                }
                            } finally {
                            }
                        }
                    }
                }
                if (z11) {
                    d10.h();
                }
            }
        }
        this.f9450a.skip(readByte);
    }

    public final void f(o oVar, int i, int i6) {
        int i10;
        w[] wVarArr;
        if (i < 8) {
            e.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i6 != 0) {
            e.c("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.f9450a.readInt();
        int readInt2 = this.f9450a.readInt();
        int i11 = i - 8;
        int[] e10 = c.j.e(11);
        int length = e10.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i10 = 0;
                break;
            }
            i10 = e10[i12];
            if (k0.k.c(i10) == readInt2) {
                break;
            } else {
                i12++;
            }
        }
        if (i10 == 0) {
            e.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        w8.k kVar = w8.k.f10970m;
        if (i11 > 0) {
            kVar = this.f9450a.g(i11);
        }
        kVar.f();
        synchronized (((q) oVar.f9424l)) {
            wVarArr = (w[]) ((q) oVar.f9424l).f9429l.values().toArray(new w[((q) oVar.f9424l).f9429l.size()]);
            ((q) oVar.f9424l).f9433p = true;
        }
        for (w wVar : wVarArr) {
            if (wVar.f9467c > readInt && wVar.f()) {
                wVar.j(5);
                ((q) oVar.f9424l).f(wVar.f9467c);
            }
        }
    }

    public final ArrayList h(int i, short s6, byte b7, int i6) {
        r rVar = this.f9451b;
        rVar.f9447n = i;
        rVar.f9444b = i;
        rVar.f9448o = s6;
        rVar.f9445l = b7;
        rVar.f9446m = i6;
        c cVar = this.f9453m;
        w8.a0 a0Var = cVar.f9387b;
        ArrayList arrayList = cVar.f9386a;
        while (!a0Var.b()) {
            byte readByte = a0Var.readByte();
            int i10 = readByte & 255;
            if (i10 == 128) {
                com.google.gson.internal.a.n("index == 0");
                return null;
            }
            if ((readByte & 128) == 128) {
                int e10 = cVar.e(i10, 127);
                int i11 = e10 - 1;
                if (i11 >= 0) {
                    b[] bVarArr = d.f9391a;
                    if (i11 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i11]);
                    }
                }
                int length = cVar.f + 1 + (i11 - d.f9391a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.f9390e;
                    if (length < bVarArr2.length) {
                        arrayList.add(bVarArr2[length]);
                    }
                }
                com.google.gson.internal.a.n(androidx.lifecycle.l.u(e10, "Header index too large "));
                return null;
            }
            if (i10 == 64) {
                w8.k d10 = cVar.d();
                d.a(d10);
                cVar.c(new b(d10, cVar.d()));
            } else if ((readByte & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i10, 63) - 1), cVar.d()));
            } else if ((readByte & 32) == 32) {
                int e11 = cVar.e(i10, 31);
                cVar.f9389d = e11;
                if (e11 < 0 || e11 > cVar.f9388c) {
                    throw new IOException("Invalid dynamic table size update " + cVar.f9389d);
                }
                int i12 = cVar.h;
                if (e11 < i12) {
                    if (e11 == 0) {
                        Arrays.fill(cVar.f9390e, (Object) null);
                        cVar.f = cVar.f9390e.length - 1;
                        cVar.g = 0;
                        cVar.h = 0;
                    } else {
                        cVar.a(i12 - e11);
                    }
                }
            } else if (i10 == 16 || i10 == 0) {
                w8.k d11 = cVar.d();
                d.a(d11);
                arrayList.add(new b(d11, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i10, 15) - 1), cVar.d()));
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList.clear();
        return arrayList2;
    }

    public final void i(o oVar, int i, byte b7, int i6) {
        if (i6 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z9 = (b7 & 1) != 0;
        short readByte = (b7 & 8) != 0 ? (short) (this.f9450a.readByte() & 255) : (short) 0;
        if ((b7 & 32) != 0) {
            w8.j jVar = this.f9450a;
            jVar.readInt();
            jVar.readByte();
            i -= 5;
        }
        ArrayList h = h(b(i, b7, readByte), readByte, b7, i6);
        q qVar = (q) oVar.f9424l;
        if (i6 != 0 && (i6 & 1) == 0) {
            try {
                qVar.f9435r.execute(new j(qVar, new Object[]{qVar.f9430m, Integer.valueOf(i6)}, i6, h, z9));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (qVar) {
            try {
                w d10 = ((q) oVar.f9424l).d(i6);
                if (d10 != null) {
                    d10.i(h);
                    if (z9) {
                        d10.h();
                        return;
                    }
                    return;
                }
                q qVar2 = (q) oVar.f9424l;
                if (qVar2.f9433p) {
                    return;
                }
                if (i6 <= qVar2.f9431n) {
                    return;
                }
                if (i6 % 2 == qVar2.f9432o % 2) {
                    return;
                }
                w wVar = new w(i6, qVar2, false, z9, h);
                q qVar3 = (q) oVar.f9424l;
                qVar3.f9431n = i6;
                qVar3.f9429l.put(Integer.valueOf(i6), wVar);
                q.D.execute(new o(oVar, new Object[]{((q) oVar.f9424l).f9430m, Integer.valueOf(i6)}, wVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(o oVar, int i, byte b7, int i6) {
        if (i != 8) {
            e.c("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i6 != 0) {
            e.c("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.f9450a.readInt();
        int readInt2 = this.f9450a.readInt();
        boolean z9 = (b7 & 1) != 0;
        q qVar = (q) oVar.f9424l;
        if (!z9) {
            try {
                qVar.f9434q.execute(new n(qVar, true, readInt, readInt2));
            } catch (RejectedExecutionException unused) {
            }
        } else {
            synchronized (qVar) {
                q qVar2 = (q) oVar.f9424l;
                qVar2.f9437t = false;
                qVar2.notifyAll();
            }
        }
    }

    public final void r(o oVar, int i, byte b7, int i6) {
        if (i6 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b7 & 8) != 0 ? (short) (this.f9450a.readByte() & 255) : (short) 0;
        int readInt = this.f9450a.readInt() & Integer.MAX_VALUE;
        ArrayList h = h(b(i - 4, b7, readByte), readByte, b7, i6);
        q qVar = (q) oVar.f9424l;
        synchronized (qVar) {
            try {
                if (qVar.C.contains(Integer.valueOf(readInt))) {
                    qVar.j(readInt, 2);
                    return;
                }
                qVar.C.add(Integer.valueOf(readInt));
                try {
                    qVar.f9435r.execute(new j(qVar, new Object[]{qVar.f9430m, Integer.valueOf(readInt)}, readInt, h));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s(o oVar, int i, byte b7, int i6) {
        long j;
        w[] wVarArr = null;
        if (i6 != 0) {
            e.c("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b7 & 1) != 0) {
            if (i == 0) {
                return;
            }
            e.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        }
        if (i % 6 != 0) {
            e.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        f8.q qVar = new f8.q(3);
        for (int i10 = 0; i10 < i; i10 += 6) {
            int readShort = this.f9450a.readShort() & 65535;
            int readInt = this.f9450a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        e.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    e.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    throw null;
                }
            } else if (readInt != 0 && readInt != 1) {
                e.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                throw null;
            }
            qVar.h(readShort, readInt);
        }
        synchronized (((q) oVar.f9424l)) {
            try {
                int c9 = ((q) oVar.f9424l).f9440x.c();
                f8.q qVar2 = ((q) oVar.f9424l).f9440x;
                qVar2.getClass();
                for (int i11 = 0; i11 < 10; i11++) {
                    if (((1 << i11) & qVar.f4964b) != 0) {
                        qVar2.h(i11, ((int[]) qVar.f4965c)[i11]);
                    }
                }
                try {
                    q qVar3 = (q) oVar.f9424l;
                    qVar3.f9434q.execute(new o(oVar, new Object[]{qVar3.f9430m}, qVar));
                } catch (RejectedExecutionException unused) {
                }
                int c10 = ((q) oVar.f9424l).f9440x.c();
                if (c10 == -1 || c10 == c9) {
                    j = 0;
                } else {
                    j = c10 - c9;
                    q qVar4 = (q) oVar.f9424l;
                    if (!qVar4.f9441y) {
                        qVar4.v += j;
                        if (j > 0) {
                            qVar4.notifyAll();
                        }
                        ((q) oVar.f9424l).f9441y = true;
                    }
                    if (!((q) oVar.f9424l).f9429l.isEmpty()) {
                        wVarArr = (w[]) ((q) oVar.f9424l).f9429l.values().toArray(new w[((q) oVar.f9424l).f9429l.size()]);
                    }
                }
                q.D.execute(new p(oVar, ((q) oVar.f9424l).f9430m));
            } finally {
            }
        }
        if (wVarArr == null || j == 0) {
            return;
        }
        for (w wVar : wVarArr) {
            synchronized (wVar) {
                wVar.f9466b += j;
                if (j > 0) {
                    wVar.notifyAll();
                }
            }
        }
    }
}
