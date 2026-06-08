package androidx.work.impl;

import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkLauncherImpl implements WorkLauncher {
    private final Processor processor;
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(Processor processor, TaskExecutor taskExecutor) {
        processor.getClass();
        taskExecutor.getClass();
        this.processor = processor;
        this.workTaskExecutor = taskExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$0(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        workLauncherImpl.processor.startWork(startStopToken, runtimeExtras);
    }

    public final Processor getProcessor() {
        return this.processor;
    }

    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    @Override // androidx.work.impl.WorkLauncher
    public void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        startStopToken.getClass();
        this.workTaskExecutor.executeOnTaskThread(new c(this, startStopToken, runtimeExtras, 1));
    }

    @Override // androidx.work.impl.WorkLauncher
    public void stopWork(StartStopToken startStopToken, int i) {
        startStopToken.getClass();
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, startStopToken, false, i));
    }

    @Override // androidx.work.impl.WorkLauncher
    public final void stopWorkWithReason(StartStopToken startStopToken, int i) {
        startStopToken.getClass();
        stopWork(startStopToken, i);
    }

    @Override // androidx.work.impl.WorkLauncher
    public final void startWork(StartStopToken startStopToken) {
        startStopToken.getClass();
        startWork(startStopToken, null);
    }

    @Override // androidx.work.impl.WorkLauncher
    public final void stopWork(StartStopToken startStopToken) {
        startStopToken.getClass();
        stopWork(startStopToken, WorkInfo.STOP_REASON_UNKNOWN);
    }
}
