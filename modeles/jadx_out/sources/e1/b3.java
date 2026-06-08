package e1;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import c4.n5;
import com.google.android.gms.internal.measurement.f8;
import j$.util.Comparator$CC;
import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b3 extends h0 {
    public final s1 A;
    public boolean B;
    public o2 C;
    public a3 D;
    public o2 E;
    public final a3.d F;

    /* renamed from: l, reason: collision with root package name */
    public x2 f3809l;

    /* renamed from: m, reason: collision with root package name */
    public android.support.v4.media.g f3810m;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArraySet f3811n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3812o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicReference f3813p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f3814q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3815r;

    /* renamed from: s, reason: collision with root package name */
    public int f3816s;

    /* renamed from: t, reason: collision with root package name */
    public o2 f3817t;

    /* renamed from: u, reason: collision with root package name */
    public o2 f3818u;
    public PriorityQueue v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3819w;

    /* renamed from: x, reason: collision with root package name */
    public j2 f3820x;

    /* renamed from: y, reason: collision with root package name */
    public final AtomicLong f3821y;

    /* renamed from: z, reason: collision with root package name */
    public long f3822z;

    public b3(t1 t1Var) {
        super(t1Var);
        this.f3811n = new CopyOnWriteArraySet();
        this.f3814q = new Object();
        this.f3815r = false;
        this.f3816s = 1;
        this.B = true;
        this.F = new a3.d(this, 24);
        this.f3813p = new AtomicReference();
        this.f3820x = j2.f4054c;
        this.f3822z = -1L;
        this.f3821y = new AtomicLong(0L);
        this.A = new s1(t1Var);
    }

    public final void A(Bundle bundle, int i, long j) {
        Boolean bool;
        String str;
        g2 g2Var;
        h();
        j2 j2Var = j2.f4054c;
        i2[] i2VarArr = h2.STORAGE.f4020a;
        int length = i2VarArr.length;
        int i6 = 0;
        while (true) {
            bool = null;
            if (i6 >= length) {
                str = null;
                break;
            }
            String str2 = i2VarArr[i6].f4038a;
            if (bundle.containsKey(str2) && (str = bundle.getString(str2)) != null) {
                if ((str.equals("granted") ? Boolean.TRUE : str.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i6++;
        }
        t1 t1Var = this.f3875a;
        if (str != null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4344t.c(str, "Ignoring invalid consent setting");
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4344t.b("Valid consent values are 'granted', 'denied'");
        }
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        boolean m10 = q1Var.m();
        j2 b7 = j2.b(i, bundle);
        Iterator it = b7.f4055a.values().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            g2Var = g2.UNINITIALIZED;
            if (!hasNext) {
                break;
            } else if (((g2) it.next()) != g2Var) {
                C(b7, m10);
                break;
            }
        }
        o c9 = o.c(i, bundle);
        Iterator it2 = c9.f4171e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((g2) it2.next()) != g2Var) {
                B(c9, m10);
                break;
            }
        }
        if (bundle != null) {
            int ordinal = j2.d(bundle.getString("ad_personalization")).ordinal();
            if (ordinal == 2) {
                bool = Boolean.FALSE;
            } else if (ordinal == 3) {
                bool = Boolean.TRUE;
            }
        }
        if (bool != null) {
            String str3 = i == -30 ? "tcf" : "app";
            if (m10) {
                r(j, bool.toString(), str3, "allow_personalized_ads");
            } else {
                q(str3, "allow_personalized_ads", bool.toString(), false, j);
            }
        }
    }

    public final void B(o oVar, boolean z9) {
        m1.a aVar = new m1.a(this, oVar, 9, false);
        if (z9) {
            g();
            aVar.run();
        } else {
            q1 q1Var = this.f3875a.f4265p;
            t1.m(q1Var);
            q1Var.p(aVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:75:0x010c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void C(e1.j2 r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b3.C(e1.j2, boolean):void");
    }

    public final void D() {
        f8.a();
        t1 t1Var = this.f3875a;
        g gVar = t1Var.f4262m;
        q1 q1Var = t1Var.f4265p;
        w0 w0Var = t1Var.f4264o;
        if (gVar.q(null, f0.R0)) {
            t1.m(q1Var);
            if (q1Var.m()) {
                t1.m(w0Var);
                w0Var.f4339o.b("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (q2.e.g()) {
                t1.m(w0Var);
                w0Var.f4339o.b("Cannot get trigger URIs from main thread");
                return;
            }
            h();
            t1.m(w0Var);
            w0Var.f4346w.b("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            t1.m(q1Var);
            q1Var.q(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "get trigger URIs", new u2(this, atomicReference, 5, false));
            final List list = (List) atomicReference.get();
            if (list == null) {
                t1.m(w0Var);
                w0Var.f4341q.b("Timed out waiting for get trigger URIs");
            } else {
                t1.m(q1Var);
                q1Var.p(new Runnable() { // from class: e1.y2
                    @Override // java.lang.Runnable
                    public final void run() {
                        b3 b3Var = b3.this;
                        b3Var.g();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        g1 g1Var = b3Var.f3875a.f4263n;
                        t1.k(g1Var);
                        SparseArray m10 = g1Var.m();
                        for (j4 j4Var : list) {
                            int i = j4Var.f4064l;
                            if (!m10.contains(i) || ((Long) m10.get(i)).longValue() < j4Var.f4063b) {
                                b3Var.E().add(j4Var);
                            }
                        }
                        b3Var.F();
                    }
                });
            }
        }
    }

    public final PriorityQueue E() {
        if (this.v == null) {
            this.v = new PriorityQueue(Comparator$CC.comparing(z2.f4457a, n5.f1901b));
        }
        return this.v;
    }

    public final void F() {
        j4 j4Var;
        g();
        this.f3819w = false;
        if (E().isEmpty() || this.f3815r || (j4Var = (j4) E().poll()) == null) {
            return;
        }
        t1 t1Var = this.f3875a;
        a5 a5Var = t1Var.f4267r;
        t1.k(a5Var);
        if (a5Var.f3776o == null) {
            a5Var.f3776o = MeasurementManagerFutures.from(a5Var.f3875a.f4259a);
        }
        MeasurementManagerFutures measurementManagerFutures = a5Var.f3776o;
        if (measurementManagerFutures != null) {
            this.f3815r = true;
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            u0 u0Var = w0Var.f4346w;
            String str = j4Var.f4062a;
            u0Var.c(str, "Registering trigger URI");
            m1.b registerTriggerAsync = measurementManagerFutures.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync != null) {
                registerTriggerAsync.addListener(new m1.a(0, registerTriggerAsync, new android.support.v4.media.g(this, j4Var, 7, false)), new p2(this, 0));
            } else {
                this.f3815r = false;
                E().add(j4Var);
            }
        }
    }

    @Override // e1.h0
    public final boolean j() {
        return false;
    }

    public final void k(j2 j2Var) {
        g();
        boolean z9 = (j2Var.i(i2.ANALYTICS_STORAGE) && j2Var.i(i2.AD_STORAGE)) || this.f3875a.p().p();
        t1 t1Var = this.f3875a;
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.g();
        if (z9 != t1Var.I) {
            q1 q1Var2 = t1Var.f4265p;
            t1.m(q1Var2);
            q1Var2.g();
            t1Var.I = z9;
            g1 g1Var = this.f3875a.f4263n;
            t1.k(g1Var);
            g1Var.g();
            Boolean valueOf = g1Var.k().contains("measurement_enabled_from_api") ? Boolean.valueOf(g1Var.k().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z9 || valueOf == null || valueOf.booleanValue()) {
                x(Boolean.valueOf(z9), false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r4 > 500) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        if (r6 > 500) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(java.lang.String r13, java.lang.String r14, android.os.Bundle r15, boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b3.l(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void m() {
        w0 w0Var;
        String str;
        int i;
        int i6;
        int i10;
        int i11;
        g4 g4Var;
        g4 g4Var2;
        b3 b3Var;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        String str2;
        com.google.android.gms.internal.measurement.r4 r4Var;
        l1.n a8;
        g();
        t1 t1Var = this.f3875a;
        w0 w0Var2 = t1Var.f4264o;
        p0.a aVar = t1Var.f4269t;
        t1.m(w0Var2);
        w0Var2.v.b("Handle tcf update.");
        g1 g1Var = t1Var.f4263n;
        t1.k(g1Var);
        SharedPreferences l10 = g1Var.l();
        HashMap hashMap = new HashMap();
        e0 e0Var = f0.f3914a1;
        int i19 = 2;
        int i20 = 1;
        if (((Boolean) e0Var.a(null)).booleanValue()) {
            l1.i iVar = i4.f4047a;
            com.google.android.gms.internal.measurement.q4 q4Var = com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            w0Var = w0Var2;
            h4 h4Var = h4.f4027a;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(q4Var, h4Var);
            com.google.android.gms.internal.measurement.q4 q4Var2 = com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            h4 h4Var2 = h4.f4028b;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(q4Var2, h4Var2);
            com.google.android.gms.internal.measurement.q4 q4Var3 = com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(q4Var3, h4Var);
            com.google.android.gms.internal.measurement.q4 q4Var4 = com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(q4Var4, h4Var);
            com.google.android.gms.internal.measurement.q4 q4Var5 = com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            List asList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(q4Var5, h4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, h4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.q4.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, h4Var2));
            f8.o oVar = new f8.o(asList instanceof Collection ? asList.size() : 4);
            oVar.f(asList);
            l1.n a10 = oVar.a();
            int i21 = l1.g.f7060l;
            l1.p pVar = new l1.p("CH");
            char[] cArr = new char[5];
            boolean contains = l10.contains("IABTCF_TCString");
            try {
                i12 = l10.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused) {
                i12 = -1;
            }
            try {
                i13 = l10.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused2) {
                i13 = -1;
            }
            try {
                i14 = l10.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused3) {
                i14 = -1;
            }
            int i22 = i13;
            try {
                i15 = l10.getInt("IABTCF_PurposeOneTreatment", -1);
            } catch (ClassCastException unused4) {
                i15 = -1;
            }
            try {
                i16 = l10.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused5) {
                i16 = -1;
            }
            String a11 = i4.a(l10, "IABTCF_PublisherCC");
            int i23 = i12;
            f8.o oVar2 = new f8.o(4);
            l1.l lVar = a10.f7058b;
            if (lVar == null) {
                str2 = a11;
                i17 = i15;
                i18 = i16;
                l1.l lVar2 = new l1.l(a10, new l1.m(a10.f7078n, 0, a10.f7079o));
                a10.f7058b = lVar2;
                lVar = lVar2;
            } else {
                i17 = i15;
                i18 = i16;
                str2 = a11;
            }
            l1.q it = lVar.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                r4Var = com.google.android.gms.internal.measurement.r4.PURPOSE_RESTRICTION_UNDEFINED;
                if (!hasNext) {
                    break;
                }
                com.google.android.gms.internal.measurement.q4 q4Var6 = (com.google.android.gms.internal.measurement.q4) it.next();
                int a12 = q4Var6.a();
                l1.q qVar = it;
                l1.n nVar = a10;
                StringBuilder sb = new StringBuilder(String.valueOf(a12).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(a12);
                String a13 = i4.a(l10, sb.toString());
                if (!TextUtils.isEmpty(a13) && a13.length() >= 755) {
                    int digit = Character.digit(a13.charAt(754), 10);
                    com.google.android.gms.internal.measurement.r4 r4Var2 = com.google.android.gms.internal.measurement.r4.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    if (digit < 0 || digit > com.google.android.gms.internal.measurement.r4.values().length || digit == 0) {
                        r4Var = r4Var2;
                    } else if (digit == i20) {
                        r4Var = com.google.android.gms.internal.measurement.r4.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (digit == i19) {
                        r4Var = com.google.android.gms.internal.measurement.r4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                oVar2.e(q4Var6, r4Var);
                it = qVar;
                a10 = nVar;
                i19 = 2;
                i20 = 1;
            }
            l1.n nVar2 = a10;
            l1.n a14 = oVar2.a();
            String a15 = i4.a(l10, "IABTCF_PurposeConsents");
            String a16 = i4.a(l10, "IABTCF_VendorConsents");
            boolean z9 = !TextUtils.isEmpty(a16) && a16.length() >= 755 && a16.charAt(754) == '1';
            String a17 = i4.a(l10, "IABTCF_PurposeLegitimateInterests");
            String a18 = i4.a(l10, "IABTCF_VendorLegitimateInterests");
            boolean z10 = !TextUtils.isEmpty(a18) && a18.length() >= 755 && a18.charAt(754) == '1';
            cArr[0] = '2';
            if (contains) {
                com.google.android.gms.internal.measurement.r4 r4Var3 = (com.google.android.gms.internal.measurement.r4) a14.get(q4Var);
                com.google.android.gms.internal.measurement.r4 r4Var4 = (com.google.android.gms.internal.measurement.r4) a14.get(q4Var3);
                com.google.android.gms.internal.measurement.r4 r4Var5 = (com.google.android.gms.internal.measurement.r4) a14.get(q4Var4);
                com.google.android.gms.internal.measurement.r4 r4Var6 = (com.google.android.gms.internal.measurement.r4) a14.get(q4Var5);
                f8.o oVar3 = new f8.o(4);
                oVar3.e("Version", ExifInterface.GPS_MEASUREMENT_2D);
                boolean z11 = z9;
                oVar3.e("VendorConsent", true != z9 ? "0" : "1");
                boolean z12 = z10;
                oVar3.e("VendorLegitimateInterest", true != z10 ? "0" : "1");
                oVar3.e("gdprApplies", i14 != 1 ? "0" : "1");
                int i24 = i18;
                oVar3.e("EnableAdvertiserConsentMode", i24 != 1 ? "0" : "1");
                oVar3.e("PolicyVersion", String.valueOf(i22));
                oVar3.e("CmpSdkID", String.valueOf(i23));
                int i25 = i17;
                oVar3.e("PurposeOneTreatment", i25 != 1 ? "0" : "1");
                String str3 = str2;
                oVar3.e("PublisherCC", str3);
                oVar3.e("PublisherRestrictions1", String.valueOf(r4Var3 != null ? r4Var3.a() : r4Var.a()));
                oVar3.e("PublisherRestrictions3", String.valueOf(r4Var4 != null ? r4Var4.a() : r4Var.a()));
                oVar3.e("PublisherRestrictions4", String.valueOf(r4Var5 != null ? r4Var5.a() : r4Var.a()));
                oVar3.e("PublisherRestrictions7", String.valueOf(r4Var6 != null ? r4Var6.a() : r4Var.a()));
                oVar3.f(l1.n.a(4, new Object[]{"Purpose1", i4.d(q4Var, a15, a17), "Purpose3", i4.d(q4Var3, a15, a17), "Purpose4", i4.d(q4Var4, a15, a17), "Purpose7", i4.d(q4Var5, a15, a17)}, null).entrySet());
                int i26 = i14;
                oVar3.f(l1.n.a(5, new Object[]{"AuthorizePurpose1", true != i4.b(q4Var, nVar2, a14, pVar, cArr, i24, i26, i25, str3, a15, a17, z11, z12) ? "0" : "1", "AuthorizePurpose3", true != i4.b(q4Var3, nVar2, a14, pVar, cArr, i24, i26, i25, str3, a15, a17, z11, z12) ? "0" : "1", "AuthorizePurpose4", true != i4.b(q4Var4, nVar2, a14, pVar, cArr, i24, i26, i25, str3, a15, a17, z11, z12) ? "0" : "1", "AuthorizePurpose7", true != i4.b(q4Var5, nVar2, a14, pVar, cArr, i24, i26, i25, str3, a15, a17, z11, z12) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null).entrySet());
                a8 = oVar3.a();
            } else {
                a8 = l1.n.f7076p;
            }
            g4Var = new g4(a8);
            str = "";
        } else {
            w0Var = w0Var2;
            String a19 = i4.a(l10, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(a19) && a19.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(a19.charAt(754)));
            }
            try {
                i = l10.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused6) {
                i = -1;
            }
            if (i != -1) {
                hashMap.put("gdprApplies", String.valueOf(i));
            }
            try {
                i6 = l10.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused7) {
                i6 = -1;
            }
            if (i6 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(i6));
            }
            try {
                i10 = l10.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused8) {
                i10 = -1;
            }
            if (i10 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(i10));
            }
            String a20 = i4.a(l10, "IABTCF_PurposeConsents");
            if (!str.equals(a20)) {
                hashMap.put("PurposeConsents", a20);
            }
            try {
                i11 = l10.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused9) {
                i11 = -1;
            }
            if (i11 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(i11));
            }
            g4Var = new g4(hashMap);
        }
        t1.m(w0Var);
        w0 w0Var3 = w0Var;
        u0 u0Var = w0Var3.f4346w;
        u0Var.c(g4Var, "Tcf preferences read");
        if (!t1Var.f4262m.q(null, e0Var)) {
            if (g1Var.o(g4Var)) {
                Bundle b7 = g4Var.b();
                t1.m(w0Var3);
                u0Var.c(b7, "Consent generated from Tcf");
                if (b7 != Bundle.EMPTY) {
                    aVar.getClass();
                    A(b7, -30, System.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", g4Var.c());
                n("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        g1Var.g();
        String string = g1Var.k().getString("stored_tcf_param", str);
        HashMap hashMap2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            g4Var2 = new g4(hashMap2);
        } else {
            for (String str4 : string.split(";")) {
                String[] split = str4.split("=");
                if (split.length >= 2 && i4.f4047a.contains(split[0])) {
                    hashMap2.put(split[0], split[1]);
                }
            }
            g4Var2 = new g4(hashMap2);
        }
        if (g1Var.o(g4Var)) {
            Bundle b10 = g4Var.b();
            t1.m(w0Var3);
            u0Var.c(b10, "Consent generated from Tcf");
            if (b10 != Bundle.EMPTY) {
                aVar.getClass();
                b3Var = this;
                b3Var.A(b10, -30, System.currentTimeMillis());
            } else {
                b3Var = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap hashMap3 = g4Var2.f4002a;
            String str5 = (hashMap3.isEmpty() || ((String) hashMap3.get("Version")) != null) ? "0" : "1";
            Bundle b11 = g4Var.b();
            Bundle b12 = g4Var2.b();
            bundle2.putString("_tcfm", str5.concat((b11.size() == b12.size() && Objects.equals(b11.getString("ad_storage"), b12.getString("ad_storage")) && Objects.equals(b11.getString("ad_personalization"), b12.getString("ad_personalization")) && Objects.equals(b11.getString("ad_user_data"), b12.getString("ad_user_data"))) ? "0" : "1"));
            String str6 = (String) g4Var.f4002a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str6)) {
                str6 = "200000";
            }
            bundle2.putString("_tcfd2", str6);
            bundle2.putString("_tcfd", g4Var.c());
            b3Var.n("auto", "_tcf", bundle2);
        }
    }

    public final void n(String str, String str2, Bundle bundle) {
        g();
        this.f3875a.f4269t.getClass();
        o(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void o(long j, Bundle bundle, String str, String str2) {
        g();
        boolean z9 = true;
        if (this.f3810m != null && !a5.F(str2)) {
            z9 = false;
        }
        p(str, str2, j, bundle, true, z9, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.lang.String r32, java.lang.String r33, long r34, android.os.Bundle r36, boolean r37, boolean r38, boolean r39) {
        /*
            Method dump skipped, instructions count: 1271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b3.p(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    public final void q(String str, String str2, Object obj, boolean z9, long j) {
        int i;
        int length;
        t1 t1Var = this.f3875a;
        if (z9) {
            a5 a5Var = t1Var.f4267r;
            t1.k(a5Var);
            i = a5Var.m0(str2);
        } else {
            a5 a5Var2 = t1Var.f4267r;
            t1.k(a5Var2);
            if (a5Var2.h0("user property", str2)) {
                if (a5Var2.j0("user property", k2.i, null, str2)) {
                    a5Var2.f3875a.getClass();
                    if (a5Var2.k0(24, "user property", str2)) {
                        i = 0;
                    }
                } else {
                    i = 15;
                }
            }
            i = 6;
        }
        a3.d dVar = this.F;
        if (i != 0) {
            t1.k(t1Var.f4267r);
            String l10 = a5.l(24, str2, true);
            length = str2 != null ? str2.length() : 0;
            t1.k(t1Var.f4267r);
            a5.w(dVar, null, i, "_ev", l10, length);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj == null) {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new w1(this, str3, str2, null, j, 1));
            return;
        }
        a5 a5Var3 = t1Var.f4267r;
        a5 a5Var4 = t1Var.f4267r;
        t1.k(a5Var3);
        int t9 = a5Var3.t(obj, str2);
        if (t9 != 0) {
            t1.k(a5Var4);
            String l11 = a5.l(24, str2, true);
            length = ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0;
            t1.k(a5Var4);
            a5.w(dVar, null, t9, "_ev", l11, length);
            return;
        }
        t1.k(a5Var4);
        Object u7 = a5Var4.u(obj, str2);
        if (u7 != null) {
            q1 q1Var2 = t1Var.f4265p;
            t1.m(q1Var2);
            q1Var2.p(new w1(this, str3, str2, u7, j, 1));
        }
    }

    public final void r(long j, Object obj, String str, String str2) {
        String str3;
        boolean n10;
        Object obj2 = obj;
        k0.y.d(str);
        k0.y.d(str2);
        g();
        h();
        boolean equals = "allow_personalized_ads".equals(str2);
        t1 t1Var = this.f3875a;
        if (equals) {
            String str4 = "_npa";
            if (obj2 instanceof String) {
                String str5 = (String) obj2;
                if (!TextUtils.isEmpty(str5)) {
                    long j6 = true != "false".equals(str5.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    obj2 = Long.valueOf(j6);
                    g1 g1Var = t1Var.f4263n;
                    t1.k(g1Var);
                    g1Var.v.o(j6 == 1 ? "true" : "false");
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4346w.d("non_personalized_ads(_npa)", "Setting user property(FE)", obj2);
                    str3 = str4;
                }
            }
            if (obj2 == null) {
                g1 g1Var2 = t1Var.f4263n;
                t1.k(g1Var2);
                g1Var2.v.o("unset");
            } else {
                str4 = str2;
            }
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4346w.d("non_personalized_ads(_npa)", "Setting user property(FE)", obj2);
            str3 = str4;
        } else {
            str3 = str2;
        }
        Object obj3 = obj2;
        if (!t1Var.d()) {
            w0 w0Var3 = t1Var.f4264o;
            t1.m(w0Var3);
            w0Var3.f4346w.b("User property not set since app measurement is disabled");
            return;
        }
        if (t1Var.h()) {
            x4 x4Var = new x4(j, obj3, str3, str);
            w3 p10 = t1Var.p();
            p10.g();
            p10.h();
            p10.s();
            p0 o10 = p10.f3875a.o();
            o10.getClass();
            Parcel obtain = Parcel.obtain();
            android.support.v4.media.f.b(x4Var, obtain);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            if (marshall.length > 131072) {
                w0 w0Var4 = o10.f3875a.f4264o;
                t1.m(w0Var4);
                w0Var4.f4340p.b("User property too long for local database. Sending directly to service");
                n10 = false;
            } else {
                n10 = o10.n(1, marshall);
            }
            p10.u(new q3(p10, p10.w(true), n10, x4Var, 0));
        }
    }

    public final void s() {
        g();
        h();
        t1 t1Var = this.f3875a;
        if (t1Var.h()) {
            g gVar = t1Var.f4262m;
            gVar.f3875a.getClass();
            Boolean s6 = gVar.s("google_analytics_deferred_deep_link_enabled");
            if (s6 != null && s6.booleanValue()) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.v.b("Deferred Deep Link feature enabled.");
                q1 q1Var = t1Var.f4265p;
                t1.m(q1Var);
                q1Var.p(new n2(this, 2));
            }
            w3 p10 = t1Var.p();
            p10.g();
            p10.h();
            c5 w2 = p10.w(true);
            p10.s();
            t1 t1Var2 = p10.f3875a;
            t1Var2.f4262m.q(null, f0.f3919c1);
            t1Var2.o().n(3, new byte[0]);
            p10.u(new r3(p10, w2, 1));
            this.B = false;
            g1 g1Var = t1Var.f4263n;
            t1.k(g1Var);
            g1Var.g();
            String string = g1Var.k().getString("previous_os_version", null);
            g1Var.f3875a.q().i();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = g1Var.k().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            t1Var.q().i();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            n("auto", "_ou", bundle);
        }
    }

    public final void t(Bundle bundle, long j) {
        k0.y.g(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean isEmpty = TextUtils.isEmpty(bundle2.getString("app_id"));
        t1 t1Var = this.f3875a;
        if (!isEmpty) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.b("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        k2.e(bundle2, "app_id", String.class, null);
        k2.e(bundle2, "origin", String.class, null);
        k2.e(bundle2, "name", String.class, null);
        k2.e(bundle2, "value", Object.class, null);
        k2.e(bundle2, "trigger_event_name", String.class, null);
        k2.e(bundle2, "trigger_timeout", Long.class, 0L);
        k2.e(bundle2, "timed_out_event_name", String.class, null);
        k2.e(bundle2, "timed_out_event_params", Bundle.class, null);
        k2.e(bundle2, "triggered_event_name", String.class, null);
        k2.e(bundle2, "triggered_event_params", Bundle.class, null);
        k2.e(bundle2, "time_to_live", Long.class, 0L);
        k2.e(bundle2, "expired_event_name", String.class, null);
        k2.e(bundle2, "expired_event_params", Bundle.class, null);
        k0.y.d(bundle2.getString("name"));
        k0.y.d(bundle2.getString("origin"));
        k0.y.g(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        a5 a5Var = t1Var.f4267r;
        q0 q0Var = t1Var.f4268s;
        w0 w0Var2 = t1Var.f4264o;
        t1.k(a5Var);
        if (a5Var.m0(string) != 0) {
            t1.m(w0Var2);
            w0Var2.f4339o.c(q0Var.c(string), "Invalid conditional user property name");
            return;
        }
        t1.k(a5Var);
        if (a5Var.t(obj, string) != 0) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(q0Var.c(string), "Invalid conditional user property value", obj);
            return;
        }
        Object u7 = a5Var.u(obj, string);
        if (u7 == null) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(q0Var.c(string), "Unable to normalize conditional user property value", obj);
            return;
        }
        k2.c(bundle2, u7);
        long j6 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j6 > 15552000000L || j6 < 1)) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(q0Var.c(string), "Invalid conditional user property timeout", Long.valueOf(j6));
            return;
        }
        long j10 = bundle2.getLong("time_to_live");
        if (j10 > 15552000000L || j10 < 1) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(q0Var.c(string), "Invalid conditional user property time to live", Long.valueOf(j10));
        } else {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new v2(this, bundle2, 0));
        }
    }

    public final void u(String str, String str2, Bundle bundle) {
        t1 t1Var = this.f3875a;
        t1Var.f4269t.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        k0.y.d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.p(new v2(this, bundle2, 1));
    }

    public final String v() {
        t1 t1Var = this.f3875a;
        try {
            return k2.b(t1Var.f4259a, t1Var.f4273y);
        } catch (IllegalStateException e10) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(e10, "getGoogleAppId failed with exception");
            return null;
        }
    }

    public final void w(j2 j2Var, long j, boolean z9) {
        int i = j2Var.f4056b;
        g();
        h();
        t1 t1Var = this.f3875a;
        g1 g1Var = t1Var.f4263n;
        w0 w0Var = t1Var.f4264o;
        t1.k(g1Var);
        j2 n10 = g1Var.n();
        if (j <= this.f3822z && j2.l(n10.f4056b, i)) {
            t1.m(w0Var);
            w0Var.f4345u.c(j2Var, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        g1 g1Var2 = t1Var.f4263n;
        t1.k(g1Var2);
        g1Var2.g();
        if (!j2.l(i, g1Var2.k().getInt("consent_source", 100))) {
            t1.m(w0Var);
            w0Var.f4345u.c(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor edit = g1Var2.k().edit();
        edit.putString("consent_settings", j2Var.g());
        edit.putInt("consent_source", i);
        edit.apply();
        t1.m(w0Var);
        w0Var.f4346w.c(j2Var, "Setting storage consent(FE)");
        this.f3822z = j;
        if (t1Var.p().q()) {
            w3 p10 = t1Var.p();
            p10.g();
            p10.h();
            p10.u(new u3(p10, 2));
        } else {
            w3 p11 = t1Var.p();
            p11.g();
            p11.h();
            if (p11.p()) {
                p11.u(new r3(p11, p11.w(false)));
            }
        }
        if (z9) {
            t1Var.p().k(new AtomicReference());
        }
    }

    public final void x(Boolean bool, boolean z9) {
        g();
        h();
        t1 t1Var = this.f3875a;
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.v.c(bool, "Setting app measurement enabled (FE)");
        g1 g1Var = t1Var.f4263n;
        t1.k(g1Var);
        g1Var.g();
        SharedPreferences.Editor edit = g1Var.k().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
        if (z9) {
            g1Var.g();
            SharedPreferences.Editor edit2 = g1Var.k().edit();
            if (bool != null) {
                edit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit2.remove("measurement_enabled_from_api");
            }
            edit2.apply();
        }
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.g();
        if (t1Var.I || !(bool == null || bool.booleanValue())) {
            y();
        }
    }

    public final void y() {
        g();
        t1 t1Var = this.f3875a;
        g1 g1Var = t1Var.f4263n;
        w0 w0Var = t1Var.f4264o;
        p0.a aVar = t1Var.f4269t;
        t1.k(g1Var);
        String n10 = g1Var.v.n();
        if (n10 != null) {
            if ("unset".equals(n10)) {
                aVar.getClass();
                r(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                Long valueOf = Long.valueOf(true != "true".equals(n10) ? 0L : 1L);
                aVar.getClass();
                r(System.currentTimeMillis(), valueOf, "app", "_npa");
            }
        }
        if (!t1Var.d() || !this.B) {
            t1.m(w0Var);
            w0Var.v.b("Updating Scion state (FE)");
            w3 p10 = t1Var.p();
            p10.g();
            p10.h();
            p10.u(new r3(p10, p10.w(true), 3));
            return;
        }
        t1.m(w0Var);
        w0Var.v.b("Recording app launch after enabling measurement for the first time (FE)");
        s();
        f4 f4Var = t1Var.f4266q;
        t1.l(f4Var);
        f4Var.f3974n.G();
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.p(new n2(this, 1));
    }

    public final void z() {
        t1 t1Var = this.f3875a;
        if (!(t1Var.f4259a.getApplicationContext() instanceof Application) || this.f3809l == null) {
            return;
        }
        ((Application) t1Var.f4259a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f3809l);
    }
}
