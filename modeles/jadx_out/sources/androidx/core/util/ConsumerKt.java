package androidx.core.util;

import androidx.annotation.RequiresApi;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(24)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(c cVar) {
        return new ContinuationConsumer(cVar);
    }
}
