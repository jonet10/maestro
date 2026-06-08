package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, c cVar);

    Object writeTo(T t9, OutputStream outputStream, c cVar);
}
