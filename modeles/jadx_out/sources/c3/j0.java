package c3;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import b2.t1;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 implements Serializer {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f1277a;

    public j0(t0 t0Var) {
        t0Var.getClass();
        this.f1277a = t0Var;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object getDefaultValue() {
        return new i0(this.f1277a.a(null), null, null);
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, t6.c cVar) {
        try {
            e8.b bVar = e8.b.f4760d;
            String j02 = l7.u.j0(t1.K(inputStream));
            bVar.getClass();
            return (i0) bVar.a(i0.Companion.serializer(), j02);
        } catch (Exception e10) {
            throw new CorruptionException("Cannot parse session data", e10);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final Object writeTo(Object obj, OutputStream outputStream, t6.c cVar) {
        byte[] bytes = e8.b.f4760d.b(i0.Companion.serializer(), (i0) obj).getBytes(l7.a.f7151a);
        bytes.getClass();
        outputStream.write(bytes);
        return p6.x.f8463a;
    }
}
