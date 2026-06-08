package androidx.datastore.core.okio;

import t6.c;
import w8.i;
import w8.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(j jVar, c cVar);

    Object writeTo(T t9, i iVar, c cVar);
}
