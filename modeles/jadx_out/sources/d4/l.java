package d4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import c4.sc;
import java.util.Calendar;
import o7.a0;
import o7.c0;
import o7.m0;
import r7.k0;
import r7.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f3583a = k0.b(k.f3579a);

    /* renamed from: b, reason: collision with root package name */
    public final o0 f3584b = k0.b(j.f3576a);

    /* renamed from: c, reason: collision with root package name */
    public final o0 f3585c = k0.b(1);

    /* renamed from: d, reason: collision with root package name */
    public final o0 f3586d;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f3587e;
    public final a3.d f;

    public l() {
        o0 b7 = k0.b(j5.p.f6705a);
        this.f3586d = b7;
        this.f3587e = b7;
        this.f = new a3.d(21);
    }

    public static int b(int i, int i6, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i6, i10 - 1, 1);
        int actualMaximum = calendar.getActualMaximum(5);
        return i > actualMaximum ? actualMaximum : i;
    }

    public final void a(Context context) {
        context.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new sc(this, context, (t6.c) null), 2);
    }
}
