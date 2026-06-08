package j1;

import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k implements f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6542a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final int f6543b;

    /* renamed from: l, reason: collision with root package name */
    public final p f6544l;

    /* renamed from: m, reason: collision with root package name */
    public int f6545m;

    /* renamed from: n, reason: collision with root package name */
    public int f6546n;

    /* renamed from: o, reason: collision with root package name */
    public int f6547o;

    /* renamed from: p, reason: collision with root package name */
    public Exception f6548p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6549q;

    public k(int i, p pVar) {
        this.f6543b = i;
        this.f6544l = pVar;
    }

    public final void a() {
        int i = this.f6545m;
        int i6 = this.f6546n;
        int i10 = i + i6 + this.f6547o;
        int i11 = this.f6543b;
        if (i10 == i11) {
            Exception exc = this.f6548p;
            p pVar = this.f6544l;
            if (exc == null) {
                if (this.f6549q) {
                    pVar.n();
                    return;
                } else {
                    pVar.k(null);
                    return;
                }
            }
            int length = String.valueOf(i6).length();
            StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + length + 8 + 24);
            sb.append(i6);
            sb.append(" out of ");
            sb.append(i11);
            sb.append(" underlying tasks failed");
            pVar.m(new ExecutionException(sb.toString(), this.f6548p));
        }
    }

    @Override // j1.f
    public final void c(Object obj) {
        synchronized (this.f6542a) {
            this.f6545m++;
            a();
        }
    }

    @Override // j1.c
    public final void f() {
        synchronized (this.f6542a) {
            this.f6547o++;
            this.f6549q = true;
            a();
        }
    }

    @Override // j1.e
    public final void i(Exception exc) {
        synchronized (this.f6542a) {
            this.f6546n++;
            this.f6548p = exc;
            a();
        }
    }
}
