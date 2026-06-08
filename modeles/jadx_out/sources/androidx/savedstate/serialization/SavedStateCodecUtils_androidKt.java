package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import b8.e;
import d8.c;
import java.io.Serializable;
import kotlin.jvm.internal.y;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateCodecUtils_androidKt {
    private static final e charSequenceArrayDescriptor;
    private static final e charSequenceListDescriptor;
    private static final e nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final e parcelableArrayDescriptor;
    private static final e parcelableListDescriptor;
    private static final e polymorphicCharSequenceArrayDescriptor;
    private static final e polymorphicCharSequenceListDescriptor;
    private static final e polymorphicParcelableArrayDescriptor;
    private static final e polymorphicParcelableListDescriptor;
    private static final e polymorphicSparseParcelableArrayDescriptor;
    private static final e sparseParcelableArrayDescriptor;
    private static final e polymorphicCharSequenceDescriptor = new z7.e(y.a(CharSequence.class)).getDescriptor();
    private static final e polymorphicParcelableDescriptor = new z7.e(y.a(Parcelable.class)).getDescriptor();
    private static final e polymorphicJavaSerializableDescriptor = new z7.e(y.a(Serializable.class)).getDescriptor();
    private static final e polymorphicIBinderDescriptor = new z7.e(y.a(IBinder.class)).getDescriptor();

    static {
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
        y.a(Parcelable.class);
        defaultParcelableSerializer.getClass();
        e descriptor = defaultParcelableSerializer.getDescriptor();
        descriptor.getClass();
        parcelableArrayDescriptor = new c(descriptor, 0);
        z7.e eVar = new z7.e(y.a(Parcelable.class));
        y.a(Parcelable.class);
        e descriptor2 = eVar.getDescriptor();
        descriptor2.getClass();
        polymorphicParcelableArrayDescriptor = new c(descriptor2, 0);
        e descriptor3 = defaultParcelableSerializer.getDescriptor();
        descriptor3.getClass();
        parcelableListDescriptor = new c(descriptor3, 1);
        e descriptor4 = new z7.e(y.a(Parcelable.class)).getDescriptor();
        descriptor4.getClass();
        polymorphicParcelableListDescriptor = new c(descriptor4, 1);
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
        y.a(CharSequence.class);
        charSequenceSerializer.getClass();
        e descriptor5 = charSequenceSerializer.getDescriptor();
        descriptor5.getClass();
        charSequenceArrayDescriptor = new c(descriptor5, 0);
        z7.e eVar2 = new z7.e(y.a(CharSequence.class));
        y.a(CharSequence.class);
        e descriptor6 = eVar2.getDescriptor();
        descriptor6.getClass();
        polymorphicCharSequenceArrayDescriptor = new c(descriptor6, 0);
        e descriptor7 = charSequenceSerializer.getDescriptor();
        descriptor7.getClass();
        charSequenceListDescriptor = new c(descriptor7, 1);
        e descriptor8 = new z7.e(y.a(CharSequence.class)).getDescriptor();
        descriptor8.getClass();
        polymorphicCharSequenceListDescriptor = new c(descriptor8, 1);
        sparseParcelableArrayDescriptor = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new z7.e(y.a(Parcelable.class))).getDescriptor();
        nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(f.y(new z7.e(y.a(Parcelable.class)))).getDescriptor();
    }

    public static final e getCharSequenceArrayDescriptor() {
        return charSequenceArrayDescriptor;
    }

    public static final e getCharSequenceListDescriptor() {
        return charSequenceListDescriptor;
    }

    public static final e getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final e getParcelableArrayDescriptor() {
        return parcelableArrayDescriptor;
    }

    public static final e getParcelableListDescriptor() {
        return parcelableListDescriptor;
    }

    public static final e getPolymorphicCharSequenceArrayDescriptor() {
        return polymorphicCharSequenceArrayDescriptor;
    }

    public static final e getPolymorphicCharSequenceDescriptor() {
        return polymorphicCharSequenceDescriptor;
    }

    public static final e getPolymorphicCharSequenceListDescriptor() {
        return polymorphicCharSequenceListDescriptor;
    }

    public static final e getPolymorphicIBinderDescriptor() {
        return polymorphicIBinderDescriptor;
    }

    public static final e getPolymorphicJavaSerializableDescriptor() {
        return polymorphicJavaSerializableDescriptor;
    }

    public static final e getPolymorphicParcelableArrayDescriptor() {
        return polymorphicParcelableArrayDescriptor;
    }

    public static final e getPolymorphicParcelableDescriptor() {
        return polymorphicParcelableDescriptor;
    }

    public static final e getPolymorphicParcelableListDescriptor() {
        return polymorphicParcelableListDescriptor;
    }

    public static final e getPolymorphicSparseParcelableArrayDescriptor() {
        return polymorphicSparseParcelableArrayDescriptor;
    }

    public static final e getSparseParcelableArrayDescriptor() {
        return sparseParcelableArrayDescriptor;
    }

    public static /* synthetic */ void getCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getParcelableArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static /* synthetic */ void getPolymorphicParcelableArrayDescriptor$annotations() {
    }
}
