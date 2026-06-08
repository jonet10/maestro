package e1;

import android.os.Looper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f4 extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public a4.c0 f3972l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3973m;

    /* renamed from: n, reason: collision with root package name */
    public final a3.d f3974n;

    /* renamed from: o, reason: collision with root package name */
    public final e4 f3975o;

    /* renamed from: p, reason: collision with root package name */
    public final android.support.v4.media.g f3976p;

    public f4(t1 t1Var) {
        super(t1Var);
        this.f3973m = true;
        this.f3974n = new a3.d(this, 25);
        this.f3975o = new e4(this);
        this.f3976p = new android.support.v4.media.g(this);
    }

    @Override // e1.h0
    public final boolean j() {
        return false;
    }

    public final void k() {
        g();
        if (this.f3972l == null) {
            this.f3972l = new a4.c0(Looper.getMainLooper(), 3);
        }
    }
}
