package j$.util.stream;

import androidx.core.location.LocationRequestCompat;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r5 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public long f6338b;

    /* renamed from: c, reason: collision with root package name */
    public long f6339c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s5 f6340d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r5(s5 s5Var, m5 m5Var) {
        super(m5Var);
        this.f6340d = s5Var;
        this.f6338b = s5Var.f6353l;
        long j = s5Var.f6354m;
        this.f6339c = j < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j) {
        this.f6214a.c(w3.x(j, this.f6340d.f6353l, this.f6339c));
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        long j6 = this.f6338b;
        if (j6 == 0) {
            long j10 = this.f6339c;
            if (j10 > 0) {
                this.f6339c = j10 - 1;
                this.f6214a.accept(j);
                return;
            }
            return;
        }
        this.f6338b = j6 - 1;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final boolean e() {
        return this.f6339c == 0 || this.f6214a.e();
    }
}
