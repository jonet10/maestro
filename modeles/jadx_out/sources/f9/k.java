package f9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends i {
    public final ArrayList h;
    public final String i;
    public final String j;

    /* renamed from: k, reason: collision with root package name */
    public final String f5040k;

    /* renamed from: l, reason: collision with root package name */
    public final String f5041l;

    /* renamed from: m, reason: collision with root package name */
    public final String f5042m;

    /* renamed from: n, reason: collision with root package name */
    public final String f5043n;

    /* renamed from: o, reason: collision with root package name */
    public final String f5044o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5045p;

    /* renamed from: q, reason: collision with root package name */
    public final String f5046q;

    /* renamed from: r, reason: collision with root package name */
    public final List f5047r;

    /* renamed from: s, reason: collision with root package name */
    public final Boolean f5048s;

    public k(ArrayList arrayList, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList2, Boolean bool, int i) {
        str3 = (i & 8) != 0 ? null : str3;
        str4 = (i & 16) != 0 ? null : str4;
        str5 = (i & 32) != 0 ? null : str5;
        str6 = (i & 64) != 0 ? null : str6;
        str7 = (i & 128) != 0 ? null : str7;
        str8 = (i & 256) != 0 ? null : str8;
        bool = (i & 2048) != 0 ? null : bool;
        this.h = arrayList;
        this.i = str;
        this.j = str2;
        this.f5040k = str3;
        this.f5041l = str4;
        this.f5042m = str5;
        this.f5043n = str6;
        this.f5044o = str7;
        this.f5045p = str8;
        this.f5046q = str9;
        this.f5047r = arrayList2;
        this.f5048s = bool;
    }

    @Override // f9.i
    public final String d() {
        ArrayList arrayList;
        List<p6.i> list = this.f5047r;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (p6.i iVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(((Number) iVar.f8441a).intValue()), iVar.f8442b);
                arrayList.add(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.h;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            arrayList2.add(new JSONObject(((a) obj).d()));
        }
        jSONObject2.put("userEvents", new JSONArray((Collection) arrayList2));
        jSONObject2.putOpt("acceptanceState", this.i);
        jSONObject2.putOpt("objectionState", this.j);
        jSONObject2.putOpt("tcData", this.f5040k);
        jSONObject2.putOpt("gppData", this.f5041l);
        jSONObject2.putOpt("state", this.f5042m);
        jSONObject2.putOpt("jurisdiction", this.f5043n);
        jSONObject2.putOpt("nonIabConsentData", this.f5044o);
        jSONObject2.putOpt("uspData", this.f5045p);
        jSONObject2.putOpt("gbcAcceptanceState", this.f5046q);
        jSONObject2.putOpt("gbcData", arrayList != null ? new JSONArray((Collection) arrayList) : null);
        jSONObject2.putOpt("paidUserIndicated", this.f5048s);
        c(jSONObject2);
        String jSONObject3 = jSONObject2.toString();
        jSONObject3.getClass();
        return jSONObject3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.l.a(this.h, kVar.h) && kotlin.jvm.internal.l.a(this.i, kVar.i) && kotlin.jvm.internal.l.a(this.j, kVar.j) && kotlin.jvm.internal.l.a(this.f5040k, kVar.f5040k) && kotlin.jvm.internal.l.a(this.f5041l, kVar.f5041l) && kotlin.jvm.internal.l.a(this.f5042m, kVar.f5042m) && kotlin.jvm.internal.l.a(this.f5043n, kVar.f5043n) && kotlin.jvm.internal.l.a(this.f5044o, kVar.f5044o) && kotlin.jvm.internal.l.a(this.f5045p, kVar.f5045p) && kotlin.jvm.internal.l.a(this.f5046q, kVar.f5046q) && kotlin.jvm.internal.l.a(this.f5047r, kVar.f5047r) && kotlin.jvm.internal.l.a(this.f5048s, kVar.f5048s);
    }

    public final int hashCode() {
        int hashCode = this.h.hashCode() * 31;
        String str = this.i;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.j;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f5040k;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f5041l;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f5042m;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f5043n;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f5044o;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f5045p;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f5046q;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List list = this.f5047r;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.f5048s;
        return hashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "TrackingUserDoneLog(userEvents=" + this.h + ", acceptanceState=" + ((Object) this.i) + ", objectionState=" + ((Object) this.j) + ", tcData=" + ((Object) this.f5040k) + ", gppData=" + ((Object) this.f5041l) + ", state=" + ((Object) this.f5042m) + ", jurisdiction=" + ((Object) this.f5043n) + ", nonIabConsentData=" + ((Object) this.f5044o) + ", uspData=" + ((Object) this.f5045p) + ", gbcAcceptanceState=" + ((Object) this.f5046q) + ", gbcData=" + this.f5047r + ", paidUserIndicated=" + this.f5048s + ')';
    }
}
