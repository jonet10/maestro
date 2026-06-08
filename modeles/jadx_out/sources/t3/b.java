package t3;

import androidx.lifecycle.l;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r3.h;
import r3.i;
import r3.j;
import r3.k;
import r3.m;
import r3.n;
import r3.p;
import r3.q;
import r3.r;
import r3.s;
import r3.t;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9561e;
    public m3.c f;
    public n3.a g;

    public /* synthetic */ b(int i) {
        this.f9561e = i;
    }

    @Override // t3.a
    public final void b(String str, r3.b bVar) {
        switch (this.f9561e) {
            case 0:
                r3.a aVar = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar);
                }
                try {
                    this.f.getClass();
                    String a8 = m3.b.a(str);
                    n3.a aVar2 = this.g;
                    List list = r3.d.f8860a;
                    aVar2.getClass();
                    n3.a.a(a8, list, aVar);
                    break;
                } catch (Exception e10) {
                    o.m(l.w("Unable to decode HeaderV1CoreSegment '", str, "'"), e10);
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
                    List list2 = r3.e.f8861a;
                    aVar4.getClass();
                    n3.a.a(a10, list2, aVar3);
                    break;
                } catch (Exception e11) {
                    o.m(l.w("Unable to decode TcfCaV1CoreSegment '", str, "'"), e11);
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
                    List list3 = r3.e.f8863c;
                    aVar6.getClass();
                    n3.a.a(a11, list3, aVar5);
                    break;
                } catch (Exception e12) {
                    o.m(l.w("Unable to decode TcfCaV1DisclosedVendorsSegment '", str, "'"), e12);
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
                    List list4 = r3.e.f8862b;
                    aVar8.getClass();
                    n3.a.a(a12, list4, aVar7);
                    break;
                } catch (Exception e13) {
                    o.m(l.w("Unable to decode TcfCaV1PublisherPurposesSegment '", str, "'"), e13);
                    return;
                }
            case 4:
                r3.a aVar9 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar9);
                }
                try {
                    this.f.getClass();
                    String a13 = m3.b.a(str);
                    n3.a aVar10 = this.g;
                    List list5 = r3.g.f8868a;
                    aVar10.getClass();
                    n3.a.a(a13, list5, aVar9);
                    break;
                } catch (Exception e14) {
                    o.m(l.w("Unable to decode UsCaCoreSegment '", str, "'"), e14);
                    return;
                }
            case 5:
                r3.a aVar11 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar11);
                }
                try {
                    this.f.getClass();
                    String a14 = m3.b.a(str);
                    n3.a aVar12 = this.g;
                    List list6 = r3.g.f8869b;
                    aVar12.getClass();
                    n3.a.a(a14, list6, aVar11);
                    break;
                } catch (Exception e15) {
                    o.m(l.w("Unable to decode UsCaGpcSegment '", str, "'"), e15);
                    return;
                }
            case 6:
                r3.a aVar13 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar13);
                }
                try {
                    this.f.getClass();
                    String a15 = m3.b.a(str);
                    n3.a aVar14 = this.g;
                    List list7 = h.f8870a;
                    aVar14.getClass();
                    n3.a.a(a15, list7, aVar13);
                    break;
                } catch (Exception e16) {
                    o.m(l.w("Unable to decode UsCoCoreSegment '", str, "'"), e16);
                    return;
                }
            case 7:
                r3.a aVar15 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar15);
                }
                try {
                    this.f.getClass();
                    String a16 = m3.b.a(str);
                    n3.a aVar16 = this.g;
                    List list8 = h.f8871b;
                    aVar16.getClass();
                    n3.a.a(a16, list8, aVar15);
                    break;
                } catch (Exception e17) {
                    o.m(l.w("Unable to decode UsCoGpcSegment '", str, "'"), e17);
                    return;
                }
            case 8:
                r3.a aVar17 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar17);
                }
                try {
                    this.f.getClass();
                    String a17 = m3.b.a(str);
                    n3.a aVar18 = this.g;
                    List list9 = i.f8872a;
                    aVar18.getClass();
                    n3.a.a(a17, list9, aVar17);
                    break;
                } catch (Exception e18) {
                    o.m(l.w("Unable to decode UsCtCoreSegment '", str, "'"), e18);
                    return;
                }
            case 9:
                r3.a aVar19 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar19);
                }
                try {
                    this.f.getClass();
                    String a18 = m3.b.a(str);
                    n3.a aVar20 = this.g;
                    List list10 = i.f8873b;
                    aVar20.getClass();
                    n3.a.a(a18, list10, aVar19);
                    break;
                } catch (Exception e19) {
                    o.m(l.w("Unable to decode UsCtGpcSegment '", str, "'"), e19);
                    return;
                }
            case 10:
                r3.a aVar21 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar21);
                }
                try {
                    this.f.getClass();
                    String a19 = m3.b.a(str);
                    n3.a aVar22 = this.g;
                    List list11 = j.f8874a;
                    aVar22.getClass();
                    n3.a.a(a19, list11, aVar21);
                    break;
                } catch (Exception e20) {
                    o.m(l.w("Unable to decode UsDeCoreSegment '", str, "'"), e20);
                    return;
                }
            case 11:
                r3.a aVar23 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar23);
                }
                try {
                    this.f.getClass();
                    String a20 = m3.b.a(str);
                    n3.a aVar24 = this.g;
                    List list12 = j.f8875b;
                    aVar24.getClass();
                    n3.a.a(a20, list12, aVar23);
                    break;
                } catch (Exception e21) {
                    o.m(l.w("Unable to decode UsDeGpcSegment '", str, "'"), e21);
                    return;
                }
            case 12:
                r3.a aVar25 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar25);
                }
                try {
                    this.f.getClass();
                    String a21 = m3.b.a(str);
                    n3.a aVar26 = this.g;
                    List list13 = k.f8876a;
                    aVar26.getClass();
                    n3.a.a(a21, list13, aVar25);
                    break;
                } catch (Exception e22) {
                    o.m(l.w("Unable to decode UsFlCoreSegment '", str, "'"), e22);
                    return;
                }
            case 13:
                r3.a aVar27 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar27);
                }
                try {
                    this.f.getClass();
                    String a22 = m3.b.a(str);
                    n3.a aVar28 = this.g;
                    List list14 = r3.l.f8877a;
                    aVar28.getClass();
                    n3.a.a(a22, list14, aVar27);
                    break;
                } catch (Exception e23) {
                    o.m(l.w("Unable to decode UsIaCoreSegment '", str, "'"), e23);
                    return;
                }
            case 14:
                r3.a aVar29 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar29);
                }
                try {
                    this.f.getClass();
                    String a23 = m3.b.a(str);
                    n3.a aVar30 = this.g;
                    List list15 = r3.l.f8878b;
                    aVar30.getClass();
                    n3.a.a(a23, list15, aVar29);
                    break;
                } catch (Exception e24) {
                    o.m(l.w("Unable to decode UsIaGpcSegment '", str, "'"), e24);
                    return;
                }
            case 15:
                r3.a aVar31 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar31);
                }
                try {
                    this.f.getClass();
                    String a24 = m3.b.a(str);
                    n3.a aVar32 = this.g;
                    List list16 = m.f8879a;
                    aVar32.getClass();
                    n3.a.a(a24, list16, aVar31);
                    break;
                } catch (Exception e25) {
                    o.m(l.w("Unable to decode UsMnCoreSegment '", str, "'"), e25);
                    return;
                }
            case 16:
                r3.a aVar33 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar33);
                }
                try {
                    this.f.getClass();
                    String a25 = m3.b.a(str);
                    n3.a aVar34 = this.g;
                    List list17 = m.f8880b;
                    aVar34.getClass();
                    n3.a.a(a25, list17, aVar33);
                    break;
                } catch (Exception e26) {
                    o.m(l.w("Unable to decode UsMnGpcSegment '", str, "'"), e26);
                    return;
                }
            case 17:
                r3.a aVar35 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar35);
                }
                try {
                    this.f.getClass();
                    String a26 = m3.b.a(str);
                    n3.a aVar36 = this.g;
                    List list18 = n.f8881a;
                    aVar36.getClass();
                    n3.a.a(a26, list18, aVar35);
                    break;
                } catch (Exception e27) {
                    o.m(l.w("Unable to decode UsMtCoreSegment '", str, "'"), e27);
                    return;
                }
            case 18:
                r3.a aVar37 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar37);
                }
                try {
                    this.f.getClass();
                    String a27 = m3.b.a(str);
                    n3.a aVar38 = this.g;
                    List list19 = n.f8882b;
                    aVar38.getClass();
                    n3.a.a(a27, list19, aVar37);
                    break;
                } catch (Exception e28) {
                    o.m(l.w("Unable to decode UsMtGpcSegment '", str, "'"), e28);
                    return;
                }
            case 19:
                r3.a aVar39 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar39);
                }
                try {
                    this.f.getClass();
                    String a28 = m3.b.a(str);
                    if (a28.length() == 60) {
                        a28 = a28.substring(0, 48) + "00000000" + a28.substring(48, 52) + "00" + a28.substring(52, 60) + "00";
                    } else if (a28.length() == 66) {
                        a28 = a28.substring(0, 48) + "00000000" + a28.substring(48, 52) + "00" + a28.substring(52, 62);
                    }
                    n3.a aVar40 = this.g;
                    List list20 = r3.o.f8883a;
                    aVar40.getClass();
                    n3.a.a(a28, list20, aVar39);
                    break;
                } catch (Exception e29) {
                    o.m(l.w("Unable to decode UsNatCoreSegment '", str, "'"), e29);
                    return;
                }
                break;
            case 20:
                r3.a aVar41 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar41);
                }
                try {
                    this.f.getClass();
                    String a29 = m3.b.a(str);
                    n3.a aVar42 = this.g;
                    List list21 = r3.o.f8884b;
                    aVar42.getClass();
                    n3.a.a(a29, list21, aVar41);
                    break;
                } catch (Exception e30) {
                    o.m(l.w("Unable to decode UsNatGpcSegment '", str, "'"), e30);
                    return;
                }
            case 21:
                r3.a aVar43 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar43);
                }
                try {
                    this.f.getClass();
                    String a30 = m3.b.a(str);
                    n3.a aVar44 = this.g;
                    List list22 = p.f8885a;
                    aVar44.getClass();
                    n3.a.a(a30, list22, aVar43);
                    break;
                } catch (Exception e31) {
                    o.m(l.w("Unable to decode UsNeCoreSegment '", str, "'"), e31);
                    return;
                }
            case 22:
                r3.a aVar45 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar45);
                }
                try {
                    this.f.getClass();
                    String a31 = m3.b.a(str);
                    n3.a aVar46 = this.g;
                    List list23 = p.f8886b;
                    aVar46.getClass();
                    n3.a.a(a31, list23, aVar45);
                    break;
                } catch (Exception e32) {
                    o.m(l.w("Unable to decode UsNeGpcSegment '", str, "'"), e32);
                    return;
                }
            case 23:
                r3.a aVar47 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar47);
                }
                try {
                    this.f.getClass();
                    String a32 = m3.b.a(str);
                    n3.a aVar48 = this.g;
                    List list24 = q.f8887a;
                    aVar48.getClass();
                    n3.a.a(a32, list24, aVar47);
                    break;
                } catch (Exception e33) {
                    o.m(l.w("Unable to decode UsNhCoreSegment '", str, "'"), e33);
                    return;
                }
            case 24:
                r3.a aVar49 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar49);
                }
                try {
                    this.f.getClass();
                    String a33 = m3.b.a(str);
                    n3.a aVar50 = this.g;
                    List list25 = q.f8888b;
                    aVar50.getClass();
                    n3.a.a(a33, list25, aVar49);
                    break;
                } catch (Exception e34) {
                    o.m(l.w("Unable to decode UsNhGpcSegment '", str, "'"), e34);
                    return;
                }
            case 25:
                r3.a aVar51 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar51);
                }
                try {
                    this.f.getClass();
                    String a34 = m3.b.a(str);
                    n3.a aVar52 = this.g;
                    List list26 = r.f8889a;
                    aVar52.getClass();
                    n3.a.a(a34, list26, aVar51);
                    break;
                } catch (Exception e35) {
                    o.m(l.w("Unable to decode UsNjCoreSegment '", str, "'"), e35);
                    return;
                }
            case 26:
                r3.a aVar53 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar53);
                }
                try {
                    this.f.getClass();
                    String a35 = m3.b.a(str);
                    n3.a aVar54 = this.g;
                    List list27 = r.f8890b;
                    aVar54.getClass();
                    n3.a.a(a35, list27, aVar53);
                    break;
                } catch (Exception e36) {
                    o.m(l.w("Unable to decode UsNjGpcSegment '", str, "'"), e36);
                    return;
                }
            case 27:
                r3.a aVar55 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar55);
                }
                try {
                    this.f.getClass();
                    String a36 = m3.b.a(str);
                    n3.a aVar56 = this.g;
                    List list28 = s.f8891a;
                    aVar56.getClass();
                    n3.a.a(a36, list28, aVar55);
                    break;
                } catch (Exception e37) {
                    o.m(l.w("Unable to decode UsOrCoreSegment '", str, "'"), e37);
                    return;
                }
            case 28:
                r3.a aVar57 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar57);
                }
                try {
                    this.f.getClass();
                    String a37 = m3.b.a(str);
                    n3.a aVar58 = this.g;
                    List list29 = s.f8892b;
                    aVar58.getClass();
                    n3.a.a(a37, list29, aVar57);
                    break;
                } catch (Exception e38) {
                    o.m(l.w("Unable to decode UsOrGpcSegment '", str, "'"), e38);
                    return;
                }
            default:
                r3.a aVar59 = (r3.a) bVar;
                if (str == null || str.isEmpty()) {
                    ((r3.a) this.f9557a).c(aVar59);
                }
                try {
                    this.f.getClass();
                    String a38 = m3.b.a(str);
                    n3.a aVar60 = this.g;
                    List list30 = t.f8893a;
                    aVar60.getClass();
                    n3.a.a(a38, list30, aVar59);
                    break;
                } catch (Exception e39) {
                    o.m(l.w("Unable to decode UsTnCoreSegment '", str, "'"), e39);
                }
        }
    }

    @Override // t3.a
    public final String d(r3.b bVar) {
        switch (this.f9561e) {
            case 0:
                n3.a aVar = this.g;
                List list = r3.d.f8860a;
                aVar.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list));
            case 1:
                n3.a aVar2 = this.g;
                List list2 = r3.e.f8861a;
                aVar2.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list2));
            case 2:
                n3.a aVar3 = this.g;
                List list3 = r3.e.f8863c;
                aVar3.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list3));
            case 3:
                n3.a aVar4 = this.g;
                List list4 = r3.e.f8862b;
                aVar4.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list4));
            case 4:
                n3.a aVar5 = this.g;
                List list5 = r3.g.f8868a;
                aVar5.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list5));
            case 5:
                n3.a aVar6 = this.g;
                List list6 = r3.g.f8869b;
                aVar6.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list6));
            case 6:
                n3.a aVar7 = this.g;
                List list7 = h.f8870a;
                aVar7.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list7));
            case 7:
                n3.a aVar8 = this.g;
                List list8 = h.f8871b;
                aVar8.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list8));
            case 8:
                n3.a aVar9 = this.g;
                List list9 = i.f8872a;
                aVar9.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list9));
            case 9:
                n3.a aVar10 = this.g;
                List list10 = i.f8873b;
                aVar10.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list10));
            case 10:
                n3.a aVar11 = this.g;
                List list11 = j.f8874a;
                aVar11.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list11));
            case 11:
                n3.a aVar12 = this.g;
                List list12 = j.f8875b;
                aVar12.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list12));
            case 12:
                n3.a aVar13 = this.g;
                List list13 = k.f8876a;
                aVar13.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list13));
            case 13:
                n3.a aVar14 = this.g;
                List list14 = r3.l.f8877a;
                aVar14.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list14));
            case 14:
                n3.a aVar15 = this.g;
                List list15 = r3.l.f8878b;
                aVar15.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list15));
            case 15:
                n3.a aVar16 = this.g;
                List list16 = m.f8879a;
                aVar16.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list16));
            case 16:
                n3.a aVar17 = this.g;
                List list17 = m.f8880b;
                aVar17.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list17));
            case 17:
                n3.a aVar18 = this.g;
                List list18 = n.f8881a;
                aVar18.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list18));
            case 18:
                n3.a aVar19 = this.g;
                List list19 = n.f8882b;
                aVar19.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list19));
            case 19:
                n3.a aVar20 = this.g;
                List list20 = r3.o.f8883a;
                aVar20.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list20));
            case 20:
                n3.a aVar21 = this.g;
                List list21 = r3.o.f8884b;
                aVar21.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list21));
            case 21:
                n3.a aVar22 = this.g;
                List list22 = p.f8885a;
                aVar22.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list22));
            case 22:
                n3.a aVar23 = this.g;
                List list23 = p.f8886b;
                aVar23.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list23));
            case 23:
                n3.a aVar24 = this.g;
                List list24 = q.f8887a;
                aVar24.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list24));
            case 24:
                n3.a aVar25 = this.g;
                List list25 = q.f8888b;
                aVar25.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list25));
            case 25:
                n3.a aVar26 = this.g;
                List list26 = r.f8889a;
                aVar26.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list26));
            case 26:
                n3.a aVar27 = this.g;
                List list27 = r.f8890b;
                aVar27.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list27));
            case 27:
                n3.a aVar28 = this.g;
                List list28 = s.f8891a;
                aVar28.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list28));
            case 28:
                n3.a aVar29 = this.g;
                List list29 = s.f8892b;
                aVar29.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list29));
            default:
                n3.a aVar30 = this.g;
                List list30 = t.f8893a;
                aVar30.getClass();
                return this.f.b(n3.a.b((r3.a) bVar, list30));
        }
    }

    @Override // t3.a
    public final r3.b f() {
        switch (this.f9561e) {
            case 0:
                r3.a aVar = new r3.a();
                List list = r3.d.f8860a;
                aVar.b("Id", new o3.d(6, (Integer) 3));
                aVar.b("Version", new o3.d(6, (Integer) 1));
                ArrayList arrayList = new ArrayList();
                o3.c cVar = new o3.c(true);
                cVar.setValue(arrayList);
                aVar.b("SectionIds", cVar);
                return aVar;
            case 1:
                ZonedDateTime now = ZonedDateTime.now();
                r3.a aVar2 = new r3.a();
                List list2 = r3.e.f8861a;
                aVar2.b("Version", new o3.d(6, (Integer) 1));
                aVar2.b("Created", new o3.c(now));
                aVar2.b("LastUpdated", new o3.c(now));
                aVar2.b("ConsentScreen", k0.k.k(aVar2, "CmpVersion", k0.k.k(aVar2, "CmpId", new o3.d(12, (Integer) 0), 12, 0), 6, 0));
                aVar2.b("ConsentLanguage", new o3.c("EN"));
                aVar2.b("VendorListVersion", new o3.d(12, (Integer) 0));
                aVar2.b("TcfPolicyVersion", new o3.d(6, (Integer) 2));
                Boolean bool = Boolean.FALSE;
                aVar2.b("UseNonStandardStacks", new o3.c(bool));
                aVar2.b("SpecialFeatureExpressConsent", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("PurposesExpressConsent", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("PurposesImpliedConsent", new o3.d(Arrays.asList(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool), 0));
                aVar2.b("VendorExpressConsent", new o3.c(new ArrayList(), 5));
                aVar2.b("VendorImpliedConsent", new o3.c(new ArrayList(), 5));
                aVar2.b("PubRestrictions", new o3.c(new ArrayList(), 0));
                return aVar2;
            case 2:
                r3.a aVar3 = new r3.a();
                List list3 = r3.e.f8861a;
                aVar3.b("DisclosedVendorsSegmentType", new o3.d(3, (Integer) 1));
                aVar3.b("DisclosedVendors", new o3.c(new ArrayList(), 5));
                return aVar3;
            case 3:
                r3.a aVar4 = new r3.a();
                List list4 = r3.e.f8861a;
                aVar4.b("PubPurposesSegmentType", new o3.d(3, (Integer) 3));
                Boolean bool2 = Boolean.FALSE;
                aVar4.b("PubPurposesExpressConsent", new o3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                aVar4.b("PubPurposesImpliedConsent", new o3.d(Arrays.asList(bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2, bool2), 0));
                o3.d dVar = new o3.d(6, (Integer) 0);
                aVar4.b("NumCustomPurposes", dVar);
                c cVar2 = new c(dVar, 0);
                aVar4.b("CustomPurposesExpressConsent", new o3.e(cVar2, new ArrayList()));
                aVar4.b("CustomPurposesImpliedConsent", new o3.e(cVar2, new ArrayList()));
                return aVar4;
            case 4:
                o3.i iVar = new o3.i(1);
                o3.i iVar2 = new o3.i(2);
                o3.i iVar3 = new o3.i(3);
                r3.a aVar5 = new r3.a();
                List list5 = r3.g.f8868a;
                aVar5.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar2 = new o3.d(2, (Integer) 0);
                dVar2.f8149b = iVar;
                o3.d k5 = k0.k.k(aVar5, "SaleOptOutNotice", dVar2, 2, 0);
                k5.f8149b = iVar;
                o3.d k10 = k0.k.k(aVar5, "SharingOptOutNotice", k5, 2, 0);
                k10.f8149b = iVar;
                o3.d k11 = k0.k.k(aVar5, "SensitiveDataLimitUseNotice", k10, 2, 0);
                k11.f8149b = iVar;
                o3.d k12 = k0.k.k(aVar5, "SaleOptOut", k11, 2, 0);
                k12.f8149b = iVar;
                aVar5.b("SharingOptOut", k12);
                o3.d dVar3 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar3.f8149b = iVar3;
                aVar5.b("SensitiveDataProcessing", dVar3);
                o3.d dVar4 = new o3.d(Arrays.asList(0, 0), 2);
                dVar4.f8149b = iVar3;
                aVar5.b("KnownChildSensitiveDataConsents", dVar4);
                o3.d dVar5 = new o3.d(2, (Integer) 0);
                dVar5.f8149b = iVar;
                o3.d k13 = k0.k.k(aVar5, "PersonalDataConsents", dVar5, 2, 1);
                k13.f8149b = iVar2;
                o3.d k14 = k0.k.k(aVar5, "MspaCoveredTransaction", k13, 2, 0);
                k14.f8149b = iVar;
                o3.d k15 = k0.k.k(aVar5, "MspaOptOutOptionMode", k14, 2, 0);
                k15.f8149b = iVar;
                aVar5.b("MspaServiceProviderMode", k15);
                return aVar5;
            case 5:
                r3.a aVar6 = new r3.a();
                List list6 = r3.g.f8868a;
                aVar6.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar6.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar6.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar6;
            case 6:
                o3.i iVar4 = new o3.i(4);
                o3.i iVar5 = new o3.i(5);
                o3.i iVar6 = new o3.i(6);
                r3.a aVar7 = new r3.a();
                List list7 = h.f8870a;
                aVar7.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar6 = new o3.d(2, (Integer) 0);
                dVar6.f8149b = iVar4;
                o3.d k16 = k0.k.k(aVar7, "SharingNotice", dVar6, 2, 0);
                k16.f8149b = iVar4;
                o3.d k17 = k0.k.k(aVar7, "SaleOptOutNotice", k16, 2, 0);
                k17.f8149b = iVar4;
                o3.d k18 = k0.k.k(aVar7, "TargetedAdvertisingOptOutNotice", k17, 2, 0);
                k18.f8149b = iVar4;
                o3.d k19 = k0.k.k(aVar7, "SaleOptOut", k18, 2, 0);
                k19.f8149b = iVar4;
                aVar7.b("TargetedAdvertisingOptOut", k19);
                o3.d dVar7 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0), 2);
                dVar7.f8149b = iVar6;
                aVar7.b("SensitiveDataProcessing", dVar7);
                o3.d dVar8 = new o3.d(2, (Integer) 0);
                dVar8.f8149b = iVar4;
                o3.d k20 = k0.k.k(aVar7, "KnownChildSensitiveDataConsents", dVar8, 2, 1);
                k20.f8149b = iVar5;
                o3.d k21 = k0.k.k(aVar7, "MspaCoveredTransaction", k20, 2, 0);
                k21.f8149b = iVar4;
                o3.d k22 = k0.k.k(aVar7, "MspaOptOutOptionMode", k21, 2, 0);
                k22.f8149b = iVar4;
                aVar7.b("MspaServiceProviderMode", k22);
                return aVar7;
            case 7:
                r3.a aVar8 = new r3.a();
                List list8 = h.f8870a;
                aVar8.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar8.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar8.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar8;
            case 8:
                o3.i iVar7 = new o3.i(7);
                o3.i iVar8 = new o3.i(8);
                o3.i iVar9 = new o3.i(9);
                r3.a aVar9 = new r3.a();
                List list9 = i.f8872a;
                aVar9.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar9 = new o3.d(2, (Integer) 0);
                dVar9.f8149b = iVar7;
                o3.d k23 = k0.k.k(aVar9, "SharingNotice", dVar9, 2, 0);
                k23.f8149b = iVar7;
                o3.d k24 = k0.k.k(aVar9, "SaleOptOutNotice", k23, 2, 0);
                k24.f8149b = iVar7;
                o3.d k25 = k0.k.k(aVar9, "TargetedAdvertisingOptOutNotice", k24, 2, 0);
                k25.f8149b = iVar7;
                o3.d k26 = k0.k.k(aVar9, "SaleOptOut", k25, 2, 0);
                k26.f8149b = iVar7;
                aVar9.b("TargetedAdvertisingOptOut", k26);
                o3.d dVar10 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar10.f8149b = iVar9;
                aVar9.b("SensitiveDataProcessing", dVar10);
                o3.d dVar11 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar11.f8149b = iVar9;
                aVar9.b("KnownChildSensitiveDataConsents", dVar11);
                o3.d dVar12 = new o3.d(2, (Integer) 1);
                dVar12.f8149b = iVar8;
                o3.d k27 = k0.k.k(aVar9, "MspaCoveredTransaction", dVar12, 2, 0);
                k27.f8149b = iVar7;
                o3.d k28 = k0.k.k(aVar9, "MspaOptOutOptionMode", k27, 2, 0);
                k28.f8149b = iVar7;
                aVar9.b("MspaServiceProviderMode", k28);
                return aVar9;
            case 9:
                r3.a aVar10 = new r3.a();
                List list10 = i.f8872a;
                aVar10.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar10.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar10.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar10;
            case 10:
                o3.i iVar10 = new o3.i(10);
                o3.i iVar11 = new o3.i(11);
                o3.i iVar12 = new o3.i(12);
                r3.a aVar11 = new r3.a();
                List list11 = j.f8874a;
                aVar11.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar13 = new o3.d(2, (Integer) 0);
                dVar13.f8149b = iVar10;
                o3.d k29 = k0.k.k(aVar11, "ProcessingNotice", dVar13, 2, 0);
                k29.f8149b = iVar10;
                o3.d k30 = k0.k.k(aVar11, "SaleOptOutNotice", k29, 2, 0);
                k30.f8149b = iVar10;
                o3.d k31 = k0.k.k(aVar11, "TargetedAdvertisingOptOutNotice", k30, 2, 0);
                k31.f8149b = iVar10;
                o3.d k32 = k0.k.k(aVar11, "SaleOptOut", k31, 2, 0);
                k32.f8149b = iVar10;
                aVar11.b("TargetedAdvertisingOptOut", k32);
                o3.d dVar14 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar14.f8149b = iVar12;
                aVar11.b("SensitiveDataProcessing", dVar14);
                o3.d dVar15 = new o3.d(Arrays.asList(0, 0, 0, 0, 0), 2);
                dVar15.f8149b = iVar12;
                aVar11.b("KnownChildSensitiveDataConsents", dVar15);
                o3.d dVar16 = new o3.d(2, (Integer) 0);
                dVar16.f8149b = iVar10;
                o3.d k33 = k0.k.k(aVar11, "AdditionalDataProcessingConsent", dVar16, 2, 1);
                k33.f8149b = iVar11;
                o3.d k34 = k0.k.k(aVar11, "MspaCoveredTransaction", k33, 2, 0);
                k34.f8149b = iVar10;
                o3.d k35 = k0.k.k(aVar11, "MspaOptOutOptionMode", k34, 2, 0);
                k35.f8149b = iVar10;
                aVar11.b("MspaServiceProviderMode", k35);
                return aVar11;
            case 11:
                r3.a aVar12 = new r3.a();
                List list12 = j.f8874a;
                aVar12.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar12.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar12.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar12;
            case 12:
                o3.i iVar13 = new o3.i(13);
                o3.i iVar14 = new o3.i(14);
                o3.i iVar15 = new o3.i(15);
                r3.a aVar13 = new r3.a();
                List list13 = k.f8876a;
                aVar13.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar17 = new o3.d(2, (Integer) 0);
                dVar17.f8149b = iVar13;
                o3.d k36 = k0.k.k(aVar13, "ProcessingNotice", dVar17, 2, 0);
                k36.f8149b = iVar13;
                o3.d k37 = k0.k.k(aVar13, "SaleOptOutNotice", k36, 2, 0);
                k37.f8149b = iVar13;
                o3.d k38 = k0.k.k(aVar13, "TargetedAdvertisingOptOutNotice", k37, 2, 0);
                k38.f8149b = iVar13;
                o3.d k39 = k0.k.k(aVar13, "SaleOptOut", k38, 2, 0);
                k39.f8149b = iVar13;
                aVar13.b("TargetedAdvertisingOptOut", k39);
                o3.d dVar18 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar18.f8149b = iVar15;
                aVar13.b("SensitiveDataProcessing", dVar18);
                o3.d dVar19 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar19.f8149b = iVar15;
                aVar13.b("KnownChildSensitiveDataConsents", dVar19);
                o3.d dVar20 = new o3.d(2, (Integer) 0);
                dVar20.f8149b = iVar13;
                o3.d k40 = k0.k.k(aVar13, "AdditionalDataProcessingConsent", dVar20, 2, 1);
                k40.f8149b = iVar14;
                o3.d k41 = k0.k.k(aVar13, "MspaCoveredTransaction", k40, 2, 0);
                k41.f8149b = iVar13;
                o3.d k42 = k0.k.k(aVar13, "MspaOptOutOptionMode", k41, 2, 0);
                k42.f8149b = iVar13;
                aVar13.b("MspaServiceProviderMode", k42);
                return aVar13;
            case 13:
                o3.i iVar16 = new o3.i(16);
                o3.i iVar17 = new o3.i(17);
                o3.i iVar18 = new o3.i(18);
                r3.a aVar14 = new r3.a();
                List list14 = r3.l.f8877a;
                aVar14.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar21 = new o3.d(2, (Integer) 0);
                dVar21.f8149b = iVar16;
                o3.d k43 = k0.k.k(aVar14, "ProcessingNotice", dVar21, 2, 0);
                k43.f8149b = iVar16;
                o3.d k44 = k0.k.k(aVar14, "SaleOptOutNotice", k43, 2, 0);
                k44.f8149b = iVar16;
                o3.d k45 = k0.k.k(aVar14, "TargetedAdvertisingOptOutNotice", k44, 2, 0);
                k45.f8149b = iVar16;
                o3.d k46 = k0.k.k(aVar14, "SensitiveDataOptOutNotice", k45, 2, 0);
                k46.f8149b = iVar16;
                o3.d k47 = k0.k.k(aVar14, "SaleOptOut", k46, 2, 0);
                k47.f8149b = iVar16;
                aVar14.b("TargetedAdvertisingOptOut", k47);
                o3.d dVar22 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar22.f8149b = iVar18;
                aVar14.b("SensitiveDataProcessing", dVar22);
                o3.d dVar23 = new o3.d(2, (Integer) 0);
                dVar23.f8149b = iVar16;
                o3.d k48 = k0.k.k(aVar14, "KnownChildSensitiveDataConsents", dVar23, 2, 1);
                k48.f8149b = iVar17;
                o3.d k49 = k0.k.k(aVar14, "MspaCoveredTransaction", k48, 2, 0);
                k49.f8149b = iVar16;
                o3.d k50 = k0.k.k(aVar14, "MspaOptOutOptionMode", k49, 2, 0);
                k50.f8149b = iVar16;
                aVar14.b("MspaServiceProviderMode", k50);
                return aVar14;
            case 14:
                r3.a aVar15 = new r3.a();
                List list15 = r3.l.f8877a;
                aVar15.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar15.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar15.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar15;
            case 15:
                o3.i iVar19 = new o3.i(19);
                o3.i iVar20 = new o3.i(20);
                o3.i iVar21 = new o3.i(21);
                r3.a aVar16 = new r3.a();
                List list16 = m.f8879a;
                aVar16.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar24 = new o3.d(2, (Integer) 0);
                dVar24.f8149b = iVar19;
                o3.d k51 = k0.k.k(aVar16, "ProcessingNotice", dVar24, 2, 0);
                k51.f8149b = iVar19;
                o3.d k52 = k0.k.k(aVar16, "SaleOptOutNotice", k51, 2, 0);
                k52.f8149b = iVar19;
                o3.d k53 = k0.k.k(aVar16, "TargetedAdvertisingOptOutNotice", k52, 2, 0);
                k53.f8149b = iVar19;
                o3.d k54 = k0.k.k(aVar16, "SaleOptOut", k53, 2, 0);
                k54.f8149b = iVar19;
                aVar16.b("TargetedAdvertisingOptOut", k54);
                o3.d dVar25 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar25.f8149b = iVar21;
                aVar16.b("SensitiveDataProcessing", dVar25);
                o3.d dVar26 = new o3.d(2, (Integer) 0);
                dVar26.f8149b = iVar19;
                o3.d k55 = k0.k.k(aVar16, "KnownChildSensitiveDataConsents", dVar26, 2, 0);
                k55.f8149b = iVar19;
                o3.d k56 = k0.k.k(aVar16, "AdditionalDataProcessingConsent", k55, 2, 1);
                k56.f8149b = iVar20;
                o3.d k57 = k0.k.k(aVar16, "MspaCoveredTransaction", k56, 2, 0);
                k57.f8149b = iVar19;
                o3.d k58 = k0.k.k(aVar16, "MspaOptOutOptionMode", k57, 2, 0);
                k58.f8149b = iVar19;
                aVar16.b("MspaServiceProviderMode", k58);
                return aVar16;
            case 16:
                r3.a aVar17 = new r3.a();
                List list17 = m.f8879a;
                aVar17.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar17.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar17.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar17;
            case 17:
                o3.i iVar22 = new o3.i(22);
                o3.i iVar23 = new o3.i(23);
                o3.i iVar24 = new o3.i(24);
                r3.a aVar18 = new r3.a();
                List list18 = n.f8881a;
                aVar18.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar27 = new o3.d(2, (Integer) 0);
                dVar27.f8149b = iVar22;
                o3.d k59 = k0.k.k(aVar18, "SharingNotice", dVar27, 2, 0);
                k59.f8149b = iVar22;
                o3.d k60 = k0.k.k(aVar18, "SaleOptOutNotice", k59, 2, 0);
                k60.f8149b = iVar22;
                o3.d k61 = k0.k.k(aVar18, "TargetedAdvertisingOptOutNotice", k60, 2, 0);
                k61.f8149b = iVar22;
                o3.d k62 = k0.k.k(aVar18, "SaleOptOut", k61, 2, 0);
                k62.f8149b = iVar22;
                aVar18.b("TargetedAdvertisingOptOut", k62);
                o3.d dVar28 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar28.f8149b = iVar24;
                aVar18.b("SensitiveDataProcessing", dVar28);
                o3.d dVar29 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar29.f8149b = iVar24;
                aVar18.b("KnownChildSensitiveDataConsents", dVar29);
                o3.d dVar30 = new o3.d(2, (Integer) 0);
                dVar30.f8149b = iVar22;
                o3.d k63 = k0.k.k(aVar18, "AdditionalDataProcessingConsent", dVar30, 2, 1);
                k63.f8149b = iVar23;
                o3.d k64 = k0.k.k(aVar18, "MspaCoveredTransaction", k63, 2, 0);
                k64.f8149b = iVar22;
                o3.d k65 = k0.k.k(aVar18, "MspaOptOutOptionMode", k64, 2, 0);
                k65.f8149b = iVar22;
                aVar18.b("MspaServiceProviderMode", k65);
                return aVar18;
            case 18:
                r3.a aVar19 = new r3.a();
                List list19 = n.f8881a;
                aVar19.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar19.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar19.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar19;
            case 19:
                o3.i iVar25 = new o3.i(25);
                o3.i iVar26 = new o3.i(26);
                o3.i iVar27 = new o3.i(27);
                r3.a aVar20 = new r3.a();
                List list20 = r3.o.f8883a;
                aVar20.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar31 = new o3.d(2, (Integer) 0);
                dVar31.f8149b = iVar25;
                o3.d k66 = k0.k.k(aVar20, "SharingNotice", dVar31, 2, 0);
                k66.f8149b = iVar25;
                o3.d k67 = k0.k.k(aVar20, "SaleOptOutNotice", k66, 2, 0);
                k67.f8149b = iVar25;
                o3.d k68 = k0.k.k(aVar20, "SharingOptOutNotice", k67, 2, 0);
                k68.f8149b = iVar25;
                o3.d k69 = k0.k.k(aVar20, "TargetedAdvertisingOptOutNotice", k68, 2, 0);
                k69.f8149b = iVar25;
                o3.d k70 = k0.k.k(aVar20, "SensitiveDataProcessingOptOutNotice", k69, 2, 0);
                k70.f8149b = iVar25;
                o3.d k71 = k0.k.k(aVar20, "SensitiveDataLimitUseNotice", k70, 2, 0);
                k71.f8149b = iVar25;
                o3.d k72 = k0.k.k(aVar20, "SaleOptOut", k71, 2, 0);
                k72.f8149b = iVar25;
                o3.d k73 = k0.k.k(aVar20, "SharingOptOut", k72, 2, 0);
                k73.f8149b = iVar25;
                aVar20.b("TargetedAdvertisingOptOut", k73);
                o3.d dVar32 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar32.f8149b = iVar27;
                aVar20.b("SensitiveDataProcessing", dVar32);
                o3.d dVar33 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar33.f8149b = iVar27;
                aVar20.b("KnownChildSensitiveDataConsents", dVar33);
                o3.d dVar34 = new o3.d(2, (Integer) 0);
                dVar34.f8149b = iVar25;
                o3.d k74 = k0.k.k(aVar20, "PersonalDataConsents", dVar34, 2, 1);
                k74.f8149b = iVar26;
                o3.d k75 = k0.k.k(aVar20, "MspaCoveredTransaction", k74, 2, 0);
                k75.f8149b = iVar25;
                o3.d k76 = k0.k.k(aVar20, "MspaOptOutOptionMode", k75, 2, 0);
                k76.f8149b = iVar25;
                aVar20.b("MspaServiceProviderMode", k76);
                return aVar20;
            case 20:
                r3.a aVar21 = new r3.a();
                List list21 = r3.o.f8883a;
                aVar21.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar21.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar21.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar21;
            case 21:
                o3.i iVar28 = new o3.i(28);
                o3.i iVar29 = new o3.i(29);
                e eVar = new e(0);
                r3.a aVar22 = new r3.a();
                List list22 = p.f8885a;
                aVar22.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar35 = new o3.d(2, (Integer) 0);
                dVar35.f8149b = iVar28;
                o3.d k77 = k0.k.k(aVar22, "ProcessingNotice", dVar35, 2, 0);
                k77.f8149b = iVar28;
                o3.d k78 = k0.k.k(aVar22, "SaleOptOutNotice", k77, 2, 0);
                k78.f8149b = iVar28;
                o3.d k79 = k0.k.k(aVar22, "TargetedAdvertisingOptOutNotice", k78, 2, 0);
                k79.f8149b = iVar28;
                o3.d k80 = k0.k.k(aVar22, "SaleOptOut", k79, 2, 0);
                k80.f8149b = iVar28;
                aVar22.b("TargetedAdvertisingOptOut", k80);
                o3.d dVar36 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar36.f8149b = eVar;
                aVar22.b("SensitiveDataProcessing", dVar36);
                o3.d dVar37 = new o3.d(2, (Integer) 0);
                dVar37.f8149b = iVar28;
                o3.d k81 = k0.k.k(aVar22, "KnownChildSensitiveDataConsents", dVar37, 2, 0);
                k81.f8149b = iVar28;
                o3.d k82 = k0.k.k(aVar22, "AdditionalDataProcessingConsent", k81, 2, 1);
                k82.f8149b = iVar29;
                o3.d k83 = k0.k.k(aVar22, "MspaCoveredTransaction", k82, 2, 0);
                k83.f8149b = iVar28;
                o3.d k84 = k0.k.k(aVar22, "MspaOptOutOptionMode", k83, 2, 0);
                k84.f8149b = iVar28;
                aVar22.b("MspaServiceProviderMode", k84);
                return aVar22;
            case 22:
                r3.a aVar23 = new r3.a();
                List list23 = p.f8885a;
                aVar23.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar23.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar23.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar23;
            case 23:
                e eVar2 = new e(1);
                e eVar3 = new e(2);
                e eVar4 = new e(3);
                r3.a aVar24 = new r3.a();
                List list24 = q.f8887a;
                aVar24.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar38 = new o3.d(2, (Integer) 0);
                dVar38.f8149b = eVar2;
                o3.d k85 = k0.k.k(aVar24, "ProcessingNotice", dVar38, 2, 0);
                k85.f8149b = eVar2;
                o3.d k86 = k0.k.k(aVar24, "SaleOptOutNotice", k85, 2, 0);
                k86.f8149b = eVar2;
                o3.d k87 = k0.k.k(aVar24, "TargetedAdvertisingOptOutNotice", k86, 2, 0);
                k87.f8149b = eVar2;
                o3.d k88 = k0.k.k(aVar24, "SaleOptOut", k87, 2, 0);
                k88.f8149b = eVar2;
                aVar24.b("TargetedAdvertisingOptOut", k88);
                o3.d dVar39 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar39.f8149b = eVar4;
                aVar24.b("SensitiveDataProcessing", dVar39);
                o3.d dVar40 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar40.f8149b = eVar4;
                aVar24.b("KnownChildSensitiveDataConsents", dVar40);
                o3.d dVar41 = new o3.d(2, (Integer) 0);
                dVar41.f8149b = eVar2;
                o3.d k89 = k0.k.k(aVar24, "AdditionalDataProcessingConsent", dVar41, 2, 1);
                k89.f8149b = eVar3;
                o3.d k90 = k0.k.k(aVar24, "MspaCoveredTransaction", k89, 2, 0);
                k90.f8149b = eVar2;
                o3.d k91 = k0.k.k(aVar24, "MspaOptOutOptionMode", k90, 2, 0);
                k91.f8149b = eVar2;
                aVar24.b("MspaServiceProviderMode", k91);
                return aVar24;
            case 24:
                r3.a aVar25 = new r3.a();
                List list25 = q.f8887a;
                aVar25.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar25.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar25.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar25;
            case 25:
                e eVar5 = new e(4);
                e eVar6 = new e(5);
                e eVar7 = new e(6);
                r3.a aVar26 = new r3.a();
                List list26 = r.f8889a;
                aVar26.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar42 = new o3.d(2, (Integer) 0);
                dVar42.f8149b = eVar5;
                o3.d k92 = k0.k.k(aVar26, "ProcessingNotice", dVar42, 2, 0);
                k92.f8149b = eVar5;
                o3.d k93 = k0.k.k(aVar26, "SaleOptOutNotice", k92, 2, 0);
                k93.f8149b = eVar5;
                o3.d k94 = k0.k.k(aVar26, "TargetedAdvertisingOptOutNotice", k93, 2, 0);
                k94.f8149b = eVar5;
                o3.d k95 = k0.k.k(aVar26, "SaleOptOut", k94, 2, 0);
                k95.f8149b = eVar5;
                aVar26.b("TargetedAdvertisingOptOut", k95);
                o3.d dVar43 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar43.f8149b = eVar7;
                aVar26.b("SensitiveDataProcessing", dVar43);
                o3.d dVar44 = new o3.d(Arrays.asList(0, 0, 0, 0, 0), 2);
                dVar44.f8149b = eVar7;
                aVar26.b("KnownChildSensitiveDataConsents", dVar44);
                o3.d dVar45 = new o3.d(2, (Integer) 0);
                dVar45.f8149b = eVar5;
                o3.d k96 = k0.k.k(aVar26, "AdditionalDataProcessingConsent", dVar45, 2, 1);
                k96.f8149b = eVar6;
                o3.d k97 = k0.k.k(aVar26, "MspaCoveredTransaction", k96, 2, 0);
                k97.f8149b = eVar5;
                o3.d k98 = k0.k.k(aVar26, "MspaOptOutOptionMode", k97, 2, 0);
                k98.f8149b = eVar5;
                aVar26.b("MspaServiceProviderMode", k98);
                return aVar26;
            case 26:
                r3.a aVar27 = new r3.a();
                List list27 = r.f8889a;
                aVar27.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar27.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar27.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar27;
            case 27:
                e eVar8 = new e(7);
                e eVar9 = new e(8);
                e eVar10 = new e(9);
                r3.a aVar28 = new r3.a();
                List list28 = s.f8891a;
                aVar28.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar46 = new o3.d(2, (Integer) 0);
                dVar46.f8149b = eVar8;
                o3.d k99 = k0.k.k(aVar28, "ProcessingNotice", dVar46, 2, 0);
                k99.f8149b = eVar8;
                o3.d k100 = k0.k.k(aVar28, "SaleOptOutNotice", k99, 2, 0);
                k100.f8149b = eVar8;
                o3.d k101 = k0.k.k(aVar28, "TargetedAdvertisingOptOutNotice", k100, 2, 0);
                k101.f8149b = eVar8;
                o3.d k102 = k0.k.k(aVar28, "SaleOptOut", k101, 2, 0);
                k102.f8149b = eVar8;
                aVar28.b("TargetedAdvertisingOptOut", k102);
                o3.d dVar47 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar47.f8149b = eVar10;
                aVar28.b("SensitiveDataProcessing", dVar47);
                o3.d dVar48 = new o3.d(Arrays.asList(0, 0, 0), 2);
                dVar48.f8149b = eVar10;
                aVar28.b("KnownChildSensitiveDataConsents", dVar48);
                o3.d dVar49 = new o3.d(2, (Integer) 0);
                dVar49.f8149b = eVar8;
                o3.d k103 = k0.k.k(aVar28, "AdditionalDataProcessingConsent", dVar49, 2, 1);
                k103.f8149b = eVar9;
                o3.d k104 = k0.k.k(aVar28, "MspaCoveredTransaction", k103, 2, 0);
                k104.f8149b = eVar8;
                o3.d k105 = k0.k.k(aVar28, "MspaOptOutOptionMode", k104, 2, 0);
                k105.f8149b = eVar8;
                aVar28.b("MspaServiceProviderMode", k105);
                return aVar28;
            case 28:
                r3.a aVar29 = new r3.a();
                List list29 = s.f8891a;
                aVar29.b("GpcSegmentType", new o3.d(2, (Integer) 1));
                aVar29.b("GpcSegmentIncluded", new o3.c(Boolean.TRUE));
                aVar29.b("Gpc", new o3.c(Boolean.FALSE));
                return aVar29;
            default:
                e eVar11 = new e(10);
                e eVar12 = new e(11);
                e eVar13 = new e(12);
                r3.a aVar30 = new r3.a();
                List list30 = t.f8893a;
                aVar30.b("Version", new o3.d(6, (Integer) 1));
                o3.d dVar50 = new o3.d(2, (Integer) 0);
                dVar50.f8149b = eVar11;
                o3.d k106 = k0.k.k(aVar30, "ProcessingNotice", dVar50, 2, 0);
                k106.f8149b = eVar11;
                o3.d k107 = k0.k.k(aVar30, "SaleOptOutNotice", k106, 2, 0);
                k107.f8149b = eVar11;
                o3.d k108 = k0.k.k(aVar30, "TargetedAdvertisingOptOutNotice", k107, 2, 0);
                k108.f8149b = eVar11;
                o3.d k109 = k0.k.k(aVar30, "SaleOptOut", k108, 2, 0);
                k109.f8149b = eVar11;
                aVar30.b("TargetedAdvertisingOptOut", k109);
                o3.d dVar51 = new o3.d(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0), 2);
                dVar51.f8149b = eVar13;
                aVar30.b("SensitiveDataProcessing", dVar51);
                o3.d dVar52 = new o3.d(2, (Integer) 0);
                dVar52.f8149b = eVar11;
                o3.d k110 = k0.k.k(aVar30, "KnownChildSensitiveDataConsents", dVar52, 2, 0);
                k110.f8149b = eVar11;
                o3.d k111 = k0.k.k(aVar30, "AdditionalDataProcessingConsent", k110, 2, 1);
                k111.f8149b = eVar12;
                o3.d k112 = k0.k.k(aVar30, "MspaCoveredTransaction", k111, 2, 0);
                k112.f8149b = eVar11;
                o3.d k113 = k0.k.k(aVar30, "MspaOptOutOptionMode", k112, 2, 0);
                k113.f8149b = eVar11;
                aVar30.b("MspaServiceProviderMode", k113);
                return aVar30;
        }
    }
}
