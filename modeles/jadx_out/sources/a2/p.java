package a2;

import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final g5.f f42a;

    static {
        n2.d dVar = new n2.d();
        a aVar = a.f2a;
        dVar.a(p.class, aVar);
        dVar.a(b.class, aVar);
        f42a = new g5.f(dVar, 10);
    }

    public static b a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("rolloutId");
        String string2 = jSONObject.getString("parameterKey");
        String string3 = jSONObject.getString("parameterValue");
        String string4 = jSONObject.getString("variantId");
        long j = jSONObject.getLong("templateVersion");
        if (string3.length() > 256) {
            string3 = string3.substring(0, 256);
        }
        return new b(j, string, string2, string3, string4);
    }
}
