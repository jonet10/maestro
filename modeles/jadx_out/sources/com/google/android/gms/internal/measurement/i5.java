package com.google.android.gms.internal.measurement;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.inmobi.cmp.core.model.Vector;
import com.uptodown.activities.MyApps;
import com.uptodown.util.views.UsernameTextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i5 {
    public static x4.r1 A(Context context) {
        context.getClass();
        x4.r1 r1Var = new x4.r1();
        r1Var.f11371a = -1L;
        r1Var.f11373c = -1;
        r1Var.f11371a = z3.t(-1L, context, "fcm_app_id");
        r1Var.f11372b = z3.y(context, "fcm_packagename");
        r1Var.f11373c = z3.s(context, -1, "fcm_download_id");
        r1Var.f11374d = z3.t(-1L, context, "fcm_received_timestamp");
        r1Var.f11375e = z3.t(-1L, context, "fcm_shown_timestamp");
        if (r1Var.f11371a <= -1 || r1Var.f11372b == null) {
            r1Var = null;
        }
        if (r1Var != null) {
            if (r1Var.f11371a > -1 && r1Var.f11372b != null) {
                long j = r1Var.f11374d;
                if (j > 0 && j + 86400000 > System.currentTimeMillis()) {
                    return r1Var;
                }
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove("fcm_app_id");
            edit.remove("fcm_packagename");
            edit.remove("fcm_download_id");
            edit.remove("fcm_received_timestamp");
            edit.remove("fcm_shown_timestamp");
            edit.apply();
        }
        return null;
    }

    public static void B(String str) {
        str.equals("");
    }

    public static void C(String str) {
        if (str != null) {
            str.equals("");
        }
    }

    public static String D(long j) {
        return j < 1000 ? String.valueOf(j) : j < 1000000 ? String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j / 1000)}, 1)).concat("K") : String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(j / 1000000)}, 1)).concat("M");
    }

    public static final long E(String str) {
        char charAt;
        int length = str.length();
        int i = (length <= 0 || !l7.m.r0("+-", str.charAt(0))) ? 0 : 1;
        if (length - i > 16) {
            int i6 = i;
            while (true) {
                if (i < length) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 != '0') {
                        if ('1' > charAt2 || charAt2 >= ':') {
                            break;
                        }
                    } else if (i6 == i) {
                        i6++;
                    }
                    i++;
                } else if (length - i6 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return LocationRequestCompat.PASSIVE_INTERVAL;
                }
            }
        }
        return (!l7.u.p0(str, "+", false) || length <= 1 || '0' > (charAt = str.charAt(1)) || charAt >= ':') ? Long.parseLong(str) : Long.parseLong(l7.m.t0(1, str));
    }

    public static void F(UsernameTextView usernameTextView) {
        usernameTextView.getClass();
        ValueAnimator valueAnimator = usernameTextView.f3453a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        usernameTextView.f3453a = null;
        usernameTextView.f3454b = 0.0f;
        usernameTextView.f3455l = null;
        usernameTextView.f3456m = Integer.valueOf(ContextCompat.getColor(usernameTextView.getContext(), 2131100790));
        usernameTextView.f3457n = 0L;
        usernameTextView.f3458o = 0L;
        int i = UsernameTextView.f3452s;
        usernameTextView.setTurbo(false);
        usernameTextView.setUsernameFormat(null);
        usernameTextView.getPaint().setShader(null);
        Handler animationHandler = usernameTextView.getAnimationHandler();
        if (animationHandler != null) {
            animationHandler.removeCallbacksAndMessages(null);
        }
        usernameTextView.setAnimationHandler(new Handler(Looper.getMainLooper()));
        Integer num = usernameTextView.f3456m;
        num.getClass();
        usernameTextView.setTextColor(num.intValue());
        usernameTextView.invalidate();
    }

    public static String G(long j) {
        double d10 = j / 1024.0d;
        if (d10 < 1024.0d) {
            return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1)).concat(" KB");
        }
        double d11 = 1024;
        double d12 = d10 / d11;
        return d12 < 1024.0d ? String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d12)}, 1)).concat(" MB") : String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d12 / d11)}, 1)).concat(" GB");
    }

    public static String H(Context context, long j) {
        context.getClass();
        double d10 = j / 1024.0d;
        if (d10 < 1024.0d) {
            String string = context.getString(2131952108, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1)));
            string.getClass();
            return string;
        }
        double d11 = 1024;
        double d12 = d10 / d11;
        if (d12 < 1024.0d) {
            String string2 = context.getString(2131952232, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d12)}, 1)));
            string2.getClass();
            return string2;
        }
        String string3 = context.getString(2131952037, String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d12 / d11)}, 1)));
        string3.getClass();
        return string3;
    }

    public static void I(ArrayList arrayList, MyApps myApps) {
        q6.q.j0(arrayList, new c4.k1(new c4.j1(5), 7));
        r(arrayList, myApps);
    }

    public static void J(ArrayList arrayList, c4.w4 w4Var) {
        q6.q.j0(arrayList, new androidx.constraintlayout.core.utils.a(5));
        r(arrayList, w4Var);
    }

    public static void K(ArrayList arrayList, MyApps myApps) {
        q6.q.j0(arrayList, new c4.k1(new c4.j1(6), 8));
        r(arrayList, myApps);
    }

    public static final w8.c L(File file) {
        Logger logger = w8.x.f11003a;
        file.getClass();
        return new w8.c(new FileInputStream(file), w8.i0.f10962d);
    }

    public static final w8.c M(InputStream inputStream) {
        Logger logger = w8.x.f11003a;
        inputStream.getClass();
        return new w8.c(inputStream, new w8.i0());
    }

    public static final long N(int i, m7.c cVar) {
        if (cVar.compareTo(m7.c.SECONDS) > 0) {
            return O(i, cVar);
        }
        return o(TimeUnit.NANOSECONDS.convert(i, cVar.f7667a));
    }

    public static final long O(long j, m7.c cVar) {
        TimeUnit timeUnit = cVar.f7667a;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long convert = timeUnit.convert(4611686018426999999L, timeUnit2);
        return ((-convert) > j || j > convert) ? m(t0.f.k(TimeUnit.MILLISECONDS.convert(j, timeUnit), -4611686018427387903L, 4611686018427387903L)) : o(timeUnit2.convert(j, timeUnit));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void P(android.content.Context r20, android.support.v4.media.g r21) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i5.P(android.content.Context, android.support.v4.media.g):void");
    }

    public static void Q(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static int R(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i6 = 0; i6 < 6; i6++) {
            int i10 = iArr[i6];
            int i11 = i10 - 1;
            if (i10 == 0) {
                throw null;
            }
            if (i11 == i) {
                return i10;
            }
        }
        return 1;
    }

    public static int S(byte[] bArr, int i, v4 v4Var) {
        int i6 = i + 1;
        byte b7 = bArr[i];
        if (b7 < 0) {
            return T(b7, bArr, i6, v4Var);
        }
        v4Var.f2837a = b7;
        return i6;
    }

    public static int T(int i, byte[] bArr, int i6, v4 v4Var) {
        byte b7 = bArr[i6];
        int i10 = i6 + 1;
        int i11 = i & 127;
        if (b7 >= 0) {
            v4Var.f2837a = i11 | (b7 << 7);
            return i10;
        }
        int i12 = i11 | ((b7 & Byte.MAX_VALUE) << 7);
        int i13 = i6 + 2;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            v4Var.f2837a = i12 | (b10 << 14);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 14);
        int i15 = i6 + 3;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            v4Var.f2837a = i14 | (b11 << 21);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 21);
        int i17 = i6 + 4;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            v4Var.f2837a = i16 | (b12 << 28);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] >= 0) {
                v4Var.f2837a = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public static d5 U() {
        String str;
        ClassLoader classLoader = i5.class.getClassLoader();
        if (d5.class.equals(d5.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!d5.class.getPackage().equals(i5.class.getPackage())) {
                com.google.gson.internal.a.p(d5.class.getName());
                return null;
            }
            str = d5.class.getPackage().getName() + ".BlazeGenerated" + d5.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        androidx.lifecycle.l.C(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InvocationTargetException e10) {
                        throw new IllegalStateException(e10);
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException(e11);
                }
            } catch (IllegalAccessException e12) {
                throw new IllegalStateException(e12);
            } catch (InstantiationException e13) {
                throw new IllegalStateException(e13);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new i5[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e14) {
                        Logger.getLogger(b5.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(d5.class.getSimpleName()), (Throwable) e14);
                    }
                }
                if (arrayList.size() == 1) {
                    return (d5) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (d5) d5.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e15) {
                    throw new IllegalStateException(e15);
                } catch (NoSuchMethodException e16) {
                    throw new IllegalStateException(e16);
                } catch (InvocationTargetException e17) {
                    throw new IllegalStateException(e17);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static int V(byte[] bArr, int i, v4 v4Var) {
        long j = bArr[i];
        int i6 = i + 1;
        if (j >= 0) {
            v4Var.f2838b = j;
            return i6;
        }
        int i10 = i + 2;
        byte b7 = bArr[i6];
        long j6 = (j & 127) | ((b7 & Byte.MAX_VALUE) << 7);
        int i11 = 7;
        while (b7 < 0) {
            int i12 = i10 + 1;
            i11 += 7;
            j6 |= (r10 & Byte.MAX_VALUE) << i11;
            b7 = bArr[i10];
            i10 = i12;
        }
        v4Var.f2838b = j6;
        return i10;
    }

    public static int W(int i, byte[] bArr) {
        int i6 = bArr[i] & 255;
        int i10 = bArr[i + 1] & 255;
        int i11 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i10 << 8) | i6 | (i11 << 16);
    }

    public static long X(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public static int Y(byte[] bArr, int i, v4 v4Var) {
        int S = S(bArr, i, v4Var);
        int i6 = v4Var.f2837a;
        if (i6 < 0) {
            c2.a.i("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i6 == 0) {
            v4Var.f2839c = "";
            return S;
        }
        int i10 = y6.f2919a;
        int length = bArr.length;
        if ((((length - S) - i6) | S | i6) < 0) {
            androidx.core.view.contentcapture.a.l("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(S), Integer.valueOf(i6)});
            return 0;
        }
        int i11 = S + i6;
        char[] cArr = new char[i6];
        int i12 = 0;
        while (S < i11) {
            byte b7 = bArr[S];
            if (b7 < 0) {
                break;
            }
            S++;
            cArr[i12] = (char) b7;
            i12++;
        }
        while (S < i11) {
            int i13 = S + 1;
            byte b10 = bArr[S];
            if (b10 >= 0) {
                cArr[i12] = (char) b10;
                i12++;
                S = i13;
                while (S < i11) {
                    byte b11 = bArr[S];
                    if (b11 >= 0) {
                        S++;
                        cArr[i12] = (char) b11;
                        i12++;
                    }
                }
            } else if (b10 < -32) {
                if (i13 >= i11) {
                    c2.a.i("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i14 = i12 + 1;
                S += 2;
                byte b12 = bArr[i13];
                if (b10 < -62 || a.a.b0(b12)) {
                    c2.a.i("Protocol message had invalid UTF-8.");
                    return 0;
                }
                cArr[i12] = (char) ((b12 & 63) | ((b10 & 31) << 6));
                i12 = i14;
            } else {
                if (b10 < -16) {
                    if (i13 >= i11 - 1) {
                        c2.a.i("Protocol message had invalid UTF-8.");
                        return 0;
                    }
                    int i15 = i12 + 1;
                    int i16 = S + 2;
                    byte b13 = bArr[i13];
                    S += 3;
                    byte b14 = bArr[i16];
                    if (!a.a.b0(b13)) {
                        if (b10 == -32) {
                            if (b13 >= -96) {
                                b10 = -32;
                            }
                        }
                        if (b10 == -19) {
                            if (b13 < -96) {
                                b10 = -19;
                            }
                        }
                        if (!a.a.b0(b14)) {
                            cArr[i12] = (char) (((b13 & 63) << 6) | ((b10 & 15) << 12) | (b14 & 63));
                            i12 = i15;
                        }
                    }
                    c2.a.i("Protocol message had invalid UTF-8.");
                    return 0;
                }
                if (i13 >= i11 - 2) {
                    c2.a.i("Protocol message had invalid UTF-8.");
                    return 0;
                }
                byte b15 = bArr[i13];
                int i17 = S + 3;
                byte b16 = bArr[S + 2];
                S += 4;
                byte b17 = bArr[i17];
                if (a.a.b0(b15) || (((b15 + 112) + (b10 << 28)) >> 30) != 0 || a.a.b0(b16) || a.a.b0(b17)) {
                    c2.a.i("Protocol message had invalid UTF-8.");
                    return 0;
                }
                int i18 = ((b15 & 63) << 12) | ((b10 & 7) << 18) | ((b16 & 63) << 6) | (b17 & 63);
                cArr[i12] = (char) ((i18 >>> 10) + 55232);
                cArr[i12 + 1] = (char) ((i18 & 1023) + 56320);
                i12 += 2;
            }
        }
        v4Var.f2839c = new String(cArr, 0, i12);
        return i11;
    }

    public static int Z(byte[] bArr, int i, v4 v4Var) {
        int S = S(bArr, i, v4Var);
        int i6 = v4Var.f2837a;
        if (i6 < 0) {
            c2.a.i("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i6 > bArr.length - S) {
            c2.a.i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i6 == 0) {
            v4Var.f2839c = a5.f2490l;
            return S;
        }
        v4Var.f2839c = a5.e(S, i6, bArr);
        return S + i6;
    }

    public static q7.e a(int i, q7.a aVar, int i6) {
        int i10 = i6 & 2;
        q7.a aVar2 = q7.a.f8729a;
        if (i10 != 0) {
            aVar = aVar2;
        }
        if (i == -2) {
            if (aVar != aVar2) {
                return new q7.o(1, aVar);
            }
            q7.i.f8769k.getClass();
            return new q7.e(q7.h.f8768b);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? aVar == aVar2 ? new q7.e(i) : new q7.o(i, aVar) : new q7.e(Integer.MAX_VALUE) : aVar == aVar2 ? new q7.e(0) : new q7.o(1, aVar);
        }
        if (aVar == aVar2) {
            return new q7.o(1, q7.a.f8730b);
        }
        com.google.gson.internal.a.p("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    public static int a0(Object obj, m6 m6Var, byte[] bArr, int i, int i6, v4 v4Var) {
        int i10 = i + 1;
        int i11 = bArr[i];
        if (i11 < 0) {
            i10 = T(i11, bArr, i10, v4Var);
            i11 = v4Var.f2837a;
        }
        int i12 = i10;
        if (i11 < 0 || i11 > i6 - i12) {
            c2.a.i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i13 = v4Var.f2840d + 1;
        v4Var.f2840d = i13;
        if (i13 >= 100) {
            c2.a.i("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i14 = i12 + i11;
        m6Var.h(obj, bArr, i12, i14, v4Var);
        v4Var.f2840d--;
        v4Var.f2839c = obj;
        return i14;
    }

    public static int b(int i, String str) {
        return androidx.lifecycle.l.o(i, 31, str);
    }

    public static int b0(Object obj, m6 m6Var, byte[] bArr, int i, int i6, int i10, v4 v4Var) {
        f6 f6Var = (f6) m6Var;
        int i11 = v4Var.f2840d + 1;
        v4Var.f2840d = i11;
        if (i11 >= 100) {
            c2.a.i("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int t9 = f6Var.t(obj, bArr, i, i6, i10, v4Var);
        v4Var.f2840d--;
        v4Var.f2839c = obj;
        return t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, java.util.Map] */
    public static Vector c(String str) {
        int i;
        int i6 = 1;
        Vector vector = new Vector(null, i6, 0 == true ? 1 : 0);
        Object obj = w5.c.f10915a;
        ?? r12 = w5.c.f10916b;
        w5.d dVar = w5.d.f10920l;
        Integer num = (Integer) r12.get(dVar);
        String substring = str.substring(0, num == null ? 0 : num.intValue());
        Integer num2 = (Integer) r12.get(dVar);
        int b7 = b2.t1.b(num2 == null ? 0 : num2.intValue(), substring);
        Integer num3 = (Integer) r12.get(dVar);
        int intValue = num3 == null ? 0 : num3.intValue();
        String valueOf = String.valueOf(str.charAt(intValue));
        w5.d dVar2 = w5.d.f10919b;
        Integer num4 = (Integer) r12.get(dVar2);
        int b10 = b2.t1.b(num4 == null ? 0 : num4.intValue(), valueOf);
        if (b10 != 0) {
            if (b10 != 1) {
                throw new w5.e(kotlin.jvm.internal.l.g(": Too large value to encode into VectorEncodingType", "h.m"));
            }
            i6 = 2;
        }
        Integer num5 = (Integer) r12.get(dVar2);
        int intValue2 = intValue + (num5 == null ? 0 : num5.intValue());
        if (i6 == 2) {
            w5.d dVar3 = w5.d.f10922n;
            Integer num6 = (Integer) r12.get(dVar3);
            String substring2 = str.substring(intValue2, num6 == null ? 0 : num6.intValue());
            Integer num7 = (Integer) r12.get(dVar3);
            int b11 = b2.t1.b(num7 == null ? 0 : num7.intValue(), substring2);
            Integer num8 = (Integer) r12.get(dVar3);
            i = intValue2 + (num8 == null ? 0 : num8.intValue());
            if (b11 >= 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    String valueOf2 = String.valueOf(str.charAt(i));
                    valueOf2.getClass();
                    boolean equals = valueOf2.equals("1");
                    Object obj2 = w5.c.f10915a;
                    ?? r72 = w5.c.f10916b;
                    Integer num9 = (Integer) r72.get(w5.d.f10927s);
                    int intValue3 = i + (num9 == null ? 0 : num9.intValue());
                    w5.d dVar4 = w5.d.f10928t;
                    Integer num10 = (Integer) r72.get(dVar4);
                    String substring3 = str.substring(intValue3, num10 == null ? 0 : num10.intValue());
                    Integer num11 = (Integer) r72.get(dVar4);
                    int b12 = b2.t1.b(num11 == null ? 0 : num11.intValue(), substring3);
                    Integer num12 = (Integer) r72.get(dVar4);
                    i = intValue3 + (num12 == null ? 0 : num12.intValue());
                    if (equals) {
                        Integer num13 = (Integer) r72.get(dVar4);
                        String substring4 = str.substring(i, num13 == null ? 0 : num13.intValue());
                        Integer num14 = (Integer) r72.get(dVar4);
                        int b13 = b2.t1.b(num14 == null ? 0 : num14.intValue(), substring4);
                        Integer num15 = (Integer) r72.get(dVar4);
                        i += num15 == null ? 0 : num15.intValue();
                        if (b12 <= b13) {
                            while (true) {
                                int i12 = b12 + 1;
                                vector.set(b12);
                                if (b12 == b13) {
                                    break;
                                }
                                b12 = i12;
                            }
                        }
                    } else {
                        vector.set(b12);
                    }
                    if (i10 == b11) {
                        break;
                    }
                    i10 = i11;
                }
            }
        } else {
            int i13 = intValue2 + b7;
            Vector b14 = a.a.b(b7, str.substring(intValue2, i13));
            i = i13;
            vector = b14;
        }
        vector.setBitLength(i);
        return vector;
    }

    public static int c0(int i, byte[] bArr, int i6, int i10, q5 q5Var, v4 v4Var) {
        m5 m5Var = (m5) q5Var;
        int S = S(bArr, i6, v4Var);
        m5Var.e(v4Var.f2837a);
        while (S < i10) {
            int S2 = S(bArr, S, v4Var);
            if (i != v4Var.f2837a) {
                break;
            }
            S = S(bArr, S2, v4Var);
            m5Var.e(v4Var.f2837a);
        }
        return S;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Map] */
    public static String d(String str) {
        String num;
        str.getClass();
        Pattern compile = Pattern.compile("^[A-Za-z0-9\\-_]+$");
        compile.getClass();
        if (!compile.matcher(str).matches()) {
            Object obj = w5.a.f10912a;
            throw new w5.e(kotlin.jvm.internal.l.g(": Invalidly encoded Base64URL string", "g.b"));
        }
        int length = str.length();
        String str2 = "";
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            i++;
            Integer num2 = (Integer) w5.a.f10912a.get(String.valueOf(charAt));
            if (num2 == null) {
                num = null;
            } else {
                int intValue = num2.intValue();
                d0.b.v(2);
                num = Integer.toString(intValue, 2);
                num.getClass();
            }
            if (num != null) {
                StringBuilder t9 = a4.x.t(str2);
                t9.append(l7.u.n0(6 - num.length()));
                t9.append((Object) num);
                str2 = t9.toString();
            }
        }
        return str2;
    }

    public static int d0(byte[] bArr, int i, q5 q5Var, v4 v4Var) {
        m5 m5Var = (m5) q5Var;
        int S = S(bArr, i, v4Var);
        int i6 = v4Var.f2837a + S;
        while (S < i6) {
            S = S(bArr, S, v4Var);
            m5Var.e(v4Var.f2837a);
        }
        if (S == i6) {
            return S;
        }
        c2.a.i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static Object e(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static int e0(m6 m6Var, int i, byte[] bArr, int i6, int i10, q5 q5Var, v4 v4Var) {
        l5 a8 = m6Var.a();
        m6 m6Var2 = m6Var;
        byte[] bArr2 = bArr;
        int i11 = i10;
        v4 v4Var2 = v4Var;
        int a0 = a0(a8, m6Var2, bArr2, i6, i11, v4Var2);
        m6Var2.g(a8);
        v4Var2.f2839c = a8;
        q5Var.add(a8);
        while (a0 < i11) {
            v4 v4Var3 = v4Var2;
            int i12 = i11;
            int S = S(bArr2, a0, v4Var3);
            if (i != v4Var3.f2837a) {
                break;
            }
            byte[] bArr3 = bArr2;
            m6 m6Var3 = m6Var2;
            l5 a10 = m6Var3.a();
            a0 = a0(a10, m6Var3, bArr3, S, i12, v4Var3);
            m6Var2 = m6Var3;
            bArr2 = bArr3;
            i11 = i12;
            v4Var2 = v4Var3;
            m6Var2.g(a10);
            v4Var2.f2839c = a10;
            q5Var.add(a10);
        }
        return a0;
    }

    public static final long f(String str) {
        m7.c cVar;
        long j;
        char charAt;
        int length = str.length();
        if (length == 0) {
            com.google.gson.internal.a.p("The string is empty");
            return 0L;
        }
        int i = m7.a.f7657m;
        char charAt2 = str.charAt(0);
        int i6 = (charAt2 == '+' || charAt2 == '-') ? 1 : 0;
        boolean z9 = i6 > 0 && str.length() > 0 && d0.b.D(str.charAt(0), '-', false);
        if (length <= i6) {
            com.google.gson.internal.a.p("No components");
            return 0L;
        }
        if (str.charAt(i6) != 'P') {
            s1.o.n();
            return 0L;
        }
        int i10 = i6 + 1;
        if (i10 == length) {
            s1.o.n();
            return 0L;
        }
        m7.c cVar2 = null;
        long j6 = 0;
        boolean z10 = false;
        while (i10 < length) {
            if (str.charAt(i10) != 'T') {
                int i11 = i10;
                while (i11 < str.length() && (('0' <= (charAt = str.charAt(i11)) && charAt < ':') || l7.m.r0("+-.", charAt))) {
                    i11++;
                }
                String substring = str.substring(i10, i11);
                if (substring.length() == 0) {
                    s1.o.n();
                    return 0L;
                }
                int length2 = substring.length() + i10;
                if (length2 < 0 || length2 >= str.length()) {
                    com.google.gson.internal.a.p("Missing unit for value ".concat(substring));
                    return 0L;
                }
                char charAt3 = str.charAt(length2);
                int i12 = length2 + 1;
                m7.c cVar3 = m7.c.SECONDS;
                if (z10) {
                    if (charAt3 == 'H') {
                        cVar = m7.c.HOURS;
                    } else if (charAt3 == 'M') {
                        cVar = m7.c.MINUTES;
                    } else {
                        if (charAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + charAt3);
                        }
                        cVar = cVar3;
                    }
                } else {
                    if (charAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + charAt3);
                    }
                    cVar = m7.c.DAYS;
                }
                if (cVar2 != null && cVar2.compareTo(cVar) <= 0) {
                    com.google.gson.internal.a.p("Unexpected order of duration components");
                    return 0L;
                }
                int x02 = l7.m.x0('.', 0, 6, substring);
                if (cVar != cVar3 || x02 <= 0) {
                    j6 = m7.a.f(j6, O(E(substring), cVar));
                } else {
                    long f = m7.a.f(j6, O(E(substring.substring(0, x02)), cVar));
                    double parseDouble = Double.parseDouble(substring.substring(x02));
                    double z11 = d0.b.z(parseDouble, cVar, m7.c.NANOSECONDS);
                    if (Double.isNaN(z11)) {
                        com.google.gson.internal.a.p("Duration value cannot be NaN.");
                    } else if (Double.isNaN(z11)) {
                        com.google.gson.internal.a.p("Cannot round NaN value.");
                    } else {
                        long round = Math.round(z11);
                        if (-4611686018426999999L > round || round >= 4611686018427000000L) {
                            double z12 = d0.b.z(parseDouble, cVar, m7.c.MILLISECONDS);
                            if (Double.isNaN(z12)) {
                                com.google.gson.internal.a.p("Cannot round NaN value.");
                            } else {
                                j = n(Math.round(z12));
                            }
                        } else {
                            j = o(round);
                        }
                        j6 = m7.a.f(f, j);
                    }
                    j = 0;
                    j6 = m7.a.f(f, j);
                }
                cVar2 = cVar;
                i10 = i12;
            } else {
                if (z10 || (i10 = i10 + 1) == length) {
                    s1.o.n();
                    return 0L;
                }
                z10 = true;
            }
        }
        if (!z9) {
            return j6;
        }
        long j10 = ((-(j6 >> 1)) << 1) + (((int) j6) & 1);
        int i13 = m7.b.f7659a;
        return j10;
    }

    public static int f0(int i, byte[] bArr, int i6, int i10, r6 r6Var, v4 v4Var) {
        if ((i >>> 3) == 0) {
            c2.a.i("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i11 = i & 7;
        if (i11 == 0) {
            int V = V(bArr, i6, v4Var);
            r6Var.d(i, Long.valueOf(v4Var.f2838b));
            return V;
        }
        if (i11 == 1) {
            r6Var.d(i, Long.valueOf(X(i6, bArr)));
            return i6 + 8;
        }
        if (i11 == 2) {
            int S = S(bArr, i6, v4Var);
            int i12 = v4Var.f2837a;
            if (i12 < 0) {
                c2.a.i("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i12 > bArr.length - S) {
                c2.a.i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i12 == 0) {
                r6Var.d(i, a5.f2490l);
            } else {
                r6Var.d(i, a5.e(S, i12, bArr));
            }
            return S + i12;
        }
        if (i11 != 3) {
            if (i11 == 5) {
                r6Var.d(i, Integer.valueOf(W(i6, bArr)));
                return i6 + 4;
            }
            c2.a.i("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i13 = (i & (-8)) | 4;
        r6 a8 = r6.a();
        int i14 = v4Var.f2840d + 1;
        v4Var.f2840d = i14;
        if (i14 >= 100) {
            c2.a.i("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i15 = 0;
        while (true) {
            if (i6 >= i10) {
                break;
            }
            int S2 = S(bArr, i6, v4Var);
            int i16 = v4Var.f2837a;
            if (i16 == i13) {
                i15 = i16;
                i6 = S2;
                break;
            }
            i6 = f0(i16, bArr, S2, i10, a8, v4Var);
            i15 = i16;
        }
        v4Var.f2840d--;
        if (i6 > i10 || i15 != i13) {
            c2.a.i("Failed to parse the message.");
            return 0;
        }
        r6Var.d(i, a8);
        return i6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static void g(UsernameTextView usernameTextView, boolean z9, String str) {
        usernameTextView.getClass();
        F(usernameTextView);
        ValueAnimator valueAnimator = usernameTextView.f3453a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        usernameTextView.setTurbo(z9);
        usernameTextView.setUsernameFormat(str);
        if (str != null) {
            switch (str.hashCode()) {
                case 110843959:
                    if (str.equals("type1")) {
                        usernameTextView.f3457n = 2000L;
                        usernameTextView.f3458o = 200L;
                        break;
                    }
                    break;
                case 110843960:
                    if (str.equals("type2")) {
                        usernameTextView.f3457n = 4000L;
                        usernameTextView.f3458o = 300L;
                        break;
                    }
                    break;
                case 110843961:
                    if (str.equals("type3")) {
                        usernameTextView.f3457n = 3000L;
                        usernameTextView.f3458o = 400L;
                        break;
                    }
                    break;
            }
        }
        long j = usernameTextView.f3458o;
        if (usernameTextView.f3459p) {
            usernameTextView.a();
            usernameTextView.f3461r = new Handler(Looper.getMainLooper());
            e1.w wVar = new e1.w(usernameTextView, j);
            String str2 = usernameTextView.f3460q;
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case 110843959:
                        if (str2.equals("type1")) {
                            int color = ContextCompat.getColor(usernameTextView.getContext(), 2131100806);
                            usernameTextView.f3455l = new int[]{color, ContextCompat.getColor(usernameTextView.getContext(), 2131100807), color, color, color};
                            break;
                        }
                        break;
                    case 110843960:
                        if (str2.equals("type2")) {
                            int color2 = ContextCompat.getColor(usernameTextView.getContext(), 2131100808);
                            usernameTextView.f3455l = new int[]{color2, ContextCompat.getColor(usernameTextView.getContext(), 2131100809), color2, color2, color2};
                            break;
                        }
                        break;
                    case 110843961:
                        if (str2.equals("type3")) {
                            int color3 = ContextCompat.getColor(usernameTextView.getContext(), 2131100810);
                            usernameTextView.f3455l = new int[]{color3, ContextCompat.getColor(usernameTextView.getContext(), 2131100811), color3, color3, color3};
                            break;
                        }
                        break;
                }
            }
            Handler handler = usernameTextView.f3461r;
            if (handler != null) {
                handler.post(wVar);
            }
        }
    }

    public static int g0(int i, byte[] bArr, int i6, int i10, v4 v4Var) {
        if ((i >>> 3) == 0) {
            c2.a.i("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i11 = i & 7;
        if (i11 == 0) {
            return V(bArr, i6, v4Var);
        }
        if (i11 == 1) {
            return i6 + 8;
        }
        if (i11 == 2) {
            return S(bArr, i6, v4Var) + v4Var.f2837a;
        }
        if (i11 != 3) {
            if (i11 == 5) {
                return i6 + 4;
            }
            c2.a.i("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i12 = (i & (-8)) | 4;
        int i13 = 0;
        while (i6 < i10) {
            i6 = S(bArr, i6, v4Var);
            i13 = v4Var.f2837a;
            if (i13 == i12) {
                break;
            }
            i6 = g0(i13, bArr, i6, i10, v4Var);
        }
        if (i6 <= i10 && i13 == i12) {
            return i6;
        }
        c2.a.i("Failed to parse the message.");
        return 0;
    }

    public static String h(String str) {
        Pattern compile = Pattern.compile("^[0-1]+$");
        compile.getClass();
        if (!compile.matcher(str).matches()) {
            Object obj = w5.a.f10912a;
            throw new w5.e("g.b: invalid bitField + ".concat(str));
        }
        int length = str.length();
        int i = 0;
        ArrayList arrayList = new ArrayList((length / 6) + (length % 6 == 0 ? 0 : 1));
        int i6 = 0;
        while (i6 >= 0 && i6 < length) {
            int i10 = i6 + 6;
            CharSequence subSequence = str.subSequence(i6, (i10 < 0 || i10 > length) ? length : i10);
            subSequence.getClass();
            arrayList.add(subSequence.toString());
            i6 = i10;
        }
        int size = arrayList.size();
        String str2 = "";
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            str2 = kotlin.jvm.internal.l.g(Character.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(Integer.parseInt((String) obj2, 2))), str2);
        }
        return str2;
    }

    public static void i(Object obj, String str) {
        if (obj != null) {
            return;
        }
        com.google.gson.internal.a.i(str);
    }

    public static void j(q4.c cVar, o4.a aVar) {
        while (!aVar.g) {
            StringBuilder sb = new StringBuilder("Command is in position ");
            ArrayList arrayList = cVar.i;
            sb.append(arrayList.indexOf(aVar));
            sb.append(" currently executing command at position ");
            sb.append(cVar.f8691o);
            sb.append(" and the number of commands is ");
            sb.append(arrayList.size());
            B(sb.toString());
            B("Processed " + aVar.f8163b + " of " + aVar.f8162a + " output from command.");
            synchronized (aVar) {
                try {
                    if (!aVar.g) {
                        aVar.wait(2000L);
                    }
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            if (!aVar.f8166e && !aVar.g) {
                boolean z9 = cVar.f8687k;
                if (!z9 && !cVar.f8688l) {
                    B("Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc = new Exception();
                    exc.setStackTrace(Thread.currentThread().getStackTrace());
                    exc.printStackTrace();
                } else if (!z9 || cVar.f8688l) {
                    B("Waiting for a command to be executed in a shell that is not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc2 = new Exception();
                    exc2.setStackTrace(Thread.currentThread().getStackTrace());
                    exc2.printStackTrace();
                } else {
                    B("Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: ".concat(aVar.b()));
                    Exception exc3 = new Exception();
                    exc3.setStackTrace(Thread.currentThread().getStackTrace());
                    exc3.printStackTrace();
                }
            }
        }
    }

    public static boolean k(String str) {
        if (str.equals("1")) {
            return true;
        }
        if (str.equals("0")) {
            return false;
        }
        throw new q3.a(androidx.lifecycle.l.w("Undecodable Boolean '", str, "'"));
    }

    public static boolean l(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                file2.getClass();
                l(file2);
            }
        }
        return file.delete();
    }

    public static final long m(long j) {
        long j6 = (j << 1) + 1;
        int i = m7.a.f7657m;
        int i6 = m7.b.f7659a;
        return j6;
    }

    public static final long n(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? m(t0.f.k(j, -4611686018427387903L, 4611686018427387903L)) : o(j * 1000000);
    }

    public static final long o(long j) {
        long j6 = j << 1;
        int i = m7.a.f7657m;
        int i6 = m7.b.f7659a;
        return j6;
    }

    public static String p(Boolean bool) {
        if (bool.booleanValue()) {
            return "1";
        }
        if (!bool.booleanValue()) {
            return "0";
        }
        throw new a1.b("Unencodable Boolean '" + bool + "'");
    }

    public static int q(int i, int i6) {
        if (i6 < 0) {
            s1.o.j("cannot store more than MAX_VALUE elements");
            return 0;
        }
        int i10 = i + (i >> 1) + 1;
        if (i10 < i6) {
            i10 = Integer.highestOneBit(i6 - 1) << 1;
        }
        if (i10 < 0) {
            return Integer.MAX_VALUE;
        }
        return i10;
    }

    public static void r(ArrayList arrayList, c4.w4 w4Var) {
        x4.d dVar;
        j5.g l10 = j5.g.D.l(w4Var);
        l10.b();
        ArrayList a0 = l10.a0();
        l10.c();
        Iterator it = a0.iterator();
        it.getClass();
        while (true) {
            boolean hasNext = it.hasNext();
            dVar = x4.d.f11087a;
            if (!hasNext) {
                break;
            }
            Object next = it.next();
            next.getClass();
            x4.q2 q2Var = (x4.q2) next;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                long j = ((x4.e) arrayList.get(i)).f11124m;
                if (l7.u.m0(q2Var.f11344b, ((x4.e) arrayList.get(i)).f11123l, true) && q2Var.f11345l > j) {
                    x4.e eVar = (x4.e) arrayList.get(i);
                    eVar.getClass();
                    eVar.f11127p = dVar;
                }
            }
        }
        int size2 = arrayList.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj = arrayList.get(i6);
            i6++;
            x4.e eVar2 = (x4.e) obj;
            int size3 = a0.size();
            int i10 = 0;
            while (i10 < size3) {
                Object obj2 = a0.get(i10);
                i10++;
                x4.q2 q2Var2 = (x4.q2) obj2;
                if (eVar2.v == 1 || (kotlin.jvm.internal.l.a(eVar2.f11123l, q2Var2.f11344b) && q2Var2.c())) {
                    eVar2.f11127p = x4.d.f11088b;
                }
            }
        }
        q6.q.j0(arrayList, new g4.z(7));
        int i11 = 0;
        while (i11 < arrayList.size() && (!l7.u.m0(w4Var.getPackageName(), ((x4.e) arrayList.get(i11)).f11123l, true) || ((x4.e) arrayList.get(i11)).f11127p != dVar)) {
            i11++;
        }
        if (i11 < arrayList.size()) {
            Object remove = arrayList.remove(i11);
            remove.getClass();
            arrayList.add(0, (x4.e) remove);
        }
    }

    public static ArrayList s(String str, ArrayList arrayList) {
        str.getClass();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            x4.e eVar = (x4.e) obj;
            String str2 = eVar.f11122b;
            boolean z9 = true;
            if (str2 == null || str2.length() == 0) {
                String str3 = eVar.f11123l;
                if (str3 != null && str3.length() != 0) {
                    String str4 = eVar.f11123l;
                    str4.getClass();
                    z9 = l7.m.q0(str4, str, true);
                }
            } else {
                String str5 = eVar.f11122b;
                str5.getClass();
                z9 = l7.m.q0(str5, str, true);
            }
            if (z9) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final z7.a t(d8.b bVar, c8.c cVar, String str) {
        z7.b bVar2;
        bVar.getClass();
        g8.f serializersModule = cVar.getSerializersModule();
        j7.c cVar2 = ((z7.e) bVar).f11986a;
        g8.d dVar = (g8.d) serializersModule;
        dVar.getClass();
        cVar2.getClass();
        Map map = (Map) dVar.f5379d.get(cVar2);
        z7.b bVar3 = map != null ? (z7.b) map.get(str) : null;
        if (!(bVar3 instanceof z7.b)) {
            bVar3 = null;
        }
        if (bVar3 != null) {
            bVar2 = bVar3;
        } else {
            Object obj = dVar.f5380e.get(cVar2);
            d7.l lVar = kotlin.jvm.internal.a0.c(1, obj) ? (d7.l) obj : null;
            bVar2 = lVar != null ? (z7.a) lVar.invoke(str) : null;
        }
        if (bVar2 != null) {
            return bVar2;
        }
        d8.o0.f(str, cVar2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final z7.h u(d8.b r3, c8.b r4, java.lang.Object r5) {
        /*
            r3.getClass()
            r5.getClass()
            g8.f r4 = r4.getSerializersModule()
            z7.e r3 = (z7.e) r3
            j7.c r3 = r3.f11986a
            g8.d r4 = (g8.d) r4
            r4.getClass()
            r3.getClass()
            r0 = r3
            kotlin.jvm.internal.f r0 = (kotlin.jvm.internal.f) r0
            boolean r0 = r0.d(r5)
            r1 = 0
            if (r0 != 0) goto L21
            goto L61
        L21:
            java.util.Map r0 = r4.f5377b
            java.lang.Object r0 = r0.get(r3)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L3a
            java.lang.Class r2 = r5.getClass()
            kotlin.jvm.internal.f r2 = kotlin.jvm.internal.y.a(r2)
            java.lang.Object r0 = r0.get(r2)
            z7.b r0 = (z7.b) r0
            goto L3b
        L3a:
            r0 = r1
        L3b:
            boolean r2 = r0 instanceof z7.h
            if (r2 == 0) goto L42
            z7.h r0 = (z7.h) r0
            goto L43
        L42:
            r0 = r1
        L43:
            if (r0 == 0) goto L46
            goto L62
        L46:
            java.util.Map r4 = r4.f5378c
            java.lang.Object r4 = r4.get(r3)
            r0 = 1
            boolean r0 = kotlin.jvm.internal.a0.c(r0, r4)
            if (r0 == 0) goto L56
            d7.l r4 = (d7.l) r4
            goto L57
        L56:
            r4 = r1
        L57:
            if (r4 == 0) goto L61
            java.lang.Object r4 = r4.invoke(r5)
            r0 = r4
            z7.h r0 = (z7.h) r0
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 != 0) goto L7a
            java.lang.Class r4 = r5.getClass()
            kotlin.jvm.internal.f r4 = kotlin.jvm.internal.y.a(r4)
            java.lang.String r5 = r4.c()
            if (r5 != 0) goto L76
            java.lang.String r5 = java.lang.String.valueOf(r4)
        L76:
            d8.o0.f(r5, r3)
            throw r1
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i5.u(d8.b, c8.b, java.lang.Object):z7.h");
    }

    public static x4.a3 v(JSONObject jSONObject) {
        x4.a3 a3Var = new x4.a3();
        a3Var.f11046a = -1L;
        a3Var.f = -1L;
        a3Var.h = new ArrayList();
        if (!jSONObject.isNull("appID")) {
            a3Var.f11046a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull("name")) {
            a3Var.f11047b = jSONObject.optString("name");
        }
        if (!jSONObject.isNull("icon")) {
            a3Var.f11048c = jSONObject.optString("icon");
        }
        if (!jSONObject.isNull("packagename")) {
            a3Var.f11049d = jSONObject.optString("packagename");
        }
        if (!jSONObject.isNull("wishlistAdded")) {
            a3Var.f11050e = jSONObject.optString("wishlistAdded");
        }
        if (!jSONObject.isNull("platformID")) {
            a3Var.f = jSONObject.optLong("platformID");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            a3Var.g = jSONObject.optString("downloadStatus");
        }
        if (!jSONObject.isNull("url")) {
            a3Var.i = jSONObject.optString("url");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("floatingCategories");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                x4.j jVar = new x4.j(0, (String) null, 7);
                optJSONObject.getClass();
                jVar.b(optJSONObject);
                a3Var.h.add(jVar);
            }
        }
        return a3Var;
    }

    public static e0.a w(Context context, GoogleSignInOptions googleSignInOptions) {
        k0.y.g(googleSignInOptions);
        return new e0.a(context, d0.a.f3532a, googleSignInOptions, new i0.c(new e1.c0(19), Looper.getMainLooper()));
    }

    public static j1.p x(Intent intent) {
        e0.c cVar;
        GoogleSignInAccount googleSignInAccount;
        f8.o oVar = f0.h.f4808a;
        Status status = Status.f2471p;
        if (intent == null) {
            cVar = new e0.c(null, status);
        } else {
            Status status2 = (Status) intent.getParcelableExtra("googleSignInStatus");
            GoogleSignInAccount googleSignInAccount2 = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
            if (googleSignInAccount2 == null) {
                if (status2 != null) {
                    status = status2;
                }
                cVar = new e0.c(null, status);
            } else {
                cVar = new e0.c(googleSignInAccount2, Status.f2469n);
            }
        }
        Status status3 = cVar.f3734a;
        if (status3.f2474a > 0 || (googleSignInAccount = cVar.f3735b) == null) {
            return b2.t1.w(status3.f2476l != null ? new i0.h(status3) : new g0.m(status3));
        }
        return b2.t1.x(googleSignInAccount);
    }

    public static final boolean y(AssertionError assertionError) {
        Logger logger = w8.x.f11003a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? l7.m.q0(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static k7.g z(d7.p pVar) {
        k7.g gVar = new k7.g();
        gVar.f7000m = d0.b.B(pVar, gVar, gVar);
        return gVar;
    }
}
