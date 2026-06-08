package g0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f5102a;

    /* renamed from: b, reason: collision with root package name */
    public int f5103b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5104c;

    public o(int i, int i6) {
        this.f5104c = null;
        this.f5102a = i;
        int i10 = i6 & 7;
        this.f5103b = i10 == 0 ? 8 : i10;
    }

    public synchronized int a() {
        PackageInfo packageInfo;
        if (this.f5102a == 0) {
            try {
                packageInfo = r0.c.a((Context) this.f5104c).b(0, "com.google.android.gms");
            } catch (PackageManager.NameNotFoundException e10) {
                Log.w("Metadata", "Failed to find package ".concat(e10.toString()));
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f5102a = packageInfo.versionCode;
            }
        }
        return this.f5102a;
    }

    public synchronized int b() {
        int i = this.f5103b;
        if (i != 0) {
            return i;
        }
        Context context = (Context) this.f5104c;
        PackageManager packageManager = context.getPackageManager();
        if (r0.c.a(context).f8855a.getPackageManager().checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i6 = 1;
        if (!p0.b.a()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                this.f5103b = i6;
                return i6;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
            i6 = 2;
            this.f5103b = i6;
            return i6;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (true == p0.b.a()) {
            i6 = 2;
        }
        this.f5103b = i6;
        return i6;
    }

    public o() {
        this.f5104c = new o[256];
        this.f5102a = 0;
        this.f5103b = 0;
    }

    public o(Context context) {
        this.f5103b = 0;
        this.f5104c = context;
    }
}
