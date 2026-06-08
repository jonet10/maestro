package com.inmobi.cmp.model;

import com.google.android.gms.internal.measurement.i5;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DisplayInfo {

    /* renamed from: a, reason: collision with root package name */
    public DisplayStatus f3278a;

    /* renamed from: b, reason: collision with root package name */
    public String f3279b;

    /* renamed from: c, reason: collision with root package name */
    public Regulations f3280c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3281d;

    public DisplayInfo(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9) {
        displayStatus.getClass();
        str.getClass();
        regulations.getClass();
        this.f3278a = displayStatus;
        this.f3279b = str;
        this.f3280c = regulations;
        this.f3281d = z9;
    }

    public static /* synthetic */ DisplayInfo copy$default(DisplayInfo displayInfo, DisplayStatus displayStatus, String str, Regulations regulations, boolean z9, int i, Object obj) {
        if ((i & 1) != 0) {
            displayStatus = displayInfo.f3278a;
        }
        if ((i & 2) != 0) {
            str = displayInfo.f3279b;
        }
        if ((i & 4) != 0) {
            regulations = displayInfo.f3280c;
        }
        if ((i & 8) != 0) {
            z9 = displayInfo.f3281d;
        }
        return displayInfo.copy(displayStatus, str, regulations, z9);
    }

    public final DisplayStatus component1() {
        return this.f3278a;
    }

    public final String component2() {
        return this.f3279b;
    }

    public final Regulations component3() {
        return this.f3280c;
    }

    public final boolean component4() {
        return this.f3281d;
    }

    public final DisplayInfo copy(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9) {
        displayStatus.getClass();
        str.getClass();
        regulations.getClass();
        return new DisplayInfo(displayStatus, str, regulations, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisplayInfo)) {
            return false;
        }
        DisplayInfo displayInfo = (DisplayInfo) obj;
        return this.f3278a == displayInfo.f3278a && l.a(this.f3279b, displayInfo.f3279b) && this.f3280c == displayInfo.f3280c && this.f3281d == displayInfo.f3281d;
    }

    public final String getDisplayMessage() {
        return this.f3279b;
    }

    public final DisplayStatus getDisplayStatus() {
        return this.f3278a;
    }

    public final boolean getGbcShown() {
        return this.f3281d;
    }

    public final Regulations getRegulationShown() {
        return this.f3280c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.f3280c.hashCode() + i5.b(this.f3278a.hashCode() * 31, this.f3279b)) * 31;
        boolean z9 = this.f3281d;
        int i = z9;
        if (z9 != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final void setDisplayMessage(String str) {
        str.getClass();
        this.f3279b = str;
    }

    public final void setDisplayStatus(DisplayStatus displayStatus) {
        displayStatus.getClass();
        this.f3278a = displayStatus;
    }

    public final void setGbcShown(boolean z9) {
        this.f3281d = z9;
    }

    public final void setRegulationShown(Regulations regulations) {
        regulations.getClass();
        this.f3280c = regulations;
    }

    public String toString() {
        return "DisplayInfo(displayStatus=" + this.f3278a + ", displayMessage=" + this.f3279b + ", regulationShown=" + this.f3280c + ", gbcShown=" + this.f3281d + ')';
    }

    public /* synthetic */ DisplayInfo(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9, int i, g gVar) {
        this(displayStatus, str, regulations, (i & 8) != 0 ? false : z9);
    }
}
