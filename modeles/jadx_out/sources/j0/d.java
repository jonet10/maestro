package j0;

import a4.c0;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends c0 {
    @Override // a4.c0, android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("BasePendingResult", androidx.lifecycle.l.u(i, "Don't know how to handle message: "), new Exception());
                return;
            } else {
                ((BasePendingResult) message.obj).c(Status.f2472q);
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        if (pair.first != null) {
            com.google.gson.internal.a.o();
            return;
        }
        try {
            throw null;
        } catch (RuntimeException e10) {
            a4.d dVar = BasePendingResult.j;
            throw e10;
        }
    }
}
