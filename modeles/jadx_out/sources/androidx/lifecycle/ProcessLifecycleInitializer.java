package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public LifecycleOwner create(Context context) {
        context.getClass();
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        if (!appInitializer.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        LifecycleDispatcher.init(context);
        ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
        companion.init$lifecycle_process(context);
        return companion.get();
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return t.f8724a;
    }
}
