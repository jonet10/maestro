package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    private final void mergeFrom(B b7, Reader reader, int i) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b7, reader, i)) {
        }
    }

    public abstract void addFixed32(B b7, int i, int i6);

    public abstract void addFixed64(B b7, int i, long j);

    public abstract void addGroup(B b7, int i, T t9);

    public abstract void addLengthDelimited(B b7, int i, ByteString byteString);

    public abstract void addVarint(B b7, int i, long j);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t9);

    public abstract int getSerializedSizeAsMessageSet(T t9);

    public abstract void makeImmutable(Object obj);

    public abstract T merge(T t9, T t10);

    public final boolean mergeOneFieldFrom(B b7, Reader reader, int i) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b7, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b7, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b7, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b7, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B newBuilder = newBuilder();
        int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
        int i6 = i + 1;
        if (i6 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        mergeFrom(newBuilder, reader, i6);
        if (makeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b7, tagFieldNumber, toImmutable(newBuilder));
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b7);

    public void setRecursionLimit(int i) {
        recursionLimit = i;
    }

    public abstract void setToMessage(Object obj, T t9);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B b7);

    public abstract void writeAsMessageSetTo(T t9, Writer writer) throws IOException;

    public abstract void writeTo(T t9, Writer writer) throws IOException;
}
