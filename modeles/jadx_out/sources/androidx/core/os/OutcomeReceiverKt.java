package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(31)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver asOutcomeReceiver(c cVar) {
        return new ContinuationOutcomeReceiver(cVar);
    }
}
