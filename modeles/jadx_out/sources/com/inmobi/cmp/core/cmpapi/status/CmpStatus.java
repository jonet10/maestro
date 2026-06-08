package com.inmobi.cmp.core.cmpapi.status;

import androidx.annotation.Keep;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public enum CmpStatus {
    STUB("stub"),
    LOADING("loading"),
    LOADED("loaded"),
    ERROR("error");

    private final String value;

    CmpStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
