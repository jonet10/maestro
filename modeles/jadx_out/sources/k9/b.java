package k9;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import h9.h;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7006a = 0;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f7007b;

    public b(JSONObject jSONObject) {
        this.f7007b = jSONObject;
    }

    public ArrayList a() {
        JSONObject jSONObject = this.f7007b;
        if (jSONObject == null) {
            l.i("json");
            throw null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("disclosures");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            int i6 = i + 1;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String optString = jSONObject2.optString("identifier");
            optString.getClass();
            String optString2 = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            optString2.getClass();
            int optInt = jSONObject2.optInt("maxAgeSeconds");
            String optString3 = jSONObject2.optString("domain");
            optString3.getClass();
            arrayList.add(new h(optString, optString2, optInt, optString3, d0.b.e(jSONObject2, "purposes")));
            i = i6;
        }
        return arrayList;
    }

    public String toString() {
        switch (this.f7006a) {
            case 1:
                String jSONObject = this.f7007b.toString();
                jSONObject.getClass();
                return jSONObject;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ b() {
    }
}
