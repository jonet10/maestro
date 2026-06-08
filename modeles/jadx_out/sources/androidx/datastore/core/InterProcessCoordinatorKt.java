package androidx.datastore.core;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InterProcessCoordinatorKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final InterProcessCoordinator createSingleProcessCoordinator(String str) {
        str.getClass();
        return new SingleProcessCoordinator(str);
    }
}
