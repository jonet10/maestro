package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l7.m;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder sb, int i) {
        sb.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            sb.append("?");
            if (i6 < i - 1) {
                sb.append(",");
            }
        }
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return l.x0(list, ",", null, null, null, 62);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        Integer num;
        if (str == null) {
            return null;
        }
        List F0 = m.F0(String.valueOf(new char[]{','}[0]), str);
        ArrayList arrayList = new ArrayList();
        Iterator it = F0.iterator();
        while (it.hasNext()) {
            try {
                num = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException unused) {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }
}
