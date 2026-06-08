package e1;

import android.content.SharedPreferences;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f3898a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3899b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3900c;

    /* renamed from: d, reason: collision with root package name */
    public long f3901d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g1 f3902e;

    public e1(g1 g1Var, String str, long j) {
        Objects.requireNonNull(g1Var);
        this.f3902e = g1Var;
        k0.y.d(str);
        this.f3898a = str;
        this.f3899b = j;
    }

    public final long a() {
        if (!this.f3900c) {
            this.f3900c = true;
            this.f3901d = this.f3902e.k().getLong(this.f3898a, this.f3899b);
        }
        return this.f3901d;
    }

    public final void b(long j) {
        SharedPreferences.Editor edit = this.f3902e.k().edit();
        edit.putLong(this.f3898a, j);
        edit.apply();
        this.f3901d = j;
    }
}
