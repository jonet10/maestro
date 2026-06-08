package k8;

import c.j;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import java.util.List;
import q6.m;
import r3.g;
import r3.h;
import r3.i;
import r3.k;
import r3.l;
import r3.n;
import r3.p;
import r3.q;
import r3.r;
import r3.t;
import r3.u;
import r3.v;
import r3.w;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends s {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7005p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i) {
        super(8);
        this.f7005p = i;
    }

    @Override // y2.s
    public final String c(int i) {
        switch (this.f7005p) {
            case 0:
                if (i == 0) {
                    throw null;
                }
                int c9 = j.c(i);
                if (c9 == 1) {
                    List list = g.f8868a;
                    return "SaleOptOutNotice";
                }
                if (c9 == 2) {
                    List list2 = g.f8868a;
                    return "SharingOptOutNotice";
                }
                if (c9 == 5) {
                    List list3 = g.f8868a;
                    return "SensitiveDataLimitUseNotice";
                }
                if (c9 == 7) {
                    List list4 = g.f8868a;
                    return "SaleOptOut";
                }
                if (c9 == 8) {
                    List list5 = g.f8868a;
                    return "SharingOptOut";
                }
                switch (c9) {
                    case 10:
                        List list6 = g.f8868a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list7 = g.f8868a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list8 = g.f8868a;
                        return "PersonalDataConsents";
                    case 13:
                        List list9 = g.f8868a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list10 = g.f8868a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list11 = g.f8868a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 1:
                if (i == 0) {
                    throw null;
                }
                int c10 = j.c(i);
                if (c10 == 0) {
                    List list12 = h.f8870a;
                    return "SharingNotice";
                }
                if (c10 == 1) {
                    List list13 = h.f8870a;
                    return "SaleOptOutNotice";
                }
                if (c10 == 3) {
                    List list14 = h.f8870a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c10 == 7) {
                    List list15 = h.f8870a;
                    return "SaleOptOut";
                }
                switch (c10) {
                    case 9:
                        List list16 = h.f8870a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list17 = h.f8870a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list18 = h.f8870a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (c10) {
                            case 13:
                                List list19 = h.f8870a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list20 = h.f8870a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list21 = h.f8870a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
            case 2:
                if (i == 0) {
                    throw null;
                }
                int c11 = j.c(i);
                if (c11 == 0) {
                    List list22 = i.f8872a;
                    return "SharingNotice";
                }
                if (c11 == 1) {
                    List list23 = i.f8872a;
                    return "SaleOptOutNotice";
                }
                if (c11 == 3) {
                    List list24 = i.f8872a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c11 == 7) {
                    List list25 = i.f8872a;
                    return "SaleOptOut";
                }
                switch (c11) {
                    case 9:
                        List list26 = i.f8872a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list27 = i.f8872a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list28 = i.f8872a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (c11) {
                            case 13:
                                List list29 = i.f8872a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list30 = i.f8872a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list31 = i.f8872a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
            case 3:
                if (i == 0) {
                    throw null;
                }
                int c12 = j.c(i);
                if (c12 == 1) {
                    List list32 = r3.j.f8874a;
                    return "SaleOptOutNotice";
                }
                if (c12 == 3) {
                    List list33 = r3.j.f8874a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c12 == 6) {
                    List list34 = r3.j.f8874a;
                    return "ProcessingNotice";
                }
                if (c12 == 7) {
                    List list35 = r3.j.f8874a;
                    return "SaleOptOut";
                }
                switch (c12) {
                    case 9:
                        List list36 = r3.j.f8874a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list37 = r3.j.f8874a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list38 = r3.j.f8874a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list39 = r3.j.f8874a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list40 = r3.j.f8874a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list41 = r3.j.f8874a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list42 = r3.j.f8874a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 4:
                if (i == 0) {
                    throw null;
                }
                int c13 = j.c(i);
                if (c13 == 1) {
                    List list43 = k.f8876a;
                    return "SaleOptOutNotice";
                }
                if (c13 == 3) {
                    List list44 = k.f8876a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c13 == 6) {
                    List list45 = k.f8876a;
                    return "ProcessingNotice";
                }
                if (c13 == 7) {
                    List list46 = k.f8876a;
                    return "SaleOptOut";
                }
                switch (c13) {
                    case 9:
                        List list47 = k.f8876a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list48 = k.f8876a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list49 = k.f8876a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list50 = k.f8876a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list51 = k.f8876a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list52 = k.f8876a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list53 = k.f8876a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 5:
                if (i == 0) {
                    throw null;
                }
                switch (j.c(i)) {
                    case 1:
                        List list54 = l.f8877a;
                        return "SaleOptOutNotice";
                    case 2:
                    case 5:
                    case 8:
                    case 12:
                    default:
                        return "";
                    case 3:
                        List list55 = l.f8877a;
                        return "TargetedAdvertisingOptOutNotice";
                    case 4:
                        List list56 = l.f8877a;
                        return "SensitiveDataOptOutNotice";
                    case 6:
                        List list57 = l.f8877a;
                        return "ProcessingNotice";
                    case 7:
                        List list58 = l.f8877a;
                        return "SaleOptOut";
                    case 9:
                        List list59 = l.f8877a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list60 = l.f8877a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list61 = l.f8877a;
                        return "KnownChildSensitiveDataConsents";
                    case 13:
                        List list62 = l.f8877a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list63 = l.f8877a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list64 = l.f8877a;
                        return "MspaServiceProviderMode";
                }
            case 6:
                if (i == 0) {
                    throw null;
                }
                int c14 = j.c(i);
                if (c14 == 0) {
                    List list65 = n.f8881a;
                    return "SharingNotice";
                }
                if (c14 == 1) {
                    List list66 = n.f8881a;
                    return "SaleOptOutNotice";
                }
                if (c14 == 3) {
                    List list67 = n.f8881a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c14 == 7) {
                    List list68 = n.f8881a;
                    return "SaleOptOut";
                }
                switch (c14) {
                    case 9:
                        List list69 = n.f8881a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list70 = n.f8881a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list71 = n.f8881a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list72 = n.f8881a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list73 = n.f8881a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list74 = n.f8881a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list75 = n.f8881a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 7:
                if (i == 0) {
                    throw null;
                }
                int c15 = j.c(i);
                if (c15 == 1) {
                    List list76 = p.f8885a;
                    return "SaleOptOutNotice";
                }
                if (c15 == 3) {
                    List list77 = p.f8885a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c15 == 6) {
                    List list78 = p.f8885a;
                    return "ProcessingNotice";
                }
                if (c15 == 7) {
                    List list79 = p.f8885a;
                    return "SaleOptOut";
                }
                switch (c15) {
                    case 9:
                        List list80 = p.f8885a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list81 = p.f8885a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list82 = p.f8885a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list83 = p.f8885a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list84 = p.f8885a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list85 = p.f8885a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list86 = p.f8885a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 8:
                if (i == 0) {
                    throw null;
                }
                int c16 = j.c(i);
                if (c16 == 1) {
                    List list87 = q.f8887a;
                    return "SaleOptOutNotice";
                }
                if (c16 == 3) {
                    List list88 = q.f8887a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c16 == 6) {
                    List list89 = q.f8887a;
                    return "ProcessingNotice";
                }
                if (c16 == 7) {
                    List list90 = q.f8887a;
                    return "SaleOptOut";
                }
                switch (c16) {
                    case 9:
                        List list91 = q.f8887a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list92 = q.f8887a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list93 = q.f8887a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list94 = q.f8887a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list95 = q.f8887a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list96 = q.f8887a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list97 = q.f8887a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 9:
                if (i == 0) {
                    throw null;
                }
                int c17 = j.c(i);
                if (c17 == 1) {
                    List list98 = r.f8889a;
                    return "SaleOptOutNotice";
                }
                if (c17 == 3) {
                    List list99 = r.f8889a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c17 == 6) {
                    List list100 = r.f8889a;
                    return "ProcessingNotice";
                }
                if (c17 == 7) {
                    List list101 = r.f8889a;
                    return "SaleOptOut";
                }
                switch (c17) {
                    case 9:
                        List list102 = r.f8889a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list103 = r.f8889a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list104 = r.f8889a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list105 = r.f8889a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list106 = r.f8889a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list107 = r.f8889a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list108 = r.f8889a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 10:
                if (i == 0) {
                    throw null;
                }
                int c18 = j.c(i);
                if (c18 == 1) {
                    List list109 = r3.s.f8891a;
                    return "SaleOptOutNotice";
                }
                if (c18 == 3) {
                    List list110 = r3.s.f8891a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c18 == 6) {
                    List list111 = r3.s.f8891a;
                    return "ProcessingNotice";
                }
                if (c18 == 7) {
                    List list112 = r3.s.f8891a;
                    return "SaleOptOut";
                }
                switch (c18) {
                    case 9:
                        List list113 = r3.s.f8891a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list114 = r3.s.f8891a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list115 = r3.s.f8891a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list116 = r3.s.f8891a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list117 = r3.s.f8891a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list118 = r3.s.f8891a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list119 = r3.s.f8891a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 11:
                if (i == 0) {
                    throw null;
                }
                int c19 = j.c(i);
                if (c19 == 1) {
                    List list120 = t.f8893a;
                    return "SaleOptOutNotice";
                }
                if (c19 == 3) {
                    List list121 = t.f8893a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c19 == 6) {
                    List list122 = t.f8893a;
                    return "ProcessingNotice";
                }
                if (c19 == 7) {
                    List list123 = t.f8893a;
                    return "SaleOptOut";
                }
                switch (c19) {
                    case 9:
                        List list124 = t.f8893a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list125 = t.f8893a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list126 = t.f8893a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list127 = t.f8893a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list128 = t.f8893a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list129 = t.f8893a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list130 = t.f8893a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 12:
                if (i == 0) {
                    throw null;
                }
                int c20 = j.c(i);
                if (c20 == 1) {
                    List list131 = u.f8895a;
                    return "SaleOptOutNotice";
                }
                if (c20 == 3) {
                    List list132 = u.f8895a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c20 == 6) {
                    List list133 = u.f8895a;
                    return "ProcessingNotice";
                }
                if (c20 == 7) {
                    List list134 = u.f8895a;
                    return "SaleOptOut";
                }
                switch (c20) {
                    case 9:
                        List list135 = u.f8895a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list136 = u.f8895a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list137 = u.f8895a;
                        return "KnownChildSensitiveDataConsents";
                    case 12:
                        List list138 = u.f8895a;
                        return "AdditionalDataProcessingConsent";
                    case 13:
                        List list139 = u.f8895a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list140 = u.f8895a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list141 = u.f8895a;
                        return "MspaServiceProviderMode";
                    default:
                        return "";
                }
            case 13:
                if (i == 0) {
                    throw null;
                }
                switch (j.c(i)) {
                    case 0:
                        List list142 = v.f8897a;
                        return "SharingNotice";
                    case 1:
                        List list143 = v.f8897a;
                        return "SaleOptOutNotice";
                    case 2:
                    case 5:
                    case 6:
                    case 8:
                    case 12:
                    default:
                        return "";
                    case 3:
                        List list144 = v.f8897a;
                        return "TargetedAdvertisingOptOutNotice";
                    case 4:
                        List list145 = v.f8897a;
                        return "SensitiveDataProcessingOptOutNotice";
                    case 7:
                        List list146 = v.f8897a;
                        return "SaleOptOut";
                    case 9:
                        List list147 = v.f8897a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list148 = v.f8897a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list149 = v.f8897a;
                        return "KnownChildSensitiveDataConsents";
                    case 13:
                        List list150 = v.f8897a;
                        return "MspaCoveredTransaction";
                    case 14:
                        List list151 = v.f8897a;
                        return "MspaOptOutOptionMode";
                    case 15:
                        List list152 = v.f8897a;
                        return "MspaServiceProviderMode";
                }
            default:
                if (i == 0) {
                    throw null;
                }
                int c21 = j.c(i);
                if (c21 == 0) {
                    List list153 = w.f8898a;
                    return "SharingNotice";
                }
                if (c21 == 1) {
                    List list154 = w.f8898a;
                    return "SaleOptOutNotice";
                }
                if (c21 == 3) {
                    List list155 = w.f8898a;
                    return "TargetedAdvertisingOptOutNotice";
                }
                if (c21 == 7) {
                    List list156 = w.f8898a;
                    return "SaleOptOut";
                }
                switch (c21) {
                    case 9:
                        List list157 = w.f8898a;
                        return "TargetedAdvertisingOptOut";
                    case 10:
                        List list158 = w.f8898a;
                        return "SensitiveDataProcessing";
                    case 11:
                        List list159 = w.f8898a;
                        return "KnownChildSensitiveDataConsents";
                    default:
                        switch (c21) {
                            case 13:
                                List list160 = w.f8898a;
                                return "MspaCoveredTransaction";
                            case 14:
                                List list161 = w.f8898a;
                                return "MspaOptOutOptionMode";
                            case 15:
                                List list162 = w.f8898a;
                                return "MspaServiceProviderMode";
                            default:
                                return "";
                        }
                }
        }
    }

    @Override // y2.s
    public void f(int i, boolean z9) {
        int i6;
        switch (this.f7005p) {
            case 1:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            default:
                super.f(i, z9);
                return;
            case 3:
                if (i == 0) {
                    throw null;
                }
                List<Integer> d02 = z9 ? m.d0(1, 1, 1, 1, 1) : m.d0(2, 2, 2, 2, 2);
                d(i, d02);
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(d02);
                return;
            case 5:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 7:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 9:
                if (i == 0) {
                    throw null;
                }
                List<Integer> d03 = z9 ? m.d0(1, 1, 1, 1, 1) : m.d0(2, 2, 2, 2, 2);
                d(i, d03);
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(d03);
                return;
            case 11:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 12:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 13:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
            case 14:
                if (i == 0) {
                    throw null;
                }
                i6 = z9 ? 1 : 2;
                d(i, Integer.valueOf(i6));
                ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(a.a.H(Integer.valueOf(i6)));
                return;
        }
    }

    @Override // y2.s
    public void g(Boolean bool, int i) {
        switch (this.f7005p) {
            case 3:
                if (i == 0) {
                    throw null;
                }
                Boolean bool2 = Boolean.TRUE;
                int i6 = kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2);
                d(i, Integer.valueOf(i6));
                return;
            case 4:
                if (i == 0) {
                    throw null;
                }
                Boolean bool3 = Boolean.TRUE;
                int i10 = kotlin.jvm.internal.l.a(bool, bool3) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool3) ? 1 : 2);
                d(i, Integer.valueOf(i10));
                return;
            case 5:
            default:
                super.g(bool, i);
                return;
            case 6:
                if (i == 0) {
                    throw null;
                }
                Boolean bool4 = Boolean.TRUE;
                int i11 = kotlin.jvm.internal.l.a(bool, bool4) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool4) ? 1 : 2);
                d(i, Integer.valueOf(i11));
                return;
            case 7:
                if (i == 0) {
                    throw null;
                }
                Boolean bool5 = Boolean.TRUE;
                int i12 = kotlin.jvm.internal.l.a(bool, bool5) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool5) ? 1 : 2);
                d(i, Integer.valueOf(i12));
                return;
            case 8:
                if (i == 0) {
                    throw null;
                }
                Boolean bool6 = Boolean.TRUE;
                int i13 = kotlin.jvm.internal.l.a(bool, bool6) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool6) ? 1 : 2);
                d(i, Integer.valueOf(i13));
                return;
            case 9:
                if (i == 0) {
                    throw null;
                }
                Boolean bool7 = Boolean.TRUE;
                int i14 = kotlin.jvm.internal.l.a(bool, bool7) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool7) ? 1 : 2);
                d(i, Integer.valueOf(i14));
                return;
            case 10:
                if (i == 0) {
                    throw null;
                }
                Boolean bool8 = Boolean.TRUE;
                int i15 = kotlin.jvm.internal.l.a(bool, bool8) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool8) ? 1 : 2);
                d(i, Integer.valueOf(i15));
                return;
            case 11:
                if (i == 0) {
                    throw null;
                }
                Boolean bool9 = Boolean.TRUE;
                int i16 = kotlin.jvm.internal.l.a(bool, bool9) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool9) ? 1 : 2);
                d(i, Integer.valueOf(i16));
                return;
            case 12:
                if (i == 0) {
                    throw null;
                }
                Boolean bool10 = Boolean.TRUE;
                int i17 = kotlin.jvm.internal.l.a(bool, bool10) ? 1 : 2;
                ((USRegulationData) this.f11758n).setAdditionalProcessingDataConsent(kotlin.jvm.internal.l.a(bool, bool10) ? 1 : 2);
                d(i, Integer.valueOf(i17));
                return;
        }
    }

    @Override // y2.s
    public void i(boolean z9) {
        switch (this.f7005p) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                break;
            default:
                super.i(z9);
                break;
        }
    }

    @Override // y2.s
    public final String k() {
        switch (this.f7005p) {
            case 0:
                return "usca";
            case 1:
                return "usco";
            case 2:
                return "usct";
            case 3:
                return "usde";
            case 4:
                return "usfl";
            case 5:
                return "usia";
            case 6:
                return "usmt";
            case 7:
                return "usne";
            case 8:
                return "usnh";
            case 9:
                return "usnj";
            case 10:
                return "usor";
            case 11:
                return "ustn";
            case 12:
                return "ustx";
            case 13:
                return "usut";
            default:
                return "usva";
        }
    }

    @Override // y2.s
    public void l(boolean z9) {
        switch (this.f7005p) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
                break;
            case 5:
            case 13:
            default:
                super.l(z9);
                break;
        }
    }

    @Override // y2.s
    public final int o() {
        switch (this.f7005p) {
            case 0:
                return 8;
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 17;
            case 4:
                return 13;
            case 5:
                return 18;
            case 6:
                return 14;
            case 7:
                return 19;
            case 8:
                return 20;
            case 9:
                return 21;
            case 10:
                return 15;
            case 11:
                return 22;
            case 12:
                return 16;
            case 13:
                return 11;
            default:
                return 9;
        }
    }

    @Override // y2.s
    public void p(boolean z9) {
        switch (this.f7005p) {
            case 0:
                break;
            default:
                super.p(z9);
                break;
        }
    }

    @Override // y2.s
    public void q(boolean z9) {
        switch (this.f7005p) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                break;
            default:
                super.q(z9);
                break;
        }
    }

    @Override // y2.s
    public void r(boolean z9) {
        switch (this.f7005p) {
            case 0:
                break;
            default:
                super.r(z9);
                break;
        }
    }

    private final void A0(boolean z9) {
    }

    private final void B0(boolean z9) {
    }

    private final void C0(boolean z9) {
    }

    private final void D0(boolean z9) {
    }

    private final void E0(boolean z9) {
    }

    private final void F0(boolean z9) {
    }

    private final void G0(boolean z9) {
    }

    private final void Q(boolean z9) {
    }

    private final void R(boolean z9) {
    }

    private final void S(boolean z9) {
    }

    private final void T(boolean z9) {
    }

    private final void U(boolean z9) {
    }

    private final void V(boolean z9) {
    }

    private final void W(boolean z9) {
    }

    private final void X(boolean z9) {
    }

    private final void Y(boolean z9) {
    }

    private final void Z(boolean z9) {
    }

    private final void a0(boolean z9) {
    }

    private final void b0(boolean z9) {
    }

    private final void c0(boolean z9) {
    }

    private final void d0(boolean z9) {
    }

    private final void e0(boolean z9) {
    }

    private final void f0(boolean z9) {
    }

    private final void g0(boolean z9) {
    }

    private final void h0(boolean z9) {
    }

    private final void i0(boolean z9) {
    }

    private final void j0(boolean z9) {
    }

    private final void k0(boolean z9) {
    }

    private final void l0(boolean z9) {
    }

    private final void m0(boolean z9) {
    }

    private final void n0(boolean z9) {
    }

    private final void o0(boolean z9) {
    }

    private final void p0(boolean z9) {
    }

    private final void q0(boolean z9) {
    }

    private final void r0(boolean z9) {
    }

    private final void s0(boolean z9) {
    }

    private final void t0(boolean z9) {
    }

    private final void u0(boolean z9) {
    }

    private final void v0(boolean z9) {
    }

    private final void w0(boolean z9) {
    }

    private final void x0(boolean z9) {
    }

    private final void y0(boolean z9) {
    }

    private final void z0(boolean z9) {
    }
}
