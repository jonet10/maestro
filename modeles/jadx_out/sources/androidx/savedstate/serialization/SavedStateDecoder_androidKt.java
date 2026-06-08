package androidx.savedstate.serialization;

import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import b8.e;
import d0.b;
import j7.c;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import z7.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateDecoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T decodeFormatSpecificTypesOnPlatform(SavedStateDecoder savedStateDecoder, a aVar) {
        savedStateDecoder.getClass();
        aVar.getClass();
        e descriptor = aVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return (T) CharSequenceSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return (T) DefaultParcelableSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return (T) DefaultJavaSerializableSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return (T) IBinderSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            return (T) CharSequenceArraySerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            return (T) CharSequenceListSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
            Parcelable[] deserialize = ParcelableArraySerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
            return (T) Arrays.copyOf(deserialize, deserialize.length, b.F(getArrayKClass(aVar)));
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            return (T) ParcelableArraySerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            return (T) ParcelableListSerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return (T) SparseParcelableArraySerializer.INSTANCE.deserialize((c8.e) savedStateDecoder);
        }
        return null;
    }

    private static final c getArrayKClass(a aVar) {
        Object deserialize = aVar.deserialize(EmptyArrayDecoder.INSTANCE);
        deserialize.getClass();
        return y.a(deserialize.getClass());
    }
}
