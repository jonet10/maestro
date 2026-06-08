package j$.time.format;

import j$.util.Objects;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j implements f {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f5836d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e, reason: collision with root package name */
    public static final j f5837e = new j("+HH:MM:ss", "Z");

    /* renamed from: a, reason: collision with root package name */
    public final String f5838a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5839b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5840c;

    static {
        new j("+HH:MM:ss", "0");
    }

    public j(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        Objects.requireNonNull(str2, "noOffsetText");
        for (int i = 0; i < 22; i++) {
            if (f5836d[i].equals(str)) {
                this.f5839b = i;
                this.f5840c = i % 11;
                this.f5838a = str2;
                return;
            }
        }
        j$.time.g.c("Invalid zone offset pattern: ".concat(str));
        throw null;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        Long a8 = pVar.a(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z9 = false;
        if (a8 == null) {
            return false;
        }
        long longValue = a8.longValue();
        int i = (int) longValue;
        if (longValue != i) {
            throw new ArithmeticException();
        }
        String str = this.f5838a;
        if (i == 0) {
            sb.append(str);
            return true;
        }
        int abs = Math.abs((i / 3600) % 100);
        int abs2 = Math.abs((i / 60) % 60);
        int abs3 = Math.abs(i % 60);
        int length = sb.length();
        sb.append(i < 0 ? "-" : "+");
        if (this.f5839b >= 11 && abs < 10) {
            sb.append((char) (abs + 48));
        } else {
            a(false, abs, sb);
        }
        int i6 = this.f5840c;
        if ((i6 >= 3 && i6 <= 8) || ((i6 >= 9 && abs3 > 0) || (i6 >= 1 && abs2 > 0))) {
            a(i6 > 0 && i6 % 2 == 0, abs2, sb);
            abs += abs2;
            if (i6 == 7 || i6 == 8 || (i6 >= 5 && abs3 > 0)) {
                if (i6 > 0 && i6 % 2 == 0) {
                    z9 = true;
                }
                a(z9, abs3, sb);
                abs += abs3;
            }
        }
        if (abs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    public static void a(boolean z9, int i, StringBuilder sb) {
        sb.append(z9 ? ":" : "");
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
    }

    public final String toString() {
        String replace = this.f5838a.replace("'", "''");
        return "Offset(" + f5836d[this.f5839b] + ",'" + replace + "')";
    }
}
