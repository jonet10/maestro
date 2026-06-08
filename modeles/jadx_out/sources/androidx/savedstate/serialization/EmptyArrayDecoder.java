package androidx.savedstate.serialization;

import b8.e;
import c8.a;
import g8.f;
import g8.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class EmptyArrayDecoder extends a {
    public static final EmptyArrayDecoder INSTANCE = new EmptyArrayDecoder();
    private static final f serializersModule = i.f5387a;

    private EmptyArrayDecoder() {
    }

    @Override // c8.c
    public int decodeElementIndex(e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // c8.c
    public f getSerializersModule() {
        return serializersModule;
    }
}
