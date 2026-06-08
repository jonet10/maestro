package h0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static h f5415c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5416a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f5417b;

    public h(Context context) {
        this.f5416a = context.getApplicationContext();
    }

    public static h a(Context context) {
        y.g(context);
        synchronized (h.class) {
            try {
                if (f5415c == null) {
                    p.a(context);
                    f5415c = new h(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5415c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f6, code lost:
    
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.pm.PackageInfo r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.h.c(android.content.pm.PackageInfo, boolean):boolean");
    }

    public static l d(PackageInfo packageInfo, l... lVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            m mVar = new m(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < lVarArr.length; i++) {
                if (lVarArr[i].equals(mVar)) {
                    return lVarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.h.b(int):boolean");
    }
}
