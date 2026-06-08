package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
interface Schema<T> {
    boolean equals(T t9, T t10);

    int getSerializedSize(T t9);

    int hashCode(T t9);

    boolean isInitialized(T t9);

    void makeImmutable(T t9);

    void mergeFrom(T t9, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t9, T t10);

    void mergeFrom(T t9, byte[] bArr, int i, int i6, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t9, Writer writer) throws IOException;
}
