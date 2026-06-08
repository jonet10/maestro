package f8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x extends c8.a implements e8.i {

    /* renamed from: a, reason: collision with root package name */
    public final e8.b f4981a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f4982b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f4983c;

    /* renamed from: d, reason: collision with root package name */
    public final g8.f f4984d;

    /* renamed from: e, reason: collision with root package name */
    public int f4985e;
    public w f;
    public final e8.h g;
    public final j h;

    public x(e8.b bVar, c0 c0Var, a0 a0Var, b8.e eVar, w wVar) {
        eVar.getClass();
        this.f4981a = bVar;
        this.f4982b = c0Var;
        this.f4983c = a0Var;
        this.f4984d = bVar.f4762b;
        this.f4985e = -1;
        this.f = wVar;
        e8.h hVar = bVar.f4761a;
        this.g = hVar;
        this.h = hVar.f4770a ? null : new j(eVar);
    }

    @Override // e8.i
    public final e8.k a() {
        return new q(this.f4981a.f4761a, this.f4983c).d();
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Serializable, java.lang.Object[]] */
    @Override // c8.a, c8.e
    public final c8.c beginStructure(b8.e eVar) {
        eVar.getClass();
        e8.b bVar = this.f4981a;
        c0 n10 = m.n(eVar, bVar);
        a0 a0Var = this.f4983c;
        o oVar = (o) a0Var.f4931l;
        int i = oVar.f4961c + 1;
        oVar.f4961c = i;
        Object[] objArr = (Object[]) oVar.f4960b;
        if (i == objArr.length) {
            int i6 = i * 2;
            oVar.f4960b = Arrays.copyOf(objArr, i6);
            oVar.f4962d = Arrays.copyOf((int[]) oVar.f4962d, i6);
        }
        ((Object[]) oVar.f4960b)[i] = eVar;
        a0Var.k(n10.f4947a);
        if (a0Var.t() != 4) {
            int ordinal = n10.ordinal();
            return (ordinal == 1 || ordinal == 2 || ordinal == 3) ? new x(bVar, n10, a0Var, eVar, this.f) : (this.f4982b == n10 && bVar.f4761a.f4770a) ? this : new x(bVar, n10, a0Var, eVar, this.f);
        }
        a0.p(a0Var, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final boolean decodeBoolean() {
        boolean z9;
        boolean z10;
        a0 a0Var = this.f4983c;
        int w2 = a0Var.w();
        String str = (String) a0Var.f4933n;
        if (w2 == str.length()) {
            a0.p(a0Var, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(w2) == '\"') {
            w2++;
            z9 = true;
        } else {
            z9 = false;
        }
        int v = a0Var.v(w2);
        if (v >= str.length() || v == -1) {
            a0.p(a0Var, "EOF", 0, null, 6);
            throw null;
        }
        int i = v + 1;
        int charAt = str.charAt(v) | ' ';
        if (charAt == 102) {
            a0Var.f(i, "alse");
            z10 = false;
        } else {
            if (charAt != 116) {
                a0.p(a0Var, "Expected valid boolean literal prefix, but had '" + a0Var.n() + '\'', 0, null, 6);
                throw null;
            }
            a0Var.f(i, "rue");
            z10 = true;
        }
        if (!z9) {
            return z10;
        }
        if (a0Var.f4930b == str.length()) {
            a0.p(a0Var, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(a0Var.f4930b) == '\"') {
            a0Var.f4930b++;
            return z10;
        }
        a0.p(a0Var, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final byte decodeByte() {
        a0 a0Var = this.f4983c;
        long l10 = a0Var.l();
        byte b7 = (byte) l10;
        if (l10 == b7) {
            return b7;
        }
        a0.p(a0Var, "Failed to parse byte for input '" + l10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final char decodeChar() {
        a0 a0Var = this.f4983c;
        String n10 = a0Var.n();
        if (n10.length() == 1) {
            return n10.charAt(0);
        }
        a0.p(a0Var, "Expected single char, but got '" + n10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final double decodeDouble() {
        a0 a0Var = this.f4983c;
        String n10 = a0Var.n();
        try {
            double parseDouble = Double.parseDouble(n10);
            this.f4981a.f4761a.getClass();
            if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                return parseDouble;
            }
            m.o(a0Var, Double.valueOf(parseDouble));
            throw null;
        } catch (IllegalArgumentException unused) {
            a0.p(a0Var, "Failed to parse type 'double' for input '" + n10 + '\'', 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x018f, code lost:
    
        r3.o(l7.m.A0(r7, r5.subSequence(0, r3.f4930b).toString(), 6), "Encountered an unknown key '" + r7 + '\'', "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b6, code lost:
    
        throw null;
     */
    @Override // c8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int decodeElementIndex(b8.e r20) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.x.decodeElementIndex(b8.e):int");
    }

    @Override // c8.a
    public final int decodeEnum(b8.e eVar) {
        eVar.getClass();
        String decodeString = decodeString();
        String concat = " at path ".concat(((o) this.f4983c.f4931l).c());
        eVar.getClass();
        e8.b bVar = this.f4981a;
        bVar.getClass();
        decodeString.getClass();
        int i = m.i(eVar, bVar, decodeString);
        if (i != -3) {
            return i;
        }
        throw new z7.g(eVar.a() + " does not contain element with name '" + decodeString + '\'' + concat);
    }

    @Override // c8.a, c8.e
    public final float decodeFloat() {
        a0 a0Var = this.f4983c;
        String n10 = a0Var.n();
        try {
            float parseFloat = Float.parseFloat(n10);
            this.f4981a.f4761a.getClass();
            if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                return parseFloat;
            }
            m.o(a0Var, Float.valueOf(parseFloat));
            throw null;
        } catch (IllegalArgumentException unused) {
            a0.p(a0Var, "Failed to parse type 'float' for input '" + n10 + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // c8.a, c8.e
    public final c8.e decodeInline(b8.e eVar) {
        eVar.getClass();
        return z.a(eVar) ? new g(this.f4983c, this.f4981a) : super.decodeInline(eVar);
    }

    @Override // c8.a, c8.e
    public final int decodeInt() {
        a0 a0Var = this.f4983c;
        long l10 = a0Var.l();
        int i = (int) l10;
        if (l10 == i) {
            return i;
        }
        a0.p(a0Var, "Failed to parse int for input '" + l10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final long decodeLong() {
        return this.f4983c.l();
    }

    @Override // c8.a, c8.e
    public final boolean decodeNotNullMark() {
        j jVar = this.h;
        if (!(jVar != null ? jVar.f4956b : false)) {
            a0 a0Var = this.f4983c;
            int v = a0Var.v(a0Var.w());
            String str = (String) a0Var.f4933n;
            int length = str.length() - v;
            boolean z9 = false;
            if (length >= 4 && v != -1) {
                int i = 0;
                while (true) {
                    if (i < 4) {
                        if ("null".charAt(i) != str.charAt(v + i)) {
                            break;
                        }
                        i++;
                    } else if (length <= 4 || m.g(str.charAt(v + 4)) != 0) {
                        z9 = true;
                        a0Var.f4930b = v + 4;
                    }
                }
            }
            if (!z9) {
                return true;
            }
        }
        return false;
    }

    @Override // c8.a, c8.e
    public final Void decodeNull() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Serializable, java.lang.Object[]] */
    @Override // c8.a, c8.c
    public final Object decodeSerializableElement(b8.e eVar, int i, z7.a aVar, Object obj) {
        o oVar = (o) this.f4983c.f4931l;
        eVar.getClass();
        aVar.getClass();
        boolean z9 = this.f4982b == c0.f4943n && (i & 1) == 0;
        if (z9) {
            int[] iArr = (int[]) oVar.f4962d;
            int i6 = oVar.f4961c;
            if (iArr[i6] == -2) {
                ((Object[]) oVar.f4960b)[i6] = n.f4958a;
            }
        }
        Object decodeSerializableElement = super.decodeSerializableElement(eVar, i, aVar, obj);
        if (z9) {
            int[] iArr2 = (int[]) oVar.f4962d;
            int i10 = oVar.f4961c;
            if (iArr2[i10] != -2) {
                int i11 = i10 + 1;
                oVar.f4961c = i11;
                Object[] objArr = (Object[]) oVar.f4960b;
                if (i11 == objArr.length) {
                    int i12 = i11 * 2;
                    oVar.f4960b = Arrays.copyOf(objArr, i12);
                    oVar.f4962d = Arrays.copyOf((int[]) oVar.f4962d, i12);
                }
            }
            Object[] objArr2 = (Object[]) oVar.f4960b;
            int i13 = oVar.f4961c;
            objArr2[i13] = decodeSerializableElement;
            ((int[]) oVar.f4962d)[i13] = -2;
        }
        return decodeSerializableElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    @Override // c8.a, c8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decodeSerializableValue(z7.a r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.x.decodeSerializableValue(z7.a):java.lang.Object");
    }

    @Override // c8.a, c8.e
    public final short decodeShort() {
        a0 a0Var = this.f4983c;
        long l10 = a0Var.l();
        short s6 = (short) l10;
        if (l10 == s6) {
            return s6;
        }
        a0.p(a0Var, "Failed to parse short for input '" + l10 + '\'', 0, null, 6);
        throw null;
    }

    @Override // c8.a, c8.e
    public final String decodeString() {
        this.g.getClass();
        return this.f4983c.m();
    }

    @Override // c8.a, c8.c
    public final void endStructure(b8.e eVar) {
        eVar.getClass();
        e8.h hVar = this.f4981a.f4761a;
        hVar.getClass();
        a0 a0Var = this.f4983c;
        if (a0Var.x()) {
            hVar.getClass();
            m.j(a0Var, "");
            throw null;
        }
        a0Var.k(this.f4982b.f4948b);
        o oVar = (o) a0Var.f4931l;
        int i = oVar.f4961c;
        int[] iArr = (int[]) oVar.f4962d;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            oVar.f4961c = i - 1;
        }
        int i6 = oVar.f4961c;
        if (i6 != -1) {
            oVar.f4961c = i6 - 1;
        }
    }

    @Override // c8.c
    public final g8.f getSerializersModule() {
        return this.f4984d;
    }
}
