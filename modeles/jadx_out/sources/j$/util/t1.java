package j$.util;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6461a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6462b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6463c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f6464d;

    /* renamed from: e, reason: collision with root package name */
    public int f6465e;
    public int f;

    public t1(CharSequence charSequence) {
        Objects.requireNonNull("", "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull("", "The suffix must not be null");
        this.f6461a = "";
        this.f6462b = charSequence.toString();
        this.f6463c = "";
    }

    public static int c(String str, char[] cArr, int i) {
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return length;
    }

    public final String toString() {
        String[] strArr = this.f6464d;
        int i = this.f6465e;
        String str = this.f6461a;
        int length = str.length();
        String str2 = this.f6463c;
        int length2 = str2.length() + length;
        if (length2 == 0) {
            b();
            return i == 0 ? "" : strArr[0];
        }
        char[] cArr = new char[this.f + length2];
        int c9 = c(str, cArr, 0);
        if (i > 0) {
            int c10 = c(strArr[0], cArr, c9) + c9;
            for (int i6 = 1; i6 < i; i6++) {
                int c11 = c(this.f6462b, cArr, c10) + c10;
                c10 = c(strArr[i6], cArr, c11) + c11;
            }
            c9 = c10;
        }
        c(str2, cArr, c9);
        return new String(cArr);
    }

    public final void a(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        String[] strArr = this.f6464d;
        if (strArr == null) {
            this.f6464d = new String[8];
        } else {
            int i = this.f6465e;
            if (i == strArr.length) {
                this.f6464d = (String[]) Arrays.copyOf(strArr, i * 2);
            }
            this.f = this.f6462b.length() + this.f;
        }
        this.f = valueOf.length() + this.f;
        String[] strArr2 = this.f6464d;
        int i6 = this.f6465e;
        this.f6465e = i6 + 1;
        strArr2[i6] = valueOf;
    }

    public final void b() {
        String[] strArr;
        if (this.f6465e > 1) {
            char[] cArr = new char[this.f];
            int c9 = c(this.f6464d[0], cArr, 0);
            int i = 1;
            do {
                int c10 = c(this.f6462b, cArr, c9) + c9;
                c9 = c(this.f6464d[i], cArr, c10) + c10;
                strArr = this.f6464d;
                strArr[i] = null;
                i++;
            } while (i < this.f6465e);
            this.f6465e = 1;
            strArr[0] = new String(cArr);
        }
    }
}
