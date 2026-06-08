package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class ZoneId implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f5748a;
    private static final long serialVersionUID = 8352817235686L;

    public abstract String d();

    public abstract j$.time.zone.f v();

    public abstract void z(DataOutput dataOutput);

    static {
        Map.Entry[] entryArr = {j$.com.android.tools.r8.a.y("ACT", "Australia/Darwin"), j$.com.android.tools.r8.a.y("AET", "Australia/Sydney"), j$.com.android.tools.r8.a.y("AGT", "America/Argentina/Buenos_Aires"), j$.com.android.tools.r8.a.y("ART", "Africa/Cairo"), j$.com.android.tools.r8.a.y("AST", "America/Anchorage"), j$.com.android.tools.r8.a.y("BET", "America/Sao_Paulo"), j$.com.android.tools.r8.a.y("BST", "Asia/Dhaka"), j$.com.android.tools.r8.a.y("CAT", "Africa/Harare"), j$.com.android.tools.r8.a.y("CNT", "America/St_Johns"), j$.com.android.tools.r8.a.y("CST", "America/Chicago"), j$.com.android.tools.r8.a.y("CTT", "Asia/Shanghai"), j$.com.android.tools.r8.a.y("EAT", "Africa/Addis_Ababa"), j$.com.android.tools.r8.a.y("ECT", "Europe/Paris"), j$.com.android.tools.r8.a.y("IET", "America/Indiana/Indianapolis"), j$.com.android.tools.r8.a.y("IST", "Asia/Kolkata"), j$.com.android.tools.r8.a.y("JST", "Asia/Tokyo"), j$.com.android.tools.r8.a.y("MIT", "Pacific/Apia"), j$.com.android.tools.r8.a.y("NET", "Asia/Yerevan"), j$.com.android.tools.r8.a.y("NST", "Pacific/Auckland"), j$.com.android.tools.r8.a.y("PLT", "Asia/Karachi"), j$.com.android.tools.r8.a.y("PNT", "America/Phoenix"), j$.com.android.tools.r8.a.y("PRT", "America/Puerto_Rico"), j$.com.android.tools.r8.a.y("PST", "America/Los_Angeles"), j$.com.android.tools.r8.a.y("SST", "Pacific/Guadalcanal"), j$.com.android.tools.r8.a.y("VST", "Asia/Ho_Chi_Minh"), j$.com.android.tools.r8.a.y("EST", "-05:00"), j$.com.android.tools.r8.a.y("MST", "-07:00"), j$.com.android.tools.r8.a.y("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        for (int i = 0; i < 28; i++) {
            Map.Entry entry = entryArr[i];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        f5748a = Collections.unmodifiableMap(hashMap);
    }

    public static ZoneId of(String str) {
        return w(str, true);
    }

    public static ZoneId x(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            g.c("prefix should be GMT, UTC or UT, is: ".concat(str));
            return null;
        }
        if (zoneOffset.f5751b != 0) {
            str = str.concat(zoneOffset.f5752c);
        }
        return new w(str, zoneOffset.v());
    }

    public static ZoneId w(String str, boolean z9) {
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.A(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            return y(str, 3, z9);
        }
        if (str.startsWith("UT")) {
            return y(str, 2, z9);
        }
        return w.A(str, z9);
    }

    public static ZoneId y(String str, int i, boolean z9) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return x(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return w.A(str, z9);
        }
        try {
            ZoneOffset A = ZoneOffset.A(str.substring(i));
            if (A == ZoneOffset.UTC) {
                return x(substring, A);
            }
            return x(substring, A);
        } catch (b e10) {
            throw new b("Invalid ID for offset-based ZoneId: ".concat(str), e10);
        }
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != w.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return d().equals(((ZoneId) obj).d());
        }
        return false;
    }

    public int hashCode() {
        return d().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return d();
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }
}
