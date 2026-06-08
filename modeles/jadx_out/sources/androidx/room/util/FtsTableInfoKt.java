package androidx.room.util;

import kotlin.jvm.internal.l;
import l7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FtsTableInfoKt {
    public static final boolean equalsCommon(FtsTableInfo ftsTableInfo, Object obj) {
        ftsTableInfo.getClass();
        if (ftsTableInfo == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo2 = (FtsTableInfo) obj;
        if (l.a(ftsTableInfo.name, ftsTableInfo2.name) && l.a(ftsTableInfo.columns, ftsTableInfo2.columns)) {
            return l.a(ftsTableInfo.options, ftsTableInfo2.options);
        }
        return false;
    }

    public static final int hashCodeCommon(FtsTableInfo ftsTableInfo) {
        ftsTableInfo.getClass();
        return ftsTableInfo.options.hashCode() + ((ftsTableInfo.columns.hashCode() + (ftsTableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(FtsTableInfo ftsTableInfo) {
        ftsTableInfo.getClass();
        return n.e0("\n            |FtsTableInfo {\n            |   name = '" + ftsTableInfo.name + "',\n            |   columns = {" + TableInfoKt.formatString(q6.l.B0(ftsTableInfo.columns)) + "\n            |   options = {" + TableInfoKt.formatString(q6.l.B0(ftsTableInfo.options)) + "\n            |}\n        ");
    }
}
