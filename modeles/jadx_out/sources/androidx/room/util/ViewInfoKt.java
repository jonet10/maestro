package androidx.room.util;

import kotlin.jvm.internal.l;
import l7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewInfoKt {
    public static final boolean equalsCommon(ViewInfo viewInfo, Object obj) {
        viewInfo.getClass();
        if (viewInfo == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo2 = (ViewInfo) obj;
        if (l.a(viewInfo.name, viewInfo2.name)) {
            String str = viewInfo.sql;
            String str2 = viewInfo2.sql;
            if (str != null ? l.a(str, str2) : str2 == null) {
                return true;
            }
        }
        return false;
    }

    public static final int hashCodeCommon(ViewInfo viewInfo) {
        viewInfo.getClass();
        int hashCode = viewInfo.name.hashCode() * 31;
        String str = viewInfo.sql;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public static final String toStringCommon(ViewInfo viewInfo) {
        viewInfo.getClass();
        return n.e0("\n            |ViewInfo {\n            |   name = '" + viewInfo.name + "',\n            |   sql = '" + viewInfo.sql + "'\n            |}\n        ");
    }
}
