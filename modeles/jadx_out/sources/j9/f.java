package j9;

import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Locale f6755a;

    /* renamed from: b, reason: collision with root package name */
    public final i9.b f6756b;

    /* renamed from: c, reason: collision with root package name */
    public final l9.a f6757c;

    /* renamed from: d, reason: collision with root package name */
    public final i9.i f6758d;

    /* renamed from: e, reason: collision with root package name */
    public final g5.g f6759e;
    public h9.t f;
    public l8.r g;
    public l8.j h;

    public f(Locale locale, i9.b bVar, l9.a aVar, i9.i iVar, g5.g gVar) {
        bVar.getClass();
        aVar.getClass();
        iVar.getClass();
        this.f6755a = locale;
        this.f6756b = bVar;
        this.f6757c = aVar;
        this.f6758d = iVar;
        this.f6759e = gVar;
        this.g = new l8.r(false, null, null, null, null, null, null, null, null, 1023);
        this.h = new l8.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(v6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof j9.b
            if (r0 == 0) goto L13
            r0 = r5
            j9.b r0 = (j9.b) r0
            int r1 = r0.f6742m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6742m = r1
            goto L18
        L13:
            j9.b r0 = new j9.b
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f6740b
            int r1 = r0.f6742m
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            j9.f r0 = r0.f6739a
            p6.a.e(r5)     // Catch: r5.a -> L52
            goto L4e
        L27:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L2e:
            p6.a.e(r5)
            l9.a r5 = r4.f6757c     // Catch: r5.a -> L51
            java.lang.String r1 = "en"
            r3 = 33
            r5.f(r3, r1)     // Catch: r5.a -> L51
            i9.i r5 = r4.f6758d     // Catch: r5.a -> L51
            java.lang.String r1 = r4.h()     // Catch: r5.a -> L51
            r0.f6739a = r4     // Catch: r5.a -> L51
            r0.f6742m = r2     // Catch: r5.a -> L51
            java.lang.Object r5 = r5.b(r1, r0)     // Catch: r5.a -> L51
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L4d
            return r0
        L4d:
            r0 = r4
        L4e:
            java.lang.String r5 = (java.lang.String) r5     // Catch: r5.a -> L52
            return r5
        L51:
            r0 = r4
        L52:
            l9.a r5 = r0.f6757c
            r0 = 28
            java.lang.String r5 = r5.j(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.f.a(v6.c):java.lang.Object");
    }

    public final String b() {
        h9.t tVar = this.f;
        if (tVar != null) {
            return tVar.f5606a.f5528w;
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Iterable, java.lang.Object] */
    public final h9.i c() {
        h9.q qVar;
        h9.q qVar2;
        i();
        h9.t tVar = this.f;
        if (tVar == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String str = tVar.f5606a.f5512a;
        String x02 = q6.l.x0(tVar.f5608c.f5558p, " ", null, null, null, 62);
        h9.t tVar2 = this.f;
        if (tVar2 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        h9.g gVar = tVar2.f5606a;
        String str2 = gVar.f5516e;
        String str3 = gVar.f5513b;
        String str4 = this.h.f7216b;
        if (str4.length() == 0) {
            h9.t tVar3 = this.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar3.f5606a.f5515d;
        }
        String str5 = str4;
        h9.t tVar4 = this.f;
        if (tVar4 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String str6 = tVar4.f5606a.f5523q;
        String str7 = "";
        if (this.h.f7217c.isEmpty()) {
            h9.t tVar5 = this.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            ArrayList arrayList = tVar5.f5607b.j;
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            if (arrayList != null && (qVar2 = (h9.q) q6.l.q0(arrayList)) != null) {
                str7 = qVar2.f5597b;
            }
        } else {
            ArrayList arrayList2 = this.h.f7217c;
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 != null && (qVar = (h9.q) q6.l.q0(arrayList2)) != null) {
                str7 = qVar.f5597b;
            }
        }
        String str8 = str7;
        h9.t tVar6 = this.f;
        if (tVar6 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String str9 = tVar6.f5606a.E;
        h9.e eVar = tVar6.f5609d;
        h9.e eVar2 = new h9.e(eVar.f5506a, eVar.f5507b, eVar.f5508c, eVar.f5509d, eVar.f, eVar.g, 16);
        h9.t tVar7 = this.f;
        if (tVar7 != null) {
            h9.a aVar = tVar7.f5610e;
            return new h9.i(str, x02, str2, str3, str5, str6, str8, str9, eVar2, new h9.a(aVar.f5483a, aVar.f5484b, aVar.f5485c, aVar.f5486d, aVar.f, 16));
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(v6.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof j9.d
            if (r0 == 0) goto L13
            r0 = r8
            j9.d r0 = (j9.d) r0
            int r1 = r0.f6750m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6750m = r1
            goto L18
        L13:
            j9.d r0 = new j9.d
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f6748b
            int r1 = r0.f6750m
            r2 = 2
            r3 = 28
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L3d
            if (r1 == r4) goto L35
            if (r1 != r2) goto L2e
            j9.f r0 = r0.f6747a
            p6.a.e(r8)
            goto L8e
        L2e:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            r8 = 0
            return r8
        L35:
            j9.f r1 = r0.f6747a
            p6.a.e(r8)     // Catch: r5.a -> L3b
            goto L5a
        L3b:
            r8 = move-exception
            goto L76
        L3d:
            p6.a.e(r8)
            i9.b r8 = r7.f6756b     // Catch: r5.a -> L5d
            boolean r8 = r8.a()     // Catch: r5.a -> L5d
            if (r8 == 0) goto L60
            i9.i r8 = r7.f6758d     // Catch: r5.a -> L5d
            java.lang.String r1 = r7.h()     // Catch: r5.a -> L5d
            r0.f6747a = r7     // Catch: r5.a -> L5d
            r0.f6750m = r4     // Catch: r5.a -> L5d
            java.lang.Object r8 = r8.b(r1, r0)     // Catch: r5.a -> L5d
            if (r8 != r5) goto L59
            goto L8c
        L59:
            r1 = r7
        L5a:
            java.lang.String r8 = (java.lang.String) r8     // Catch: r5.a -> L3b
            goto L98
        L5d:
            r8 = move-exception
            r1 = r7
            goto L76
        L60:
            com.inmobi.cmp.ChoiceCmp r8 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: r5.a -> L5d
            com.inmobi.cmp.ChoiceCmpCallback r8 = r8.getCallback()     // Catch: r5.a -> L5d
            if (r8 != 0) goto L69
            goto L6e
        L69:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L5d
            r8.onCmpError(r1)     // Catch: r5.a -> L5d
        L6e:
            l9.a r8 = r7.f6757c     // Catch: r5.a -> L5d
            java.lang.String r8 = r8.j(r3)     // Catch: r5.a -> L5d
            r1 = r7
            goto L98
        L76:
            int[] r6 = j9.a.f6738a
            com.inmobi.cmp.model.ChoiceError r8 = r8.f8908a
            int r8 = r8.ordinal()
            r8 = r6[r8]
            if (r8 != r4) goto L92
            r0.f6747a = r1
            r0.f6750m = r2
            java.lang.Object r8 = r1.a(r0)
            if (r8 != r5) goto L8d
        L8c:
            return r5
        L8d:
            r0 = r1
        L8e:
            java.lang.String r8 = (java.lang.String) r8
            r1 = r0
            goto L98
        L92:
            l9.a r8 = r1.f6757c
            java.lang.String r8 = r8.j(r3)
        L98:
            l9.a r0 = r1.f6757c
            r0.f(r3, r8)
            g5.g r0 = r1.f6759e
            java.lang.Object r8 = r0.l(r8)
            h9.t r8 = (h9.t) r8
            r1.f = r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.f.d(v6.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Iterable, java.lang.Object] */
    public final h9.l e() {
        i();
        h9.t tVar = this.f;
        if (tVar == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String str = tVar.f5606a.f5512a;
        String x02 = q6.l.x0(tVar.f5608c.f5558p, " ", null, null, null, 62);
        h9.t tVar2 = this.f;
        if (tVar2 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        h9.g gVar = tVar2.f5606a;
        String str2 = gVar.f5524r;
        String str3 = gVar.Q;
        h9.k kVar = tVar2.f5608c;
        String str4 = kVar.f;
        String str5 = gVar.f5521o;
        String str6 = gVar.f5514c;
        String str7 = gVar.f5522p;
        String str8 = gVar.A;
        String str9 = gVar.f5523q;
        String str10 = kVar.i;
        String str11 = kVar.j;
        String str12 = kVar.f5553k;
        String str13 = kVar.f5554l;
        String b7 = b();
        h9.t tVar3 = this.f;
        if (tVar3 != null) {
            return new h9.l(str, x02, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, b7, tVar3.f5606a.B, tVar3.f5609d, tVar3.f5610e);
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    public final h9.n f() {
        i();
        h9.t tVar = this.f;
        if (tVar == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        h9.k kVar = tVar.f5608c;
        String str = kVar.f;
        h9.g gVar = tVar.f5606a;
        return new h9.n(str, gVar.D, kVar.f5549b, gVar.f5523q, kVar.f5551d, kVar.f5552e, b());
    }

    public final h9.m g() {
        i();
        h9.t tVar = this.f;
        if (tVar == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        h9.g gVar = tVar.f5606a;
        String str = gVar.Q;
        String str2 = gVar.f5524r;
        Locale locale = this.f6755a;
        String upperCase = str2.toUpperCase(locale);
        upperCase.getClass();
        h9.t tVar2 = this.f;
        if (tVar2 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String upperCase2 = tVar2.f5606a.f5525s.toUpperCase(locale);
        upperCase2.getClass();
        h9.t tVar3 = this.f;
        if (tVar3 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        h9.g gVar2 = tVar3.f5606a;
        String str3 = gVar2.f5527u;
        String str4 = gVar2.f5526t;
        String str5 = gVar2.v;
        String str6 = gVar2.E;
        String str7 = gVar2.R;
        String str8 = gVar2.S;
        String str9 = gVar2.T;
        String str10 = gVar2.U;
        String str11 = gVar2.V;
        String str12 = gVar2.W;
        String str13 = gVar2.X;
        String b7 = b();
        h9.t tVar4 = this.f;
        if (tVar4 != null) {
            h9.g gVar3 = tVar4.f5606a;
            return new h9.m(str, upperCase, upperCase2, str3, str4, str5, str6, str7, str8, str9, str13, str10, str11, str12, b7, gVar3.Y, gVar3.Z);
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    public final String h() {
        String o02;
        String str = (d0.b.C() || d0.b.s()) ? m9.c.e().f7239n.f7214w.f7256c : m9.c.e().f7239n.f7214w.f7254a;
        String p10 = d0.b.p();
        Locale locale = this.f6755a;
        if (str == null) {
            o02 = null;
        } else {
            String lowerCase = p10.toLowerCase(locale);
            lowerCase.getClass();
            o02 = l7.u.o0(str, "${language}", lowerCase, false);
        }
        if (o02 != null) {
            return o02;
        }
        StringBuilder sb = new StringBuilder("https://cmp.inmobi.com/tcfv2/translations/");
        String lowerCase2 = p10.toLowerCase(locale);
        lowerCase2.getClass();
        sb.append(lowerCase2);
        sb.append(".json");
        return sb.toString();
    }

    public final void i() {
        if (this.f == null) {
            String j = this.f6757c.j(28);
            this.f = j.length() > 0 ? (h9.t) this.f6759e.l(j) : new h9.t();
        }
    }
}
