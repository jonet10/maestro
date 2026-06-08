package androidx.savedstate.serialization.serializers;

import android.os.IBinder;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import b2.t1;
import b8.e;
import c8.f;
import s1.o;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IBinderSerializer implements b {
    public static final IBinderSerializer INSTANCE = new IBinderSerializer();
    private static final e descriptor = t1.n("android.os.IBinder", new e[0]);

    private IBinderSerializer() {
    }

    @Override // z7.a
    public IBinder deserialize(c8.e eVar) {
        eVar.getClass();
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m104getBinderimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate()), savedStateDecoder.getKey$savedstate());
        }
        o.o(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar));
        return null;
    }

    @Override // z7.h, z7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public void serialize(f fVar, IBinder iBinder) {
        fVar.getClass();
        iBinder.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            o.o(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar));
        } else {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m188putBinderimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate()), savedStateEncoder.getKey$savedstate(), iBinder);
        }
    }
}
