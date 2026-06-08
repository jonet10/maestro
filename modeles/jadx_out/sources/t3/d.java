package t3;

import androidx.lifecycle.l;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k0.k;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9564e;
    public m3.d f;
    public n3.a g;

    public /* synthetic */ d(int i) {
        this.f9564e = i;
    }

    @Override // t3.a
    public final void b(String str, r3.b bVar) {
        switch (this.f9564e) {
            case 0:
                r3.a aVar = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar);
                }
                try {
                    this.f.getClass();
                    String a8 = m3.b.a(str);
                    n3.a aVar2 = this.g;
                    List list = r3.f.f8864a;
                    aVar2.getClass();
                    n3.a.a(a8, list, aVar);
                    break;
                } catch (Exception e10) {
                    o.m(l.w("Unable to decode TcfEuV2CoreSegment '", str, "'"), e10);
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
                    List list2 = r3.f.f8865b;
                    aVar4.getClass();
                    n3.a.a(a10, list2, aVar3);
                    break;
                } catch (Exception e11) {
                    o.m(l.w("Unable to decode TcfEuV2PublisherPurposesSegment '", str, "'"), e11);
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
                    List list3 = r3.f.f8866c;
                    aVar6.getClass();
                    n3.a.a(a11, list3, aVar5);
                    break;
                } catch (Exception e12) {
                    o.m(l.w("Unable to decode TcfEuV2VendorsAllowedSegment '", str, "'"), e12);
                    return;
                }
            default:
                r3.a aVar7 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar7);
                }
                try {
                    this.f.getClass();
                    String a12 = m3.b.a(str);
                    n3.a aVar8 = this.g;
                    List list4 = r3.f.f8867d;
                    aVar8.getClass();
                    n3.a.a(a12, list4, aVar7);
                    break;
                } catch (Exception e13) {
                    o.m(l.w("Unable to decode TcfEuV2VendorsDisclosedSegment '", str, "'"), e13);
                }
        }
    }

    @Override // t3.a
    public final String d(r3.b bVar) {
        switch (this.f9564e) {
            case 0:
                n3.a aVar = this.g;
                List list = r3.f.f8864a;
                aVar.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list));
            case 1:
                n3.a aVar2 = this.g;
                List list2 = r3.f.f8865b;
                aVar2.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list2));
            case 2:
                n3.a aVar3 = this.g;
                List list3 = r3.f.f8866c;
                aVar3.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list3));
            default:
                n3.a aVar4 = this.g;
                List list4 = r3.f.f8867d;
                aVar4.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list4));
        }
    }

    @Override // t3.a
    public final r3.b f() {
        switch (this.f9564e) {
            case 0:
                ZonedDateTime now = ZonedDateTime.now();
                r3.a aVar = new r3.a();
                List list = r3.f.f8864a;
                aVar.b("Version", new o3.d(6, (Integer) 2));
                aVar.b("Created", new o3.c(now));
                aVar.b("LastUpdated", new o3.c(now));
                aVar.b("ConsentScreen", k.k(aVar, "CmpVersion", k.k(aVar, "CmpId", new o3.d(12, (Integer) 0), 12, 0), 6, 0));
                aVar.b("ConsentLanguage", new o3.c("EN"));
                aVar.b("VendorListVersion", new o3.d(12, (Integer) 0));
                aVar.b("PolicyVersion", new o3.d(6, (Integer) 2));
                Boolean bool = Boolean.FALSE;
                aVar.b("IsServiceSpecific", new o3.c(bool));
                aVar.b("UseNonStandardStacks", new o3.c(bool));
                aVar.b("SpecialFeatureOptins", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeConsents", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeLegitimateInterests", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar.b("PurposeOneTreatment", new o3.c(bool));
                aVar.b("PublisherCountryCode", new o3.c("AA"));
                aVar.b("VendorConsents", new o3.c(new ArrayList(), 5));
                aVar.b("VendorLegitimateInterests", new o3.c(new ArrayList(), 5));
                aVar.b("PublisherRestrictions", new o3.c(new ArrayList(), 0));
                return aVar;
            case 1:
                r3.a aVar2 = new r3.a();
                List list2 = r3.f.f8864a;
                aVar2.b("PublisherPurposesSegmentType", new o3.d(3, (Integer) 3));
                Boolean bool2 = Boolean.FALSE;
                aVar2.b("PublisherConsents", new o3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                aVar2.b("PublisherLegitimateInterests", new o3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                o3.d dVar = new o3.d(6, (Integer) 0);
                aVar2.b("NumCustomPurposes", dVar);
                c cVar = new c(dVar, 1);
                aVar2.b("PublisherCustomConsents", new o3.e(cVar, new ArrayList()));
                aVar2.b("PublisherCustomLegitimateInterests", new o3.e(cVar, new ArrayList()));
                return aVar2;
            case 2:
                r3.a aVar3 = new r3.a();
                List list3 = r3.f.f8864a;
                aVar3.b("VendorsAllowedSegmentType", new o3.d(3, (Integer) 2));
                aVar3.b("VendorsAllowed", new o3.c(new ArrayList(), 5));
                return aVar3;
            default:
                r3.a aVar4 = new r3.a();
                List list4 = r3.f.f8864a;
                aVar4.b("VendorsDisclosedSegmentType", new o3.d(3, (Integer) 1));
                aVar4.b("VendorsDisclosed", new o3.c(new ArrayList(), 5));
                return aVar4;
        }
    }
}
