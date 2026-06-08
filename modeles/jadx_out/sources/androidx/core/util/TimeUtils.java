package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i, int i6, boolean z9, int i10) {
        if (i > 99 || (z9 && i10 >= 3)) {
            return i6 + 3;
        }
        if (i > 9 || (z9 && i10 >= 2)) {
            return i6 + 2;
        }
        if (z9 || i > 0) {
            return i6 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    private static int formatDurationLocked(long j, int i) {
        char c9;
        int i6;
        int i10;
        int i11;
        int i12;
        long j6 = j;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j6 == 0) {
            int i13 = i - 1;
            while (i13 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j6 > 0) {
            c9 = '+';
        } else {
            j6 = -j6;
            c9 = '-';
        }
        int i14 = (int) (j6 % 1000);
        int floor = (int) Math.floor(j6 / 1000);
        if (floor > SECONDS_PER_DAY) {
            i6 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i6;
        } else {
            i6 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i10 = floor / SECONDS_PER_HOUR;
            floor -= i10 * SECONDS_PER_HOUR;
        } else {
            i10 = 0;
        }
        if (floor > SECONDS_PER_MINUTE) {
            int i15 = floor / SECONDS_PER_MINUTE;
            floor -= i15 * SECONDS_PER_MINUTE;
            i11 = i15;
        } else {
            i11 = 0;
        }
        if (i != 0) {
            int accumField = accumField(i6, 1, false, 0);
            int accumField2 = accumField + accumField(i10, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i11, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(floor, 1, accumField3 > 0, 2);
            i12 = 0;
            for (int accumField5 = accumField(i14, 2, true, accumField4 > 0 ? 3 : 0) + 1 + accumField4; accumField5 < i; accumField5++) {
                cArr[i12] = ' ';
                i12++;
            }
        } else {
            i12 = 0;
        }
        cArr[i12] = c9;
        int i16 = i12 + 1;
        boolean z9 = i != 0;
        int printField = printField(cArr, i6, 'd', i16, false, 0);
        int printField2 = printField(cArr, i10, 'h', printField, printField != i16, z9 ? 2 : 0);
        int printField3 = printField(cArr, i11, 'm', printField2, printField2 != i16, z9 ? 2 : 0);
        int printField4 = printField(cArr, floor, 's', printField3, printField3 != i16, z9 ? 2 : 0);
        int printField5 = printField(cArr, i14, 'm', printField4, true, (!z9 || printField4 == i16) ? 0 : 3);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c9, int i6, boolean z9, int i10) {
        int i11;
        if (!z9 && i <= 0) {
            return i6;
        }
        if ((!z9 || i10 < 3) && i <= 99) {
            i11 = i6;
        } else {
            int i12 = i / 100;
            cArr[i6] = (char) (i12 + 48);
            i11 = i6 + 1;
            i -= i12 * 100;
        }
        if ((z9 && i10 >= 2) || i > 9 || i6 != i11) {
            int i13 = i / 10;
            cArr[i11] = (char) (i13 + 48);
            i11++;
            i -= i13 * 10;
        }
        cArr[i11] = (char) (i + 48);
        cArr[i11 + 1] = c9;
        return i11 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, long j6, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j6, printWriter, 0);
        }
    }
}
