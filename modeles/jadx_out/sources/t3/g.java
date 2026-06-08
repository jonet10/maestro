package t3;

import androidx.lifecycle.l;
import java.util.HashMap;
import java.util.List;
import o3.h;
import o3.i;
import r3.x;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends a {
    @Override // t3.a
    public final void b(String str, r3.b bVar) {
        r3.c cVar = (r3.c) bVar;
        if (str == null || str.length() != 4) {
            throw new q3.a(l.w("Invalid uspv1 string: '", str, "'"));
        }
        try {
            List list = x.f8899a;
            cVar.get("Version").setValue(Integer.valueOf(Integer.parseInt(str.substring(0, 1))));
            cVar.get("Notice").setValue(Character.valueOf(str.charAt(1)));
            cVar.get("OptOutSale").setValue(Character.valueOf(str.charAt(2)));
            cVar.get("LspaCovered").setValue(Character.valueOf(str.charAt(3)));
        } catch (Exception e10) {
            o.m(l.w("Unable to decode UspV1CoreSegment '", str, "'"), e10);
        }
    }

    @Override // t3.a
    public final String d(r3.b bVar) {
        r3.c cVar = (r3.c) bVar;
        StringBuilder sb = new StringBuilder("");
        List list = x.f8899a;
        sb.append(cVar.get("Version").getValue());
        StringBuilder t9 = a4.x.t(sb.toString());
        t9.append(cVar.get("Notice").getValue());
        StringBuilder t10 = a4.x.t(t9.toString());
        t10.append(cVar.get("OptOutSale").getValue());
        StringBuilder t11 = a4.x.t(t10.toString());
        t11.append(cVar.get("LspaCovered").getValue());
        return t11.toString();
    }

    @Override // t3.a
    public final r3.b f() {
        r3.c cVar = new r3.c();
        HashMap hashMap = new HashMap();
        cVar.f8859a = hashMap;
        List list = x.f8899a;
        h hVar = new h();
        hVar.f8160c = null;
        hVar.f8159b = new i(0);
        hVar.setValue(1);
        hashMap.put("Version", hVar);
        hashMap.put("Notice", new h(new e(22)));
        hashMap.put("OptOutSale", new h(new e(23)));
        hashMap.put("LspaCovered", new h(new e(24)));
        return cVar;
    }
}
