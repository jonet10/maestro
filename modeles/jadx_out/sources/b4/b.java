package b4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import d7.p;
import j$.util.Collection;
import j5.v;
import java.util.ArrayList;
import o7.a0;
import org.json.JSONArray;
import org.json.JSONObject;
import p6.x;
import v6.i;
import x4.g2;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f993a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, t6.c cVar) {
        super(2, cVar);
        this.f993a = context;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new b(this.f993a, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        b bVar = (b) create((a0) obj, (t6.c) obj2);
        x xVar = x.f8463a;
        bVar.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        p6.a.e(obj);
        Context context = this.f993a;
        if (u2.h(context) != null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v(context);
            g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/user-data/devices"), null, ShareTarget.METHOD_GET, false);
            k5.f11206d = vVar.i(k5, "/eapi/user-data/devices");
            if (!k5.b() && (jSONObject = k5.f11206d) != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (jSONObject.optInt("success") == 1 && optJSONArray != null) {
                    arrayList = z3.F(optJSONArray);
                }
            }
            Collection.EL.removeIf(arrayList, new androidx.window.embedding.b(new androidx.room.b(context, 9), 1));
            float f = UptodownApp.I;
            UptodownApp.f3291e0 = !arrayList.isEmpty();
        }
        return x.f8463a;
    }
}
