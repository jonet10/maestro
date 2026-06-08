package c8;

import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface d {
    void encodeBooleanElement(b8.e eVar, int i, boolean z9);

    void encodeByteElement(b8.e eVar, int i, byte b7);

    void encodeCharElement(b8.e eVar, int i, char c9);

    void encodeDoubleElement(b8.e eVar, int i, double d10);

    void encodeFloatElement(b8.e eVar, int i, float f);

    f encodeInlineElement(b8.e eVar, int i);

    void encodeIntElement(b8.e eVar, int i, int i6);

    void encodeLongElement(b8.e eVar, int i, long j);

    void encodeNullableSerializableElement(b8.e eVar, int i, h hVar, Object obj);

    void encodeSerializableElement(b8.e eVar, int i, h hVar, Object obj);

    void encodeShortElement(b8.e eVar, int i, short s6);

    void encodeStringElement(b8.e eVar, int i, String str);

    void endStructure(b8.e eVar);

    boolean shouldEncodeElementDefault(b8.e eVar, int i);
}
