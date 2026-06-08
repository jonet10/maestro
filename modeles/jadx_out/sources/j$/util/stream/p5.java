package j$.util.stream;

import androidx.core.location.LocationRequestCompat;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p5 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public long f6325b;

    /* renamed from: c, reason: collision with root package name */
    public long f6326c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q5 f6327d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(q5 q5Var, m5 m5Var) {
        super(m5Var);
        this.f6327d = q5Var;
        this.f6325b = q5Var.f6333l;
        long j = q5Var.f6334m;
        this.f6326c = j < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j) {
        this.f6205a.c(w3.x(j, this.f6327d.f6333l, this.f6326c));
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        long j = this.f6325b;
        if (j == 0) {
            long j6 = this.f6326c;
            if (j6 > 0) {
                this.f6326c = j6 - 1;
                this.f6205a.accept(i);
                return;
            }
            return;
        }
        this.f6325b = j - 1;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        return this.f6326c == 0 || this.f6205a.e();
    }
}
