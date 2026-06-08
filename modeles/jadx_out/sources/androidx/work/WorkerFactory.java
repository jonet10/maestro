package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class WorkerFactory {
    private static final ListenableWorker createWorkerWithDefaultFallback$fallbackToReflection(Context context, String str, WorkerParameters workerParameters) {
        String str2;
        try {
            ListenableWorker newInstance = createWorkerWithDefaultFallback$getWorkerClass(str).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            newInstance.getClass();
            return newInstance;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Could not instantiate " + str, th);
            throw th;
        }
    }

    private static final Class<? extends ListenableWorker> createWorkerWithDefaultFallback$getWorkerClass(String str) {
        String str2;
        try {
            Class asSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            asSubclass.getClass();
            return asSubclass;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Invalid class: " + str, th);
            throw th;
        }
    }

    public abstract ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        context.getClass();
        str.getClass();
        workerParameters.getClass();
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker == null) {
            createWorker = createWorkerWithDefaultFallback$fallbackToReflection(context, str, workerParameters);
        }
        if (!createWorker.isUsed()) {
            return createWorker;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.k("WorkerFactory (", getClass().getName(), ") returned an instance of a ListenableWorker (", str, ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
        return null;
    }
}
