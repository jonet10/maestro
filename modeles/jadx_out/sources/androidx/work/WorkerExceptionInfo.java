package androidx.work;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerExceptionInfo {
    private final Throwable throwable;
    private final String workerClassName;
    private final WorkerParameters workerParameters;

    public WorkerExceptionInfo(String str, WorkerParameters workerParameters, Throwable th) {
        str.getClass();
        workerParameters.getClass();
        th.getClass();
        this.workerClassName = str;
        this.workerParameters = workerParameters;
        this.throwable = th;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    public final WorkerParameters getWorkerParameters() {
        return this.workerParameters;
    }
}
