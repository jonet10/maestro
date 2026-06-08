package c4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ca extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f1474a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f1475b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f1476c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f1477d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1478e;
    public final r7.o0 f;
    public final r7.o0 g;
    public final r7.o0 h;
    public final r7.o0 i;
    public final r7.o0 j;

    public ca() {
        j5.q qVar = j5.q.f6706a;
        r7.o0 b7 = r7.k0.b(qVar);
        this.f1474a = b7;
        this.f1475b = b7;
        r7.o0 b10 = r7.k0.b(qVar);
        this.f1476c = b10;
        this.f1477d = b10;
        this.f = r7.k0.b(ba.f1426a);
        Boolean bool = Boolean.TRUE;
        this.g = r7.k0.b(bool);
        this.h = r7.k0.b("");
        this.i = r7.k0.b(bool);
        this.j = r7.k0.b("");
    }

    public final void a(Context context, int i, String str) {
        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(context, this, str, i, (t6.c) null), 2);
    }
}
