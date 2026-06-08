package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Utf8Safe extends Utf8 {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i6) {
            super("Unpaired surrogate at index " + i + " of " + i6);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i6 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(charSequence, i);
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

    public static String decodeUtf8Array(byte[] bArr, int i, int i6) {
        if ((i | i6 | ((bArr.length - i) - i6)) < 0) {
            androidx.core.view.contentcapture.a.l("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)});
            return null;
        }
        int i10 = i + i6;
        char[] cArr = new char[i6];
        int i11 = 0;
        while (i < i10) {
            byte b7 = bArr[i];
            if (!Utf8.DecodeUtil.isOneByte(b7)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i < i10) {
            int i13 = i + 1;
            byte b10 = bArr[i];
            if (Utf8.DecodeUtil.isOneByte(b10)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b10, cArr, i12);
                while (i13 < i10) {
                    byte b11 = bArr[i13];
                    if (!Utf8.DecodeUtil.isOneByte(b11)) {
                        break;
                    }
                    i13++;
                    Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i = i13;
            } else if (Utf8.DecodeUtil.isTwoBytes(b10)) {
                if (i13 >= i10) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                i += 2;
                Utf8.DecodeUtil.handleTwoBytes(b10, bArr[i13], cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b10)) {
                if (i13 >= i10 - 1) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                int i15 = i + 2;
                i += 3;
                Utf8.DecodeUtil.handleThreeBytes(b10, bArr[i13], bArr[i15], cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                byte b12 = bArr[i13];
                int i16 = i + 3;
                byte b13 = bArr[i + 2];
                i += 4;
                Utf8.DecodeUtil.handleFourBytes(b10, b12, b13, bArr[i16], cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i6) {
        if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
            androidx.core.view.contentcapture.a.l("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)});
            return null;
        }
        int i10 = i + i6;
        char[] cArr = new char[i6];
        int i11 = 0;
        while (i < i10) {
            byte b7 = byteBuffer.get(i);
            if (!Utf8.DecodeUtil.isOneByte(b7)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i < i10) {
            int i13 = i + 1;
            byte b10 = byteBuffer.get(i);
            if (Utf8.DecodeUtil.isOneByte(b10)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b10, cArr, i12);
                while (i13 < i10) {
                    byte b11 = byteBuffer.get(i13);
                    if (!Utf8.DecodeUtil.isOneByte(b11)) {
                        break;
                    }
                    i13++;
                    Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i = i13;
            } else if (Utf8.DecodeUtil.isTwoBytes(b10)) {
                if (i13 >= i10) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                i += 2;
                Utf8.DecodeUtil.handleTwoBytes(b10, byteBuffer.get(i13), cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b10)) {
                if (i13 >= i10 - 1) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                int i15 = i + 2;
                i += 3;
                Utf8.DecodeUtil.handleThreeBytes(b10, byteBuffer.get(i13), byteBuffer.get(i15), cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    com.google.gson.internal.a.p("Invalid UTF-8");
                    return null;
                }
                byte b12 = byteBuffer.get(i13);
                int i16 = i + 3;
                byte b13 = byteBuffer.get(i + 2);
                i += 4;
                Utf8.DecodeUtil.handleFourBytes(b10, b12, b13, byteBuffer.get(i16), cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int encodeUtf8Array(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.flatbuffer.Utf8Safe.encodeUtf8Array(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i6 = 0;
        while (i6 < length) {
            try {
                char charAt = charSequence.charAt(i6);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i6, (byte) charAt);
                i6++;
            } catch (IndexOutOfBoundsException unused) {
                androidx.core.view.contentcapture.a.e(charSequence.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                return;
            }
        }
        if (i6 == length) {
            byteBuffer.position(position + i6);
            return;
        }
        position += i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
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
                    androidx.core.view.contentcapture.a.e(charSequence.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
                    return;
                }
            } else {
                if (charAt2 >= 55296 && 57343 >= charAt2) {
                    int i11 = i6 + 1;
                    if (i11 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i11);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i12 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    i = position + 2;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i12;
                                    i6 = i11;
                                    androidx.core.view.contentcapture.a.e(charSequence.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
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
                                    androidx.core.view.contentcapture.a.e(charSequence.charAt(i6), Math.max(i6, (position - byteBuffer.position()) + 1) + byteBuffer.position());
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
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i6 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i6;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i6) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i6) : decodeUtf8Buffer(byteBuffer, i, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
