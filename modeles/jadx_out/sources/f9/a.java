package f9;

import a4.x;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends i {
    public long h;
    public final String i;

    public a(long j, String str) {
        this.h = j;
        this.i = str;
    }

    @Override // f9.i
    public final long a() {
        return this.h;
    }

    @Override // f9.i
    public final void b(long j) {
        this.h = j;
    }

    @Override // f9.i
    public final String d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.i);
        jSONObject.putOpt("clientTimestamp", Long.valueOf(this.h));
        String jSONObject2 = jSONObject.toString();
        jSONObject2.getClass();
        return jSONObject2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.h == aVar.h && this.i.equals(aVar.i);
    }

    public final int hashCode() {
        long j = this.h;
        return this.i.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserEvent(clientTimestamp=");
        sb.append(this.h);
        sb.append(", event=");
        return x.m(sb, this.i, ')');
    }
}
