package c4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v8 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f2213a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f2214b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f2215c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f2216d;

    /* renamed from: e, reason: collision with root package name */
    public final r7.o0 f2217e;
    public final r7.o0 f;
    public final r7.o0 g;
    public final r7.o0 h;
    public final r7.o0 i;
    public final r7.o0 j;

    /* renamed from: k, reason: collision with root package name */
    public final r7.o0 f2218k;

    /* renamed from: l, reason: collision with root package name */
    public final r7.o0 f2219l;

    /* renamed from: m, reason: collision with root package name */
    public final r7.o0 f2220m;

    /* renamed from: n, reason: collision with root package name */
    public final r7.o0 f2221n;

    /* renamed from: o, reason: collision with root package name */
    public final r7.o0 f2222o;

    /* renamed from: p, reason: collision with root package name */
    public final r7.o0 f2223p;

    /* renamed from: q, reason: collision with root package name */
    public final r7.o0 f2224q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2225r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2226s;

    public v8() {
        j5.p pVar = j5.p.f6705a;
        r7.o0 b7 = r7.k0.b(pVar);
        this.f2213a = b7;
        this.f2214b = b7;
        r7.o0 b10 = r7.k0.b(pVar);
        this.f2215c = b10;
        this.f2216d = b10;
        j5.q qVar = j5.q.f6706a;
        r7.o0 b11 = r7.k0.b(qVar);
        this.f2217e = b11;
        this.f = b11;
        r7.o0 b12 = r7.k0.b(pVar);
        this.g = b12;
        this.h = b12;
        r7.o0 b13 = r7.k0.b(qVar);
        this.i = b13;
        this.j = b13;
        this.f2218k = r7.k0.b("");
        this.f2219l = r7.k0.b("");
        this.f2220m = r7.k0.b(null);
        this.f2221n = r7.k0.b(null);
        this.f2222o = r7.k0.b(null);
        this.f2223p = r7.k0.b(0L);
        this.f2224q = r7.k0.b(null);
        this.f2225r = true;
    }

    public final void a(Context context, int i, String str) {
        if (i == 1) {
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(viewModelScope, v7.d.f10884a, null, new u8(context, str, this, null, 1), 2);
        } else {
            o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(this);
            v7.e eVar2 = o7.m0.f8288a;
            o7.c0.s(viewModelScope2, v7.d.f10884a, null, new u8(context, str, this, null, 0), 2);
        }
    }
}
