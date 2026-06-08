package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DecodeUtil {
        public static void handleFourBytes(byte b7, byte b10, byte b11, byte b12, char[] cArr, int i) throws IllegalArgumentException {
            if (!isNotTrailingByte(b10)) {
                if ((((b10 + 112) + (b7 << 28)) >> 30) == 0 && !isNotTrailingByte(b11) && !isNotTrailingByte(b12)) {
                    int trailingByteValue = ((b7 & 7) << 18) | (trailingByteValue(b10) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12);
                    cArr[i] = highSurrogate(trailingByteValue);
                    cArr[i + 1] = lowSurrogate(trailingByteValue);
                    return;
                }
            }
            com.google.gson.internal.a.p("Invalid UTF-8");
        }

        public static void handleOneByte(byte b7, char[] cArr, int i) {
            cArr[i] = (char) b7;
        }

        public static void handleThreeBytes(byte b7, byte b10, byte b11, char[] cArr, int i) throws IllegalArgumentException {
            if (isNotTrailingByte(b10) || ((b7 == -32 && b10 < -96) || ((b7 == -19 && b10 >= -96) || isNotTrailingByte(b11)))) {
                com.google.gson.internal.a.p("Invalid UTF-8");
            } else {
                cArr[i] = (char) (((b7 & 15) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11));
            }
        }

        public static void handleTwoBytes(byte b7, byte b10, char[] cArr, int i) throws IllegalArgumentException {
            if (b7 < -62) {
                com.google.gson.internal.a.p("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            } else if (isNotTrailingByte(b10)) {
                com.google.gson.internal.a.p("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            } else {
                cArr[i] = (char) (((b7 & 31) << 6) | trailingByteValue(b10));
            }
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b7) {
            return b7 > -65;
        }

        public static boolean isOneByte(byte b7) {
            return b7 >= 0;
        }

        public static boolean isThreeBytes(byte b7) {
            return b7 < -16;
        }

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

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i, int i6);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
