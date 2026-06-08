package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d6 extends z5 {

    /* renamed from: c, reason: collision with root package name */
    public t6 f6175c;

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j) {
        t6 t6Var;
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return;
        }
        if (j <= 0) {
            t6Var = new t6();
        } else {
            t6Var = new t6((int) j);
        }
        this.f6175c = t6Var;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void end() {
        long[] jArr = (long[]) this.f6175c.b();
        Arrays.sort(jArr);
        long length = jArr.length;
        m5 m5Var = this.f6214a;
        m5Var.c(length);
        int i = 0;
        if (!this.f6441b) {
            int length2 = jArr.length;
            while (i < length2) {
                m5Var.accept(jArr[i]);
                i++;
            }
        } else {
            int length3 = jArr.length;
            while (i < length3) {
                long j = jArr[i];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(j);
                i++;
            }
        }
        m5Var.end();
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        this.f6175c.accept(j);
    }
}
