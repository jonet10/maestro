package c4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class vd extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final r7.o0 f2235a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.o0 f2236b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2237c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2238d;

    /* renamed from: e, reason: collision with root package name */
    public int f2239e;

    public vd() {
        r7.o0 b7 = r7.k0.b(j5.p.f6705a);
        this.f2235a = b7;
        this.f2236b = b7;
    }

    public final void a(Context context) {
        this.f2238d = true;
        r7.o0 o0Var = this.f2235a;
        o0Var.getClass();
        o0Var.g(null, j5.p.f6705a);
        o7.c0.s(ViewModelKt.getViewModelScope(this), null, null, new ya(context, this, (t6.c) null, 2), 3);
    }
}
