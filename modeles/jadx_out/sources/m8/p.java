package m8;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f7771k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f7772l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f7773m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f7774a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7775b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7776c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7777d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7778e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public p(String str, String str2, long j6, String str3, String str4, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f7774a = str;
        this.f7775b = str2;
        this.f7776c = j6;
        this.f7777d = str3;
        this.f7778e = str4;
        this.f = z9;
        this.g = z10;
        this.i = z11;
        this.h = z12;
    }

    public static int a(String str, int i, int i6, boolean z9) {
        while (i < i6) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z9)) {
                return i;
            }
            i++;
        }
        return i6;
    }

    public static long b(int i, String str) {
        int a8 = a(str, 0, i, false);
        Pattern pattern = f7773m;
        Matcher matcher = pattern.matcher(str);
        int i6 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        while (a8 < i) {
            int a10 = a(str, a8 + 1, i, true);
            matcher.region(a8, a10);
            if (i10 == -1 && matcher.usePattern(pattern).matches()) {
                i10 = Integer.parseInt(matcher.group(1));
                i13 = Integer.parseInt(matcher.group(2));
                i14 = Integer.parseInt(matcher.group(3));
            } else if (i11 == -1 && matcher.usePattern(f7772l).matches()) {
                i11 = Integer.parseInt(matcher.group(1));
            } else {
                if (i12 == -1) {
                    Pattern pattern2 = f7771k;
                    if (matcher.usePattern(pattern2).matches()) {
                        i12 = pattern2.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i6 == -1 && matcher.usePattern(j).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            }
            a8 = a(str, a10 + 1, i, false);
        }
        if (i6 >= 70 && i6 <= 99) {
            i6 += 1900;
        }
        if (i6 >= 0 && i6 <= 69) {
            i6 += 2000;
        }
        if (i6 < 1601) {
            s1.o.n();
            return 0L;
        }
        if (i12 == -1) {
            s1.o.n();
            return 0L;
        }
        if (i11 < 1 || i11 > 31) {
            s1.o.n();
            return 0L;
        }
        if (i10 < 0 || i10 > 23) {
            s1.o.n();
            return 0L;
        }
        if (i13 < 0 || i13 > 59) {
            s1.o.n();
            return 0L;
        }
        if (i14 < 0 || i14 > 59) {
            s1.o.n();
            return 0L;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(n8.c.f8118e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i6);
        gregorianCalendar.set(2, i12 - 1);
        gregorianCalendar.set(5, i11);
        gregorianCalendar.set(11, i10);
        gregorianCalendar.set(12, i13);
        gregorianCalendar.set(13, i14);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return pVar.f7774a.equals(this.f7774a) && pVar.f7775b.equals(this.f7775b) && pVar.f7777d.equals(this.f7777d) && pVar.f7778e.equals(this.f7778e) && pVar.f7776c == this.f7776c && pVar.f == this.f && pVar.g == this.g && pVar.h == this.h && pVar.i == this.i;
    }

    public final int hashCode() {
        int o10 = androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(527, 31, this.f7774a), 31, this.f7775b), 31, this.f7777d), 31, this.f7778e);
        long j6 = this.f7776c;
        return ((((((((o10 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (!this.f ? 1 : 0)) * 31) + (!this.g ? 1 : 0)) * 31) + (!this.h ? 1 : 0)) * 31) + (!this.i ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7774a);
        sb.append('=');
        sb.append(this.f7775b);
        if (this.h) {
            long j6 = this.f7776c;
            if (j6 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(((DateFormat) q8.b.f8782a.get()).format(new Date(j6)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.f7777d);
        }
        sb.append("; path=");
        sb.append(this.f7778e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
