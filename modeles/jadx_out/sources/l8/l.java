package l8;

import a4.x;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import q6.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f7223a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7224b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7225c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7226d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7227e;
    public final ArrayList f;
    public final ArrayList g;
    public final String h;

    public l(int i, String str, String str2, String str3, String str4, ArrayList arrayList, ArrayList arrayList2, String str5) {
        this.f7223a = i;
        this.f7224b = str;
        this.f7225c = str2;
        this.f7226d = str3;
        this.f7227e = str4;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = str5;
    }

    public final h8.i a() {
        Set I0 = q6.l.I0(this.f);
        Set I02 = q6.l.I0(this.g);
        String str = this.h;
        String str2 = this.f7227e;
        h8.h[] hVarArr = {new h8.h("", str2, str)};
        LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(1));
        linkedHashSet.add(hVarArr[0]);
        return new h8.i(this.f7223a, this.f7225c, this.f7226d, I0, I02, null, null, null, null, str2, null, 0, null, null, null, linkedHashSet, null, 652768);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f7223a == lVar.f7223a && this.f7224b.equals(lVar.f7224b) && this.f7225c.equals(lVar.f7225c) && this.f7226d.equals(lVar.f7226d) && this.f7227e.equals(lVar.f7227e) && this.f.equals(lVar.f) && this.g.equals(lVar.g) && this.h.equals(lVar.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(this.f7223a * 31, 31, this.f7224b), 31, this.f7225c), 31, this.f7226d), 31, this.f7227e)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NonIABVendor(vendorId=");
        sb.append(this.f7223a);
        sb.append(", pCode=");
        sb.append(this.f7224b);
        sb.append(", name=");
        sb.append(this.f7225c);
        sb.append(", description=");
        sb.append(this.f7226d);
        sb.append(", privacyPolicyUrl=");
        sb.append(this.f7227e);
        sb.append(", nonIabPurposeConsentIds=");
        sb.append(this.f);
        sb.append(", nonIabPurposeLegitimateInterestIds=");
        sb.append(this.g);
        sb.append(", legitimateInterestClaimUrl=");
        return x.m(sb, this.h, ')');
    }
}
