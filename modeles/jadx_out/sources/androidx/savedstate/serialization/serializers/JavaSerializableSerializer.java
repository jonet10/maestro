package androidx.savedstate.serialization.serializers;

import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import b2.t1;
import b8.e;
import c8.f;
import java.io.Serializable;
import kotlin.jvm.internal.y;
import s1.o;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class JavaSerializableSerializer<T extends Serializable> implements b {
    private final e descriptor = t1.n("java.io.Serializable", new e[0]);

    @Override // z7.a
    public final T deserialize(c8.e eVar) {
        eVar.getClass();
        if (!(eVar instanceof SavedStateDecoder)) {
            o.o(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.a(), eVar));
            return null;
        }
        SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
        T t9 = (T) SavedStateReader.m135getJavaSerializableimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate()), savedStateDecoder.getKey$savedstate(), y.a(Serializable.class));
        t9.getClass();
        return t9;
    }

    @Override // z7.h, z7.a
    public final e getDescriptor() {
        return this.descriptor;
    }

    @Override // z7.h
    public final void serialize(f fVar, T t9) {
        fVar.getClass();
        t9.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            o.o(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.a(), fVar));
        } else {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m203putJavaSerializableimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate()), savedStateEncoder.getKey$savedstate(), t9);
        }
    }
}
