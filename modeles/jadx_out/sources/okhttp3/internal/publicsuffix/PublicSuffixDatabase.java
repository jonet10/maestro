package okhttp3.internal.publicsuffix;

import com.google.android.gms.internal.measurement.i5;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import n8.c;
import w8.a0;
import w8.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f8385e = {42};
    public static final String[] f = new String[0];
    public static final String[] g = {"*"};
    public static final PublicSuffixDatabase h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f8386a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f8387b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f8388c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f8389d;

    public static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i6;
        boolean z9;
        int i10;
        int i11;
        int length = bArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = (i12 + length) / 2;
            while (i13 > -1 && bArr[i13] != 10) {
                i13--;
            }
            int i14 = i13 + 1;
            int i15 = 1;
            while (true) {
                i6 = i14 + i15;
                if (bArr[i6] == 10) {
                    break;
                }
                i15++;
            }
            int i16 = i6 - i14;
            int i17 = i;
            boolean z10 = false;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (z10) {
                    i10 = 46;
                    z9 = false;
                } else {
                    z9 = z10;
                    i10 = bArr2[i17][i18] & 255;
                }
                i11 = i10 - (bArr[i14 + i19] & 255);
                if (i11 == 0) {
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (bArr2[i17].length != i18) {
                        z10 = z9;
                    } else {
                        if (i17 == bArr2.length - 1) {
                            break;
                        }
                        i17++;
                        i18 = -1;
                        z10 = true;
                    }
                } else {
                    break;
                }
            }
            if (i11 >= 0) {
                if (i11 <= 0) {
                    int i20 = i16 - i19;
                    int length2 = bArr2[i17].length - i18;
                    while (true) {
                        i17++;
                        if (i17 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i17].length;
                    }
                    if (length2 >= i20) {
                        if (length2 <= i20) {
                            return new String(bArr, i14, i16, c.f8117d);
                        }
                    }
                }
                i12 = i6 + 1;
            }
            length = i13;
        }
        return null;
    }

    public final void b() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        a0 a0Var = new a0(new s(i5.M(resourceAsStream)));
        try {
            byte[] bArr = new byte[a0Var.readInt()];
            a0Var.e(bArr);
            byte[] bArr2 = new byte[a0Var.readInt()];
            a0Var.e(bArr2);
            synchronized (this) {
                this.f8388c = bArr;
                this.f8389d = bArr2;
            }
            this.f8387b.countDown();
        } finally {
            c.c(a0Var);
        }
    }
}
