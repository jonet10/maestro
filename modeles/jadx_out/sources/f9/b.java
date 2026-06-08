package f9;

import a2.t;
import java.io.IOException;
import org.json.JSONObject;
import w8.e0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4992a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4993b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4994c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4995d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4996e;

    public b(m8.g gVar, t tVar) {
        this.f4996e = gVar;
        this.f4993b = tVar;
        e0 j = tVar.j(1);
        this.f4994c = j;
        this.f4995d = new m8.c(this, j, tVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("themeUuid", (String) this.f4993b);
        jSONObject.put("language", (String) this.f4994c);
        jSONObject.put("copApplicable", (Boolean) this.f4995d);
        jSONObject.put("advancedApplicable", (Boolean) this.f4996e);
        jSONObject.put("gbcApplicable", this.f4992a);
        return jSONObject;
    }

    public void b() {
        synchronized (((m8.g) this.f4996e)) {
            try {
                if (this.f4992a) {
                    return;
                }
                this.f4992a = true;
                n8.c.c((e0) this.f4994c);
                try {
                    ((t) this.f4993b).a();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b(String str, String str2, Boolean bool, Boolean bool2, boolean z9) {
        this.f4993b = str;
        this.f4994c = str2;
        this.f4995d = bool;
        this.f4996e = bool2;
        this.f4992a = z9;
    }
}
