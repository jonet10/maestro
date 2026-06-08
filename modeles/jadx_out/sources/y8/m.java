package y8;

import b9.v;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m {
    public static final Pattern i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    public static final Pattern j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f11856k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f11857l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f11858m = Pattern.compile("`+");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f11859n = Pattern.compile("^`+");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f11860o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f11861p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f11862q = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f11863r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f11864s = Pattern.compile("\\s+");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f11865t = Pattern.compile(" *$");

    /* renamed from: a, reason: collision with root package name */
    public final BitSet f11866a;

    /* renamed from: b, reason: collision with root package name */
    public final BitSet f11867b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f11868c;

    /* renamed from: d, reason: collision with root package name */
    public final m8.q f11869d;

    /* renamed from: e, reason: collision with root package name */
    public String f11870e;
    public int f;
    public f g;
    public e h;

    public m(m8.q qVar) {
        List list = (List) qVar.f7780b;
        HashMap hashMap = new HashMap();
        b(Arrays.asList(new z8.a('*'), new z8.a('_')), hashMap);
        b(list, hashMap);
        this.f11868c = hashMap;
        Set keySet = hashMap.keySet();
        BitSet bitSet = new BitSet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        this.f11867b = bitSet;
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        this.f11866a = bitSet2;
        this.f11869d = qVar;
    }

    public static void a(char c9, e9.a aVar, HashMap hashMap) {
        if (((e9.a) hashMap.put(Character.valueOf(c9), aVar)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c9 + "'");
    }

    public static void b(Iterable iterable, HashMap hashMap) {
        s sVar;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            e9.a aVar = (e9.a) it.next();
            char d10 = aVar.d();
            char b7 = aVar.b();
            if (d10 == b7) {
                e9.a aVar2 = (e9.a) hashMap.get(Character.valueOf(d10));
                if (aVar2 == null || aVar2.d() != aVar2.b()) {
                    a(d10, aVar, hashMap);
                } else {
                    if (aVar2 instanceof s) {
                        sVar = (s) aVar2;
                    } else {
                        s sVar2 = new s(d10);
                        sVar2.f(aVar2);
                        sVar = sVar2;
                    }
                    sVar.f(aVar);
                    hashMap.put(Character.valueOf(d10), sVar);
                }
            } else {
                a(d10, aVar, hashMap);
                a(b7, aVar, hashMap);
            }
        }
    }

    public static void d(v vVar, v vVar2, int i6) {
        if (vVar == null || vVar2 == null || vVar == vVar2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i6);
        sb.append(vVar.f);
        b9.q qVar = vVar.f1125e;
        b9.q qVar2 = vVar2.f1125e;
        while (qVar != qVar2) {
            sb.append(((v) qVar).f);
            b9.q qVar3 = qVar.f1125e;
            qVar.f();
            qVar = qVar3;
        }
        vVar.f = sb.toString();
    }

    public static void e(b9.q qVar, b9.q qVar2) {
        v vVar = null;
        v vVar2 = null;
        int i6 = 0;
        while (qVar != null) {
            if (qVar instanceof v) {
                vVar2 = (v) qVar;
                if (vVar == null) {
                    vVar = vVar2;
                }
                i6 = vVar2.f.length() + i6;
            } else {
                d(vVar, vVar2, i6);
                vVar = null;
                vVar2 = null;
                i6 = 0;
            }
            if (qVar == qVar2) {
                break;
            } else {
                qVar = qVar.f1125e;
            }
        }
        d(vVar, vVar2, i6);
    }

    public final String c(Pattern pattern) {
        if (this.f >= this.f11870e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f11870e);
        matcher.region(this.f, this.f11870e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f = matcher.end();
        return matcher.group();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0543 A[LOOP:0: B:2:0x0013->B:7:0x0543, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x054a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v17, types: [b9.d, b9.q] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v27, types: [b9.q] */
    /* JADX WARN: Type inference failed for: r4v44, types: [b9.v] */
    /* JADX WARN: Type inference failed for: r4v45, types: [b9.v] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v55, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r5v22, types: [y8.l] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r8v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r26, b9.q r27) {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.m.f(java.lang.String, b9.q):void");
    }

    public final char g() {
        if (this.f < this.f11870e.length()) {
            return this.f11870e.charAt(this.f);
        }
        return (char) 0;
    }

    public final void h(f fVar) {
        boolean z9;
        b9.q qVar;
        HashMap hashMap = new HashMap();
        f fVar2 = this.g;
        while (fVar2 != null) {
            f fVar3 = fVar2.f11827e;
            if (fVar3 == fVar) {
                break;
            } else {
                fVar2 = fVar3;
            }
        }
        while (fVar2 != null) {
            v vVar = fVar2.f11823a;
            char c9 = fVar2.f11824b;
            e9.a aVar = (e9.a) this.f11868c.get(Character.valueOf(c9));
            if (!fVar2.f11826d || aVar == null) {
                fVar2 = fVar2.f;
            } else {
                char d10 = aVar.d();
                f fVar4 = fVar2.f11827e;
                int i6 = 0;
                boolean z10 = false;
                while (fVar4 != null && fVar4 != fVar && fVar4 != hashMap.get(Character.valueOf(c9))) {
                    if (fVar4.f11825c && fVar4.f11824b == d10) {
                        i6 = aVar.e(fVar4, fVar2);
                        z10 = true;
                        if (i6 > 0) {
                            z9 = true;
                            break;
                        }
                    }
                    fVar4 = fVar4.f11827e;
                }
                z9 = z10;
                z10 = false;
                if (z10) {
                    v vVar2 = fVar4.f11823a;
                    fVar4.g -= i6;
                    fVar2.g -= i6;
                    String str = vVar2.f;
                    vVar2.f = str.substring(0, str.length() - i6);
                    String str2 = vVar.f;
                    vVar.f = str2.substring(0, str2.length() - i6);
                    f fVar5 = fVar2.f11827e;
                    while (fVar5 != null && fVar5 != fVar4) {
                        f fVar6 = fVar5.f11827e;
                        i(fVar5);
                        fVar5 = fVar6;
                    }
                    if (vVar2 != vVar && (qVar = vVar2.f1125e) != vVar) {
                        e(qVar, vVar.f1124d);
                    }
                    aVar.a(vVar2, vVar, i6);
                    if (fVar4.g == 0) {
                        fVar4.f11823a.f();
                        i(fVar4);
                    }
                    if (fVar2.g == 0) {
                        f fVar7 = fVar2.f;
                        vVar.f();
                        i(fVar2);
                        fVar2 = fVar7;
                    }
                } else {
                    if (!z9) {
                        hashMap.put(Character.valueOf(c9), fVar2.f11827e);
                        if (!fVar2.f11825c) {
                            i(fVar2);
                        }
                    }
                    fVar2 = fVar2.f;
                }
            }
        }
        while (true) {
            f fVar8 = this.g;
            if (fVar8 == null || fVar8 == fVar) {
                return;
            } else {
                i(fVar8);
            }
        }
    }

    public final void i(f fVar) {
        f fVar2 = fVar.f11827e;
        if (fVar2 != null) {
            fVar2.f = fVar.f;
        }
        f fVar3 = fVar.f;
        if (fVar3 == null) {
            this.g = fVar2;
        } else {
            fVar3.f11827e = fVar2;
        }
    }
}
