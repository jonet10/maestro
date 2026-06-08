package e1;

import android.text.TextUtils;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 {
    public Long A;
    public long B;
    public String C;
    public int D;
    public int E;
    public long F;
    public String G;
    public byte[] H;
    public int I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public String P;
    public boolean Q;
    public long R;
    public long S;

    /* renamed from: a, reason: collision with root package name */
    public final t1 f3784a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3785b;

    /* renamed from: c, reason: collision with root package name */
    public String f3786c;

    /* renamed from: d, reason: collision with root package name */
    public String f3787d;

    /* renamed from: e, reason: collision with root package name */
    public String f3788e;
    public String f;
    public long g;
    public long h;
    public long i;
    public String j;

    /* renamed from: k, reason: collision with root package name */
    public long f3789k;

    /* renamed from: l, reason: collision with root package name */
    public String f3790l;

    /* renamed from: m, reason: collision with root package name */
    public long f3791m;

    /* renamed from: n, reason: collision with root package name */
    public long f3792n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3793o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3794p;

    /* renamed from: q, reason: collision with root package name */
    public Boolean f3795q;

    /* renamed from: r, reason: collision with root package name */
    public long f3796r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f3797s;

    /* renamed from: t, reason: collision with root package name */
    public String f3798t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3799u;
    public long v;

    /* renamed from: w, reason: collision with root package name */
    public long f3800w;

    /* renamed from: x, reason: collision with root package name */
    public int f3801x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3802y;

    /* renamed from: z, reason: collision with root package name */
    public Long f3803z;

    public b1(t1 t1Var, String str) {
        k0.y.g(t1Var);
        k0.y.d(str);
        this.f3784a = t1Var;
        this.f3785b = str;
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.g();
    }

    public final void A(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3800w != j;
        this.f3800w = j;
    }

    public final void B(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.B != j;
        this.B = j;
    }

    public final String C() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.C;
    }

    public final String D() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3785b;
    }

    public final String E() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3786c;
    }

    public final void F(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.f3786c, str);
        this.f3786c = str;
    }

    public final String G() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3787d;
    }

    public final void H(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.Q |= true ^ Objects.equals(this.f3787d, str);
        this.f3787d = str;
    }

    public final void I(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.f3788e, str);
        this.f3788e = str;
    }

    public final String J() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f;
    }

    public final void K(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.f, str);
        this.f = str;
    }

    public final void L(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.h != j;
        this.h = j;
    }

    public final void M(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.i != j;
        this.i = j;
    }

    public final String N() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.j;
    }

    public final void O(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.j, str);
        this.j = str;
    }

    public final long P() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3789k;
    }

    public final void Q(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3789k != j;
        this.f3789k = j;
    }

    public final void R(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.f3790l, str);
        this.f3790l = str;
    }

    public final void S(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3791m != j;
        this.f3791m = j;
    }

    public final void a(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3792n != j;
        this.f3792n = j;
    }

    public final long b() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3796r;
    }

    public final void c(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3796r != j;
        this.f3796r = j;
    }

    public final void d(boolean z9) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.f3793o != z9;
        this.f3793o = z9;
    }

    public final void e(long j) {
        k0.y.b(j >= 0);
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.g != j;
        this.g = j;
    }

    public final void f(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.R != j;
        this.R = j;
    }

    public final void g(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.S != j;
        this.S = j;
    }

    public final void h(long j) {
        t1 t1Var = this.f3784a;
        q1 q1Var = t1Var.f4265p;
        w0 w0Var = t1Var.f4264o;
        t1.m(q1Var);
        q1Var.g();
        long j6 = this.g + j;
        String str = this.f3785b;
        if (j6 > 2147483647L) {
            t1.m(w0Var);
            w0Var.f4342r.c(w0.o(str), "Bundle index overflow. appId");
            j6 = (-1) + j;
        }
        long j10 = this.F + 1;
        if (j10 > 2147483647L) {
            t1.m(w0Var);
            w0Var.f4342r.c(w0.o(str), "Delivery index overflow. appId");
            j10 = 0;
        }
        this.Q = true;
        this.g = j6;
        this.F = j10;
    }

    public final void i(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.J != j;
        this.J = j;
    }

    public final void j(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.K != j;
        this.K = j;
    }

    public final void k(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.L != j;
        this.L = j;
    }

    public final void l(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.M != j;
        this.M = j;
    }

    public final void m(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.O != j;
        this.O = j;
    }

    public final void n(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.N != j;
        this.N = j;
    }

    public final boolean o() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.Q;
    }

    public final void p(int i) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.D != i;
        this.D = i;
    }

    public final void q(int i) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.E != i;
        this.E = i;
    }

    public final void r(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.F != j;
        this.F = j;
    }

    public final String s() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.G;
    }

    public final int t() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.I;
    }

    public final String u() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        String str = this.P;
        v(null);
        return str;
    }

    public final void v(String str) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= !Objects.equals(this.P, str);
        this.P = str;
    }

    public final Boolean w() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3795q;
    }

    public final void x(List list) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        if (Objects.equals(this.f3797s, list)) {
            return;
        }
        this.Q = true;
        this.f3797s = list != null ? new ArrayList(list) : null;
    }

    public final boolean y() {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        return this.f3799u;
    }

    public final void z(long j) {
        q1 q1Var = this.f3784a.f4265p;
        t1.m(q1Var);
        q1Var.g();
        this.Q |= this.v != j;
        this.v = j;
    }
}
