package f8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4936a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f4937b;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u" + b(i >> 12) + b(i >> 8) + b(i >> 4) + b(i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f4936a = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f4937b = bArr;
    }

    public static final void a(String str, StringBuilder sb) {
        str.getClass();
        sb.append('\"');
        int length = str.length();
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            String[] strArr = f4936a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append((CharSequence) str, i, i6);
                sb.append(strArr[charAt]);
                i = i6 + 1;
            }
        }
        if (i != 0) {
            sb.append((CharSequence) str, i, str.length());
        } else {
            sb.append(str);
        }
        sb.append('\"');
    }

    public static final char b(int i) {
        int i6 = i & 15;
        return (char) (i6 < 10 ? i6 + 48 : i6 + 87);
    }
}
