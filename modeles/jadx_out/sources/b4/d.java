package b4;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.l;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import c4.k0;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetUserDataWorker;
import com.uptodown.workers.PreRegisterWorker;
import com.uptodown.workers.TrackingWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l7.u;
import n4.i;
import x4.k;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {
    public static void A(Context context) {
        context.getClass();
        if (p(context, "PreRegisterWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PreRegisterWorker.class, 4L, TimeUnit.HOURS).addTag("PreRegisterWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }

    public static void B(Context context) {
        if (p(context, "TrackingWorkerPeriodic")) {
            return;
        }
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) TrackingWorker.class, 30L, timeUnit).addTag("TrackingWorkerPeriodic").setBackoffCriteria(BackoffPolicy.LINEAR, 1L, timeUnit).setConstraints(build).build());
    }

    public static void C(FragmentTransaction fragmentTransaction, k0 k0Var) {
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = k0Var.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            fragmentTransaction.setCustomAnimations(2130772024, 2130772025, 2130772003, 2130772004);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x4.r D(x4.g r7, c4.k0 r8) {
        /*
            r7.getClass()
            boolean r0 = com.google.android.gms.internal.measurement.z3.f2928c
            java.lang.String r1 = " (108)"
            r2 = 2131951992(0x7f130178, float:1.9540414E38)
            r3 = 0
            if (r0 == 0) goto Lf2
            java.lang.String r0 = r7.F
            if (r0 == 0) goto L1d
            android.content.pm.PackageManager r4 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1d
            if (r4 == 0) goto L1d
            r5 = 0
            android.content.pm.PackageInfo r0 = n4.i.e(r4, r0, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1d
            goto L1e
        L1d:
            r0 = r3
        L1e:
            r4 = 2131951994(0x7f13017a, float:1.9540418E38)
            java.lang.String r5 = "DownloadUpdatesWorker"
            java.lang.String r6 = "GenerateQueueWorker"
            if (r0 == 0) goto Lad
            java.lang.String r0 = "downloadApkWorker"
            boolean r1 = p(r8, r0)
            if (r1 != 0) goto L9c
            java.lang.String r7 = r7.F
            x4.e r7 = j5.a.h(r8, r7)
            if (r7 == 0) goto Lac
            boolean r0 = p(r8, r5)
            if (r0 == 0) goto L4c
            java.lang.String r8 = r7.f11123l
            r8.getClass()
            boolean r8 = m(r8)
            if (r8 != 0) goto Lac
            c(r7)
            return r3
        L4c:
            java.util.ArrayList r0 = c(r7)
            if (r0 == 0) goto Lac
            int r0 = r0.size()
            r1 = 1
            if (r0 > r1) goto Lac
            boolean r0 = p(r8, r6)
            if (r0 != 0) goto Lac
            java.lang.String r7 = r7.f11123l
            float r0 = com.uptodown.UptodownApp.I
            boolean r0 = p(r8, r6)
            if (r0 != 0) goto Lac
            androidx.work.Data$Builder r0 = new androidx.work.Data$Builder
            r0.<init>()
            java.lang.String r2 = "downloadAnyway"
            androidx.work.Data$Builder r0 = r0.putBoolean(r2, r1)
            java.lang.String r1 = "packagename"
            androidx.work.Data$Builder r7 = r0.putString(r1, r7)
            java.lang.Class<com.uptodown.workers.GenerateQueueWorker> r0 = com.uptodown.workers.GenerateQueueWorker.class
            androidx.work.WorkRequest$Builder r0 = androidx.lifecycle.l.t(r0, r6)
            androidx.work.OneTimeWorkRequest$Builder r0 = (androidx.work.OneTimeWorkRequest.Builder) r0
            androidx.work.Data r7 = r7.build()
            androidx.work.WorkRequest$Builder r7 = r0.setInputData(r7)
            androidx.work.OneTimeWorkRequest$Builder r7 = (androidx.work.OneTimeWorkRequest.Builder) r7
            androidx.work.WorkRequest r7 = r7.build()
            androidx.work.OneTimeWorkRequest r7 = (androidx.work.OneTimeWorkRequest) r7
            androidx.work.WorkManager$Companion r0 = androidx.work.WorkManager.Companion
            androidx.work.WorkManager r8 = r0.getInstance(r8)
            r8.enqueue(r7)
            goto Lac
        L9c:
            boolean r7 = p(r8, r0)
            if (r7 == 0) goto Lac
            java.lang.String r7 = r8.getString(r4)
            r7.getClass()
            r8.N(r7)
        Lac:
            return r3
        Lad:
            boolean r0 = p(r8, r6)
            if (r0 != 0) goto Le7
            boolean r0 = p(r8, r5)
            if (r0 != 0) goto Le7
            x4.r r0 = new x4.r
            r0.<init>()
            r0.a(r7)
            int r3 = r0.r(r8)
            if (r3 < 0) goto Ld0
            java.lang.String r7 = r7.f11159b
            r7.getClass()
            r8.o0(r3, r7)
            return r0
        Ld0:
            java.lang.String r7 = r8.getString(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r1)
            java.lang.String r7 = r2.toString()
            r8.A(r7)
            return r0
        Le7:
            java.lang.String r7 = r8.getString(r4)
            r7.getClass()
            r8.N(r7)
            return r3
        Lf2:
            java.lang.String r7 = r8.getString(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r1)
            java.lang.String r7 = r0.toString()
            r8.A(r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.d.D(x4.g, c4.k0):x4.r");
    }

    public static int E(Context context, x4.g gVar) {
        gVar.getClass();
        context.getClass();
        if (!z3.f2928c) {
            return -1;
        }
        r rVar = new r();
        rVar.a(gVar);
        int r9 = rVar.r(context);
        if (r9 >= 0) {
            float f = UptodownApp.I;
            if (!p(context, "downloadApkWorker")) {
                WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) l.t(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", r9).build()).build());
            }
        }
        return r9;
    }

    public static boolean F(Context context) {
        float f = UptodownApp.I;
        context.getClass();
        if (p(context, "TrackingWorkerSingle") || o(context, "TrackingWorkerPeriodic") || o(context, "GenerateQueueWorker") || o(context, "DownloadUpdatesWorker") || o(context, "GetUpdatesWorker")) {
            return false;
        }
        Data build = new Data.Builder().putBoolean("isCompressed", true).build();
        WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) l.t(TrackingWorker.class, "TrackingWorkerSingle")).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.MINUTES).setInputData(build).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
        return true;
    }

    public static Bundle a(Activity activity) {
        activity.getClass();
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return ActivityOptions.makeCustomAnimation(activity, 2130772024, 2130772025).toBundle();
        }
        return null;
    }

    public static ActivityOptionsCompat b(Activity activity) {
        activity.getClass();
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return ActivityOptionsCompat.makeCustomAnimation(activity, 2130772024, 2130772025);
        }
        return null;
    }

    public static ArrayList c(x4.e eVar) {
        ArrayList arrayList;
        eVar.getClass();
        synchronized (UptodownApp.f3294h0) {
            try {
                if (eVar.F > 0) {
                    ArrayList arrayList2 = UptodownApp.f3295i0;
                    if (arrayList2 != null) {
                        arrayList2.add(eVar);
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        UptodownApp.f3295i0 = arrayList3;
                        arrayList3.add(eVar);
                    }
                }
                arrayList = UptodownApp.f3295i0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0164, code lost:
    
        if (r13 <= 2.0f) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0204, code lost:
    
        if (r1 >= 4300) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0237, code lost:
    
        if (r1 >= 4300) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x011a, code lost:
    
        if (r13 <= 2.0f) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011c, code lost:
    
        r13 = r13 + 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.d.d(android.content.Context):void");
    }

    public static boolean e(Context context) {
        context.getClass();
        if (z3.f) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("autoplay_wifi")) {
                    return sharedPreferences.getBoolean("autoplay_wifi", true);
                }
            } catch (Exception unused) {
            }
            return true;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("autoplay_mobile_data")) {
                return sharedPreferences2.getBoolean("autoplay_mobile_data", false);
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static Drawable f(Context context) {
        context.getClass();
        Drawable drawable = ContextCompat.getDrawable(context, 2131231216);
        return drawable != null ? drawable : new ColorDrawable(ContextCompat.getColor(context, 2131100735));
    }

    public static x4.e g() {
        x4.e eVar;
        synchronized (UptodownApp.f3294h0) {
            ArrayList arrayList = UptodownApp.f3295i0;
            if (arrayList == null || arrayList.isEmpty()) {
                eVar = null;
            } else {
                ArrayList arrayList2 = UptodownApp.f3295i0;
                arrayList2.getClass();
                eVar = (x4.e) arrayList2.remove(0);
            }
        }
        return eVar;
    }

    public static ArrayList h() {
        ArrayList arrayList;
        synchronized (UptodownApp.f3299m0) {
            arrayList = UptodownApp.n0;
        }
        return arrayList;
    }

    public static ArrayList i() {
        ArrayList arrayList;
        synchronized (UptodownApp.f3294h0) {
            arrayList = UptodownApp.f3295i0;
        }
        return arrayList;
    }

    public static WorkInfo.State j(Context context) {
        WorkInfo.State state = WorkInfo.State.SUCCEEDED;
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag("downloadApkWorker").get()).iterator();
        while (it.hasNext() && (state = ((WorkInfo) it.next()).getState()) != WorkInfo.State.RUNNING && state != WorkInfo.State.ENQUEUED) {
        }
        return state;
    }

    public static boolean k(String str) {
        String C;
        k kVar = UptodownApp.f3293g0;
        if (kVar == null) {
            return false;
        }
        String str2 = kVar.f11249c;
        if (str2 == null || str2.length() == 0) {
            String a8 = kVar.a();
            C = (a8 == null || a8.length() == 0) ? null : a.a.C(a8);
        } else {
            C = kVar.f11249c;
        }
        return u.m0(C, str, true);
    }

    public static boolean l(q2 q2Var) {
        boolean z9;
        synchronized (UptodownApp.f3299m0) {
            Iterator it = UptodownApp.n0.iterator();
            it.getClass();
            while (true) {
                if (!it.hasNext()) {
                    z9 = false;
                    break;
                }
                Object next = it.next();
                next.getClass();
                z9 = true;
                if (u.m0(((q2) next).f11344b, q2Var.f11344b, true)) {
                    break;
                }
            }
        }
        return z9;
    }

    public static boolean m(String str) {
        str.getClass();
        synchronized (UptodownApp.f3294h0) {
            ArrayList arrayList = UptodownApp.f3295i0;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ArrayList arrayList2 = UptodownApp.f3295i0;
                    arrayList2.getClass();
                    if (str.equalsIgnoreCase(((x4.e) arrayList2.get(i)).f11123l)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean n(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("uimode");
        systemService.getClass();
        if (((UiModeManager) systemService).getCurrentModeType() == 4) {
            return true;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            ApplicationInfo applicationInfo = i.e(packageManager, "com.npg.smarttvnpg", 4096).applicationInfo;
            if (applicationInfo != null) {
                return (applicationInfo.flags & 129) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean o(Context context, String str) {
        context.getClass();
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag(str).get()).iterator();
        while (it.hasNext()) {
            if (((WorkInfo) it.next()).getState() == WorkInfo.State.RUNNING) {
                return true;
            }
        }
        return false;
    }

    public static boolean p(Context context, String str) {
        if (context == null) {
            return false;
        }
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag(str).get()).iterator();
        while (it.hasNext()) {
            WorkInfo.State state = ((WorkInfo) it.next()).getState();
            if (state == WorkInfo.State.RUNNING || state == WorkInfo.State.ENQUEUED) {
                return true;
            }
        }
        return false;
    }

    public static void q(Context context, String str, File file) {
        file.getClass();
        context.getClass();
        if (f4.a.f4869a.c() != null || f4.c.v != null) {
            k0 k0Var = (k0) context;
            String string = context.getString(2131951872);
            string.getClass();
            k0Var.A(string);
            return;
        }
        boolean f = j5.a.f(context);
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(context, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", f);
        intent.putExtra("backgroundInstallation", true);
        intent.addFlags(268435456);
        if (str != null && str.length() != 0) {
            intent.putExtra("newFeatures", str);
        }
        context.startActivity(intent);
        s(context, file);
    }

    public static void r(Context context, File file) {
        float f = UptodownApp.I;
        file.getClass();
        context.getClass();
        boolean f10 = j5.a.f(context);
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(context, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", f10);
        intent.putExtra("backgroundInstallation", false);
        intent.addFlags(268435456);
        context.startActivity(intent);
        s(context, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void s(android.content.Context r8, java.io.File r9) {
        /*
            e1.c0 r0 = j5.g.D
            j5.g r0 = r0.l(r8)
            r0.b()
            boolean r1 = r9.isFile()
            if (r1 == 0) goto L1b
            java.lang.String r9 = r9.getName()
            r9.getClass()
            x4.r r9 = r0.G(r9)
            goto L26
        L1b:
            java.lang.String r9 = r9.getAbsolutePath()
            r9.getClass()
            x4.r r9 = r0.H(r9)
        L26:
            r0.c()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r1 = 0
            r3 = 0
            r4 = 1
            if (r9 == 0) goto L61
            java.lang.String r5 = r9.f11355b
            if (r5 == 0) goto L61
            int r6 = r9.A
            if (r6 != r4) goto L3e
            r6 = r4
            goto L3f
        L3e:
            r6 = r3
        L3f:
            b2.t1.i(r8, r5, r0, r6)
            java.lang.String r5 = "packagename"
            java.lang.String r6 = r9.f11355b
            r0.putString(r5, r6)
            long r5 = r9.f11369z
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 <= 0) goto L61
            java.util.LinkedHashMap r5 = a5.e.f205a
            java.lang.String r5 = r9.f11355b
            r5.getClass()
            java.lang.String r5 = a5.e.a(r5)
            java.lang.String r6 = "updateOrigin"
            r0.putString(r6, r5)
            r5 = r4
            goto L62
        L61:
            r5 = r3
        L62:
            if (r9 == 0) goto L73
            long r6 = r9.f11361q
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L73
            java.lang.String r1 = "appId"
            java.lang.String r2 = java.lang.String.valueOf(r6)
            r0.putString(r1, r2)
        L73:
            java.lang.String r1 = "update"
            if (r5 == 0) goto L7b
            r0.putInt(r1, r4)
            goto L7e
        L7b:
            r0.putInt(r1, r3)
        L7e:
            java.lang.String r1 = "type"
            java.lang.String r2 = "start"
            r0.putString(r1, r2)
            android.support.v4.media.g r1 = new android.support.v4.media.g
            r2 = 20
            r1.<init>(r8, r2)
            java.lang.String r8 = "install"
            r1.E(r0, r8)
            r7.o0 r8 = a5.d.f201a
            r8 = 0
            if (r9 == 0) goto L99
            java.lang.String r9 = r9.f11355b
            goto L9a
        L99:
            r9 = r8
        L9a:
            r7.o0 r0 = a5.d.f201a
            x4.o1 r1 = new x4.o1
            r1.<init>(r9)
            r0.getClass()
            r0.g(r8, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.d.s(android.content.Context, java.io.File):void");
    }

    public static boolean t() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - UptodownApp.f3296j0 <= 600) {
            return false;
        }
        UptodownApp.f3296j0 = currentTimeMillis;
        return true;
    }

    public static void u(q2 q2Var) {
        q2Var.getClass();
        synchronized (UptodownApp.f3299m0) {
            try {
                Iterator it = UptodownApp.n0.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    int i6 = i + 1;
                    if (u.m0(((q2) it.next()).f11344b, q2Var.f11344b, true)) {
                        break;
                    } else {
                        i = i6;
                    }
                }
                if (i >= 0) {
                    ArrayList arrayList = UptodownApp.n0;
                    if (i < arrayList.size()) {
                        arrayList.remove(i);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r0 = com.uptodown.UptodownApp.f3295i0;
        r0.getClass();
        r0.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void v(x4.q2 r7) {
        /*
            java.lang.String r0 = r7.f11344b
            java.lang.Object r1 = com.uptodown.UptodownApp.f3294h0
            monitor-enter(r1)
            java.util.ArrayList r2 = com.uptodown.UptodownApp.f3295i0     // Catch: java.lang.Throwable -> L2f
            r3 = 0
            if (r2 == 0) goto L34
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L2f
            r4 = r3
        Lf:
            if (r4 >= r2) goto L34
            java.util.ArrayList r5 = com.uptodown.UptodownApp.f3295i0     // Catch: java.lang.Throwable -> L2f
            r5.getClass()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Throwable -> L2f
            x4.e r5 = (x4.e) r5     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = r5.f11123l     // Catch: java.lang.Throwable -> L2f
            r6 = 1
            boolean r5 = l7.u.m0(r0, r5, r6)     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L31
            java.util.ArrayList r0 = com.uptodown.UptodownApp.f3295i0     // Catch: java.lang.Throwable -> L2f
            r0.getClass()     // Catch: java.lang.Throwable -> L2f
            r0.remove(r4)     // Catch: java.lang.Throwable -> L2f
            r3 = r6
            goto L34
        L2f:
            r7 = move-exception
            goto L46
        L31:
            int r4 = r4 + 1
            goto Lf
        L34:
            monitor-exit(r1)
            if (r3 == 0) goto L45
            r7.o0 r0 = a5.c.f197a
            x4.m0 r0 = new x4.m0
            x4.r r7 = r7.f11352s
            r0.<init>(r7)
            r7.j0 r7 = a5.c.f199c
            r7.n(r0)
        L45:
            return
        L46:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.d.v(x4.q2):void");
    }

    public static n5.g w(Context context) {
        context.getClass();
        return new n5.g((int) context.getResources().getDimension(2131165268));
    }

    public static n5.g x(Context context) {
        context.getClass();
        n5.g gVar = UptodownApp.W;
        return gVar != null ? gVar : new n5.g((int) context.getResources().getDimension(2131165268));
    }

    public static n5.g y(Context context) {
        context.getClass();
        return new n5.g((int) context.getResources().getDimension(2131165269));
    }

    public static void z(Context context) {
        context.getClass();
        if (p(context, "GetUserDataWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetUserDataWorker.class, 24L, TimeUnit.HOURS).addTag("GetUserDataWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }
}
