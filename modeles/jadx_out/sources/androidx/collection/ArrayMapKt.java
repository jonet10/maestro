package androidx.collection;

import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ArrayMapKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(i... iVarArr) {
        iVarArr.getClass();
        ArrayMap<K, V> arrayMap = (ArrayMap<K, V>) new ArrayMap(iVarArr.length);
        for (i iVar : iVarArr) {
            arrayMap.put(iVar.f8441a, iVar.f8442b);
        }
        return arrayMap;
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }
}
