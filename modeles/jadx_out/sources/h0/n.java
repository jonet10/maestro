package h0;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5427a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5428b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f5429c;

    public /* synthetic */ n(boolean z9, String str, m mVar) {
        this.f5427a = z9;
        this.f5428b = str;
        this.f5429c = mVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        boolean z9 = this.f5427a;
        String str = this.f5428b;
        m mVar = this.f5429c;
        String str2 = (z9 || !p.c(str, mVar, true, false).f5445a) ? "not allowed" : "debug cert rejected";
        int i = 0;
        while (true) {
            if (i >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                break;
            }
            i++;
        }
        y.g(messageDigest);
        byte[] digest = messageDigest.digest(mVar.f5426k);
        int length = digest.length;
        char[] cArr = new char[length + length];
        int i6 = 0;
        for (byte b7 : digest) {
            char[] cArr2 = p0.b.f8405b;
            cArr[i6] = cArr2[(b7 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b7 & 15];
            i6 += 2;
        }
        return str2 + ": pkg=" + str + ", sha256=" + new String(cArr) + ", atk=" + z9 + ", ver=12451000.false";
    }
}
