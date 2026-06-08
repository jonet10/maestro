package t3;

import androidx.lifecycle.l;
import java.util.Arrays;
import java.util.List;
import k0.k;
import r3.t;
import r3.u;
import r3.v;
import r3.w;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9566e;
    public m3.c f;
    public n3.a g;

    public /* synthetic */ f(int i) {
        this.f9566e = i;
    }

    @Override // t3.a
    public final void b(String str, r3.b bVar) {
        switch (this.f9566e) {
            case 0:
                r3.a aVar = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar);
                }
                try {
                    this.f.getClass();
                    String a8 = m3.b.a(str);
                    n3.a aVar2 = this.g;
                    List list = t.f8894b;
                    aVar2.getClass();
                    n3.a.a(a8, list, aVar);
                    break;
                } catch (Exception e10) {
                    o.m(l.w("Unable to decode UsTnGpcSegment '", str, "'"), e10);
                    return;
                }
            case 1:
                r3.a aVar3 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar3);
                }
                try {
                    this.f.getClass();
                    String a10 = m3.b.a(str);
                    n3.a aVar4 = this.g;
                    List list2 = u.f8895a;
                    aVar4.getClass();
                    n3.a.a(a10, list2, aVar3);
                    break;
                } catch (Exception e11) {
                    o.m(l.w("Unable to decode UsTxCoreSegment '", str, "'"), e11);
                    return;
                }
            case 2:
                r3.a aVar5 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar5);
                }
                try {
                    this.f.getClass();
                    String a11 = m3.b.a(str);
                    n3.a aVar6 = this.g;
                    List list3 = u.f8896b;
                    aVar6.getClass();
                    n3.a.a(a11, list3, aVar5);
                    break;
                } catch (Exception e12) {
                    o.m(l.w("Unable to decode UsTxGpcSegment '", str, "'"), e12);
                    return;
                }
            case 3:
                r3.a aVar7 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar7);
                }
                try {
                    this.f.getClass();
                    String a12 = m3.b.a(str);
                    n3.a aVar8 = this.g;
                    List list4 = v.f8897a;
                    aVar8.getClass();
                    n3.a.a(a12, list4, aVar7);
                    break;
                } catch (Exception e13) {
                    o.m(l.w("Unable to decode UsUtCoreSegment '", str, "'"), e13);
                    return;
                }
            default:
                r3.a aVar9 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar9);
                }
                try {
                    this.f.getClass();
                    String a13 = m3.b.a(str);
                    n3.a aVar10 = this.g;
                    List list5 = w.f8898a;
                    aVar10.getClass();
                    n3.a.a(a13, list5, aVar9);
                    break;
                } catch (Exception e14) {
                    o.m(l.w("Unable to decode UsVaCoreSegment '", str, "'"), e14);
                }
        }
    }

    @Override // t3.a
    public final String d(r3.b bVar) {
        switch (this.f9566e) {
            case 0:
                n3.a aVar = this.g;
                List list = t.f8894b;
                aVar.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list));
            case 1:
                n3.a aVar2 = this.g;
                List list2 = u.f8895a;
                aVar2.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list2));
            case 2:
                n3.a aVar3 = this.g;
                List list3 = u.f8896b;
                aVar3.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list3));
            case 3:
                n3.a aVar4 = this.g;
                List list4 = v.f8897a;
                aVar4.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list4));
            default:
                n3.a aVar5 = this.g;
                List list5 = w.f8898a;
                aVar5.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list5));
        }
    }

    @Override // t3.a
    public final r3.b f() {
        switch (this.f9566e) {
            case 0:
                r3.a aVar = new r3.a();
                List list = t.f8893a;
                aVar.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar;
            case 1:
                e eVar = new e(13);
                e eVar2 = new e(14);
                e eVar3 = new e(15);
                r3.a aVar2 = new r3.a();
                List list2 = u.f8895a;
                aVar2.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar = new o3.d(2, (Integer) 0);
                dVar.f8149b = eVar;
                o3.d k5 = k.k(aVar2, "ProcessingNotice", dVar, 2, 0);
                k5.f8149b = eVar;
                o3.d k10 = k.k(aVar2, "SaleOptOutNotice", k5, 2, 0);
                k10.f8149b = eVar;
                o3.d k11 = k.k(aVar2, "TargetedAdvertisingOptOutNotice", k10, 2, 0);
                k11.f8149b = eVar;
                o3.d k12 = k.k(aVar2, "SaleOptOut", k11, 2, 0);
                k12.f8149b = eVar;
                aVar2.b("TargetedAdvertisingOptOut", k12);
                o3.d dVar2 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar2.f8149b = eVar3;
                aVar2.b("SensitiveDataProcessing", dVar2);
                o3.d dVar3 = new o3.d(2, (Integer) 0);
                dVar3.f8149b = eVar;
                o3.d k13 = k.k(aVar2, "KnownChildSensitiveDataConsents", dVar3, 2, 0);
                k13.f8149b = eVar;
                o3.d k14 = k.k(aVar2, "AdditionalDataProcessingConsent", k13, 2, 1);
                k14.f8149b = eVar2;
                o3.d k15 = k.k(aVar2, "MspaCoveredTransaction", k14, 2, 0);
                k15.f8149b = eVar;
                o3.d k16 = k.k(aVar2, "MspaOptOutOptionMode", k15, 2, 0);
                k16.f8149b = eVar;
                aVar2.b("MspaServiceProviderMode", k16);
                return aVar2;
            case 2:
                r3.a aVar3 = new r3.a();
                List list3 = u.f8895a;
                aVar3.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar3.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar3.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar3;
            case 3:
                e eVar4 = new e(16);
                e eVar5 = new e(17);
                e eVar6 = new e(18);
                r3.a aVar4 = new r3.a();
                List list4 = v.f8897a;
                aVar4.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar4 = new o3.d(2, (Integer) 0);
                dVar4.f8149b = eVar4;
                o3.d k17 = k.k(aVar4, "SharingNotice", dVar4, 2, 0);
                k17.f8149b = eVar4;
                o3.d k18 = k.k(aVar4, "SaleOptOutNotice", k17, 2, 0);
                k18.f8149b = eVar4;
                o3.d k19 = k.k(aVar4, "TargetedAdvertisingOptOutNotice", k18, 2, 0);
                k19.f8149b = eVar4;
                o3.d k20 = k.k(aVar4, "SensitiveDataProcessingOptOutNotice", k19, 2, 0);
                k20.f8149b = eVar4;
                o3.d k21 = k.k(aVar4, "SaleOptOut", k20, 2, 0);
                k21.f8149b = eVar4;
                aVar4.b("TargetedAdvertisingOptOut", k21);
                o3.d dVar5 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar5.f8149b = eVar6;
                aVar4.b("SensitiveDataProcessing", dVar5);
                o3.d dVar6 = new o3.d(2, (Integer) 0);
                dVar6.f8149b = eVar4;
                o3.d k22 = k.k(aVar4, "KnownChildSensitiveDataConsents", dVar6, 2, 1);
                k22.f8149b = eVar5;
                o3.d k23 = k.k(aVar4, "MspaCoveredTransaction", k22, 2, 0);
                k23.f8149b = eVar4;
                o3.d k24 = k.k(aVar4, "MspaOptOutOptionMode", k23, 2, 0);
                k24.f8149b = eVar4;
                aVar4.b("MspaServiceProviderMode", k24);
                return aVar4;
            default:
                e eVar7 = new e(19);
                e eVar8 = new e(20);
                e eVar9 = new e(21);
                r3.a aVar5 = new r3.a();
                List list5 = w.f8898a;
                aVar5.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar7 = new o3.d(2, (Integer) 0);
                dVar7.f8149b = eVar7;
                o3.d k25 = k.k(aVar5, "SharingNotice", dVar7, 2, 0);
                k25.f8149b = eVar7;
                o3.d k26 = k.k(aVar5, "SaleOptOutNotice", k25, 2, 0);
                k26.f8149b = eVar7;
                o3.d k27 = k.k(aVar5, "TargetedAdvertisingOptOutNotice", k26, 2, 0);
                k27.f8149b = eVar7;
                o3.d k28 = k.k(aVar5, "SaleOptOut", k27, 2, 0);
                k28.f8149b = eVar7;
                aVar5.b("TargetedAdvertisingOptOut", k28);
                o3.d dVar8 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar8.f8149b = eVar9;
                aVar5.b("SensitiveDataProcessing", dVar8);
                o3.d dVar9 = new o3.d(2, (Integer) 0);
                dVar9.f8149b = eVar7;
                o3.d k29 = k.k(aVar5, "KnownChildSensitiveDataConsents", dVar9, 2, 1);
                k29.f8149b = eVar8;
                o3.d k30 = k.k(aVar5, "MspaCoveredTransaction", k29, 2, 0);
                k30.f8149b = eVar7;
                o3.d k31 = k.k(aVar5, "MspaOptOutOptionMode", k30, 2, 0);
                k31.f8149b = eVar7;
                aVar5.b("MspaServiceProviderMode", k31);
                return aVar5;
        }
    }
}
