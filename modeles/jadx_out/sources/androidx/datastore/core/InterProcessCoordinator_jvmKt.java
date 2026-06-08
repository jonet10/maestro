package androidx.datastore.core;

import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InterProcessCoordinator_jvmKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(File file) {
        file.getClass();
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        absolutePath.getClass();
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(absolutePath);
    }
}
