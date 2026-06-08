package u5;

import android.util.Log;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import j$.time.ZonedDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m {
    public final Vector A;
    public final Vector B;
    public Vector C;
    public final Vector D;
    public Vector E;
    public Vector F;
    public h G;

    /* renamed from: b, reason: collision with root package name */
    public long f10738b;

    /* renamed from: c, reason: collision with root package name */
    public long f10739c;

    /* renamed from: d, reason: collision with root package name */
    public ZonedDateTime f10740d;
    public boolean f;
    public boolean g;
    public int j;

    /* renamed from: o, reason: collision with root package name */
    public int f10746o;

    /* renamed from: p, reason: collision with root package name */
    public int f10747p;

    /* renamed from: z, reason: collision with root package name */
    public Vector f10756z;

    /* renamed from: a, reason: collision with root package name */
    public h8.c f10737a = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10741e = true;
    public String h = "AA";
    public int i = 2;

    /* renamed from: k, reason: collision with root package name */
    public int f10742k = 2;

    /* renamed from: l, reason: collision with root package name */
    public String f10743l = "EN";

    /* renamed from: m, reason: collision with root package name */
    public int f10744m = 10;

    /* renamed from: n, reason: collision with root package name */
    public int f10745n = 2021;

    /* renamed from: q, reason: collision with root package name */
    public Vector f10748q = new Vector(null, 1, null);

    /* renamed from: r, reason: collision with root package name */
    public Vector f10749r = new Vector(null, 1, null);

    /* renamed from: s, reason: collision with root package name */
    public Vector f10750s = new Vector(null, 1, null);

    /* renamed from: t, reason: collision with root package name */
    public final Vector f10751t = new Vector(null, 1, null);

    /* renamed from: u, reason: collision with root package name */
    public final Vector f10752u = new Vector(null, 1, null);
    public Vector v = new Vector(null, 1, null);

    /* renamed from: w, reason: collision with root package name */
    public Vector f10753w = new Vector(null, 1, null);

    /* renamed from: x, reason: collision with root package name */
    public Vector f10754x = new Vector(null, 1, null);

    /* renamed from: y, reason: collision with root package name */
    public Vector f10755y = new Vector(null, 1, null);

    public m() {
        new LinkedHashSet();
        this.f10756z = new Vector(null, 1, null);
        this.A = new Vector(null, 1, null);
        this.B = new Vector(null, 1, null);
        this.C = new Vector(null, 1, null);
        this.D = new Vector(null, 1, null);
        this.E = new Vector(null, 1, null);
        this.F = new Vector(null, 1, null);
        this.G = new h(this.f10737a);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    public static boolean b(h8.i iVar) {
        ?? r02 = m9.c.e().f7239n.g;
        Set set = iVar.f5474d;
        if (set != null && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r02.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.List] */
    public static final boolean c(m mVar, h8.i iVar) {
        ?? r12 = m9.c.e().f7239n.i;
        Set set = iVar.f5475e;
        if (set != null && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r12.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str) {
        str.getClass();
        String[] iSOCountries = Locale.getISOCountries();
        iSOCountries.getClass();
        Locale locale = Locale.getDefault();
        locale.getClass();
        String upperCase = str.toUpperCase(locale);
        upperCase.getClass();
        if (q6.j.j0(iSOCountries, upperCase) >= 0) {
            Locale locale2 = Locale.getDefault();
            locale2.getClass();
            String upperCase2 = str.toUpperCase(locale2);
            upperCase2.getClass();
            this.h = upperCase2;
            return;
        }
        n nVar = new n("publisherCountryCode", str);
        ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
        if (callback != null) {
            callback.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
        }
        String message = nVar.getMessage();
        if (message == null) {
            message = "";
        }
        Object obj = Boolean.TRUE;
        if (obj.equals(obj)) {
            Log.e("f.u", message, nVar);
        }
    }

    public final int d() {
        h8.c cVar = this.f10737a;
        Integer num = cVar == null ? null : cVar.f5461c;
        return num == null ? this.f10742k : num.intValue();
    }

    public final void e() {
        this.B.setAllOwnedItems();
        this.f10756z.forEach(new l(this, 1));
        this.f10749r.setAllOwnedItems();
        this.f10750s.setAllOwnedItems();
        this.f10748q.setAllOwnedItems();
        this.C.forEach(new l(this, 2));
        this.A.forEach(new l(this, 0));
        this.D.setAllOwnedItems();
        this.v.setAllOwnedItems();
        this.f10753w.setAllOwnedItems();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && kotlin.jvm.internal.l.a(this.f10737a, ((m) obj).f10737a);
    }

    public final void f() {
        this.f10756z.forEach(new l(this, 4));
        this.C.forEach(new l(this, 2));
        Vector vector = this.B;
        vector.unset(vector.getKeys());
        this.A.unsetAllOwnedItems();
        this.f10748q.unsetAllOwnedItems();
        this.f10749r.unsetAllOwnedItems();
        this.f10750s.setAllOwnedItems();
        this.C.forEach(new l(this, 3));
        this.v.unsetAllOwnedItems();
        this.f10753w.unsetAllOwnedItems();
    }

    public final int hashCode() {
        h8.c cVar = this.f10737a;
        if (cVar == null) {
            return 0;
        }
        return cVar.hashCode();
    }

    public final String toString() {
        return "TCModel(gvl=" + this.f10737a + ')';
    }
}
