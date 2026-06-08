package androidx.datastore.core;

import d7.p;
import d7.q;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, c cVar);

    Object writeScope(p pVar, c cVar);
}
