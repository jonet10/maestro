package e1;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.t5;
import com.google.android.gms.internal.measurement.z5;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m1 extends p4 implements f {

    /* renamed from: m, reason: collision with root package name */
    public final ArrayMap f4105m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayMap f4106n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayMap f4107o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayMap f4108p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayMap f4109q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayMap f4110r;

    /* renamed from: s, reason: collision with root package name */
    public final j1 f4111s;

    /* renamed from: t, reason: collision with root package name */
    public final f0.i f4112t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayMap f4113u;
    public final ArrayMap v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayMap f4114w;

    public m1(u4 u4Var) {
        super(u4Var);
        this.f4105m = new ArrayMap();
        this.f4106n = new ArrayMap();
        this.f4107o = new ArrayMap();
        this.f4108p = new ArrayMap();
        this.f4109q = new ArrayMap();
        this.f4113u = new ArrayMap();
        this.v = new ArrayMap();
        this.f4114w = new ArrayMap();
        this.f4110r = new ArrayMap();
        this.f4111s = new j1(this);
        this.f4112t = new f0.i(this, 21);
    }

    public static final ArrayMap q(com.google.android.gms.internal.measurement.f2 f2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.j2 j2Var : f2Var.s()) {
            arrayMap.put(j2Var.o(), j2Var.p());
        }
        return arrayMap;
    }

    public static final i2 r(int i) {
        int i6 = i - 1;
        if (i6 == 1) {
            return i2.AD_STORAGE;
        }
        if (i6 == 2) {
            return i2.ANALYTICS_STORAGE;
        }
        if (i6 == 3) {
            return i2.AD_USER_DATA;
        }
        if (i6 != 4) {
            return null;
        }
        return i2.AD_PERSONALIZATION;
    }

    public final boolean A(String str, i2 i2Var) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.a2 B = B(str);
        if (B == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.x1 x1Var : B.o()) {
            if (i2Var == r(x1Var.o())) {
                return x1Var.p() == 2;
            }
        }
        return false;
    }

    public final com.google.android.gms.internal.measurement.a2 B(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.f2 s6 = s(str);
        if (s6 == null || !s6.A()) {
            return null;
        }
        return s6.B();
    }

    @Override // e1.f
    public final String d(String str, String str2) {
        g();
        m(str);
        Map map = (Map) this.f4105m.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final g2 k(String str, i2 i2Var) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.a2 B = B(str);
        if (B != null) {
            Iterator it = B.t().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.gms.internal.measurement.x1 x1Var = (com.google.android.gms.internal.measurement.x1) it.next();
                if (r(x1Var.o()) == i2Var) {
                    int p10 = x1Var.p() - 1;
                    if (p10 == 1) {
                        return g2.GRANTED;
                    }
                    if (p10 == 2) {
                        return g2.DENIED;
                    }
                }
            }
        }
        return g2.UNINITIALIZED;
    }

    public final boolean l(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.a2 B = B(str);
        if (B == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.x1 x1Var : B.o()) {
            if (x1Var.o() == 3 && x1Var.q() == 3) {
                return true;
            }
        }
        return false;
    }

    public final void m(String str) {
        h();
        g();
        k0.y.d(str);
        ArrayMap arrayMap = this.f4109q;
        if (arrayMap.get(str) == 0) {
            m mVar = this.f4092b.f4307l;
            u4.U(mVar);
            b5.m m02 = mVar.m0(str);
            ArrayMap arrayMap2 = this.f4114w;
            ArrayMap arrayMap3 = this.v;
            ArrayMap arrayMap4 = this.f4113u;
            ArrayMap arrayMap5 = this.f4105m;
            if (m02 != null) {
                com.google.android.gms.internal.measurement.e2 e2Var = (com.google.android.gms.internal.measurement.e2) p(str, (byte[]) m02.f1061b).h();
                n(str, e2Var);
                arrayMap5.put(str, q((com.google.android.gms.internal.measurement.f2) e2Var.d()));
                arrayMap.put(str, (com.google.android.gms.internal.measurement.f2) e2Var.d());
                o(str, (com.google.android.gms.internal.measurement.f2) e2Var.d());
                arrayMap4.put(str, ((com.google.android.gms.internal.measurement.f2) e2Var.f2687b).z());
                arrayMap3.put(str, (String) m02.f1062l);
                arrayMap2.put(str, (String) m02.f1063m);
                return;
            }
            arrayMap5.put(str, null);
            this.f4107o.put(str, null);
            this.f4106n.put(str, null);
            this.f4108p.put(str, null);
            arrayMap.put(str, null);
            arrayMap4.put(str, null);
            arrayMap3.put(str, null);
            arrayMap2.put(str, null);
            this.f4110r.put(str, null);
        }
    }

    public final void n(String str, com.google.android.gms.internal.measurement.e2 e2Var) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.f2) e2Var.f2687b).y()).iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.b2) it.next()).o());
        }
        for (int i = 0; i < ((com.google.android.gms.internal.measurement.f2) e2Var.f2687b).t(); i++) {
            com.google.android.gms.internal.measurement.c2 c2Var = (com.google.android.gms.internal.measurement.c2) ((com.google.android.gms.internal.measurement.f2) e2Var.f2687b).u(i).h();
            boolean isEmpty = c2Var.g().isEmpty();
            t1 t1Var = this.f3875a;
            if (isEmpty) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.b("EventConfig contained null event name");
            } else {
                String g = c2Var.g();
                String g3 = k2.g(c2Var.g(), k2.f4072a, k2.f4074c);
                if (!TextUtils.isEmpty(g3)) {
                    c2Var.b();
                    ((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).v(g3);
                    e2Var.b();
                    ((com.google.android.gms.internal.measurement.f2) e2Var.f2687b).G(i, (com.google.android.gms.internal.measurement.d2) c2Var.d());
                }
                if (((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).p() && ((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).q()) {
                    arrayMap.put(g, Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).r() && ((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).s()) {
                    arrayMap2.put(c2Var.g(), Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).t()) {
                    if (((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).u() < 2 || ((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).u() > 65535) {
                        w0 w0Var2 = t1Var.f4264o;
                        t1.m(w0Var2);
                        w0Var2.f4342r.d(c2Var.g(), "Invalid sampling rate. Event name, sample rate", Integer.valueOf(((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).u()));
                    } else {
                        arrayMap3.put(c2Var.g(), Integer.valueOf(((com.google.android.gms.internal.measurement.d2) c2Var.f2687b).u()));
                    }
                }
            }
        }
        this.f4106n.put(str, hashSet);
        this.f4107o.put(str, arrayMap);
        this.f4108p.put(str, arrayMap2);
        this.f4110r.put(str, arrayMap3);
    }

    public final void o(String str, com.google.android.gms.internal.measurement.f2 f2Var) {
        int x3 = f2Var.x();
        j1 j1Var = this.f4111s;
        if (x3 == 0) {
            j1Var.remove(str);
            return;
        }
        t1 t1Var = this.f3875a;
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.c(Integer.valueOf(f2Var.x()), "EES programs found");
        com.google.android.gms.internal.measurement.v3 v3Var = (com.google.android.gms.internal.measurement.v3) f2Var.w().get(0);
        try {
            com.google.android.gms.internal.measurement.e0 e0Var = new com.google.android.gms.internal.measurement.e0();
            y2.s sVar = e0Var.f2546a;
            ((HashMap) ((z5) sVar.f11758n).f2934a).put("internal.remoteConfig", new k1(this, str, 2));
            ((HashMap) ((z5) sVar.f11758n).f2934a).put("internal.appMetadata", new k1(this, str, 0));
            ((HashMap) ((z5) sVar.f11758n).f2934a).put("internal.logger", new l1(this));
            e0Var.b(v3Var);
            j1Var.put(str, e0Var);
            t1.m(w0Var);
            u0 u0Var = w0Var.f4346w;
            u0Var.d(str, "EES program loaded for appId, activities", Integer.valueOf(v3Var.p().p()));
            for (com.google.android.gms.internal.measurement.u3 u3Var : v3Var.p().o()) {
                t1.m(w0Var);
                u0Var.c(u3Var.o(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.q0 unused) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(str, "Failed to load EES program. appId");
        }
    }

    public final com.google.android.gms.internal.measurement.f2 p(String str, byte[] bArr) {
        t1 t1Var = this.f3875a;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.f2.F();
        }
        try {
            com.google.android.gms.internal.measurement.f2 f2Var = (com.google.android.gms.internal.measurement.f2) ((com.google.android.gms.internal.measurement.e2) a1.T(com.google.android.gms.internal.measurement.f2.E(), bArr)).d();
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.d(f2Var.o() ? Long.valueOf(f2Var.p()) : null, "Parsed config. version, gmp_app_id", f2Var.q() ? f2Var.r() : null);
            return f2Var;
        } catch (t5 e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4342r.d(w0.o(str), "Unable to merge remote config. appId", e10);
            return com.google.android.gms.internal.measurement.f2.F();
        } catch (RuntimeException e11) {
            w0 w0Var3 = t1Var.f4264o;
            t1.m(w0Var3);
            w0Var3.f4342r.d(w0.o(str), "Unable to merge remote config. appId", e11);
            return com.google.android.gms.internal.measurement.f2.F();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.gms.internal.measurement.f2 s(String str) {
        h();
        g();
        k0.y.d(str);
        m(str);
        return (com.google.android.gms.internal.measurement.f2) this.f4109q.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String t(String str) {
        g();
        m(str);
        return (String) this.f4113u.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0481, code lost:
    
        r1 = r24;
        r3 = r25;
        r0 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x033e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0322, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02cb, code lost:
    
        r0 = r13.f4264o;
        e1.t1.m(r0);
        r0 = r0.f4342r;
        r3 = e1.w0.o(r30);
        r4 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02e0, code lost:
    
        if (r14.o() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02e2, code lost:
    
        r5 = java.lang.Integer.valueOf(r14.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02f1, code lost:
    
        r0.e("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r3, r4, java.lang.String.valueOf(r5));
        r27 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02f0, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02eb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0382, code lost:
    
        r27 = r6;
        r5 = r5.q().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0392, code lost:
    
        if (r5.hasNext() == false) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0394, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.v1) r5.next();
        r8.h();
        r8.g();
        k0.y.d(r30);
        k0.y.g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03ae, code lost:
    
        if (r6.q().isEmpty() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03da, code lost:
    
        r14 = r6.a();
        r23 = r5;
        r5 = new android.content.ContentValues();
        r5.put(r3, r30);
        r26 = r3;
        r5.put("audience_id", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03f5, code lost:
    
        if (r6.o() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03f7, code lost:
    
        r3 = java.lang.Integer.valueOf(r6.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0401, code lost:
    
        r5.put(r0, r3);
        r28 = r0;
        r5.put("property_name", r6.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0413, code lost:
    
        if (r6.u() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0415, code lost:
    
        r3 = java.lang.Boolean.valueOf(r6.v());
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x041f, code lost:
    
        r5.put("session_scoped", r3);
        r5.put("data", r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0431, code lost:
    
        if (r8.V().insertWithOnConflict("property_filters", null, r5, 5) != (-1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0446, code lost:
    
        r5 = r23;
        r3 = r26;
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0433, code lost:
    
        r0 = r13.f4264o;
        e1.t1.m(r0);
        r0.f4339o.c(e1.w0.o(r30), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0444, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x044e, code lost:
    
        r1 = r13.f4264o;
        e1.t1.m(r1);
        r1.f4339o.d(e1.w0.o(r30), "Error storing property filter. appId", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x041e, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0400, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03b0, code lost:
    
        r0 = r13.f4264o;
        e1.t1.m(r0);
        r0 = r0.f4342r;
        r3 = e1.w0.o(r30);
        r4 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03c5, code lost:
    
        if (r6.o() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x03c7, code lost:
    
        r5 = java.lang.Integer.valueOf(r6.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x03d1, code lost:
    
        r0.e("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r3, r4, java.lang.String.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03d0, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0260, code lost:
    
        r0 = r5.q().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x026c, code lost:
    
        if (r0.hasNext() == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0278, code lost:
    
        if (((com.google.android.gms.internal.measurement.v1) r0.next()).o() != false) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x027a, code lost:
    
        r0 = r13.f4264o;
        e1.t1.m(r0);
        r0.f4342r.d(e1.w0.o(r30), "Property filter with no ID. Audience definition ignored. appId, audienceId", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x028f, code lost:
    
        r0 = r5.t().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0297, code lost:
    
        r14 = r0.hasNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x029b, code lost:
    
        r23 = r0;
        r0 = "filter_id";
        r24 = r1;
        r25 = r3;
        r3 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02ad, code lost:
    
        if (r14 == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02af, code lost:
    
        r14 = (com.google.android.gms.internal.measurement.o1) r23.next();
        r8.h();
        r8.g();
        k0.y.d(r30);
        k0.y.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02c9, code lost:
    
        if (r14.q().isEmpty() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02fc, code lost:
    
        r26 = r5;
        r5 = r14.a();
        r27 = r6;
        r6 = new android.content.ContentValues();
        r6.put("app_id", r30);
        r6.put("audience_id", java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0317, code lost:
    
        if (r14.o() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0319, code lost:
    
        r1 = java.lang.Integer.valueOf(r14.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0323, code lost:
    
        r6.put("filter_id", r1);
        r6.put("event_name", r14.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0333, code lost:
    
        if (r14.y() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0335, code lost:
    
        r0 = java.lang.Boolean.valueOf(r14.z());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x033f, code lost:
    
        r6.put("session_scoped", r0);
        r6.put("data", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0351, code lost:
    
        if (r8.V().insertWithOnConflict("event_filters", null, r6, 5) != (-1)) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0353, code lost:
    
        r0 = r13.f4264o;
        e1.t1.m(r0);
        r0.f4339o.c(e1.w0.o(r30), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0363, code lost:
    
        r0 = r23;
        r1 = r24;
        r3 = r25;
        r5 = r26;
        r6 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x036f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0370, code lost:
    
        r1 = r13.f4264o;
        e1.t1.m(r1);
        r1.f4339o.d(e1.w0.o(r30), "Error storing event filter. appId", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x045e, code lost:
    
        r8.h();
        r8.g();
        k0.y.d(r30);
        r0 = r8.V();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r7)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r7)});
     */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05ea A[Catch: SQLiteException -> 0x05fb, TRY_LEAVE, TryCatch #8 {SQLiteException -> 0x05fb, blocks: (B:180:0x05d3, B:182:0x05ea), top: B:179:0x05d3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.String r30, byte[] r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 1574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m1.u(java.lang.String, byte[], java.lang.String, java.lang.String):void");
    }

    public final boolean v(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("1".equals(d(str, "measurement.upload.blacklist_internal")) && a5.F(str2)) {
            return true;
        }
        if ("1".equals(d(str, "measurement.upload.blacklist_public")) && a5.f0(str2)) {
            return true;
        }
        Map map = (Map) this.f4107o.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean w(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f4108p.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int x(String str, String str2) {
        Integer num;
        g();
        m(str);
        Map map = (Map) this.f4110r.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean y(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.f4106n;
        if (arrayMap.get(str) != 0) {
            return ((Set) arrayMap.get(str)).contains("os_version") || ((Set) arrayMap.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean z(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.f4106n;
        return arrayMap.get(str) != 0 && ((Set) arrayMap.get(str)).contains("app_instance_id");
    }

    @Override // e1.p4
    public final void j() {
    }
}
