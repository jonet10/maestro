package a4;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends n0 {

    /* renamed from: b, reason: collision with root package name */
    public static final UriMatcher f122b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f123a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f122b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public j(Context context) {
        this.f123a = context;
    }

    @Override // a4.n0
    public final boolean b(k0 k0Var) {
        Uri uri = (Uri) k0Var.f127b;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f122b.match(uri) != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @Override // a4.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a4.m0 e(a4.k0 r6, int r7) {
        /*
            r5 = this;
            android.content.Context r7 = r5.f123a
            android.content.ContentResolver r7 = r7.getContentResolver()
            java.lang.Object r6 = r6.f127b
            android.net.Uri r6 = (android.net.Uri) r6
            android.content.UriMatcher r0 = a4.j.f122b
            int r0 = r0.match(r6)
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L2a
            if (r0 == r1) goto L25
            r4 = 3
            if (r0 == r4) goto L32
            r3 = 4
            if (r0 != r3) goto L1e
            goto L25
        L1e:
            java.lang.String r7 = "Invalid uri: "
            a3.b.l(r6, r7)
            r6 = 0
            return r6
        L25:
            java.io.InputStream r6 = r7.openInputStream(r6)
            goto L36
        L2a:
            android.net.Uri r6 = android.provider.ContactsContract.Contacts.lookupContact(r7, r6)
            if (r6 != 0) goto L32
            r6 = r2
            goto L36
        L32:
            java.io.InputStream r6 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r7, r6, r3)
        L36:
            if (r6 != 0) goto L39
            return r2
        L39:
            a4.m0 r7 = new a4.m0
            w8.c r6 = com.google.android.gms.internal.measurement.i5.M(r6)
            r7.<init>(r6, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.j.e(a4.k0, int):a4.m0");
    }
}
