package c2;

import android.util.Base64;
import android.util.JsonReader;
import b2.a0;
import b2.a2;
import b2.b0;
import b2.b1;
import b2.b2;
import b2.c0;
import b2.c1;
import b2.c2;
import b2.d0;
import b2.d2;
import b2.e;
import b2.e0;
import b2.e1;
import b2.e2;
import b2.f0;
import b2.f1;
import b2.f2;
import b2.g;
import b2.g0;
import b2.g1;
import b2.g2;
import b2.h;
import b2.h0;
import b2.h1;
import b2.h2;
import b2.i;
import b2.i0;
import b2.i1;
import b2.i2;
import b2.j;
import b2.j0;
import b2.j1;
import b2.j2;
import b2.k;
import b2.k0;
import b2.k2;
import b2.l;
import b2.l0;
import b2.l2;
import b2.m;
import b2.m0;
import b2.m2;
import b2.n;
import b2.n0;
import b2.n2;
import b2.o;
import b2.o1;
import b2.p;
import b2.p0;
import b2.p1;
import b2.q;
import b2.q0;
import b2.q1;
import b2.r;
import b2.r0;
import b2.r1;
import b2.s;
import b2.s0;
import b2.s1;
import b2.t;
import b2.t0;
import b2.t1;
import b2.u;
import b2.u0;
import b2.u1;
import b2.v;
import b2.v0;
import b2.v1;
import b2.w;
import b2.w0;
import b2.w1;
import b2.x;
import b2.x0;
import b2.x1;
import b2.y;
import b2.y0;
import b2.y1;
import b2.z;
import b2.z0;
import b2.z1;
import g5.f;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import n2.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1184a;

    static {
        d dVar = new d();
        b2.d dVar2 = b2.d.f754a;
        dVar.a(n2.class, dVar2);
        dVar.a(b0.class, dVar2);
        j jVar = j.f822a;
        dVar.a(m2.class, jVar);
        dVar.a(j0.class, jVar);
        g gVar = g.f789a;
        dVar.a(u1.class, gVar);
        dVar.a(k0.class, gVar);
        h hVar = h.f797a;
        dVar.a(t1.class, hVar);
        dVar.a(l0.class, hVar);
        z zVar = z.f986a;
        dVar.a(l2.class, zVar);
        dVar.a(j1.class, zVar);
        y yVar = y.f976a;
        dVar.a(k2.class, yVar);
        dVar.a(i1.class, yVar);
        i iVar = i.f805a;
        dVar.a(v1.class, iVar);
        dVar.a(n0.class, iVar);
        t tVar = t.f935a;
        dVar.a(j2.class, tVar);
        dVar.a(p0.class, tVar);
        k kVar = k.f838a;
        dVar.a(d2.class, kVar);
        dVar.a(q0.class, kVar);
        m mVar = m.f861a;
        dVar.a(b2.class, mVar);
        dVar.a(r0.class, mVar);
        p pVar = p.f897a;
        dVar.a(a2.class, pVar);
        dVar.a(v0.class, pVar);
        q qVar = q.f906a;
        dVar.a(z1.class, qVar);
        dVar.a(x0.class, qVar);
        n nVar = n.f876a;
        dVar.a(x1.class, nVar);
        dVar.a(t0.class, nVar);
        b2.b bVar = b2.b.f728a;
        dVar.a(p1.class, bVar);
        dVar.a(d0.class, bVar);
        b2.a aVar = b2.a.f711a;
        dVar.a(o1.class, aVar);
        dVar.a(e0.class, aVar);
        o oVar = o.f888a;
        dVar.a(y1.class, oVar);
        dVar.a(u0.class, oVar);
        l lVar = l.f851a;
        dVar.a(w1.class, lVar);
        dVar.a(s0.class, lVar);
        b2.c cVar = b2.c.f745a;
        dVar.a(q1.class, cVar);
        dVar.a(f0.class, cVar);
        r rVar = r.f916a;
        dVar.a(c2.class, rVar);
        dVar.a(z0.class, rVar);
        s sVar = s.f926a;
        dVar.a(e2.class, sVar);
        dVar.a(b1.class, sVar);
        u uVar = u.f948a;
        dVar.a(f2.class, uVar);
        dVar.a(c1.class, uVar);
        x xVar = x.f969a;
        dVar.a(i2.class, xVar);
        dVar.a(g1.class, xVar);
        v vVar = v.f953a;
        dVar.a(h2.class, vVar);
        dVar.a(e1.class, vVar);
        w wVar = w.f961a;
        dVar.a(g2.class, wVar);
        dVar.a(f1.class, wVar);
        e eVar = e.f772a;
        dVar.a(s1.class, eVar);
        dVar.a(g0.class, eVar);
        b2.f fVar = b2.f.f782a;
        dVar.a(r1.class, fVar);
        dVar.a(h0.class, fVar);
        dVar.f7930d = true;
        f1184a = new f(dVar, 10);
    }

    public static x0 a(JsonReader jsonReader) {
        w0 w0Var = new w0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "offset":
                    w0Var.f967d = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 2);
                    break;
                case "symbol":
                    String nextString = jsonReader.nextString();
                    if (nextString == null) {
                        com.google.gson.internal.a.i("Null symbol");
                        return null;
                    }
                    w0Var.f965b = nextString;
                    break;
                case "pc":
                    w0Var.f964a = jsonReader.nextLong();
                    w0Var.f = (byte) (w0Var.f | 1);
                    break;
                case "file":
                    w0Var.f966c = jsonReader.nextString();
                    break;
                case "importance":
                    w0Var.f968e = jsonReader.nextInt();
                    w0Var.f = (byte) (w0Var.f | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return w0Var.a();
    }

    public static f0 b(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("key")) {
                str = jsonReader.nextString();
                if (str == null) {
                    com.google.gson.internal.a.i("Null key");
                    return null;
                }
            } else if (nextName.equals("value")) {
                str2 = jsonReader.nextString();
                if (str2 == null) {
                    com.google.gson.internal.a.i("Null value");
                    return null;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (str != null && str2 != null) {
            return new f0(str, str2);
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            sb.append(" key");
        }
        if (str2 == null) {
            sb.append(" value");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }

    public static d0 c(JsonReader jsonReader) {
        c0 c0Var = new c0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "buildIdMappingForArch":
                    c0Var.i = d(jsonReader, new androidx.privacysandbox.ads.adservices.customaudience.a(28));
                    break;
                case "pid":
                    c0Var.f748a = jsonReader.nextInt();
                    c0Var.j = (byte) (c0Var.j | 1);
                    break;
                case "pss":
                    c0Var.f752e = jsonReader.nextLong();
                    c0Var.j = (byte) (c0Var.j | 8);
                    break;
                case "rss":
                    c0Var.f = jsonReader.nextLong();
                    c0Var.j = (byte) (c0Var.j | 16);
                    break;
                case "timestamp":
                    c0Var.g = jsonReader.nextLong();
                    c0Var.j = (byte) (c0Var.j | 32);
                    break;
                case "processName":
                    String nextString = jsonReader.nextString();
                    if (nextString == null) {
                        com.google.gson.internal.a.i("Null processName");
                        return null;
                    }
                    c0Var.f749b = nextString;
                    break;
                case "reasonCode":
                    c0Var.f750c = jsonReader.nextInt();
                    c0Var.j = (byte) (c0Var.j | 2);
                    break;
                case "traceFile":
                    c0Var.h = jsonReader.nextString();
                    break;
                case "importance":
                    c0Var.f751d = jsonReader.nextInt();
                    c0Var.j = (byte) (c0Var.j | 4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return c0Var.a();
    }

    public static List d(JsonReader jsonReader, b bVar) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(bVar.a(jsonReader));
        }
        jsonReader.endArray();
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x028f, code lost:
    
        if (r5 != null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0291, code lost:
    
        r0.append(" name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0296, code lost:
    
        if (r6 != null) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0298, code lost:
    
        r0.append(" code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x029f, code lost:
    
        if ((r4 & 1) != 0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a1, code lost:
    
        r0.append(" address");
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a6, code lost:
    
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02dc, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02e1, code lost:
    
        if (r25 != 0) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02e3, code lost:
    
        r0.append(" signal");
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02e8, code lost:
    
        if (r26 != null) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02ea, code lost:
    
        r0.append(" binaries");
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02ef, code lost:
    
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v1, types: [b2.p0] */
    /* JADX WARN: Type inference failed for: r23v1, types: [b2.t0] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [b2.p1] */
    /* JADX WARN: Type inference failed for: r24v2, types: [b2.d0] */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r25v1, types: [b2.u0] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b2.p0 e(android.util.JsonReader r29) {
        /*
            Method dump skipped, instructions count: 1328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.c.e(android.util.JsonReader):b2.p0");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x004b, code lost:
    
        if (r3.equals("reason") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b2.t0 f(android.util.JsonReader r13) {
        /*
            r13.beginObject()
            r0 = 0
            r1 = 0
            r2 = r0
            r8 = r2
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
        Lb:
            boolean r3 = r13.hasNext()
            r9 = 1
            if (r3 == 0) goto L90
            java.lang.String r3 = r13.nextName()
            r3.getClass()
            int r10 = r3.hashCode()
            r11 = 3
            r12 = -1
            switch(r10) {
                case -1266514778: goto L4e;
                case -934964668: goto L45;
                case 3575610: goto L3a;
                case 91997906: goto L2f;
                case 581754413: goto L24;
                default: goto L22;
            }
        L22:
            r9 = r12
            goto L58
        L24:
            java.lang.String r9 = "overflowCount"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L2d
            goto L22
        L2d:
            r9 = 4
            goto L58
        L2f:
            java.lang.String r9 = "causedBy"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L38
            goto L22
        L38:
            r9 = r11
            goto L58
        L3a:
            java.lang.String r9 = "type"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L43
            goto L22
        L43:
            r9 = 2
            goto L58
        L45:
            java.lang.String r10 = "reason"
            boolean r3 = r3.equals(r10)
            if (r3 != 0) goto L58
            goto L22
        L4e:
            java.lang.String r9 = "frames"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L57
            goto L22
        L57:
            r9 = r0
        L58:
            switch(r9) {
                case 0: goto L7e;
                case 1: goto L79;
                case 2: goto L6c;
                case 3: goto L67;
                case 4: goto L5f;
                default: goto L5b;
            }
        L5b:
            r13.skipValue()
            goto Lb
        L5f:
            int r8 = r13.nextInt()
            r2 = r2 | 1
            byte r2 = (byte) r2
            goto Lb
        L67:
            b2.t0 r7 = f(r13)
            goto Lb
        L6c:
            java.lang.String r4 = r13.nextString()
            if (r4 == 0) goto L73
            goto Lb
        L73:
            java.lang.String r13 = "Null type"
            com.google.gson.internal.a.i(r13)
            return r1
        L79:
            java.lang.String r5 = r13.nextString()
            goto Lb
        L7e:
            c2.a r3 = new c2.a
            r3.<init>(r11)
            java.util.List r6 = d(r13, r3)
            if (r6 == 0) goto L8a
            goto Lb
        L8a:
            java.lang.String r13 = "Null frames"
            com.google.gson.internal.a.i(r13)
            return r1
        L90:
            r13.endObject()
            if (r2 != r9) goto La0
            if (r4 == 0) goto La0
            if (r6 != 0) goto L9a
            goto La0
        L9a:
            b2.t0 r3 = new b2.t0
            r3.<init>(r4, r5, r6, r7, r8)
            return r3
        La0:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            if (r4 != 0) goto Lac
            java.lang.String r0 = " type"
            r13.append(r0)
        Lac:
            if (r6 != 0) goto Lb3
            java.lang.String r0 = " frames"
            r13.append(r0)
        Lb3:
            r0 = r2 & 1
            if (r0 != 0) goto Lbc
            java.lang.String r0 = " overflowCount"
            r13.append(r0)
        Lbc:
            java.lang.String r0 = "Missing required properties:"
            java.lang.String r13 = k0.k.h(r0, r13)
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.c.f(android.util.JsonReader):b2.t0");
    }

    public static z0 g(JsonReader jsonReader) {
        y0 y0Var = new y0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "pid":
                    y0Var.f982b = jsonReader.nextInt();
                    y0Var.f985e = (byte) (y0Var.f985e | 1);
                    break;
                case "processName":
                    String nextString = jsonReader.nextString();
                    if (nextString == null) {
                        com.google.gson.internal.a.i("Null processName");
                        return null;
                    }
                    y0Var.f981a = nextString;
                    break;
                case "defaultProcess":
                    y0Var.f984d = jsonReader.nextBoolean();
                    y0Var.f985e = (byte) (y0Var.f985e | 4);
                    break;
                case "importance":
                    y0Var.f983c = jsonReader.nextInt();
                    y0Var.f985e = (byte) (y0Var.f985e | 2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return y0Var.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b0 h(JsonReader jsonReader) {
        char c9;
        char c10;
        char c11;
        boolean z9;
        boolean z10;
        Charset charset = n2.f887a;
        a0 a0Var = new a0();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c9 = 0;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c9 = 1;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c9 = 2;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c9 = 3;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c9 = 4;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -401988390:
                    if (nextName.equals("firebaseAuthenticationToken")) {
                        c9 = 5;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c9 = 6;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c9 = 7;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c9 = '\b';
                        break;
                    }
                    c9 = 65535;
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c9 = '\t';
                        break;
                    }
                    c9 = 65535;
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c9 = '\n';
                        break;
                    }
                    c9 = 65535;
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c9 = 11;
                        break;
                    }
                    c9 = 65535;
                    break;
                default:
                    c9 = 65535;
                    break;
            }
            switch (c9) {
                case 0:
                    jsonReader.beginObject();
                    List list = null;
                    String str = null;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (nextName2.equals("files")) {
                            list = d(jsonReader, new androidx.privacysandbox.ads.adservices.customaudience.a(29));
                            if (list == null) {
                                com.google.gson.internal.a.i("Null files");
                                return null;
                            }
                        } else if (nextName2.equals("orgId")) {
                            str = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    if (list == null) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("Missing required properties: files");
                        return null;
                    }
                    a0Var.f720k = new g0(str, list);
                    continue;
                case 1:
                    String nextString = jsonReader.nextString();
                    if (nextString == null) {
                        com.google.gson.internal.a.i("Null sdkVersion");
                        return null;
                    }
                    a0Var.f715a = nextString;
                    break;
                case 2:
                    a0Var.g = jsonReader.nextString();
                    break;
                case 3:
                    a0Var.f721l = c(jsonReader);
                    break;
                case 4:
                    String nextString2 = jsonReader.nextString();
                    if (nextString2 == null) {
                        com.google.gson.internal.a.i("Null buildVersion");
                        return null;
                    }
                    a0Var.h = nextString2;
                    break;
                case 5:
                    a0Var.f = jsonReader.nextString();
                    break;
                case 6:
                    String nextString3 = jsonReader.nextString();
                    if (nextString3 == null) {
                        com.google.gson.internal.a.i("Null gmpAppId");
                        return null;
                    }
                    a0Var.f716b = nextString3;
                    break;
                case 7:
                    String nextString4 = jsonReader.nextString();
                    if (nextString4 == null) {
                        com.google.gson.internal.a.i("Null installationUuid");
                        return null;
                    }
                    a0Var.f718d = nextString4;
                    break;
                case '\b':
                    a0Var.f719e = jsonReader.nextString();
                    break;
                case '\t':
                    a0Var.f717c = jsonReader.nextInt();
                    a0Var.f722m = (byte) (a0Var.f722m | 1);
                    break;
                case '\n':
                    String nextString5 = jsonReader.nextString();
                    if (nextString5 == null) {
                        com.google.gson.internal.a.i("Null displayVersion");
                        return null;
                    }
                    a0Var.i = nextString5;
                    break;
                case 11:
                    i0 i0Var = new i0();
                    i0Var.f = false;
                    i0Var.f817m = (byte) (i0Var.f817m | 2);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.getClass();
                        switch (nextName3.hashCode()) {
                            case -2128794476:
                                if (nextName3.equals("startedAt")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -1907185581:
                                if (nextName3.equals("appQualitySessionId")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -1618432855:
                                if (nextName3.equals("identifier")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -1606742899:
                                if (nextName3.equals("endedAt")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -1335157162:
                                if (nextName3.equals("device")) {
                                    c10 = 4;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -1291329255:
                                if (nextName3.equals("events")) {
                                    c10 = 5;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3556:
                                if (nextName3.equals("os")) {
                                    c10 = 6;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 96801:
                                if (nextName3.equals("app")) {
                                    c10 = 7;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3599307:
                                if (nextName3.equals("user")) {
                                    c10 = '\b';
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 286956243:
                                if (nextName3.equals("generator")) {
                                    c10 = '\t';
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 1025385094:
                                if (nextName3.equals("crashed")) {
                                    c10 = '\n';
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 2047016109:
                                if (nextName3.equals("generatorType")) {
                                    c10 = 11;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                                i0Var.f813d = jsonReader.nextLong();
                                i0Var.f817m = (byte) (i0Var.f817m | 1);
                            case 1:
                                i0Var.f812c = jsonReader.nextString();
                            case 2:
                                i0Var.f811b = new String(Base64.decode(jsonReader.nextString(), 2), n2.f887a);
                            case 3:
                                i0Var.f814e = Long.valueOf(jsonReader.nextLong());
                            case 4:
                                m0 m0Var = new m0();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName4 = jsonReader.nextName();
                                    nextName4.getClass();
                                    switch (nextName4.hashCode()) {
                                        case -1981332476:
                                            if (nextName4.equals("simulator")) {
                                                c11 = 0;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case -1969347631:
                                            if (nextName4.equals("manufacturer")) {
                                                c11 = 1;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 112670:
                                            if (nextName4.equals("ram")) {
                                                c11 = 2;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 3002454:
                                            if (nextName4.equals("arch")) {
                                                c11 = 3;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 81784169:
                                            if (nextName4.equals("diskSpace")) {
                                                c11 = 4;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 94848180:
                                            if (nextName4.equals("cores")) {
                                                c11 = 5;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 104069929:
                                            if (nextName4.equals("model")) {
                                                c11 = 6;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 109757585:
                                            if (nextName4.equals("state")) {
                                                c11 = 7;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 2078953423:
                                            if (nextName4.equals("modelClass")) {
                                                c11 = '\b';
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        default:
                                            c11 = 65535;
                                            break;
                                    }
                                    switch (c11) {
                                        case 0:
                                            m0Var.f = jsonReader.nextBoolean();
                                            m0Var.j = (byte) (m0Var.j | 16);
                                            break;
                                        case 1:
                                            String nextString6 = jsonReader.nextString();
                                            if (nextString6 == null) {
                                                com.google.gson.internal.a.i("Null manufacturer");
                                                break;
                                            } else {
                                                m0Var.h = nextString6;
                                                break;
                                            }
                                        case 2:
                                            m0Var.f869d = jsonReader.nextLong();
                                            m0Var.j = (byte) (m0Var.j | 4);
                                            break;
                                        case 3:
                                            m0Var.f866a = jsonReader.nextInt();
                                            m0Var.j = (byte) (m0Var.j | 1);
                                            break;
                                        case 4:
                                            m0Var.f870e = jsonReader.nextLong();
                                            m0Var.j = (byte) (m0Var.j | 8);
                                            break;
                                        case 5:
                                            m0Var.f868c = jsonReader.nextInt();
                                            m0Var.j = (byte) (m0Var.j | 2);
                                            break;
                                        case 6:
                                            String nextString7 = jsonReader.nextString();
                                            if (nextString7 == null) {
                                                com.google.gson.internal.a.i("Null model");
                                                break;
                                            } else {
                                                m0Var.f867b = nextString7;
                                                break;
                                            }
                                        case 7:
                                            m0Var.g = jsonReader.nextInt();
                                            m0Var.j = (byte) (m0Var.j | 32);
                                            break;
                                        case '\b':
                                            String nextString8 = jsonReader.nextString();
                                            if (nextString8 == null) {
                                                com.google.gson.internal.a.i("Null modelClass");
                                                break;
                                            } else {
                                                m0Var.i = nextString8;
                                                break;
                                            }
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                i0Var.j = m0Var.a();
                            case 5:
                                ArrayList arrayList = new ArrayList();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add(e(jsonReader));
                                }
                                jsonReader.endArray();
                                i0Var.f815k = DesugarCollections.unmodifiableList(arrayList);
                            case 6:
                                h1 h1Var = new h1();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName5 = jsonReader.nextName();
                                    nextName5.getClass();
                                    switch (nextName5.hashCode()) {
                                        case -911706486:
                                            if (nextName5.equals("buildVersion")) {
                                                z9 = false;
                                                break;
                                            }
                                            z9 = -1;
                                            break;
                                        case -293026577:
                                            if (nextName5.equals("jailbroken")) {
                                                z9 = true;
                                                break;
                                            }
                                            z9 = -1;
                                            break;
                                        case 351608024:
                                            if (nextName5.equals("version")) {
                                                z9 = 2;
                                                break;
                                            }
                                            z9 = -1;
                                            break;
                                        case 1874684019:
                                            if (nextName5.equals("platform")) {
                                                z9 = 3;
                                                break;
                                            }
                                            z9 = -1;
                                            break;
                                        default:
                                            z9 = -1;
                                            break;
                                    }
                                    switch (z9) {
                                        case false:
                                            String nextString9 = jsonReader.nextString();
                                            if (nextString9 == null) {
                                                com.google.gson.internal.a.i("Null buildVersion");
                                                break;
                                            } else {
                                                h1Var.f802c = nextString9;
                                                break;
                                            }
                                        case true:
                                            h1Var.f803d = jsonReader.nextBoolean();
                                            h1Var.f804e = (byte) (h1Var.f804e | 2);
                                            break;
                                        case true:
                                            String nextString10 = jsonReader.nextString();
                                            if (nextString10 == null) {
                                                com.google.gson.internal.a.i("Null version");
                                                break;
                                            } else {
                                                h1Var.f801b = nextString10;
                                                break;
                                            }
                                        case true:
                                            h1Var.f800a = jsonReader.nextInt();
                                            h1Var.f804e = (byte) (h1Var.f804e | 1);
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                i0Var.i = h1Var.a();
                            case 7:
                                jsonReader.beginObject();
                                String str2 = null;
                                String str3 = null;
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                while (jsonReader.hasNext()) {
                                    String nextName6 = jsonReader.nextName();
                                    nextName6.getClass();
                                    switch (nextName6.hashCode()) {
                                        case -1618432855:
                                            if (nextName6.equals("identifier")) {
                                                z10 = false;
                                                break;
                                            }
                                            z10 = -1;
                                            break;
                                        case -519438642:
                                            if (nextName6.equals("developmentPlatform")) {
                                                z10 = true;
                                                break;
                                            }
                                            z10 = -1;
                                            break;
                                        case 213652010:
                                            if (nextName6.equals("developmentPlatformVersion")) {
                                                z10 = 2;
                                                break;
                                            }
                                            z10 = -1;
                                            break;
                                        case 351608024:
                                            if (nextName6.equals("version")) {
                                                z10 = 3;
                                                break;
                                            }
                                            z10 = -1;
                                        case 719853845:
                                            if (nextName6.equals("installationUuid")) {
                                                z10 = 4;
                                                break;
                                            }
                                            z10 = -1;
                                        case 1975623094:
                                            if (nextName6.equals("displayVersion")) {
                                                z10 = 5;
                                                break;
                                            }
                                            z10 = -1;
                                        default:
                                            z10 = -1;
                                            break;
                                    }
                                    switch (z10) {
                                        case false:
                                            str7 = jsonReader.nextString();
                                            if (str7 == null) {
                                                com.google.gson.internal.a.i("Null identifier");
                                                break;
                                            } else {
                                                break;
                                            }
                                        case true:
                                            str5 = jsonReader.nextString();
                                            break;
                                        case true:
                                            str6 = jsonReader.nextString();
                                            break;
                                        case true:
                                            str2 = jsonReader.nextString();
                                            if (str2 == null) {
                                                com.google.gson.internal.a.i("Null version");
                                                break;
                                            } else {
                                                break;
                                            }
                                        case true:
                                            str4 = jsonReader.nextString();
                                            break;
                                        case true:
                                            str3 = jsonReader.nextString();
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                if (str7 == null || str2 == null) {
                                    StringBuilder sb = new StringBuilder();
                                    if (str7 == null) {
                                        sb.append(" identifier");
                                    }
                                    if (str2 == null) {
                                        sb.append(" version");
                                    }
                                    androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
                                    break;
                                } else {
                                    i0Var.g = new k0(str7, str2, str3, str4, str5, str6);
                                }
                                break;
                            case '\b':
                                jsonReader.beginObject();
                                String str8 = null;
                                while (jsonReader.hasNext()) {
                                    if (jsonReader.nextName().equals("identifier")) {
                                        str8 = jsonReader.nextString();
                                        if (str8 == null) {
                                            com.google.gson.internal.a.i("Null identifier");
                                            break;
                                        }
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                if (str8 == null) {
                                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Missing required properties: identifier");
                                    break;
                                } else {
                                    i0Var.h = new j1(str8);
                                }
                            case '\t':
                                String nextString11 = jsonReader.nextString();
                                if (nextString11 == null) {
                                    com.google.gson.internal.a.i("Null generator");
                                    break;
                                } else {
                                    i0Var.f810a = nextString11;
                                }
                            case '\n':
                                i0Var.f = jsonReader.nextBoolean();
                                i0Var.f817m = (byte) (i0Var.f817m | 2);
                            case 11:
                                i0Var.f816l = jsonReader.nextInt();
                                i0Var.f817m = (byte) (i0Var.f817m | 4);
                            default:
                                jsonReader.skipValue();
                        }
                        return null;
                        break;
                    }
                    jsonReader.endObject();
                    a0Var.j = i0Var.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a0Var.a();
    }

    public static b0 i(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0 h = h(jsonReader);
                jsonReader.close();
                return h;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }
}
