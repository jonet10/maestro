package o6;

import android.content.Context;
import androidx.leanback.media.MediaPlayerGlue;
import b2.t1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.l;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f8224a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static n9.a f8225b;

    /* renamed from: c, reason: collision with root package name */
    public static n9.a f8226c;

    /* renamed from: d, reason: collision with root package name */
    public static n9.a f8227d;

    /* renamed from: e, reason: collision with root package name */
    public static n9.a f8228e;

    public static final File a(Context context, String str) {
        File file = new File(context.getCacheDir(), "downloaded_fonts/inmobi/");
        if (!file.exists()) {
            file.mkdirs();
        }
        int lastIndexOf = str.lastIndexOf(47, m.u0(str));
        String I0 = m.I0(lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1, str.length()), '?');
        if (m.z0(I0)) {
            I0 = "font";
        }
        return new File(file, I0 + '_' + String.valueOf(str.hashCode()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b9, code lost:
    
        if (r13 == r5) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(android.app.Application r10, java.lang.String r11, java.lang.String r12, v6.c r13) {
        /*
            boolean r0 = r13 instanceof o6.a
            if (r0 == 0) goto L13
            r0 = r13
            o6.a r0 = (o6.a) r0
            int r1 = r0.f8214n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8214n = r1
            goto L18
        L13:
            o6.a r0 = new o6.a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f8213m
            int r1 = r0.f8214n
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2c
            p6.a.e(r13)
            goto Lbc
        L2c:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r10)
            return r4
        L32:
            java.lang.String r12 = r0.f8212l
            android.content.Context r10 = r0.f8211b
            o6.e r11 = r0.f8210a
            p6.a.e(r13)
            goto L8d
        L3c:
            p6.a.e(r13)
            o6.e r13 = o6.e.f8224a
            if (r11 == 0) goto L90
            int r1 = r11.length()
            if (r1 != 0) goto L4a
            goto L90
        L4a:
            r0.f8210a = r13
            r0.f8211b = r10
            r0.f8212l = r12
            r0.f8214n = r3
            o7.l r1 = new o7.l
            t6.c r6 = d0.b.I(r0)
            r1.<init>(r3, r6)
            r1.s()
            java.lang.String r3 = "Trying Google Font: "
            java.lang.String r3 = kotlin.jvm.internal.l.g(r11, r3)
            a.a.f(r3)
            androidx.core.provider.FontRequest r3 = new androidx.core.provider.FontRequest
            java.lang.String r6 = "com.google.android.gms.fonts"
            java.lang.String r7 = "com.google.android.gms"
            r8 = 2130903040(0x7f030000, float:1.7412887E38)
            r3.<init>(r6, r7, r11, r8)
            o6.d r6 = new o6.d
            r6.<init>(r11, r1)
            android.os.Handler r11 = new android.os.Handler
            android.os.Looper r7 = android.os.Looper.getMainLooper()
            r11.<init>(r7)
            androidx.core.provider.FontsContractCompat.requestFont(r10, r3, r6, r11)
            java.lang.Object r11 = r1.r()
            if (r11 != r5) goto L8a
            goto Lbb
        L8a:
            r9 = r13
            r13 = r11
            r11 = r9
        L8d:
            android.graphics.Typeface r13 = (android.graphics.Typeface) r13
            goto L92
        L90:
            r11 = r13
            r13 = r4
        L92:
            if (r13 == 0) goto L95
            return r13
        L95:
            r0.f8210a = r4
            r0.f8211b = r4
            r0.f8212l = r4
            r0.f8214n = r2
            r11.getClass()
            if (r12 == 0) goto Lb8
            int r11 = r12.length()
            if (r11 != 0) goto La9
            goto Lb8
        La9:
            v7.e r11 = o7.m0.f8288a
            v7.d r11 = v7.d.f10884a
            j5.i r13 = new j5.i
            r13.<init>(r10, r12, r4, r2)
            java.lang.Object r10 = o7.c0.C(r13, r11, r0)
            r13 = r10
            goto Lb9
        Lb8:
            r13 = r4
        Lb9:
            if (r13 != r5) goto Lbc
        Lbb:
            return r5
        Lbc:
            android.graphics.Typeface r13 = (android.graphics.Typeface) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.e.b(android.app.Application, java.lang.String, java.lang.String, v6.c):java.lang.Object");
    }

    public static final void c(File file, String str) {
        HttpURLConnection httpURLConnection;
        File file2 = new File(file.getParentFile(), file.getName() + '.' + System.nanoTime() + ".tmp");
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(MediaPlayerGlue.FAST_FORWARD_REWIND_STEP);
            httpURLConnection.setInstanceFollowRedirects(true);
            try {
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    throw new IllegalStateException("HTTP " + httpURLConnection.getResponseCode() + " while downloading " + str);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        inputStream.getClass();
                        t1.t(inputStream, fileOutputStream);
                        fileOutputStream.close();
                        inputStream.close();
                        if (file2.length() <= 0) {
                            throw new IllegalStateException(l.g(str, "Downloaded font is empty for "));
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!file2.renameTo(file)) {
                            a7.c.h0(file2, file);
                            file2.delete();
                        }
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                } catch (Throwable unused2) {
                }
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
