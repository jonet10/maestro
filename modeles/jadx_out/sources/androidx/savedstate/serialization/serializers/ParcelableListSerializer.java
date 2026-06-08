package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import b2.t1;
import b8.e;
import c8.f;
import java.util.List;
import kotlin.jvm.internal.y;
import s1.o;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ParcelableListSerializer implements b {
    public static final ParcelableListSerializer INSTANCE = new ParcelableListSerializer();
    private static final e descriptor = t1.n("kotlin.collections.List<android.os.Parcelable>", new e[0]);

    private ParcelableListSerializer() {
    }

    @Override // z7.a
    public List<Parcelable> deserialize(c8.e eVar) {
        eVar.getClass();
        if (eVar instanceof SavedStateDecoder) {
            SavedStateDecoder savedStateDecoder = (SavedStateDecoder) eVar;
            return SavedStateReader.m149getParcelableListimpl(SavedStateReader.m97constructorimpl(savedStateDecoder.getSavedState$savedstate()), savedStateDecoder.getKey$savedstate(), y.a(Parcelable.class));
        }
        o.o(BuiltInSerializerKt.decoderErrorMessage(INSTANCE.getDescriptor().a(), eVar));
        return null;
    }

    @Override // z7.h, z7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public void serialize(f fVar, List<? extends Parcelable> list) {
        fVar.getClass();
        list.getClass();
        if (!(fVar instanceof SavedStateEncoder)) {
            o.o(BuiltInSerializerKt.encoderErrorMessage(INSTANCE.getDescriptor().a(), fVar));
        } else {
            SavedStateEncoder savedStateEncoder = (SavedStateEncoder) fVar;
            SavedStateWriter.m209putParcelableListimpl(SavedStateWriter.m183constructorimpl(savedStateEncoder.getSavedState$savedstate()), savedStateEncoder.getKey$savedstate(), list);
        }
    }
}
