package com.uptodown.workers;

import a5.b;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.media.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b4.d;
import c4.c1;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import f4.c;
import h4.a;
import j5.o;
import java.io.File;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import l7.m;
import o7.m0;
import r7.o0;
import t0.f;
import v7.e;
import x4.a0;
import x4.b0;
import x4.c0;
import x4.e0;
import x4.f0;
import x4.g0;
import x4.g2;
import x4.h0;
import x4.j0;
import x4.k;
import x4.k0;
import x4.r;
import x4.s;
import x4.t;
import x4.u;
import x4.v;
import x4.w;
import x4.x;
import x4.y;
import x4.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DownloadApkWorker extends DownloadWorker {

    /* renamed from: e, reason: collision with root package name */
    public final String f3472e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadApkWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Cursor cursor;
        int i;
        context.getClass();
        workerParameters.getClass();
        Activity activity = c.f4875o;
        Context e10 = f.e(this.f3474a);
        this.f3474a = e10;
        this.f3475b = new g(e10, 20);
        int i6 = workerParameters.getInputData().getInt("downloadId", -1);
        if (i6 >= 0) {
            j5.g l10 = j5.g.D.l(this.f3474a);
            l10.b();
            r rVar = null;
            try {
                String[] strArr = {String.valueOf(i6)};
                SQLiteDatabase sQLiteDatabase = l10.f6673a;
                sQLiteDatabase.getClass();
                cursor = sQLiteDatabase.query("downloads", l10.f6677n, "id=?", strArr, null, null, null);
            } catch (Exception e11) {
                e = e11;
                cursor = null;
            }
            try {
                r i02 = cursor.moveToFirst() ? j5.g.i0(cursor) : null;
                cursor.close();
                if (i02 != null && (i = i02.f11354a) >= 0) {
                    i02.F = l10.N(i);
                }
                rVar = i02;
            } catch (Exception e12) {
                e = e12;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                this.f3477d = rVar;
                l10.c();
                this.f3472e = workerParameters.getInputData().getString("url");
            }
            this.f3477d = rVar;
            l10.c();
        }
        this.f3472e = workerParameters.getInputData().getString("url");
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void A() {
        b.h();
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void B(r rVar) {
        rVar.getClass();
        o0 o0Var = b.f193a;
        b.i(g0.f11198a);
        b.f195c.n(new w(rVar));
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void C(int i, r rVar) {
        rVar.getClass();
        g0 g0Var = g0.f11198a;
        switch (i) {
            case 199:
                o0 o0Var = b.f193a;
                b.f195c.n(new y(rVar));
                break;
            case 200:
                o0 o0Var2 = b.f193a;
                b.i(new f0(rVar));
                b.f195c.n(new c0(rVar));
                break;
            case 201:
                o0 o0Var3 = b.f193a;
                b.i(new f0(rVar));
                b.f195c.n(new b0(rVar));
                break;
            case 202:
                b.i(g0Var);
                b.f195c.n(new x(rVar));
                break;
            case 205:
                o0 o0Var4 = b.f193a;
                b.f195c.n(new v(rVar));
                break;
            case 206:
                o0 o0Var5 = b.f193a;
                b.f195c.n(new u(rVar));
                break;
            case 207:
                o0 o0Var6 = b.f193a;
                b.f195c.n(new t(rVar));
                break;
            case 208:
                b.i(g0Var);
                b.f195c.n(a0.f11041a);
                break;
            case 211:
                o0 o0Var7 = b.f193a;
                b.i(new h0(rVar));
                break;
        }
    }

    public final void D() {
        k kVar = UptodownApp.f3293g0;
        if (kVar == null || this.f3477d == null || kVar.f11251e <= -1) {
            return;
        }
        kVar.getClass();
        int i = kVar.f11250d;
        r rVar = this.f3477d;
        rVar.getClass();
        if (i == rVar.f11354a) {
            j5.v vVar = new j5.v(this.f3474a);
            k kVar2 = UptodownApp.f3293g0;
            kVar2.getClass();
            String h = a4.x.h(kVar2.f11251e, "/eapi/deep-link-hash/");
            g2 k5 = vVar.k("https://www.uptodown.app:443".concat(h), null, "DELETE", false);
            k5.f11206d = vVar.i(k5, h);
            k kVar3 = UptodownApp.f3293g0;
            if (kVar3 != null) {
                kVar3.f11251e = -1L;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00e2  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(x4.r r31) {
        /*
            Method dump skipped, instructions count: 2005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadApkWorker.E(x4.r):void");
    }

    public final void F(r rVar, String str) {
        if (rVar != null) {
            rVar.l(this.f3474a);
            B(rVar);
        }
        o.i(this.f3474a, rVar, str);
    }

    @Override // com.uptodown.workers.DownloadWorker, androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        long j;
        File externalFilesDir;
        r rVar;
        File externalFilesDir2;
        File externalFilesDir3;
        b.a();
        boolean z9 = false;
        String str = this.f3472e;
        if (str != null) {
            this.f3476c = null;
            b.a();
            if (z3.f2928c) {
                long currentTimeMillis = System.currentTimeMillis();
                r(k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start"), new URL(str).getHost(), null);
                HttpsURLConnection z10 = z(str, currentTimeMillis, null);
                if (z10 != null) {
                    this.f3476c = z10.getURL().getHost();
                    String url = z10.getURL().toString();
                    url.getClass();
                    String substring = url.substring(m.A0("/", url, 6) + 1);
                    if (m.y0(substring, ".", 0, false, 6) < 0) {
                        String url2 = z10.getURL().toString();
                        url2.getClass();
                        substring = substring.concat(DownloadWorker.n(url2));
                    }
                    if (substring.length() <= 0 || (rVar = this.f3477d) == null) {
                        j = 0;
                    } else if (rVar.F.isEmpty()) {
                        Context context = this.f3474a;
                        context.getClass();
                        a aVar = new a(context);
                        if (aVar.d()) {
                            j = 0;
                            File[] externalFilesDirs = context.getExternalFilesDirs(null);
                            if (externalFilesDirs.length > 1) {
                                externalFilesDir3 = externalFilesDirs[1];
                            } else {
                                externalFilesDir3 = context.getExternalFilesDir(null);
                                aVar.g();
                                aVar.f();
                            }
                        } else {
                            j = 0;
                            externalFilesDir3 = context.getExternalFilesDir(null);
                        }
                        File file = new File(externalFilesDir3, "Apps");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(file, substring);
                        j0 j0Var = new j0();
                        j0Var.f11240q = file2.getAbsolutePath();
                        j0Var.f11237n = DownloadWorker.m(z10);
                        j5.g l10 = j5.g.D.l(this.f3474a);
                        l10.b();
                        this.f3477d.getClass();
                        l10.c0(j0Var, r8.f11354a);
                        l10.c();
                        r rVar2 = this.f3477d;
                        rVar2.getClass();
                        rVar2.F.add(j0Var);
                    } else {
                        j = 0;
                        r rVar3 = this.f3477d;
                        rVar3.getClass();
                        if (((j0) rVar3.F.get(0)).f11240q == null) {
                            Context context2 = this.f3474a;
                            context2.getClass();
                            a aVar2 = new a(context2);
                            if (aVar2.d()) {
                                File[] externalFilesDirs2 = context2.getExternalFilesDirs(null);
                                if (externalFilesDirs2.length > 1) {
                                    externalFilesDir2 = externalFilesDirs2[1];
                                } else {
                                    externalFilesDir2 = context2.getExternalFilesDir(null);
                                    aVar2.g();
                                    aVar2.f();
                                }
                            } else {
                                externalFilesDir2 = context2.getExternalFilesDir(null);
                            }
                            File file3 = new File(externalFilesDir2, "Apps");
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                            File file4 = new File(file3, substring);
                            r rVar4 = this.f3477d;
                            rVar4.getClass();
                            ((j0) rVar4.F.get(0)).f11240q = file4.getAbsolutePath();
                            j5.g l11 = j5.g.D.l(this.f3474a);
                            l11.b();
                            r rVar5 = this.f3477d;
                            rVar5.getClass();
                            Object obj = rVar5.F.get(0);
                            obj.getClass();
                            l11.r0((j0) obj);
                            l11.c();
                        }
                    }
                    Context context3 = this.f3474a;
                    context3.getClass();
                    a aVar3 = new a(context3);
                    if (aVar3.d()) {
                        File[] externalFilesDirs3 = context3.getExternalFilesDirs(null);
                        if (externalFilesDirs3.length > 1) {
                            externalFilesDir = externalFilesDirs3[1];
                        } else {
                            externalFilesDir = context3.getExternalFilesDir(null);
                            aVar3.g();
                            aVar3.f();
                        }
                    } else {
                        externalFilesDir = context3.getExternalFilesDir(null);
                    }
                    File file5 = new File(externalFilesDir, "Apps");
                    if (!file5.exists()) {
                        file5.mkdirs();
                    }
                    if (file5.exists() || file5.mkdirs()) {
                        r rVar6 = this.f3477d;
                        rVar6.getClass();
                        String str2 = ((j0) rVar6.F.get(0)).f11240q;
                        str2.getClass();
                        File file6 = new File(str2);
                        if (p()) {
                            r rVar7 = this.f3477d;
                            rVar7.getClass();
                            h(currentTimeMillis, (j0) rVar7.F.get(0), 207);
                        } else if (v(z10, currentTimeMillis)) {
                            r rVar8 = this.f3477d;
                            rVar8.getClass();
                            long length = ((j0) rVar8.F.get(0)).f11237n - file6.length();
                            if (length >= j) {
                                if (a.a.F(this.f3474a, file5) < length * 2.25d) {
                                    z10.disconnect();
                                    r rVar9 = this.f3477d;
                                    if (rVar9 != null) {
                                        rVar9.t(this.f3474a);
                                    }
                                    j(k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "error", "no_enough_space"), " (112)", currentTimeMillis);
                                } else {
                                    r rVar10 = this.f3477d;
                                    rVar10.getClass();
                                    C(200, rVar10);
                                    D();
                                    r rVar11 = this.f3477d;
                                    rVar11.getClass();
                                    if (rVar11.f11361q > j) {
                                        j5.g l12 = j5.g.D.l(this.f3474a);
                                        l12.b();
                                        r rVar12 = this.f3477d;
                                        rVar12.getClass();
                                        k0 O = l12.O(rVar12.f11361q);
                                        if (O != null) {
                                            O.a(this.f3474a, "downloadStarted");
                                        }
                                        l12.c();
                                    }
                                    kotlin.jvm.internal.w wVar = new kotlin.jvm.internal.w();
                                    kotlin.jvm.internal.w wVar2 = new kotlin.jvm.internal.w();
                                    b5.m mVar = new b5.m(wVar, wVar2, this, 18);
                                    r rVar13 = this.f3477d;
                                    rVar13.getClass();
                                    r rVar14 = this.f3477d;
                                    rVar14.getClass();
                                    Object obj2 = rVar14.F.get(0);
                                    obj2.getClass();
                                    String str3 = this.f3476c;
                                    str3.getClass();
                                    long k5 = k(z10, file6, rVar13, (j0) obj2, str3, currentTimeMillis, mVar);
                                    if (k5 >= j && !isStopped()) {
                                        boolean p10 = p();
                                        r rVar15 = this.f3477d;
                                        if (p10) {
                                            rVar15.getClass();
                                            h(currentTimeMillis, (j0) rVar15.F.get(0), 207);
                                        } else {
                                            if (rVar15 != null) {
                                                rVar15.f11357m = 0;
                                                j5.g l13 = j5.g.D.l(this.f3474a);
                                                l13.b();
                                                r rVar16 = this.f3477d;
                                                rVar16.getClass();
                                                l13.q0(rVar16);
                                                l13.c();
                                            }
                                            r rVar17 = this.f3477d;
                                            if (rVar17 != null && rVar17.f11361q > j) {
                                                j5.g l14 = j5.g.D.l(this.f3474a);
                                                l14.b();
                                                r rVar18 = this.f3477d;
                                                rVar18.getClass();
                                                k0 O2 = l14.O(rVar18.f11361q);
                                                if (O2 != null) {
                                                    O2.a(this.f3474a, "downloadFinished");
                                                }
                                                l14.c();
                                            }
                                            s(wVar.f7023a, currentTimeMillis, wVar2.f7023a, k5, null);
                                            Context context4 = this.f3474a;
                                            context4.getClass();
                                            try {
                                                SharedPreferences sharedPreferences = context4.getSharedPreferences("CoreSettings", 0);
                                                if (sharedPreferences.contains("install_apk_as_root_system")) {
                                                    z9 = sharedPreferences.getBoolean("install_apk_as_root_system", false);
                                                }
                                            } catch (Exception unused) {
                                            }
                                            if (z9) {
                                                float f = UptodownApp.I;
                                                d.r(this.f3474a, file6);
                                            }
                                            r rVar19 = this.f3477d;
                                            if (rVar19 != null) {
                                                if (rVar19.B == 1) {
                                                    Context context5 = this.f3474a;
                                                    String str4 = rVar19.f11355b;
                                                    rVar19.getClass();
                                                    long j6 = rVar19.f11358n;
                                                    context5.getClass();
                                                    if (str4 != null && str4.length() != 0) {
                                                        e eVar = m0.f8288a;
                                                        o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new c1(context5, str4, j6, null, 3), 3);
                                                    }
                                                }
                                                r rVar20 = this.f3477d;
                                                rVar20.getClass();
                                                C(202, rVar20);
                                            }
                                            Context context6 = this.f3474a;
                                            context6.getClass();
                                            Object systemService = context6.getSystemService("notification");
                                            systemService.getClass();
                                            ((NotificationManager) systemService).cancel(261);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        j(k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "error", "cant_mkdir"), " (106)", currentTimeMillis);
                    }
                }
            } else {
                b.f195c.n(z.f11477a);
            }
        } else {
            r rVar21 = this.f3477d;
            if (rVar21 == null) {
                F(null, " (100)");
            } else {
                boolean isEmpty = rVar21.F.isEmpty();
                r rVar22 = this.f3477d;
                if (isEmpty) {
                    F(rVar22, " (114)");
                } else {
                    rVar22.getClass();
                    long j10 = ((j0) rVar22.F.get(0)).f11235l;
                    r rVar23 = this.f3477d;
                    if (j10 < 0) {
                        F(rVar23, " (103)");
                    } else {
                        rVar23.getClass();
                        long j11 = rVar23.f11361q;
                        r rVar24 = this.f3477d;
                        if (j11 == -1) {
                            F(rVar24, " (113)");
                        } else {
                            rVar24.getClass();
                            E(rVar24);
                        }
                    }
                }
            }
        }
        o0 o0Var = b.f193a;
        b.i(g0.f11198a);
        b.f195c.n(s.f11382a);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        success.getClass();
        return success;
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void j(Bundle bundle, String str, long j) {
        F(this.f3477d, str);
        if (j > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j) / 1000);
        }
        d(bundle, null);
        g gVar = this.f3475b;
        if (gVar != null) {
            gVar.E(bundle, "download");
        }
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final boolean p() {
        return b.f194b.f8972a.getValue() instanceof e0;
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final boolean q() {
        return b.f194b.f8972a.getValue() instanceof h0;
    }
}
