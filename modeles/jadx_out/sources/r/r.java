package r;

import android.content.Context;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static volatile l f8848e;

    /* renamed from: a, reason: collision with root package name */
    public final q2.e f8849a;

    /* renamed from: b, reason: collision with root package name */
    public final q2.e f8850b;

    /* renamed from: c, reason: collision with root package name */
    public final w.a f8851c;

    /* renamed from: d, reason: collision with root package name */
    public final x.g f8852d;

    public r(q2.e eVar, q2.e eVar2, w.a aVar, x.g gVar, s sVar) {
        this.f8849a = eVar;
        this.f8850b = eVar2;
        this.f8851c = aVar;
        this.f8852d = gVar;
        ((Executor) sVar.f11755b).execute(new a2.s(sVar, 17));
    }

    public static r a() {
        l lVar = f8848e;
        if (lVar != null) {
            return (r) lVar.f8840o.get();
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Not initialized!");
        return null;
    }

    public static void b(Context context) {
        if (f8848e == null) {
            synchronized (r.class) {
                try {
                    if (f8848e == null) {
                        k kVar = new k();
                        context.getClass();
                        kVar.f8834a = context;
                        f8848e = kVar.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final q c(p.a aVar) {
        byte[] bytes;
        Set unmodifiableSet = aVar instanceof p.a ? DesugarCollections.unmodifiableSet(p.a.f8391d) : Collections.singleton(new o.c("proto"));
        aVar.getClass();
        String str = aVar.f8393a;
        String str2 = aVar.f8394b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        return new q(unmodifiableSet, new j("cct", bytes, o.d.f8126a), this);
    }
}
