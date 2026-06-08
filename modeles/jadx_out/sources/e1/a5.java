package e1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a5 extends e2 {

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f3771r = {"firebase_", "google_", "ga_"};

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f3772s = {"_err"};

    /* renamed from: l, reason: collision with root package name */
    public SecureRandom f3773l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicLong f3774m;

    /* renamed from: n, reason: collision with root package name */
    public int f3775n;

    /* renamed from: o, reason: collision with root package name */
    public MeasurementManagerFutures f3776o;

    /* renamed from: p, reason: collision with root package name */
    public Boolean f3777p;

    /* renamed from: q, reason: collision with root package name */
    public Integer f3778q;

    public a5(t1 t1Var) {
        super(t1Var);
        this.f3778q = null;
        this.f3774m = new AtomicLong(0L);
    }

    public static boolean A(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static int B() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static boolean D(String str) {
        String str2 = (String) f0.f3953s0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean F(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean G(String str, String[] strArr) {
        k0.y.g(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] L(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static ArrayList W(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", eVar.f3882a);
            bundle.putString("origin", eVar.f3883b);
            bundle.putLong("creation_timestamp", eVar.f3885m);
            bundle.putString("name", eVar.f3884l.f4402b);
            Object c9 = eVar.f3884l.c();
            k0.y.g(c9);
            k2.c(bundle, c9);
            bundle.putBoolean("active", eVar.f3886n);
            String str = eVar.f3887o;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            u uVar = eVar.f3888p;
            if (uVar != null) {
                bundle.putString("timed_out_event_name", uVar.f4289a);
                t tVar = uVar.f4290b;
                if (tVar != null) {
                    bundle.putBundle("timed_out_event_params", tVar.g());
                }
            }
            bundle.putLong("trigger_timeout", eVar.f3889q);
            u uVar2 = eVar.f3890r;
            if (uVar2 != null) {
                bundle.putString("triggered_event_name", uVar2.f4289a);
                t tVar2 = uVar2.f4290b;
                if (tVar2 != null) {
                    bundle.putBundle("triggered_event_params", tVar2.g());
                }
            }
            bundle.putLong("triggered_timestamp", eVar.f3884l.f4403l);
            bundle.putLong("time_to_live", eVar.f3891s);
            u uVar3 = eVar.f3892t;
            if (uVar3 != null) {
                bundle.putString("expired_event_name", uVar3.f4289a);
                t tVar3 = uVar3.f4290b;
                if (tVar3 != null) {
                    bundle.putBundle("expired_event_params", tVar3.g());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean X(Context context) {
        ActivityInfo receiverInfo;
        k0.y.g(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void Y(j3 j3Var, Bundle bundle, boolean z9) {
        if (bundle != null && j3Var != null) {
            if (!bundle.containsKey("_sc") || z9) {
                String str = j3Var.f4057a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = j3Var.f4058b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", j3Var.f4059c);
                return;
            }
            z9 = false;
        }
        if (bundle != null && j3Var == null && z9) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean a0(int i, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean f0(String str) {
        k0.y.d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static String l(int i, String str, boolean z9) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z9) {
            return str.substring(0, str.offsetByCodePoints(0, i)).concat("...");
        }
        return null;
    }

    public static boolean p0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static void w(z4 z4Var, String str, int i, String str2, String str3, int i6) {
        Bundle bundle = new Bundle();
        a0(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i6);
        }
        z4Var.a(str, "_err", bundle);
    }

    public static MessageDigest x() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long y(byte[] bArr) {
        k0.y.g(bArr);
        int length = bArr.length;
        if (length <= 0) {
            throw new IllegalStateException();
        }
        int i = 0;
        long j = 0;
        for (int i6 = length - 1; i6 >= 0 && i6 >= bArr.length - 8; i6--) {
            j += (bArr[i6] & 255) << i;
            i += 8;
        }
        return j;
    }

    public static boolean z(Context context) {
        k0.y.g(context);
        return Build.VERSION.SDK_INT >= 24 ? A(context, "com.google.android.gms.measurement.AppMeasurementJobService") : A(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long C() {
        /*
            r11 = this;
            r11.g()
            e1.t1 r0 = r11.f3875a
            e1.n0 r1 = r0.r()
            e1.w0 r2 = r0.f4264o
            java.lang.String r1 = r1.m()
            boolean r1 = D(r1)
            r3 = 0
            if (r1 != 0) goto L18
            return r3
        L18:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 0
            r6 = 30
            if (r1 >= r6) goto L22
            r6 = 4
            goto L42
        L22:
            int r1 = android.os.ext.SdkExtensions.getExtensionVersion(r6)
            r6 = 4
            if (r1 >= r6) goto L2c
            r6 = 8
            goto L42
        L2c:
            int r1 = B()
            e1.e0 r6 = e1.f0.f3942m0
            java.lang.Object r6 = r6.a(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r1 >= r6) goto L41
            r6 = 16
            goto L42
        L41:
            r6 = r3
        L42:
            java.lang.String r1 = "android.permission.ACCESS_ADSERVICES_ATTRIBUTION"
            boolean r1 = r11.E(r1)
            if (r1 != 0) goto L4d
            r8 = 2
            long r6 = r6 | r8
        L4d:
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 != 0) goto Lbd
            java.lang.Boolean r1 = r11.f3777p
            if (r1 != 0) goto Lb3
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r1 = r11.f3776o
            if (r1 != 0) goto L61
            android.content.Context r0 = r0.f4259a
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r0 = androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures.from(r0)
            r11.f3776o = r0
        L61:
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r0 = r11.f3776o
            r1 = 0
            if (r0 != 0) goto L67
            goto Lb9
        L67:
            m1.b r0 = r0.getMeasurementApiStatusAsync()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            r9 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r0 = r0.get(r9, r8)     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            if (r0 == 0) goto L88
            int r5 = r0.intValue()     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            r8 = 1
            if (r5 != r8) goto L88
            r1 = r8
            goto L88
        L80:
            r1 = move-exception
            goto L8f
        L82:
            r1 = move-exception
            goto L8f
        L84:
            r1 = move-exception
            goto L8f
        L86:
            r1 = move-exception
            goto L8f
        L88:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            r11.f3777p = r1     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            goto La9
        L8f:
            r5 = r0
            goto L9a
        L91:
            r0 = move-exception
        L92:
            r1 = r0
            goto L9a
        L94:
            r0 = move-exception
            goto L92
        L96:
            r0 = move-exception
            goto L92
        L98:
            r0 = move-exception
            goto L92
        L9a:
            e1.t1.m(r2)
            e1.u0 r0 = r2.f4342r
            java.lang.String r8 = "Measurement manager api exception"
            r0.c(r1, r8)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.f3777p = r0
            r0 = r5
        La9:
            e1.t1.m(r2)
            e1.u0 r1 = r2.f4346w
            java.lang.String r2 = "Measurement manager api status result"
            r1.c(r0, r2)
        Lb3:
            java.lang.Boolean r0 = r11.f3777p
            boolean r1 = r0.booleanValue()
        Lb9:
            if (r1 != 0) goto Lbd
            r6 = 64
        Lbd:
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto Lc4
            r0 = 1
            return r0
        Lc4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.a5.C():long");
    }

    public final boolean E(String str) {
        g();
        t1 t1Var = this.f3875a;
        if (r0.c.a(t1Var.f4259a).f8855a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.v.c(str, "Permission not granted");
        return false;
    }

    public final boolean H(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f3875a.f4262m.k("debug.firebase.analytics.app").equals(str);
    }

    public final Bundle I(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object n10 = n(bundle.get(str), str);
                if (n10 == null) {
                    t1 t1Var = this.f3875a;
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4344t.c(t1Var.f4268s.b(str), "Param value can't be null");
                } else {
                    v(n10, str, bundle2);
                }
            }
        }
        return bundle2;
    }

    public final u J(String str, Bundle bundle, String str2, long j, boolean z9) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (l0(str) != 0) {
            t1 t1Var = this.f3875a;
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(t1Var.f4268s.c(str), "Invalid conditional property event name");
            s1.o.n();
            return null;
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle o10 = o(str, bundle2, Collections.singletonList("_o"), true);
        if (z9) {
            o10 = I(o10);
        }
        k0.y.g(o10);
        return new u(str, new t(o10), str2, j);
    }

    public final boolean K(Context context, String str) {
        Signature[] signatureArr;
        t1 t1Var = this.f3875a;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b7 = r0.c.a(context).b(64, str);
            if (b7 == null || (signatureArr = b7.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(e10, "Package name not found");
            return true;
        } catch (CertificateException e11) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e11, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean M(int i) {
        Boolean bool = this.f3875a.p().f4360n;
        if (N() < i / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int N() {
        if (this.f3778q == null) {
            h0.f fVar = h0.f.f5409b;
            Context context = this.f3875a.f4259a;
            fVar.getClass();
            AtomicBoolean atomicBoolean = h0.g.f5410a;
            int i = 0;
            try {
                i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.f3778q = Integer.valueOf(i / 1000);
        }
        return this.f3778q.intValue();
    }

    public final void O(Bundle bundle, long j) {
        long j6 = bundle.getLong("_et");
        if (j6 != 0) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(Long.valueOf(j6), "Params already contained engagement");
        } else {
            j6 = 0;
        }
        bundle.putLong("_et", j + j6);
    }

    public final void P(String str, com.google.android.gms.internal.measurement.m0 m0Var) {
        try {
            m0Var.t(k0.k.e("r", str));
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning string value to wrapper");
        }
    }

    public final void Q(com.google.android.gms.internal.measurement.m0 m0Var, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning long value to wrapper");
        }
    }

    public final void R(com.google.android.gms.internal.measurement.m0 m0Var, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning int value to wrapper");
        }
    }

    public final void S(com.google.android.gms.internal.measurement.m0 m0Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning byte array to wrapper");
        }
    }

    public final void T(com.google.android.gms.internal.measurement.m0 m0Var, boolean z9) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z9);
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning boolean value to wrapper");
        }
    }

    public final void U(com.google.android.gms.internal.measurement.m0 m0Var, Bundle bundle) {
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning bundle value to wrapper");
        }
    }

    public final void V(com.google.android.gms.internal.measurement.m0 m0Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error returning bundle list to wrapper");
        }
    }

    public final String Z() {
        byte[] bArr = new byte[16];
        e0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object b0(int i, Object obj, boolean z9, boolean z10) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Long) {
            return obj;
        }
        if (obj instanceof Double) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return l(i, obj.toString(), z9);
        }
        if (!z10) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle I = I((Bundle) parcelable);
                if (!I.isEmpty()) {
                    arrayList.add(I);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int c0(String str) {
        boolean equals = "_ldl".equals(str);
        t1 t1Var = this.f3875a;
        if (equals) {
            t1Var.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            t1Var.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            t1Var.getClass();
            return 100;
        }
        t1Var.getClass();
        return 36;
    }

    public final long d0() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.f3774m;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f3774m;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long nanoTime = System.nanoTime();
            this.f3875a.f4269t.getClass();
            long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.f3775n + 1;
            this.f3775n = i;
            j = nextLong + i;
        }
        return j;
    }

    public final SecureRandom e0() {
        g();
        if (this.f3773l == null) {
            this.f3773l = new SecureRandom();
        }
        return this.f3773l;
    }

    public final Bundle g0(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("gbraid");
                str6 = uri.getQueryParameter("utm_id");
                str7 = uri.getQueryParameter("dclid");
                str8 = uri.getQueryParameter("srsltid");
                str9 = uri.getQueryParameter("sfmc_id");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str10 = "sfmc_id";
            } else {
                str10 = "sfmc_id";
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("term", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("content", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("aclid", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("cp1", queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("campaign_id", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("dclid", str7);
            }
            String queryParameter7 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("source_platform", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("creative_format", queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("marketing_tactic", queryParameter9);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("srsltid", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                bundle.putString(str10, str9);
            }
            for (String str11 : uri.getQueryParameterNames()) {
                if (str11.startsWith("gad_")) {
                    String queryParameter10 = uri.getQueryParameter(str11);
                    if (!TextUtils.isEmpty(queryParameter10)) {
                        bundle.putString(str11, queryParameter10);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    @Override // e1.e2
    public final boolean h() {
        return true;
    }

    public final boolean h0(String str, String str2) {
        t1 t1Var = this.f3875a;
        if (str2 == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4341q.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4341q.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            w0 w0Var3 = t1Var.f4264o;
            t1.m(w0Var3);
            w0Var3.f4341q.d(str, "Name must start with a letter. Type, name", str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                w0 w0Var4 = t1Var.f4264o;
                t1.m(w0Var4);
                w0Var4.f4341q.d(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean i0(String str, String str2) {
        t1 t1Var = this.f3875a;
        if (str2 == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4341q.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4341q.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt != 95) {
                w0 w0Var3 = t1Var.f4264o;
                t1.m(w0Var3);
                w0Var3.f4341q.d(str, "Name must start with a letter or _ (underscore). Type, name", str2);
                return false;
            }
            codePointAt = 95;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                w0 w0Var4 = t1Var.f4264o;
                t1.m(w0Var4);
                w0Var4.f4341q.d(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean j0(String str, String[] strArr, String[] strArr2, String str2) {
        t1 t1Var = this.f3875a;
        if (str2 == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4341q.c(str, "Name is required and can't be null. Type");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(f3771r[i])) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4341q.d(str, "Name starts with reserved prefix. Type, name", str2);
                return false;
            }
        }
        if (strArr == null || !G(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && G(str2, strArr2)) {
            return true;
        }
        w0 w0Var3 = t1Var.f4264o;
        t1.m(w0Var3);
        w0Var3.f4341q.d(str, "Name is reserved. Type, name", str2);
        return false;
    }

    public final boolean k(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        t1 t1Var = this.f3875a;
        if (isEmpty) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4341q.b("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        k0.y.g(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        w0 w0Var2 = t1Var.f4264o;
        t1.m(w0Var2);
        w0Var2.f4341q.c(w0.o(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
        return false;
    }

    public final boolean k0(int i, String str, String str2) {
        t1 t1Var = this.f3875a;
        if (str2 == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4341q.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        w0 w0Var2 = t1Var.f4264o;
        t1.m(w0Var2);
        w0Var2.f4341q.e("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final int l0(String str) {
        if (!i0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!j0(NotificationCompat.CATEGORY_EVENT, k2.f4072a, k2.f4073b, str)) {
            return 13;
        }
        this.f3875a.getClass();
        return !k0(40, NotificationCompat.CATEGORY_EVENT, str) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.a5.m(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int m0(String str) {
        if (!i0("user property", str)) {
            return 6;
        }
        if (!j0("user property", k2.i, null, str)) {
            return 15;
        }
        this.f3875a.getClass();
        return !k0(24, "user property", str) ? 6 : 0;
    }

    public final Object n(Object obj, String str) {
        boolean equals = "_ev".equals(str);
        int i = 500;
        t1 t1Var = this.f3875a;
        if (equals) {
            t1Var.f4262m.getClass();
            return b0(Math.max(500, 256), obj, true, true);
        }
        if (F(str)) {
            t1Var.f4262m.getClass();
            i = Math.max(500, 256);
        } else {
            t1Var.f4262m.getClass();
        }
        return b0(i, obj, false, true);
    }

    public final int n0(String str) {
        if (!h0("event param", str)) {
            return 3;
        }
        if (!j0("event param", null, null, str)) {
            return 14;
        }
        this.f3875a.getClass();
        return !k0(40, "event param", str) ? 3 : 0;
    }

    public final Bundle o(String str, Bundle bundle, List list, boolean z9) {
        int n0;
        String str2;
        List list2 = list;
        boolean G = G(str, k2.f4075d);
        String str3 = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        t1 t1Var = this.f3875a;
        g gVar = t1Var.f4262m;
        q0 q0Var = t1Var.f4268s;
        a5 a5Var = gVar.f3875a.f4267r;
        t1.k(a5Var);
        int i = a5Var.M(201500000) ? 100 : 25;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i6 = 0;
        boolean z10 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                n0 = !z9 ? n0(str4) : 0;
                if (n0 == 0) {
                    n0 = o0(str4);
                }
            } else {
                n0 = 0;
            }
            if (n0 != 0) {
                s(bundle2, n0, str4, n0 == 3 ? str4 : str3);
                bundle2.remove(str4);
            } else {
                int m10 = m(str, str4, bundle.get(str4), bundle2, list2, z9, G);
                if (m10 == 17) {
                    s(bundle2, 17, str4, Boolean.FALSE);
                } else if (m10 != 0 && !"_ev".equals(str4)) {
                    s(bundle2, m10, m10 == 21 ? str : str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (f0(str4)) {
                    i6++;
                    if (i6 > i) {
                        if (t1Var.f4262m.q(str3, f0.f3926f1) && z10) {
                            str2 = str3;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(i);
                            sb.append(" params");
                            String sb2 = sb.toString();
                            w0 w0Var = t1Var.f4264o;
                            t1.m(w0Var);
                            str2 = str3;
                            w0Var.f4341q.d(q0Var.a(str), sb2, q0Var.e(bundle));
                        }
                        a0(5, bundle2);
                        bundle2.remove(str4);
                        z10 = true;
                        list2 = list;
                        str3 = str2;
                    } else {
                        list2 = list;
                    }
                }
            }
            str2 = str3;
            list2 = list;
            str3 = str2;
        }
        return bundle2;
    }

    public final int o0(String str) {
        if (!i0("event param", str)) {
            return 3;
        }
        if (!j0("event param", null, null, str)) {
            return 14;
        }
        this.f3875a.getClass();
        return !k0(40, "event param", str) ? 3 : 0;
    }

    public final void p(x0 x0Var, int i) {
        Bundle bundle = (Bundle) x0Var.f4391e;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i6 = 0;
        boolean z9 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (f0(str) && (i6 = i6 + 1) > i) {
                t1 t1Var = this.f3875a;
                g gVar = t1Var.f4262m;
                q0 q0Var = t1Var.f4268s;
                if (!gVar.q(null, f0.f3926f1) || !z9) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    String sb2 = sb.toString();
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4341q.d(q0Var.a((String) x0Var.f4389c), sb2, q0Var.e(bundle));
                    a0(5, bundle);
                }
                bundle.remove(str);
                z9 = true;
            }
        }
    }

    public final void q(Parcelable[] parcelableArr, int i) {
        k0.y.g(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i6 = 0;
            boolean z9 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (f0(str) && !G(str, k2.h) && (i6 = i6 + 1) > i) {
                    t1 t1Var = this.f3875a;
                    g gVar = t1Var.f4262m;
                    q0 q0Var = t1Var.f4268s;
                    if (!gVar.q(null, f0.f3926f1) || !z9) {
                        w0 w0Var = t1Var.f4264o;
                        t1.m(w0Var);
                        u0 u0Var = w0Var.f4341q;
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        u0Var.d(q0Var.b(str), sb.toString(), q0Var.e(bundle));
                    }
                    a0(28, bundle);
                    bundle.remove(str);
                    z9 = true;
                }
            }
        }
    }

    public final boolean q0(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String obj2 = obj.toString();
        if (obj2.codePointCount(0, obj2.length()) > i) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4344t.e("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
            return false;
        }
        return true;
    }

    public final void r(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                a5 a5Var = this.f3875a.f4267r;
                t1.k(a5Var);
                a5Var.v(bundle2.get(str), str, bundle);
            }
        }
    }

    public final void r0(String str, String str2, Bundle bundle, List list, boolean z9) {
        int n0;
        String str3;
        int m10;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        t1 t1Var = this.f3875a;
        g gVar = t1Var.f4262m;
        w0 w0Var = t1Var.f4264o;
        q0 q0Var = t1Var.f4268s;
        a5 a5Var = gVar.f3875a.f4267r;
        t1.k(a5Var);
        int i = true != a5Var.M(231100000) ? 0 : 35;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i6 = 0;
        boolean z10 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                n0 = !z9 ? n0(str4) : 0;
                if (n0 == 0) {
                    n0 = o0(str4);
                }
            } else {
                n0 = 0;
            }
            if (n0 != 0) {
                s(bundle, n0, str4, n0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (p0(bundle.get(str4))) {
                    t1.m(w0Var);
                    w0Var.f4344t.e("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    m10 = 22;
                    str3 = null;
                } else {
                    str3 = null;
                    m10 = m(str, str4, bundle.get(str4), bundle, list2, z9, false);
                }
                if (m10 != 0 && !"_ev".equals(str4)) {
                    s(bundle, m10, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (f0(str4) && !G(str4, k2.h)) {
                    int i10 = i6 + 1;
                    if (!M(231100000)) {
                        t1.m(w0Var);
                        w0Var.f4341q.d(q0Var.a(str), "Item array not supported on client's version of Google Play Services (Android Only)", q0Var.e(bundle));
                        a0(23, bundle);
                        bundle.remove(str4);
                    } else if (i10 > i) {
                        if (!t1Var.f4262m.q(str3, f0.f3926f1) || !z10) {
                            t1.m(w0Var);
                            u0 u0Var = w0Var.f4341q;
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i);
                            sb.append(" item-scoped custom params");
                            u0Var.d(q0Var.a(str), sb.toString(), q0Var.e(bundle));
                        }
                        a0(28, bundle);
                        bundle.remove(str4);
                        list2 = list;
                        i6 = i10;
                        z10 = true;
                    }
                    list2 = list;
                    i6 = i10;
                }
            }
            list2 = list;
        }
    }

    public final void s(Bundle bundle, int i, String str, Object obj) {
        if (a0(i, bundle)) {
            this.f3875a.getClass();
            bundle.putString("_ev", l(40, str, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int t(Object obj, String str) {
        return "_ldl".equals(str) ? q0("user property referrer", str, c0(str), obj) : q0("user property", str, c0(str), obj) ? 0 : 7;
    }

    public final Object u(Object obj, String str) {
        return "_ldl".equals(str) ? b0(c0(str), obj, true, false) : b0(c0(str), obj, false, false);
    }

    public final void v(Object obj, String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            t1 t1Var = this.f3875a;
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4344t.d(t1Var.f4268s.b(str), "Not putting event parameter. Invalid value type. name, type", simpleName);
        }
    }
}
