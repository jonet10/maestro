package j$.util.stream;

import androidx.core.location.LocationRequestCompat;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class t5 extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public long f6366b;

    /* renamed from: c, reason: collision with root package name */
    public long f6367c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u5 f6368d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t5(u5 u5Var, m5 m5Var) {
        super(m5Var);
        this.f6368d = u5Var;
        this.f6366b = u5Var.f6380l;
        long j = u5Var.f6381m;
        this.f6367c = j < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j) {
        this.f6195a.c(w3.x(j, this.f6368d.f6380l, this.f6367c));
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        long j = this.f6366b;
        if (j == 0) {
            long j6 = this.f6367c;
            if (j6 > 0) {
                this.f6367c = j6 - 1;
                this.f6195a.accept(d10);
                return;
            }
            return;
        }
        this.f6366b = j - 1;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final boolean e() {
        return this.f6367c == 0 || this.f6195a.e();
    }
}
