package b2;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.core.text.HtmlCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.google.firebase.messaging.FirebaseMessaging;
import com.inmobi.cmp.core.model.Vector;
import com.uptodown.UptodownApp;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static c3.d1 f945a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f946b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f947c = "";

    public static boolean A(int i, CharSequence charSequence) {
        if (i >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i);
        switch (charAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (charAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    case '@':
                        return true;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (charAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean B(String str) {
        return str.equals(TypedValues.TransitionType.S_DURATION) || str.equals("speed");
    }

    public static boolean C(String str) {
        return str.equals("responseCode") || str.equals("exception") || str.equals("error") || str.equals("extraError") || str.equals("filehashCalculated");
    }

    public static boolean D(String str) {
        return str.equals("host") || str.equals("connectionType") || str.equals("downBandwidthKbps") || str.equals("upBandwidthKbps");
    }

    public static final boolean E(TextView textView) {
        int lineCount;
        textView.getClass();
        Layout layout = textView.getLayout();
        return layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0;
    }

    public static String F(String str, Object... objArr) {
        int indexOf;
        String sb;
        int i = 0;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e10) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, sb3.length() != 0 ? "Exception during lenientFormat for ".concat(sb3) : new String("Exception during lenientFormat for "), (Throwable) e10);
                    String name2 = e10.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(name2.length() + sb3.length() + 9);
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i6] = sb;
        }
        StringBuilder sb5 = new StringBuilder((objArr.length * 16) + str.length());
        int i10 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i10)) != -1) {
            sb5.append((CharSequence) str, i10, indexOf);
            sb5.append(objArr[i]);
            i10 = indexOf + 2;
            i++;
        }
        sb5.append((CharSequence) str, i10, str.length());
        if (i < objArr.length) {
            sb5.append(" [");
            sb5.append(objArr[i]);
            for (int i11 = i + 1; i11 < objArr.length; i11++) {
                sb5.append(", ");
                sb5.append(objArr[i11]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }

    public static q2 G(x4.e eVar, JSONObject jSONObject) {
        if (jSONObject.isNull("packagename")) {
            return null;
        }
        String optString = jSONObject.optString("packagename");
        optString.getClass();
        q2 q2Var = new q2(optString);
        if (!jSONObject.isNull("versionName")) {
            q2Var.f11346m = jSONObject.optString("versionName");
        }
        if (!jSONObject.isNull("versionCode")) {
            q2Var.f11345l = jSONObject.optLong("versionCode");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requiredFeatures");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            q2Var.f11353t = arrayList;
        }
        x4.r rVar = new x4.r();
        rVar.f11355b = q2Var.f11344b;
        rVar.f11361q = eVar.F;
        rVar.f11366w = eVar.f11122b;
        rVar.f11363s = eVar.f11132u;
        rVar.f11358n = q2Var.f11345l;
        rVar.f11359o = q2Var.f11346m;
        long j = q2Var.f11343a;
        if (j == -1) {
            rVar.f11369z = 0L;
        } else {
            rVar.f11369z = j;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("containedFiles");
        if (optJSONArray2 == null) {
            optJSONArray2 = jSONObject.optJSONArray("files");
        }
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i6 = 0; i6 < length2; i6++) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i6);
                jSONObject2.getClass();
                x4.j0 j0Var = new x4.j0();
                if (!jSONObject2.isNull("fileID")) {
                    j0Var.f11235l = jSONObject2.optLong("fileID");
                }
                if (!jSONObject2.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                    j0Var.f11236m = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                }
                if (!jSONObject2.isNull("size")) {
                    j0Var.f11237n = jSONObject2.optLong("size");
                }
                if (!jSONObject2.isNull("sha256")) {
                    j0Var.f11239p = jSONObject2.optString("sha256");
                }
                rVar.F.add(j0Var);
                q2Var.f11352s = rVar;
            }
        } else {
            x4.j0 j0Var2 = new x4.j0();
            if (!jSONObject.isNull("size")) {
                j0Var2.f11237n = jSONObject.optLong("size");
            }
            if (!jSONObject.isNull("fileID")) {
                String optString2 = jSONObject.optString("fileID");
                try {
                    optString2.getClass();
                    j0Var2.f11235l = Long.parseLong(optString2);
                } catch (NumberFormatException e10) {
                    e10.printStackTrace();
                }
                rVar.F.add(j0Var2);
                q2Var.f11352s = rVar;
            }
        }
        return q2Var;
    }

    public static final void H() {
        try {
            if (f945a == null) {
                c3.d1 d1Var = (c3.d1) ((c3.i) ((c3.r) n1.f.c().b(c3.r.class))).f1265o.get();
                d1Var.getClass();
                f945a = d1Var;
            }
            c3.d1 d1Var2 = f945a;
            if (d1Var2 == null) {
                kotlin.jvm.internal.l.i("sharedSessionRepository");
                throw null;
            }
            if (d1Var2.i) {
                if (d1Var2 != null) {
                    d1Var2.b();
                } else {
                    kotlin.jvm.internal.l.i("sharedSessionRepository");
                    throw null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String I(long j) {
        return j < 10485760 ? "<10MB" : j < 104857600 ? "<100MB" : j < 524288000 ? "<500MB" : j < 1073741824 ? "<1GB" : j < 10737418240L ? "<10GB" : "<10MB";
    }

    public static void J(String str, JSONObject jSONObject, Bundle bundle) {
        if (str.equalsIgnoreCase("downBandwidthKbps") || str.equalsIgnoreCase("upBandwidthKbps") || str.equalsIgnoreCase("speed") || str.equalsIgnoreCase(TypedValues.TransitionType.S_DURATION)) {
            jSONObject.put(str, bundle.getLong(str));
            return;
        }
        if (str.equalsIgnoreCase("update") || str.equalsIgnoreCase("deeplink") || str.equalsIgnoreCase("notification_fcm") || str.equalsIgnoreCase("rollback")) {
            jSONObject.put(str, bundle.getInt(str));
        } else {
            jSONObject.put(str, bundle.getString(str));
        }
    }

    public static final byte[] K(InputStream inputStream) {
        inputStream.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        t(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public static final void L(Object[] objArr, int i, int i6) {
        objArr.getClass();
        while (i < i6) {
            objArr[i] = null;
            i++;
        }
    }

    public static int M(char c9, int i, int i6, CharSequence charSequence) {
        while (i < i6) {
            if (charSequence.charAt(i) != c9) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static int N(CharSequence charSequence, int i, int i6) {
        while (i < i6) {
            char charAt = charSequence.charAt(i);
            if (charAt != '\t' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static final p6.q O(String str) {
        int i;
        d0.b.v(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char charAt = str.charAt(0);
        if (kotlin.jvm.internal.l.c(charAt, 48) < 0) {
            i = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i = 0;
        }
        int i10 = 119304647;
        while (i < length) {
            int digit = Character.digit((int) str.charAt(i), 10);
            if (digit < 0) {
                return null;
            }
            int i11 = i6 ^ Integer.MIN_VALUE;
            if (Integer.compare(i11, i10 ^ Integer.MIN_VALUE) > 0) {
                if (i10 != 119304647) {
                    return null;
                }
                i10 = (int) (((-1) & 4294967295L) / (4294967295L & 10));
                if (Integer.compare(i11, i10 ^ Integer.MIN_VALUE) > 0) {
                    return null;
                }
            }
            int i12 = i6 * 10;
            int i13 = digit + i12;
            if (Integer.compare(i13 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i++;
            i6 = i13;
        }
        return new p6.q(i6);
    }

    public static final p6.s P(String str) {
        int i;
        long j;
        str.getClass();
        int i6 = 10;
        d0.b.v(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        int i10 = 1;
        if (kotlin.jvm.internal.l.c(charAt, 48) >= 0) {
            i = 0;
        } else {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i = 1;
        }
        long j6 = 10;
        long j10 = 0;
        long j11 = 512409557603043100L;
        while (i < length) {
            int digit = Character.digit((int) str.charAt(i), i6);
            if (digit < 0) {
                return null;
            }
            int i11 = length;
            long j12 = j10 ^ Long.MIN_VALUE;
            int i12 = i;
            if (Long.compare(j12, j11 ^ Long.MIN_VALUE) <= 0) {
                j = j6;
            } else {
                if (j11 != 512409557603043100L) {
                    return null;
                }
                if (j6 >= 0) {
                    long j13 = (LocationRequestCompat.PASSIVE_INTERVAL / j6) << i10;
                    j = j6;
                    j11 = j13 + ((((-1) - (j13 * j6)) ^ Long.MIN_VALUE) >= (j6 ^ Long.MIN_VALUE) ? i10 : 0);
                } else if (LocationRequestCompat.PASSIVE_INTERVAL < (j6 ^ Long.MIN_VALUE)) {
                    j = j6;
                    j11 = 0;
                } else {
                    j11 = 1;
                    j = j6;
                }
                if (Long.compare(j12, j11 ^ Long.MIN_VALUE) > 0) {
                    return null;
                }
            }
            long j14 = j10 * j;
            long j15 = (digit & 4294967295L) + j14;
            if (Long.compare(j15 ^ Long.MIN_VALUE, j14 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i = i12 + 1;
            j10 = j15;
            length = i11;
            j6 = j;
            i6 = 10;
            i10 = 1;
        }
        return new p6.s(j10);
    }

    public static j1.p Q(List list) {
        if (list == null || list.isEmpty()) {
            return x(null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((j1.p) it.next()) == null) {
                com.google.gson.internal.a.i("null tasks are not accepted");
                return null;
            }
        }
        j1.p pVar = new j1.p();
        j1.k kVar = new j1.k(list.size(), pVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            j1.p pVar2 = (j1.p) it2.next();
            j1.o oVar = j1.j.f6541b;
            pVar2.c(oVar, kVar);
            pVar2.b(oVar, kVar);
            pVar2.f6561b.e(new j1.m((Executor) oVar, (j1.c) kVar));
            pVar2.p();
        }
        return pVar;
    }

    public static Object R(j1.p pVar) {
        if (pVar.i()) {
            return pVar.g();
        }
        if (pVar.f6563d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(pVar.f());
    }

    public static void S(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        c2.a.g(i, str, list.size(), " operation requires ");
    }

    public static void T(int i, int i6) {
        String V;
        if (i < 0 || i >= i6) {
            if (i < 0) {
                V = z3.V("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i6 < 0) {
                    y2.n.a(String.valueOf(i6).length() + 15, i6, "negative size: ");
                    return;
                }
                V = z3.V("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(V);
        }
    }

    public static void U(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        c2.a.g(i, str, list.size(), " operation requires at least ");
    }

    public static void V(int i, String str, ArrayList arrayList) {
        if (arrayList.size() <= i) {
            return;
        }
        c2.a.g(i, str, arrayList.size(), " operation requires at most ");
    }

    public static void W(int i, int i6, int i10) {
        if (i < 0 || i6 < i || i6 > i10) {
            throw new IndexOutOfBoundsException((i < 0 || i > i10) ? Z(i, i10, "start index") : (i6 < 0 || i6 > i10) ? Z(i6, i10, "end index") : z3.V("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    public static boolean X(com.google.android.gms.internal.measurement.n nVar) {
        if (nVar == null) {
            return false;
        }
        Double g = nVar.g();
        return !g.isNaN() && g.doubleValue() >= 0.0d && g.equals(Double.valueOf(Math.floor(g.doubleValue())));
    }

    public static com.google.android.gms.internal.measurement.w Y(String str) {
        com.google.android.gms.internal.measurement.w wVar = null;
        if (str != null && !str.isEmpty()) {
            wVar = (com.google.android.gms.internal.measurement.w) com.google.android.gms.internal.measurement.w.f2875u0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (wVar != null) {
            return wVar;
        }
        com.google.gson.internal.a.p(a4.x.j("Unsupported commandId ", str));
        return null;
    }

    public static String Z(int i, int i6, String str) {
        if (i < 0) {
            return z3.V("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return z3.V("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        y2.n.a(String.valueOf(i6).length() + 15, i6, "negative size: ");
        return null;
    }

    public static final d8.u0 a(String str, b8.d dVar) {
        if (l7.m.z0(str)) {
            com.google.gson.internal.a.p("Blank serial names are prohibited");
            return null;
        }
        Iterator it = ((r6.h) d8.v0.f3716a.values()).iterator();
        while (((r6.d) it).hasNext()) {
            z7.b bVar = (z7.b) ((r6.d) it).next();
            if (str.equals(bVar.getDescriptor().a())) {
                StringBuilder v = a4.x.v("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                v.append(kotlin.jvm.internal.y.a(bVar.getClass()).c());
                v.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                com.google.gson.internal.a.p(l7.n.d0(v.toString()));
                return null;
            }
        }
        return new d8.u0(str, dVar);
    }

    public static boolean a0(com.google.android.gms.internal.measurement.n nVar, com.google.android.gms.internal.measurement.n nVar2) {
        if (!nVar.getClass().equals(nVar2.getClass())) {
            return false;
        }
        if ((nVar instanceof com.google.android.gms.internal.measurement.r) || (nVar instanceof com.google.android.gms.internal.measurement.l)) {
            return true;
        }
        if (!(nVar instanceof com.google.android.gms.internal.measurement.g)) {
            return nVar instanceof com.google.android.gms.internal.measurement.q ? nVar.f().equals(nVar2.f()) : nVar instanceof com.google.android.gms.internal.measurement.e ? nVar.e().equals(nVar2.e()) : nVar == nVar2;
        }
        if (Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue())) {
            return false;
        }
        return nVar.g().equals(nVar2.g());
    }

    public static int b(int i, String str) {
        str.getClass();
        if (i != str.length()) {
            throw new w5.e(kotlin.jvm.internal.l.g(": invalid bit length", "h.g"));
        }
        d0.b.v(2);
        return Integer.parseInt(str, 2);
    }

    public static int b0(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10) || d10 == 0.0d) {
            return 0;
        }
        return (int) (((d10 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d10))) % 4.294967296E9d);
    }

    public static String c(Number number, int i) {
        String l10;
        number.getClass();
        if ((number instanceof Integer) && number.intValue() >= 0) {
            int intValue = number.intValue();
            d0.b.v(2);
            l10 = Integer.toString(intValue, 2);
            l10.getClass();
        } else {
            if (!(number instanceof Long) || number.longValue() < 0) {
                throw new w5.e(kotlin.jvm.internal.l.g(": incorrect format passed", "h.g"));
            }
            long longValue = number.longValue();
            d0.b.v(2);
            l10 = Long.toString(longValue, 2);
            l10.getClass();
        }
        if (l10.length() <= i) {
            return l7.m.D0(i, l10);
        }
        throw new w5.e("h.g: " + number + " too large to encode into " + i);
    }

    public static double c0(double d10) {
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (Double.isInfinite(d10) || d10 == 0.0d || d10 == 0.0d) {
            return d10;
        }
        return (d10 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d10));
    }

    public static final String d(String str) {
        str.getClass();
        return q6.l.x0(l7.m.G0(str, new String[]{" "}), " ", null, null, g9.a.f5388b, 30);
    }

    public static Object d0(com.google.android.gms.internal.measurement.n nVar) {
        if (com.google.android.gms.internal.measurement.n.f2718d.equals(nVar)) {
            return null;
        }
        if (com.google.android.gms.internal.measurement.n.f2717c.equals(nVar)) {
            return "";
        }
        if (nVar instanceof com.google.android.gms.internal.measurement.k) {
            return e0((com.google.android.gms.internal.measurement.k) nVar);
        }
        if (!(nVar instanceof com.google.android.gms.internal.measurement.d)) {
            return !nVar.g().isNaN() ? nVar.g() : nVar.f();
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.gms.internal.measurement.d dVar = (com.google.android.gms.internal.measurement.d) nVar;
        int i = 0;
        while (i < dVar.o()) {
            if (i >= dVar.o()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i);
                throw new NoSuchElementException(sb.toString());
            }
            int i6 = i + 1;
            Object d02 = d0(dVar.p(i));
            if (d02 != null) {
                arrayList.add(d02);
            }
            i = i6;
        }
        return arrayList;
    }

    public static List e(int i, Vector vector) {
        boolean[] zArr = new boolean[i];
        Iterator<T> it = vector.getAcceptedItems().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (1 <= intValue && intValue < i + 1) {
                zArr[intValue - 1] = true;
            }
        }
        if (i == 0) {
            return q6.t.f8724a;
        }
        if (i == 1) {
            return a.a.H(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i6 = 0; i6 < i; i6++) {
            arrayList.add(Boolean.valueOf(zArr[i6]));
        }
        return arrayList;
    }

    public static HashMap e0(com.google.android.gms.internal.measurement.k kVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(kVar.f2678a.keySet());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            Object d02 = d0(kVar.c(str));
            if (d02 != null) {
                hashMap.put(str, d02);
            }
        }
        return hashMap;
    }

    public static void f(n9.a aVar, TextView... textViewArr) {
        Float f;
        Typeface typeface;
        int i = 0;
        if (aVar != null && (typeface = aVar.f8119a) != null) {
            int length = textViewArr.length;
            int i6 = 0;
            while (i6 < length) {
                TextView textView = textViewArr[i6];
                i6++;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
            }
        }
        if (aVar == null || (f = aVar.f8120b) == null) {
            return;
        }
        float floatValue = f.floatValue();
        int length2 = textViewArr.length;
        while (i < length2) {
            TextView textView2 = textViewArr[i];
            i++;
            if (textView2 != null) {
                textView2.setTextSize(2, floatValue);
            }
        }
    }

    public static void f0(y2.s sVar) {
        int b02 = b0(sVar.P("runtime.counter").g().doubleValue() + 1.0d);
        if (b02 <= 1000000) {
            sVar.N("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(b02)));
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Instructions allowed exceeded");
        }
    }

    public static final String g(Object[] objArr, int i, int i6, q6.f fVar) {
        StringBuilder sb = new StringBuilder((i6 * 3) + 2);
        sb.append("[");
        for (int i10 = 0; i10 < i6; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i10];
            if (obj == fVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void h(Bundle bundle) {
        bundle.putString("connectionType", z3.f ? "wifi" : "mobile");
        bundle.putLong("downBandwidthKbps", z3.f2929d);
        bundle.putLong("upBandwidthKbps", z3.f2930e);
    }

    public static void i(Context context, String str, Bundle bundle, boolean z9) {
        String C;
        context.getClass();
        str.getClass();
        if (z9) {
            bundle.putString("source", "deeplink");
            return;
        }
        x4.k kVar = UptodownApp.f3293g0;
        if (kVar != null) {
            String str2 = kVar.f11249c;
            if (str2 == null || str2.length() == 0) {
                x4.k kVar2 = UptodownApp.f3293g0;
                kVar2.getClass();
                String a8 = kVar2.a();
                if (a8 != null && a8.length() != 0 && (C = a.a.C(a8)) != null && C.equalsIgnoreCase(str)) {
                    bundle.putString("source", "deeplink");
                    return;
                }
            } else {
                x4.k kVar3 = UptodownApp.f3293g0;
                kVar3.getClass();
                if (l7.u.m0(kVar3.f11249c, str, true)) {
                    bundle.putString("source", "deeplink");
                    return;
                }
            }
        }
        x4.r1 A = i5.A(context);
        if (A == null || !l7.u.m0(A.f11372b, str, true)) {
            return;
        }
        bundle.putString("source", "notification_fcm");
    }

    public static Object j(j1.p pVar) {
        k0.y.f("Must not be called on the main application thread");
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && Objects.equals(myLooper.getThread().getName(), "GoogleApiHandler")) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Must not be called on GoogleApiHandler thread.");
            return null;
        }
        k0.y.h(pVar, "Task must not be null");
        if (pVar.h()) {
            return R(pVar);
        }
        g5.g gVar = new g5.g(3);
        Executor executor = j1.j.f6541b;
        pVar.c(executor, gVar);
        pVar.b(executor, gVar);
        pVar.f6561b.e(new j1.m(executor, (j1.c) gVar));
        pVar.p();
        ((CountDownLatch) gVar.f5315b).await();
        return R(pVar);
    }

    public static Object k(j1.p pVar, long j, TimeUnit timeUnit) {
        k0.y.f("Must not be called on the main application thread");
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && Objects.equals(myLooper.getThread().getName(), "GoogleApiHandler")) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Must not be called on GoogleApiHandler thread.");
            return null;
        }
        k0.y.h(pVar, "Task must not be null");
        k0.y.h(timeUnit, "TimeUnit must not be null");
        if (pVar.h()) {
            return R(pVar);
        }
        g5.g gVar = new g5.g(3);
        Executor executor = j1.j.f6541b;
        pVar.c(executor, gVar);
        pVar.b(executor, gVar);
        pVar.f6561b.e(new j1.m(executor, (j1.c) gVar));
        pVar.p();
        if (((CountDownLatch) gVar.f5315b).await(j, timeUnit)) {
            return R(pVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static w8.d l() {
        w8.d dVar = w8.d.f10951l;
        dVar.getClass();
        w8.d dVar2 = dVar.f;
        if (dVar2 == null) {
            long nanoTime = System.nanoTime();
            w8.d.i.await(w8.d.j, TimeUnit.MILLISECONDS);
            w8.d dVar3 = w8.d.f10951l;
            dVar3.getClass();
            if (dVar3.f != null || System.nanoTime() - nanoTime < w8.d.f10950k) {
                return null;
            }
            return w8.d.f10951l;
        }
        long nanoTime2 = dVar2.g - System.nanoTime();
        if (nanoTime2 > 0) {
            w8.d.i.await(nanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        w8.d dVar4 = w8.d.f10951l;
        dVar4.getClass();
        dVar4.f = dVar2.f;
        dVar2.f = null;
        return dVar2;
    }

    public static final String m(String str) {
        str.getClass();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(l7.a.f7151a);
        bytes.getClass();
        byte[] digest = messageDigest.digest(bytes);
        digest.getClass();
        return q6.j.k0(digest, "", g9.a.f5389l, 30);
    }

    public static b8.f n(String str, b8.e[] eVarArr) {
        if (l7.m.z0(str)) {
            com.google.gson.internal.a.p("Blank serial names are prohibited");
            return null;
        }
        b8.a aVar = new b8.a(str);
        return new b8.f(str, b8.i.h, aVar.f1099b.size(), q6.j.m0(eVarArr), aVar);
    }

    public static final b8.f o(String str, z3 z3Var, b8.e[] eVarArr, d7.l lVar) {
        if (l7.m.z0(str)) {
            com.google.gson.internal.a.p("Blank serial names are prohibited");
            return null;
        }
        if (z3Var.equals(b8.i.h)) {
            com.google.gson.internal.a.p("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        b8.a aVar = new b8.a(str);
        lVar.invoke(aVar);
        return new b8.f(str, z3Var, aVar.f1099b.size(), q6.j.m0(eVarArr), aVar);
    }

    public static b8.f p(String str, z3 z3Var, b8.e[] eVarArr) {
        if (l7.m.z0(str)) {
            com.google.gson.internal.a.p("Blank serial names are prohibited");
            return null;
        }
        if (z3Var.equals(b8.i.h)) {
            com.google.gson.internal.a.p("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            return null;
        }
        b8.a aVar = new b8.a(str);
        return new b8.f(str, z3Var, aVar.f1099b.size(), q6.j.m0(eVarArr), aVar);
    }

    public static j1.p q(Executor executor, Callable callable) {
        k0.y.h(executor, "Executor must not be null");
        j1.p pVar = new j1.p();
        executor.execute(new m1.a(28, pVar, callable));
        return pVar;
    }

    public static void r(int i, String str) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String s(String str, String str2) {
        String concat = "uptodown.native.1.".concat(str);
        return str2 != null ? a4.x.k(concat, ".", str2) : concat;
    }

    public static final long t(InputStream inputStream, OutputStream outputStream) {
        inputStream.getClass();
        byte[] bArr = new byte[8192];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    public static final void u(c4.k0 k0Var, String str) {
        if (k0Var.isFinishing() || str == null || str.length() == 0) {
            return;
        }
        AlertDialog alertDialog = k0Var.F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(k0Var);
        a4.d0 k5 = a4.d0.k(k0Var.getLayoutInflater());
        TextView textView = (TextView) k5.f83m;
        TextView textView2 = (TextView) k5.f84n;
        TextView textView3 = (TextView) k5.f85o;
        textView2.setTypeface(f4.c.f4883x);
        textView2.setText(k0Var.getString(2131952050));
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new c4.o(k0Var, 9));
        textView3.setTypeface(f4.c.f4882w);
        textView3.setText(k0Var.getString(2131952420));
        textView3.setOnClickListener(new g4.b0(21, k0Var, str));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(true);
        AlertDialog alertDialog2 = k0Var.F;
        if (alertDialog2 == null || !alertDialog2.isShowing()) {
            AlertDialog create = builder.create();
            k0Var.F = create;
            create.getClass();
            Window window = create.getWindow();
            if (window != null) {
                a4.x.y(window, 0);
            }
            AlertDialog alertDialog3 = k0Var.F;
            alertDialog3.getClass();
            alertDialog3.show();
        }
    }

    public static final void v(c4.k0 k0Var, String str, String str2) {
        k0Var.getClass();
        if (k0Var.isFinishing()) {
            return;
        }
        AlertDialog alertDialog = k0Var.F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(k0Var);
        View inflate = k0Var.getLayoutInflater().inflate(2131558512, (ViewGroup) null, false);
        int i = 2131362324;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362324);
        if (imageView != null) {
            i = 2131363974;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363974);
            if (textView != null) {
                i = 2131364014;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364014);
                if (textView2 != null) {
                    i = 2131364384;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364384);
                    if (textView3 != null) {
                        textView3.setTypeface(f4.c.f4882w);
                        textView3.setText(str);
                        textView2.setTypeface(f4.c.f4883x);
                        textView2.setText(str2);
                        textView.setTypeface(f4.c.f4882w);
                        textView.setOnClickListener(new c4.o(k0Var, 7));
                        imageView.setOnClickListener(new c4.o(k0Var, 8));
                        builder.setView((RelativeLayout) inflate);
                        builder.setCancelable(true);
                        AlertDialog alertDialog2 = k0Var.F;
                        if (alertDialog2 == null || !alertDialog2.isShowing()) {
                            AlertDialog create = builder.create();
                            k0Var.F = create;
                            create.getClass();
                            Window window = create.getWindow();
                            if (window != null) {
                                a4.x.y(window, 0);
                            }
                            AlertDialog alertDialog3 = k0Var.F;
                            alertDialog3.getClass();
                            alertDialog3.show();
                            return;
                        }
                        return;
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public static j1.p w(Exception exc) {
        j1.p pVar = new j1.p();
        pVar.m(exc);
        return pVar;
    }

    public static j1.p x(Object obj) {
        j1.p pVar = new j1.p();
        pVar.k(obj);
        return pVar;
    }

    public static void y(UptodownApp uptodownApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = FirebaseMessaging.getInstance(n1.f.c());
        }
        firebaseMessaging.getClass();
        j1.i iVar = new j1.i();
        firebaseMessaging.f.execute(new y1.n(3, firebaseMessaging, iVar));
        j1.p pVar = iVar.f6539a;
        v4.a aVar = new v4.a(uptodownApp, 0);
        pVar.getClass();
        pVar.f6561b.e(new j1.m(j1.j.f6540a, aVar));
        pVar.p();
    }

    public static ArrayList z(Context context) {
        x4.e B;
        int applicationEnabledSetting;
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        ArrayList arrayList = new ArrayList();
        Iterator it = l10.a0().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            q2 q2Var = (q2) next;
            String str = q2Var.f11344b;
            str.getClass();
            try {
                applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            } catch (Error e10) {
                e10.printStackTrace();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
                if (str.equalsIgnoreCase(context.getPackageName())) {
                    long j = q2Var.f11345l;
                    if (j > 0) {
                        if (j > 728) {
                            arrayList.add(q2Var);
                        }
                    }
                }
                if (!q2Var.c() && (B = l10.B(str)) != null && B.v == 0 && B.b(context)) {
                    arrayList.add(q2Var);
                }
            }
        }
        l10.c();
        return arrayList;
    }
}
