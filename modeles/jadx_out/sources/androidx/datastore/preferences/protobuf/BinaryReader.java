package androidx.datastore.preferences.protobuf;

import a3.b;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.work.WorkInfo;
import com.google.gson.internal.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z9) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z9);
        }
        a.p("Direct buffers not yet supported");
        return null;
    }

    public abstract int getTotalBytesRead();

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    private BinaryReader() {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z9) {
            super(null);
            this.bufferIsImmutable = z9;
            this.buffer = byteBuffer.array();
            int position = byteBuffer.position() + byteBuffer.arrayOffset();
            this.pos = position;
            this.initialPos = position;
            this.limit = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        private byte readByte() throws IOException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    b.n("unsupported field type.");
                    return null;
            }
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        private int readVarint32() throws IOException {
            int i;
            int i6 = this.pos;
            int i10 = this.limit;
            if (i10 == i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i11 = i6 + 1;
            byte b7 = bArr[i6];
            if (b7 >= 0) {
                this.pos = i11;
                return b7;
            }
            if (i10 - i11 < 9) {
                return (int) readVarint64SlowPath();
            }
            int i12 = i6 + 2;
            int i13 = (bArr[i11] << 7) ^ b7;
            if (i13 < 0) {
                i = i13 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            } else {
                int i14 = i6 + 3;
                int i15 = (bArr[i12] << 14) ^ i13;
                if (i15 >= 0) {
                    i = i15 ^ 16256;
                } else {
                    int i16 = i6 + 4;
                    int i17 = i15 ^ (bArr[i14] << 21);
                    if (i17 < 0) {
                        i = (-2080896) ^ i17;
                    } else {
                        i14 = i6 + 5;
                        byte b10 = bArr[i16];
                        int i18 = (i17 ^ (b10 << 28)) ^ 266354560;
                        if (b10 < 0) {
                            i16 = i6 + 6;
                            if (bArr[i14] < 0) {
                                i14 = i6 + 7;
                                if (bArr[i16] < 0) {
                                    i16 = i6 + 8;
                                    if (bArr[i14] < 0) {
                                        i14 = i6 + 9;
                                        if (bArr[i16] < 0) {
                                            int i19 = i6 + 10;
                                            if (bArr[i14] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i12 = i19;
                                            i = i18;
                                        }
                                    }
                                }
                            }
                            i = i18;
                        }
                        i = i18;
                    }
                    i12 = i16;
                }
                i12 = i14;
            }
            this.pos = i12;
            return i;
        }

        private long readVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i) throws IOException {
            if (i < 0 || i > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i) throws IOException {
            if (this.pos != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i) throws IOException {
            requireBytes(i);
            this.pos += i;
        }

        private void skipGroup() throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i;
        }

        private void skipVarint() throws IOException {
            int i = this.limit;
            int i6 = this.pos;
            if (i - i6 >= 10) {
                byte[] bArr = this.buffer;
                int i10 = 0;
                while (i10 < 10) {
                    int i11 = i6 + 1;
                    if (bArr[i6] >= 0) {
                        this.pos = i11;
                        return;
                    } else {
                        i10++;
                        i6 = i11;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void mergeGroupField(T t9, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(t9, this, extensionRegistryLite);
                if (this.tag == this.endGroupTag) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void mergeMessageField(T t9, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            int i6 = this.pos + readVarint32;
            this.limit = i6;
            try {
                schema.mergeFrom(t9, this, extensionRegistryLite);
                if (this.pos == i6) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean readBool() throws IOException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readBoolList(List<Boolean> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof BooleanArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(readVarint32);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(readBool()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    booleanArrayList.addBoolean(readVarint32() != 0);
                }
                requirePosition(readVarint322);
                return;
            }
            do {
                booleanArrayList.addBoolean(readBool());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public ByteString readBytes() throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            boolean z9 = this.bufferIsImmutable;
            byte[] bArr = this.buffer;
            ByteString wrap = z9 ? ByteString.wrap(bArr, this.pos, readVarint32) : ByteString.copyFrom(bArr, this.pos, readVarint32);
            this.pos += readVarint32;
            return wrap;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readBytesList(List<ByteString> list) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readDoubleList(List<Double> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof DoubleArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i11 = this.pos + readVarint32;
                while (this.pos < i11) {
                    list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                }
                return;
            }
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i12 = this.pos + readVarint322;
            while (this.pos < i12) {
                doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readEnumList(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readEnum());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFixed32List(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i11 = this.pos + readVarint32;
                    while (this.pos < i11) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i12 = this.pos + readVarint322;
                while (this.pos < i12) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFixed64List(List<Long> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i11 = this.pos + readVarint32;
                while (this.pos < i11) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i12 = this.pos + readVarint322;
            while (this.pos < i12) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFloatList(List<Float> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof FloatArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i11 = this.pos + readVarint32;
                    while (this.pos < i11) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i12 = this.pos + readVarint322;
                while (this.pos < i12) {
                    floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                floatArrayList.addFloat(readFloat());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i6 = this.tag;
            do {
                list.add(readGroup(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i6);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readInt32List(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Integer.valueOf(readVarint32()));
                }
                requirePosition(readVarint32);
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    intArrayList.addInt(readInt32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = this.pos + readVarint32();
            while (this.pos < readVarint322) {
                intArrayList.addInt(readVarint32());
            }
            requirePosition(readVarint322);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readInt64List(List<Long> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(readVarint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.addLong(readInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = this.pos + readVarint32();
            while (this.pos < readVarint322) {
                longArrayList.addLong(readVarint64());
            }
            requirePosition(readVarint322);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        public <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            this.limit = this.pos + readVarint32;
            try {
                Object obj = metadata.defaultKey;
                Object obj2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        obj = readField(metadata.keyType, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    }
                }
            } finally {
                this.limit = i;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i6 = this.tag;
            do {
                list.add(readMessage(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i6);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSFixed32List(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i11 = this.pos + readVarint32;
                    while (this.pos < i11) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i12 = this.pos + readVarint322;
                while (this.pos < i12) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readSFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSFixed64List(List<Long> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i11 = this.pos + readVarint32;
                while (this.pos < i11) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i12 = this.pos + readVarint322;
            while (this.pos < i12) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSInt32List(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                }
                return;
            }
            do {
                intArrayList.addInt(readSInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSInt64List(List<Long> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                }
                return;
            }
            do {
                longArrayList.addLong(readSInt64());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z9) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z9) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                if (!Utf8.isValidUtf8(bArr, i, i + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z9) throws IOException {
            int i;
            int i6;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (!(list instanceof LazyStringList) || z9) {
                do {
                    list.add(readStringInternal(z9));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readUInt32List(List<Integer> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof IntArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readUInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i6 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readUInt64List(List<Long> list) throws IOException {
            int i;
            int i6;
            boolean z9 = list instanceof LongArrayList;
            int i10 = this.tag;
            if (!z9) {
                int tagWireType = WireFormat.getTagWireType(i10);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(readVarint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(i10);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.addLong(readUInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i6 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i6;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = this.pos + readVarint32();
            while (this.pos < readVarint322) {
                longArrayList.addLong(readVarint64());
            }
            requirePosition(readVarint322);
        }

        public long readVarint64() throws IOException {
            long j;
            long j6;
            long j10;
            long j11;
            int i = this.pos;
            int i6 = this.limit;
            if (i6 == i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i10 = i + 1;
            byte b7 = bArr[i];
            if (b7 >= 0) {
                this.pos = i10;
                return b7;
            }
            if (i6 - i10 < 9) {
                return readVarint64SlowPath();
            }
            int i11 = i + 2;
            int i12 = (bArr[i10] << 7) ^ b7;
            if (i12 < 0) {
                j = i12 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            } else {
                int i13 = i + 3;
                int i14 = (bArr[i11] << 14) ^ i12;
                if (i14 >= 0) {
                    j = i14 ^ 16256;
                    i11 = i13;
                } else {
                    int i15 = i + 4;
                    int i16 = i14 ^ (bArr[i13] << 21);
                    if (i16 < 0) {
                        j11 = (-2080896) ^ i16;
                    } else {
                        long j12 = i16;
                        i11 = i + 5;
                        long j13 = j12 ^ (bArr[i15] << 28);
                        if (j13 >= 0) {
                            j10 = 266354560;
                        } else {
                            i15 = i + 6;
                            long j14 = j13 ^ (bArr[i11] << 35);
                            if (j14 < 0) {
                                j6 = -34093383808L;
                            } else {
                                i11 = i + 7;
                                j13 = j14 ^ (bArr[i15] << 42);
                                if (j13 >= 0) {
                                    j10 = 4363953127296L;
                                } else {
                                    i15 = i + 8;
                                    j14 = j13 ^ (bArr[i11] << 49);
                                    if (j14 < 0) {
                                        j6 = -558586000294016L;
                                    } else {
                                        i11 = i + 9;
                                        long j15 = (j14 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                        if (j15 < 0) {
                                            int i17 = i + 10;
                                            if (bArr[i11] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i11 = i17;
                                        }
                                        j = j15;
                                    }
                                }
                            }
                            j11 = j6 ^ j14;
                        }
                        j = j10 ^ j13;
                    }
                    i11 = i15;
                    j = j11;
                }
            }
            this.pos = i11;
            return j;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean skipField() throws IOException {
            int i;
            if (isAtEnd() || (i = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipGroup();
                return true;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipBytes(4);
            return true;
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }
    }
}
