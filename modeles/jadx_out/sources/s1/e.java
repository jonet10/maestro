package s1;

import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e implements s2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9120a;

    public /* synthetic */ e(int i) {
        this.f9120a = i;
    }

    @Override // s2.b
    public final Object get() {
        switch (this.f9120a) {
            case 0:
                return Collections.EMPTY_SET;
            case 1:
                return null;
            case 2:
                return ExecutorsRegistrar.a();
            case 3:
                m mVar = ExecutorsRegistrar.f3073a;
                return new t1.f(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new t1.a("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f3076d.get());
            case 4:
                m mVar2 = ExecutorsRegistrar.f3073a;
                return new t1.f(Executors.newCachedThreadPool(new t1.a("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f3076d.get());
            default:
                m mVar3 = ExecutorsRegistrar.f3073a;
                return Executors.newSingleThreadScheduledExecutor(new t1.a("Firebase Scheduler", 0, null));
        }
    }
}
