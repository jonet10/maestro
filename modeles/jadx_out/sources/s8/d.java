package s8;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final b[] f9391a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f9392b;

    static {
        b bVar = new b(b.i, "");
        w8.k kVar = b.f;
        b bVar2 = new b(kVar, ShareTarget.METHOD_GET);
        b bVar3 = new b(kVar, ShareTarget.METHOD_POST);
        w8.k kVar2 = b.g;
        b bVar4 = new b(kVar2, "/");
        b bVar5 = new b(kVar2, "/index.html");
        w8.k kVar3 = b.h;
        b bVar6 = new b(kVar3, "http");
        b bVar7 = new b(kVar3, "https");
        w8.k kVar4 = b.f9382e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(kVar4, "200"), new b(kVar4, "204"), new b(kVar4, "206"), new b(kVar4, "304"), new b(kVar4, "400"), new b(kVar4, "404"), new b(kVar4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b(TypedValues.TransitionType.S_FROM, ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f9391a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(bVarArr.length);
        for (int i = 0; i < bVarArr.length; i++) {
            if (!linkedHashMap.containsKey(bVarArr[i].f9383a)) {
                linkedHashMap.put(bVarArr[i].f9383a, Integer.valueOf(i));
            }
        }
        f9392b = DesugarCollections.unmodifiableMap(linkedHashMap);
    }

    public static void a(w8.k kVar) {
        int f = kVar.f();
        for (int i = 0; i < f; i++) {
            byte k5 = kVar.k(i);
            if (k5 >= 65 && k5 <= 90) {
                com.google.gson.internal.a.n("PROTOCOL_ERROR response malformed: mixed case name: ".concat(kVar.t()));
                return;
            }
        }
    }
}
