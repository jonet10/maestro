package e1;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f3870a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3871b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3872c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3873d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g1 f3874e;

    public d1(g1 g1Var, String str, boolean z9) {
        this.f3874e = g1Var;
        k0.y.d(str);
        this.f3870a = str;
        this.f3871b = z9;
    }

    public final boolean a() {
        if (!this.f3872c) {
            this.f3872c = true;
            this.f3873d = this.f3874e.k().getBoolean(this.f3870a, this.f3871b);
        }
        return this.f3873d;
    }

    public final void b(boolean z9) {
        SharedPreferences.Editor edit = this.f3874e.k().edit();
        edit.putBoolean(this.f3870a, z9);
        edit.apply();
        this.f3873d = z9;
    }
}
