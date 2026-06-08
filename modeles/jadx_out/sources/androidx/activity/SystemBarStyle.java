package androidx.activity;

import androidx.annotation.ColorInt;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    private SystemBarStyle(int i, int i6, int i10, l lVar) {
        this.lightScrim = i;
        this.darkScrim = i6;
        this.nightMode = i10;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6) {
        return Companion.auto(i, i6);
    }

    public static final SystemBarStyle dark(@ColorInt int i) {
        return Companion.dark(i);
    }

    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i6) {
        return Companion.light(i, i6);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z9) {
        return z9 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z9) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z9 ? this.darkScrim : this.lightScrim;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i6, l lVar, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i, i6, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6, l lVar) {
            lVar.getClass();
            return new SystemBarStyle(i, i6, 0, lVar, null);
        }

        public final SystemBarStyle dark(@ColorInt int i) {
            return new SystemBarStyle(i, i, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        public final SystemBarStyle light(@ColorInt int i, @ColorInt int i6) {
            return new SystemBarStyle(i, i6, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6) {
            return auto$default(this, i, i6, null, 4, null);
        }
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i6, l lVar) {
        return Companion.auto(i, i6, lVar);
    }

    public /* synthetic */ SystemBarStyle(int i, int i6, int i10, l lVar, kotlin.jvm.internal.g gVar) {
        this(i, i6, i10, lVar);
    }
}
