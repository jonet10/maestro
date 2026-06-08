package androidx.savedstate.serialization;

import a4.x;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import b8.e;
import b8.i;
import c8.b;
import c8.d;
import com.google.gson.internal.a;
import g8.f;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.l;
import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateEncoder extends b {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;

    public SavedStateEncoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.key = "";
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, e eVar, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            if (l.a(eVar.getKind(), i.h) || l.a(eVar.getKind(), i.f1118k)) {
                SavedStateWriter.m216putStringimpl(SavedStateWriter.m183constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, eVar.a());
            }
        }
    }

    @Override // c8.b, c8.f
    public d beginStructure(e eVar) {
        eVar.getClass();
        if (l.a(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, eVar, this.savedState);
            return this;
        }
        p6.i[] iVarArr = new p6.i[0];
        Bundle bundleOf = BundleKt.bundleOf((p6.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleOf);
        SavedStateWriter.m210putSavedStateimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, bundleOf);
        putClassDiscriminatorIfRequired(this.configuration, eVar, bundleOf);
        return new SavedStateEncoder(bundleOf, this.configuration);
    }

    @Override // c8.b, c8.f
    public void encodeBoolean(boolean z9) {
        SavedStateWriter.m189putBooleanimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, z9);
    }

    @Override // c8.b, c8.f
    public void encodeByte(byte b7) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, b7);
    }

    @Override // c8.b, c8.f
    public void encodeChar(char c9) {
        SavedStateWriter.m191putCharimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, c9);
    }

    @Override // c8.b, c8.f
    public void encodeDouble(double d10) {
        SavedStateWriter.m196putDoubleimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, d10);
    }

    @Override // c8.b
    public boolean encodeElement(e eVar, int i) {
        eVar.getClass();
        this.key = eVar.f(i);
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean m98containsimpl = SavedStateReader.m98containsimpl(SavedStateReader.m97constructorimpl(this.savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            boolean a8 = l.a(this.key, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (m98containsimpl && a8) {
                a.p(x.n(x.v("SavedStateEncoder for ", SavedStateReader.m168getStringimpl(SavedStateReader.m97constructorimpl(this.savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY), " has property '"), this.key, "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation."));
                return false;
            }
        }
        return true;
    }

    public void encodeEnum(e eVar, int i) {
        eVar.getClass();
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, i);
    }

    @Override // c8.b, c8.f
    public void encodeFloat(float f) {
        SavedStateWriter.m198putFloatimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, f);
    }

    @Override // c8.b, c8.f
    public void encodeInt(int i) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, i);
    }

    @Override // c8.b, c8.f
    public void encodeLong(long j) {
        SavedStateWriter.m204putLongimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, j);
    }

    @Override // c8.f
    public void encodeNull() {
        SavedStateWriter.m206putNullimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c8.b, c8.f
    public <T> void encodeSerializableValue(h hVar, T t9) {
        hVar.getClass();
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, hVar, t9)) {
            return;
        }
        e descriptor = hVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            Bundle m183constructorimpl = SavedStateWriter.m183constructorimpl(this.savedState);
            String str = this.key;
            t9.getClass();
            SavedStateWriter.m202putIntListimpl(m183constructorimpl, str, (List) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            Bundle m183constructorimpl2 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str2 = this.key;
            t9.getClass();
            SavedStateWriter.m218putStringListimpl(m183constructorimpl2, str2, (List) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            Bundle m183constructorimpl3 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str3 = this.key;
            t9.getClass();
            SavedStateWriter.m190putBooleanArrayimpl(m183constructorimpl3, str3, (boolean[]) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            Bundle m183constructorimpl4 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str4 = this.key;
            t9.getClass();
            SavedStateWriter.m192putCharArrayimpl(m183constructorimpl4, str4, (char[]) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            Bundle m183constructorimpl5 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str5 = this.key;
            t9.getClass();
            SavedStateWriter.m197putDoubleArrayimpl(m183constructorimpl5, str5, (double[]) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            Bundle m183constructorimpl6 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str6 = this.key;
            t9.getClass();
            SavedStateWriter.m199putFloatArrayimpl(m183constructorimpl6, str6, (float[]) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            Bundle m183constructorimpl7 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str7 = this.key;
            t9.getClass();
            SavedStateWriter.m201putIntArrayimpl(m183constructorimpl7, str7, (int[]) t9);
            return;
        }
        if (l.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            Bundle m183constructorimpl8 = SavedStateWriter.m183constructorimpl(this.savedState);
            String str8 = this.key;
            t9.getClass();
            SavedStateWriter.m205putLongArrayimpl(m183constructorimpl8, str8, (long[]) t9);
            return;
        }
        if (!l.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            hVar.serialize(this, t9);
            return;
        }
        Bundle m183constructorimpl9 = SavedStateWriter.m183constructorimpl(this.savedState);
        String str9 = this.key;
        t9.getClass();
        SavedStateWriter.m217putStringArrayimpl(m183constructorimpl9, str9, (String[]) t9);
    }

    @Override // c8.b, c8.f
    public void encodeShort(short s6) {
        SavedStateWriter.m200putIntimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, s6);
    }

    @Override // c8.b, c8.f
    public void encodeString(String str) {
        str.getClass();
        SavedStateWriter.m216putStringimpl(SavedStateWriter.m183constructorimpl(this.savedState), this.key, str);
    }

    public final String getKey$savedstate() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate() {
        return this.savedState;
    }

    @Override // c8.f
    public f getSerializersModule() {
        return this.configuration.getSerializersModule();
    }

    @Override // c8.b, c8.d
    public boolean shouldEncodeElementDefault(e eVar, int i) {
        eVar.getClass();
        return this.configuration.getEncodeDefaults();
    }
}
