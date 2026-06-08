package j$.util.stream;

import androidx.core.location.LocationRequestCompat;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class n5 extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public long f6296b;

    /* renamed from: c, reason: collision with root package name */
    public long f6297c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o5 f6298d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(o5 o5Var, m5 m5Var) {
        super(m5Var);
        this.f6298d = o5Var;
        this.f6296b = o5Var.f6314l;
        long j = o5Var.f6315m;
        this.f6297c = j < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j) {
        this.f6224a.c(w3.x(j, this.f6298d.f6314l, this.f6297c));
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        long j = this.f6296b;
        if (j == 0) {
            long j6 = this.f6297c;
            if (j6 > 0) {
                this.f6297c = j6 - 1;
                this.f6224a.n((m5) obj);
                return;
            }
            return;
        }
        this.f6296b = j - 1;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final boolean e() {
        return this.f6297c == 0 || this.f6224a.e();
    }
}
