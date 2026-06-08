package c8;

import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface f {
    d beginCollection(b8.e eVar, int i);

    d beginStructure(b8.e eVar);

    void encodeBoolean(boolean z9);

    void encodeByte(byte b7);

    void encodeChar(char c9);

    void encodeDouble(double d10);

    void encodeFloat(float f);

    f encodeInline(b8.e eVar);

    void encodeInt(int i);

    void encodeLong(long j);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(h hVar, Object obj);

    void encodeShort(short s6);

    void encodeString(String str);

    g8.f getSerializersModule();
}
