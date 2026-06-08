package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import p6.x;
import t6.c;
import u6.a;
import w8.i;
import w8.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> serializer) {
        serializer.getClass();
        this.delegate = serializer;
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(j jVar, c cVar) {
        return this.delegate.readFrom(jVar.x(), cVar);
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object writeTo(T t9, i iVar, c cVar) {
        Object writeTo = this.delegate.writeTo(t9, iVar.v(), cVar);
        return writeTo == a.f10762a ? writeTo : x.f8463a;
    }
}
