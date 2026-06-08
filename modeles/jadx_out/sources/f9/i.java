package f9;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public long f5028a;

    /* renamed from: c, reason: collision with root package name */
    public String f5030c;
    public String g;

    /* renamed from: b, reason: collision with root package name */
    public int f5029b = 4;

    /* renamed from: d, reason: collision with root package name */
    public String f5031d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f5032e = "";
    public String f = "";

    public long a() {
        return this.f5028a;
    }

    public void b(long j) {
        this.f5028a = j;
    }

    public final void c(JSONObject jSONObject) {
        String str;
        jSONObject.putOpt("clientTimestamp", Long.valueOf(a()));
        if (this.f5029b != 5) {
            jSONObject.putOpt("sessionId", this.f5030c);
        }
        jSONObject.putOpt("domain", this.f5031d);
        jSONObject.putOpt("cmpVersion", "2.4.1");
        jSONObject.putOpt("cmpPlatform", "android");
        jSONObject.putOpt("deviceType", this.f);
        jSONObject.putOpt("country", this.f5032e);
        jSONObject.putOpt("siteUuid", this.g);
        switch (this.f5029b) {
            case 1:
                str = "init";
                break;
            case 2:
                str = NotificationCompat.CATEGORY_NAVIGATION;
                break;
            case 3:
                str = "done";
                break;
            case 4:
                str = "none";
                break;
            case 5:
                str = "visit";
                break;
            case 6:
                str = "click";
                break;
            default:
                throw null;
        }
        jSONObject.putOpt("operationType", str);
    }

    public abstract String d();
}
