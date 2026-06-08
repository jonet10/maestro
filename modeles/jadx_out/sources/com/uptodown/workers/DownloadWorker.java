package com.uptodown.workers;

import a5.c;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.l;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import j5.o;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import l7.m;
import r7.o0;
import x4.j0;
import x4.k;
import x4.q2;
import x4.r;
import x4.r0;
import x4.r1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class DownloadWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public Context f3474a;

    /* renamed from: b, reason: collision with root package name */
    public g f3475b;

    /* renamed from: c, reason: collision with root package name */
    public String f3476c;

    /* renamed from: d, reason: collision with root package name */
    public r f3477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f3474a = context;
    }

    public static void g(InputStream inputStream, FileOutputStream fileOutputStream, HttpsURLConnection httpsURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        if (l.D(fileOutputStream)) {
            fileOutputStream.getFD().sync();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        httpsURLConnection.disconnect();
    }

    public static /* synthetic */ void i(DownloadWorker downloadWorker, long j, j0 j0Var) {
        downloadWorker.h(j, j0Var, 207);
    }

    public static long m(HttpsURLConnection httpsURLConnection) {
        return Build.VERSION.SDK_INT >= 24 ? httpsURLConnection.getContentLengthLong() : httpsURLConnection.getContentLength();
    }

    public static String n(String str) {
        int A0 = m.A0("/", str, 6);
        int A02 = m.A0(".", str, 6);
        if (A02 > A0) {
            String substring = str.substring(A02);
            if (substring.length() != 0) {
                return substring;
            }
        }
        return ".apk";
    }

    public static HttpsURLConnection w(URL url) {
        URLConnection openConnection = url.openConnection();
        openConnection.getClass();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "728");
        httpsURLConnection.setConnectTimeout(60000);
        httpsURLConnection.setReadTimeout(90000);
        return httpsURLConnection;
    }

    public void B(r rVar) {
        rVar.getClass();
    }

    public void C(int i, r rVar) {
        rVar.getClass();
    }

    public Bundle d(Bundle bundle, j0 j0Var) {
        r rVar = this.f3477d;
        if (rVar == null || rVar.A != 1) {
            k kVar = UptodownApp.f3293g0;
            if (kVar != null && rVar != null) {
                int i = kVar.f11250d;
                rVar.getClass();
                if (i == rVar.f11354a) {
                    bundle.putInt("deeplink", 1);
                }
            }
            bundle.putInt("deeplink", 0);
        } else {
            bundle.putInt("deeplink", 1);
        }
        r1 A = i5.A(this.f3474a);
        if (A != null) {
            r rVar2 = this.f3477d;
            if (rVar2 == null || A.f11373c != rVar2.f11354a) {
                bundle.putInt("notification_fcm", 0);
            } else {
                bundle.putInt("notification_fcm", 1);
            }
        }
        String str = this.f3476c;
        if (str != null) {
            bundle.putString("host", str);
        }
        if (j0Var != null) {
            long j = j0Var.f11235l;
            if (j > 0) {
                bundle.putString("fileId", String.valueOf(j));
            }
            long j6 = j0Var.f11237n;
            if (j6 > 0) {
                String str2 = "<10MB";
                if (j6 >= 10485760) {
                    if (j6 < 104857600) {
                        str2 = "<100MB";
                    } else if (j6 < 524288000) {
                        str2 = "<500MB";
                    } else if (j6 < 1073741824) {
                        str2 = "<1GB";
                    } else if (j6 < 10737418240L) {
                        str2 = "<10GB";
                    }
                }
                bundle.putString("size", str2);
            }
        }
        if (o() != null) {
            bundle.putInt("update", 1);
        } else {
            bundle.putInt("update", 0);
        }
        r rVar3 = this.f3477d;
        if (rVar3 != null && rVar3.f11361q > 0) {
            rVar3.getClass();
            bundle.putString("appId", String.valueOf(rVar3.f11361q));
        }
        r rVar4 = this.f3477d;
        if (rVar4 != null && rVar4.f11355b != null) {
            rVar4.getClass();
            bundle.putString("packagename", rVar4.f11355b);
        }
        bundle.putString("connectionType", z3.f ? "wifi" : "mobile");
        bundle.putLong("downBandwidthKbps", z3.f2929d);
        bundle.putLong("upBandwidthKbps", z3.f2930e);
        return bundle;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result failure = ListenableWorker.Result.failure();
        failure.getClass();
        return failure;
    }

    public final boolean e() {
        return o() != null ? z3.h(this.f3474a) : z3.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle f(long r21, long r23, java.io.File r25, x4.j0 r26) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.f(long, long, java.io.File, x4.j0):android.os.Bundle");
    }

    public final void h(long j, j0 j0Var, int i) {
        r rVar = this.f3477d;
        if (rVar != null) {
            rVar.t(this.f3474a);
            j5.g l10 = j5.g.D.l(this.f3474a);
            l10.b();
            r rVar2 = this.f3477d;
            rVar2.getClass();
            boolean p10 = rVar2.p();
            r rVar3 = this.f3477d;
            if (p10) {
                l10.j(rVar3);
            } else {
                rVar3.getClass();
                Iterator it = rVar3.F.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    j0 j0Var2 = (j0) next;
                    j0Var2.f11238o = 0L;
                    j0Var2.f11241r = 0;
                    l10.r0(j0Var2);
                }
            }
            l10.c();
            if (q()) {
                A();
            }
            Context context = this.f3474a;
            context.getClass();
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(261);
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled");
            if (j > 0) {
                bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j) / 1000);
            }
            r(bundle, null, j0Var);
            r rVar4 = this.f3477d;
            rVar4.getClass();
            C(i, rVar4);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public final long k(javax.net.ssl.HttpsURLConnection r42, java.io.File r43, x4.r r44, x4.j0 r45, java.lang.String r46, long r47, o5.e r49) {
        /*
            Method dump skipped, instructions count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.k(javax.net.ssl.HttpsURLConnection, java.io.File, x4.r, x4.j0, java.lang.String, long, o5.e):long");
    }

    public final void l(j0 j0Var) {
        r(k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "first_data"), this.f3476c, j0Var);
    }

    public q2 o() {
        return null;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public final void r(Bundle bundle, String str, j0 j0Var) {
        this.f3476c = str;
        Bundle d10 = d(bundle, j0Var);
        g gVar = this.f3475b;
        if (gVar != null) {
            gVar.E(d10, "download");
        }
    }

    public final void s(long j, long j6, long j10, long j11, j0 j0Var) {
        Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "completed");
        if (j == 0) {
            long currentTimeMillis = (System.currentTimeMillis() - j10) / 1000;
            if (currentTimeMillis > 0) {
                j = j11 / currentTimeMillis;
            }
        }
        e10.putLong("speed", j);
        e10.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j6) / 1000);
        r(e10, this.f3476c, j0Var);
    }

    public void t(q2 q2Var, r rVar, j0 j0Var, Bundle bundle, String str, long j) {
        rVar.getClass();
    }

    public final void u(int i) {
        if (this.f3477d != null) {
            Data.Builder builder = new Data.Builder();
            builder.putInt("downloadProgress", i);
            setProgressAsync(builder.build());
            if (o() == null) {
                o.c(this.f3474a);
            }
            r rVar = this.f3477d;
            rVar.getClass();
            C(201, rVar);
        }
    }

    public final boolean v(HttpsURLConnection httpsURLConnection, long j) {
        httpsURLConnection.connect();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return true;
        }
        Bundle f = k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "error", NotificationCompat.CATEGORY_STATUS);
        f.putString("responseCode", String.valueOf(responseCode));
        f.putString("url", httpsURLConnection.getURL().toString());
        if (o() != null) {
            f.putInt("update", 1);
        } else {
            f.putInt("update", 0);
        }
        j(f, " (105)", j);
        return false;
    }

    public final void x(r rVar, j0 j0Var, String str, String str2, long j, String str3) {
        q2 o10 = o();
        if (o10 == null) {
            Bundle f = k0.k.f("exception", str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
            f.putString("url", str3);
            j(f, " (109)", j);
            return;
        }
        o0 o0Var = c.f197a;
        c.f199c.n(new r0(o10.f11352s));
        Bundle bundle = new Bundle();
        bundle.putString("exception", str);
        bundle.putString("url", str3);
        t(o10, rVar, j0Var, bundle, str2, j);
    }

    public final void y(String str, Bundle bundle, long j, r rVar) {
        if (rVar != null) {
            rVar.l(this.f3474a);
            B(rVar);
            if (rVar.p()) {
                o.i(this.f3474a, rVar, str);
            }
        }
        if (j > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j) / 1000);
        }
        Bundle d10 = d(bundle, null);
        g gVar = this.f3475b;
        if (gVar != null) {
            gVar.E(d10, "download");
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final javax.net.ssl.HttpsURLConnection z(java.lang.String r19, long r20, x4.j0 r22) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.z(java.lang.String, long, x4.j0):javax.net.ssl.HttpsURLConnection");
    }

    public void A() {
    }

    public void j(Bundle bundle, String str, long j) {
    }
}
