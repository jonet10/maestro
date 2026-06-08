package p3;

import androidx.lifecycle.l;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8419a = Pattern.compile("^[0-1]*$", 2);

    public static ZonedDateTime a(String str) {
        if (!f8419a.matcher(str).matches() || str.length() != 36) {
            throw new q3.a(l.w("Undecodable Datetime '", str, "'"));
        }
        if (!h.f8428a.matcher(str).matches()) {
            throw new q3.a(l.w("Undecodable FixedLong '", str, "'"));
        }
        long j = 0;
        int i = 0;
        while (i < str.length()) {
            int i6 = i + 1;
            if (str.charAt(str.length() - i6) == '1') {
                j += 1 << i;
            }
            i = i6;
        }
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(j * 100), ZoneId.of("UTC"));
    }
}
