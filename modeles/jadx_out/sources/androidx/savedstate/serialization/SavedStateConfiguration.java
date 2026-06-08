package androidx.savedstate.serialization;

import g8.d;
import g8.f;
import g8.i;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateConfiguration {
    public static final Companion Companion = new Companion(null);
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final f serializersModule;

    public /* synthetic */ SavedStateConfiguration(f fVar, int i, boolean z9, int i6, g gVar) {
        this((i6 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : fVar, (i6 & 2) != 0 ? 2 : i, (i6 & 4) != 0 ? false : z9);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final f getSerializersModule() {
        return this.serializersModule;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private f serializersModule;

        public Builder(SavedStateConfiguration savedStateConfiguration) {
            savedStateConfiguration.getClass();
            this.serializersModule = savedStateConfiguration.getSerializersModule();
            this.encodeDefaults = savedStateConfiguration.getEncodeDefaults();
            this.classDiscriminatorMode = savedStateConfiguration.getClassDiscriminatorMode();
        }

        public final SavedStateConfiguration build$savedstate() {
            f fVar;
            fVar = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
            f fVar2 = this.serializersModule;
            d dVar = i.f5387a;
            fVar.getClass();
            fVar2.getClass();
            g8.g gVar = new g8.g();
            fVar.a(gVar);
            fVar2.a(new g5.f(gVar, 1));
            return new SavedStateConfiguration(gVar.c(), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final f getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int i) {
            this.classDiscriminatorMode = i;
        }

        public final void setEncodeDefaults(boolean z9) {
            this.encodeDefaults = z9;
        }

        public final void setSerializersModule(f fVar) {
            fVar.getClass();
            this.serializersModule = fVar;
        }

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }
    }

    private SavedStateConfiguration(f fVar, int i, boolean z9) {
        this.serializersModule = fVar;
        this.classDiscriminatorMode = i;
        this.encodeDefaults = z9;
    }

    public /* synthetic */ SavedStateConfiguration(f fVar, int i, boolean z9, g gVar) {
        this(fVar, i, z9);
    }
}
