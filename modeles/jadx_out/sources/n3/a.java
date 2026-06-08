package n3;

import a1.b;
import a4.x;
import androidx.lifecycle.l;
import java.util.List;
import o3.g;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7936a = new a();

    public static void a(String str, List list, r3.a aVar) {
        int i = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str2 = (String) list.get(i6);
            if (!aVar.f8858a.containsKey(str2)) {
                throw new q3.a(l.w("Field not found: '", str2, "'"));
            }
            o3.a aVar2 = (o3.a) aVar.f8858a.get(str2);
            try {
                String c9 = aVar2.c(i, str);
                aVar2.a(c9);
                i += c9.length();
            } catch (g e10) {
                if (aVar2.f8148a) {
                    o.m(x.j("Unable to decode ", str2), e10);
                    return;
                }
                return;
            } catch (Exception e11) {
                o.m(x.j("Unable to decode ", str2), e11);
                return;
            }
        }
    }

    public static String b(r3.a aVar, List list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            String str2 = (String) list.get(i);
            if (!aVar.f8858a.containsKey(str2)) {
                throw new b(l.w("Field not found: '", str2, "'"));
            }
            str = str.concat(((o3.a) aVar.f8858a.get(str2)).b());
        }
        return str;
    }
}
