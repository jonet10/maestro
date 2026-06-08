package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StopWorkRunnable implements Runnable {
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;
    private final StartStopToken token;

    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z9, int i) {
        processor.getClass();
        startStopToken.getClass();
        this.processor = processor;
        this.token = startStopToken;
        this.stopInForeground = z9;
        this.reason = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z9 = this.stopInForeground;
        Processor processor = this.processor;
        boolean stopForegroundWork = z9 ? processor.stopForegroundWork(this.token, this.reason) : processor.stopWork(this.token, this.reason);
        Logger.get().debug(Logger.tagWithPrefix("StopWorkRunnable"), "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + stopForegroundWork);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z9) {
        this(processor, startStopToken, z9, WorkInfo.STOP_REASON_UNKNOWN);
        processor.getClass();
        startStopToken.getClass();
    }
}
