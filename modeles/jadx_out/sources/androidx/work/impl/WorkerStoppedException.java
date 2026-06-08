package androidx.work.impl;

import androidx.annotation.RestrictTo;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerStoppedException extends CancellationException {
    private final int reason;

    public WorkerStoppedException(int i) {
        this.reason = i;
    }

    public final int getReason() {
        return this.reason;
    }
}
