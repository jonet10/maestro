package u4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.HashMap;
import x4.g2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d2 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f10458a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f10459b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f10460c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f10461d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10462e;
    public boolean f;
    public boolean g;
    public int h;

    public d2() {
        j5.p pVar = j5.p.f6705a;
        r7.o0 b7 = r7.k0.b(pVar);
        this.f10458a = b7;
        this.f10459b = b7;
        r7.o0 b10 = r7.k0.b(pVar);
        this.f10460c = b10;
        this.f10461d = b10;
    }

    public static final p2 a(d2 d2Var, Context context, x4.j jVar) {
        j5.v vVar = new j5.v(context);
        p2 p2Var = new p2(null, null, 7);
        jVar.getClass();
        p2Var.f11329a = jVar;
        int i = jVar.f11224a;
        if (i > 0) {
            if (jVar.f11227m) {
                int i6 = d2Var.h;
                HashMap hashMap = new HashMap();
                hashMap.put("page[limit]", String.valueOf(40));
                hashMap.put("page[offset]", String.valueOf(i6));
                hashMap.putAll(j5.v.g());
                String g = a4.x.g(i, "/eapi/v2/floating-category/", "/data-and-apps-list");
                g2 k5 = vVar.k("https://www.uptodown.app:443".concat(g), hashMap, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, g);
                p2Var = a.a.J(k5, jVar);
            } else {
                int i10 = jVar.f11229o;
                if ((i10 == 0 || i10 == 831) && !jVar.f11228n) {
                    p2Var.f11330b = j5.v.E(vVar.t(i, 40, d2Var.h));
                } else {
                    p2Var = a.a.J(vVar.v(i, 40, d2Var.h), jVar);
                }
            }
        } else if (i == -1) {
            p2Var.f11330b = j5.v.E(vVar.s(40, d2Var.h));
        } else if (i == -2) {
            int i11 = jVar.f11229o;
            int i12 = d2Var.h;
            p2Var.f11330b = j5.v.E(i11 > 0 ? vVar.p(i11, 40, i12) : vVar.m(40, i12));
        } else if (i == -3) {
            int i13 = d2Var.h;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("page[limit]", String.valueOf(40));
            hashMap2.put("page[offset]", String.valueOf(i13));
            hashMap2.putAll(j5.v.g());
            g2 k10 = vVar.k("https://www.uptodown.app:443".concat("/eapi/apps/latest-updates"), hashMap2, ShareTarget.METHOD_GET, false);
            k10.f11206d = vVar.i(k10, "/eapi/apps/latest-updates");
            p2Var.f11330b = j5.v.E(k10);
        }
        d2Var.h = p2Var.f11330b.size() + d2Var.h;
        return p2Var;
    }

    public final String b() {
        r7.o0 o0Var = this.f10458a;
        if (!(o0Var.getValue() instanceof j5.r)) {
            return null;
        }
        Object value = o0Var.getValue();
        value.getClass();
        return ((a2) ((j5.r) value).f6707a).f10423a.f11329a.f11227m ? "floatingCategory" : "leafCategory";
    }

    public final void c(Context context, int i) {
        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b2(context, this, i, null), 2);
    }

    public final void d(Context context, x4.g gVar, String str) {
        gVar.getClass();
        if (gVar.m()) {
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(viewModelScope, v7.d.f10884a, null, new c4.w(this, context, gVar, str, (t6.c) null), 2);
        }
    }
}
