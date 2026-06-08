package c8;

import d8.j0;
import kotlin.jvm.internal.y;
import z7.g;
import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b implements f, d {
    @Override // c8.f
    public d beginCollection(b8.e eVar, int i) {
        eVar.getClass();
        return beginStructure(eVar);
    }

    @Override // c8.f
    public d beginStructure(b8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // c8.f
    public abstract void encodeBoolean(boolean z9);

    @Override // c8.d
    public final void encodeBooleanElement(b8.e eVar, int i, boolean z9) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeBoolean(z9);
        }
    }

    @Override // c8.f
    public abstract void encodeByte(byte b7);

    @Override // c8.d
    public final void encodeByteElement(b8.e eVar, int i, byte b7) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeByte(b7);
        }
    }

    @Override // c8.f
    public abstract void encodeChar(char c9);

    @Override // c8.d
    public final void encodeCharElement(b8.e eVar, int i, char c9) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeChar(c9);
        }
    }

    @Override // c8.f
    public abstract void encodeDouble(double d10);

    @Override // c8.d
    public final void encodeDoubleElement(b8.e eVar, int i, double d10) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeDouble(d10);
        }
    }

    public boolean encodeElement(b8.e eVar, int i) {
        eVar.getClass();
        return true;
    }

    @Override // c8.f
    public abstract void encodeFloat(float f);

    @Override // c8.d
    public final void encodeFloatElement(b8.e eVar, int i, float f) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeFloat(f);
        }
    }

    @Override // c8.f
    public f encodeInline(b8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // c8.d
    public final f encodeInlineElement(b8.e eVar, int i) {
        eVar.getClass();
        return encodeElement(eVar, i) ? encodeInline(eVar.h(i)) : j0.f3661a;
    }

    @Override // c8.f
    public abstract void encodeInt(int i);

    @Override // c8.d
    public final void encodeIntElement(b8.e eVar, int i, int i6) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeInt(i6);
        }
    }

    @Override // c8.f
    public abstract void encodeLong(long j);

    @Override // c8.d
    public final void encodeLongElement(b8.e eVar, int i, long j) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeLong(j);
        }
    }

    @Override // c8.d
    public <T> void encodeNullableSerializableElement(b8.e eVar, int i, h hVar, T t9) {
        eVar.getClass();
        hVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeNullableSerializableValue(hVar, t9);
        }
    }

    public <T> void encodeNullableSerializableValue(h hVar, T t9) {
        hVar.getClass();
        if (hVar.getDescriptor().c()) {
            encodeSerializableValue(hVar, t9);
        } else if (t9 == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(hVar, t9);
        }
    }

    @Override // c8.d
    public <T> void encodeSerializableElement(b8.e eVar, int i, h hVar, T t9) {
        eVar.getClass();
        hVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeSerializableValue(hVar, t9);
        }
    }

    @Override // c8.f
    public void encodeSerializableValue(h hVar, Object obj) {
        hVar.getClass();
        hVar.serialize(this, obj);
    }

    @Override // c8.f
    public abstract void encodeShort(short s6);

    @Override // c8.d
    public final void encodeShortElement(b8.e eVar, int i, short s6) {
        eVar.getClass();
        if (encodeElement(eVar, i)) {
            encodeShort(s6);
        }
    }

    @Override // c8.f
    public abstract void encodeString(String str);

    @Override // c8.d
    public final void encodeStringElement(b8.e eVar, int i, String str) {
        eVar.getClass();
        str.getClass();
        if (encodeElement(eVar, i)) {
            encodeString(str);
        }
    }

    public void encodeValue(Object obj) {
        obj.getClass();
        throw new g("Non-serializable " + y.a(obj.getClass()) + " is not supported by " + y.a(getClass()) + " encoder");
    }

    @Override // c8.d
    public void endStructure(b8.e eVar) {
        eVar.getClass();
    }

    public boolean shouldEncodeElementDefault(b8.e eVar, int i) {
        eVar.getClass();
        return true;
    }

    @Override // c8.f
    public void encodeNotNullMark() {
    }
}
