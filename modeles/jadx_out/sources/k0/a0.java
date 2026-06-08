package k0;

import android.net.Uri;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f6834a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent a(android.content.Context r5, k0.h0 r6) {
        /*
            java.lang.String r0 = "ServiceBindIntentUtils"
            java.lang.String r1 = r6.f6880a
            r2 = 0
            if (r1 != 0) goto L11
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            android.content.Intent r5 = r5.setComponent(r2)
            return r5
        L11:
            boolean r3 = r6.f6882c
            if (r3 == 0) goto La1
            java.lang.String r3 = "serviceActionBundleKey"
            android.os.Bundle r3 = k0.k.e(r3, r1)
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            android.net.Uri r4 = k0.a0.f6834a     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            if (r5 == 0) goto L3a
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r3 = r5.call(r4, r2, r3)     // Catch: java.lang.Throwable -> L35
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            goto L50
        L31:
            r5 = move-exception
            goto L42
        L33:
            r5 = move-exception
            goto L42
        L35:
            r3 = move-exception
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            throw r3     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
        L3a:
            android.os.RemoteException r5 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            java.lang.String r3 = "Failed to acquire ContentProviderClient"
            r5.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
            throw r5     // Catch: java.lang.IllegalArgumentException -> L31 android.os.RemoteException -> L33
        L42:
            java.lang.String r3 = "Dynamic intent resolution failed: "
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r3.concat(r5)
            android.util.Log.w(r0, r5)
            r3 = r2
        L50:
            if (r3 != 0) goto L53
            goto L69
        L53:
            java.lang.String r5 = "serviceResponseIntentKey"
            android.os.Parcelable r5 = r3.getParcelable(r5)
            android.content.Intent r5 = (android.content.Intent) r5
            if (r5 == 0) goto L5f
            r2 = r5
            goto L69
        L5f:
            java.lang.String r5 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r5 = r3.getParcelable(r5)
            android.app.PendingIntent r5 = (android.app.PendingIntent) r5
            if (r5 != 0) goto L75
        L69:
            if (r2 != 0) goto La1
            java.lang.String r5 = "Dynamic lookup for intent failed for action: "
            java.lang.String r5 = r5.concat(r1)
            android.util.Log.w(r0, r5)
            goto La1
        L75:
            int r6 = r1.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r6 = r6 + 72
            r3.<init>(r6)
            java.lang.String r6 = "Dynamic lookup for intent failed for action "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r6 = " but has possible resolution"
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            android.util.Log.w(r0, r6)
            k0.z r6 = new k0.z
            h0.b r0 = new h0.b
            r1 = 25
            r0.<init>(r2, r5, r1)
            r6.<init>(r0)
            throw r6
        La1:
            if (r2 != 0) goto Laf
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r1)
            java.lang.String r6 = r6.f6881b
            android.content.Intent r5 = r5.setPackage(r6)
            return r5
        Laf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.a0.a(android.content.Context, k0.h0):android.content.Intent");
    }
}
