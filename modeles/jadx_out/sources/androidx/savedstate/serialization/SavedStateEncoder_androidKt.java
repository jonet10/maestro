package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
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
import c8.f;
import java.util.List;
import kotlin.jvm.internal.l;
import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateEncoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder savedStateEncoder, h hVar, T t9) {
        savedStateEncoder.getClass();
        hVar.getClass();
        e descriptor = hVar.getDescriptor();
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
            t9.getClass();
            charSequenceSerializer.serialize((f) savedStateEncoder, (CharSequence) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
            t9.getClass();
            defaultParcelableSerializer.serialize((f) savedStateEncoder, (SavedStateEncoder) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.INSTANCE;
            t9.getClass();
            defaultJavaSerializableSerializer.serialize((f) savedStateEncoder, (SavedStateEncoder) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.INSTANCE;
            t9.getClass();
            iBinderSerializer.serialize((f) savedStateEncoder, (IBinder) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.INSTANCE;
            t9.getClass();
            charSequenceArraySerializer.serialize((f) savedStateEncoder, (CharSequence[]) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.INSTANCE;
            t9.getClass();
            charSequenceListSerializer.serialize((f) savedStateEncoder, (List<? extends CharSequence>) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.INSTANCE;
            t9.getClass();
            parcelableArraySerializer.serialize((f) savedStateEncoder, (Parcelable[]) t9);
            return true;
        }
        if (l.a(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.INSTANCE;
            t9.getClass();
            parcelableListSerializer.serialize((f) savedStateEncoder, (List<? extends Parcelable>) t9);
            return true;
        }
        if (!l.a(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !l.a(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && !l.a(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return false;
        }
        SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.INSTANCE;
        t9.getClass();
        sparseParcelableArraySerializer.serialize((f) savedStateEncoder, (SparseArray<Parcelable>) t9);
        return true;
    }
}
