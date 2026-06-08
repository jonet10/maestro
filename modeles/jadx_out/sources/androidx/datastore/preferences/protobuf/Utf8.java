package androidx.datastore.preferences.protobuf;

import androidx.core.view.contentcapture.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b7, byte b10, byte b11, byte b12, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b10)) {
                if ((((b10 + 112) + (b7 << 28)) >> 30) == 0 && !isNotTrailingByte(b11) && !isNotTrailingByte(b12)) {
                    int trailingByteValue = ((b7 & 7) << 18) | (trailingByteValue(b10) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12);
                    cArr[i] = highSurrogate(trailingByteValue);
                    cArr[i + 1] = lowSurrogate(trailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b7, char[] cArr, int i) {
            cArr[i] = (char) b7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b7, byte b10, byte b11, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b10) || ((b7 == -32 && b10 < -96) || ((b7 == -19 && b10 >= -96) || isNotTrailingByte(b11)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b7 & 15) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b7, byte b10, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b7 < -62 || isNotTrailingByte(b10)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b7 & 31) << 6) | trailingByteValue(b10));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b7) {
            return b7 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b7) {
            return b7 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b7) {
            return b7 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b7) {
            return b7 < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + 56320);
        }

        private static int trailingByteValue(byte b7) {
            return b7 & 63;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i6) {
            super("Unpaired surrogate at index " + i + " of " + i6);
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i, i6);
    }

    public static int encode(String str, byte[] bArr, int i, int i6) {
        return processor.encodeUtf8(str, bArr, i, i6);
    }

    public static void encodeUtf8(String str, ByteBuffer byteBuffer) {
        processor.encodeUtf8(str, byteBuffer);
    }

    public static int encodedLength(String str) {
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) < 128) {
            i++;
        }
        int i6 = length;
        while (true) {
            if (i < length) {
                char charAt = str.charAt(i);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(str, i);
                    break;
                }
                i6 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i6 + 4294967296L));
    }

    private static int encodedLengthGeneral(String str, int i) {
        int length = str.length();
        int i6 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(str, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i6) {
        int i10 = i6 - 7;
        int i11 = i;
        while (i11 < i10 && (byteBuffer.getLong(i11) & (-9187201950435737472L)) == 0) {
            i11 += 8;
        }
        return i11 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i6, int i10) {
        if (i10 == 0) {
            return incompleteStateFor(i);
        }
        if (i10 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i6));
        }
        if (i10 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i6), byteBuffer.get(i6 + 1));
        }
        throw new AssertionError();
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i6, int i10) {
        return processor.partialIsValidUtf8(i, bArr, i6, i10);
    }

    public static String decodeUtf8(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i6);
    }

    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i6, int i10) {
        return processor.partialIsValidUtf8(i, byteBuffer, i6, i10);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Processor {
        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i6) {
            int estimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i6);
            while (estimateConsecutiveAscii < i6) {
                int i10 = estimateConsecutiveAscii + 1;
                byte b7 = byteBuffer.get(estimateConsecutiveAscii);
                if (b7 >= 0) {
                    estimateConsecutiveAscii = i10;
                } else if (b7 < -32) {
                    if (i10 >= i6) {
                        return b7;
                    }
                    if (b7 < -62 || byteBuffer.get(i10) > -65) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 2;
                } else {
                    if (b7 >= -16) {
                        if (i10 >= i6 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b7, i10, i6 - i10);
                        }
                        int i11 = estimateConsecutiveAscii + 2;
                        byte b10 = byteBuffer.get(i10);
                        if (b10 <= -65) {
                            if ((((b10 + 112) + (b7 << 28)) >> 30) == 0) {
                                int i12 = estimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i11) <= -65) {
                                    estimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i12) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i6 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b7, i10, i6 - i10);
                    }
                    int i13 = estimateConsecutiveAscii + 2;
                    byte b11 = byteBuffer.get(i10);
                    if (b11 > -65 || ((b7 == -32 && b11 < -96) || ((b7 == -19 && b11 >= -96) || byteBuffer.get(i13) > -65))) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }

        public final String decodeUtf8(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i6);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i6) : decodeUtf8Default(byteBuffer, i, i6);
        }

        public abstract String decodeUtf8(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException;

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
            if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
                a.l("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)});
                return null;
            }
            int i10 = i + i6;
            char[] cArr = new char[i6];
            int i11 = 0;
            while (i < i10) {
                byte b7 = byteBuffer.get(i);
                if (!DecodeUtil.isOneByte(b7)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b7, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i < i10) {
                int i13 = i + 1;
                byte b10 = byteBuffer.get(i);
                if (DecodeUtil.isOneByte(b10)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    while (i13 < i10) {
                        byte b11 = byteBuffer.get(i13);
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i = i13;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b10, byteBuffer.get(i13), cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b10, byteBuffer.get(i13), byteBuffer.get(i15), cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = byteBuffer.get(i13);
                    int i16 = i + 3;
                    byte b13 = byteBuffer.get(i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, byteBuffer.get(i16), cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(String str, byte[] bArr, int i, int i6);

        public final void encodeUtf8(String str, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.position(byteBuffer, Utf8.encode(str, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(str, byteBuffer);
            } else {
                encodeUtf8Default(str, byteBuffer);
            }
        }

        public final void encodeUtf8Default(String str, ByteBuffer byteBuffer) {
            int i;
            int length = str.length();
            int position = byteBuffer.position();
            int i6 = 0;
            while (i6 < length) {
                try {
                    char charAt = str.charAt(i6);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i6, (byte) charAt);
                    i6++;
                } catch (IndexOutOfBoundsException unused) {
                    a.e(str.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                    return;
                }
            }
            if (i6 == length) {
                Java8Compatibility.position(byteBuffer, position + i6);
                return;
            }
            position += i6;
            while (i6 < length) {
                char charAt2 = str.charAt(i6);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i10 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i10, (byte) ((charAt2 & '?') | 128));
                        position = i10;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i10;
                        a.e(str.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                        return;
                    }
                } else {
                    if (charAt2 >= 55296 && 57343 >= charAt2) {
                        int i11 = i6 + 1;
                        if (i11 != length) {
                            try {
                                char charAt3 = str.charAt(i11);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i12 = position + 1;
                                    try {
                                        byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                        i = position + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        position = i12;
                                        i6 = i11;
                                        a.e(str.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                                        return;
                                    }
                                    try {
                                        byteBuffer.put(i12, (byte) (((codePoint >>> 12) & 63) | 128));
                                        position += 3;
                                        byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                        i6 = i11;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i6 = i11;
                                        position = i;
                                        a.e(str.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                                        return;
                                    }
                                } else {
                                    i6 = i11;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i6, length);
                    }
                    int i13 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position += 2;
                    byteBuffer.put(i13, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                }
                i6++;
                position++;
            }
            Java8Compatibility.position(byteBuffer, position);
        }

        public abstract void encodeUtf8Direct(String str, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i, int i6) {
            return partialIsValidUtf8(0, bArr, i, i6) == 0;
        }

        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i6, int i10);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i6, int i10);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i6) {
            return partialIsValidUtf8(0, byteBuffer, i, i6) == 0;
        }

        public final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i6, int i10) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i, byteBuffer.array(), i6 + arrayOffset, arrayOffset + i10);
            }
            if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i, byteBuffer, i6, i10);
            }
            return partialIsValidUtf8Default(i, byteBuffer, i6, i10);
        }
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i6) {
        return processor.isValidUtf8(bArr, i, i6);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i6) {
        if (i > -12 || i6 > -65) {
            return -1;
        }
        return i ^ (i6 << 8);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i6 = 0;
            if (i < 16) {
                return 0;
            }
            int i10 = 8 - (((int) j) & 7);
            while (i6 < i10) {
                long j6 = 1 + j;
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i6;
                }
                i6++;
                j = j6;
            }
            while (true) {
                int i11 = i6 + 8;
                if (i11 > i || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j += 8;
                i6 = i11;
            }
            while (i6 < i) {
                long j10 = j + 1;
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i6;
                }
                i6++;
                j = j10;
            }
            return i;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i, i6, charset);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i6 + i))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
            int i10;
            if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
                a.l("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)});
                return null;
            }
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + i;
            long j = i6 + addressOffset;
            char[] cArr = new char[i6];
            int i11 = 0;
            while (addressOffset < j) {
                byte b7 = UnsafeUtil.getByte(addressOffset);
                if (!DecodeUtil.isOneByte(b7)) {
                    break;
                }
                addressOffset++;
                DecodeUtil.handleOneByte(b7, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (addressOffset < j) {
                long j6 = addressOffset + 1;
                byte b10 = UnsafeUtil.getByte(addressOffset);
                if (DecodeUtil.isOneByte(b10)) {
                    i10 = i12 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    while (j6 < j) {
                        byte b11 = UnsafeUtil.getByte(j6);
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        j6++;
                        DecodeUtil.handleOneByte(b11, cArr, i10);
                        i10++;
                    }
                    addressOffset = j6;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (j6 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    addressOffset += 2;
                    DecodeUtil.handleTwoBytes(b10, UnsafeUtil.getByte(j6), cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (j6 >= j - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j10 = 2 + addressOffset;
                    addressOffset += 3;
                    i10 = i12 + 1;
                    DecodeUtil.handleThreeBytes(b10, UnsafeUtil.getByte(j6), UnsafeUtil.getByte(j10), cArr, i12);
                } else {
                    if (j6 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = UnsafeUtil.getByte(j6);
                    long j11 = addressOffset + 3;
                    byte b13 = UnsafeUtil.getByte(2 + addressOffset);
                    addressOffset += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, UnsafeUtil.getByte(j11), cArr, i12);
                    i12 += 2;
                }
                i12 = i10;
            }
            return new String(cArr, 0, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int encodeUtf8(String str, byte[] bArr, int i, int i6) {
            long j;
            long j6;
            int i10;
            char charAt;
            long j10 = i;
            long j11 = i6 + j10;
            int length = str.length();
            if (length > i6 || bArr.length - i6 < i) {
                a.e(str.charAt(length - 1), i + i6);
                return 0;
            }
            int i11 = 0;
            while (true) {
                j = 1;
                if (i11 >= length || (charAt = str.charAt(i11)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j10, (byte) charAt);
                i11++;
                j10 = 1 + j10;
            }
            if (i11 == length) {
                return (int) j10;
            }
            while (i11 < length) {
                char charAt2 = str.charAt(i11);
                if (charAt2 < 128 && j10 < j11) {
                    UnsafeUtil.putByte(bArr, j10, (byte) charAt2);
                    j6 = j;
                    j10 += j;
                } else if (charAt2 >= 2048 || j10 > j11 - 2) {
                    j6 = j;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || j10 > j11 - 3) {
                        if (j10 > j11 - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i10 = i11 + 1) == length || !Character.isSurrogatePair(charAt2, str.charAt(i10)))) {
                                throw new UnpairedSurrogateException(i11, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j10);
                        }
                        int i12 = i11 + 1;
                        if (i12 != length) {
                            char charAt3 = str.charAt(i12);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                UnsafeUtil.putByte(bArr, j10, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.putByte(bArr, j10 + j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j12 = j10 + 3;
                                UnsafeUtil.putByte(bArr, 2 + j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                j10 += 4;
                                UnsafeUtil.putByte(bArr, j12, (byte) ((codePoint & 63) | 128));
                                i11 = i12;
                            } else {
                                i11 = i12;
                            }
                        }
                        throw new UnpairedSurrogateException(i11 - 1, length);
                    }
                    UnsafeUtil.putByte(bArr, j10, (byte) ((charAt2 >>> '\f') | 480));
                    long j13 = 2 + j10;
                    UnsafeUtil.putByte(bArr, j10 + j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                    j10 += 3;
                    UnsafeUtil.putByte(bArr, j13, (byte) ((charAt2 & '?') | 128));
                } else {
                    j6 = j;
                    long j14 = j10 + j6;
                    UnsafeUtil.putByte(bArr, j10, (byte) ((charAt2 >>> 6) | 960));
                    j10 += 2;
                    UnsafeUtil.putByte(bArr, j14, (byte) ((charAt2 & '?') | 128));
                }
                i11++;
                j = j6;
            }
            return (int) j10;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String str, ByteBuffer byteBuffer) {
            long j;
            char c9;
            long j6;
            long j10;
            char c10;
            int i;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long position = byteBuffer.position() + addressOffset;
            long limit = byteBuffer.limit() + addressOffset;
            int length = str.length();
            if (length > limit - position) {
                a.e(str.charAt(length - 1), byteBuffer.limit());
                return;
            }
            int i6 = 0;
            while (true) {
                j = 1;
                c9 = 128;
                if (i6 >= length || (charAt = str.charAt(i6)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(position, (byte) charAt);
                i6++;
                position = 1 + position;
            }
            if (i6 == length) {
                Java8Compatibility.position(byteBuffer, (int) (position - addressOffset));
                return;
            }
            while (i6 < length) {
                char charAt2 = str.charAt(i6);
                if (charAt2 < c9 && position < limit) {
                    UnsafeUtil.putByte(position, (byte) charAt2);
                    j10 = addressOffset;
                    j6 = j;
                    position += j;
                } else if (charAt2 >= 2048 || position > limit - 2) {
                    j6 = j;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || position > limit - 3) {
                        if (position > limit - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i = i6 + 1) == length || !Character.isSurrogatePair(charAt2, str.charAt(i)))) {
                                throw new UnpairedSurrogateException(i6, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                        }
                        int i10 = i6 + 1;
                        if (i10 != length) {
                            char charAt3 = str.charAt(i10);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                UnsafeUtil.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                j10 = addressOffset;
                                c10 = 128;
                                UnsafeUtil.putByte(position + j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = position + 3;
                                UnsafeUtil.putByte(position + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                position += 4;
                                UnsafeUtil.putByte(j11, (byte) ((codePoint & 63) | 128));
                                i6 = i10;
                            } else {
                                i6 = i10;
                            }
                        }
                        throw new UnpairedSurrogateException(i6 - 1, length);
                    }
                    UnsafeUtil.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                    long j12 = position + 2;
                    UnsafeUtil.putByte(position + j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                    position += 3;
                    UnsafeUtil.putByte(j12, (byte) ((charAt2 & '?') | 128));
                    j10 = addressOffset;
                    c10 = 128;
                    i6++;
                    c9 = c10;
                    j = j6;
                    addressOffset = j10;
                } else {
                    j6 = j;
                    long j13 = position + j6;
                    UnsafeUtil.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                    position += 2;
                    UnsafeUtil.putByte(j13, (byte) ((charAt2 & '?') | c9));
                    j10 = addressOffset;
                }
                c10 = c9;
                i6++;
                c9 = c10;
                j = j6;
                addressOffset = j10;
            }
            Java8Compatibility.position(byteBuffer, (int) (position - addressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r13, r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r13, r2) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 198
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a8, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 211
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i6 = (int) ((-j) & 7);
            int i10 = i6;
            while (i10 > 0) {
                long j6 = 1 + j;
                if (UnsafeUtil.getByte(j) < 0) {
                    return i6 - i10;
                }
                i10--;
                j = j6;
            }
            int i11 = i - i6;
            while (i11 >= 8 && (UnsafeUtil.getLong(j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i11 -= 8;
            }
            return i - i11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i6, int i10) {
        if (i > -12 || i6 > -65 || i10 > -65) {
            return -1;
        }
        return (i ^ (i6 << 8)) ^ (i10 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i6) {
        byte b7 = bArr[i - 1];
        int i10 = i6 - i;
        if (i10 == 0) {
            return incompleteStateFor(b7);
        }
        if (i10 == 1) {
            return incompleteStateFor(b7, bArr[i]);
        }
        if (i10 == 2) {
            return incompleteStateFor(b7, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i6) {
            while (i < i6) {
                int i10 = i + 1;
                byte b7 = bArr[i];
                if (b7 < 0) {
                    if (b7 < -32) {
                        if (i10 >= i6) {
                            return b7;
                        }
                        if (b7 >= -62) {
                            i += 2;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b7 < -16) {
                        if (i10 >= i6 - 1) {
                            return Utf8.incompleteStateFor(bArr, i10, i6);
                        }
                        int i11 = i + 2;
                        byte b10 = bArr[i10];
                        if (b10 <= -65 && ((b7 != -32 || b10 >= -96) && (b7 != -19 || b10 < -96))) {
                            i += 3;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i10 >= i6 - 2) {
                        return Utf8.incompleteStateFor(bArr, i10, i6);
                    }
                    int i12 = i + 2;
                    byte b11 = bArr[i10];
                    if (b11 <= -65) {
                        if ((((b11 + 112) + (b7 << 28)) >> 30) == 0) {
                            int i13 = i + 3;
                            if (bArr[i12] <= -65) {
                                i += 4;
                                if (bArr[i13] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i = i10;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException {
            if ((i | i6 | ((bArr.length - i) - i6)) < 0) {
                a.l("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)});
                return null;
            }
            int i10 = i + i6;
            char[] cArr = new char[i6];
            int i11 = 0;
            while (i < i10) {
                byte b7 = bArr[i];
                if (!DecodeUtil.isOneByte(b7)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b7, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i < i10) {
                int i13 = i + 1;
                byte b10 = bArr[i];
                if (DecodeUtil.isOneByte(b10)) {
                    int i14 = i12 + 1;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    while (i13 < i10) {
                        byte b11 = bArr[i13];
                        if (!DecodeUtil.isOneByte(b11)) {
                            break;
                        }
                        i13++;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i = i13;
                } else if (DecodeUtil.isTwoBytes(b10)) {
                    if (i13 >= i10) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b10, bArr[i13], cArr, i12);
                    i12++;
                } else if (DecodeUtil.isThreeBytes(b10)) {
                    if (i13 >= i10 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i15 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b10, bArr[i13], bArr[i15], cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b12 = bArr[i13];
                    int i16 = i + 3;
                    byte b13 = bArr[i + 2];
                    i += 4;
                    DecodeUtil.handleFourBytes(b10, b12, b13, bArr[i16], cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i, i6);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int encodeUtf8(java.lang.String r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 251
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.String, byte[], int, int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String str, ByteBuffer byteBuffer) {
            encodeUtf8Default(str, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i6, int i10) {
            return partialIsValidUtf8Default(i, byteBuffer, i6, i10);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i6) {
            while (i < i6 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i6) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i6);
        }
    }
}
