package x4;

import android.content.Context;
import com.google.android.gms.internal.measurement.z3;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g2 {

    /* renamed from: a, reason: collision with root package name */
    public String f11203a;

    /* renamed from: b, reason: collision with root package name */
    public int f11204b;

    /* renamed from: c, reason: collision with root package name */
    public String f11205c;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f11206d;

    public static String e(JSONObject jSONObject) {
        jSONObject.getClass();
        String str = null;
        try {
            if (!jSONObject.isNull("errorMsg")) {
                Object obj = jSONObject.get("errorMsg");
                if (obj instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("errorMsg");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            str = (str == null || str.equals("")) ? optJSONArray.getString(i) : String.format("%s\n%s", Arrays.copyOf(new Object[]{str, optJSONArray.optString(i)}, 2));
                        }
                        return str;
                    }
                } else if (obj instanceof String) {
                    return (String) obj;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void a(Context context) {
        context.getClass();
        if (this.f11204b == 526) {
            z3.M(context, "is_status_code_526", true);
            z3.O(context, 728, "versioncode_526");
            String str = this.f11203a;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f11203a;
            str2.getClass();
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.isNull("url_update")) {
                return;
            }
            z3.R(context, "url_526", jSONObject.optString("url_update"));
        }
    }

    public final boolean b() {
        int i = this.f11204b;
        return i < 200 || i >= 300;
    }

    public final String c() {
        return this.f11203a;
    }

    public final int d() {
        return this.f11204b;
    }

    public final void f(String str) {
        this.f11205c = str;
    }

    public final void g(String str) {
        this.f11203a = str;
    }

    public final void h(int i) {
        this.f11204b = i;
    }
}
