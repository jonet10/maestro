package c4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i8 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f1725a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f1726b;

    /* renamed from: c, reason: collision with root package name */
    public final r7.o0 f1727c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.o0 f1728d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1729e;
    public boolean f;
    public int g;

    public i8() {
        r7.o0 b7 = r7.k0.b(j5.p.f6705a);
        this.f1725a = b7;
        this.f1726b = b7;
        r7.o0 b10 = r7.k0.b(Boolean.TRUE);
        this.f1727c = b10;
        this.f1728d = b10;
    }

    public final void a(Context context) {
        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(viewModelScope, v7.d.f10884a, null, new h8(this, context, null, 1), 2);
    }
}
