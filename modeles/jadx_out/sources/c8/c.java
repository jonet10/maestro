package c8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface c {
    boolean decodeBooleanElement(b8.e eVar, int i);

    byte decodeByteElement(b8.e eVar, int i);

    char decodeCharElement(b8.e eVar, int i);

    int decodeCollectionSize(b8.e eVar);

    double decodeDoubleElement(b8.e eVar, int i);

    int decodeElementIndex(b8.e eVar);

    float decodeFloatElement(b8.e eVar, int i);

    e decodeInlineElement(b8.e eVar, int i);

    int decodeIntElement(b8.e eVar, int i);

    long decodeLongElement(b8.e eVar, int i);

    Object decodeNullableSerializableElement(b8.e eVar, int i, z7.a aVar, Object obj);

    boolean decodeSequentially();

    Object decodeSerializableElement(b8.e eVar, int i, z7.a aVar, Object obj);

    short decodeShortElement(b8.e eVar, int i);

    String decodeStringElement(b8.e eVar, int i);

    void endStructure(b8.e eVar);

    g8.f getSerializersModule();
}
