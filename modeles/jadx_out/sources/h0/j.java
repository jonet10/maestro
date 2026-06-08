package h0;

import a4.c0;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.PendingIntentCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public final Context f5421b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f5422c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 4);
        this.f5422c = eVar;
        this.f5421b = context.getApplicationContext();
    }

    @Override // a4.c0, android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            androidx.lifecycle.l.z(i, "Don't know how to handle this message: ", "GoogleApiAvailability");
            return;
        }
        int i6 = f.f5408a;
        e eVar = this.f5422c;
        Context context = this.f5421b;
        int b7 = eVar.b(context, i6);
        AtomicBoolean atomicBoolean = g.f5410a;
        if (b7 == 1 || b7 == 2 || b7 == 3 || b7 == 9) {
            Intent a8 = eVar.a(context, b7, "n");
            eVar.f(context, b7, a8 == null ? null : PendingIntentCompat.getActivity(context, 0, a8, 134217728, false));
        }
    }
}
