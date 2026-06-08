package androidx.work;

import androidx.work.Data;
import kotlin.jvm.internal.l;
import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataKt {
    public static final <T> boolean hasKeyWithValueOfType(Data data, String str) {
        data.getClass();
        str.getClass();
        l.h();
        throw null;
    }

    public static final Data workDataOf(i... iVarArr) {
        iVarArr.getClass();
        Data.Builder builder = new Data.Builder();
        for (i iVar : iVarArr) {
            builder.put((String) iVar.f8441a, iVar.f8442b);
        }
        return builder.build();
    }
}
