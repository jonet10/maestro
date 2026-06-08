package c8;

import kotlin.jvm.internal.y;
import z7.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements e, c {
    public static /* synthetic */ Object decodeSerializableValue$default(a aVar, z7.a aVar2, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            a3.b.r("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
            return null;
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        return aVar.decodeSerializableValue(aVar2, obj);
    }

    @Override // c8.e
    public c beginStructure(b8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // c8.e
    public boolean decodeBoolean() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Boolean) decodeValue).booleanValue();
    }

    @Override // c8.c
    public final boolean decodeBooleanElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeBoolean();
    }

    @Override // c8.e
    public byte decodeByte() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Byte) decodeValue).byteValue();
    }

    @Override // c8.c
    public final byte decodeByteElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeByte();
    }

    @Override // c8.e
    public char decodeChar() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Character) decodeValue).charValue();
    }

    @Override // c8.c
    public final char decodeCharElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeChar();
    }

    @Override // c8.c
    public int decodeCollectionSize(b8.e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // c8.e
    public double decodeDouble() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Double) decodeValue).doubleValue();
    }

    @Override // c8.c
    public final double decodeDoubleElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeDouble();
    }

    public int decodeEnum(b8.e eVar) {
        eVar.getClass();
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Integer) decodeValue).intValue();
    }

    @Override // c8.e
    public float decodeFloat() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Float) decodeValue).floatValue();
    }

    @Override // c8.c
    public final float decodeFloatElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeFloat();
    }

    @Override // c8.e
    public e decodeInline(b8.e eVar) {
        eVar.getClass();
        return this;
    }

    @Override // c8.c
    public e decodeInlineElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeInline(eVar.h(i));
    }

    @Override // c8.e
    public int decodeInt() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Integer) decodeValue).intValue();
    }

    @Override // c8.c
    public final int decodeIntElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeInt();
    }

    @Override // c8.e
    public long decodeLong() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Long) decodeValue).longValue();
    }

    @Override // c8.c
    public final long decodeLongElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeLong();
    }

    @Override // c8.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // c8.e
    public Void decodeNull() {
        return null;
    }

    @Override // c8.c
    public final <T> T decodeNullableSerializableElement(b8.e eVar, int i, z7.a aVar, T t9) {
        eVar.getClass();
        aVar.getClass();
        return (aVar.getDescriptor().c() || decodeNotNullMark()) ? (T) decodeSerializableValue(aVar, t9) : (T) decodeNull();
    }

    public <T> T decodeNullableSerializableValue(z7.a aVar) {
        aVar.getClass();
        return (aVar.getDescriptor().c() || decodeNotNullMark()) ? (T) decodeSerializableValue(aVar) : (T) decodeNull();
    }

    @Override // c8.c
    public boolean decodeSequentially() {
        return false;
    }

    @Override // c8.c
    public <T> T decodeSerializableElement(b8.e eVar, int i, z7.a aVar, T t9) {
        eVar.getClass();
        aVar.getClass();
        return (T) decodeSerializableValue(aVar, t9);
    }

    @Override // c8.e
    public <T> T decodeSerializableValue(z7.a aVar) {
        aVar.getClass();
        return (T) aVar.deserialize(this);
    }

    @Override // c8.e
    public short decodeShort() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return ((Short) decodeValue).shortValue();
    }

    @Override // c8.c
    public final short decodeShortElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeShort();
    }

    @Override // c8.e
    public String decodeString() {
        Object decodeValue = decodeValue();
        decodeValue.getClass();
        return (String) decodeValue;
    }

    @Override // c8.c
    public final String decodeStringElement(b8.e eVar, int i) {
        eVar.getClass();
        return decodeString();
    }

    public Object decodeValue() {
        throw new g(y.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // c8.c
    public void endStructure(b8.e eVar) {
        eVar.getClass();
    }

    public <T> T decodeSerializableValue(z7.a aVar, T t9) {
        aVar.getClass();
        return (T) decodeSerializableValue(aVar);
    }
}
