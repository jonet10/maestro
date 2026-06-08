package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k6 extends y5 {

    /* renamed from: c, reason: collision with root package name */
    public int[] f6266c;

    /* renamed from: d, reason: collision with root package name */
    public int f6267d;

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f6266c = new int[(int) j];
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f6266c, 0, this.f6267d);
        long j = this.f6267d;
        m5 m5Var = this.f6205a;
        m5Var.c(j);
        if (!this.f6431b) {
            while (i < this.f6267d) {
                m5Var.accept(this.f6266c[i]);
                i++;
            }
        } else {
            while (i < this.f6267d && !m5Var.e()) {
                m5Var.accept(this.f6266c[i]);
                i++;
            }
        }
        m5Var.end();
        this.f6266c = null;
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        int[] iArr = this.f6266c;
        int i6 = this.f6267d;
        this.f6267d = i6 + 1;
        iArr[i6] = i;
    }
}
