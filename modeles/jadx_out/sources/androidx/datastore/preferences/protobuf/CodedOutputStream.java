package androidx.datastore.preferences.protobuf;

import a4.x;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.work.WorkInfo;
import com.google.gson.internal.a;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int i) {
            super();
            if (i < 0) {
                a.p("bufferSize must be >= 0");
                throw null;
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        public final void buffer(byte b7) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b7;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i) {
            byte[] bArr = this.buffer;
            int i6 = this.position;
            int i10 = i6 + 1;
            this.position = i10;
            bArr[i6] = (byte) (i & 255);
            int i11 = i6 + 2;
            this.position = i11;
            bArr[i10] = (byte) ((i >> 8) & 255);
            int i12 = i6 + 3;
            this.position = i12;
            bArr[i11] = (byte) ((i >> 16) & 255);
            this.position = i6 + 4;
            bArr[i12] = (byte) ((i >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            int i6 = i + 1;
            this.position = i6;
            bArr[i] = (byte) (j & 255);
            int i10 = i + 2;
            this.position = i10;
            bArr[i6] = (byte) ((j >> 8) & 255);
            int i11 = i + 3;
            this.position = i11;
            bArr[i10] = (byte) ((j >> 16) & 255);
            int i12 = i + 4;
            this.position = i12;
            bArr[i11] = (byte) (255 & (j >> 24));
            int i13 = i + 5;
            this.position = i13;
            bArr[i12] = (byte) (((int) (j >> 32)) & 255);
            int i14 = i + 6;
            this.position = i14;
            bArr[i13] = (byte) (((int) (j >> 40)) & 255);
            int i15 = i + 7;
            this.position = i15;
            bArr[i14] = (byte) (((int) (j >> 48)) & 255);
            this.position = i + 8;
            bArr[i15] = (byte) (((int) (j >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i) {
            if (i >= 0) {
                bufferUInt32NoTag(i);
            } else {
                bufferUInt64NoTag(i);
            }
        }

        public final void bufferTag(int i, int i6) {
            bufferUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        public final void bufferUInt32NoTag(int i) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j = this.position;
                while (true) {
                    int i6 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                    byte[] bArr = this.buffer;
                    if (i6 == 0) {
                        int i10 = this.position;
                        this.position = i10 + 1;
                        UnsafeUtil.putByte(bArr, i10, (byte) i);
                        this.totalBytesWritten += (int) (this.position - j);
                        return;
                    }
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr, i11, (byte) ((i | 128) & 255));
                    i >>>= 7;
                }
            } else {
                while (true) {
                    int i12 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                    byte[] bArr2 = this.buffer;
                    if (i12 == 0) {
                        int i13 = this.position;
                        this.position = i13 + 1;
                        bArr2[i13] = (byte) i;
                        this.totalBytesWritten++;
                        return;
                    }
                    int i14 = this.position;
                    this.position = i14 + 1;
                    bArr2[i14] = (byte) ((i | 128) & 255);
                    this.totalBytesWritten++;
                    i >>>= 7;
                }
            }
        }

        public final void bufferUInt64NoTag(long j) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j6 = this.position;
                while (true) {
                    long j10 = j & (-128);
                    byte[] bArr = this.buffer;
                    if (j10 == 0) {
                        int i = this.position;
                        this.position = i + 1;
                        UnsafeUtil.putByte(bArr, i, (byte) j);
                        this.totalBytesWritten += (int) (this.position - j6);
                        return;
                    }
                    int i6 = this.position;
                    this.position = i6 + 1;
                    UnsafeUtil.putByte(bArr, i6, (byte) ((((int) j) | 128) & 255));
                    j >>>= 7;
                }
            } else {
                while (true) {
                    long j11 = j & (-128);
                    byte[] bArr2 = this.buffer;
                    if (j11 == 0) {
                        int i10 = this.position;
                        this.position = i10 + 1;
                        bArr2[i10] = (byte) j;
                        this.totalBytesWritten++;
                        return;
                    }
                    int i11 = this.position;
                    this.position = i11 + 1;
                    bArr2[i11] = (byte) ((((int) j) | 128) & 255);
                    this.totalBytesWritten++;
                    j >>>= 7;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream.ArrayEncoder, androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static int computeBoolSize(int i, boolean z9) {
        return computeBoolSizeNoTag(z9) + computeTagSize(i);
    }

    public static int computeBoolSizeNoTag(boolean z9) {
        return 1;
    }

    public static int computeByteArraySize(int i, byte[] bArr) {
        return computeByteArraySizeNoTag(bArr) + computeTagSize(i);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i, ByteBuffer byteBuffer) {
        return computeByteBufferSizeNoTag(byteBuffer) + computeTagSize(i);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i, double d10) {
        return computeDoubleSizeNoTag(d10) + computeTagSize(i);
    }

    public static int computeDoubleSizeNoTag(double d10) {
        return 8;
    }

    public static int computeEnumSize(int i, int i6) {
        return computeEnumSizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i6) {
        return computeFixed32SizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j) {
        return computeFixed64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeFloatSizeNoTag(f) + computeTagSize(i);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite) {
        return messageLite.getSerializedSize() + (computeTagSize(i) * 2);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeInt32Size(int i, int i6) {
        return computeInt32SizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeInt32SizeNoTag(int i) {
        return computeUInt64SizeNoTag(i);
    }

    public static int computeInt64Size(int i, long j) {
        return computeInt64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSize(3, lazyFieldLite) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    public static int computeLazyFieldSize(int i, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSizeNoTag(lazyFieldLite) + computeTagSize(i);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        return computeMessageSize(3, messageLite) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeMessageSizeNoTag(messageLite) + computeTagSize(i);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static int computePreferredBufferSize(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        return computeBytesSize(3, byteString) + computeUInt32Size(2, i) + (computeTagSize(1) * 2);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i) {
        return computeUInt32SizeNoTag(i);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeSFixed32Size(int i, int i6) {
        return computeSFixed32SizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j) {
        return computeSFixed64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i6) {
        return computeSInt32SizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeSInt64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(i);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i, 0));
    }

    public static int computeUInt32Size(int i, int i6) {
        return computeUInt32SizeNoTag(i6) + computeTagSize(i);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int computeUInt64Size(int i, long j) {
        return computeUInt64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return UnsafeDirectNioEncoder.isSupported() ? newUnsafeInstance(byteBuffer) : newSafeInstance(byteBuffer);
        }
        a.p("ByteBuffer is read-only");
        return null;
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Did not write as much data as expected.");
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new OutOfSpaceException(e10);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void write(byte b7) throws IOException;

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i, int i6) throws IOException;

    public abstract void writeBool(int i, boolean z9) throws IOException;

    public final void writeBoolNoTag(boolean z9) throws IOException {
        write(z9 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException;

    public abstract void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i, double d10) throws IOException {
        writeFixed64(i, Double.doubleToRawLongBits(d10));
    }

    public final void writeDoubleNoTag(double d10) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d10));
    }

    public final void writeEnum(int i, int i6) throws IOException {
        writeInt32(i, i6);
    }

    public final void writeEnumNoTag(int i) throws IOException {
        writeInt32NoTag(i);
    }

    public abstract void writeFixed32(int i, int i6) throws IOException;

    public abstract void writeFixed32NoTag(int i) throws IOException;

    public abstract void writeFixed64(int i, long j) throws IOException;

    public abstract void writeFixed64NoTag(long j) throws IOException;

    public final void writeFloat(int i, float f) throws IOException {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public final void writeFloatNoTag(float f) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite) throws IOException {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    public abstract void writeInt32(int i, int i6) throws IOException;

    public abstract void writeInt32NoTag(int i) throws IOException;

    public final void writeInt64(int i, long j) throws IOException {
        writeUInt64(i, j);
    }

    public final void writeInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i, int i6) throws IOException;

    public abstract void writeMessage(int i, MessageLite messageLite) throws IOException;

    public abstract void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException;

    public final void writeRawByte(int i) throws IOException {
        write((byte) i);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i) throws IOException {
        writeFixed32NoTag(i);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public abstract void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException;

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i) throws IOException {
        writeUInt32NoTag(i);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    public final void writeSFixed32(int i, int i6) throws IOException {
        writeFixed32(i, i6);
    }

    public final void writeSFixed32NoTag(int i) throws IOException {
        writeFixed32NoTag(i);
    }

    public final void writeSFixed64(int i, long j) throws IOException {
        writeFixed64(i, j);
    }

    public final void writeSFixed64NoTag(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public final void writeSInt32(int i, int i6) throws IOException {
        writeUInt32(i, encodeZigZag32(i6));
    }

    public final void writeSInt32NoTag(int i) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j) throws IOException {
        writeUInt64(i, encodeZigZag64(j));
    }

    public final void writeSInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    public abstract void writeString(int i, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i, int i6) throws IOException;

    public abstract void writeUInt32(int i, int i6) throws IOException;

    public abstract void writeUInt32NoTag(int i) throws IOException;

    public abstract void writeUInt64(int i, long j) throws IOException;

    public abstract void writeUInt64NoTag(long j) throws IOException;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i, int i6) {
            super();
            if (bArr == null) {
                a.i("buffer");
                throw null;
            }
            int i10 = i + i6;
            if ((i | i6 | (bArr.length - i10)) < 0) {
                androidx.core.view.contentcapture.a.o("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)});
                throw null;
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z9) throws IOException {
            writeTag(i, 0);
            write(z9 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i6, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i6) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i6 = this.position;
                int i10 = i6 + 1;
                this.position = i10;
                bArr[i6] = (byte) (i & 255);
                int i11 = i6 + 2;
                this.position = i11;
                bArr[i10] = (byte) ((i >> 8) & 255);
                int i12 = i6 + 3;
                this.position = i12;
                bArr[i11] = (byte) ((i >> 16) & 255);
                this.position = i6 + 4;
                bArr[i12] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i6 = i + 1;
                this.position = i6;
                bArr[i] = (byte) (((int) j) & 255);
                int i10 = i + 2;
                this.position = i10;
                bArr[i6] = (byte) (((int) (j >> 8)) & 255);
                int i11 = i + 3;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j >> 16)) & 255);
                int i12 = i + 4;
                this.position = i12;
                bArr[i11] = (byte) (((int) (j >> 24)) & 255);
                int i13 = i + 5;
                this.position = i13;
                bArr[i12] = (byte) (((int) (j >> 32)) & 255);
                int i14 = i + 6;
                this.position = i14;
                bArr[i13] = (byte) (((int) (j >> 40)) & 255);
                int i15 = i + 7;
                this.position = i15;
                bArr[i14] = (byte) (((int) (j >> 48)) & 255);
                this.position = i + 8;
                bArr[i15] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i, int i6) throws IOException {
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 != computeUInt32SizeNoTag) {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                    return;
                }
                int i6 = i + computeUInt32SizeNoTag2;
                this.position = i6;
                int encode = Utf8.encode(str, this.buffer, i6, spaceLeft());
                this.position = i;
                writeUInt32NoTag((encode - i) - computeUInt32SizeNoTag2);
                this.position = encode;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = i;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeTag(int i, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws IOException {
            while (true) {
                int i6 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                byte[] bArr = this.buffer;
                if (i6 == 0) {
                    int i10 = this.position;
                    this.position = i10 + 1;
                    bArr[i10] = (byte) i;
                    return;
                } else {
                    try {
                        int i11 = this.position;
                        this.position = i11 + 1;
                        bArr[i11] = (byte) ((i | 128) & 255);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                    }
                }
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while (true) {
                    long j6 = j & (-128);
                    byte[] bArr = this.buffer;
                    if (j6 == 0) {
                        int i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) j;
                        return;
                    } else {
                        try {
                            int i6 = this.position;
                            this.position = i6 + 1;
                            bArr[i6] = (byte) ((((int) j) | 128) & 255);
                            j >>>= 7;
                        } catch (IndexOutOfBoundsException e10) {
                            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                        }
                    }
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                }
            }
            while (true) {
                long j10 = j & (-128);
                byte[] bArr2 = this.buffer;
                if (j10 == 0) {
                    int i10 = this.position;
                    this.position = i10 + 1;
                    UnsafeUtil.putByte(bArr2, i10, (byte) j);
                    return;
                } else {
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr2, i11, (byte) ((((int) j) | 128) & 255));
                    j >>>= 7;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public final void write(byte[] bArr, int i, int i6) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i6);
                this.position += i6;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i6)), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public final void write(byte b7) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b7;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.out = outputStream;
            } else {
                a.i("out");
                throw null;
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i = this.limit;
            int i6 = this.position;
            int i10 = i - i6;
            byte[] bArr = this.buffer;
            if (i10 >= remaining) {
                byteBuffer.get(bArr, i6, remaining);
                this.position += remaining;
                this.totalBytesWritten += remaining;
                return;
            }
            int i11 = i - i6;
            byteBuffer.get(bArr, i6, i11);
            int i12 = remaining - i11;
            this.position = this.limit;
            this.totalBytesWritten += i11;
            doFlush();
            while (true) {
                int i13 = this.limit;
                byte[] bArr2 = this.buffer;
                if (i12 <= i13) {
                    byteBuffer.get(bArr2, 0, i12);
                    this.position = i12;
                    this.totalBytesWritten += i12;
                    return;
                } else {
                    byteBuffer.get(bArr2, 0, i13);
                    this.out.write(this.buffer, 0, this.limit);
                    int i14 = this.limit;
                    i12 -= i14;
                    this.totalBytesWritten += i14;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z9) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            buffer(z9 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i6, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i6) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i6) throws IOException {
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int encodedLength;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i = computeUInt32SizeNoTag + length;
                int i6 = this.limit;
                if (i > i6) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i > i6 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i10 = this.position;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i11 = i10 + computeUInt32SizeNoTag2;
                        this.position = i11;
                        int encode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                        this.position = i10;
                        encodedLength = (encode2 - i10) - computeUInt32SizeNoTag2;
                        bufferUInt32NoTag(encodedLength);
                        this.position = encode2;
                    } else {
                        encodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(encodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    }
                    this.totalBytesWritten += encodedLength;
                } catch (Utf8.UnpairedSurrogateException e10) {
                    this.totalBytesWritten -= this.position - i10;
                    this.position = i10;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(e11);
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                inefficientWriteStringNoTag(str, e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i6) throws IOException {
            int i10 = this.limit;
            int i11 = this.position;
            int i12 = i10 - i11;
            byte[] bArr2 = this.buffer;
            if (i12 >= i6) {
                System.arraycopy(bArr, i, bArr2, i11, i6);
                this.position += i6;
                this.totalBytesWritten += i6;
                return;
            }
            int i13 = i10 - i11;
            System.arraycopy(bArr, i, bArr2, i11, i13);
            int i14 = i + i13;
            int i15 = i6 - i13;
            this.position = this.limit;
            this.totalBytesWritten += i13;
            doFlush();
            if (i15 <= this.limit) {
                System.arraycopy(bArr, i14, this.buffer, 0, i15);
                this.position = i15;
            } else {
                this.out.write(bArr, i14, i15);
            }
            this.totalBytesWritten += i15;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b7) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b7);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i6) throws IOException {
            try {
                this.buffer.put(bArr, i, i6);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z9) throws IOException {
            writeTag(i, 0);
            write(z9 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i6, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i6) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            try {
                this.buffer.putInt(i);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            try {
                this.buffer.putLong(j);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i6) throws IOException {
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 != computeUInt32SizeNoTag) {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                    return;
                }
                int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                Java8Compatibility.position(this.buffer, position2);
                encode(str);
                int position3 = this.buffer.position();
                Java8Compatibility.position(this.buffer, position);
                writeUInt32NoTag(position3 - position2);
                Java8Compatibility.position(this.buffer, position3);
            } catch (Utf8.UnpairedSurrogateException e10) {
                Java8Compatibility.position(this.buffer, position);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            while (true) {
                int i6 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                ByteBuffer byteBuffer = this.buffer;
                if (i6 == 0) {
                    byteBuffer.put((byte) i);
                    return;
                }
                try {
                    byteBuffer.put((byte) ((i | 128) & 255));
                    i >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            while (true) {
                long j6 = (-128) & j;
                ByteBuffer byteBuffer = this.buffer;
                if (j6 == 0) {
                    byteBuffer.put((byte) j);
                    return;
                }
                try {
                    byteBuffer.put((byte) ((((int) j) | 128) & 255));
                    j >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b7) throws IOException {
            try {
                this.buffer.put(b7);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            long position = byteBuffer.position() + addressOffset;
            this.initialPosition = position;
            long limit = addressOffset + byteBuffer.limit();
            this.limit = limit;
            this.oneVarintLimit = limit - 10;
            this.position = position;
        }

        private int bufferPos(long j) {
            return (int) (j - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j) {
            Java8Compatibility.position(this.buffer, bufferPos(j));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i6) throws IOException {
            if (bArr != null && i >= 0 && i6 >= 0 && bArr.length - i6 >= i) {
                long j = i6;
                long j6 = this.limit - j;
                long j10 = this.position;
                if (j6 >= j10) {
                    UnsafeUtil.copyMemory(bArr, i, j10, j);
                    this.position += j;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i6)));
            }
            a.i("value");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z9) throws IOException {
            writeTag(i, 0);
            write(z9 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i6, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i6) throws IOException {
            writeTag(i, 5);
            writeFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i);
            this.position += 4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws IOException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j);
            this.position += 8;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i6) throws IOException {
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long j = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 != computeUInt32SizeNoTag) {
                    int encodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(encodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += encodedLength;
                    return;
                }
                int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                Java8Compatibility.position(this.buffer, bufferPos);
                Utf8.encodeUtf8(str, this.buffer);
                int position = this.buffer.position() - bufferPos;
                writeUInt32NoTag(position);
                this.position += position;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = j;
                repositionBuffer(j);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i6) throws IOException {
            writeTag(i, 0);
            writeUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while (true) {
                    int i6 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                    long j = this.position;
                    if (i6 == 0) {
                        this.position = 1 + j;
                        UnsafeUtil.putByte(j, (byte) i);
                        return;
                    } else {
                        this.position = j + 1;
                        UnsafeUtil.putByte(j, (byte) ((i | 128) & 255));
                        i >>>= 7;
                    }
                }
            } else {
                while (true) {
                    long j6 = this.position;
                    if (j6 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j6), Long.valueOf(this.limit), 1));
                    }
                    if ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
                        this.position = 1 + j6;
                        UnsafeUtil.putByte(j6, (byte) i);
                        return;
                    } else {
                        this.position = j6 + 1;
                        UnsafeUtil.putByte(j6, (byte) ((i | 128) & 255));
                        i >>>= 7;
                    }
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws IOException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while (true) {
                    long j6 = j & (-128);
                    long j10 = this.position;
                    if (j6 == 0) {
                        this.position = 1 + j10;
                        UnsafeUtil.putByte(j10, (byte) j);
                        return;
                    } else {
                        this.position = j10 + 1;
                        UnsafeUtil.putByte(j10, (byte) ((((int) j) | 128) & 255));
                        j >>>= 7;
                    }
                }
            } else {
                while (true) {
                    long j11 = this.position;
                    if (j11 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j11), Long.valueOf(this.limit), 1));
                    }
                    if ((j & (-128)) == 0) {
                        this.position = 1 + j11;
                        UnsafeUtil.putByte(j11, (byte) j);
                        return;
                    } else {
                        this.position = j11 + 1;
                        UnsafeUtil.putByte(j11, (byte) ((((int) j) | 128) & 255));
                        j >>>= 7;
                    }
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b7) throws IOException {
            long j = this.position;
            if (j < this.limit) {
                this.position = 1 + j;
                UnsafeUtil.putByte(j, b7);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(this.limit), 1));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += remaining;
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    private CodedOutputStream() {
    }

    public final void writeRawByte(byte b7) throws IOException {
        write(b7);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i6) throws IOException {
        write(bArr, i, i6);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i) {
            super(i);
            if (byteOutput != null) {
                this.out = byteOutput;
            } else {
                a.i("out");
                throw null;
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z9) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            buffer(z9 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i6, int i10) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i6, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i6) throws IOException {
            writeUInt32NoTag(i6);
            write(bArr, i, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i6) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i = computeUInt32SizeNoTag + length;
            int i6 = this.limit;
            if (i > i6) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i > i6 - this.position) {
                doFlush();
            }
            int i10 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 != computeUInt32SizeNoTag) {
                    int encodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(encodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    this.totalBytesWritten += encodedLength;
                    return;
                }
                int i11 = i10 + computeUInt32SizeNoTag2;
                this.position = i11;
                int encode2 = Utf8.encode(str, this.buffer, i11, this.limit - i11);
                this.position = i10;
                int i12 = (encode2 - i10) - computeUInt32SizeNoTag2;
                bufferUInt32NoTag(i12);
                this.position = encode2;
                this.totalBytesWritten += i12;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.totalBytesWritten -= this.position - i10;
                this.position = i10;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i, int i6) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i6) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i, int i6) throws IOException {
            flush();
            this.out.write(bArr, i, i6);
            this.totalBytesWritten += i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i6) throws IOException {
            flush();
            this.out.writeLazy(bArr, i, i6);
            this.totalBytesWritten += i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b7) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b7);
        }
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo(this);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException(String str) {
            super(x.j("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str));
        }

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super(x.j("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }
    }

    public static int computeMessageSize(int i, MessageLite messageLite, Schema schema) {
        return computeMessageSizeNoTag(messageLite, schema) + computeTagSize(i);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite, Schema schema) {
        return computeGroupSizeNoTag(messageLite, schema) + (computeTagSize(i) * 2);
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i, 4);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new OutputStreamEncoder(outputStream, i);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i6) {
        return new ArrayEncoder(bArr, i, i6);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i) {
        if (i >= 0) {
            return new ByteOutputEncoder(byteOutput, i);
        }
        a.p("bufferSize must be positive");
        return null;
    }
}
