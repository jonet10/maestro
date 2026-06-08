package com.inmobi.cmp.core.cmpapi.map;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class OutOfBandMap {
    private Map<String, Boolean> allowedVendors;
    private Map<String, Boolean> disclosedVendors;

    public /* synthetic */ OutOfBandMap(Map map, Map map2, int i, g gVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? new LinkedHashMap() : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutOfBandMap copy$default(OutOfBandMap outOfBandMap, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = outOfBandMap.allowedVendors;
        }
        if ((i & 2) != 0) {
            map2 = outOfBandMap.disclosedVendors;
        }
        return outOfBandMap.copy(map, map2);
    }

    public final Map<String, Boolean> component1() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> component2() {
        return this.disclosedVendors;
    }

    public final OutOfBandMap copy(Map<String, Boolean> map, Map<String, Boolean> map2) {
        map.getClass();
        map2.getClass();
        return new OutOfBandMap(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutOfBandMap)) {
            return false;
        }
        OutOfBandMap outOfBandMap = (OutOfBandMap) obj;
        return l.a(this.allowedVendors, outOfBandMap.allowedVendors) && l.a(this.disclosedVendors, outOfBandMap.disclosedVendors);
    }

    public final Map<String, Boolean> getAllowedVendors() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> getDisclosedVendors() {
        return this.disclosedVendors;
    }

    public int hashCode() {
        return this.disclosedVendors.hashCode() + (this.allowedVendors.hashCode() * 31);
    }

    public final void setAllowedVendors(Map<String, Boolean> map) {
        map.getClass();
        this.allowedVendors = map;
    }

    public final void setDisclosedVendors(Map<String, Boolean> map) {
        map.getClass();
        this.disclosedVendors = map;
    }

    public String toString() {
        return "OutOfBandMap(allowedVendors=" + this.allowedVendors + ", disclosedVendors=" + this.disclosedVendors + ')';
    }

    public OutOfBandMap(Map<String, Boolean> map, Map<String, Boolean> map2) {
        map.getClass();
        map2.getClass();
        this.allowedVendors = map;
        this.disclosedVendors = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutOfBandMap() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
