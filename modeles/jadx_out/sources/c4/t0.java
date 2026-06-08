package c4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f2105a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f2106b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f2107c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f2108d;

    /* renamed from: e, reason: collision with root package name */
    public int f2109e;
    public boolean f;
    public boolean g;

    public t0() {
        j5.q qVar = j5.q.f6706a;
        r7.o0 b7 = r7.k0.b(qVar);
        this.f2105a = b7;
        this.f2106b = b7;
        r7.o0 b10 = r7.k0.b(qVar);
        this.f2107c = b10;
        this.f2108d = b10;
        this.f = true;
    }

    public final void a(Context context) {
        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.a(this, context, null, 5), 2);
    }
}
