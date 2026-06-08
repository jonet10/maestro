package androidx.core.content;

import android.content.ContentValues;
import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(i... iVarArr) {
        ContentValues contentValues = new ContentValues(iVarArr.length);
        for (i iVar : iVarArr) {
            String str = (String) iVar.f8441a;
            Object obj = iVar.f8442b;
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof String) {
                contentValues.put(str, (String) obj);
            } else if (obj instanceof Integer) {
                contentValues.put(str, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(str, (Long) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(str, (Boolean) obj);
            } else if (obj instanceof Float) {
                contentValues.put(str, (Float) obj);
            } else if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(str, (Byte) obj);
            } else {
                if (!(obj instanceof Short)) {
                    androidx.core.content.pm.a.g(34, obj.getClass().getCanonicalName(), " for key \"", str, "Illegal value type ");
                    return null;
                }
                contentValues.put(str, (Short) obj);
            }
        }
        return contentValues;
    }
}
