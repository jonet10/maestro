package androidx.savedstate.serialization.serializers;

import c8.e;
import c8.f;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String str, e eVar) {
        str.getClass();
        eVar.getClass();
        return "Cannot deserialize " + str + " with '" + y.a(eVar.getClass()).c() + "'. This serializer can only be used with SavedStateDecoder. Use 'decodeFromSavedState' instead.";
    }

    public static final String encoderErrorMessage(String str, f fVar) {
        str.getClass();
        fVar.getClass();
        return "Cannot serialize " + str + " with '" + y.a(fVar.getClass()).c() + "'. This serializer can only be used with SavedStateEncoder. Use 'encodeToSavedState' instead.";
    }
}
