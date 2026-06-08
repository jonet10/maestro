package j9;

import android.content.SharedPreferences;
import android.os.Build;
import b2.t1;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final l9.a f6761a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.m f6762b;

    /* renamed from: c, reason: collision with root package name */
    public final ChoiceCmpCallback f6763c;

    /* renamed from: d, reason: collision with root package name */
    public final w5.f f6764d;

    public h(l9.a aVar, u5.m mVar, ChoiceCmpCallback choiceCmpCallback) {
        aVar.getClass();
        this.f6761a = aVar;
        this.f6762b = mVar;
        this.f6763c = choiceCmpCallback;
        this.f6764d = new w5.f(q6.m.e0(u5.j.CORE, u5.j.VENDORS_DISCLOSED, u5.j.PUBLISHER_TC));
    }

    public final void a() {
        u5.c cVar;
        u5.m mVar = this.f6762b;
        Vector vector = mVar.A;
        int i = 0;
        try {
            l3.a c9 = m9.c.c();
            l9.a aVar = (l9.a) m9.c.v.getValue();
            List list = r3.f.f8864a;
            c9.h("tcfeuv2", "Version", Integer.valueOf(mVar.i));
            c9.h("tcfeuv2", "CmpId", Integer.valueOf(mVar.f10744m));
            c9.h("tcfeuv2", "CmpVersion", Integer.valueOf(mVar.f10745n));
            c9.h("tcfeuv2", "ConsentScreen", Integer.valueOf(mVar.j));
            c9.h("tcfeuv2", "ConsentLanguage", mVar.f10743l);
            h8.c cVar2 = mVar.f10737a;
            Integer num = cVar2 == null ? null : cVar2.f5460b;
            c9.h("tcfeuv2", "VendorListVersion", Integer.valueOf(num == null ? mVar.f10746o : num.intValue()));
            c9.h("tcfeuv2", "PolicyVersion", Integer.valueOf(mVar.d()));
            c9.h("tcfeuv2", "IsServiceSpecific", Boolean.valueOf(mVar.f10741e));
            c9.h("tcfeuv2", "UseNonStandardStacks", Boolean.valueOf(mVar.f));
            c9.h("tcfeuv2", "SpecialFeatureOptins", t1.e(12, mVar.f10748q));
            c9.h("tcfeuv2", "PurposeConsents", t1.e(24, mVar.f10749r));
            c9.h("tcfeuv2", "PurposeLegitimateInterests", t1.e(24, mVar.f10750s));
            c9.h("tcfeuv2", "PurposeOneTreatment", Boolean.valueOf(mVar.g));
            c9.h("tcfeuv2", "PublisherCountryCode", mVar.h);
            c9.h("tcfeuv2", "VendorConsents", q6.l.G0(mVar.f10756z.getAcceptedItems()));
            c9.h("tcfeuv2", "VendorLegitimateInterests", q6.l.G0(mVar.C.getAcceptedItems()));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : mVar.G.f10720c.entrySet()) {
                String str = (String) entry.getKey();
                Set set = (Set) entry.getValue();
                u5.g b7 = z3.b(str);
                arrayList.add(new o3.f(q6.l.G0(set), b7.f10716a, b7.f10717b.f10726a));
            }
            List list2 = r3.f.f8864a;
            c9.h("tcfeuv2", "PublisherRestrictions", arrayList);
            c9.h("tcfeuv2", "PublisherConsents", t1.e(24, mVar.v));
            c9.h("tcfeuv2", "PublisherLegitimateInterests", t1.e(24, mVar.f10753w));
            int i6 = mVar.f10747p;
            c9.h("tcfeuv2", "NumCustomPurposes", Integer.valueOf(i6));
            c9.h("tcfeuv2", "PublisherCustomConsents", t1.e(i6, mVar.f10754x));
            c9.h("tcfeuv2", "PublisherCustomLegitimateInterests", t1.e(i6, mVar.f10755y));
            c9.h("tcfeuv2", "VendorsAllowed", q6.l.G0(mVar.F.getAcceptedItems()));
            c9.h("tcfeuv2", "VendorsDisclosed", q6.l.G0(mVar.E.getAcceptedItems()));
            c9.d();
            aVar.f(61, String.valueOf(1));
            aVar.f(62, c9.f().toString());
            aVar.f(64, q6.l.x0(c9.f(), "_", null, null, null, 62));
            String o02 = l7.u.o0("IABGPP_[SectionID]_String", "[SectionID]", String.valueOf(2), false);
            String c10 = c9.e("tcfeuv2").c();
            c10.getClass();
            aVar.h(o02, c10);
            ZonedDateTime zonedDateTime = mVar.f10740d;
            if (zonedDateTime != null) {
                c9.h("tcfeuv2", "Created", zonedDateTime);
                c9.h("tcfeuv2", "LastUpdated", mVar.f10740d);
            }
            m9.c.i = c9;
            cVar = new u5.c(c9.c(), c10);
        } catch (Exception e10) {
            a.a.h("GPPString", kotlin.jvm.internal.l.g(e10.getMessage(), "Error while encoding GPP String: "), e10, 8);
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
            }
            cVar = new u5.c("", "");
        }
        String str2 = cVar.f10708a;
        String str3 = str2 != null ? str2 : "";
        String c11 = d0.b.c(vector);
        String m10 = t1.m(vector.toString());
        String c12 = d0.b.c(mVar.D);
        Set<Integer> acceptedItems = mVar.B.getAcceptedItems();
        acceptedItems.getClass();
        String str4 = "1~";
        for (Object obj : acceptedItems) {
            int i10 = i + 1;
            if (i < 0) {
                q6.m.h0();
                throw null;
            }
            int intValue = ((Number) obj).intValue();
            str4 = kotlin.jvm.internal.l.g(i != 0 ? kotlin.jvm.internal.l.g(Integer.valueOf(intValue), ".") : Integer.valueOf(intValue), str4);
            i = i10;
        }
        String c13 = d0.b.c(mVar.f10756z);
        String c14 = d0.b.c(mVar.C);
        String c15 = d0.b.c(mVar.f10749r);
        String c16 = d0.b.c(mVar.f10750s);
        String c17 = d0.b.c(mVar.f10748q);
        String obj2 = mVar.G.f10720c.toString();
        String c18 = d0.b.c(mVar.v);
        String c19 = d0.b.c(mVar.f10753w);
        String c20 = d0.b.c(mVar.f10754x);
        String c21 = d0.b.c(mVar.f10755y);
        l9.a aVar2 = this.f6761a;
        aVar2.getClass();
        c11.getClass();
        c12.getClass();
        c13.getClass();
        c14.getClass();
        c15.getClass();
        c16.getClass();
        c17.getClass();
        obj2.getClass();
        c18.getClass();
        c19.getClass();
        c20.getClass();
        c21.getClass();
        aVar2.f(63, str3);
        aVar2.f(50, cVar.f10709b);
        aVar2.f(35, c11);
        aVar2.f(23, t1.m(m10));
        aVar2.f(36, c12);
        aVar2.f(22, kotlin.jvm.internal.l.g(aVar2.j(24), aVar2.j(23)));
        aVar2.f(31, str4);
        aVar2.f(51, c13);
        aVar2.f(52, c14);
        aVar2.f(53, c15);
        aVar2.f(54, c16);
        aVar2.f(55, c17);
        aVar2.f(56, obj2);
        aVar2.f(57, c18);
        aVar2.f(58, c19);
        aVar2.f(59, c20);
        aVar2.f(60, c21);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(PrivacyEncodingMode privacyEncodingMode, boolean z9, boolean z10) {
        boolean z11;
        privacyEncodingMode.getClass();
        u5.m mVar = this.f6762b;
        Vector vector = mVar.A;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            ZonedDateTime of = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 0, 0, 0, 0, ZoneOffset.UTC);
            mVar.f10740d = of;
            long epochMilli = of.toInstant().toEpochMilli();
            mVar.f10738b = epochMilli;
            mVar.f10739c = epochMilli;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            mVar.f10738b = timeInMillis;
            mVar.f10739c = timeInMillis;
        }
        int i6 = g.f6760a[privacyEncodingMode.ordinal()];
        int i10 = 1;
        if (i6 == 1) {
            a();
        } else if (i6 != 2) {
            a();
            c();
        } else {
            c();
        }
        long j = mVar.f10738b;
        long j6 = mVar.f10739c;
        int i11 = mVar.f10744m;
        int i12 = mVar.f10745n;
        int maxId = vector.getMaxId();
        Set<Integer> acceptedItems = vector.getAcceptedItems();
        acceptedItems.getClass();
        StringBuilder sb = new StringBuilder();
        d0.b.v(2);
        String l10 = Long.toString(j, 2);
        l10.getClass();
        sb.append(l10);
        d0.b.v(2);
        String l11 = Long.toString(j6, 2);
        l11.getClass();
        sb.append(l11);
        d0.b.v(2);
        String num = Integer.toString(i11, 2);
        num.getClass();
        sb.append(num);
        d0.b.v(2);
        String num2 = Integer.toString(i12, 2);
        num2.getClass();
        sb.append(num2);
        d0.b.v(2);
        String num3 = Integer.toString(maxId, 2);
        num3.getClass();
        sb.append(num3);
        String str = "";
        if (!acceptedItems.isEmpty()) {
            Iterator<T> it = acceptedItems.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                d0.b.v(2);
                String num4 = Integer.toString(intValue, 2);
                num4.getClass();
                while (true) {
                    int length = num4.length();
                    d0.b.v(2);
                    String num5 = Integer.toString(maxId, 2);
                    num5.getClass();
                    if (length < num5.length()) {
                        num4 = kotlin.jvm.internal.l.g(num4, "0");
                    }
                }
                str = kotlin.jvm.internal.l.g(num4, str);
            }
        }
        sb.append(str);
        String sb2 = sb.toString();
        Object obj = w5.a.f10912a;
        String h = i5.h(sb2);
        l9.a aVar = this.f6761a;
        aVar.f(34, h);
        SharedPreferences sharedPreferences = aVar.f7262a;
        if (z10) {
            String str2 = m9.c.e().h;
            if (str2 != null) {
                aVar.f(81, str2);
            }
            aVar.f(82, aVar.j(33));
            Boolean bool = m9.c.e().f7236k.f7185c;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(bool2)) {
                ArrayList arrayList = m9.c.e().f7239n.v.f7181a;
                String upperCase = t1.f947c.toUpperCase(Locale.ROOT);
                upperCase.getClass();
                if (arrayList.contains(upperCase)) {
                    z11 = true;
                    aVar.g(83, z11);
                    aVar.g(84, m9.c.e().f7236k.f7184b.equals(bool2));
                    aVar.g(85, l.g.f7044a);
                }
            }
            z11 = false;
            aVar.g(83, z11);
            aVar.g(84, m9.c.e().f7236k.f7184b.equals(bool2));
            aVar.g(85, l.g.f7044a);
        }
        long j10 = m9.c.e().f7238m;
        if (z9) {
            aVar.d(80, j10);
            Set set = null;
            Object[] objArr = 0;
            ChoiceCmpCallback choiceCmpCallback = this.f6763c;
            if (choiceCmpCallback != null) {
                GDPRData gDPRData = new GDPRData(set, i10, objArr == true ? 1 : 0);
                gDPRData.setCmpStatus(CmpStatus.LOADED);
                choiceCmpCallback.onIABVendorConsentGiven(gDPRData);
            }
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onNonIABVendorConsentGiven(new NonIABData(sharedPreferences.getInt("IABTCF_gdprApplies", 0) == 1, false, false, aVar.j(34), vector.getMap()));
            }
            if (!sharedPreferences.getBoolean("google_enabled", false) || choiceCmpCallback == null) {
                return;
            }
            Set<Integer> acceptedItems2 = mVar.B.getAcceptedItems();
            acceptedItems2.getClass();
            String str3 = "1~";
            for (Object obj2 : acceptedItems2) {
                int i13 = i + 1;
                if (i < 0) {
                    q6.m.h0();
                    throw null;
                }
                int intValue2 = ((Number) obj2).intValue();
                str3 = kotlin.jvm.internal.l.g(i != 0 ? kotlin.jvm.internal.l.g(Integer.valueOf(intValue2), ".") : Integer.valueOf(intValue2), str3);
                i = i13;
            }
            choiceCmpCallback.onGoogleVendorConsentGiven(new ACData(str3));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0390, code lost:
    
        throw new w5.e("h.i: invalid language code: ".concat(r3));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04ea A[LOOP:4: B:154:0x04c1->B:161:0x04ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0500 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02d1  */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v105, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 1708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.h.c():void");
    }
}
