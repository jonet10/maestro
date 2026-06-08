package androidx.window.core;

import androidx.window.core.SpecificationComputer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BuildConfig {
    public static final BuildConfig INSTANCE = new BuildConfig();
    private static final SpecificationComputer.VerificationMode verificationMode = SpecificationComputer.VerificationMode.QUIET;

    private BuildConfig() {
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return verificationMode;
    }
}
