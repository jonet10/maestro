package a2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements d {

    /* renamed from: l, reason: collision with root package name */
    public static final Charset f39l = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final File f40a;

    /* renamed from: b, reason: collision with root package name */
    public m f41b;

    public o(File file) {
        this.f40a = file;
    }

    public final void a() {
        File file = this.f40a;
        if (this.f41b == null) {
            try {
                this.f41b = new m(file);
            } catch (IOException e10) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e10);
            }
        }
    }

    @Override // a2.d
    public final void b() {
        y1.g.b(this.f41b, "There was a problem closing the Crashlytics log file.");
        this.f41b = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    @Override // a2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() {
        /*
            r7 = this;
            java.io.File r0 = r7.f40a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r2
            goto L38
        Lc:
            r7.a()
            a2.m r0 = r7.f41b
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r1}
            int r0 = r0.s()
            byte[] r0 = new byte[r0]
            a2.m r4 = r7.f41b     // Catch: java.io.IOException -> L29
            a2.f r5 = new a2.f     // Catch: java.io.IOException -> L29
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L29
            r4.e(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            java.lang.String r5 = "A problem occurred while reading the Crashlytics log file."
            java.lang.String r6 = "FirebaseCrashlytics"
            android.util.Log.e(r6, r5, r4)
        L31:
            a2.n r4 = new a2.n
            r3 = r3[r1]
            r4.<init>(r0, r3)
        L38:
            if (r4 != 0) goto L3c
            r3 = r2
            goto L45
        L3c:
            int r0 = r4.f38b
            byte[] r3 = new byte[r0]
            byte[] r4 = r4.f37a
            java.lang.System.arraycopy(r4, r1, r3, r1, r0)
        L45:
            if (r3 == 0) goto L4f
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = a2.o.f39l
            r0.<init>(r3, r1)
            return r0
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.o.c():java.lang.String");
    }

    @Override // a2.d
    public final void e(long j, String str) {
        a();
        if (this.f41b == null) {
            return;
        }
        try {
            if (str.length() > 16384) {
                str = "...".concat(str.substring(str.length() - 16384));
            }
            this.f41b.b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f39l));
            while (!this.f41b.f() && this.f41b.s() > 65536) {
                this.f41b.j();
            }
        } catch (IOException e10) {
            Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e10);
        }
    }
}
