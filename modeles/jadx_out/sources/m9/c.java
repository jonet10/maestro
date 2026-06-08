package m9;

import android.app.Application;
import android.support.v4.media.g;
import androidx.core.os.ConfigurationCompat;
import com.inmobi.cmp.data.model.ChoiceStyle;
import h9.d;
import j9.u;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.l;
import l8.n;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static Application f7857a;

    /* renamed from: c, reason: collision with root package name */
    public static h9.c f7859c;

    /* renamed from: d, reason: collision with root package name */
    public static d f7860d;

    /* renamed from: e, reason: collision with root package name */
    public static m f7861e;
    public static n f;
    public static k6.c g;
    public static j8.a h;
    public static l3.a i;

    /* renamed from: k, reason: collision with root package name */
    public static g f7862k;

    /* renamed from: l, reason: collision with root package name */
    public static u f7863l;

    /* renamed from: b, reason: collision with root package name */
    public static ChoiceStyle f7858b = new ChoiceStyle();
    public static final p6.m j = new p6.m(b.f7845m);

    /* renamed from: m, reason: collision with root package name */
    public static final p6.m f7864m = new p6.m(b.f7850r);

    /* renamed from: n, reason: collision with root package name */
    public static final p6.m f7865n = new p6.m(b.f7844l);

    /* renamed from: o, reason: collision with root package name */
    public static final p6.m f7866o = new p6.m(b.f7843b);

    /* renamed from: p, reason: collision with root package name */
    public static final p6.m f7867p = new p6.m(b.f7847o);

    /* renamed from: q, reason: collision with root package name */
    public static final p6.m f7868q = new p6.m(b.f7852t);

    /* renamed from: r, reason: collision with root package name */
    public static final p6.m f7869r = new p6.m(b.f7855x);

    /* renamed from: s, reason: collision with root package name */
    public static final p6.m f7870s = new p6.m(b.f7849q);

    /* renamed from: t, reason: collision with root package name */
    public static final p6.m f7871t = new p6.m(b.f7848p);

    /* renamed from: u, reason: collision with root package name */
    public static final p6.m f7872u = new p6.m(b.f7846n);
    public static final p6.m v = new p6.m(b.v);

    /* renamed from: w, reason: collision with root package name */
    public static final p6.m f7873w = new p6.m(b.f7851s);

    /* renamed from: x, reason: collision with root package name */
    public static final p6.m f7874x = new p6.m(b.f7853u);

    /* renamed from: y, reason: collision with root package name */
    public static final p6.m f7875y = new p6.m(b.f7854w);

    public static Locale a() {
        if (f7857a == null) {
            Locale locale = Locale.US;
            locale.getClass();
            return locale;
        }
        Locale locale2 = ConfigurationCompat.getLocales(b().getResources().getConfiguration()).get(0);
        if (locale2 == null) {
            locale2 = Locale.US;
        }
        locale2.getClass();
        return locale2;
    }

    public static Application b() {
        Application application = f7857a;
        if (application != null) {
            return application;
        }
        l.i("application");
        throw null;
    }

    public static l3.a c() {
        l3.a aVar = i;
        if (aVar != null) {
            return aVar;
        }
        l3.a aVar2 = new l3.a();
        aVar2.f7091a = new HashMap();
        aVar2.f7093c = false;
        aVar2.f7094d = true;
        i = aVar2;
        return aVar2;
    }

    public static j8.a d() {
        j8.a aVar = h;
        return aVar == null ? new j8.a(15, null, null) : aVar;
    }

    public static n e() {
        n nVar = f;
        return nVar == null ? new n(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 4194303) : nVar;
    }

    public static m f() {
        m mVar = f7861e;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m();
        f7861e = mVar2;
        return mVar2;
    }
}
