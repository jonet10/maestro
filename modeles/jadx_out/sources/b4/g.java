package b4;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.workers.GetRemoteInstallWorker;
import g4.r0;
import g4.s0;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import l7.m;
import w4.p;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UptodownApp f1004a;

    public /* synthetic */ g(UptodownApp uptodownApp) {
        this.f1004a = uptodownApp;
    }

    public static void a(String str) {
        m4.b bVar;
        e2.d dVar;
        str.getClass();
        m4.b bVar2 = f4.c.f4885z;
        bVar2.getClass();
        Socket socket = bVar2.f7284e;
        if (socket == null || socket.isClosed()) {
            if (f4.c.f4884y == null || (bVar = f4.c.f4885z) == null || (dVar = bVar.f7281b) == null) {
                return;
            }
            dVar.p();
            return;
        }
        Activity activity = f4.c.f4875o;
        if (activity == null || !(activity instanceof s0)) {
            return;
        }
        ((s0) activity).F();
    }

    public static void b(String str) {
        android.support.v4.media.g gVar;
        str.getClass();
        Activity activity = f4.c.f4875o;
        String str2 = "File Transfer is correct!";
        if (activity == null || !(activity instanceof s0)) {
            f4.c.B = str;
            f4.c.C = "File Transfer is correct!";
        } else {
            s0 s0Var = (s0) activity;
            s0Var.runOnUiThread(new androidx.work.impl.c(s0Var, str, str2, 3));
        }
        m4.b bVar = f4.c.f4885z;
        if (bVar == null || (gVar = bVar.f7282c) == null) {
            return;
        }
        new Thread(new a4.f(gVar, 20)).start();
    }

    public static void c(l4.c cVar) {
        cVar.getClass();
        Activity activity = f4.c.f4875o;
        if (activity == null || !(activity instanceof s0)) {
            return;
        }
        s0 s0Var = (s0) activity;
        s0Var.runOnUiThread(new androidx.browser.trusted.c(17, s0Var, cVar));
    }

    public static void d(l4.c cVar) {
        m4.b bVar;
        android.support.v4.media.g gVar;
        cVar.getClass();
        File file = cVar.f7103a;
        if (file == null || (bVar = f4.c.f4885z) == null || (gVar = bVar.f7282c) == null) {
            return;
        }
        new Thread(new m1.a(gVar, file, 29, false)).start();
    }

    public static void h(NsdServiceInfo nsdServiceInfo) {
        m4.b bVar = f4.c.f4885z;
        if (bVar != null) {
            Socket socket = bVar.f7283d;
            if (socket == null || socket.isClosed()) {
                bVar.f7280a.f1004a.b();
            } else {
                android.support.v4.media.g gVar = bVar.f7282c;
                String str = f4.c.f4880t;
                if (str == null) {
                    l.i("myNsdServiceName");
                    throw null;
                }
                gVar.getClass();
                new Thread(new m4.a(0, gVar, str)).start();
            }
        }
        Activity activity = f4.c.f4875o;
        if (activity == null || !(activity instanceof s0)) {
            return;
        }
        s0 s0Var = (s0) activity;
        s0Var.runOnUiThread(new androidx.browser.trusted.c(16, s0Var, nsdServiceInfo));
    }

    public void e(int i) {
        NsdManager nsdManager;
        f4.b bVar = this.f1004a.f4890n;
        try {
            m4.g gVar = f4.c.f4884y;
            if (gVar != null && (nsdManager = gVar.f7291b) != null) {
                nsdManager.unregisterService(bVar);
            }
        } catch (Exception unused) {
        }
        m4.g gVar2 = f4.c.f4884y;
        if (gVar2 != null) {
            bVar.getClass();
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setPort(i);
            String str = f4.c.f4880t;
            if (str == null) {
                l.i("myNsdServiceName");
                throw null;
            }
            nsdServiceInfo.setServiceName(str);
            nsdServiceInfo.setServiceType("_nsduptodown._tcp.");
            try {
                gVar2.f7291b.registerService(nsdServiceInfo, 1, bVar);
            } catch (Exception unused2) {
                gVar2.f7290a.f1004a.b();
            }
        }
        m4.g gVar3 = f4.c.f4884y;
        if (gVar3 != null) {
            gVar3.b();
        }
    }

    public void f(String str) {
        Activity activity = f4.c.f4875o;
        if (activity == null || !(activity instanceof s0)) {
            f4.c.E = str;
        } else {
            s0 s0Var = (s0) activity;
            s0Var.runOnUiThread(new r0(s0Var, str, 0));
        }
        this.f1004a.b();
    }

    public void g(String str) {
        this.f1004a.b();
        Activity activity = f4.c.f4875o;
        if (activity == null || !(activity instanceof s0)) {
            f4.c.D = str;
        } else {
            s0 s0Var = (s0) activity;
            s0Var.runOnUiThread(new r0(s0Var, str, 1));
        }
    }

    public void i(String str) {
        NsdServiceInfo nsdServiceInfo;
        m4.b bVar = f4.c.f4885z;
        bVar.getClass();
        Socket socket = bVar.f7284e;
        if (socket == null || socket.isClosed()) {
            m4.g gVar = f4.c.f4884y;
            gVar.getClass();
            Iterator it = gVar.g.iterator();
            it.getClass();
            while (true) {
                if (!it.hasNext()) {
                    nsdServiceInfo = null;
                    break;
                }
                Object next = it.next();
                next.getClass();
                nsdServiceInfo = (NsdServiceInfo) next;
                if (str.equalsIgnoreCase(nsdServiceInfo.getServiceName())) {
                    break;
                }
            }
            if (nsdServiceInfo != null) {
                m4.g gVar2 = f4.c.f4884y;
                gVar2.getClass();
                gVar2.d(nsdServiceInfo);
                return;
            }
            this.f1004a.b();
            Activity activity = f4.c.f4875o;
            if (activity == null || !(activity instanceof s0)) {
                return;
            }
            s0 s0Var = (s0) activity;
            activity.getClass();
            String string = activity.getString(2131952003, str.substring(0, m.y0(str, "_d:_", 0, false, 6)));
            string.getClass();
            s0Var.runOnUiThread(new r0(s0Var, string, 0));
        }
    }

    @Override // w4.p
    public void l() {
        UptodownApp uptodownApp = this.f1004a;
        Context applicationContext = uptodownApp.getApplicationContext();
        applicationContext.getClass();
        if (u2.h(applicationContext) != null) {
            float f = UptodownApp.I;
            Context applicationContext2 = uptodownApp.getApplicationContext();
            applicationContext2.getClass();
            d.z(applicationContext2);
            Context applicationContext3 = uptodownApp.getApplicationContext();
            applicationContext3.getClass();
            d.A(applicationContext3);
            Context applicationContext4 = uptodownApp.getApplicationContext();
            applicationContext4.getClass();
            String str = null;
            try {
                SharedPreferences sharedPreferences = applicationContext4.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("fcmToken")) {
                    str = sharedPreferences.getString("fcmToken", null);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (str != null && str.length() != 0) {
                if (d.p(applicationContext4, "GetRemoteInstallWorker")) {
                    WorkManager.Companion.getInstance(applicationContext4).cancelAllWorkByTag("GetRemoteInstallWorker");
                }
            } else {
                if (d.p(applicationContext4, "GetRemoteInstallWorker")) {
                    return;
                }
                WorkManager.Companion.getInstance(applicationContext4).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetRemoteInstallWorker.class, 30L, TimeUnit.MINUTES).addTag("GetRemoteInstallWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
            }
        }
    }
}
