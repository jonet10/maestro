package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import kotlin.jvm.internal.g;
import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DoubleMapper {
    public static final Companion Companion = new Companion(null);
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    static {
        Float valueOf = Float.valueOf(0.0f);
        i iVar = new i(valueOf, valueOf);
        Float valueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(iVar, new i(valueOf2, valueOf2));
    }

    public DoubleMapper(i... iVarArr) {
        iVarArr.getClass();
        this.sourceValues = new MutableFloatList(iVarArr.length);
        this.targetValues = new MutableFloatList(iVarArr.length);
        int length = iVarArr.length;
        int i = 0;
        while (true) {
            MutableFloatList mutableFloatList = this.sourceValues;
            if (i >= length) {
                FloatMappingKt.validateProgress(mutableFloatList);
                FloatMappingKt.validateProgress(this.targetValues);
                return;
            } else {
                mutableFloatList.add(((Number) iVarArr[i].f8441a).floatValue());
                this.targetValues.add(((Number) iVarArr[i].f8442b).floatValue());
                i++;
            }
        }
    }

    public final float map(float f) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, f);
    }

    public final float mapBack(float f) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, f);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
