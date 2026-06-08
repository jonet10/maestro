package j$.sun.nio.cs;

import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public CoderResult f5731a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5732b;

    public final int a(char c9, CharBuffer charBuffer) {
        if (Character.isHighSurrogate(c9)) {
            if (!charBuffer.hasRemaining()) {
                this.f5731a = CoderResult.UNDERFLOW;
                return -1;
            }
            char c10 = charBuffer.get();
            if (Character.isLowSurrogate(c10)) {
                int codePoint = Character.toCodePoint(c9, c10);
                this.f5732b = true;
                this.f5731a = null;
                return codePoint;
            }
            this.f5731a = CoderResult.malformedForLength(1);
            return -1;
        }
        if (Character.isLowSurrogate(c9)) {
            this.f5731a = CoderResult.malformedForLength(1);
            return -1;
        }
        this.f5732b = false;
        this.f5731a = null;
        return c9;
    }

    public final int b(char c9, char[] cArr, int i, int i6) {
        if (!Character.isHighSurrogate(c9)) {
            if (Character.isLowSurrogate(c9)) {
                this.f5731a = CoderResult.malformedForLength(1);
                return -1;
            }
            this.f5732b = false;
            this.f5731a = null;
            return c9;
        }
        if (i6 - i < 2) {
            this.f5731a = CoderResult.UNDERFLOW;
            return -1;
        }
        char c10 = cArr[i + 1];
        if (Character.isLowSurrogate(c10)) {
            int codePoint = Character.toCodePoint(c9, c10);
            this.f5732b = true;
            this.f5731a = null;
            return codePoint;
        }
        this.f5731a = CoderResult.malformedForLength(1);
        return -1;
    }
}
