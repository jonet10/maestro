package androidx.savedstate.serialization.serializers;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import b2.t1;
import b8.e;
import c8.f;
import kotlin.jvm.internal.l;
import s1.o;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateSerializer implements b {
    public static final SavedStateSerializer INSTANCE = new SavedStateSerializer();
    private static final e descriptor = t1.n("androidx.savedstate.SavedState", new e[0]);

    private SavedStateSerializer() {
    }

    @Override // z7.a
    public Bundle deserialize(c8.e eVar) {
        eVar.getClass();
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return l.a(savedStateDecoder.getKey$savedstate(), "") ? savedStateDecoder.getSavedState$savedstate() : SavedStateReader.m154getSavedStateimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate()), savedStateDecoder.getKey$savedstate());
        }
        o.o(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar));
        return null;
    }

    @Override // z7.h, z7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public void serialize(f fVar, Bundle bundle) {
        fVar.getClass();
        bundle.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            o.o(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar));
            return;
        }
        SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
        if (l.a(savedStateEncoder.getKey$savedstate(), "")) {
            SavedStateWriter.m187putAllimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate()), bundle);
        } else {
            SavedStateWriter.m210putSavedStateimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate()), savedStateEncoder.getKey$savedstate(), bundle);
        }
    }
}
