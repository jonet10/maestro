package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import b8.e;
import c8.a;
import c8.c;
import g8.f;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateDecoder extends a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;

    public SavedStateDecoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        bundle.getClass();
        savedStateConfiguration.getClass();
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.key = "";
    }

    @Override // c8.a, c8.e
    public c beginStructure(e eVar) {
        eVar.getClass();
        return l.a(this.key, "") ? this : new SavedStateDecoder(SavedStateReader.m154getSavedStateimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // c8.a, c8.e
    public boolean decodeBoolean() {
        return SavedStateReader.m106getBooleanimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public byte decodeByte() {
        return (byte) SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public char decodeChar() {
        return SavedStateReader.m110getCharimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public double decodeDouble() {
        return SavedStateReader.m120getDoubleimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        r3.key = r1;
        r4 = r3.index;
        r3.index = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        return r4;
     */
    @Override // c8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int decodeElementIndex(b8.e r4) {
        /*
            r3 = this;
            r4.getClass()
            com.google.android.gms.internal.measurement.z3 r0 = r4.getKind()
            b8.i r1 = b8.i.i
            boolean r0 = kotlin.jvm.internal.l.a(r0, r1)
            if (r0 != 0) goto L21
            com.google.android.gms.internal.measurement.z3 r0 = r4.getKind()
            b8.i r1 = b8.i.j
            boolean r0 = kotlin.jvm.internal.l.a(r0, r1)
            if (r0 == 0) goto L1c
            goto L21
        L1c:
            int r0 = r4.e()
            goto L2b
        L21:
            android.os.Bundle r0 = r3.savedState
            android.os.Bundle r0 = androidx.savedstate.SavedStateReader.m97constructorimpl(r0)
            int r0 = androidx.savedstate.SavedStateReader.m177sizeimpl(r0)
        L2b:
            int r1 = r3.index
            if (r1 >= r0) goto L57
            java.lang.String r1 = r4.f(r1)
            int r2 = r3.index
            boolean r2 = r4.i(r2)
            if (r2 == 0) goto L4e
            android.os.Bundle r2 = r3.savedState
            android.os.Bundle r2 = androidx.savedstate.SavedStateReader.m97constructorimpl(r2)
            boolean r2 = androidx.savedstate.SavedStateReader.m98containsimpl(r2, r1)
            if (r2 != 0) goto L4e
            int r1 = r3.index
            int r1 = r1 + 1
            r3.index = r1
            goto L2b
        L4e:
            r3.key = r1
            int r4 = r3.index
            int r0 = r4 + 1
            r3.index = r0
            return r4
        L57:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.savedstate.serialization.SavedStateDecoder.decodeElementIndex(b8.e):int");
    }

    @Override // c8.a
    public int decodeEnum(e eVar) {
        eVar.getClass();
        return SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public float decodeFloat() {
        return SavedStateReader.m124getFloatimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public int decodeInt() {
        return SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public long decodeLong() {
        return SavedStateReader.m138getLongimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m176isNullimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c8.a, c8.e
    public <T> T decodeSerializableValue(z7.a aVar) {
        aVar.getClass();
        T t9 = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, aVar);
        if (t9 != null) {
            return t9;
        }
        e descriptor = aVar.getDescriptor();
        return l.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor()) ? (T) SavedStateReader.m131getIntListimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor()) ? (T) SavedStateReader.m171getStringListimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor()) ? (T) SavedStateReader.m107getBooleanArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor()) ? (T) SavedStateReader.m111getCharArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor()) ? (T) SavedStateReader.m121getDoubleArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor()) ? (T) SavedStateReader.m125getFloatArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor()) ? (T) SavedStateReader.m129getIntArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor()) ? (T) SavedStateReader.m139getLongArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : l.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor()) ? (T) SavedStateReader.m169getStringArrayimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key) : (T) super.decodeSerializableValue(aVar);
    }

    @Override // c8.a, c8.e
    public short decodeShort() {
        return (short) SavedStateReader.m128getIntimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    @Override // c8.a, c8.e
    public String decodeString() {
        return SavedStateReader.m168getStringimpl(SavedStateReader.m97constructorimpl(this.savedState), this.key);
    }

    public final String getKey$savedstate() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate() {
        return this.savedState;
    }

    @Override // c8.c
    public f getSerializersModule() {
        return this.configuration.getSerializersModule();
    }
}
