package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2534b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f2535a;

    public d0(int i) {
        this.f2535a = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        int i = ((d0) obj).f2535a;
        int i6 = this.f2535a;
        if (i6 != 0) {
            return i6 == i;
        }
        throw null;
    }

    public final int hashCode() {
        int i = this.f2535a;
        if (i != 0) {
            return ((i ^ (-485106924)) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i = this.f2535a;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        StringBuilder sb = new StringBuilder("READ_AND_WRITE".length() + str.length() + "".length() + 73 + 91 + 1);
        a4.x.B(sb, "FileComplianceOptions{fileOwner=, hasDifferentDmaOwner=false, fileChecks=", str, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", "READ_AND_WRITE");
        sb.append("}");
        return sb.toString();
    }
}
