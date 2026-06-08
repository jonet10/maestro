package z4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static String f11959a;

    /* renamed from: b, reason: collision with root package name */
    public static long f11960b;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data;
        context.getClass();
        intent.getClass();
        String action = intent.getAction();
        if (action == null || !action.equalsIgnoreCase("android.intent.action.PACKAGE_REPLACED") || (data = intent.getData()) == null) {
            return;
        }
        String schemeSpecificPart = data.getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (schemeSpecificPart == null || !booleanExtra) {
            return;
        }
        String concat = action.concat(schemeSpecificPart);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z9 = !concat.equalsIgnoreCase(f11959a) || currentTimeMillis - f11960b > 2000;
        f11960b = currentTimeMillis;
        f11959a = concat;
        if (!z9 || u.m0(j5.a.b(context, schemeSpecificPart), context.getPackageName(), true)) {
            return;
        }
        a5.a.f191a.n(schemeSpecificPart);
    }
}
