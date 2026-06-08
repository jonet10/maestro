package androidx.work;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DelegatingWorkerFactory extends WorkerFactory {
    private final List<WorkerFactory> factories = new CopyOnWriteArrayList();

    public final void addFactory(WorkerFactory workerFactory) {
        workerFactory.getClass();
        this.factories.add(workerFactory);
    }

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        String str2;
        context.getClass();
        str.getClass();
        workerParameters.getClass();
        Iterator<T> it = this.factories.iterator();
        while (it.hasNext()) {
            try {
                ListenableWorker createWorker = ((WorkerFactory) it.next()).createWorker(context, str, workerParameters);
                if (createWorker != null) {
                    return createWorker;
                }
            } catch (Throwable th) {
                Logger logger = Logger.get();
                str2 = DelegatingWorkerFactoryKt.TAG;
                logger.error(str2, "Unable to instantiate a ListenableWorker (" + str + ')', th);
                throw th;
            }
        }
        return null;
    }
}
