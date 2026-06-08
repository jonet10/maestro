package f3;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import b2.t1;
import java.io.InputStream;
import java.io.OutputStream;
import l7.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements Serializer {

    /* renamed from: a, reason: collision with root package name */
    public static final h f4851a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final g f4852b = new g(null, null, null, null, null);

    @Override // androidx.datastore.core.Serializer
    public final /* bridge */ /* synthetic */ Object getDefaultValue() {
        return f4852b;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, t6.c cVar) {
        try {
            e8.b bVar = e8.b.f4760d;
            String j02 = u.j0(t1.K(inputStream));
            bVar.getClass();
            return (g) bVar.a(g.Companion.serializer(), j02);
        } catch (Exception e10) {
            throw new CorruptionException("Cannot parse session configs", e10);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final Object writeTo(Object obj, OutputStream outputStream, t6.c cVar) {
        byte[] bytes = e8.b.f4760d.b(g.Companion.serializer(), (g) obj).getBytes(l7.a.f7151a);
        bytes.getClass();
        outputStream.write(bytes);
        return x.f8463a;
    }
}
