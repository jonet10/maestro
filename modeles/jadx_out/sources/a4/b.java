package a4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f68a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f69b;

    /* renamed from: c, reason: collision with root package name */
    public final a f70c;

    /* renamed from: d, reason: collision with root package name */
    public final String f71d;

    /* renamed from: e, reason: collision with root package name */
    public final b f72e;
    public boolean f;
    public boolean g;

    public b(g0 g0Var, Object obj, k0 k0Var, String str) {
        this.f68a = g0Var;
        this.f69b = k0Var;
        this.f70c = obj == null ? null : new a(this, obj, g0Var.i);
        this.f71d = str;
        this.f72e = this;
    }

    public void a() {
        this.g = true;
    }

    public abstract void b(Bitmap bitmap, int i);

    public abstract void c(Exception exc);

    public Object d() {
        a aVar = this.f70c;
        if (aVar == null) {
            return null;
        }
        return aVar.get();
    }
}
