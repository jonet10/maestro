package f9;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends i {
    public final ArrayList h;
    public final String i;
    public final ArrayList j;

    public m(ArrayList arrayList, ArrayList arrayList2, String str) {
        this.h = arrayList;
        this.i = str;
        this.j = arrayList2;
    }

    @Override // f9.i
    public final String d() {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList2.get(i6);
            i6++;
            arrayList.add(new JSONObject(((a) obj).d()));
        }
        jSONObject.put("userEvents", new JSONArray((Collection) arrayList));
        jSONObject.putOpt("acceptanceState", this.i);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.j;
        int size2 = arrayList4.size();
        while (i < size2) {
            Object obj2 = arrayList4.get(i);
            i++;
            p6.i iVar = (p6.i) obj2;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(String.valueOf(((Number) iVar.f8441a).intValue()), iVar.f8442b);
            arrayList3.add(jSONObject2);
        }
        jSONObject.putOpt("gbcData", new JSONArray((Collection) arrayList3));
        c(jSONObject);
        String jSONObject3 = jSONObject.toString();
        jSONObject3.getClass();
        return jSONObject3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.h.equals(mVar.h) && this.i.equals(mVar.i) && this.j.equals(mVar.j);
    }

    public final int hashCode() {
        return this.j.hashCode() + androidx.lifecycle.l.o(this.h.hashCode() * 31, 31, this.i);
    }

    public final String toString() {
        return "TrackingUserGBCDoneLog(userEvents=" + this.h + ", acceptanceState=" + ((Object) this.i) + ", gbcData=" + this.j + ')';
    }
}
