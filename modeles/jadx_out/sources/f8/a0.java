package f8;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.PreRegisterWorker;
import java.io.Serializable;
import o7.m0;
import x4.j0;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class a0 implements o5.e, a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4929a;

    /* renamed from: b, reason: collision with root package name */
    public int f4930b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f4931l;

    /* renamed from: m, reason: collision with root package name */
    public Serializable f4932m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f4933n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f4934o;

    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.Serializable, java.lang.Object[]] */
    public a0(String str) {
        this.f4929a = 0;
        str.getClass();
        o oVar = new o();
        oVar.f4960b = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        oVar.f4962d = iArr;
        oVar.f4961c = -1;
        this.f4931l = oVar;
        this.f4934o = new StringBuilder();
        this.f4933n = str;
    }

    public static /* synthetic */ void p(a0 a0Var, String str, int i, String str2, int i6) {
        if ((i6 & 2) != 0) {
            i = a0Var.f4930b;
        }
        if ((i6 & 4) != 0) {
            str2 = "";
        }
        a0Var.o(i, str, str2);
        throw null;
    }

    @Override // o5.e
    public void a(long j) {
        ((kotlin.jvm.internal.w) this.f4931l).f7023a = j;
    }

    @Override // o5.e
    public void b(long j) {
        ((kotlin.jvm.internal.w) this.f4932m).f7023a = j;
    }

    public int c(int i, CharSequence charSequence) {
        int i6 = i + 4;
        if (i6 < charSequence.length()) {
            ((StringBuilder) this.f4934o).append((char) (r(i + 3, charSequence) + (r(i, charSequence) << 12) + (r(i + 1, charSequence) << 8) + (r(i + 2, charSequence) << 4)));
            return i6;
        }
        this.f4930b = i;
        if (i6 < charSequence.length()) {
            return c(this.f4930b, charSequence);
        }
        p(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public boolean d() {
        int i = this.f4930b;
        if (i == -1) {
            return false;
        }
        String str = (String) this.f4933n;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f4930b = i;
                return (charAt == ',' || charAt == ':' || charAt == ']' || charAt == '}') ? false : true;
            }
            i++;
        }
        this.f4930b = i;
        return false;
    }

    @Override // o5.e
    public void e() {
        Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadApkWorker downloadApkWorker = (DownloadApkWorker) this.f4933n;
        downloadApkWorker.r(e10, downloadApkWorker.f3476c, (j0) ((x4.r) this.f4934o).F.get(this.f4930b));
    }

    public void f(int i, String str) {
        String str2 = (String) this.f4933n;
        if (str2.length() - i < str.length()) {
            p(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) != (str2.charAt(i + i6) | ' ')) {
                p(this, "Expected valid boolean literal prefix, but had '" + n() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.f4930b = str.length() + i;
    }

    public String g() {
        String str;
        StringBuilder sb = (StringBuilder) this.f4934o;
        String str2 = (String) this.f4933n;
        k('\"');
        int i = this.f4930b;
        int x02 = l7.m.x0('\"', i, 4, str2);
        if (x02 == -1) {
            n();
            q((byte) 1, false);
            throw null;
        }
        int i6 = i;
        while (i6 < x02) {
            if (str2.charAt(i6) == '\\') {
                int i10 = this.f4930b;
                char charAt = str2.charAt(i6);
                boolean z9 = false;
                while (charAt != '\"') {
                    if (charAt == '\\') {
                        sb.append((CharSequence) str2, i10, i6);
                        int v = v(i6 + 1);
                        if (v == -1) {
                            p(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int i11 = v + 1;
                        char charAt2 = str2.charAt(v);
                        if (charAt2 == 'u') {
                            i11 = c(i11, str2);
                        } else {
                            char c9 = charAt2 < 'u' ? d.f4949a[charAt2] : (char) 0;
                            if (c9 == 0) {
                                p(this, "Invalid escaped char '" + charAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c9);
                        }
                        i10 = v(i11);
                        if (i10 == -1) {
                            p(this, "Unexpected EOF", i10, null, 4);
                            throw null;
                        }
                    } else {
                        i6++;
                        if (i6 >= str2.length()) {
                            sb.append((CharSequence) str2, i10, i6);
                            i10 = v(i6);
                            if (i10 == -1) {
                                p(this, "Unexpected EOF", i10, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            charAt = str2.charAt(i6);
                        }
                    }
                    i6 = i10;
                    z9 = true;
                    charAt = str2.charAt(i6);
                }
                if (z9) {
                    sb.append((CharSequence) str2, i10, i6);
                    String sb2 = sb.toString();
                    sb.setLength(0);
                    str = sb2;
                } else {
                    str = str2.subSequence(i10, i6).toString();
                }
                this.f4930b = i6 + 1;
                return str;
            }
            i6++;
        }
        this.f4930b = x02 + 1;
        return str2.substring(i, x02);
    }

    @Override // a4.i
    public void h(Exception exc) {
        j5.o.e(((PreRegisterWorker) this.f4931l).f3487a, (x4.g) this.f4934o, this.f4930b, null, (x1) this.f4933n);
    }

    public byte i() {
        String str = (String) this.f4933n;
        int i = this.f4930b;
        while (i != -1 && i < str.length()) {
            int i6 = i + 1;
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f4930b = i6;
                return m.g(charAt);
            }
            i = i6;
        }
        this.f4930b = str.length();
        return (byte) 10;
    }

    public byte j(byte b7) {
        byte i = i();
        if (i == b7) {
            return i;
        }
        q(b7, true);
        throw null;
    }

    public void k(char c9) {
        int i = this.f4930b;
        if (i == -1) {
            y(c9);
            throw null;
        }
        String str = (String) this.f4933n;
        while (i < str.length()) {
            int i6 = i + 1;
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f4930b = i6;
                if (charAt == c9) {
                    return;
                }
                y(c9);
                throw null;
            }
            i = i6;
        }
        this.f4930b = -1;
        y(c9);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0191, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0194, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0195, code lost:
    
        p(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x019a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0164, code lost:
    
        p(r21, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x017c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x017d, code lost:
    
        p(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0182, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0146, code lost:
    
        if (r11 != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0148, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0183, code lost:
    
        com.google.gson.internal.a.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0188, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0189, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x019b, code lost:
    
        p(r21, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01a0, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0108, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e9, code lost:
    
        p(r21, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0101, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0104, code lost:
    
        if (r12 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0106, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0109, code lost:
    
        if (r1 == r12) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x010b, code lost:
    
        if (r14 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010f, code lost:
    
        if (r1 == (r12 - 1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0116, code lost:
    
        if (r20 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0118, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
    
        if (r2.charAt(r12) != '\"') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0122, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0125, code lost:
    
        p(r21, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x012c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x012d, code lost:
    
        p(r21, "EOF", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0132, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0133, code lost:
    
        r21.f4930b = r12;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0137, code lost:
    
        if (r13 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0139, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x013c, code lost:
    
        if (r11 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x013e, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x014d, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0152, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0158, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0162, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x018a, code lost:
    
        if (r14 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x018c, code lost:
    
        return r10;
     */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long l() {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.a0.l():long");
    }

    public String m() {
        String str = (String) this.f4932m;
        if (str == null) {
            return g();
        }
        str.getClass();
        this.f4932m = null;
        return str;
    }

    public String n() {
        String str;
        StringBuilder sb = (StringBuilder) this.f4934o;
        String str2 = (String) this.f4933n;
        String str3 = (String) this.f4932m;
        if (str3 != null) {
            str3.getClass();
            this.f4932m = null;
            return str3;
        }
        int w2 = w();
        if (w2 >= str2.length() || w2 == -1) {
            p(this, "EOF", w2, null, 4);
            throw null;
        }
        byte g = m.g(str2.charAt(w2));
        if (g == 1) {
            return m();
        }
        if (g != 0) {
            p(this, "Expected beginning of the string, but got " + str2.charAt(w2), 0, null, 6);
            throw null;
        }
        boolean z9 = false;
        while (m.g(str2.charAt(w2)) == 0) {
            w2++;
            if (w2 >= str2.length()) {
                sb.append((CharSequence) str2, this.f4930b, w2);
                int v = v(w2);
                if (v == -1) {
                    this.f4930b = w2;
                    sb.append((CharSequence) str2, 0, 0);
                    String sb2 = sb.toString();
                    sb.setLength(0);
                    return sb2;
                }
                w2 = v;
                z9 = true;
            }
        }
        int i = this.f4930b;
        if (z9) {
            sb.append((CharSequence) str2, i, w2);
            String sb3 = sb.toString();
            sb.setLength(0);
            str = sb3;
        } else {
            str = str2.subSequence(i, w2).toString();
        }
        this.f4930b = w2;
        return str;
    }

    public void o(int i, String str, String str2) {
        str2.getClass();
        String concat = str2.length() == 0 ? "" : "\n".concat(str2);
        StringBuilder u7 = a4.x.u(str, " at path: ");
        u7.append(((o) this.f4931l).c());
        u7.append(concat);
        throw m.e(u7.toString(), (String) this.f4933n, i);
    }

    @Override // a4.i
    public void onSuccess() {
        v7.e eVar = m0.f8288a;
        t7.c b7 = o7.c0.b(v7.d.f10884a);
        PreRegisterWorker preRegisterWorker = (PreRegisterWorker) this.f4931l;
        String str = (String) this.f4932m;
        x1 x1Var = (x1) this.f4933n;
        o7.c0.s(b7, null, null, new o5.m(this.f4930b, preRegisterWorker, str, null, (x4.g) this.f4934o, x1Var), 3);
    }

    public void q(byte b7, boolean z9) {
        String str = (String) this.f4933n;
        String p10 = m.p(b7);
        int i = this.f4930b;
        int i6 = z9 ? i - 1 : i;
        p(this, "Expected " + p10 + ", but had '" + ((i == str.length() || i6 < 0) ? "EOF" : String.valueOf(str.charAt(i6))) + "' instead", i6, null, 4);
        throw null;
    }

    public int r(int i, CharSequence charSequence) {
        char charAt = charSequence.charAt(i);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        p(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public String s(String str) {
        str.getClass();
        int i = this.f4930b;
        try {
            if (i() == 6 && kotlin.jvm.internal.l.a(u(), str)) {
                this.f4932m = null;
                if (i() == 5) {
                    return u();
                }
            }
            return null;
        } finally {
            this.f4930b = i;
            this.f4932m = null;
        }
    }

    public byte t() {
        String str = (String) this.f4933n;
        int i = this.f4930b;
        while (true) {
            int v = v(i);
            if (v == -1) {
                this.f4930b = v;
                return (byte) 10;
            }
            char charAt = str.charAt(v);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                this.f4930b = v;
                return m.g(charAt);
            }
            i = v + 1;
        }
    }

    public String toString() {
        switch (this.f4929a) {
            case 0:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.f4933n);
                sb.append("', currentPosition=");
                sb.append(this.f4930b);
                sb.append(')');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public String u() {
        if (t() != 1) {
            return null;
        }
        String m10 = m();
        this.f4932m = m10;
        return m10;
    }

    public int v(int i) {
        if (i < ((String) this.f4933n).length()) {
            return i;
        }
        return -1;
    }

    public int w() {
        char charAt;
        int i = this.f4930b;
        if (i == -1) {
            return i;
        }
        String str = (String) this.f4933n;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i++;
        }
        this.f4930b = i;
        return i;
    }

    public boolean x() {
        int w2 = w();
        String str = (String) this.f4933n;
        if (w2 >= str.length() || w2 == -1 || str.charAt(w2) != ',') {
            return false;
        }
        this.f4930b++;
        return true;
    }

    public void y(char c9) {
        int i = this.f4930b;
        if (i > 0 && c9 == '\"') {
            try {
                this.f4930b = i - 1;
                String n10 = n();
                this.f4930b = i;
                if (kotlin.jvm.internal.l.a(n10, "null")) {
                    o(this.f4930b - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f4930b = i;
                throw th;
            }
        }
        q(m.g(c9), true);
        throw null;
    }

    public /* synthetic */ a0(Object obj, Serializable serializable, Object obj2, Parcelable parcelable, int i, int i6) {
        this.f4929a = i6;
        this.f4931l = obj;
        this.f4932m = serializable;
        this.f4933n = obj2;
        this.f4934o = parcelable;
        this.f4930b = i;
    }
}
