package x0;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import j0.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c extends ContextCompat {
    public static void a(Context context, p pVar, IntentFilter intentFilter) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            context.registerReceiver(pVar, intentFilter, i >= 33 ? 2 : 0);
        } else {
            context.registerReceiver(pVar, intentFilter);
        }
    }
}
