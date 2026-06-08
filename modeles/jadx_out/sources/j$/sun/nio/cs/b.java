package j$.sun.nio.cs;

import j$.util.Objects;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class b extends CharsetEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final e f5728a;

    @Override // java.nio.charset.CharsetEncoder
    public final boolean canEncode(char c9) {
        return c9 <= 255;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final boolean isLegalReplacement(byte[] bArr) {
        return true;
    }

    public b(c cVar) {
        super(cVar, 1.0f, 1.0f);
        e eVar = new e();
        eVar.f5731a = CoderResult.UNDERFLOW;
        this.f5728a = eVar;
    }

    public static int a(char[] cArr, int i, byte[] bArr, int i6, int i10) {
        int i11 = 0;
        if (i10 <= 0) {
            return 0;
        }
        Objects.requireNonNull(cArr);
        Objects.requireNonNull(bArr);
        if (i < 0 || i >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i6 < 0 || i6 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i6);
        }
        int i12 = (i + i10) - 1;
        if (i12 < 0 || i12 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i12);
        }
        int i13 = (i6 + i10) - 1;
        if (i13 < 0 || i13 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i13);
        }
        while (i11 < i10) {
            int i14 = i + 1;
            char c9 = cArr[i];
            if (c9 > 255) {
                break;
            }
            bArr[i6] = (byte) c9;
            i11++;
            i = i14;
            i6++;
        }
        return i11;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        CoderResult coderResult;
        CoderResult coderResult2;
        int i = 2;
        if (!charBuffer.hasArray() || !byteBuffer.hasArray()) {
            int position = charBuffer.position();
            while (true) {
                try {
                    if (!charBuffer.hasRemaining()) {
                        coderResult = CoderResult.UNDERFLOW;
                        break;
                    }
                    char c9 = charBuffer.get();
                    if (c9 > 255) {
                        int a8 = this.f5728a.a(c9, charBuffer);
                        e eVar = this.f5728a;
                        if (a8 < 0) {
                            coderResult = eVar.f5731a;
                        } else {
                            if (!eVar.f5732b) {
                                i = 1;
                            }
                            coderResult = CoderResult.unmappableForLength(i);
                        }
                    } else {
                        if (!byteBuffer.hasRemaining()) {
                            coderResult = CoderResult.OVERFLOW;
                            break;
                        }
                        byteBuffer.put((byte) c9);
                        position++;
                    }
                } finally {
                }
            }
            return coderResult;
        }
        char[] array = charBuffer.array();
        int arrayOffset = charBuffer.arrayOffset();
        int position2 = charBuffer.position() + arrayOffset;
        int limit = charBuffer.limit() + arrayOffset;
        if (position2 > limit) {
            position2 = limit;
        }
        byte[] array2 = byteBuffer.array();
        int arrayOffset2 = byteBuffer.arrayOffset();
        int position3 = byteBuffer.position() + arrayOffset2;
        int limit2 = byteBuffer.limit() + arrayOffset2;
        if (position3 > limit2) {
            position3 = limit2;
        }
        int i6 = limit2 - position3;
        int i10 = limit - position2;
        if (i6 >= i10) {
            i6 = i10;
        }
        try {
            int a10 = a(array, position2, array2, position3, i6);
            int i11 = position2 + a10;
            int i12 = position3 + a10;
            if (a10 != i6) {
                int b7 = this.f5728a.b(array[i11], array, i11, limit);
                e eVar2 = this.f5728a;
                if (b7 < 0) {
                    coderResult2 = eVar2.f5731a;
                } else {
                    if (!eVar2.f5732b) {
                        i = 1;
                    }
                    coderResult2 = CoderResult.unmappableForLength(i);
                }
            } else {
                coderResult2 = i6 < i10 ? CoderResult.OVERFLOW : CoderResult.UNDERFLOW;
            }
            return coderResult2;
        } catch (Throwable th) {
            throw th;
        }
    }
}
