package f9;

import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends i {
    public final String h;
    public final Boolean i;
    public final String j;

    /* renamed from: k, reason: collision with root package name */
    public final String f5049k;

    /* renamed from: l, reason: collision with root package name */
    public final b f5050l;

    /* renamed from: m, reason: collision with root package name */
    public final Boolean f5051m;

    /* renamed from: n, reason: collision with root package name */
    public final String f5052n;

    /* renamed from: o, reason: collision with root package name */
    public final Boolean f5053o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f5054p;

    public n(String str, Boolean bool, String str2, String str3, b bVar, Boolean bool2, String str4, Boolean bool3, boolean z9) {
        this.h = str;
        this.i = bool;
        this.j = str2;
        this.f5049k = str3;
        this.f5050l = bVar;
        this.f5051m = bool2;
        this.f5052n = str4;
        this.f5053o = bool3;
        this.f5054p = z9;
    }

    @Override // f9.i
    public final String d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("existingCMPStatus", this.h);
        jSONObject.putOpt("regulation", this.j);
        jSONObject.putOpt("cmpTriggered", this.i);
        jSONObject.putOpt("accountId", this.f5049k);
        b bVar = this.f5050l;
        jSONObject.putOpt("existingConfigs", bVar == null ? null : bVar.a());
        jSONObject.putOpt("paidUser", this.f5051m);
        jSONObject.putOpt("existingGBCStatus", this.f5052n);
        jSONObject.putOpt("consentOrPayApplicable", this.f5053o);
        jSONObject.putOpt("gbcApplicable", Boolean.valueOf(this.f5054p));
        c(jSONObject);
        String jSONObject2 = jSONObject.toString();
        jSONObject2.getClass();
        return jSONObject2;
    }
}
