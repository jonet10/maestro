package u4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import x4.b3;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10596b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b3 f10597l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10598m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v0 f10599n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(Context context, long j, b3 b3Var, ArrayList arrayList, v0 v0Var, t6.c cVar) {
        super(2, cVar);
        this.f10595a = context;
        this.f10596b = j;
        this.f10597l = b3Var;
        this.f10598m = arrayList;
        this.f10599n = v0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new s0(this.f10595a, this.f10596b, this.f10597l, this.f10598m, this.f10599n, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        s0 s0Var = (s0) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        s0Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        p6.a.e(obj);
        Context context = this.f10595a;
        j5.v vVar = new j5.v(context);
        long j = this.f10597l.f11065a;
        ArrayList arrayList = this.f10598m;
        ArrayList arrayList2 = new ArrayList(q6.n.i0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(new Long(((b3) obj2).f11065a));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", String.valueOf(j));
        hashMap.put("targetDeviceIDs", arrayList2.toString());
        StringBuilder sb = new StringBuilder("/eapi/app/");
        long j6 = this.f10596b;
        String l10 = a4.x.l(sb, j6, "/remote-install");
        g2 k5 = vVar.k("https://www.uptodown.app:443".concat(l10), hashMap, ShareTarget.METHOD_POST, false);
        k5.f11206d = vVar.i(k5, l10);
        if (!k5.b() && (jSONObject = k5.f11206d) != null && jSONObject.optInt("success") == 1) {
            v0 v0Var = this.f10599n;
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(v0Var);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(viewModelScope, v7.d.f10884a, null, new q0(v0Var, context, vVar, j6, (t6.c) null), 2);
        }
        return p6.x.f8463a;
    }
}
