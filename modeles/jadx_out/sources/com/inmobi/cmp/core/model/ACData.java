package com.inmobi.cmp.core.model;

import androidx.annotation.Keep;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ACData {
    private final String acString;

    public /* synthetic */ ACData(String str, int i, g gVar) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ ACData copy$default(ACData aCData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aCData.acString;
        }
        return aCData.copy(str);
    }

    public final String component1() {
        return this.acString;
    }

    public final ACData copy(String str) {
        return new ACData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ACData) && l.a(this.acString, ((ACData) obj).acString);
    }

    public final String getAcString() {
        return this.acString;
    }

    public int hashCode() {
        String str = this.acString;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ACData(acString=" + ((Object) this.acString) + ')';
    }

    public ACData(String str) {
        this.acString = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ACData() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
