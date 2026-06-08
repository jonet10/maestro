package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j6 extends x5 {

    /* renamed from: c, reason: collision with root package name */
    public double[] f6241c;

    /* renamed from: d, reason: collision with root package name */
    public int f6242d;

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f6241c = new double[(int) j];
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f6241c, 0, this.f6242d);
        long j = this.f6242d;
        m5 m5Var = this.f6195a;
        m5Var.c(j);
        if (!this.f6425b) {
            while (i < this.f6242d) {
                m5Var.accept(this.f6241c[i]);
                i++;
            }
        } else {
            while (i < this.f6242d && !m5Var.e()) {
                m5Var.accept(this.f6241c[i]);
                i++;
            }
        }
        m5Var.end();
        this.f6241c = null;
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        double[] dArr = this.f6241c;
        int i = this.f6242d;
        this.f6242d = i + 1;
        dArr[i] = d10;
    }
}
