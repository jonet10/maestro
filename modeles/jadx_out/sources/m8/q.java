package m8;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import b2.t1;
import c4.k0;
import com.google.android.material.card.MaterialCardViewHelper;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import g4.h0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import t4.n0;
import u4.z1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class q implements w4.g, t.b, ViewBinding, a4.i, j1.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7779a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7780b;

    /* renamed from: l, reason: collision with root package name */
    public Object f7781l;

    public q(q qVar) {
        this.f7779a = 20;
        Context context = (Context) qVar.f7780b;
        int d10 = y1.g.d(context, "com.google.firebase.crashlytics.unity_version", TypedValues.Custom.S_STRING);
        if (d10 != 0) {
            this.f7780b = "Unity";
            String string = context.getResources().getString(d10);
            this.f7781l = string;
            String j = a4.x.j("Unity Editor version is: ", string);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", j, null);
                return;
            }
            return;
        }
        if (context.getAssets() != null) {
            try {
                InputStream open = context.getAssets().open("flutter_assets/NOTICES.Z");
                if (open != null) {
                    open.close();
                }
                this.f7780b = "Flutter";
                this.f7781l = null;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Development platform is: Flutter", null);
                    return;
                }
                return;
            } catch (IOException unused) {
            }
        }
        this.f7780b = null;
        this.f7781l = null;
    }

    public static final void a(q qVar, File file) {
        long j;
        Activity activity = (Activity) qVar.f7780b;
        h0 h0Var = (h0) qVar.f7781l;
        try {
            try {
                PackageManager packageManager = activity.getPackageManager();
                packageManager.getClass();
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                PackageInfo d10 = n4.i.d(packageManager, absolutePath, 128);
                if ((d10 != null ? d10.applicationInfo : null) == null) {
                    if (h0Var != null) {
                        String name = file.getName();
                        name.getClass();
                        h0Var.f5190a.M(name.concat(" could not be parsed."));
                    }
                    if (f4.c.f4881u != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("fileName", file.getName());
                        z4.d dVar = f4.c.f4881u;
                        if (dVar != null) {
                            dVar.send(353, bundle);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ApplicationInfo applicationInfo = d10.applicationInfo;
                applicationInfo.getClass();
                String str = applicationInfo.packageName;
                long d11 = n4.d.d(d10);
                int i = 0;
                try {
                    PackageManager packageManager2 = activity.getPackageManager();
                    packageManager2.getClass();
                    str.getClass();
                    if (n4.d.d(n4.i.e(packageManager2, str, 0)) > d11) {
                        if (h0Var != null) {
                            file.getName().getClass();
                            h0Var.f5190a.M("invalid version code");
                        }
                        if (f4.c.f4881u != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("packageName", str);
                            bundle2.putLong("versionCode", d11);
                            z4.d dVar2 = f4.c.f4881u;
                            if (dVar2 != null) {
                                dVar2.send(353, bundle2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (h0Var != null) {
                    file.getName().getClass();
                    InstallerActivity installerActivity = h0Var.f5190a;
                    installerActivity.runOnUiThread(new g4.e0(installerActivity, i));
                }
                if (f4.c.f4881u != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("packageName", str);
                    bundle3.putLong("versionCode", d11);
                    z4.d dVar3 = f4.c.f4881u;
                    if (dVar3 != null) {
                        dVar3.send(351, bundle3);
                    }
                }
                ApplicationInfo applicationInfo2 = d10.applicationInfo;
                applicationInfo2.getClass();
                String absolutePath2 = file.getAbsolutePath();
                absolutePath2.getClass();
                applicationInfo2.sourceDir = absolutePath2;
                applicationInfo2.publicSourceDir = absolutePath2;
                String obj = packageManager.getApplicationLabel(applicationInfo2).toString();
                long d12 = n4.d.d(d10);
                String absolutePath3 = file.getAbsolutePath();
                absolutePath3.getClass();
                try {
                    j = new File(absolutePath3).length();
                } catch (Exception unused2) {
                    j = -1;
                }
                long j6 = j;
                f4.a aVar = f4.a.f4869a;
                String str2 = d10.packageName;
                str2.getClass();
                aVar.d(d12, j6, str2, obj);
                packageManager.getClass().getMethod("installPackage", (Class[]) Arrays.copyOf(new Class[]{Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class}, 4)).invoke(packageManager, Uri.fromFile(file), new n4.n(qVar), 2, null);
            } catch (Error e10) {
                f4.a.f4869a.a();
                if (h0Var != null) {
                    file.getName().getClass();
                    String message = e10.getMessage();
                    InstallerActivity installerActivity2 = h0Var.f5190a;
                    if (message != null) {
                        installerActivity2.M(message);
                    } else {
                        String string = installerActivity2.getString(2131952007);
                        string.getClass();
                        installerActivity2.M(string);
                    }
                }
                if (f4.c.f4881u != null) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("fileName", file.getName());
                    z4.d dVar4 = f4.c.f4881u;
                    if (dVar4 != null) {
                        dVar4.send(353, bundle4);
                    }
                }
            }
        } catch (Exception e11) {
            f4.a.f4869a.a();
            if (h0Var != null) {
                file.getName().getClass();
                String message2 = e11.getMessage();
                InstallerActivity installerActivity3 = h0Var.f5190a;
                if (message2 != null) {
                    installerActivity3.M(message2);
                } else {
                    String string2 = installerActivity3.getString(2131952007);
                    string2.getClass();
                    installerActivity3.M(string2);
                }
            }
            if (f4.c.f4881u != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putString("fileName", file.getName());
                z4.d dVar5 = f4.c.f4881u;
                if (dVar5 != null) {
                    dVar5.send(353, bundle5);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m8.q b(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L29 java.lang.Error -> L2c java.io.IOException -> L2e
            m8.q r2 = new m8.q     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            r3 = 8
            r2.<init>(r3, r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            return r2
        L23:
            r2 = move-exception
            goto L38
        L25:
            r2 = move-exception
            goto L38
        L27:
            r2 = move-exception
            goto L38
        L29:
            r2 = move-exception
        L2a:
            r0 = r1
            goto L38
        L2c:
            r2 = move-exception
            goto L2a
        L2e:
            r2 = move-exception
            goto L2a
        L30:
            r2 = move-exception
        L31:
            r5 = r1
            r0 = r5
            goto L38
        L34:
            r2 = move-exception
            goto L31
        L36:
            r2 = move-exception
            goto L31
        L38:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L44
            r0.release()     // Catch: java.io.IOException -> L44
        L44:
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L49
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.q.b(android.content.Context):m8.q");
    }

    public static q c(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364171);
        if (textView != null) {
            return new q(14, (RelativeLayout) view, textView);
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(2131364171)));
        return null;
    }

    public static boolean m(c0 c0Var, a0 a0Var) {
        int i = c0Var.f7694l;
        if (i != 200 && i != 410 && i != 414 && i != 501 && i != 203 && i != 204) {
            if (i != 307) {
                if (i != 308 && i != 404 && i != 405) {
                    switch (i) {
                        case MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION /* 300 */:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (c0Var.c("Expires") == null && c0Var.b().f7737c == -1 && !c0Var.b().f && !c0Var.b().f7739e) {
                return false;
            }
        }
        if (c0Var.b().f7736b) {
            return false;
        }
        i iVar = a0Var.f7677e;
        if (iVar == null) {
            iVar = i.a(a0Var.f7675c);
            a0Var.f7677e = iVar;
        }
        return !iVar.f7736b;
    }

    @Override // w4.g
    public void A(String str) {
        switch (this.f7779a) {
            case 2:
                ((k0) this.f7781l).N(str);
                break;
            case 17:
                u4.d dVar = (u4.d) this.f7780b;
                if (dVar.getActivity() instanceof k0) {
                    FragmentActivity activity = dVar.getActivity();
                    activity.getClass();
                    ((k0) activity).N(str);
                    break;
                }
                break;
            default:
                z1 z1Var = (z1) this.f7780b;
                if (z1Var.getActivity() instanceof k0) {
                    FragmentActivity activity2 = z1Var.getActivity();
                    activity2.getClass();
                    ((k0) activity2).N(str);
                    break;
                }
                break;
        }
    }

    public void d() {
        String str = (String) this.f7780b;
        try {
            e2.d dVar = (e2.d) this.f7781l;
            dVar.getClass();
            new File((File) dVar.f4468m, str).createNewFile();
        } catch (IOException e10) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e10);
        }
    }

    public synchronized void e(z zVar) {
        ((ArrayDeque) this.f7781l).add(zVar);
    }

    public void f(z zVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f7781l;
        synchronized (this) {
            try {
                if (!arrayDeque.remove(zVar)) {
                    throw new AssertionError("Call wasn't in-flight!");
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w4.g
    public void g(x4.r rVar) {
        switch (this.f7779a) {
            case 2:
                n5.d dVar = (n5.d) this.f7780b;
                File g = rVar.g();
                if (g != null) {
                    k0 k0Var = (k0) this.f7781l;
                    float f = UptodownApp.I;
                    b4.d.q(k0Var, null, g);
                    dVar.g();
                }
                android.support.v4.media.g gVar = dVar.f8071c;
                dVar.f8069a.getClass();
                ((d7.a) gVar.f247b).invoke();
                break;
            case 17:
                u4.d dVar2 = (u4.d) this.f7780b;
                if (dVar2.getContext() != null) {
                    float f10 = UptodownApp.I;
                    File g3 = rVar.g();
                    g3.getClass();
                    Context requireContext = dVar2.requireContext();
                    requireContext.getClass();
                    b4.d.q(requireContext, null, g3);
                    break;
                }
                break;
            default:
                z1 z1Var = (z1) this.f7780b;
                if (z1Var.getContext() != null) {
                    float f11 = UptodownApp.I;
                    File g10 = rVar.g();
                    g10.getClass();
                    Context requireContext2 = z1Var.requireContext();
                    requireContext2.getClass();
                    b4.d.q(requireContext2, null, g10);
                    break;
                }
                break;
        }
    }

    @Override // m6.a
    public Object get() {
        switch (this.f7779a) {
            case 6:
                return new s.d((Context) ((g5.f) this.f7780b).f5309b, (b5.m) ((g5.g) this.f7781l).get());
            default:
                q2.e eVar = new q2.e(2);
                q2.e eVar2 = new q2.e(1);
                Object obj = ((m6.a) this.f7780b).get();
                m6.a aVar = (m6.a) this.f7781l;
                return new y.h(eVar, eVar2, y.a.f, (y.j) obj, aVar);
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f7779a) {
            case 9:
                return (RelativeLayout) this.f7780b;
            case 10:
                return (LinearLayout) this.f7780b;
            case 11:
                return (LinearLayout) this.f7780b;
            case 12:
                return (TextView) this.f7780b;
            case 13:
                return (LinearLayout) this.f7780b;
            default:
                return (RelativeLayout) this.f7780b;
        }
    }

    @Override // a4.i
    public void h(Exception exc) {
        exc.getClass();
        exc.printStackTrace();
        u4.f0 f0Var = (u4.f0) this.f7780b;
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        u4.f0.g(f0Var, bVar.T.f9652b, (Context) this.f7781l);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory i(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.q.i(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public File j() {
        if (((File) this.f7780b) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f7780b) == null) {
                        n1.f fVar = (n1.f) this.f7781l;
                        fVar.a();
                        this.f7780b = new File(fVar.f7908a.getFilesDir(), "PersistedInstallation." + ((n1.f) this.f7781l).d() + ".json");
                    }
                } finally {
                }
            }
        }
        return (File) this.f7780b;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(int r5, v6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof s4.t
            if (r0 == 0) goto L13
            r0 = r6
            s4.t r0 = (s4.t) r0
            int r1 = r0.f9293l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9293l = r1
            goto L18
        L13:
            s4.t r0 = new s4.t
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f9291a
            int r1 = r0.f9293l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r6)
            goto L43
        L26:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return r2
        L2c:
            p6.a.e(r6)
            v7.e r6 = o7.m0.f8288a
            v7.d r6 = v7.d.f10884a
            p9.c r1 = new p9.c
            r1.<init>(r4, r5, r2)
            r0.f9293l = r3
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r5 = u6.a.f10762a
            if (r6 != r5) goto L43
            return r5
        L43:
            p6.k r6 = (p6.k) r6
            java.lang.Object r5 = r6.f8444a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.q.k(int, v6.c):java.lang.Object");
    }

    public void l(u2.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.f10404a);
            jSONObject.put("Status", c.j.c(bVar.f10405b));
            jSONObject.put("AuthToken", bVar.f10406c);
            jSONObject.put("RefreshToken", bVar.f10407d);
            jSONObject.put("TokenCreationEpochInSecs", bVar.f);
            jSONObject.put("ExpiresInSecs", bVar.f10408e);
            jSONObject.put("FisError", bVar.g);
            n1.f fVar = (n1.f) this.f7781l;
            fVar.a();
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", fVar.f7908a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (createTempFile.renameTo(j())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public void n(int i, Bundle bundle) {
        Locale locale = Locale.US;
        String str = "Analytics listener received message. ID: " + i + ", Extras: " + bundle;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
        String string = bundle.getString("name");
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            w1.b bVar = "clx".equals(bundle2.getString("_o")) ? (n0) this.f7780b : (g5.g) this.f7781l;
            if (bVar == null) {
                return;
            }
            bVar.g(bundle2, string);
        }
    }

    public u2.b o() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(j());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("Fid", null);
        int optInt = jSONObject.optInt("Status", 0);
        String optString2 = jSONObject.optString("AuthToken", null);
        String optString3 = jSONObject.optString("RefreshToken", null);
        long optLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String optString4 = jSONObject.optString("FisError", null);
        int i = u2.b.h;
        byte b7 = (byte) (((byte) (0 | 2)) | 1);
        int i6 = c.j.e(5)[optInt];
        if (i6 == 0) {
            com.google.gson.internal.a.i("Null registrationStatus");
            return null;
        }
        byte b10 = (byte) (((byte) (b7 | 2)) | 1);
        if (b10 == 3 && i6 != 0) {
            return new u2.b(optString, i6, optString2, optString3, optLong2, optLong, optString4);
        }
        StringBuilder sb = new StringBuilder();
        if (i6 == 0) {
            sb.append(" registrationStatus");
        }
        if ((b10 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b10 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }

    @Override // a4.i
    public void onSuccess() {
        u4.f0 f0Var = (u4.f0) this.f7780b;
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        u4.f0.g(f0Var, bVar.T.f9652b, (Context) this.f7781l);
    }

    @Override // w4.g
    public void p(String str) {
        int i = this.f7779a;
        str.getClass();
        switch (i) {
            case 2:
                n5.d dVar = (n5.d) this.f7780b;
                k0 k0Var = (k0) this.f7781l;
                dVar.c(k0Var);
                j5.c.e(k0Var, str, null);
                break;
            case 17:
                u4.d dVar2 = (u4.d) this.f7780b;
                if (dVar2.getActivity() instanceof k0) {
                    FragmentActivity requireActivity = dVar2.requireActivity();
                    requireActivity.getClass();
                    j5.c.e((k0) requireActivity, str, null);
                    break;
                }
                break;
            default:
                z1 z1Var = (z1) this.f7780b;
                if (z1Var.getActivity() instanceof k0) {
                    FragmentActivity requireActivity2 = z1Var.requireActivity();
                    requireActivity2.getClass();
                    j5.c.e((k0) requireActivity2, str, null);
                    break;
                }
                break;
        }
    }

    @Override // j1.h
    public j1.p q(Object obj) {
        Boolean bool = (Boolean) obj;
        y1.l lVar = (y1.l) this.f7781l;
        if (bool.booleanValue()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
            }
            boolean booleanValue = bool.booleanValue();
            y1.t tVar = lVar.f11637b;
            if (booleanValue) {
                tVar.h.c(null);
                return ((j1.p) this.f7780b).j(lVar.f11640e.f11908a, new g5.g(this, 18));
            }
            tVar.getClass();
            androidx.privacysandbox.ads.adservices.customaudience.a.i("An invalid data collection token was used.");
            return null;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
        }
        e2.d dVar = lVar.g;
        Iterator it = e2.d.n(((File) dVar.f4468m).listFiles(y1.l.f11634r)).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        e2.d dVar2 = ((e2.b) lVar.f11643m.f4467l).f4461b;
        e2.b.a(e2.d.n(((File) dVar2.f4470o).listFiles()));
        e2.b.a(e2.d.n(((File) dVar2.f4471p).listFiles()));
        e2.b.a(e2.d.n(((File) dVar2.f4472q).listFiles()));
        lVar.f11647q.c(null);
        return t1.x(null);
    }

    public void r() {
        try {
            ((FileLock) this.f7781l).release();
            ((FileChannel) this.f7780b).close();
        } catch (IOException e10) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e10);
        }
    }

    public synchronized void s() {
        ((ArrayDeque) this.f7780b).size();
        ((ArrayDeque) this.f7781l).size();
    }

    @Override // w4.g
    public void u(x4.r rVar) {
        switch (this.f7779a) {
            case 2:
                n5.d dVar = (n5.d) this.f7780b;
                android.support.v4.media.g gVar = dVar.f8071c;
                dVar.f8069a.getClass();
                ((d7.a) gVar.f247b).invoke();
                break;
            case 17:
                ((u4.d) this.f7780b).a(((x4.g) this.f7781l).F);
                break;
            default:
                ((z1) this.f7780b).g(((x4.g) this.f7781l).F);
                break;
        }
    }

    public /* synthetic */ q(Context context, int i) {
        this.f7779a = i;
        this.f7781l = null;
        this.f7780b = context;
    }

    public q(f0.i iVar, q qVar) {
        this.f7779a = 4;
        this.f7781l = qVar;
        iVar.n(new q1.c(this, 0));
        this.f7780b = new HashSet();
    }

    public q(Context context, x4.g gVar) {
        this.f7779a = 7;
        gVar.getClass();
        this.f7780b = context;
        this.f7781l = gVar;
    }

    public q(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.f7779a = 11;
        this.f7780b = linearLayout;
        this.f7781l = editText;
    }

    public q(LinearLayout linearLayout, NumberPicker numberPicker, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f7779a = 10;
        this.f7780b = linearLayout;
        this.f7781l = numberPicker;
    }

    public q(int i) {
        this.f7779a = i;
        switch (i) {
            case 15:
                break;
            case 25:
                this.f7780b = new AtomicInteger();
                this.f7781l = new AtomicInteger();
                break;
            default:
                new ArrayDeque();
                this.f7780b = new ArrayDeque();
                this.f7781l = new ArrayDeque();
                break;
        }
    }

    public q(n1.f fVar) {
        this.f7779a = 16;
        this.f7781l = fVar;
    }

    public /* synthetic */ q(int i, Object obj, Object obj2) {
        this.f7779a = i;
        this.f7780b = obj;
        this.f7781l = obj2;
    }

    public q(y1.l lVar, j1.p pVar) {
        this.f7779a = 23;
        this.f7781l = lVar;
        this.f7780b = pVar;
    }
}
