package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MetadataItem extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s6) {
        flatBufferBuilder.addShort(3, s6, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean z9) {
        flatBufferBuilder.addBoolean(1, z9, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s6) {
        flatBufferBuilder.addShort(5, s6, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s6) {
        flatBufferBuilder.addShort(2, s6, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s6) {
        flatBufferBuilder.addShort(4, s6, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int i, boolean z9, short s6, short s9, short s10, short s11, int i6) {
        flatBufferBuilder.startTable(7);
        addCodepoints(flatBufferBuilder, i6);
        addId(flatBufferBuilder, i);
        addHeight(flatBufferBuilder, s11);
        addWidth(flatBufferBuilder, s10);
        addCompatAdded(flatBufferBuilder, s9);
        addSdkAdded(flatBufferBuilder, s6);
        addEmojiStyle(flatBufferBuilder, z9);
        return endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.position() + byteBuffer.getInt(byteBuffer.position()), byteBuffer);
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public int codepoints(int i) {
        int __offset = __offset(16);
        if (__offset == 0) {
            return 0;
        }
        return this.bb.getInt((i * 4) + __vector(__offset));
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector codepointsVector(IntVector intVector) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public short compatAdded() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public boolean emojiStyle() {
        int __offset = __offset(6);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public short height() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public int id() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public short sdkAdded() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public short width() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos);
        }
        return (short) 0;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i6, ByteBuffer byteBuffer) {
            __reset(i, i6, byteBuffer);
            return this;
        }

        public MetadataItem get(MetadataItem metadataItem, int i) {
            return metadataItem.__assign(Table.__indirect(__element(i), this.bb), this.bb);
        }

        public MetadataItem get(int i) {
            return get(new MetadataItem(), i);
        }
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }
}
