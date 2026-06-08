package m8;

import com.google.android.gms.internal.measurement.z3;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public final g5.g f7721a = new g5.g(this, 7);

    /* renamed from: b, reason: collision with root package name */
    public final o8.f f7722b;

    public g(File file, long j) {
        Pattern pattern = o8.f.D;
        if (j <= 0) {
            com.google.gson.internal.a.p("maxSize <= 0");
            throw null;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        byte[] bArr = n8.c.f8114a;
        this.f7722b = new o8.f(file, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, linkedBlockingQueue, new n8.b("OkHttp DiskLruCache", true)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if (r6 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x002e, code lost:
    
        d0.b.v(16);
        d0.b.v(16);
        r0 = java.lang.Integer.toString(r10, 16);
        r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        throw new java.lang.NumberFormatException("Expected a digit or '-' but was 0x".concat(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(w8.a0 r12) {
        /*
            java.lang.String r0 = "expected an int but was \""
            w8.h r1 = r12.f10934b     // Catch: java.lang.NumberFormatException -> L83
            r2 = 1
            r12.t(r2)     // Catch: java.lang.NumberFormatException -> L83
            r4 = 0
            r6 = r4
        Lc:
            long r8 = r6 + r2
            boolean r10 = r12.n(r8)     // Catch: java.lang.NumberFormatException -> L83
            if (r10 == 0) goto L49
            byte r10 = r1.d(r6)     // Catch: java.lang.NumberFormatException -> L83
            r11 = 48
            if (r10 < r11) goto L20
            r11 = 57
            if (r10 <= r11) goto L29
        L20:
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 != 0) goto L2b
            r7 = 45
            if (r10 == r7) goto L29
            goto L2b
        L29:
            r6 = r8
            goto Lc
        L2b:
            if (r6 == 0) goto L2e
            goto L49
        L2e:
            java.lang.NumberFormatException r12 = new java.lang.NumberFormatException     // Catch: java.lang.NumberFormatException -> L83
            r0 = 16
            d0.b.v(r0)     // Catch: java.lang.NumberFormatException -> L83
            d0.b.v(r0)     // Catch: java.lang.NumberFormatException -> L83
            java.lang.String r0 = java.lang.Integer.toString(r10, r0)     // Catch: java.lang.NumberFormatException -> L83
            r0.getClass()     // Catch: java.lang.NumberFormatException -> L83
            java.lang.String r1 = "Expected a digit or '-' but was 0x"
            java.lang.String r0 = r1.concat(r0)     // Catch: java.lang.NumberFormatException -> L83
            r12.<init>(r0)     // Catch: java.lang.NumberFormatException -> L83
            throw r12     // Catch: java.lang.NumberFormatException -> L83
        L49:
            long r1 = r1.j()     // Catch: java.lang.NumberFormatException -> L83
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r12 = r12.k(r6)     // Catch: java.lang.NumberFormatException -> L83
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 < 0) goto L69
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L69
            boolean r3 = r12.isEmpty()     // Catch: java.lang.NumberFormatException -> L83
            if (r3 == 0) goto L69
            int r12 = (int) r1     // Catch: java.lang.NumberFormatException -> L83
            return r12
        L69:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.NumberFormatException -> L83
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L83
            r4.<init>(r0)     // Catch: java.lang.NumberFormatException -> L83
            r4.append(r1)     // Catch: java.lang.NumberFormatException -> L83
            r4.append(r12)     // Catch: java.lang.NumberFormatException -> L83
            java.lang.String r12 = "\""
            r4.append(r12)     // Catch: java.lang.NumberFormatException -> L83
            java.lang.String r12 = r4.toString()     // Catch: java.lang.NumberFormatException -> L83
            r3.<init>(r12)     // Catch: java.lang.NumberFormatException -> L83
            throw r3     // Catch: java.lang.NumberFormatException -> L83
        L83:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.google.gson.internal.a.n(r12)
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.g.b(w8.a0):int");
    }

    public final void c(a0 a0Var) {
        o8.f fVar = this.f7722b;
        String str = a0Var.f7673a.i;
        w8.k kVar = w8.k.f10970m;
        String g = z3.m(str).e("MD5").g();
        synchronized (fVar) {
            fVar.f();
            fVar.b();
            o8.f.z(g);
            o8.d dVar = (o8.d) fVar.f8365t.get(g);
            if (dVar == null) {
                return;
            }
            fVar.u(dVar);
            if (fVar.f8363r <= fVar.f8361p) {
                fVar.f8369y = false;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f7722b.close();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.f7722b.flush();
    }
}
