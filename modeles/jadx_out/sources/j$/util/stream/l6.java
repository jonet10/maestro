package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l6 extends z5 {

    /* renamed from: c, reason: collision with root package name */
    public long[] f6280c;

    /* renamed from: d, reason: collision with root package name */
    public int f6281d;

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f6280c = new long[(int) j];
        }
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f6280c, 0, this.f6281d);
        long j = this.f6281d;
        m5 m5Var = this.f6214a;
        m5Var.c(j);
        if (!this.f6441b) {
            while (i < this.f6281d) {
                m5Var.accept(this.f6280c[i]);
                i++;
            }
        } else {
            while (i < this.f6281d && !m5Var.e()) {
                m5Var.accept(this.f6280c[i]);
                i++;
            }
        }
        m5Var.end();
        this.f6280c = null;
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        long[] jArr = this.f6280c;
        int i = this.f6281d;
        this.f6281d = i + 1;
        jArr[i] = j;
    }
}
