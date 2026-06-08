package m8;

import java.io.Closeable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f7692a;

    /* renamed from: b, reason: collision with root package name */
    public final y f7693b;

    /* renamed from: l, reason: collision with root package name */
    public final int f7694l;

    /* renamed from: m, reason: collision with root package name */
    public final String f7695m;

    /* renamed from: n, reason: collision with root package name */
    public final r f7696n;

    /* renamed from: o, reason: collision with root package name */
    public final s f7697o;

    /* renamed from: p, reason: collision with root package name */
    public final e0 f7698p;

    /* renamed from: q, reason: collision with root package name */
    public final c0 f7699q;

    /* renamed from: r, reason: collision with root package name */
    public final c0 f7700r;

    /* renamed from: s, reason: collision with root package name */
    public final c0 f7701s;

    /* renamed from: t, reason: collision with root package name */
    public final long f7702t;

    /* renamed from: u, reason: collision with root package name */
    public final long f7703u;
    public volatile i v;

    public c0(b0 b0Var) {
        this.f7692a = b0Var.f7683a;
        this.f7693b = b0Var.f7684b;
        this.f7694l = b0Var.f7685c;
        this.f7695m = b0Var.f7686d;
        this.f7696n = b0Var.f7687e;
        g5.f fVar = b0Var.f;
        fVar.getClass();
        this.f7697o = new s(fVar);
        this.f7698p = b0Var.g;
        this.f7699q = b0Var.h;
        this.f7700r = b0Var.i;
        this.f7701s = b0Var.j;
        this.f7702t = b0Var.f7688k;
        this.f7703u = b0Var.f7689l;
    }

    public final i b() {
        i iVar = this.v;
        if (iVar != null) {
            return iVar;
        }
        i a8 = i.a(this.f7697o);
        this.v = a8;
        return a8;
    }

    public final String c(String str) {
        String a8 = this.f7697o.a(str);
        if (a8 != null) {
            return a8;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e0 e0Var = this.f7698p;
        if (e0Var != null) {
            e0Var.close();
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("response is not eligible for a body and must not be closed");
        }
    }

    public final b0 d() {
        b0 b0Var = new b0();
        b0Var.f7683a = this.f7692a;
        b0Var.f7684b = this.f7693b;
        b0Var.f7685c = this.f7694l;
        b0Var.f7686d = this.f7695m;
        b0Var.f7687e = this.f7696n;
        b0Var.f = this.f7697o.c();
        b0Var.g = this.f7698p;
        b0Var.h = this.f7699q;
        b0Var.i = this.f7700r;
        b0Var.j = this.f7701s;
        b0Var.f7688k = this.f7702t;
        b0Var.f7689l = this.f7703u;
        return b0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.f7693b + ", code=" + this.f7694l + ", message=" + this.f7695m + ", url=" + this.f7692a.f7673a + '}';
    }
}
