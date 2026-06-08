package b;

import android.content.SharedPreferences;
import android.util.Log;
import b2.t1;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.Regulations;
import j$.util.DesugarTimeZone;
import j9.x;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final l9.a f668a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.m f669b;

    /* renamed from: c, reason: collision with root package name */
    public final j9.s f670c;

    /* renamed from: d, reason: collision with root package name */
    public final j9.e f671d;

    /* renamed from: e, reason: collision with root package name */
    public final x f672e;
    public final j9.f f;
    public final j9.n g;
    public final j9.l h;
    public final j9.h i;
    public final j9.j j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f673k;

    /* renamed from: l, reason: collision with root package name */
    public u5.d f674l;

    /* renamed from: m, reason: collision with root package name */
    public n6.a f675m;

    /* renamed from: n, reason: collision with root package name */
    public int f676n;

    /* renamed from: o, reason: collision with root package name */
    public u5.f f677o;

    /* renamed from: p, reason: collision with root package name */
    public l8.n f678p;

    public h(l9.a aVar, u5.m mVar, j9.s sVar, j9.e eVar, x xVar, j9.f fVar, j9.n nVar, j9.l lVar, j9.h hVar, j9.j jVar) {
        aVar.getClass();
        sVar.getClass();
        eVar.getClass();
        xVar.getClass();
        fVar.getClass();
        nVar.getClass();
        lVar.getClass();
        hVar.getClass();
        jVar.getClass();
        this.f668a = aVar;
        this.f669b = mVar;
        this.f670c = sVar;
        this.f671d = eVar;
        this.f672e = xVar;
        this.f = fVar;
        this.g = nVar;
        this.h = lVar;
        this.i = hVar;
        this.j = jVar;
        this.f674l = new u5.d();
        this.f676n = -1;
        this.f677o = new u5.f();
        this.f678p = new l8.n(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 4194303);
        this.f676n = h();
    }

    public static Vector a(Object obj) {
        ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
        Vector vector = new Vector(null, 1, null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            int i6 = 0;
            while (i6 < size) {
                Object obj2 = arrayList.get(i6);
                i6++;
                int i10 = i + 1;
                if (i < 0) {
                    q6.m.h0();
                    throw null;
                }
                if (kotlin.jvm.internal.l.a(obj2 instanceof Boolean ? (Boolean) obj2 : null, Boolean.TRUE)) {
                    vector.set(i10);
                }
                i = i10;
            }
        }
        return vector;
    }

    public static Vector e(Object obj) {
        ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
        Vector vector = new Vector(null, 1, null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                if (num != null) {
                    vector.set(num.intValue());
                }
            }
        }
        return vector;
    }

    public final void b() {
        l9.a aVar = this.f668a;
        aVar.b(43);
        aVar.b(44);
        aVar.b(45);
        aVar.b(46);
        aVar.b(47);
        aVar.b(48);
        aVar.b(49);
        aVar.b(51);
        aVar.b(52);
        aVar.b(53);
        aVar.b(54);
        aVar.b(55);
        aVar.b(56);
        aVar.b(57);
        aVar.b(58);
        aVar.b(59);
        aVar.b(60);
    }

    public final void c(boolean z9) {
        l9.a aVar = this.f668a;
        if (z9) {
            aVar.f(76, "Reject");
        } else {
            aVar.f(76, "");
            aVar.b(75);
        }
        if (l.g.f7044a) {
            if (z9) {
                aVar.f(93, "Reject");
            } else {
                aVar.f(93, "");
                aVar.b(92);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    public final boolean d(Set set) {
        ?? r02 = this.f678p.f7239n.g;
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r02.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        l9.a aVar = this.f668a;
        aVar.b(1);
        aVar.b(2);
        aVar.b(3);
        aVar.b(4);
        aVar.b(5);
        aVar.b(6);
        aVar.b(7);
        aVar.b(8);
        aVar.b(50);
        aVar.b(9);
        aVar.b(10);
        aVar.b(11);
        aVar.b(12);
        aVar.b(13);
        aVar.b(14);
        aVar.b(15);
        aVar.b(16);
        aVar.b(17);
        aVar.b(18);
    }

    public final String g() {
        l8.i iVar = this.f678p.f7239n;
        return t1.m(iVar.f7212t.f7230c + iVar.f7202e + iVar.f7207o + iVar.f7208p + iVar.f7206n + iVar.f7204l + iVar.f7205m);
    }

    public final int h() {
        l9.a aVar = this.f668a;
        aVar.getClass();
        int i = aVar.f7262a.getInt("IABTCF_PolicyVersion", 0);
        if (i != 0) {
            return i;
        }
        aVar.getClass();
        return aVar.f7262a.getInt("IABGPP_TCFEU2_PolicyVersion", 0);
    }

    public final int i() {
        h8.c cVar = this.f669b.f10737a;
        Integer num = cVar == null ? null : cVar.f5460b;
        if (num != null) {
            return num.intValue();
        }
        l9.a aVar = this.f668a;
        aVar.getClass();
        return aVar.f7262a.getInt("gvl_version", 0);
    }

    public final boolean j() {
        n6.a aVar = this.f675m;
        return u.m0(aVar == null ? null : aVar.f8105a, "USA", true);
    }

    public final boolean k() {
        l9.a aVar = this.f668a;
        aVar.getClass();
        SharedPreferences sharedPreferences = aVar.f7262a;
        return (System.currentTimeMillis() - sharedPreferences.getLong("gvl_last_updated", 0L)) / 86400000 < ((long) this.f678p.f7239n.f) || i() <= sharedPreferences.getInt("gvl_version", 0);
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v19, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v39, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, java.util.Map] */
    public final void l() {
        List list;
        String substring;
        String[] strArr;
        int i;
        int i6;
        String str;
        int i10;
        int i11;
        int i12;
        int intValue;
        int i13;
        int intValue2;
        int i14;
        int intValue3;
        String str2;
        int intValue4;
        int i15;
        int intValue5;
        int i16;
        int intValue6;
        int i17;
        int intValue7;
        String str3;
        int intValue8;
        int i18;
        int intValue9;
        int i19;
        int intValue10;
        Integer num;
        boolean g = m9.c.c().g();
        l9.a aVar = this.f668a;
        int i20 = 1;
        u5.m mVar = this.f669b;
        boolean z9 = false;
        if (g) {
            s3.a e10 = m9.c.c().e((String) s3.b.f9158b.get(2));
            Vector vector = mVar.f10749r;
            List list2 = r3.f.f8864a;
            Object d10 = e10.d("PurposeConsents");
            d10.getClass();
            vector.set(a(d10));
            Vector vector2 = mVar.f10750s;
            vector2.unsetAllOwnedItems();
            Object d11 = e10.d("PurposeLegitimateInterests");
            d11.getClass();
            vector2.set(a(d11));
            Vector vector3 = mVar.f10748q;
            Object d12 = e10.d("SpecialFeatureOptins");
            d12.getClass();
            vector3.set(a(d12));
            Vector vector4 = mVar.f10756z;
            vector4.unsetAllOwnedItems();
            Object d13 = e10.d("VendorConsents");
            d13.getClass();
            vector4.setOwnedItems(e(d13));
            Vector vector5 = mVar.C;
            vector5.unsetAllOwnedItems();
            Object d14 = e10.d("VendorLegitimateInterests");
            d14.getClass();
            vector5.setOwnedItems(e(d14));
            Vector vector6 = mVar.v;
            vector6.unsetAllOwnedItems();
            Object d15 = e10.d("PublisherConsents");
            d15.getClass();
            vector6.setOwnedItems(a(d15));
            Vector vector7 = mVar.f10753w;
            vector7.unsetAllOwnedItems();
            Object d16 = e10.d("PublisherLegitimateInterests");
            d16.getClass();
            vector7.setOwnedItems(a(d16));
        } else {
            String j = aVar.j(8);
            if (j.length() <= 0) {
                j = null;
            }
            if (j != null) {
                List G0 = l7.m.G0(j, new String[]{"."});
                int size = G0.size();
                u5.m mVar2 = new u5.m();
                int i21 = 0;
                while (i21 < size) {
                    int i22 = i21 + 1;
                    String str4 = (String) G0.get(i21);
                    Object obj = w5.a.f10912a;
                    String d17 = i5.d(String.valueOf(str4.charAt(z9 ? 1 : 0)));
                    Object obj2 = w5.c.f10915a;
                    ?? r13 = w5.c.f10916b;
                    w5.d dVar = w5.d.f10926r;
                    Integer num2 = (Integer) r13.get(dVar);
                    String substring2 = d17.substring(z9 ? 1 : 0, num2 == null ? z9 ? 1 : 0 : num2.intValue());
                    Set set = u5.k.f10733a;
                    Integer num3 = (Integer) r13.get(dVar);
                    u5.j jVar = (u5.j) q6.l.p0(set, t1.b(num3 == null ? z9 ? 1 : 0 : num3.intValue(), substring2));
                    jVar.getClass();
                    String str5 = jVar.f10732a;
                    String d18 = i5.d(str4);
                    u5.j jVar2 = u5.j.CORE;
                    if (jVar == jVar2) {
                        ?? r15 = w5.c.f10915a;
                        u5.a aVar2 = u5.a.I;
                        Integer num4 = (Integer) r15.get(aVar2);
                        String substring3 = d18.substring(z9 ? 1 : 0, num4 == null ? z9 ? 1 : 0 : num4.intValue());
                        Integer num5 = (Integer) r15.get(aVar2);
                        mVar2.i = t1.b(num5 == null ? z9 ? 1 : 0 : num5.intValue(), substring3);
                    }
                    int intValue11 = (jVar == jVar2 || (num = (Integer) w5.c.f10917c.get("segmentType")) == null) ? z9 ? 1 : 0 : num.intValue();
                    String[] strArr2 = mVar2.i == i20 ? (String[]) a6.a.f206a.get(str5) : (String[]) a6.a.f207b.get(str5);
                    if (strArr2 != null) {
                        int length = strArr2.length;
                        int i23 = z9 ? 1 : 0;
                        ?? r62 = z9;
                        while (i23 < length) {
                            String str6 = strArr2[i23];
                            int i24 = i23 + 1;
                            Object obj3 = y5.a.f11806a;
                            str6.getClass();
                            Integer num6 = (Integer) w5.c.f10917c.get(str6);
                            if (num6 == null) {
                                list = G0;
                                if (l7.m.y0(str6, "publisherCustom", r62, r62, 6) == 0) {
                                    num6 = Integer.valueOf(mVar2.f10747p);
                                }
                            } else {
                                list = G0;
                            }
                            if ((num6 != null && num6.intValue() == 0) || num6 == null) {
                                str = d18;
                                i10 = i22;
                                i11 = length;
                                i12 = i24;
                                G0 = list;
                                strArr2 = strArr2;
                                size = size;
                                intValue11 = intValue11;
                            } else {
                                try {
                                    substring = d18.substring(intValue11, num6.intValue() + intValue11);
                                } catch (IndexOutOfBoundsException unused) {
                                    substring = l7.m.C0(num6.intValue() + intValue11, d18).substring(intValue11, num6.intValue() + intValue11);
                                }
                                if (str6.equals("version")) {
                                    mVar2.i = t1.b(num6.intValue(), substring);
                                    i = intValue11;
                                    strArr = strArr2;
                                } else {
                                    if (str6.equals("created")) {
                                        strArr = strArr2;
                                        mVar2.f10738b = t0.f.a(num6.intValue(), substring);
                                    } else {
                                        strArr = strArr2;
                                        if (str6.equals("lastUpdated")) {
                                            mVar2.f10739c = t0.f.a(num6.intValue(), substring);
                                        } else if (str6.equals("cmpId")) {
                                            int b7 = t1.b(num6.intValue(), substring);
                                            if (b7 > -1) {
                                                mVar2.f10744m = b7;
                                            } else {
                                                u5.n nVar = new u5.n("cmpId", String.valueOf(b7));
                                                ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback != null) {
                                                    callback.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message = nVar.getMessage();
                                                if (message == null) {
                                                    message = "";
                                                }
                                                Object obj4 = Boolean.TRUE;
                                                if (obj4.equals(obj4)) {
                                                    Log.e("f.u", message, nVar);
                                                }
                                            }
                                        } else if (str6.equals("cmpVersion")) {
                                            int b10 = t1.b(num6.intValue(), substring);
                                            if (b10 > -1) {
                                                mVar2.f10745n = b10;
                                            } else {
                                                u5.n nVar2 = new u5.n("cmpVersion", String.valueOf(b10));
                                                ChoiceCmpCallback callback2 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback2 != null) {
                                                    callback2.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message2 = nVar2.getMessage();
                                                if (message2 == null) {
                                                    message2 = "";
                                                }
                                                Object obj5 = Boolean.TRUE;
                                                if (obj5.equals(obj5)) {
                                                    Log.e("f.u", message2, nVar2);
                                                }
                                            }
                                        } else if (str6.equals("consentScreen")) {
                                            int b11 = t1.b(num6.intValue(), substring);
                                            if (b11 > -1) {
                                                mVar2.j = b11;
                                            } else {
                                                u5.n nVar3 = new u5.n("consentScreen", String.valueOf(b11));
                                                ChoiceCmpCallback callback3 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback3 != null) {
                                                    callback3.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message3 = nVar3.getMessage();
                                                if (message3 == null) {
                                                    message3 = "";
                                                }
                                                Object obj6 = Boolean.TRUE;
                                                if (obj6.equals(obj6)) {
                                                    Log.e("f.u", message3, nVar3);
                                                }
                                            }
                                        } else if (str6.equals("consentLanguage")) {
                                            mVar2.f10743l = z3.a(num6.intValue(), substring);
                                        } else if (str6.equals("vendorListVersion")) {
                                            int b12 = t1.b(num6.intValue(), substring);
                                            mVar2.f10746o = b12;
                                            if (b12 < 0) {
                                                u5.n nVar4 = new u5.n("vendorListVersion", String.valueOf(b12));
                                                ChoiceCmpCallback callback4 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback4 != null) {
                                                    callback4.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message4 = nVar4.getMessage();
                                                if (message4 == null) {
                                                    message4 = "";
                                                }
                                                Object obj7 = Boolean.TRUE;
                                                if (obj7.equals(obj7)) {
                                                    Log.e("f.u", message4, nVar4);
                                                }
                                            }
                                        } else if (str6.equals("policyVersion")) {
                                            int b13 = t1.b(num6.intValue(), substring);
                                            mVar2.f10742k = b13;
                                            if (b13 < 0) {
                                                u5.n nVar5 = new u5.n("policyVersion", String.valueOf(b13));
                                                ChoiceCmpCallback callback5 = ChoiceCmp.INSTANCE.getCallback();
                                                if (callback5 != null) {
                                                    callback5.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
                                                }
                                                String message5 = nVar5.getMessage();
                                                if (message5 == null) {
                                                    message5 = "";
                                                }
                                                Object obj8 = Boolean.TRUE;
                                                if (obj8.equals(obj8)) {
                                                    Log.e("f.u", message5, nVar5);
                                                }
                                            }
                                        } else {
                                            String str7 = "1";
                                            if (str6.equals("isServiceSpecific")) {
                                                mVar2.f10741e = substring.equals("1");
                                            } else if (str6.equals("useNonStandardStacks")) {
                                                mVar2.f = substring.equals("1");
                                            } else if (str6.equals("specialFeatureOptions")) {
                                                mVar2.f10748q = a.a.b(num6.intValue(), substring);
                                            } else if (str6.equals("purposeConsents")) {
                                                mVar2.f10749r = a.a.b(num6.intValue(), substring);
                                            } else if (str6.equals("purposeLegitimateInterests")) {
                                                mVar2.f10750s = a.a.b(num6.intValue(), substring);
                                            } else if (str6.equals("purposeOneTreatment")) {
                                                mVar2.g = substring.equals("1");
                                            } else if (str6.equals("publisherCountryCode")) {
                                                mVar2.a(z3.a(num6.intValue(), substring));
                                            } else if (str6.equals("vendorConsents")) {
                                                Vector c9 = i5.c(d18.substring(intValue11));
                                                mVar2.f10756z = c9;
                                                num6 = Integer.valueOf(c9.getBitLength());
                                            } else if (str6.equals("vendorLegitimateInterests")) {
                                                Vector c10 = i5.c(d18.substring(intValue11));
                                                mVar2.C = c10;
                                                num6 = Integer.valueOf(c10.getBitLength());
                                            } else {
                                                if (str6.equals("publisherRestrictions")) {
                                                    u5.h hVar = new u5.h(new h8.c());
                                                    Object obj9 = w5.c.f10915a;
                                                    ?? r42 = w5.c.f10916b;
                                                    w5.d dVar2 = w5.d.f10923o;
                                                    Integer num7 = (Integer) r42.get(dVar2);
                                                    if (num7 == null) {
                                                        i = intValue11;
                                                        intValue = 0;
                                                    } else {
                                                        i = intValue11;
                                                        intValue = num7.intValue();
                                                    }
                                                    i6 = size;
                                                    String substring4 = substring.substring(0, intValue);
                                                    Integer num8 = (Integer) r42.get(dVar2);
                                                    int b14 = t1.b(num8 == null ? 0 : num8.intValue(), substring4);
                                                    Integer num9 = (Integer) r42.get(dVar2);
                                                    int intValue12 = num9 == null ? 0 : num9.intValue();
                                                    int i25 = 0;
                                                    while (i25 < b14) {
                                                        int i26 = i25 + 1;
                                                        Object obj10 = w5.c.f10915a;
                                                        ?? r14 = w5.c.f10916b;
                                                        int i27 = b14;
                                                        w5.d dVar3 = w5.d.f10924p;
                                                        Integer num10 = (Integer) r14.get(dVar3);
                                                        if (num10 == null) {
                                                            i13 = i26;
                                                            intValue2 = 0;
                                                        } else {
                                                            i13 = i26;
                                                            intValue2 = num10.intValue();
                                                        }
                                                        String substring5 = substring.substring(intValue12, intValue2);
                                                        Integer num11 = (Integer) r14.get(dVar3);
                                                        if (num11 == null) {
                                                            i14 = intValue12;
                                                            intValue3 = 0;
                                                        } else {
                                                            i14 = intValue12;
                                                            intValue3 = num11.intValue();
                                                        }
                                                        int b15 = t1.b(intValue3, substring5);
                                                        Integer num12 = (Integer) r14.get(dVar3);
                                                        int intValue13 = i14 + (num12 == null ? 0 : num12.intValue());
                                                        w5.d dVar4 = w5.d.f10925q;
                                                        Integer num13 = (Integer) r14.get(dVar4);
                                                        if (num13 == null) {
                                                            str2 = d18;
                                                            intValue4 = 0;
                                                        } else {
                                                            str2 = d18;
                                                            intValue4 = num13.intValue();
                                                        }
                                                        String substring6 = substring.substring(intValue13, intValue4);
                                                        Integer num14 = (Integer) r14.get(dVar4);
                                                        if (num14 == null) {
                                                            i15 = intValue13;
                                                            intValue5 = 0;
                                                        } else {
                                                            i15 = intValue13;
                                                            intValue5 = num14.intValue();
                                                        }
                                                        int b16 = t1.b(intValue5, substring6);
                                                        Integer num15 = (Integer) r14.get(dVar4);
                                                        int intValue14 = i15 + (num15 == null ? 0 : num15.intValue());
                                                        u5.g gVar = new u5.g(b15, u5.i.valueOf(String.valueOf(b16)));
                                                        w5.d dVar5 = w5.d.f10922n;
                                                        Integer num16 = (Integer) r14.get(dVar5);
                                                        String substring7 = substring.substring(intValue14, num16 == null ? 0 : num16.intValue());
                                                        Integer num17 = (Integer) r14.get(dVar5);
                                                        if (num17 == null) {
                                                            i16 = intValue14;
                                                            intValue6 = 0;
                                                        } else {
                                                            i16 = intValue14;
                                                            intValue6 = num17.intValue();
                                                        }
                                                        int b17 = t1.b(intValue6, substring7);
                                                        Integer num18 = (Integer) r14.get(dVar5);
                                                        int intValue15 = i16 + (num18 == null ? 0 : num18.intValue());
                                                        if (b17 >= 0) {
                                                            int i28 = 0;
                                                            while (true) {
                                                                int i29 = i28 + 1;
                                                                Object obj11 = w5.c.f10915a;
                                                                int i30 = i22;
                                                                ?? r11 = w5.c.f10916b;
                                                                int i31 = length;
                                                                w5.d dVar6 = w5.d.f10918a;
                                                                Integer num19 = (Integer) r11.get(dVar6);
                                                                if (num19 == null) {
                                                                    i17 = i24;
                                                                    intValue7 = 0;
                                                                } else {
                                                                    i17 = i24;
                                                                    intValue7 = num19.intValue();
                                                                }
                                                                boolean equals = substring.substring(intValue15, intValue7).equals(str7);
                                                                Integer num20 = (Integer) r11.get(dVar6);
                                                                int intValue16 = intValue15 + (num20 == null ? 0 : num20.intValue());
                                                                w5.d dVar7 = w5.d.f10928t;
                                                                Integer num21 = (Integer) r11.get(dVar7);
                                                                if (num21 == null) {
                                                                    str3 = str7;
                                                                    intValue8 = 0;
                                                                } else {
                                                                    str3 = str7;
                                                                    intValue8 = num21.intValue();
                                                                }
                                                                String substring8 = substring.substring(intValue16, intValue8);
                                                                Integer num22 = (Integer) r11.get(dVar7);
                                                                if (num22 == null) {
                                                                    i18 = intValue16;
                                                                    intValue9 = 0;
                                                                } else {
                                                                    i18 = intValue16;
                                                                    intValue9 = num22.intValue();
                                                                }
                                                                int b18 = t1.b(intValue9, substring8);
                                                                Integer num23 = (Integer) r11.get(dVar7);
                                                                int intValue17 = i18 + (num23 == null ? 0 : num23.intValue());
                                                                if (equals) {
                                                                    Integer num24 = (Integer) r11.get(dVar7);
                                                                    String substring9 = substring.substring(intValue17, num24 == null ? 0 : num24.intValue());
                                                                    Integer num25 = (Integer) r11.get(dVar7);
                                                                    if (num25 == null) {
                                                                        i19 = intValue17;
                                                                        intValue10 = 0;
                                                                    } else {
                                                                        i19 = intValue17;
                                                                        intValue10 = num25.intValue();
                                                                    }
                                                                    int b19 = t1.b(intValue10, substring9);
                                                                    Integer num26 = (Integer) r11.get(dVar7);
                                                                    int intValue18 = i19 + (num26 == null ? 0 : num26.intValue());
                                                                    if (b19 < b18) {
                                                                        throw new w5.e("h.k: Invalid RangeEntry: endVendorId " + b19 + " is less than " + b18);
                                                                    }
                                                                    if (b18 <= b19) {
                                                                        while (true) {
                                                                            int i32 = b18 + 1;
                                                                            hVar.a(b18, gVar);
                                                                            if (b18 == b19) {
                                                                                break;
                                                                            } else {
                                                                                b18 = i32;
                                                                            }
                                                                        }
                                                                    }
                                                                    intValue15 = intValue18;
                                                                } else {
                                                                    hVar.a(b18, gVar);
                                                                    intValue15 = intValue17;
                                                                }
                                                                if (i28 == b17) {
                                                                    intValue12 = intValue15;
                                                                    b14 = i27;
                                                                    i22 = i30;
                                                                    i25 = i13;
                                                                    d18 = str2;
                                                                    length = i31;
                                                                    i24 = i17;
                                                                    str7 = str3;
                                                                    break;
                                                                }
                                                                i28 = i29;
                                                                i22 = i30;
                                                                length = i31;
                                                                i24 = i17;
                                                                str7 = str3;
                                                            }
                                                        } else {
                                                            intValue12 = intValue15;
                                                            b14 = i27;
                                                            i25 = i13;
                                                            d18 = str2;
                                                        }
                                                    }
                                                    str = d18;
                                                    i10 = i22;
                                                    i11 = length;
                                                    i12 = i24;
                                                    mVar2.G = hVar;
                                                } else {
                                                    i = intValue11;
                                                    i6 = size;
                                                    str = d18;
                                                    i10 = i22;
                                                    i11 = length;
                                                    i12 = i24;
                                                    if (str6.equals("publisherConsents")) {
                                                        mVar2.v = a.a.b(num6.intValue(), substring);
                                                    } else if (str6.equals("publisherLegitimateInterests")) {
                                                        mVar2.f10753w = a.a.b(num6.intValue(), substring);
                                                    } else if (str6.equals("numCustomPurposes")) {
                                                        mVar2.f10747p = t1.b(num6.intValue(), substring);
                                                    } else if (str6.equals("publisherCustomConsents")) {
                                                        mVar2.f10754x = a.a.b(num6.intValue(), substring);
                                                    } else if (str6.equals("publisherCustomLegitimateInterests")) {
                                                        mVar2.f10755y = a.a.b(num6.intValue(), substring);
                                                    } else if (str6.equals("vendorsAllowed")) {
                                                        mVar2.F = i5.c(substring);
                                                    } else {
                                                        if (!str6.equals("vendorsDisclosed")) {
                                                            throw new w5.e(androidx.lifecycle.l.w("g.i: Unable to find: ", str6, " field on TCModel, segment"));
                                                        }
                                                        mVar2.E = i5.c(substring);
                                                    }
                                                }
                                                intValue11 = num6.intValue() + i;
                                                G0 = list;
                                                strArr2 = strArr;
                                                size = i6;
                                            }
                                        }
                                    }
                                    i = intValue11;
                                }
                                i6 = size;
                                str = d18;
                                i10 = i22;
                                i11 = length;
                                i12 = i24;
                                intValue11 = num6.intValue() + i;
                                G0 = list;
                                strArr2 = strArr;
                                size = i6;
                            }
                            i22 = i10;
                            d18 = str;
                            length = i11;
                            i23 = i12;
                            r62 = 0;
                        }
                    }
                    G0 = G0;
                    size = size;
                    i21 = i22;
                    i20 = 1;
                    z9 = false;
                }
                mVar.f10749r.set(mVar2.f10749r);
                Vector vector8 = mVar.f10750s;
                vector8.unsetAllOwnedItems();
                vector8.set(mVar2.f10750s);
                mVar.f10748q.set(mVar2.f10748q);
                Vector vector9 = mVar.f10756z;
                vector9.unsetAllOwnedItems();
                vector9.setOwnedItems(mVar2.f10756z);
                Vector vector10 = mVar.C;
                vector10.unsetAllOwnedItems();
                vector10.setOwnedItems(mVar2.C);
                Vector vector11 = mVar.v;
                vector11.unsetAllOwnedItems();
                vector11.set(mVar2.v);
                Vector vector12 = mVar.f10753w;
                vector12.unsetAllOwnedItems();
                vector12.set(mVar2.f10753w);
            }
        }
        if (m9.c.c().g() || aVar.j(8).length() > 0) {
            String str8 = this.f678p.f7239n.f7198a;
            j9.h hVar2 = this.i;
            if (str8 != null) {
                PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
                if (str8.equals(privacyEncodingMode.getValue())) {
                    if (!m9.c.c().g()) {
                        hVar2.b(privacyEncodingMode, false, false);
                    }
                    f();
                    return;
                }
            }
            String str9 = this.f678p.f7239n.f7198a;
            if (str9 != null) {
                PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
                if (str9.equals(privacyEncodingMode2.getValue())) {
                    m9.c.c().b(2);
                    b();
                    String c11 = m9.c.c().c();
                    c11.getClass();
                    aVar.f(63, c11);
                    if (aVar.j(8).length() == 0) {
                        hVar2.b(privacyEncodingMode2, false, false);
                        return;
                    }
                    return;
                }
            }
            if (!m9.c.c().g()) {
                hVar2.b(PrivacyEncodingMode.GPP, false, false);
            }
            if (aVar.j(8).length() == 0) {
                hVar2.b(PrivacyEncodingMode.TCF, false, false);
            }
        }
    }

    public final void m() {
        u5.m mVar = this.f669b;
        int i = mVar.f10744m;
        l9.a aVar = this.f668a;
        aVar.c(43, i);
        aVar.c(44, mVar.f10745n);
        aVar.c(45, mVar.d());
        aVar.c(46, this.f678p.f7231a.contains(Regulations.GDPR) ? 1 : 0);
        aVar.f(47, this.f678p.f7234d);
        aVar.c(48, mVar.g ? 1 : 0);
        aVar.c(49, mVar.f ? 1 : 0);
    }

    public final void n() {
        u5.m mVar = this.f669b;
        int i = mVar.f10744m;
        l9.a aVar = this.f668a;
        aVar.c(1, i);
        aVar.c(2, mVar.f10745n);
        aVar.c(3, mVar.d());
        if (this.f676n <= 0) {
            this.f676n = mVar.d();
        }
        aVar.c(4, this.f678p.f7231a.contains(Regulations.GDPR) ? 1 : 0);
        aVar.f(5, this.f678p.f7234d);
        aVar.c(6, mVar.g ? 1 : 0);
        aVar.c(7, mVar.f ? 1 : 0);
    }

    public final boolean o() {
        long j = this.f678p.f7238m;
        l9.a aVar = this.f668a;
        aVar.getClass();
        long j6 = aVar.f7262a.getLong("LastVisitTime", 0L);
        boolean z9 = ((double) (j - j6)) / ((double) 60000) >= 30.0d;
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j6);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTimeInMillis(j);
        boolean z10 = calendar.get(6) != calendar2.get(6);
        aVar.d(79, this.f678p.f7238m);
        return z9 || z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
    
        if (r0.f7091a.containsKey("tcfeuv2") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00be, code lost:
    
        if (r0.equals(b2.t1.m(r4.toString())) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() {
        /*
            r7 = this;
            r0 = 28
            l9.a r1 = r7.f668a
            java.lang.String r0 = r1.j(r0)
            int r0 = r0.length()
            r2 = 0
            r3 = 39
            if (r0 <= 0) goto Lc1
            r0 = 21
            java.lang.String r0 = r1.j(r0)
            int r0 = r0.length()
            if (r0 <= 0) goto Lc1
            u5.f r0 = r7.f677o
            java.util.LinkedHashMap r0 = r0.f10715b
            u5.m r4 = r7.f669b
            int r5 = r4.f10744m
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r0 = r0.containsKey(r5)
            r5 = 1
            if (r0 == 0) goto Lc0
            boolean r0 = r7.k()
            if (r0 == 0) goto Lc0
            r0 = 23
            java.lang.String r0 = r1.j(r0)
            java.lang.String r6 = r7.g()
            java.lang.String r0 = kotlin.jvm.internal.l.g(r6, r0)
            r6 = 22
            java.lang.String r6 = r1.j(r6)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto Lc0
            int r0 = r7.f676n
            h8.c r4 = r4.f10737a
            if (r4 != 0) goto L58
            r4 = 0
            goto L5a
        L58:
            java.lang.Integer r4 = r4.f5461c
        L5a:
            if (r4 != 0) goto L61
            int r4 = r7.h()
            goto L65
        L61:
            int r4 = r4.intValue()
        L65:
            if (r0 == r4) goto L68
            goto Lc0
        L68:
            r0 = 8
            java.lang.String r0 = r1.j(r0)
            int r0 = r0.length()
            if (r0 != 0) goto L93
            l3.a r0 = m9.c.c()
            boolean r4 = r0.f7094d
            if (r4 != 0) goto L88
            java.lang.String r4 = r0.f7092b
            java.util.HashMap r4 = l3.a.a(r4)
            r0.f7091a = r4
            r0.f7093c = r2
            r0.f7094d = r5
        L88:
            java.util.HashMap r0 = r0.f7091a
            java.lang.String r4 = "tcfeuv2"
            boolean r0 = r0.containsKey(r4)
            if (r0 != 0) goto L93
            goto Lc0
        L93:
            boolean r0 = l.g.f7044a
            if (r0 == 0) goto Lc1
            java.lang.String r0 = r1.j(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            l8.n r6 = r7.f678p
            l8.h r6 = r6.f7242q
            java.lang.Object r6 = r6.f7197b
            r4.append(r6)
            l8.n r6 = r7.f678p
            l8.h r6 = r6.f7242q
            boolean r6 = r6.f7196a
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = b2.t1.m(r4)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto Lc1
        Lc0:
            r2 = r5
        Lc1:
            boolean r0 = l.g.f7044a
            if (r0 == 0) goto Le7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            l8.n r4 = r7.f678p
            l8.h r4 = r4.f7242q
            java.lang.Object r4 = r4.f7197b
            r0.append(r4)
            l8.n r4 = r7.f678p
            l8.h r4 = r4.f7242q
            boolean r4 = r4.f7196a
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = b2.t1.m(r0)
            r1.f(r3, r0)
        Le7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.p():boolean");
    }
}
