package e1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.f8;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.j6;
import com.google.android.gms.internal.measurement.k5;
import com.google.android.gms.internal.measurement.p5;
import com.google.android.gms.internal.measurement.q5;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a1 extends p4 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f3759m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(u4 u4Var, int i) {
        super(u4Var);
        this.f3759m = i;
    }

    public static boolean M(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean N(p5 p5Var, int i) {
        if (i < p5Var.size() * 64) {
            return ((1 << (i % 64)) & ((Long) p5Var.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static ArrayList O(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i6 = 0; i6 < 64; i6++) {
                int i10 = (i * 64) + i6;
                if (i10 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i10)) {
                    j |= 1 << i6;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static k5 T(k5 k5Var, byte[] bArr) {
        com.google.android.gms.internal.measurement.d5 d5Var;
        com.google.android.gms.internal.measurement.d5 d5Var2 = com.google.android.gms.internal.measurement.d5.f2539a;
        if (d5Var2 == null) {
            synchronized (com.google.android.gms.internal.measurement.d5.class) {
                try {
                    d5Var = com.google.android.gms.internal.measurement.d5.f2539a;
                    if (d5Var == null) {
                        j6 j6Var = j6.f2671c;
                        d5Var = i5.U();
                        com.google.android.gms.internal.measurement.d5.f2539a = d5Var;
                    }
                } finally {
                }
            }
            d5Var2 = d5Var;
        }
        if (d5Var2 != null) {
            k5Var.getClass();
            k5Var.f(bArr, bArr.length, d5Var2);
            return k5Var;
        }
        k5Var.getClass();
        int length = bArr.length;
        com.google.android.gms.internal.measurement.d5 d5Var3 = com.google.android.gms.internal.measurement.d5.f2539a;
        j6 j6Var2 = j6.f2671c;
        k5Var.f(bArr, length, com.google.android.gms.internal.measurement.d5.f2540b);
        return k5Var;
    }

    public static int U(com.google.android.gms.internal.measurement.i3 i3Var, String str) {
        for (int i = 0; i < ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).U1(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).V1(i).q())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle[] V(q5 q5Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = q5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            if (e3Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.e3 e3Var2 : e3Var.y()) {
                    if (e3Var2.q()) {
                        bundle.putString(e3Var2.p(), e3Var2.r());
                    } else if (e3Var2.s()) {
                        bundle.putLong(e3Var2.p(), e3Var2.t());
                    } else if (e3Var2.w()) {
                        bundle.putDouble(e3Var2.p(), e3Var2.x());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r4 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r7 >= r4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r5.add(W(false, (android.os.Bundle) r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0.put(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r3 instanceof java.util.ArrayList) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if (r7 >= r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r5.add(W(false, (android.os.Bundle) r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if ((r3 instanceof android.os.Bundle) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        r5.add(W(false, (android.os.Bundle) r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap W(boolean r10, android.os.Bundle r11) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r11.get(r2)
            boolean r4 = r3 instanceof android.os.Parcelable[]
            if (r4 != 0) goto L30
            boolean r5 = r3 instanceof java.util.ArrayList
            if (r5 != 0) goto L30
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto L2a
            goto L30
        L2a:
            if (r3 == 0) goto Ld
            r0.put(r2, r3)
            goto Ld
        L30:
            if (r10 == 0) goto Ld
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            if (r4 == 0) goto L52
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            int r4 = r3.length
            r7 = r6
        L3e:
            if (r7 >= r4) goto L80
            r8 = r3[r7]
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L4f
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = W(r6, r8)
            r5.add(r8)
        L4f:
            int r7 = r7 + 1
            goto L3e
        L52:
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 == 0) goto L73
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r4 = r3.size()
            r7 = r6
        L5d:
            if (r7 >= r4) goto L80
            java.lang.Object r8 = r3.get(r7)
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L70
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = W(r6, r8)
            r5.add(r8)
        L70:
            int r7 = r7 + 1
            goto L5d
        L73:
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L80
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.util.HashMap r3 = W(r6, r3)
            r5.add(r3)
        L80:
            r0.put(r2, r5)
            goto Ld
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.a1.W(boolean, android.os.Bundle):java.util.HashMap");
    }

    public static u k(com.google.android.gms.internal.measurement.b bVar) {
        Object obj;
        Bundle l10 = l(bVar.f2510c, true);
        String obj2 = (!l10.containsKey("_o") || (obj = l10.get("_o")) == null) ? "app" : obj.toString();
        String g = k2.g(bVar.f2508a, k2.f4072a, k2.f4074c);
        if (g == null) {
            g = bVar.f2508a;
        }
        return new u(g, new t(l10), obj2, bVar.f2509b);
    }

    public static Bundle l(Map map, boolean z9) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z9) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(l((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static final void m(com.google.android.gms.internal.measurement.a3 a3Var, String str, Long l10) {
        List g = a3Var.g();
        int i = 0;
        while (true) {
            if (i >= g.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.e3) g.get(i)).p())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.d3 A = com.google.android.gms.internal.measurement.e3.A();
        A.g(str);
        A.i(l10.longValue());
        if (i < 0) {
            a3Var.k(A);
        } else {
            a3Var.b();
            ((com.google.android.gms.internal.measurement.b3) a3Var.f2687b).z(i, (com.google.android.gms.internal.measurement.e3) A.d());
        }
    }

    public static final Bundle n(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            String p10 = e3Var.p();
            if (e3Var.w()) {
                bundle.putDouble(p10, e3Var.x());
            } else if (e3Var.u()) {
                bundle.putFloat(p10, e3Var.v());
            } else if (e3Var.q()) {
                bundle.putString(p10, e3Var.r());
            } else if (e3Var.s()) {
                bundle.putLong(p10, e3Var.t());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.e3 o(com.google.android.gms.internal.measurement.b3 b3Var, String str) {
        for (com.google.android.gms.internal.measurement.e3 e3Var : b3Var.o()) {
            if (e3Var.p().equals(str)) {
                return e3Var;
            }
        }
        return null;
    }

    public static final Serializable p(com.google.android.gms.internal.measurement.b3 b3Var, String str) {
        com.google.android.gms.internal.measurement.e3 o10 = o(b3Var, str);
        if (o10 == null) {
            return null;
        }
        return v(o10);
    }

    public static final void s(int i, StringBuilder sb) {
        for (int i6 = 0; i6 < i; i6++) {
            sb.append("  ");
        }
    }

    public static final void t(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static final String u(boolean z9, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder();
        if (z9) {
            sb.append("Dynamic ");
        }
        if (z10) {
            sb.append("Sequence ");
        }
        if (z11) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable v(com.google.android.gms.internal.measurement.e3 e3Var) {
        if (e3Var.q()) {
            return e3Var.r();
        }
        if (e3Var.s()) {
            return Long.valueOf(e3Var.t());
        }
        if (e3Var.w()) {
            return Double.valueOf(e3Var.x());
        }
        if (e3Var.z() > 0) {
            return V((q5) e3Var.y());
        }
        return null;
    }

    public static final void w(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] split = str.split(",");
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                t(builder, str3, string, set);
            }
        }
    }

    public static final void x(StringBuilder sb, String str, com.google.android.gms.internal.measurement.m3 m3Var) {
        if (m3Var == null) {
            return;
        }
        s(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (m3Var.r() != 0) {
            s(4, sb);
            sb.append("results: ");
            int i = 0;
            for (Long l10 : m3Var.q()) {
                int i6 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(l10);
                i = i6;
            }
            sb.append('\n');
        }
        if (m3Var.p() != 0) {
            s(4, sb);
            sb.append("status: ");
            int i10 = 0;
            for (Long l11 : m3Var.o()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(l11);
                i10 = i11;
            }
            sb.append('\n');
        }
        if (m3Var.t() != 0) {
            s(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i12 = 0;
            for (com.google.android.gms.internal.measurement.z2 z2Var : m3Var.s()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb.append(", ");
                }
                sb.append(z2Var.o() ? Integer.valueOf(z2Var.p()) : null);
                sb.append(":");
                sb.append(z2Var.q() ? Long.valueOf(z2Var.r()) : null);
                i12 = i13;
            }
            sb.append("}\n");
        }
        if (m3Var.v() != 0) {
            s(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i14 = 0;
            for (com.google.android.gms.internal.measurement.o3 o3Var : m3Var.u()) {
                int i15 = i14 + 1;
                if (i14 != 0) {
                    sb.append(", ");
                }
                sb.append(o3Var.o() ? Integer.valueOf(o3Var.p()) : null);
                sb.append(": [");
                Iterator it = o3Var.q().iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    int i17 = i16 + 1;
                    if (i16 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i16 = i17;
                }
                sb.append("]");
                i14 = i15;
            }
            sb.append("}\n");
        }
        s(3, sb);
        sb.append("}\n");
    }

    public static final void y(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        s(i + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void z(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.t1 t1Var) {
        if (t1Var == null) {
            return;
        }
        s(i, sb);
        sb.append(str);
        sb.append(" {\n");
        if (t1Var.o()) {
            int y9 = t1Var.y();
            y(sb, i, "comparison_type", y9 != 1 ? y9 != 2 ? y9 != 3 ? y9 != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (t1Var.p()) {
            y(sb, i, "match_as_float", Boolean.valueOf(t1Var.q()));
        }
        if (t1Var.r()) {
            y(sb, i, "comparison_value", t1Var.s());
        }
        if (t1Var.t()) {
            y(sb, i, "min_comparison_value", t1Var.u());
        }
        if (t1Var.v()) {
            y(sb, i, "max_comparison_value", t1Var.w());
        }
        s(i, sb);
        sb.append("}\n");
    }

    public boolean A() {
        h();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f3875a.f4259a.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public void E(com.google.android.gms.internal.measurement.r3 r3Var, Object obj) {
        k0.y.g(obj);
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).D();
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).F();
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).H();
        if (obj instanceof String) {
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).C((String) obj);
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).E(longValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2687b).G(doubleValue);
        } else {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public void F(String str, q4 q4Var, com.google.android.gms.internal.measurement.h3 h3Var, y0 y0Var) {
        String str2;
        URL url;
        byte[] a8;
        q1 q1Var;
        Map map;
        String str3 = q4Var.f4219a;
        t1 t1Var = this.f3875a;
        g();
        h();
        try {
            url = new URI(str3).toURL();
            this.f4092b.j0();
            a8 = h3Var.a();
            q1Var = t1Var.f4265p;
            t1.m(q1Var);
            map = q4Var.f4220b;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            q1Var.s(new z0(this, str2, url, a8, map, y0Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(str2), "Failed to parse URL. Not uploading MeasurementBatch. appId", str3);
        }
    }

    public void G(com.google.android.gms.internal.measurement.d3 d3Var, Object obj) {
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).D();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).F();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).H();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).K();
        if (obj instanceof String) {
            d3Var.h((String) obj);
            return;
        }
        if (obj instanceof Long) {
            d3Var.i(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            d3Var.b();
            ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).G(doubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.d3 A = com.google.android.gms.internal.measurement.e3.A();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.d3 A2 = com.google.android.gms.internal.measurement.e3.A();
                    A2.g(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        A2.i(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        A2.h((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double doubleValue2 = ((Double) obj2).doubleValue();
                        A2.b();
                        ((com.google.android.gms.internal.measurement.e3) A2.f2687b).G(doubleValue2);
                    }
                    A.b();
                    ((com.google.android.gms.internal.measurement.e3) A.f2687b).I((com.google.android.gms.internal.measurement.e3) A2.d());
                }
                if (((com.google.android.gms.internal.measurement.e3) A.f2687b).z() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.e3) A.d());
                }
            }
        }
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2687b).J(arrayList);
    }

    public j4 H(String str, com.google.android.gms.internal.measurement.i3 i3Var, com.google.android.gms.internal.measurement.a3 a3Var, String str2) {
        int indexOf;
        f8.a();
        t1 t1Var = this.f3875a;
        g gVar = t1Var.f4262m;
        if (!gVar.q(str, f0.Q0)) {
            return null;
        }
        t1Var.f4269t.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        String[] split = gVar.m(str, f0.f3958v0).split(",");
        HashSet hashSet = new HashSet(split.length);
        for (String str3 : split) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                c2.a.h(str3, "duplicate element: ");
                return null;
            }
        }
        Set unmodifiableSet = DesugarCollections.unmodifiableSet(hashSet);
        u4 u4Var = this.f4092b;
        r4 r4Var = u4Var.f4314s;
        m1 m1Var = u4Var.f4305a;
        m1 m1Var2 = r4Var.f4092b.f4305a;
        u4.U(m1Var2);
        String t9 = m1Var2.t(str);
        Uri.Builder builder = new Uri.Builder();
        g gVar2 = r4Var.f3875a.f4262m;
        builder.scheme(gVar2.m(str, f0.f3945o0));
        if (TextUtils.isEmpty(t9)) {
            builder.authority(gVar2.m(str, f0.f3947p0));
        } else {
            String m10 = gVar2.m(str, f0.f3947p0);
            StringBuilder sb = new StringBuilder(String.valueOf(t9).length() + 1 + String.valueOf(m10).length());
            sb.append(t9);
            sb.append(".");
            sb.append(m10);
            builder.authority(sb.toString());
        }
        builder.path(gVar2.m(str, f0.f3949q0));
        t(builder, "gmp_app_id", ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).D(), unmodifiableSet);
        gVar.l();
        t(builder, "gmp_version", String.valueOf(133005L), unmodifiableSet);
        String x3 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).x();
        e0 e0Var = f0.T0;
        if (gVar.q(str, e0Var)) {
            u4.U(m1Var);
            if (m1Var.z(str)) {
                x3 = "";
            }
        }
        t(builder, "app_instance_id", x3, unmodifiableSet);
        t(builder, "rdid", ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).u(), unmodifiableSet);
        t(builder, "bundle_id", i3Var.n(), unmodifiableSet);
        String m11 = a3Var.m();
        String g = k2.g(m11, k2.f4074c, k2.f4072a);
        if (true != TextUtils.isEmpty(g)) {
            m11 = g;
        }
        t(builder, "app_event_name", m11, unmodifiableSet);
        t(builder, "app_version", String.valueOf(((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).J()), unmodifiableSet);
        String h22 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).h2();
        if (gVar.q(str, e0Var)) {
            u4.U(m1Var);
            if (m1Var.y(str) && !TextUtils.isEmpty(h22) && (indexOf = h22.indexOf(".")) != -1) {
                h22 = h22.substring(0, indexOf);
            }
        }
        t(builder, "os_version", h22, unmodifiableSet);
        t(builder, "timestamp", String.valueOf(a3Var.n()), unmodifiableSet);
        if (((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).w()) {
            t(builder, "lat", "1", unmodifiableSet);
        }
        t(builder, "privacy_sandbox_version", String.valueOf(((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).F0()), unmodifiableSet);
        t(builder, "trigger_uri_source", "1", unmodifiableSet);
        t(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
        t(builder, "request_uuid", str2, unmodifiableSet);
        List<com.google.android.gms.internal.measurement.e3> g3 = a3Var.g();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.e3 e3Var : g3) {
            String p10 = e3Var.p();
            if (e3Var.w()) {
                bundle.putString(p10, String.valueOf(e3Var.x()));
            } else if (e3Var.u()) {
                bundle.putString(p10, String.valueOf(e3Var.v()));
            } else if (e3Var.q()) {
                bundle.putString(p10, e3Var.r());
            } else if (e3Var.s()) {
                bundle.putString(p10, String.valueOf(e3Var.t()));
            }
        }
        w(builder, gVar.m(str, f0.f3957u0).split("\\|"), bundle, unmodifiableSet);
        List<com.google.android.gms.internal.measurement.s3> unmodifiableList = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).T1());
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.s3 s3Var : unmodifiableList) {
            String q9 = s3Var.q();
            if (s3Var.x()) {
                bundle2.putString(q9, String.valueOf(s3Var.y()));
            } else if (s3Var.v()) {
                bundle2.putString(q9, String.valueOf(s3Var.w()));
            } else if (s3Var.r()) {
                bundle2.putString(q9, s3Var.s());
            } else if (s3Var.t()) {
                bundle2.putString(q9, String.valueOf(s3Var.u()));
            }
        }
        w(builder, gVar.m(str, f0.f3955t0).split("\\|"), bundle2, unmodifiableSet);
        t(builder, "dma", true != ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).C0() ? "0" : "1", unmodifiableSet);
        if (!((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).E0().isEmpty()) {
            t(builder, "dma_cps", ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).E0(), unmodifiableSet);
        }
        if (((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).K0()) {
            com.google.android.gms.internal.measurement.o2 L0 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2687b).L0();
            if (!L0.y().isEmpty()) {
                t(builder, "dl_gclid", L0.y(), unmodifiableSet);
            }
            if (!L0.A().isEmpty()) {
                t(builder, "dl_gbraid", L0.A(), unmodifiableSet);
            }
            if (!L0.C().isEmpty()) {
                t(builder, "dl_gs", L0.C(), unmodifiableSet);
            }
            if (L0.E() > 0) {
                t(builder, "dl_ss_ts", String.valueOf(L0.E()), unmodifiableSet);
            }
            if (!L0.G().isEmpty()) {
                t(builder, "mr_gclid", L0.G(), unmodifiableSet);
            }
            if (!L0.I().isEmpty()) {
                t(builder, "mr_gbraid", L0.I(), unmodifiableSet);
            }
            if (!L0.K().isEmpty()) {
                t(builder, "mr_gs", L0.K(), unmodifiableSet);
            }
            if (L0.M() > 0) {
                t(builder, "mr_click_ts", String.valueOf(L0.M()), unmodifiableSet);
            }
        }
        return new j4(builder.build().toString(), 1, currentTimeMillis);
    }

    public com.google.android.gms.internal.measurement.b3 I(q qVar) {
        com.google.android.gms.internal.measurement.a3 y9 = com.google.android.gms.internal.measurement.b3.y();
        long j = qVar.f4197e;
        y9.b();
        ((com.google.android.gms.internal.measurement.b3) y9.f2687b).G(j);
        t tVar = qVar.f;
        Objects.requireNonNull(tVar);
        Bundle bundle = tVar.f4251a;
        for (String str : bundle.keySet()) {
            com.google.android.gms.internal.measurement.d3 A = com.google.android.gms.internal.measurement.e3.A();
            A.g(str);
            Object obj = bundle.get(str);
            k0.y.g(obj);
            G(A, obj);
            y9.k(A);
        }
        String str2 = qVar.f4195c;
        if (!TextUtils.isEmpty(str2) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.d3 A2 = com.google.android.gms.internal.measurement.e3.A();
            A2.g("_o");
            A2.h(str2);
            y9.j((com.google.android.gms.internal.measurement.e3) A2.d());
        }
        return (com.google.android.gms.internal.measurement.b3) y9.d();
    }

    public String J(com.google.android.gms.internal.measurement.h3 h3Var) {
        com.google.android.gms.internal.measurement.r2 H0;
        StringBuilder t9 = a4.x.t("\nbatch {\n");
        if (h3Var.t()) {
            y(t9, 0, "upload_subdomain", h3Var.u());
        }
        if (h3Var.r()) {
            y(t9, 0, "sgtm_join_id", h3Var.s());
        }
        for (com.google.android.gms.internal.measurement.j3 j3Var : h3Var.o()) {
            if (j3Var != null) {
                s(1, t9);
                t9.append("bundle {\n");
                if (j3Var.O()) {
                    y(t9, 1, "protocol_version", Integer.valueOf(j3Var.O0()));
                }
                t1 t1Var = this.f3875a;
                g gVar = t1Var.f4262m;
                q0 q0Var = t1Var.f4268s;
                if (gVar.q(j3Var.o(), f0.N0) && j3Var.u0()) {
                    y(t9, 1, "session_stitching_token", j3Var.v0());
                }
                y(t9, 1, "platform", j3Var.g2());
                if (j3Var.q()) {
                    y(t9, 1, "gmp_version", Long.valueOf(j3Var.r()));
                }
                if (j3Var.s()) {
                    y(t9, 1, "uploading_gmp_version", Long.valueOf(j3Var.t()));
                }
                if (j3Var.q0()) {
                    y(t9, 1, "dynamite_version", Long.valueOf(j3Var.r0()));
                }
                if (j3Var.K()) {
                    y(t9, 1, "config_version", Long.valueOf(j3Var.L()));
                }
                y(t9, 1, "gmp_app_id", j3Var.D());
                y(t9, 1, "app_id", j3Var.o());
                y(t9, 1, "app_version", j3Var.p());
                if (j3Var.I()) {
                    y(t9, 1, "app_version_major", Integer.valueOf(j3Var.J()));
                }
                y(t9, 1, "firebase_instance_id", j3Var.H());
                if (j3Var.y()) {
                    y(t9, 1, "dev_cert_hash", Long.valueOf(j3Var.z()));
                }
                y(t9, 1, "app_store", j3Var.m2());
                if (j3Var.W1()) {
                    y(t9, 1, "upload_timestamp_millis", Long.valueOf(j3Var.X1()));
                }
                if (j3Var.Y1()) {
                    y(t9, 1, "start_timestamp_millis", Long.valueOf(j3Var.Z1()));
                }
                if (j3Var.a2()) {
                    y(t9, 1, "end_timestamp_millis", Long.valueOf(j3Var.b2()));
                }
                if (j3Var.c2()) {
                    y(t9, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(j3Var.d2()));
                }
                if (j3Var.e2()) {
                    y(t9, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(j3Var.f2()));
                }
                y(t9, 1, "app_instance_id", j3Var.x());
                y(t9, 1, "resettable_device_id", j3Var.u());
                y(t9, 1, "ds_id", j3Var.N());
                if (j3Var.v()) {
                    y(t9, 1, "limited_ad_tracking", Boolean.valueOf(j3Var.w()));
                }
                y(t9, 1, "os_version", j3Var.h2());
                y(t9, 1, "device_model", j3Var.i2());
                y(t9, 1, "user_default_language", j3Var.j2());
                if (j3Var.k2()) {
                    y(t9, 1, "time_zone_offset_minutes", Integer.valueOf(j3Var.l2()));
                }
                if (j3Var.A()) {
                    y(t9, 1, "bundle_sequential_index", Integer.valueOf(j3Var.B()));
                }
                if (j3Var.I0()) {
                    y(t9, 1, "delivery_index", Integer.valueOf(j3Var.J0()));
                }
                if (j3Var.E()) {
                    y(t9, 1, "service_upload", Boolean.valueOf(j3Var.F()));
                }
                y(t9, 1, "health_monitor", j3Var.C());
                if (j3Var.o0()) {
                    y(t9, 1, "retry_counter", Integer.valueOf(j3Var.p0()));
                }
                if (j3Var.s0()) {
                    y(t9, 1, "consent_signals", j3Var.t0());
                }
                if (j3Var.B0()) {
                    y(t9, 1, "is_dma_region", Boolean.valueOf(j3Var.C0()));
                }
                if (j3Var.D0()) {
                    y(t9, 1, "core_platform_services", j3Var.E0());
                }
                if (j3Var.z0()) {
                    y(t9, 1, "consent_diagnostics", j3Var.A0());
                }
                if (j3Var.w0()) {
                    y(t9, 1, "target_os_version", Long.valueOf(j3Var.x0()));
                }
                f8.a();
                if (t1Var.f4262m.q(j3Var.o(), f0.Q0)) {
                    y(t9, 1, "ad_services_version", Integer.valueOf(j3Var.F0()));
                    if (j3Var.G0() && (H0 = j3Var.H0()) != null) {
                        s(2, t9);
                        t9.append("attribution_eligibility_status {\n");
                        y(t9, 2, "eligible", Boolean.valueOf(H0.o()));
                        y(t9, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(H0.p()));
                        y(t9, 2, "pre_r", Boolean.valueOf(H0.q()));
                        y(t9, 2, "r_extensions_too_old", Boolean.valueOf(H0.r()));
                        y(t9, 2, "adservices_extension_too_old", Boolean.valueOf(H0.s()));
                        y(t9, 2, "ad_storage_not_allowed", Boolean.valueOf(H0.t()));
                        y(t9, 2, "measurement_manager_disabled", Boolean.valueOf(H0.u()));
                        s(2, t9);
                        t9.append("}\n");
                    }
                }
                if (j3Var.K0()) {
                    com.google.android.gms.internal.measurement.o2 L0 = j3Var.L0();
                    s(2, t9);
                    t9.append("ad_campaign_info {\n");
                    if (L0.x()) {
                        y(t9, 2, "deep_link_gclid", L0.y());
                    }
                    if (L0.z()) {
                        y(t9, 2, "deep_link_gbraid", L0.A());
                    }
                    if (L0.B()) {
                        y(t9, 2, "deep_link_gad_source", L0.C());
                    }
                    if (L0.D()) {
                        y(t9, 2, "deep_link_session_millis", Long.valueOf(L0.E()));
                    }
                    if (L0.F()) {
                        y(t9, 2, "market_referrer_gclid", L0.G());
                    }
                    if (L0.H()) {
                        y(t9, 2, "market_referrer_gbraid", L0.I());
                    }
                    if (L0.J()) {
                        y(t9, 2, "market_referrer_gad_source", L0.K());
                    }
                    if (L0.L()) {
                        y(t9, 2, "market_referrer_click_millis", Long.valueOf(L0.M()));
                    }
                    s(2, t9);
                    t9.append("}\n");
                }
                if (j3Var.P()) {
                    y(t9, 1, "batching_timestamp_millis", Long.valueOf(j3Var.Q()));
                }
                if (j3Var.M0()) {
                    com.google.android.gms.internal.measurement.q3 N0 = j3Var.N0();
                    s(2, t9);
                    t9.append("sgtm_diagnostics {\n");
                    int s6 = N0.s();
                    y(t9, 2, "upload_type", s6 != 1 ? s6 != 2 ? s6 != 3 ? s6 != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    y(t9, 2, "client_upload_eligibility", androidx.lifecycle.l.F(N0.o()));
                    int t10 = N0.t();
                    y(t9, 2, "service_upload_eligibility", t10 != 1 ? t10 != 2 ? t10 != 3 ? t10 != 4 ? t10 != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    s(2, t9);
                    t9.append("}\n");
                }
                if (j3Var.R()) {
                    com.google.android.gms.internal.measurement.x2 S = j3Var.S();
                    s(2, t9);
                    t9.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.w2 w2Var : S.o()) {
                        s(3, t9);
                        t9.append("limited_data_modes {\n");
                        int p10 = w2Var.p();
                        y(t9, 3, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, p10 != 1 ? p10 != 2 ? p10 != 3 ? p10 != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int q9 = w2Var.q();
                        y(t9, 3, "mode", q9 != 1 ? q9 != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        s(3, t9);
                        t9.append("}\n");
                    }
                    s(2, t9);
                    t9.append("}\n");
                }
                q5<com.google.android.gms.internal.measurement.s3> T1 = j3Var.T1();
                if (T1 != null) {
                    for (com.google.android.gms.internal.measurement.s3 s3Var : T1) {
                        if (s3Var != null) {
                            s(2, t9);
                            t9.append("user_property {\n");
                            y(t9, 2, "set_timestamp_millis", s3Var.o() ? Long.valueOf(s3Var.p()) : null);
                            y(t9, 2, "name", q0Var.c(s3Var.q()));
                            y(t9, 2, "string_value", s3Var.s());
                            y(t9, 2, "int_value", s3Var.t() ? Long.valueOf(s3Var.u()) : null);
                            y(t9, 2, "double_value", s3Var.x() ? Double.valueOf(s3Var.y()) : null);
                            s(2, t9);
                            t9.append("}\n");
                        }
                    }
                }
                q5<com.google.android.gms.internal.measurement.t2> G = j3Var.G();
                if (G != null) {
                    for (com.google.android.gms.internal.measurement.t2 t2Var : G) {
                        if (t2Var != null) {
                            s(2, t9);
                            t9.append("audience_membership {\n");
                            if (t2Var.o()) {
                                y(t9, 2, "audience_id", Integer.valueOf(t2Var.p()));
                            }
                            if (t2Var.t()) {
                                y(t9, 2, "new_audience", Boolean.valueOf(t2Var.u()));
                            }
                            x(t9, "current_data", t2Var.q());
                            if (t2Var.r()) {
                                x(t9, "previous_data", t2Var.s());
                            }
                            s(2, t9);
                            t9.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.b3> O1 = j3Var.O1();
                if (O1 != null) {
                    for (com.google.android.gms.internal.measurement.b3 b3Var : O1) {
                        if (b3Var != null) {
                            s(2, t9);
                            t9.append("event {\n");
                            y(t9, 2, "name", q0Var.a(b3Var.r()));
                            if (b3Var.s()) {
                                y(t9, 2, "timestamp_millis", Long.valueOf(b3Var.t()));
                            }
                            if (b3Var.u()) {
                                y(t9, 2, "previous_timestamp_millis", Long.valueOf(b3Var.v()));
                            }
                            if (b3Var.w()) {
                                y(t9, 2, "count", Integer.valueOf(b3Var.x()));
                            }
                            if (b3Var.p() != 0) {
                                q(t9, 2, (q5) b3Var.o());
                            }
                            s(2, t9);
                            t9.append("}\n");
                        }
                    }
                }
                s(1, t9);
                t9.append("}\n");
            }
        }
        t9.append("} // End-of-batch\n");
        return t9.toString();
    }

    public String K(com.google.android.gms.internal.measurement.v1 v1Var) {
        StringBuilder t9 = a4.x.t("\nproperty_filter {\n");
        if (v1Var.o()) {
            y(t9, 0, "filter_id", Integer.valueOf(v1Var.p()));
        }
        y(t9, 0, "property_name", this.f3875a.f4268s.c(v1Var.q()));
        String u7 = u(v1Var.s(), v1Var.t(), v1Var.v());
        if (!u7.isEmpty()) {
            y(t9, 0, "filter_type", u7);
        }
        r(t9, 1, v1Var.r());
        t9.append("}\n");
        return t9.toString();
    }

    public Parcelable L(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(obtain);
            } catch (l0.b unused) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.b("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            obtain.recycle();
        }
    }

    public List P(p5 p5Var, List list) {
        int i;
        ArrayList arrayList = new ArrayList(p5Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int intValue = num.intValue();
            t1 t1Var = this.f3875a;
            if (intValue < 0) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.c(num, "Ignoring negative bit index to be cleared");
            } else {
                int intValue2 = num.intValue() / 64;
                if (intValue2 >= arrayList.size()) {
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4342r.d(num, "Ignoring bit index greater than bitSet size", Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue2, Long.valueOf(((Long) arrayList.get(intValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i6 = size2;
            i = size;
            size = i6;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public boolean Q(long j, long j6) {
        if (j == 0 || j6 <= 0) {
            return true;
        }
        this.f3875a.f4269t.getClass();
        return Math.abs(System.currentTimeMillis() - j) > j6;
    }

    public long R(byte[] bArr) {
        k0.y.g(bArr);
        t1 t1Var = this.f3875a;
        a5 a5Var = t1Var.f4267r;
        t1.k(a5Var);
        a5Var.g();
        MessageDigest x3 = a5.x();
        if (x3 != null) {
            return a5.y(x3.digest(bArr));
        }
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.f4339o.b("Failed to get MD5");
        return 0L;
    }

    public byte[] S(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(e10, "Failed to gzip content");
            throw e10;
        }
    }

    @Override // e1.p4
    public final void j() {
        int i = this.f3759m;
    }

    public void q(StringBuilder sb, int i, q5 q5Var) {
        if (q5Var == null) {
            return;
        }
        int i6 = i + 1;
        Iterator it = q5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            if (e3Var != null) {
                s(i6, sb);
                sb.append("param {\n");
                y(sb, i6, "name", e3Var.o() ? this.f3875a.f4268s.b(e3Var.p()) : null);
                y(sb, i6, "string_value", e3Var.q() ? e3Var.r() : null);
                y(sb, i6, "int_value", e3Var.s() ? Long.valueOf(e3Var.t()) : null);
                y(sb, i6, "double_value", e3Var.w() ? Double.valueOf(e3Var.x()) : null);
                if (e3Var.z() > 0) {
                    q(sb, i6, (q5) e3Var.y());
                }
                s(i6, sb);
                sb.append("}\n");
            }
        }
    }

    public void r(StringBuilder sb, int i, com.google.android.gms.internal.measurement.q1 q1Var) {
        String str;
        if (q1Var == null) {
            return;
        }
        s(i, sb);
        sb.append("filter {\n");
        if (q1Var.s()) {
            y(sb, i, "complement", Boolean.valueOf(q1Var.t()));
        }
        if (q1Var.u()) {
            y(sb, i, "param_name", this.f3875a.f4268s.b(q1Var.v()));
        }
        if (q1Var.o()) {
            int i6 = i + 1;
            com.google.android.gms.internal.measurement.w1 p10 = q1Var.p();
            if (p10 != null) {
                s(i6, sb);
                sb.append("string_filter {\n");
                if (p10.o()) {
                    switch (p10.w()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    y(sb, i6, "match_type", str);
                }
                if (p10.p()) {
                    y(sb, i6, "expression", p10.q());
                }
                if (p10.r()) {
                    y(sb, i6, "case_sensitive", Boolean.valueOf(p10.s()));
                }
                if (p10.u() > 0) {
                    s(i + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : p10.t()) {
                        s(i + 3, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                s(i6, sb);
                sb.append("}\n");
            }
        }
        if (q1Var.q()) {
            z(sb, i + 1, "number_filter", q1Var.r());
        }
        s(i, sb);
        sb.append("}\n");
    }

    private final void B() {
    }

    private final void C() {
    }

    private final void D() {
    }
}
