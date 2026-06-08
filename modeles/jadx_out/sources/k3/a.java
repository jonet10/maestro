package k3;

import a4.x;
import androidx.lifecycle.l;
import e1.c0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.StringReader;
import java.util.Arrays;
import k0.k;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final StringReader f6949a;

    /* renamed from: q, reason: collision with root package name */
    public long f6956q;

    /* renamed from: r, reason: collision with root package name */
    public int f6957r;

    /* renamed from: s, reason: collision with root package name */
    public String f6958s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f6959t;
    public String[] v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f6961w;

    /* renamed from: x, reason: collision with root package name */
    public int f6962x = 2;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f6950b = new char[1024];

    /* renamed from: l, reason: collision with root package name */
    public int f6951l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f6952m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f6953n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f6954o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f6955p = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f6960u = 1;

    static {
        c0.f3840r = new c0(22);
    }

    public a(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f6959t = iArr;
        iArr[0] = 6;
        this.v = new String[32];
        this.f6961w = new int[32];
        this.f6949a = stringReader;
    }

    public final long A() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 15) {
            this.f6955p = 0;
            int[] iArr = this.f6961w;
            int i6 = this.f6960u - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f6956q;
        }
        if (i == 16) {
            this.f6958s = new String(this.f6950b, this.f6951l, this.f6957r);
            this.f6951l += this.f6957r;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw P("a long");
            }
            if (i == 10) {
                this.f6958s = G();
            } else {
                this.f6958s = E(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f6958s);
                this.f6955p = 0;
                int[] iArr2 = this.f6961w;
                int i10 = this.f6960u - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6955p = 11;
        double parseDouble = Double.parseDouble(this.f6958s);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.f6958s = null;
            this.f6955p = 0;
            int[] iArr3 = this.f6961w;
            int i11 = this.f6960u - 1;
            iArr3[i11] = iArr3[i11] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.f6958s + s());
    }

    public final String B() {
        String E;
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 14) {
            E = G();
        } else if (i == 12) {
            E = E('\'');
        } else {
            if (i != 13) {
                throw P("a name");
            }
            E = E('\"');
        }
        this.f6955p = 0;
        this.v[this.f6960u - 1] = E;
        return E;
    }

    public final int C(boolean z9) {
        char c9;
        int i = this.f6951l;
        int i6 = this.f6952m;
        while (true) {
            if (i == i6) {
                this.f6951l = i;
                if (!i(1)) {
                    if (z9) {
                        throw new EOFException("End of input".concat(s()));
                    }
                    return -1;
                }
                i = this.f6951l;
                i6 = this.f6952m;
            }
            int i10 = i + 1;
            char[] cArr = this.f6950b;
            c9 = cArr[i];
            if (c9 == '\n') {
                this.f6953n++;
                this.f6954o = i10;
            } else if (c9 != ' ' && c9 != '\r' && c9 != '\t') {
                if (c9 == '/') {
                    this.f6951l = i10;
                    if (i10 == i6) {
                        this.f6951l = i;
                        boolean i11 = i(2);
                        this.f6951l++;
                        if (!i11) {
                            break;
                        }
                    }
                    d();
                    int i12 = this.f6951l;
                    char c10 = cArr[i12];
                    if (c10 == '*') {
                        this.f6951l = i12 + 1;
                        while (true) {
                            if (this.f6951l + 2 > this.f6952m && !i(2)) {
                                O("Unterminated comment");
                                throw null;
                            }
                            int i13 = this.f6951l;
                            if (cArr[i13] != '\n') {
                                int i14 = 0;
                                while (true) {
                                    int i15 = this.f6951l;
                                    if (i14 >= 2) {
                                        i = i15 + 2;
                                        i6 = this.f6952m;
                                        break;
                                    }
                                    if (cArr[i15 + i14] != "*/".charAt(i14)) {
                                        break;
                                    }
                                    i14++;
                                }
                            } else {
                                this.f6953n++;
                                this.f6954o = i13 + 1;
                            }
                            this.f6951l++;
                        }
                    } else {
                        if (c10 != '/') {
                            break;
                        }
                        this.f6951l = i12 + 1;
                        L();
                        i = this.f6951l;
                        i6 = this.f6952m;
                    }
                } else {
                    if (c9 != '#') {
                        this.f6951l = i10;
                        return c9;
                    }
                    this.f6951l = i10;
                    d();
                    L();
                    i = this.f6951l;
                    i6 = this.f6952m;
                }
            }
            i = i10;
        }
        return c9;
    }

    public final void D() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i != 7) {
            throw P("null");
        }
        this.f6955p = 0;
        int[] iArr = this.f6961w;
        int i6 = this.f6960u - 1;
        iArr[i6] = iArr[i6] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r11.f6951l = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.f6951l = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String E(char r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f6951l
            int r3 = r11.f6952m
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f6950b
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.f6962x
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.O(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.f6951l = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r12 = new java.lang.String
            r12.<init>(r7, r3, r8)
            return r12
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.f6951l = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.J()
            r1.append(r2)
            int r2 = r11.f6951l
            int r3 = r11.f6952m
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.f6953n
            int r2 = r2 + r6
            r11.f6953n = r2
            r11.f6954o = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.f6951l = r2
            boolean r2 = r11.i(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.O(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.E(char):java.lang.String");
    }

    public final String F() {
        String str;
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 10) {
            str = G();
        } else if (i == 8) {
            str = E('\'');
        } else if (i == 9) {
            str = E('\"');
        } else if (i == 11) {
            str = this.f6958s;
            this.f6958s = null;
        } else if (i == 15) {
            str = Long.toString(this.f6956q);
        } else {
            if (i != 16) {
                throw P("a string");
            }
            str = new String(this.f6950b, this.f6951l, this.f6957r);
            this.f6951l += this.f6957r;
        }
        this.f6955p = 0;
        int[] iArr = this.f6961w;
        int i6 = this.f6960u - 1;
        iArr[i6] = iArr[i6] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0048, code lost:
    
        d();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String G() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f6951l
            int r3 = r3 + r2
            int r4 = r6.f6952m
            char[] r5 = r6.f6950b
            if (r3 >= r4) goto L4c
            char r3 = r5[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r6.d()
            goto L58
        L4c:
            int r3 = r5.length
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r6.i(r3)
            if (r3 == 0) goto L58
            goto L3
        L58:
            r1 = r2
            goto L78
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            int r3 = r6.f6951l
            r0.append(r5, r3, r2)
            int r3 = r6.f6951l
            int r3 = r3 + r2
            r6.f6951l = r3
            r2 = 1
            boolean r2 = r6.i(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.f6951l
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.f6951l
            int r2 = r2 + r1
            r6.f6951l = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.G():java.lang.String");
    }

    public final int H() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void I(int i) {
        int i6 = this.f6960u;
        if (i6 - 1 >= 255) {
            throw new c("Nesting limit 255 reached".concat(s()));
        }
        int[] iArr = this.f6959t;
        if (i6 == iArr.length) {
            int i10 = i6 * 2;
            this.f6959t = Arrays.copyOf(iArr, i10);
            this.f6961w = Arrays.copyOf(this.f6961w, i10);
            this.v = (String[]) Arrays.copyOf(this.v, i10);
        }
        int[] iArr2 = this.f6959t;
        int i11 = this.f6960u;
        this.f6960u = i11 + 1;
        iArr2[i11] = i;
    }

    public final char J() {
        int i;
        if (this.f6951l == this.f6952m && !i(1)) {
            O("Unterminated escape sequence");
            throw null;
        }
        int i6 = this.f6951l;
        int i10 = i6 + 1;
        this.f6951l = i10;
        char[] cArr = this.f6950b;
        char c9 = cArr[i6];
        if (c9 != '\n') {
            if (c9 != '\"') {
                if (c9 != '\'') {
                    if (c9 != '/' && c9 != '\\') {
                        if (c9 == 'b') {
                            return '\b';
                        }
                        if (c9 == 'f') {
                            return '\f';
                        }
                        if (c9 == 'n') {
                            return '\n';
                        }
                        if (c9 == 'r') {
                            return '\r';
                        }
                        if (c9 == 't') {
                            return '\t';
                        }
                        if (c9 != 'u') {
                            O("Invalid escape sequence");
                            throw null;
                        }
                        if (i6 + 5 > this.f6952m && !i(4)) {
                            O("Unterminated escape sequence");
                            throw null;
                        }
                        int i11 = this.f6951l;
                        int i12 = i11 + 4;
                        int i13 = 0;
                        while (i11 < i12) {
                            char c10 = cArr[i11];
                            int i14 = i13 << 4;
                            if (c10 >= '0' && c10 <= '9') {
                                i = c10 - '0';
                            } else if (c10 >= 'a' && c10 <= 'f') {
                                i = c10 - 'W';
                            } else {
                                if (c10 < 'A' || c10 > 'F') {
                                    O("Malformed Unicode escape \\u".concat(new String(cArr, this.f6951l, 4)));
                                    throw null;
                                }
                                i = c10 - '7';
                            }
                            i13 = i + i14;
                            i11++;
                        }
                        this.f6951l += 4;
                        return (char) i13;
                    }
                }
            }
            return c9;
        }
        if (this.f6962x == 3) {
            O("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.f6953n++;
        this.f6954o = i10;
        if (this.f6962x == 3) {
            O("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c9;
    }

    public final void K(char c9) {
        do {
            int i = this.f6951l;
            int i6 = this.f6952m;
            while (i < i6) {
                int i10 = i + 1;
                char c10 = this.f6950b[i];
                if (c10 == c9) {
                    this.f6951l = i10;
                    return;
                }
                if (c10 == '\\') {
                    this.f6951l = i10;
                    J();
                    i = this.f6951l;
                    i6 = this.f6952m;
                } else {
                    if (c10 == '\n') {
                        this.f6953n++;
                        this.f6954o = i10;
                    }
                    i = i10;
                }
            }
            this.f6951l = i;
        } while (i(1));
        O("Unterminated string");
        throw null;
    }

    public final void L() {
        char c9;
        do {
            if (this.f6951l >= this.f6952m && !i(1)) {
                return;
            }
            int i = this.f6951l;
            int i6 = i + 1;
            this.f6951l = i6;
            c9 = this.f6950b[i];
            if (c9 == '\n') {
                this.f6953n++;
                this.f6954o = i6;
                return;
            }
        } while (c9 != '\r');
    }

    public final void M() {
        do {
            int i = 0;
            while (true) {
                int i6 = this.f6951l + i;
                if (i6 < this.f6952m) {
                    char c9 = this.f6950b[i6];
                    if (c9 != '\t' && c9 != '\n' && c9 != '\f' && c9 != '\r' && c9 != ' ') {
                        if (c9 != '#') {
                            if (c9 != ',') {
                                if (c9 != '/' && c9 != '=') {
                                    if (c9 != '{' && c9 != '}' && c9 != ':') {
                                        if (c9 != ';') {
                                            switch (c9) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f6951l = i6;
                }
            }
            d();
            this.f6951l += i;
            return;
        } while (i(1));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void N() {
        int i = 0;
        do {
            int i6 = this.f6955p;
            if (i6 == 0) {
                i6 = e();
            }
            switch (i6) {
                case 1:
                    I(3);
                    i++;
                    this.f6955p = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.v[this.f6960u - 1] = null;
                    }
                    this.f6960u--;
                    i--;
                    this.f6955p = 0;
                    break;
                case 3:
                    I(1);
                    i++;
                    this.f6955p = 0;
                    break;
                case 4:
                    this.f6960u--;
                    i--;
                    this.f6955p = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f6955p = 0;
                    break;
                case 8:
                    K('\'');
                    this.f6955p = 0;
                    break;
                case 9:
                    K('\"');
                    this.f6955p = 0;
                    break;
                case 10:
                    M();
                    this.f6955p = 0;
                    break;
                case 12:
                    K('\'');
                    if (i == 0) {
                        this.v[this.f6960u - 1] = "<skipped>";
                    }
                    this.f6955p = 0;
                    break;
                case 13:
                    K('\"');
                    if (i == 0) {
                        this.v[this.f6960u - 1] = "<skipped>";
                    }
                    this.f6955p = 0;
                    break;
                case 14:
                    M();
                    if (i == 0) {
                        this.v[this.f6960u - 1] = "<skipped>";
                    }
                    this.f6955p = 0;
                    break;
                case 16:
                    this.f6951l += this.f6957r;
                    this.f6955p = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.f6961w;
        int i10 = this.f6960u - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public final void O(String str) {
        StringBuilder t9 = x.t(str);
        t9.append(s());
        t9.append("\nSee ");
        t9.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new c(t9.toString());
    }

    public final IllegalStateException P(String str) {
        String str2 = H() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder v = x.v("Expected ", str, " but was ");
        v.append(k.m(H()));
        v.append(s());
        v.append("\nSee ");
        v.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(v.toString());
    }

    public final void b() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i != 3) {
            throw P("BEGIN_ARRAY");
        }
        I(1);
        this.f6961w[this.f6960u - 1] = 0;
        this.f6955p = 0;
    }

    public final void c() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i != 1) {
            throw P("BEGIN_OBJECT");
        }
        I(3);
        this.f6955p = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6955p = 0;
        this.f6959t[0] = 8;
        this.f6960u = 1;
        this.f6949a.close();
    }

    public final void d() {
        if (this.f6962x == 1) {
            return;
        }
        O("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0214, code lost:
    
        if (r(r12) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a5, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0217, code lost:
    
        if (r5 != 2) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0219, code lost:
    
        if (r10 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x021f, code lost:
    
        if (r1 != Long.MIN_VALUE) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0221, code lost:
    
        if (r17 == 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0228, code lost:
    
        if (r1 != 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x022a, code lost:
    
        if (r17 != 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x022c, code lost:
    
        if (r17 == 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x022f, code lost:
    
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0230, code lost:
    
        r24.f6956q = r1;
        r24.f6951l += r7;
        r9 = 15;
        r24.f6955p = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0224, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x023c, code lost:
    
        if (r5 == r13) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x023f, code lost:
    
        if (r5 == 4) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0242, code lost:
    
        if (r5 != 7) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0244, code lost:
    
        r24.f6957r = r7;
        r9 = 16;
        r24.f6955p = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e() {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.e():int");
    }

    public final void f() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i != 4) {
            throw P("END_ARRAY");
        }
        int i6 = this.f6960u;
        this.f6960u = i6 - 1;
        int[] iArr = this.f6961w;
        int i10 = i6 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f6955p = 0;
    }

    public final void h() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i != 2) {
            throw P("END_OBJECT");
        }
        int i6 = this.f6960u;
        int i10 = i6 - 1;
        this.f6960u = i10;
        this.v[i10] = null;
        int[] iArr = this.f6961w;
        int i11 = i6 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f6955p = 0;
    }

    public final boolean i(int i) {
        int i6;
        int i10;
        int i11 = this.f6954o;
        int i12 = this.f6951l;
        this.f6954o = i11 - i12;
        int i13 = this.f6952m;
        char[] cArr = this.f6950b;
        if (i13 != i12) {
            int i14 = i13 - i12;
            this.f6952m = i14;
            System.arraycopy(cArr, i12, cArr, 0, i14);
        } else {
            this.f6952m = 0;
        }
        this.f6951l = 0;
        do {
            int i15 = this.f6952m;
            int read = this.f6949a.read(cArr, i15, cArr.length - i15);
            if (read == -1) {
                return false;
            }
            i6 = this.f6952m + read;
            this.f6952m = i6;
            if (this.f6953n == 0 && (i10 = this.f6954o) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.f6951l++;
                this.f6954o = i10 + 1;
                i++;
            }
        } while (i6 < i);
        return true;
    }

    public final String j(boolean z9) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i6 = this.f6960u;
            if (i >= i6) {
                return sb.toString();
            }
            int i10 = this.f6959t[i];
            switch (i10) {
                case 1:
                case 2:
                    int i11 = this.f6961w[i];
                    if (z9 && i11 > 0 && i == i6 - 1) {
                        i11--;
                    }
                    sb.append('[');
                    sb.append(i11);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.v[i];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    o.j(l.u(i10, "Unknown scope value: "));
                    return null;
            }
            i++;
        }
    }

    public final boolean n() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public final boolean r(char c9) {
        if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
            return false;
        }
        if (c9 != '#') {
            if (c9 == ',') {
                return false;
            }
            if (c9 != '/' && c9 != '=') {
                if (c9 == '{' || c9 == '}' || c9 == ':') {
                    return false;
                }
                if (c9 != ';') {
                    switch (c9) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        d();
        return false;
    }

    public final String s() {
        return " at line " + (this.f6953n + 1) + " column " + ((this.f6951l - this.f6954o) + 1) + " path " + j(false);
    }

    public final String toString() {
        return a.class.getSimpleName().concat(s());
    }

    public final boolean u() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 5) {
            this.f6955p = 0;
            int[] iArr = this.f6961w;
            int i6 = this.f6960u - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        }
        if (i != 6) {
            throw P("a boolean");
        }
        this.f6955p = 0;
        int[] iArr2 = this.f6961w;
        int i10 = this.f6960u - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return false;
    }

    public final double y() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 15) {
            this.f6955p = 0;
            int[] iArr = this.f6961w;
            int i6 = this.f6960u - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f6956q;
        }
        if (i == 16) {
            this.f6958s = new String(this.f6950b, this.f6951l, this.f6957r);
            this.f6951l += this.f6957r;
        } else if (i == 8 || i == 9) {
            this.f6958s = E(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f6958s = G();
        } else if (i != 11) {
            throw P("a double");
        }
        this.f6955p = 11;
        double parseDouble = Double.parseDouble(this.f6958s);
        if (this.f6962x != 1 && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            O("JSON forbids NaN and infinities: " + parseDouble);
            throw null;
        }
        this.f6958s = null;
        this.f6955p = 0;
        int[] iArr2 = this.f6961w;
        int i10 = this.f6960u - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return parseDouble;
    }

    public final int z() {
        int i = this.f6955p;
        if (i == 0) {
            i = e();
        }
        if (i == 15) {
            long j = this.f6956q;
            int i6 = (int) j;
            if (j == i6) {
                this.f6955p = 0;
                int[] iArr = this.f6961w;
                int i10 = this.f6960u - 1;
                iArr[i10] = iArr[i10] + 1;
                return i6;
            }
            throw new NumberFormatException("Expected an int but was " + this.f6956q + s());
        }
        if (i == 16) {
            this.f6958s = new String(this.f6950b, this.f6951l, this.f6957r);
            this.f6951l += this.f6957r;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw P("an int");
            }
            if (i == 10) {
                this.f6958s = G();
            } else {
                this.f6958s = E(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f6958s);
                this.f6955p = 0;
                int[] iArr2 = this.f6961w;
                int i11 = this.f6960u - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6955p = 11;
        double parseDouble = Double.parseDouble(this.f6958s);
        int i12 = (int) parseDouble;
        if (i12 == parseDouble) {
            this.f6958s = null;
            this.f6955p = 0;
            int[] iArr3 = this.f6961w;
            int i13 = this.f6960u - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return i12;
        }
        throw new NumberFormatException("Expected an int but was " + this.f6958s + s());
    }
}
