package a2;

import android.net.Uri;
import com.google.android.gms.internal.measurement.n4;
import f8.b0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f22a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f23b;

    public /* synthetic */ i(Object obj) {
        this.f23b = obj;
        this.f22a = true;
    }

    @Override // a2.l
    public void a(k kVar, int i) {
        StringBuilder sb = (StringBuilder) this.f23b;
        if (this.f22a) {
            this.f22a = false;
        } else {
            sb.append(", ");
        }
        sb.append(i);
    }

    public void b() {
        this.f22a = false;
    }

    public void c(byte b7) {
        ((f8.q) this.f23b).i(String.valueOf(b7));
    }

    public void d(char c9) {
        f8.q qVar = (f8.q) this.f23b;
        qVar.b(qVar.f4964b, 1);
        char[] cArr = (char[]) qVar.f4965c;
        int i = qVar.f4964b;
        qVar.f4964b = i + 1;
        cArr[i] = c9;
    }

    public void e(int i) {
        ((f8.q) this.f23b).i(String.valueOf(i));
    }

    public void f(long j) {
        ((f8.q) this.f23b).i(String.valueOf(j));
    }

    public void g(short s6) {
        ((f8.q) this.f23b).i(String.valueOf(s6));
    }

    public void h(String str) {
        int i;
        str.getClass();
        f8.q qVar = (f8.q) this.f23b;
        qVar.b(qVar.f4964b, str.length() + 2);
        char[] cArr = (char[]) qVar.f4965c;
        int i6 = qVar.f4964b;
        int i10 = i6 + 1;
        cArr[i6] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        int i11 = length + i10;
        int i12 = i10;
        while (i12 < i11) {
            char c9 = cArr[i12];
            byte[] bArr = b0.f4937b;
            if (c9 < bArr.length && bArr[c9] != 0) {
                int length2 = str.length();
                for (int i13 = i12 - i10; i13 < length2; i13++) {
                    qVar.b(i12, 2);
                    char charAt = str.charAt(i13);
                    byte[] bArr2 = b0.f4937b;
                    if (charAt < bArr2.length) {
                        byte b7 = bArr2[charAt];
                        if (b7 == 0) {
                            i = i12 + 1;
                            ((char[]) qVar.f4965c)[i12] = charAt;
                        } else {
                            if (b7 == 1) {
                                String str2 = b0.f4936a[charAt];
                                str2.getClass();
                                qVar.b(i12, str2.length());
                                str2.getChars(0, str2.length(), (char[]) qVar.f4965c, i12);
                                int length3 = str2.length() + i12;
                                qVar.f4964b = length3;
                                i12 = length3;
                            } else {
                                char[] cArr2 = (char[]) qVar.f4965c;
                                cArr2[i12] = '\\';
                                cArr2[i12 + 1] = (char) b7;
                                i12 += 2;
                                qVar.f4964b = i12;
                            }
                        }
                    } else {
                        i = i12 + 1;
                        ((char[]) qVar.f4965c)[i12] = charAt;
                    }
                    i12 = i;
                }
                qVar.b(i12, 1);
                ((char[]) qVar.f4965c)[i12] = '\"';
                qVar.f4964b = i12 + 1;
                return;
            }
            i12++;
        }
        cArr[i11] = '\"';
        qVar.f4964b = i11 + 1;
    }

    public n4 k(long j, String str) {
        Long valueOf = Long.valueOf(j);
        Object obj = n4.g;
        return new n4(this, str, valueOf, 0);
    }

    public n4 l(String str, boolean z9) {
        Boolean valueOf = Boolean.valueOf(z9);
        Object obj = n4.g;
        return new n4(this, str, valueOf, 1);
    }

    public n4 m(String str, String str2) {
        Object obj = n4.g;
        return new n4(this, str, str2, 3);
    }

    public i(Uri uri, boolean z9, boolean z10) {
        this.f23b = uri;
        this.f22a = z9;
    }

    public void i() {
    }

    public void j() {
    }
}
